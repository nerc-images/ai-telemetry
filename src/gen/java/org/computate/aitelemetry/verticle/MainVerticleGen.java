package org.computate.aitelemetry.verticle;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.tool.SearchTool;
import org.computate.vertx.api.BaseApiServiceInterface;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.openapi.OpenApi3Generator;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.result.base.ComputateBaseResult;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.verticle.EmailVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.loader.FileLocator;
import org.yaml.snakeyaml.Yaml;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.vertx.amqp.AmqpClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxBuilder;
import io.vertx.core.VertxOptions;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBusOptions;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.auth.oauth2.OAuth2Options;
import io.vertx.ext.auth.oauth2.Oauth2Credentials;
import io.vertx.ext.auth.oauth2.authorization.KeycloakAuthorization;
import io.vertx.ext.auth.oauth2.providers.OpenIDConnectAuth;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.healthchecks.HealthCheckHandler;
import io.vertx.ext.healthchecks.Status;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.FileSystemAccess;
import io.vertx.ext.web.handler.OAuth2AuthHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.openapi.RouterBuilder;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.ext.web.sstore.ClusteredSessionStore;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.kafka.client.consumer.KafkaConsumer;
import io.vertx.mqtt.MqttClient;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgBuilder;
import io.vertx.spi.cluster.zookeeper.ZookeeperClusterManager;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import io.vertx.sqlclient.Transaction;
import io.vertx.sqlclient.Tuple;
import io.vertx.tracing.opentelemetry.OpenTelemetryTracingFactory;
import org.computate.aitelemetry.config.ConfigKeys;
import org.computate.aitelemetry.request.SiteRequest;
import org.computate.aitelemetry.user.SiteUser;
import org.computate.aitelemetry.user.SiteUserEnUSGenApiService;
import org.computate.aitelemetry.user.SiteUserEnUSApiServiceImpl;
import org.computate.aitelemetry.result.BaseResult;
import org.computate.aitelemetry.timezone.TimeZoneEnUSGenApiService;
import org.computate.aitelemetry.timezone.TimeZoneEnUSApiServiceImpl;
import org.computate.aitelemetry.timezone.TimeZone;
import org.computate.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperEnUSGenApiService;
import org.computate.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperEnUSApiServiceImpl;
import org.computate.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloper;
import org.computate.aitelemetry.page.SitePageEnUSGenApiService;
import org.computate.aitelemetry.page.SitePageEnUSApiServiceImpl;
import org.computate.aitelemetry.page.SitePage;
import org.computate.aitelemetry.model.MapModelEnUSGenApiService;
import org.computate.aitelemetry.model.MapModelEnUSApiServiceImpl;
import org.computate.aitelemetry.model.MapModel;
import org.computate.aitelemetry.model.tenant.TenantEnUSGenApiService;
import org.computate.aitelemetry.model.tenant.TenantEnUSApiServiceImpl;
import org.computate.aitelemetry.model.tenant.Tenant;
import org.computate.aitelemetry.model.hub.HubEnUSGenApiService;
import org.computate.aitelemetry.model.hub.HubEnUSApiServiceImpl;
import org.computate.aitelemetry.model.hub.Hub;
import org.computate.aitelemetry.model.cluster.ClusterEnUSGenApiService;
import org.computate.aitelemetry.model.cluster.ClusterEnUSApiServiceImpl;
import org.computate.aitelemetry.model.cluster.Cluster;
import org.computate.aitelemetry.model.node.AiNodeEnUSGenApiService;
import org.computate.aitelemetry.model.node.AiNodeEnUSApiServiceImpl;
import org.computate.aitelemetry.model.node.AiNode;
import org.computate.aitelemetry.model.gpudevice.GpuDeviceEnUSGenApiService;
import org.computate.aitelemetry.model.gpudevice.GpuDeviceEnUSApiServiceImpl;
import org.computate.aitelemetry.model.gpudevice.GpuDevice;
import org.computate.aitelemetry.model.project.ProjectEnUSGenApiService;
import org.computate.aitelemetry.model.project.ProjectEnUSApiServiceImpl;
import org.computate.aitelemetry.model.project.Project;
import org.computate.aitelemetry.model.virtualmachine.VirtualMachineEnUSGenApiService;
import org.computate.aitelemetry.model.virtualmachine.VirtualMachineEnUSApiServiceImpl;
import org.computate.aitelemetry.model.virtualmachine.VirtualMachine;
import org.computate.aitelemetry.model.clusterrequest.ClusterRequestEnUSGenApiService;
import org.computate.aitelemetry.model.clusterrequest.ClusterRequestEnUSApiServiceImpl;
import org.computate.aitelemetry.model.clusterrequest.ClusterRequest;
import org.computate.aitelemetry.model.clusterorder.ClusterOrderEnUSGenApiService;
import org.computate.aitelemetry.model.clusterorder.ClusterOrderEnUSApiServiceImpl;
import org.computate.aitelemetry.model.clusterorder.ClusterOrder;
import org.computate.aitelemetry.model.clustertemplate.ClusterTemplateEnUSGenApiService;
import org.computate.aitelemetry.model.clustertemplate.ClusterTemplateEnUSApiServiceImpl;
import org.computate.aitelemetry.model.clustertemplate.ClusterTemplate;
import org.computate.aitelemetry.model.managedcluster.ManagedClusterEnUSGenApiService;
import org.computate.aitelemetry.model.managedcluster.ManagedClusterEnUSApiServiceImpl;
import org.computate.aitelemetry.model.managedcluster.ManagedCluster;
import org.computate.aitelemetry.model.baremetalorder.BareMetalOrderEnUSGenApiService;
import org.computate.aitelemetry.model.baremetalorder.BareMetalOrderEnUSApiServiceImpl;
import org.computate.aitelemetry.model.baremetalorder.BareMetalOrder;
import org.computate.aitelemetry.model.baremetalresourceclass.BareMetalResourceClassEnUSGenApiService;
import org.computate.aitelemetry.model.baremetalresourceclass.BareMetalResourceClassEnUSApiServiceImpl;
import org.computate.aitelemetry.model.baremetalresourceclass.BareMetalResourceClass;
import org.computate.aitelemetry.model.baremetalnetwork.BareMetalNetworkEnUSGenApiService;
import org.computate.aitelemetry.model.baremetalnetwork.BareMetalNetworkEnUSApiServiceImpl;
import org.computate.aitelemetry.model.baremetalnetwork.BareMetalNetwork;
import org.computate.aitelemetry.model.baremetalnode.BareMetalNodeEnUSGenApiService;
import org.computate.aitelemetry.model.baremetalnode.BareMetalNodeEnUSApiServiceImpl;
import org.computate.aitelemetry.model.baremetalnode.BareMetalNode;
import org.computate.aitelemetry.request.SiteRequest;
import io.vertx.core.AbstractVerticle;
import org.computate.aitelemetry.model.BaseModel;
import org.computate.vertx.api.ApiRequest;
import org.computate.aitelemetry.config.ConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.computate.search.serialize.ComputateBigDecimalDeserializer;
import java.math.MathContext;
import org.apache.commons.lang3.math.NumberUtils;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import java.util.Map;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import org.computate.vertx.search.list.SearchList;
import org.computate.search.tool.SearchTool;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li><p>
 *   You can add a class comment <kbd><b>Api: true</b></kbd> if you wish to GET, POST, PATCH or PUT these  objects in a RESTful API. 
 * </p>
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class MainVerticleGen into the class MainVerticle. 
 * </li>
 * <h3>About the MainVerticle class and it's generated class MainVerticleGen&lt;AbstractVerticle&gt;: </h3>extends MainVerticleGen
 * <p>
 * This Java class extends a generated Java class MainVerticleGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.aitelemetry.verticle.MainVerticle">Find the class MainVerticle in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends MainVerticleGen<AbstractVerticle>
 * <p>This <code>class MainVerticle extends MainVerticleGen&lt;AbstractVerticle&gt;</code>, which means it extends a newly generated MainVerticleGen. 
 * The generated <code>class MainVerticleGen extends AbstractVerticle</code> which means that MainVerticle extends MainVerticleGen which extends AbstractVerticle. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>
 *   Api: true
 * </h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the MainVerticle class will inherit the helpful inherited class comments from the super class MainVerticleGen. 
 * </p>
 * <h2>
 *   Rows: 10
 * </h2>
 * <p>This class contains a comment <kbd><b>Rows: 10</b></kbd>, which means the  API will return a default of 10 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <p>
 *   You can add a class comment <kbd><b>Rows: 100</b></kbd> if you wish for the  API to return more or less than 10 results by default. 
 *   In this case, the API will return 100 results from the API instead of 10 by default. 
 *   Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>
 *   Order: 1
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Order: 1</b></kbd>, 
 *   which means this class will be sorted by the given number 1 
 *   ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <p>
 *   You can add a class comment <kbd><b>Order: </b></kbd>, followed by an Integer to sort this class compared to other classes in the project. 
 *   There is code that is generated that queries several classes and writes code for each class in a sequence. 
 *   The <kbd><b>Order</b></kbd> comment allows you to define which order the class code is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class MainVerticle in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.aitelemetry.verticle.MainVerticle&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.aitelemetry.verticle in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.aitelemetry.verticle&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the project ai-telemetry in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:ai\-telemetry&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * Generated: true
 **/
public abstract class MainVerticleGen<DEV> extends AbstractVerticle {
  protected static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);

  public static final String SITE_NAME = "ai-telemetry";
  public static final String authorizeDataFail1 = "Adding Keycloak authorization resources, policies, and permissions failed. ";
  public static final String authorizeDataFail = authorizeDataFail1;

  public static final String configureI18nFileError1 = "Failed to load internationalization data from file: %s";
  public static final String configureI18nFileError = configureI18nFileError1;
  public static final String configureI18nError1 = "Failed to load internationalization data. ";
  public static final String configureI18nError = configureI18nError1;
  public static final String configureI18nComplete1 = "Loading internationalization data is complete. ";
  public static final String configureI18nComplete = configureI18nComplete1;
  public static final String configureI18nLoaded1 = "Loaded internationalization data: %s";
  public static final String configureI18nLoaded = configureI18nLoaded1;


  //////////////
  // initDeep //
  //////////////

  public MainVerticle initDeepMainVerticle(SiteRequest siteRequest_) {
    initDeepMainVerticle();
    return (MainVerticle)this;
  }

  public void initDeepMainVerticle() {
    initMainVerticle();
  }

  public void initMainVerticle() {
  }

  public void initDeepForClass(SiteRequest siteRequest_) {
    initDeepMainVerticle(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainMainVerticle(v);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.obtainForClass(v);
      }
      else if(o instanceof Map) {
        Map<?, ?> map = (Map<?, ?>)o;
        o = map.get(v);
      }
    }
    return o;
  }
  public Object obtainMainVerticle(String var) {
    MainVerticle oMainVerticle = (MainVerticle)this;
    switch(var) {
      default:
        return null;
    }
  }

  ///////////////
  // relate //
  ///////////////

  public boolean relateForClass(String var, Object val) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = relateMainVerticle(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateMainVerticle(String var, Object val) {
    MainVerticle oMainVerticle = (MainVerticle)this;
    switch(var) {
      default:
        return null;
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, MainVerticle o) {
    return staticSetMainVerticle(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetMainVerticle(String entityVar, SiteRequest siteRequest_, String v, MainVerticle o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchMainVerticle(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchMainVerticle(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrMainVerticle(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrMainVerticle(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqMainVerticle(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqMainVerticle(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    return sb.toString();
  }

  public static final String[] MainVerticleVals = new String[] { authorizeDataFail1, configureI18nFileError1, configureI18nError1, configureI18nComplete1, configureI18nLoaded1 };

  public static final String CLASS_SIMPLE_NAME = "MainVerticle";
  public static final String CLASS_CANONICAL_NAME = "org.computate.aitelemetry.verticle.MainVerticle";
  public static final String CLASS_AUTH_RESOURCE = "MAINVERTICLE";


  public static String displayNameForClass(String var) {
    return MainVerticle.displayNameMainVerticle(var);
  }
  public static String displayNameMainVerticle(String var) {
    switch(var) {
    default:
      return null;
    }
  }
}

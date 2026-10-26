package org.computate.aitelemetry.verticle;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.yaml.snakeyaml.Yaml;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.tool.TimeTool;
import org.computate.search.tool.XmlTool;
import org.computate.vertx.api.ApiCounter;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.api.ApiCounter;
import org.computate.vertx.api.ApiRequest;
import org.computate.aitelemetry.config.ConfigKeys;
import org.computate.aitelemetry.request.SiteRequest;
import org.computate.aitelemetry.timezone.TimeZone;
import org.computate.aitelemetry.timezone.TimeZoneEnUSApiServiceImpl;
import org.computate.aitelemetry.timezone.TimeZoneEnUSGenApiService;
import org.computate.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloper;
import org.computate.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperEnUSApiServiceImpl;
import org.computate.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperEnUSGenApiService;
import org.computate.aitelemetry.page.SitePage;
import org.computate.aitelemetry.page.SitePageEnUSApiServiceImpl;
import org.computate.aitelemetry.page.SitePageEnUSGenApiService;
import org.computate.aitelemetry.model.MapModel;
import org.computate.aitelemetry.model.MapModelEnUSApiServiceImpl;
import org.computate.aitelemetry.model.MapModelEnUSGenApiService;
import org.computate.aitelemetry.model.tenant.Tenant;
import org.computate.aitelemetry.model.tenant.TenantEnUSApiServiceImpl;
import org.computate.aitelemetry.model.tenant.TenantEnUSGenApiService;
import org.computate.aitelemetry.model.hub.Hub;
import org.computate.aitelemetry.model.hub.HubEnUSApiServiceImpl;
import org.computate.aitelemetry.model.hub.HubEnUSGenApiService;
import org.computate.aitelemetry.model.cluster.Cluster;
import org.computate.aitelemetry.model.cluster.ClusterEnUSApiServiceImpl;
import org.computate.aitelemetry.model.cluster.ClusterEnUSGenApiService;
import org.computate.aitelemetry.model.node.AiNode;
import org.computate.aitelemetry.model.node.AiNodeEnUSApiServiceImpl;
import org.computate.aitelemetry.model.node.AiNodeEnUSGenApiService;
import org.computate.aitelemetry.model.gpudevice.GpuDevice;
import org.computate.aitelemetry.model.gpudevice.GpuDeviceEnUSApiServiceImpl;
import org.computate.aitelemetry.model.gpudevice.GpuDeviceEnUSGenApiService;
import org.computate.aitelemetry.model.project.Project;
import org.computate.aitelemetry.model.project.ProjectEnUSApiServiceImpl;
import org.computate.aitelemetry.model.project.ProjectEnUSGenApiService;
import org.computate.aitelemetry.model.virtualmachine.VirtualMachine;
import org.computate.aitelemetry.model.virtualmachine.VirtualMachineEnUSApiServiceImpl;
import org.computate.aitelemetry.model.virtualmachine.VirtualMachineEnUSGenApiService;
import org.computate.aitelemetry.model.clusterrequest.ClusterRequest;
import org.computate.aitelemetry.model.clusterrequest.ClusterRequestEnUSApiServiceImpl;
import org.computate.aitelemetry.model.clusterrequest.ClusterRequestEnUSGenApiService;
import org.computate.aitelemetry.model.clusterorder.ClusterOrder;
import org.computate.aitelemetry.model.clusterorder.ClusterOrderEnUSApiServiceImpl;
import org.computate.aitelemetry.model.clusterorder.ClusterOrderEnUSGenApiService;
import org.computate.aitelemetry.model.clustertemplate.ClusterTemplate;
import org.computate.aitelemetry.model.clustertemplate.ClusterTemplateEnUSApiServiceImpl;
import org.computate.aitelemetry.model.clustertemplate.ClusterTemplateEnUSGenApiService;
import org.computate.aitelemetry.model.managedcluster.ManagedCluster;
import org.computate.aitelemetry.model.managedcluster.ManagedClusterEnUSApiServiceImpl;
import org.computate.aitelemetry.model.managedcluster.ManagedClusterEnUSGenApiService;
import org.computate.aitelemetry.model.baremetalorder.BareMetalOrder;
import org.computate.aitelemetry.model.baremetalorder.BareMetalOrderEnUSApiServiceImpl;
import org.computate.aitelemetry.model.baremetalorder.BareMetalOrderEnUSGenApiService;
import org.computate.aitelemetry.model.baremetalresourceclass.BareMetalResourceClass;
import org.computate.aitelemetry.model.baremetalresourceclass.BareMetalResourceClassEnUSApiServiceImpl;
import org.computate.aitelemetry.model.baremetalresourceclass.BareMetalResourceClassEnUSGenApiService;
import org.computate.aitelemetry.model.baremetalnetwork.BareMetalNetwork;
import org.computate.aitelemetry.model.baremetalnetwork.BareMetalNetworkEnUSApiServiceImpl;
import org.computate.aitelemetry.model.baremetalnetwork.BareMetalNetworkEnUSGenApiService;
import org.computate.aitelemetry.model.baremetalnode.BareMetalNode;
import org.computate.aitelemetry.model.baremetalnode.BareMetalNodeEnUSApiServiceImpl;
import org.computate.aitelemetry.model.baremetalnode.BareMetalNodeEnUSGenApiService;
import org.computate.vertx.api.ApiCounter;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.computate.vertx.api.BaseApiServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.io.PatternFilenameFilter;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.loader.FileLocator;
import io.vertx.config.yaml.YamlProcessor;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.api.trace.Tracer;
import io.vertx.ext.auth.authentication.TokenCredentials;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailConfig;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpClient;
import io.vertx.amqp.AmqpClientOptions;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.rabbitmq.RabbitMQOptions;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import io.vertx.amqp.AmqpMessage;
import io.vertx.amqp.AmqpMessageBuilder;
import io.vertx.amqp.AmqpSenderOptions;
import io.vertx.pgclient.PgBuilder;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.Cursor;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowStream;
import io.vertx.sqlclient.SqlConnection;
import org.computate.aitelemetry.user.SiteUser;
import org.computate.aitelemetry.user.SiteUserEnUSApiServiceImpl;
import org.computate.aitelemetry.user.SiteUserEnUSGenApiService;
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
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class WorkerVerticleGen into the class WorkerVerticle. 
 * </li>
 * <h3>About the WorkerVerticle class and it's generated class WorkerVerticleGen&lt;AbstractVerticle&gt;: </h3>extends WorkerVerticleGen
 * <p>
 * This Java class extends a generated Java class WorkerVerticleGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.aitelemetry.verticle.WorkerVerticle">Find the class WorkerVerticle in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends WorkerVerticleGen<AbstractVerticle>
 * <p>This <code>class WorkerVerticle extends WorkerVerticleGen&lt;AbstractVerticle&gt;</code>, which means it extends a newly generated WorkerVerticleGen. 
 * The generated <code>class WorkerVerticleGen extends AbstractVerticle</code> which means that WorkerVerticle extends WorkerVerticleGen which extends AbstractVerticle. 
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
 * <p>By adding a class comment "{@inheritDoc}", the WorkerVerticle class will inherit the helpful inherited class comments from the super class WorkerVerticleGen. 
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
 * Delete the class WorkerVerticle in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.aitelemetry.verticle.WorkerVerticle&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class WorkerVerticleGen<DEV> extends AbstractVerticle {
  protected static final Logger LOG = LoggerFactory.getLogger(WorkerVerticle.class);
  public static final String configureI18nFileError1 = "Failed to load internationalization data from file: %s";
  public static final String configureI18nFileError = configureI18nFileError1;
  public static final String configureI18nError1 = "Failed to load internationalization data. ";
  public static final String configureI18nError = configureI18nError1;
  public static final String configureI18nComplete1 = "Loading internationalization data is complete. ";
  public static final String configureI18nComplete = configureI18nComplete1;
  public static final String configureI18nLoaded1 = "Loaded internationalization data: %s";
  public static final String configureI18nLoaded = configureI18nLoaded1;

  public static final String configureDataConnectionError1 = "Could not open the database client connection. ";
  public static final String configureDataConnectionError = configureDataConnectionError1;
  public static final String configureDataConnectionSuccess1 = "The database client connection was successful. \n";
  public static final String configureDataConnectionSuccess = configureDataConnectionSuccess1;
  public static final String configureDataInitError1 = "Could not initialize the database tables. ";
  public static final String configureDataInitError = configureDataInitError1;
  public static final String configureDataInitSuccess1 = "The database was initialized successfully. \n";
  public static final String configureDataInitSuccess = configureDataInitSuccess1;

  public static final String configureSharedWorkerExecutorFail1 = "Could not configure the shared worker executor. ";
  public static final String configureSharedWorkerExecutorFail = configureSharedWorkerExecutorFail1;
  public static final String configureSharedWorkerExecutorComplete1 = "The shared worker executor \"{}\" was configured successfully. \n";
  public static final String configureSharedWorkerExecutorComplete = configureSharedWorkerExecutorComplete1;

  public static final String configureKafkaSuccess1 = "The Kafka producer was initialized successfully. ";
  public static final String configureKafkaSuccess = configureKafkaSuccess1;

  public static final String importDataSkip1 = "The data import is disabled. ";
  public static final String importDataSkip = importDataSkip1;


  //////////////
  // initDeep //
  //////////////

  public WorkerVerticle initDeepWorkerVerticle(SiteRequest siteRequest_) {
    initDeepWorkerVerticle();
    return (WorkerVerticle)this;
  }

  public void initDeepWorkerVerticle() {
    initWorkerVerticle();
  }

  public void initWorkerVerticle() {
  }

  public void initDeepForClass(SiteRequest siteRequest_) {
    initDeepWorkerVerticle(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainWorkerVerticle(v);
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
  public Object obtainWorkerVerticle(String var) {
    WorkerVerticle oWorkerVerticle = (WorkerVerticle)this;
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
        o = relateWorkerVerticle(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateWorkerVerticle(String var, Object val) {
    WorkerVerticle oWorkerVerticle = (WorkerVerticle)this;
    switch(var) {
      default:
        return null;
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, WorkerVerticle o) {
    return staticSetWorkerVerticle(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetWorkerVerticle(String entityVar, SiteRequest siteRequest_, String v, WorkerVerticle o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchWorkerVerticle(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchWorkerVerticle(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrWorkerVerticle(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrWorkerVerticle(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqWorkerVerticle(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqWorkerVerticle(String entityVar, SiteRequest siteRequest_, String o) {
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

  public static final String[] WorkerVerticleVals = new String[] { configureI18nFileError1, configureI18nError1, configureI18nComplete1, configureI18nLoaded1, configureDataConnectionError1, configureDataConnectionSuccess1, configureDataInitError1, configureDataInitSuccess1, configureSharedWorkerExecutorFail1, configureSharedWorkerExecutorComplete1, configureKafkaSuccess1, importDataSkip1 };

  public static final String CLASS_SIMPLE_NAME = "WorkerVerticle";
  public static final String CLASS_CANONICAL_NAME = "org.computate.aitelemetry.verticle.WorkerVerticle";
  public static final String CLASS_AUTH_RESOURCE = "WORKERVERTICLE";


  public static String displayNameForClass(String var) {
    return WorkerVerticle.displayNameWorkerVerticle(var);
  }
  public static String displayNameWorkerVerticle(String var) {
    switch(var) {
    default:
      return null;
    }
  }
}

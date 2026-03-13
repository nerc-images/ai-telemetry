
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
import org.computate.aitelemetry.page.SitePage;
import org.computate.aitelemetry.page.SitePageEnUSApiServiceImpl;
import org.computate.aitelemetry.page.SitePageEnUSGenApiService;
import org.computate.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloper;
import org.computate.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperEnUSApiServiceImpl;
import org.computate.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperEnUSGenApiService;
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
import org.computate.vertx.handlebars.AuthHelpers;
import org.computate.vertx.handlebars.DateHelpers;
import org.computate.vertx.handlebars.SiteHelpers;
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

/**
 */
public class WorkerVerticle extends WorkerVerticleGen<AbstractVerticle> {
  private static final Logger LOG = LoggerFactory.getLogger(WorkerVerticle.class);

  public static final Integer FACET_LIMIT = 100;

  public final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss VV");

  private KafkaProducer<String, String> kafkaProducer;

  private MqttClient mqttClient;

  private AmqpClient amqpClient;

  private AmqpSender amqpSender;

  private RabbitMQClient rabbitmqClient;

  private ComputateOAuth2AuthHandlerImpl oauth2AuthHandler = null;

  public ComputateOAuth2AuthHandlerImpl getOauth2AuthHandler() {
    return oauth2AuthHandler;
  }

  public void setOauth2AuthHandler(ComputateOAuth2AuthHandlerImpl oauth2AuthHandler) {
    this.oauth2AuthHandler = oauth2AuthHandler;
  }

  private JsonObject i18n;

  /**
   * A JDBC client for connecting to the relational database PostgreSQL. 
   **/
  private Pool pgPool;

  public Pool getPgPool() {
    return pgPool;
  }

  public void setPgPool(Pool pgPool) {
    this.pgPool = pgPool;
  }

  private WebClient webClient;

  WorkerExecutor workerExecutor;

  Integer commitWithin;

  Jinjava jinjava;

  SdkTracerProvider sdkTracerProvider;
  public void setSdkTracerProvider(SdkTracerProvider sdkTracerProvider) {
    this.sdkTracerProvider = sdkTracerProvider;
  }

  SdkMeterProvider sdkMeterProvider;
  public void setSdkMeterProvider(SdkMeterProvider sdkMeterProvider) {
    this.sdkMeterProvider = sdkMeterProvider;
  }

  /**
   * This is called by Vert.x when the verticle instance is deployed. 
   * Initialize a new site context object for storing information about the entire site in English. 
   * Setup the startPromise to handle the configuration steps and starting the server. 
   **/
  @Override()
  public void start(Promise<Void> startPromise) throws Exception, Exception {
    commitWithin = Integer.parseInt(config().getString(ConfigKeys.SOLR_WORKER_COMMIT_WITHIN_MILLIS));

    try {
      configureI18n().onSuccess(a -> 
        configureData().onSuccess(b -> 
          configureJinjava().onSuccess(c -> 
            configureWebClient().onSuccess(d -> 
              configureSharedWorkerExecutor().onSuccess(e -> 
                configureKafka().onSuccess(f -> 
                  MainVerticle.authorizeData(vertx, config(), webClient).onComplete(j -> 
                          importData().onSuccess(k -> 
                            startPromise.complete()
                          ).onFailure(ex -> startPromise.fail(ex))
                        ).onFailure(ex -> startPromise.fail(ex))
                      ).onFailure(ex -> startPromise.fail(ex))
              ).onFailure(ex -> startPromise.fail(ex))
            ).onFailure(ex -> startPromise.fail(ex))
          ).onFailure(ex -> startPromise.fail(ex))
        ).onFailure(ex -> startPromise.fail(ex))
      ).onFailure(ex -> startPromise.fail(ex));
    } catch (Exception ex) {
      LOG.error("Couldn't start verticle. ", ex);
    }
  }

  /**
   * Configure internationalization. 
   * Val.FileError.enUS: Failed to load internationalization data from file: %s
   * Val.Error.enUS: Failed to load internationalization data. 
   * Val.Complete.enUS: Loading internationalization data is complete. 
   * Val.Loaded.enUS: Loaded internationalization data: %s
   **/
  public Future<JsonObject> configureI18n() {
    Promise<JsonObject> promise = Promise.promise();
    try {
      List<Future<String>> futures = new ArrayList<>();
      JsonArray i18nPaths = Optional.ofNullable(config().getValue(ConfigKeys.I18N_PATHS))
          .map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString()))
          .orElse(new JsonArray())
          ;
      i18n = new JsonObject();
      i18nPaths.stream().map(o -> (String)o).forEach(i18nPath -> {
        futures.add(Future.future(promise1 -> {
          vertx.fileSystem().readFile(i18nPath).onSuccess(buffer -> {
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(buffer.toString());
            i18n.mergeIn(new JsonObject(map));
            LOG.info(String.format(configureI18nLoaded, i18nPath));
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format(configureI18nFileError, i18nPath), ex);
            promise1.fail(ex);
          });
        }));
      });
      Future.all(futures).onSuccess(b -> {
        LOG.info(configureI18nComplete);
        promise.complete(i18n);
      }).onFailure(ex -> {
        LOG.error(configureI18nError, ex);
        promise.fail(ex);
      });
    } catch (Throwable ex) {
      LOG.error(configureI18nError, ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  /**
   **/
  public Future<Jinjava> configureJinjava() {
    Promise<Jinjava> promise = Promise.promise();

    try {
      jinjava = ComputateConfigKeys.getJinjava();
      String templatePath = config().getString(ConfigKeys.TEMPLATE_PATH);
      if(!StringUtils.isBlank(templatePath))
        jinjava.setResourceLocator(new FileLocator(new File(templatePath)));
      promise.complete(jinjava);
    } catch(Exception ex) {
      LOG.error("Jinjava failed to initialize.", ex);
      promise.fail(ex);
    }

    return promise.future();
  }

  /**
   **/
  private Future<Void> configureWebClient() {
    Promise<Void> promise = Promise.promise();

    try {
      Boolean sslVerify = Boolean.valueOf(config().getString(ConfigKeys.SSL_VERIFY));
      webClient = WebClient.create(vertx, new WebClientOptions().setVerifyHost(sslVerify).setTrustAll(!sslVerify));
      promise.complete();
    } catch(Exception ex) {
      LOG.error("Unable to configure site context. ", ex);
      promise.fail(ex);
    }

    return promise.future();
  }

  /**
   * 
   * Val.ConnectionError.enUS: Could not open the database client connection. 
   * Val.ConnectionSuccess.enUS: The database client connection was successful. 
   * 
   * Val.InitError.enUS: Could not initialize the database tables. 
   * Val.InitSuccess.enUS: The database was initialized successfully. 
   * 
   * Configure shared database connections across the cluster for massive scaling of the application. 
   * Return a promise that configures a shared database client connection. 
   * Load the database configuration into a shared JDBC client for a scalable, clustered datasource connection pool. 
   * Initialize the database tables if not already created for the first time. 
   **/
  private Future<Void> configureData() {
    Promise<Void> promise = Promise.promise();
    try {
      PgConnectOptions pgOptions = new PgConnectOptions();
      Integer jdbcMaxPoolSize = Integer.parseInt(config().getString(ConfigKeys.DATABASE_MAX_POOL_SIZE));

      pgOptions.setPort(Integer.parseInt(config().getString(ConfigKeys.DATABASE_PORT)));
      pgOptions.setHost(config().getString(ConfigKeys.DATABASE_HOST_NAME));
      pgOptions.setDatabase(config().getString(ConfigKeys.DATABASE_DATABASE));
      pgOptions.setUser(config().getString(ConfigKeys.DATABASE_USERNAME));
      pgOptions.setPassword(config().getString(ConfigKeys.DATABASE_PASSWORD));
      // pgOptions.setIdleTimeout(Integer.parseInt(config().getString(ConfigKeys.DATABASE_MAX_IDLE_TIME)));
      // pgOptions.setIdleTimeoutUnit(TimeUnit.HOURS);
      // pgOptions.setConnectTimeout(Integer.parseInt(config().getString(ConfigKeys.DATABASE_CONNECT_TIMEOUT)));

      PoolOptions poolOptions = new PoolOptions();
      poolOptions.setMaxSize(jdbcMaxPoolSize);
      poolOptions.setMaxWaitQueueSize(Integer.parseInt(config().getString(ConfigKeys.DATABASE_MAX_WAIT_QUEUE_SIZE)));

      pgPool = PgBuilder.pool().connectingTo(pgOptions).with(poolOptions).using(vertx).build();

      MainVerticle.configureDatabaseSchema(vertx, config()).onComplete(a -> {
        LOG.info(configureDataInitSuccess);
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(configureDataInitError, ex);
        promise.fail(ex);
      });
    } catch (Exception ex) {
      LOG.error(configureDataInitError, ex);
      promise.fail(ex);
    }

    return promise.future();
  }

  /**
   * Val.Fail.enUS: Could not configure the shared worker executor. 
   * Val.Complete.enUS: The shared worker executor "{}" was configured successfully. 
   * 
   * Configure a shared worker executor for running blocking tasks in the background. 
   * Return a promise that configures the shared worker executor. 
   **/
  private Future<Void> configureSharedWorkerExecutor() {
    Promise<Void> promise = Promise.promise();
    try {
      String name = "WorkerVerticle-WorkerExecutor";
      Integer workerPoolSize = System.getenv(ConfigKeys.WORKER_POOL_SIZE) == null ? 5 : Integer.parseInt(System.getenv(ConfigKeys.WORKER_POOL_SIZE));
      Long vertxMaxWorkerExecuteTime = config().getLong(ConfigKeys.VERTX_MAX_WORKER_EXECUTE_TIME);
      workerExecutor = vertx.createSharedWorkerExecutor(name, workerPoolSize, vertxMaxWorkerExecuteTime, TimeUnit.SECONDS);
      LOG.info(configureSharedWorkerExecutorComplete, name);
      promise.complete();
    } catch (Exception ex) {
      LOG.error(configureSharedWorkerExecutorFail, ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  /**
   * Val.Success.enUS: The Kafka producer was initialized successfully. 
   **/
  public Future<KafkaProducer<String, String>> configureKafka() {
    Promise<KafkaProducer<String, String>> promise = Promise.promise();

    try {
      if(Boolean.valueOf(config().getString(ConfigKeys.ENABLE_KAFKA))) {
        Map<String, String> kafkaConfig = new HashMap<>();
        kafkaConfig.put("bootstrap.servers", config().getString(ConfigKeys.KAFKA_BROKERS));
        kafkaConfig.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaConfig.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaConfig.put("acks", "1");
        kafkaConfig.put("security.protocol", "SSL");
        kafkaConfig.put("ssl.keystore.type", config().getString(ConfigKeys.KAFKA_SSL_KEYSTORE_TYPE));
        kafkaConfig.put("ssl.keystore.location", config().getString(ConfigKeys.KAFKA_SSL_KEYSTORE_LOCATION));
        kafkaConfig.put("ssl.keystore.password", config().getString(ConfigKeys.KAFKA_SSL_KEYSTORE_PASSWORD));
        kafkaConfig.put("ssl.truststore.type", config().getString(ConfigKeys.KAFKA_SSL_TRUSTSTORE_TYPE));
        kafkaConfig.put("ssl.truststore.location", config().getString(ConfigKeys.KAFKA_SSL_TRUSTSTORE_LOCATION));
        kafkaConfig.put("ssl.truststore.password", config().getString(ConfigKeys.KAFKA_SSL_TRUSTSTORE_PASSWORD));

        kafkaProducer = KafkaProducer.createShared(vertx, config().getString(ConfigKeys.SITE_NAME), kafkaConfig);
        LOG.info(configureKafkaSuccess);
        promise.complete(kafkaProducer);
      } else {
        LOG.info(configureKafkaSuccess);
        promise.complete(null);
      }
    } catch(Exception ex) {
      LOG.error("Unable to configure site context. ", ex);
      promise.fail(ex);
    }

    return promise.future();
  }

  public <API_IMPL extends BaseApiServiceInterface> void initializeApiService(API_IMPL service) {
    service.setVertx(vertx);
    service.setEventBus(vertx.eventBus());
    service.setConfig(config());
    service.setWorkerExecutor(workerExecutor);
    service.setOauth2AuthHandler(oauth2AuthHandler);
    service.setPgPool(pgPool);
    service.setKafkaProducer(kafkaProducer);
    service.setMqttClient(mqttClient);
    service.setAmqpClient(amqpClient);
    service.setRabbitmqClient(rabbitmqClient);
    service.setWebClient(webClient);
    service.setJinjava(jinjava);
    service.setI18n(i18n);
  }

  /**
   * Description: Import initial data
   * Val.Skip.enUS: The data import is disabled. 
   **/
  public Future<Void> importData() {
    Promise<Void> promise = Promise.promise();
    if(Boolean.valueOf(config().getString(ConfigKeys.ENABLE_IMPORT_DATA))) {
      SiteRequest siteRequest = new SiteRequest();
      siteRequest.setConfig(config());
      siteRequest.setWebClient(webClient);
      siteRequest.initDeepSiteRequest(siteRequest);
      siteRequest.addScopes("GET");
      String templatePath = config().getString(ComputateConfigKeys.TEMPLATE_PATH);

      TimeZoneEnUSApiServiceImpl apiTimeZone = new TimeZoneEnUSApiServiceImpl();
      initializeApiService(apiTimeZone);
      SitePageEnUSApiServiceImpl apiSitePage = new SitePageEnUSApiServiceImpl();
      initializeApiService(apiSitePage);
      AiTelemetryDeveloperEnUSApiServiceImpl apiAiTelemetryDeveloper = new AiTelemetryDeveloperEnUSApiServiceImpl();
      initializeApiService(apiAiTelemetryDeveloper);
      TenantEnUSApiServiceImpl apiTenant = new TenantEnUSApiServiceImpl();
      initializeApiService(apiTenant);
      HubEnUSApiServiceImpl apiHub = new HubEnUSApiServiceImpl();
      initializeApiService(apiHub);
      ClusterEnUSApiServiceImpl apiCluster = new ClusterEnUSApiServiceImpl();
      initializeApiService(apiCluster);
      AiNodeEnUSApiServiceImpl apiAiNode = new AiNodeEnUSApiServiceImpl();
      initializeApiService(apiAiNode);
      GpuDeviceEnUSApiServiceImpl apiGpuDevice = new GpuDeviceEnUSApiServiceImpl();
      initializeApiService(apiGpuDevice);
      ProjectEnUSApiServiceImpl apiProject = new ProjectEnUSApiServiceImpl();
      initializeApiService(apiProject);
      VirtualMachineEnUSApiServiceImpl apiVirtualMachine = new VirtualMachineEnUSApiServiceImpl();
      initializeApiService(apiVirtualMachine);
      ClusterRequestEnUSApiServiceImpl apiClusterRequest = new ClusterRequestEnUSApiServiceImpl();
      initializeApiService(apiClusterRequest);
      ClusterOrderEnUSApiServiceImpl apiClusterOrder = new ClusterOrderEnUSApiServiceImpl();
      initializeApiService(apiClusterOrder);
      ClusterTemplateEnUSApiServiceImpl apiClusterTemplate = new ClusterTemplateEnUSApiServiceImpl();
      initializeApiService(apiClusterTemplate);
      ManagedClusterEnUSApiServiceImpl apiManagedCluster = new ManagedClusterEnUSApiServiceImpl();
      initializeApiService(apiManagedCluster);
      BareMetalResourceClassEnUSApiServiceImpl apiBareMetalResourceClass = new BareMetalResourceClassEnUSApiServiceImpl();
      initializeApiService(apiBareMetalResourceClass);
      BareMetalNetworkEnUSApiServiceImpl apiBareMetalNetwork = new BareMetalNetworkEnUSApiServiceImpl();
      initializeApiService(apiBareMetalNetwork);
      BareMetalNodeEnUSApiServiceImpl apiBareMetalNode = new BareMetalNodeEnUSApiServiceImpl();
      initializeApiService(apiBareMetalNode);

      apiTimeZone.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, TimeZone.CLASS_CANONICAL_NAME, TimeZone.CLASS_SIMPLE_NAME, TimeZone.CLASS_API_ADDRESS_TimeZone, TimeZone.CLASS_AUTH_RESOURCE, "id", "userPage", "download").onSuccess(q1 -> {
        apiSitePage.importTimer(Paths.get(templatePath, "/en-us/view/article"), vertx, siteRequest, SitePage.CLASS_CANONICAL_NAME, SitePage.CLASS_SIMPLE_NAME, SitePage.CLASS_API_ADDRESS_SitePage, SitePage.CLASS_AUTH_RESOURCE, "pageId", "userPage", "download").onSuccess(q2 -> {
          apiAiTelemetryDeveloper.importTimer(Paths.get(templatePath, "/en-us/ai-telemetry-developer/learn"), vertx, siteRequest, AiTelemetryDeveloper.CLASS_CANONICAL_NAME, AiTelemetryDeveloper.CLASS_SIMPLE_NAME, AiTelemetryDeveloper.CLASS_API_ADDRESS_AiTelemetryDeveloper, AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "pageId", "userPage", "download").onSuccess(q3 -> {
            apiTenant.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, Tenant.CLASS_CANONICAL_NAME, Tenant.CLASS_SIMPLE_NAME, Tenant.CLASS_API_ADDRESS_Tenant, Tenant.CLASS_AUTH_RESOURCE, "tenantId", "userPage", "download").onSuccess(q4 -> {
              apiHub.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, Hub.CLASS_CANONICAL_NAME, Hub.CLASS_SIMPLE_NAME, Hub.CLASS_API_ADDRESS_Hub, Hub.CLASS_AUTH_RESOURCE, "hubId", "userPage", "download").onSuccess(q5 -> {
                apiCluster.importTimer(Paths.get(templatePath, "/en-us/user/cluster"), vertx, siteRequest, Cluster.CLASS_CANONICAL_NAME, Cluster.CLASS_SIMPLE_NAME, Cluster.CLASS_API_ADDRESS_Cluster, Cluster.CLASS_AUTH_RESOURCE, "clusterResource", "userPage", "download").onSuccess(q6 -> {
                  apiAiNode.importTimer(Paths.get(templatePath, "/en-us/user/ai-node"), vertx, siteRequest, AiNode.CLASS_CANONICAL_NAME, AiNode.CLASS_SIMPLE_NAME, AiNode.CLASS_API_ADDRESS_AiNode, AiNode.CLASS_AUTH_RESOURCE, "nodeResource", "userPage", "download").onSuccess(q7 -> {
                    apiGpuDevice.importTimer(Paths.get(templatePath, "/en-us/user/gpu-device"), vertx, siteRequest, GpuDevice.CLASS_CANONICAL_NAME, GpuDevice.CLASS_SIMPLE_NAME, GpuDevice.CLASS_API_ADDRESS_GpuDevice, GpuDevice.CLASS_AUTH_RESOURCE, "gpuDeviceResource", "userPage", "download").onSuccess(q8 -> {
                      apiProject.importTimer(Paths.get(templatePath, "/en-us/user/project"), vertx, siteRequest, Project.CLASS_CANONICAL_NAME, Project.CLASS_SIMPLE_NAME, Project.CLASS_API_ADDRESS_Project, Project.CLASS_AUTH_RESOURCE, "projectResource", "userPage", "download").onSuccess(q9 -> {
                        apiVirtualMachine.importTimer(Paths.get(templatePath, "/en-us/user/vm"), vertx, siteRequest, VirtualMachine.CLASS_CANONICAL_NAME, VirtualMachine.CLASS_SIMPLE_NAME, VirtualMachine.CLASS_API_ADDRESS_VirtualMachine, VirtualMachine.CLASS_AUTH_RESOURCE, "vmResource", "userPage", "download").onSuccess(q10 -> {
                          apiClusterRequest.importTimer(Paths.get(templatePath, "/en-us/user/cluster-request"), vertx, siteRequest, ClusterRequest.CLASS_CANONICAL_NAME, ClusterRequest.CLASS_SIMPLE_NAME, ClusterRequest.CLASS_API_ADDRESS_ClusterRequest, ClusterRequest.CLASS_AUTH_RESOURCE, "name", "userPage", "download").onSuccess(q11 -> {
                            apiClusterOrder.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, ClusterOrder.CLASS_CANONICAL_NAME, ClusterOrder.CLASS_SIMPLE_NAME, ClusterOrder.CLASS_API_ADDRESS_ClusterOrder, ClusterOrder.CLASS_AUTH_RESOURCE, "id", "userPage", "download").onSuccess(q12 -> {
                              apiClusterTemplate.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, ClusterTemplate.CLASS_CANONICAL_NAME, ClusterTemplate.CLASS_SIMPLE_NAME, ClusterTemplate.CLASS_API_ADDRESS_ClusterTemplate, ClusterTemplate.CLASS_AUTH_RESOURCE, "id", "userPage", "download").onSuccess(q13 -> {
                                apiManagedCluster.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, ManagedCluster.CLASS_CANONICAL_NAME, ManagedCluster.CLASS_SIMPLE_NAME, ManagedCluster.CLASS_API_ADDRESS_ManagedCluster, ManagedCluster.CLASS_AUTH_RESOURCE, "id", "userPage", "download").onSuccess(q14 -> {
                                  apiBareMetalResourceClass.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, BareMetalResourceClass.CLASS_CANONICAL_NAME, BareMetalResourceClass.CLASS_SIMPLE_NAME, BareMetalResourceClass.CLASS_API_ADDRESS_BareMetalResourceClass, BareMetalResourceClass.CLASS_AUTH_RESOURCE, "name", "userPage", "download").onSuccess(q15 -> {
                                    apiBareMetalNetwork.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, BareMetalNetwork.CLASS_CANONICAL_NAME, BareMetalNetwork.CLASS_SIMPLE_NAME, BareMetalNetwork.CLASS_API_ADDRESS_BareMetalNetwork, BareMetalNetwork.CLASS_AUTH_RESOURCE, "id", "userPage", "download").onSuccess(q16 -> {
                                      apiBareMetalNode.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, BareMetalNode.CLASS_CANONICAL_NAME, BareMetalNode.CLASS_SIMPLE_NAME, BareMetalNode.CLASS_API_ADDRESS_BareMetalNode, BareMetalNode.CLASS_AUTH_RESOURCE, "nodeId", "userPage", "download").onSuccess(q17 -> {
                                        LOG.info("data import complete");
                                        promise.complete();
                                      }).onFailure(ex -> promise.fail(ex));
                                    }).onFailure(ex -> promise.fail(ex));
                                  }).onFailure(ex -> promise.fail(ex));
                                }).onFailure(ex -> promise.fail(ex));
                              }).onFailure(ex -> promise.fail(ex));
                            }).onFailure(ex -> promise.fail(ex));
                          }).onFailure(ex -> promise.fail(ex));
                        }).onFailure(ex -> promise.fail(ex));
                      }).onFailure(ex -> promise.fail(ex));
                    }).onFailure(ex -> promise.fail(ex));
                  }).onFailure(ex -> promise.fail(ex));
                }).onFailure(ex -> promise.fail(ex));
              }).onFailure(ex -> promise.fail(ex));
            }).onFailure(ex -> promise.fail(ex));
          }).onFailure(ex -> promise.fail(ex));
        }).onFailure(ex -> promise.fail(ex));
      }).onFailure(ex -> promise.fail(ex));
    }
    else {
      LOG.info(importDataSkip);
      promise.complete();
    }
    return promise.future();
  }
}

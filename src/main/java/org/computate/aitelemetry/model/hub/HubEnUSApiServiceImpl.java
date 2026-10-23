package org.computate.aitelemetry.model.hub;

import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.sqlclient.Pool;

import java.net.URLEncoder;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.search.list.SearchList;
import org.computate.aitelemetry.config.ConfigKeys;
import org.computate.aitelemetry.model.cluster.Cluster;
import org.computate.aitelemetry.model.cluster.ClusterEnUSApiServiceImpl;
import org.computate.aitelemetry.model.gpudevice.GpuDevice;
import org.computate.aitelemetry.model.gpudevice.GpuDeviceEnUSApiServiceImpl;
import org.computate.aitelemetry.model.node.AiNode;
import org.computate.aitelemetry.model.node.AiNodeEnUSApiServiceImpl;
import org.computate.aitelemetry.model.project.Project;
import org.computate.aitelemetry.model.virtualmachine.VirtualMachine;
import org.computate.aitelemetry.model.virtualmachine.VirtualMachineEnUSApiServiceImpl;
import org.computate.aitelemetry.request.SiteRequest;

import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.config.yaml.YamlProcessor;
import io.vertx.rabbitmq.RabbitMQClient;
import com.hubspot.jinjava.Jinjava;

/**
 * Translate: false
 **/
public class HubEnUSApiServiceImpl extends HubEnUSGenApiServiceImpl {

  ////////////////
  // Hub import //
  ////////////////

  @Override
  public Future<Hub> patchHubFuture(Hub o, Boolean inheritPrimaryKey) {
    Promise<Hub> promise = Promise.promise();
    super.patchHubFuture(o, inheritPrimaryKey).onSuccess(o2 -> {
      postOrPatchHubFuture(o2).onSuccess(a -> {
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("patchHubFuture failed. "), ex);
        promise.fail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("patchHubFuture failed. "), ex);
      promise.fail(ex);
    });
    return promise.future();
  }

  @Override
  public Future<Hub> postHubFuture(SiteRequest siteRequest, Boolean hubResource) {
    Promise<Hub> promise = Promise.promise();
    super.postHubFuture(siteRequest, hubResource).onSuccess(o -> {
      postOrPatchHubFuture(o).onSuccess(a -> {
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("postHubFuture failed. "), ex);
        promise.fail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("postHubFuture failed. "), ex);
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<Hub> postOrPatchHubFuture(Hub hub) {
    Promise<Hub> promise = Promise.promise();
    try {
      String hubId = hub.getHubId();
      String authHostName = config.getString(ConfigKeys.AUTH_HOST_NAME);
      Integer authPort = config.getInteger(ConfigKeys.AUTH_PORT);
      String authTokenUri = config.getString(ConfigKeys.AUTH_TOKEN_URI);
      Boolean authSsl = config.getBoolean(ConfigKeys.AUTH_SSL);
      String authClient = config.getString(ConfigKeys.AUTH_CLIENT_SA);
      String authSecret = config.getString(ConfigKeys.AUTH_SECRET_SA);
      MultiMap form = MultiMap.caseInsensitiveMultiMap();
      form.add("grant_type", "client_credentials");
      UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(authClient, authSecret);
      webClient.post(authPort, authHostName, authTokenUri).ssl(authSsl).authentication(credentials)
          .putHeader("Content-Type", "application/json")
          .sendForm(form)
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(requestAuthResponse -> {
        try {
          String accessToken = requestAuthResponse.bodyAsJsonObject().getString("access_token");
          ClusterEnUSApiServiceImpl.queryClusterCapacityMemoryBytes(vertx, webClient, config, hub, Cluster.CLASS_SIMPLE_NAME, accessToken).onSuccess(clustersMemoryBytesTotal -> {
            ClusterEnUSApiServiceImpl.queryClusterCapacityCpuCores(vertx, webClient, config, hub, Cluster.CLASS_SIMPLE_NAME, accessToken).onSuccess(clustersCpuCoresTotal -> {
              AiNodeEnUSApiServiceImpl.queryAiNodesTotal(vertx, webClient, config, hub, Cluster.CLASS_SIMPLE_NAME, accessToken).onSuccess(clustersAiNodesTotal -> {
                VirtualMachineEnUSApiServiceImpl.queryVmsTotalForHub(vertx, webClient, config, hub, Cluster.CLASS_SIMPLE_NAME, accessToken).onSuccess(clustersVmsTotal -> {
                  GpuDeviceEnUSApiServiceImpl.queryGpuDevicesTotalForHub(vertx, webClient, config, hub, Cluster.CLASS_SIMPLE_NAME, accessToken).onSuccess(clustersGpuDevicesTotal -> {
                    List<JsonObject> clustersMemoryBytes = clustersMemoryBytesTotal.stream().filter(clusterResult -> !((JsonObject)clusterResult).getJsonArray("value").getString(1).equals("0")).map(result -> (JsonObject)result).map(result -> result.put("clusterName", "local-cluster".equals(result.getJsonObject("metric").getValue("cluster")) ? hub.getLocalClusterName() : result.getJsonObject("metric").getValue("cluster"))).collect(Collectors.toList());
                    List<JsonObject> clustersCpuCores = clustersCpuCoresTotal.stream().filter(clusterResult -> !((JsonObject)clusterResult).getJsonArray("value").getString(1).equals("0")).map(result -> (JsonObject)result).collect(Collectors.toList());
                    List<JsonObject> clustersAiNodes = clustersAiNodesTotal.stream().filter(clusterResult -> !((JsonObject)clusterResult).getJsonArray("value").getString(1).equals("0")).map(result -> (JsonObject)result).collect(Collectors.toList());
                    List<JsonObject> clustersGpuDevices = clustersGpuDevicesTotal.stream().filter(clusterResult -> !((JsonObject)clusterResult).getJsonArray("value").getString(1).equals("0")).map(result -> (JsonObject)result).collect(Collectors.toList());
                    List<JsonObject> clustersVms = clustersVmsTotal.stream().filter(vmResult -> !((JsonObject)vmResult).getJsonArray("value").getString(1).equals("0")).map(result -> (JsonObject)result).collect(Collectors.toList());
                    List<Future<?>> futures = new ArrayList<>();
                    for(Integer i = 0; i < clustersMemoryBytes.size(); i++) {
                      JsonObject clusterMemoryBytesResult = clustersMemoryBytes.get(i);
                      String clusterName = clusterMemoryBytesResult.getJsonObject("metric").getString("cluster");
                      JsonObject clusterCpuCoresResult = clustersCpuCores.stream().filter(cluster -> Objects.equals(clusterName, cluster.getJsonObject("metric").getString("cluster"))).findFirst().orElse(null);
                      JsonObject aiNodeResult = clustersAiNodes.stream().filter(cluster -> Objects.equals(clusterName, cluster.getJsonObject("metric").getString("cluster"))).findFirst().orElse(null);
                      JsonObject gpuDeviceResult = clustersGpuDevices.stream().filter(cluster -> Objects.equals(clusterName, cluster.getJsonObject("metric").getString("cluster"))).findFirst().orElse(null);
                      JsonObject vmResult = clustersVms.stream().filter(cluster -> Objects.equals(clusterName, cluster.getJsonObject("metric").getString("cluster"))).findFirst().orElse(null);
                      futures.add(Future.future(promise1 -> {
                        ClusterEnUSApiServiceImpl.importCluster(vertx, webClient, config, hub, Cluster.CLASS_SIMPLE_NAME, Cluster.CLASS_API_ADDRESS_Cluster, clusterName, clusterMemoryBytesResult, clusterCpuCoresResult, aiNodeResult, gpuDeviceResult, vmResult).onComplete(b -> {
                          promise1.complete();
                        }).onFailure(ex -> {
                          LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
                          promise1.fail(ex);
                        });
                      }));
                    }
                    Future.all(futures).onSuccess(b -> {
                      promise.complete();
                    }).onFailure(ex -> {
                      LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
                      promise.fail(ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
                    promise.fail(ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
                  promise.fail(ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
                promise.fail(ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
            promise.fail(ex);
          });
        } catch(Throwable ex) {
          LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
          promise.fail(ex);
        }
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, Cluster.CLASS_SIMPLE_NAME), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public Future<Void> importHub(JsonObject hubData, String classSimpleName, String classApiAddress, String hubId) {
    Promise<Void> promise = Promise.promise();
    try {
      String hubName = hubData.getString(Hub.VAR_hubName);
      String hubDescription = hubData.getString(Hub.VAR_description);
      String localClusterName = hubData.getString(Hub.VAR_localClusterName);
      String hubResource = String.format("%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId);
      JsonObject body = new JsonObject();
      body.put(Hub.VAR_pk, hubResource);
      body.put(Hub.VAR_hubId, hubId);
      body.put(Hub.VAR_hubName, hubName);
      body.put(Hub.VAR_description, hubDescription);
      body.put(Hub.VAR_hubResource, hubResource);
      body.put(Hub.VAR_localClusterName, localClusterName);

      JsonObject pageParams = new JsonObject();
      pageParams.put("body", body);
      pageParams.put("path", new JsonObject());
      pageParams.put("cookie", new JsonObject());
      pageParams.put("query", new JsonObject().put("softCommit", true).put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
      pageParams.put("scopes", new JsonArray().add("GET").add("POST").add("PATCH").add("PUT"));
      JsonObject pageContext = new JsonObject().put("params", pageParams);
      JsonObject pageRequest = new JsonObject().put("context", pageContext);

      vertx.eventBus().request(classApiAddress, pageRequest, new DeliveryOptions()
          .setSendTimeout(config.getLong(ComputateConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME) * 1000)
          .addHeader("action", String.format("putimport%sFuture", classSimpleName))
          ).onSuccess(message -> {
        importHubAuth(hubId, classSimpleName, classApiAddress, body).onSuccess(a -> {
          LOG.info(String.format("Imported %s Hub", hubId));
          promise.complete();
        }).onFailure(ex -> {
          promise.fail(ex);
        });
      }).onFailure(ex -> {
        promise.fail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public Future<Void> importHubAuth(String hubId, String classSimpleName, String classApiAddress, JsonObject body) {
    Promise<Void> promise = Promise.promise();
    try {
      String groupName = String.format("%s-%s-GET", Hub.CLASS_AUTH_RESOURCE, hubId);
      String resourceName = String.format("%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId);
      String realmName = config.getString(ComputateConfigKeys.AUTH_REALM);
      String clientId = config.getString(ComputateConfigKeys.AUTH_CLIENT);
      String[] defaultScopes = new String[] { "GET", "DELETE", "PATCH", "POST", "SuperAdmin", "Admin", "GETManager", "PUT" };
      obtainKeycloakAdminToken().onSuccess(adminToken -> {
        obtainClientUuid(adminToken, realmName, clientId).onSuccess(clientUuid -> {
          authorizeGroupData(adminToken, realmName, clientId, clientUuid, Hub.CLASS_AUTH_RESOURCE, groupName, new String[] { "GET" }, defaultScopes).onSuccess(a -> {
            LOG.info(String.format("Successfully granted %s access to %s", "GET", resourceName));
            promise.complete();
          }).onFailure(ex -> promise.fail(ex));
        }).onFailure(ex -> promise.fail(ex));
      }).onFailure(ex -> promise.fail(ex));
    } catch(Throwable ex) {
      LOG.error(String.format("Failed to set up the auth token for fine-grained resource permissions for %s", classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  protected Future<Void> importHubsFromEnv(Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest, String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource, String varPageId, String varUserUrl, String varDownload) {
    Promise<Void> promise = Promise.promise();
    try {
      JsonObject hubs = new JsonObject(config.getString(ConfigKeys.HUBS));
      List<Future<?>> futures = new ArrayList<>();
      for(String hubId : hubs.fieldNames()) {
        JsonObject hubData = hubs.getJsonObject(hubId);
        futures.add(Future.future(promise1 -> {
          importHub(hubData, Hub.CLASS_SIMPLE_NAME, Hub.CLASS_API_ADDRESS_Hub, hubId).onComplete(b -> {
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format(importDataFail, Hub.CLASS_SIMPLE_NAME), ex);
            promise1.fail(ex);
          });
        }));
      }
      Future.all(futures).onSuccess(b -> {
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, Hub.CLASS_SIMPLE_NAME), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, Hub.CLASS_SIMPLE_NAME), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  @Override
  public Future<Void> importData(String clientUuid, Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest,
      String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource,
      String varPageId, String varUserUrl, String varDownload) {
    Promise<Void> promise = Promise.promise();
    // ZonedDateTime dateTimeStarted = ZonedDateTime.now();
    importHubsFromEnv(pagePath, vertx, siteRequest, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, varPageId, varUserUrl, varDownload).onSuccess(a -> {
      try {
        String authHostName = config.getString(ConfigKeys.AUTH_HOST_NAME);
        Integer authPort = config.getInteger(ConfigKeys.AUTH_PORT);
        String authTokenUri = config.getString(ConfigKeys.AUTH_TOKEN_URI);
        Boolean authSsl = config.getBoolean(ConfigKeys.AUTH_SSL);
        String authClient = config.getString(ConfigKeys.AUTH_CLIENT_SA);
        String authSecret = config.getString(ConfigKeys.AUTH_SECRET_SA);
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "client_credentials");
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(authClient, authSecret);
        webClient.post(authPort, authHostName, authTokenUri).ssl(authSsl).authentication(credentials)
            .putHeader("Content-Type", "application/json")
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
            .onSuccess(requestAuthResponse -> {
          try {
            // String accessToken = requestAuthResponse.bodyAsJsonObject().getString("access_token");
            // cleanupNonAiNodesTotal(siteRequest, dateTimeStarted, Cluster.CLASS_SIMPLE_NAME, accessToken).onSuccess(oldAiNodes -> {
              promise.complete();
            // }).onFailure(ex -> {
            //   LOG.error(String.format(importDataFail, classSimpleName), ex);
            //   promise.fail(ex);
            // });
          } catch(Throwable ex) {
            LOG.error(String.format(importDataFail, classSimpleName), ex);
            promise.fail(ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format(importDataFail, classSimpleName), ex);
          promise.fail(ex);
        });
      } catch(Throwable ex) {
        LOG.error(String.format(importDataFail, classSimpleName), ex);
        promise.fail(ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    });
    return promise.future();
  }
}

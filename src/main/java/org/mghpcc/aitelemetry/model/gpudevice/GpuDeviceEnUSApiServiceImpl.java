package org.mghpcc.aitelemetry.model.gpudevice;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.search.list.SearchList;
import org.mghpcc.aitelemetry.config.ConfigKeys;
import org.mghpcc.aitelemetry.model.cluster.Cluster;
import org.mghpcc.aitelemetry.model.hub.Hub;
import org.mghpcc.aitelemetry.model.node.AiNode;
import org.mghpcc.aitelemetry.request.SiteRequest;

import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.web.client.WebClient;

/**
 * Translate: false
 **/
public class GpuDeviceEnUSApiServiceImpl extends GpuDeviceEnUSGenApiServiceImpl {

  //////////////////////
  // GpuDevice import //
  //////////////////////

  public static Future<Void> importGpuDeviceData(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson) {
    Promise<Void> promise = Promise.promise();
    String classSimpleName = GpuDevice.CLASS_SIMPLE_NAME;
    String classApiAddress = GpuDevice.CLASS_API_ADDRESS_GpuDevice;
    String hubId = clusterJson.getString(Cluster.VAR_hubId);
    String clusterName = clusterJson.getString(Cluster.VAR_clusterName);
    try {
      String authHostName = config.getString(ConfigKeys.AUTH_HOST_NAME);
      Integer authPort = Integer.parseInt(config.getString(ConfigKeys.AUTH_PORT));
      String authTokenUri = config.getString(ConfigKeys.AUTH_TOKEN_URI);
      Boolean authSsl = Boolean.parseBoolean(config.getString(ConfigKeys.AUTH_SSL));
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
          String hubIdEnv = hubId.toUpperCase().replace("-", "");
          Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
          String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
          Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
          String promKeycloakProxyUri = String.format("/api/v1/query?query=DCGM_FI_DEV_GPU_UTIL{cluster=\"%s\"}", clusterName);

          webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
              .putHeader("Authorization", String.format("Bearer %s", accessToken))
              .send()
              .expecting(HttpResponseExpectation.SC_OK)
              .onSuccess(metricsResponse -> {
            JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
            JsonArray dataResult = Optional.ofNullable(metricsBody.getJsonObject("data")).map(data -> data.getJsonArray("result")).orElse(new JsonArray());
            List<Future<?>> futures = new ArrayList<>();
            dataResult.stream().map(o -> (JsonObject)o).forEach(clusterResult -> {
              futures.add(Future.future(promise1 -> {
                try {
                  JsonObject clusterMetric = clusterResult.getJsonObject("metric");
                  JsonArray clusterValue = clusterResult.getJsonArray("value");
                  String nodeName = clusterMetric.getString("Hostname");
                  String modelName = clusterMetric.getString("modelName");
                  String hubResource = String.format("%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId);
                  String clusterResource = String.format("%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName);
                  String nodeResource = String.format("%s-%s-%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName, AiNode.CLASS_AUTH_RESOURCE, nodeName);
                  Integer gpuDeviceNumber = Integer.parseInt(clusterMetric.getString("gpu"));
                  String gpuDeviceUtilization = clusterValue.getString(1);
                  String gpuDeviceResource = String.format("%s-%s-%s-%s-%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName, AiNode.CLASS_AUTH_RESOURCE, nodeName, GpuDevice.CLASS_AUTH_RESOURCE, gpuDeviceNumber);
                  JsonObject body = new JsonObject();
                  body.put(GpuDevice.VAR_pk, gpuDeviceResource);
                  body.put(GpuDevice.VAR_hubId, hubId);
                  body.put(GpuDevice.VAR_hubResource, hubResource);
                  body.put(GpuDevice.VAR_clusterName, clusterName);
                  body.put(GpuDevice.VAR_clusterResource, clusterResource);
                  body.put(GpuDevice.VAR_nodeName, nodeName);
                  body.put(GpuDevice.VAR_nodeResource, nodeResource);
                  body.put(GpuDevice.VAR_gpuDeviceResource, gpuDeviceResource);
                  body.put(GpuDevice.VAR_gpuDeviceNumber, gpuDeviceNumber.toString());
                  body.put(GpuDevice.VAR_gpuDeviceUtilization, gpuDeviceUtilization);
                  body.put(GpuDevice.VAR_modelName, modelName);

                  JsonObject pageParams = new JsonObject();
                  pageParams.put("body", body);
                  pageParams.put("path", new JsonObject());
                  pageParams.put("cookie", new JsonObject());
                  pageParams.put("query", new JsonObject().put("softCommit", true).put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
                  JsonObject pageContext = new JsonObject().put("params", pageParams);
                  JsonObject pageRequest = new JsonObject().put("context", pageContext);

                  vertx.eventBus().request(classApiAddress, pageRequest, new DeliveryOptions()
                      .setSendTimeout(config.getLong(ComputateConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME) * 1000)
                      .addHeader("action", String.format("putimport%sFuture", classSimpleName))
                      ).onSuccess(message -> {
                    LOG.info(String.format("Imported %s GPU device", gpuDeviceResource));
                    promise1.complete();
                  }).onFailure(ex -> {
                    LOG.error(String.format(importDataFail, classSimpleName), ex);
                    promise1.fail(ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format(importDataFail, classSimpleName), ex);
                  promise1.fail(ex);
                }
              }));
            });
            Future.all(futures).onSuccess(b -> {
              // cleanupGpuDevices(siteRequest, dateTimeStarted, classSimpleName, accessToken).onSuccess(oldAiNodes -> {
                promise.complete();
              // }).onFailure(ex -> {
              //   LOG.error(String.format(importDataFail, classSimpleName), ex);
              //   promise.fail(ex);
              // });
            }).onFailure(ex -> {
              LOG.error(String.format(importDataFail, classSimpleName), ex);
              promise.fail(ex);
            });
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
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<JsonArray> queryGpuDevicesTotalForCluster(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = clusterJson.getString(Cluster.VAR_hubId);
      String clusterName = clusterJson.getString(Cluster.VAR_clusterName);
      String hubIdEnv = hubId.toUpperCase().replace("-", "");
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode(String.format("sum by (cluster, node) (gpu_operator_nvidia_pci_devices_total{cluster=\"%s\"})", clusterName)));

      webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
          .putHeader("Authorization", String.format("Bearer %s", accessToken))
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(metricsResponse -> {
        JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
        promise.complete(Optional.ofNullable(metricsBody.getJsonObject("data")).map(data -> data.getJsonArray("result")).orElse(new JsonArray()));
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, classSimpleName), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<JsonArray> queryGpuDevicesTotalForHub(Vertx vertx, WebClient webClient, JsonObject config, Hub hub, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubIdEnv = hub.getHubId().toUpperCase().replace("-", "");
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode("sum by (cluster) (gpu_operator_nvidia_pci_devices_total)"));

      webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
          .putHeader("Authorization", String.format("Bearer %s", accessToken))
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(metricsResponse -> {
        JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
        promise.complete(Optional.ofNullable(metricsBody.getJsonObject("data")).map(data -> data.getJsonArray("result")).orElse(new JsonArray()));
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, classSimpleName), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<SearchList<GpuDevice>> cleanupGpuDevices(Vertx vertx, WebClient webClient, JsonObject config, ComputateSiteRequest siteRequest, ZonedDateTime dateTimeStarted, String classSimpleName, String accessToken) {
    Promise<SearchList<GpuDevice>> promise = Promise.promise();
    try {
      SearchList<GpuDevice> searchList = new SearchList<GpuDevice>();
      searchList.setStore(true);
      searchList.q("*:*");
      searchList.setC(GpuDevice.class);
      searchList.fq(String.format("modified_docvalues_date:[* TO %s]", GpuDevice.staticSearchCreated((SiteRequest)siteRequest, dateTimeStarted)));
      searchList.promiseDeepForClass(siteRequest).onSuccess(oldGpuDevices -> {
        try {
          List<Future<?>> futures = new ArrayList<>();
          for(Integer i = 0; i < oldGpuDevices.getList().size(); i++) {
            GpuDevice oldGpuDevice = oldGpuDevices.getList().get(i);
            futures.add(Future.future(promise1 -> {
              try {
                String clusterName = oldGpuDevice.getClusterName();
                JsonObject body = new JsonObject();
                body.put("setArchived", true);

                JsonObject pageParams = new JsonObject();
                pageParams.put("body", body);
                pageParams.put("path", new JsonObject());
                pageParams.put("cookie", new JsonObject());
                pageParams.put("query", new JsonObject().put("softCommit", true).put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
                JsonObject pageContext = new JsonObject().put("params", pageParams);
                JsonObject pageRequest = new JsonObject().put("context", pageContext);

                vertx.eventBus().request(GpuDevice.CLASS_API_ADDRESS_GpuDevice, pageRequest, new DeliveryOptions()
                    .setSendTimeout(config.getLong(ComputateConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME) * 1000)
                    .addHeader("action", String.format("patch%sFuture", classSimpleName))
                    ).onSuccess(message -> {
                  LOG.info(String.format("Archived %s GPU node", clusterName));
                  promise1.complete(oldGpuDevices);
                }).onFailure(ex -> {
                  LOG.error(String.format(importDataFail, classSimpleName), ex);
                  promise.fail(ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format(importDataFail, classSimpleName), ex);
                promise1.fail(ex);
              }
            }));
          }
          Future.all(futures).onSuccess(b -> {
            promise.complete();
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
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }
}

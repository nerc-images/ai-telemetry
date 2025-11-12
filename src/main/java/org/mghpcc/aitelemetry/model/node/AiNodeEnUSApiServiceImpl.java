package org.mghpcc.aitelemetry.model.node;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.search.list.SearchList;
import org.mghpcc.aitelemetry.config.ConfigKeys;
import org.mghpcc.aitelemetry.model.cluster.Cluster;
import org.mghpcc.aitelemetry.model.gpudevice.GpuDeviceEnUSApiServiceImpl;
import org.mghpcc.aitelemetry.model.hub.Hub;
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
public class AiNodeEnUSApiServiceImpl extends AiNodeEnUSGenApiServiceImpl {

  ///////////////////
  // AiNode import //
  ///////////////////

  public static Future<Void> importAiNode(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String classApiAddress, JsonObject gpuDeviceResult) {
    Promise<Void> promise = Promise.promise();
    try {
      String clusterName = gpuDeviceResult.getJsonObject("metric").getString("cluster");
      String nodeName = gpuDeviceResult.getJsonObject("metric").getString("node");
      String hubId = clusterJson.getString(AiNode.VAR_hubId);
      String hubResource = String.format("%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId);
      String clusterResource = String.format("%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName);
      String nodeResource = String.format("%s-%s-%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName, AiNode.CLASS_AUTH_RESOURCE, nodeName);
      JsonObject body = new JsonObject();
      body.put(AiNode.VAR_pk, nodeResource);
      body.put(AiNode.VAR_hubId, hubId);
      body.put(AiNode.VAR_hubResource, hubResource);
      body.put(AiNode.VAR_clusterName, clusterName);
      body.put(AiNode.VAR_clusterResource, clusterResource);
      body.put(AiNode.VAR_nodeName, nodeName);
      body.put(AiNode.VAR_nodeResource, nodeResource);
      body.put(AiNode.VAR_gpuDevicesTotal, gpuDeviceResult.getJsonArray("value").getString(1));

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
        LOG.info(String.format("Imported %s-%s AI node", clusterName, nodeName));
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, classSimpleName), ex);
        promise.fail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<Void> importAiNodeData(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson) {
    Promise<Void> promise = Promise.promise();
    String classSimpleName = AiNode.CLASS_SIMPLE_NAME;
    String classApiAddress = AiNode.CLASS_API_ADDRESS_AiNode;
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
          GpuDeviceEnUSApiServiceImpl.queryGpuDevicesTotalForCluster(vertx, webClient, config, clusterJson, classSimpleName, accessToken).onSuccess(gpuDevicesTotal -> {
            List<Future<?>> futures = new ArrayList<>();
            for(Integer i = 0; i < gpuDevicesTotal.size(); i++) {
              JsonObject gpuDeviceResult = gpuDevicesTotal.getJsonObject(i);
              futures.add(Future.future(promise1 -> {
                try {
                  AiNodeEnUSApiServiceImpl.importAiNode(vertx, webClient, config, clusterJson, classSimpleName, classApiAddress, gpuDeviceResult).onSuccess(b -> {
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
            }
            Future.all(futures).onSuccess(b -> {
              promise.complete();
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

  public static Future<JsonArray> queryAiNodesTotal(Vertx vertx, WebClient webClient, JsonObject config, Hub hub, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubIdEnv = hub.getHubId().toUpperCase().replace("-", "");
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=gpu_operator_gpu_nodes_total");

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

  public static Future<SearchList<Cluster>> cleanupNonAiNodesTotal(Vertx vertx, WebClient webClient, JsonObject config, ComputateSiteRequest siteRequest, ZonedDateTime dateTimeStarted, String classSimpleName, String accessToken) {
    Promise<SearchList<Cluster>> promise = Promise.promise();
    try {
      SearchList<Cluster> searchList = new SearchList<Cluster>();
      searchList.setStore(true);
      searchList.q("*:*");
      searchList.setC(Cluster.class);
      searchList.fq(String.format("modified_docvalues_date:[* TO %s]", Cluster.staticSearchCreated((SiteRequest)siteRequest, dateTimeStarted)));
      searchList.promiseDeepForClass(siteRequest).onSuccess(oldClusters -> {
        try {
          List<Future<?>> futures = new ArrayList<>();
          for(Integer i = 0; i < oldClusters.getList().size(); i++) {
            Cluster oldCluster = oldClusters.getList().get(i);
            futures.add(Future.future(promise1 -> {
              try {
                String clusterName = oldCluster.getClusterName();
                JsonObject body = new JsonObject();
                body.put(Cluster.VAR_clusterName, clusterName);
                body.put(Cluster.VAR_aiNodesTotal, 0);
                body.put(Cluster.VAR_gpuDevicesTotal, 0);

                JsonObject pageParams = new JsonObject();
                pageParams.put("body", body);
                pageParams.put("path", new JsonObject());
                pageParams.put("cookie", new JsonObject());
                pageParams.put("query", new JsonObject().put("softCommit", true).put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
                JsonObject pageContext = new JsonObject().put("params", pageParams);
                JsonObject pageRequest = new JsonObject().put("context", pageContext);

                vertx.eventBus().request(Cluster.CLASS_API_ADDRESS_Cluster, pageRequest, new DeliveryOptions()
                    .setSendTimeout(config.getLong(ComputateConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME) * 1000)
                    .addHeader("action", String.format("putimport%sFuture", classSimpleName))
                    ).onSuccess(message -> {
                  LOG.info(String.format("Imported %s AI cluster", clusterName));
                  promise1.complete(oldClusters);
                }).onFailure(ex -> {
                  LOG.error(String.format(importDataFail, classSimpleName), ex);
                  promise1.fail(ex);
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

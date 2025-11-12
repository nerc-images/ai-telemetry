package org.mghpcc.aitelemetry.model.virtualmachine;

import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.sqlclient.Pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.mghpcc.aitelemetry.config.ConfigKeys;
import org.mghpcc.aitelemetry.model.cluster.Cluster;
import org.mghpcc.aitelemetry.model.hub.Hub;
import org.mghpcc.aitelemetry.model.node.AiNode;
import org.mghpcc.aitelemetry.model.project.Project;

import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import com.hubspot.jinjava.Jinjava;

/**
 * Translate: false
 **/
public class VirtualMachineEnUSApiServiceImpl extends VirtualMachineEnUSGenApiServiceImpl {

  ///////////////////////////
  // VirtualMachine import //
  ///////////////////////////

  public static Future<Void> importVirtualMachineData(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson) {
    Promise<Void> promise = Promise.promise();
    String classSimpleName = VirtualMachine.CLASS_SIMPLE_NAME;
    String classApiAddress = VirtualMachine.CLASS_API_ADDRESS_VirtualMachine;
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
          String promKeycloakProxyUri = String.format("/api/v1/query?query=kubevirt_vmi_info{cluster=\"%s\"}", clusterName);

          webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
              .putHeader("Authorization", String.format("Bearer %s", accessToken))
              .send()
              .expecting(HttpResponseExpectation.SC_OK)
              .onSuccess(metricsResponse -> {
            JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
            JsonArray dataResult = metricsBody.getJsonObject("data").getJsonArray("result");
            List<Future<?>> futures = new ArrayList<>();
            dataResult.stream().map(o -> (JsonObject)o).forEach(vmMetrics -> {
              futures.add(Future.future(promise1 -> {
                importVirtualMachine(vertx, webClient, config, clusterJson, classSimpleName, classApiAddress, vmMetrics).onSuccess(vmBody -> {
                  LOG.info(String.format("Imported %s virtual machine", vmBody.getString(VirtualMachine.VAR_vmResource)));
                  promise1.complete();
                }).onFailure(ex -> {
                  LOG.error(String.format(importDataFail, classSimpleName), ex);
                  promise1.fail(ex);
                });
              }));
            });
            Future.all(futures).onSuccess(b -> {
              // cleanupVirtualMachines(siteRequest, dateTimeStarted, classSimpleName, accessToken).onSuccess(oldAiNodes -> {
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

  public static Future<JsonObject> importVirtualMachine(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String classApiAddress, JsonObject vmMetrics) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      JsonObject vmMetric = vmMetrics.getJsonObject("metric");
      JsonArray vmValue = vmMetrics.getJsonArray("value");
      String clusterName = vmMetric.getString("cluster");
      String vmName = vmMetric.getString("name");
      String vmProject = vmMetric.getString("namespace");
      String os = vmMetric.getString("os");
      String hubId = clusterJson.getString(VirtualMachine.VAR_hubId);
      String hubResource = String.format("%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId);
      String clusterResource = String.format("%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName);
      String vmResource = String.format("%s-%s-%s-%s-%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName, Project.CLASS_AUTH_RESOURCE, vmProject, VirtualMachine.CLASS_AUTH_RESOURCE, vmName);
      JsonObject body = new JsonObject();
      body.put(VirtualMachine.VAR_pk, vmResource);
      body.put(VirtualMachine.VAR_hubId, hubId);
      body.put(VirtualMachine.VAR_hubResource, hubResource);
      body.put(VirtualMachine.VAR_clusterName, clusterName);
      body.put(VirtualMachine.VAR_clusterResource, clusterResource);
      body.put(VirtualMachine.VAR_vmProject, vmProject);
      body.put(VirtualMachine.VAR_vmName, vmName);
      body.put(VirtualMachine.VAR_vmResource, vmResource);
      body.put(VirtualMachine.VAR_os, os);

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
        LOG.info(String.format("Imported %s-%s AI node", clusterName, vmName));
        promise.complete(body);
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

  public static Future<JsonArray> queryVmsTotal(Vertx vertx, WebClient webClient, JsonObject config, Hub hub, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubIdEnv = hub.getHubId().toUpperCase().replace("-", "");
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=kubevirt_vmi_info");

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

  public static Future<JsonArray> queryVmsTotalForHub(Vertx vertx, WebClient webClient, JsonObject config, Hub hub, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubIdEnv = hub.getHubId().toUpperCase().replace("-", "");
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode("sum by (cluster) (kubevirt_vmi_info)"));

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

  public static Future<JsonArray> queryVmsTotalForCluster(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = clusterJson.getString(Cluster.VAR_hubId);
      String clusterName = clusterJson.getString(Cluster.VAR_clusterName);
      String hubIdEnv = hubId.toUpperCase().replace("-", "");
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode(String.format("sum by (cluster) (kubevirt_vmi_info{cluster=\"%s\"})", clusterName)));

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
}

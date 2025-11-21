package org.mghpcc.aitelemetry.model.cluster;

import java.net.URLEncoder;
import java.util.Optional;
import java.util.stream.Collectors;

import org.computate.search.tool.SearchTool;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.search.list.SearchList;
import org.mghpcc.aitelemetry.config.ConfigKeys;
import org.mghpcc.aitelemetry.model.gpudevice.GpuDeviceEnUSApiServiceImpl;
import org.mghpcc.aitelemetry.model.hub.Hub;
import org.mghpcc.aitelemetry.model.node.AiNodeEnUSApiServiceImpl;
import org.mghpcc.aitelemetry.model.project.Project;
import org.mghpcc.aitelemetry.model.project.ProjectEnUSApiServiceImpl;
import org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachineEnUSApiServiceImpl;
import org.mghpcc.aitelemetry.request.SiteRequest;

import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClient;

/**
 * Translate: false
 **/
public class ClusterEnUSApiServiceImpl extends ClusterEnUSGenApiServiceImpl {

  @Override
  public void editpageClusterPageInit(JsonObject ctx, ClusterPage page, SearchList<Cluster> listCluster, Promise<Void> promise) {
    try {
      Cluster result = page.getResult();
      if(result == null) {
        promise.complete();
      } else {
        SiteRequest siteRequest = page.getSiteRequest_();
        SearchList<Project> searchList = new SearchList<Project>();
        searchList.setStore(true);
        searchList.q("*:*");
        searchList.setC(Project.class);
        searchList.setSiteRequest_(siteRequest);
        searchList.facetMinCount(1);
        searchList.rows(100);
        searchList.fq("clusterResource_docvalues_string:" + SearchTool.escapeQueryChars(result.getClusterResource()));
        searchList.bf("sum(podRestartCount_docvalues_int)");
        searchList.bf("sum(fullPvcsCount_docvalues_int)");
        searchList.defType("edismax");
        searchList.promiseDeepForClass(siteRequest).onSuccess(searchList2 -> {
          ctx.put("clusterProjects", searchList.getList().stream()
              .map(project -> JsonObject.mapFrom(project).getMap())
              .collect(Collectors.toList())
              );
          promise.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("searchProject failed. "), ex);
          promise.fail(ex);
        });
      }
    } catch(Exception ex) {
      LOG.error(String.format("searchProject failed. "), ex);
      promise.fail(ex);
    }
  }

  ////////////////////
  // Cluster import //
  ////////////////////

  public static Future<Void> importCluster(Vertx vertx, WebClient webClient, JsonObject config, Hub hub, String classSimpleName, String classApiAddress, String possibleClusterName, JsonObject clusterMemoryBytesResult, JsonObject clusterCpuCoresResult, JsonObject aiNodeResult, JsonObject gpuDeviceResult, JsonObject vmResult) {
    Promise<Void> promise = Promise.promise();
    try {
      String hubId = hub.getHubId();
      Boolean hubCluster = false;
      if("local-cluster".equals(possibleClusterName) 
          && hub.getLocalClusterName() != null) {
        hubCluster = true;
        possibleClusterName = hub.getLocalClusterName();
      }
      String clusterName = possibleClusterName;
      String hubResource = String.format("%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId);
      String clusterResource = String.format("%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse(""));
      JsonObject body = new JsonObject();
      body.put(Cluster.VAR_pk, clusterResource);
      body.put(Cluster.VAR_hubId, hubId);
      body.put(Cluster.VAR_hubResource, hubResource);
      body.put(Cluster.VAR_clusterResource, clusterResource);
      body.put(Cluster.VAR_clusterName, clusterName);
      body.put(Cluster.VAR_hubCluster, hubCluster);
      body.put(Cluster.VAR_aiNodesTotal, Optional.ofNullable(aiNodeResult).map(result -> result.getJsonArray("value").getString(1)).orElse(null));
      body.put(Cluster.VAR_gpuDevicesTotal, Optional.ofNullable(gpuDeviceResult).map(result -> result.getJsonArray("value").getString(1)).orElse(null));
      body.put(Cluster.VAR_cpuCoresTotal, Optional.ofNullable(clusterCpuCoresResult).map(result -> result.getJsonArray("value").getString(1)).orElse(null));
      body.put(Cluster.VAR_memoryBytesTotal, Optional.ofNullable(clusterMemoryBytesResult).map(result -> result.getJsonArray("value").getString(1)).orElse(null));

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
        ClusterEnUSApiServiceImpl.importClusterAuth(vertx, webClient, config, hubId, classSimpleName, classApiAddress, body).onSuccess(a -> {
          ProjectEnUSApiServiceImpl.importProjectData(vertx, webClient, config, body).onSuccess(b -> {
            AiNodeEnUSApiServiceImpl.importAiNodeData(vertx, webClient, config, body).onSuccess(c -> {
              GpuDeviceEnUSApiServiceImpl.importGpuDeviceData(vertx, webClient, config, body).onSuccess(d -> {
                VirtualMachineEnUSApiServiceImpl.importVirtualMachineData(vertx, webClient, config, body).onSuccess(e -> {
                  LOG.info(String.format("Imported %s AI cluster in %s", clusterName, hubId));
                  promise.complete();
                }).onFailure(ex -> {
                  LOG.error(String.format(importDataFail, classSimpleName), ex);
                  promise.fail(ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format(importDataFail, classSimpleName), ex);
                promise.fail(ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format(importDataFail, classSimpleName), ex);
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            LOG.error(String.format(importDataFail, classSimpleName), ex);
            promise.fail(ex);
          });
        }).onFailure(ex -> {
          LOG.error(String.format(importDataFail, classSimpleName), ex);
          promise.fail(ex);
        });
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

  public static Future<Void> importClusterAuth(Vertx vertx, WebClient webClient, JsonObject config, String hubId, String classSimpleName, String classApiAddress, JsonObject body) {
    Promise<Void> promise = Promise.promise();
    try {
      String clusterName = body.getString(Cluster.VAR_clusterName);
      String groupName = String.format("%s-%s-%s-%s-GET", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName);
      String policyId = String.format("%s-%s-%s-%s-GET", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName);
      String policyName = String.format("%s-%s-%s-%s-GET", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName);
      String resourceName = String.format("%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName);
      String permissionName = String.format("%s-%s-%s-%s-GET-permission", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName);
      String resourceDisplayName = String.format("%s %s %s %s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName);
      String authAdminUsername = config.getString(ComputateConfigKeys.AUTH_ADMIN_USERNAME);
      String authAdminPassword = config.getString(ComputateConfigKeys.AUTH_ADMIN_PASSWORD);
      Integer authPort = Integer.parseInt(config.getString(ComputateConfigKeys.AUTH_PORT));
      String authHostName = config.getString(ComputateConfigKeys.AUTH_HOST_NAME);
      Boolean authSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.AUTH_SSL));
      String authRealm = config.getString(ComputateConfigKeys.AUTH_REALM);
      String authClient = config.getString(ComputateConfigKeys.AUTH_CLIENT);
      webClient.post(authPort, authHostName, "/realms/master/protocol/openid-connect/token").ssl(authSsl)
          .sendForm(MultiMap.caseInsensitiveMultiMap()
              .add("username", authAdminUsername)
              .add("password", authAdminPassword)
              .add("grant_type", "password")
              .add("client_id", "admin-cli")
              ).onSuccess(tokenResponse -> {
        try {
          String authToken = tokenResponse.bodyAsJsonObject().getString("access_token");
          webClient.post(authPort, authHostName, String.format("/admin/realms/%s/groups", authRealm)).ssl(authSsl)
              .putHeader("Authorization", String.format("Bearer %s", authToken))
              .sendJson(new JsonObject().put("name", groupName))
              .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
              .onSuccess(createGroupResponse -> {
            try {
              webClient.get(authPort, authHostName, String.format("/admin/realms/%s/groups?exact=true&global=true&first=0&max=1&search=%s", authRealm, URLEncoder.encode(groupName, "UTF-8"))).ssl(authSsl)
                  .putHeader("Authorization", String.format("Bearer %s", authToken))
                  .send()
                  .expecting(HttpResponseExpectation.SC_OK)
                  .onSuccess(groupsResponse -> {
                try {
                  JsonArray groups = Optional.ofNullable(groupsResponse.bodyAsJsonArray()).orElse(new JsonArray());
                  JsonObject group = groups.stream().findFirst().map(o -> (JsonObject)o).orElse(null);
                  if(group != null) {
                    String groupId = group.getString("id");
                    webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/policy/group", authRealm, authClient)).ssl(authSsl)
                        .putHeader("Authorization", String.format("Bearer %s", authToken))
                        .sendJson(new JsonObject().put("id", policyId).put("name", policyName).put("description", String.format("%s group", groupName)).put("groups", new JsonArray().add(groupId)))
                        .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                        .onSuccess(createPolicyResponse -> {
                      webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/resource", authRealm, authClient)).ssl(authSsl)
                          .putHeader("Authorization", String.format("Bearer %s", authToken))
                          .sendJson(new JsonObject()
                              .put("name", resourceName)
                              .put("displayName", resourceDisplayName)
                              .put("scopes", new JsonArray().add("GET").add("PATCH"))
                              )
                          .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                          .onSuccess(createResourceResponse -> {
                        webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/permission/scope", authRealm, authClient)).ssl(authSsl)
                            .putHeader("Authorization", String.format("Bearer %s", authToken))
                            .sendJson(new JsonObject()
                                .put("name", permissionName)
                                .put("description", String.format("GET %s", groupName))
                                .put("decisionStrategy", "AFFIRMATIVE")
                                .put("resources", new JsonArray().add(resourceName))
                                .put("policies", new JsonArray().add(policyName))
                                .put("scopes", new JsonArray().add(String.format("%s-GET", authRealm)))
                                )
                            .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                            .onSuccess(createPermissionResponse -> {
                          LOG.info(String.format("Successfully granted %s access to %s", "GET", resourceName));
                          promise.complete();
                        }).onFailure(ex -> {
                          LOG.error(String.format("Failed to create an auth permission for resource %s. ", resourceName), ex);
                          promise.fail(ex);
                        });
                      }).onFailure(ex -> {
                        LOG.error(String.format("Failed to create an auth resource %s. ", resourceName), ex);
                        promise.fail(ex);
                      });
                    }).onFailure(ex -> {
                      LOG.error(String.format("Failed to create an auth policy for group %s. ", groupName), ex);
                      promise.fail(ex);
                    });
                  } else {
                    Throwable ex = new RuntimeException(String.format("Failed to find group %s", groupName));
                    LOG.error(ex.getMessage(), ex);
                    promise.fail(ex);
                  }
                } catch(Throwable ex) {
                  LOG.error("Failed to set up fine-grained resource permissions. ", ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("Failed to query the group %s. ", groupName), ex);
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error("Failed to set up fine-grained resource permissions. ", ex);
              promise.fail(ex);
            }
          }).onFailure(ex -> {
            LOG.error(String.format("Failed to create the group %s. ", groupName), ex);
            promise.fail(ex);
          });
        } catch(Throwable ex) {
          LOG.error(String.format("Failed to set up the auth token for fine-grained resource permissions for group %s", groupName), ex);
          promise.fail(ex);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("Failed to get an admin token while creating fine-grained resource permissions for group %s", groupName), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format("Failed to set up the auth token for fine-grained resource permissions for %s", classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<JsonArray> queryClusterCapacityMemoryBytes(Vertx vertx, WebClient webClient, JsonObject config, Hub hub, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = hub.getHubId();
      String hubIdEnv = hub.getHubId().toUpperCase().replace("-", "");
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=cluster:capacity_memory_bytes:sum{" + ("openshift-local".equals(hubId) ? "" : "label_node_role_kubernetes_io!=\"master\"") + "}");

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

  public static Future<JsonArray> queryClusterCapacityCpuCores(Vertx vertx, WebClient webClient, JsonObject config, Hub hub, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = hub.getHubId();
      String hubIdEnv = hub.getHubId().toUpperCase().replace("-", "");
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=cluster:capacity_cpu_cores:sum{" + ("openshift-local".equals(hubId) ? "" : "label_node_role_kubernetes_io!=\"master\"") + "}");

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

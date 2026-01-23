package org.mghpcc.aitelemetry.model.project;

import java.net.URLEncoder;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.computate.search.tool.SearchTool;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.search.list.SearchList;
import org.mghpcc.aitelemetry.config.ConfigKeys;
import org.mghpcc.aitelemetry.model.cluster.Cluster;
import org.mghpcc.aitelemetry.model.hub.Hub;
import org.mghpcc.aitelemetry.model.tenant.Tenant;
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
public class ProjectEnUSApiServiceImpl extends ProjectEnUSGenApiServiceImpl {

  // @Override
  // public void editpageProjectPageInit(JsonObject ctx, ProjectPage page, SearchList<Project> listProject, Promise<Void> promise) {
  //   String accessToken = listProject.getSiteRequest_().getUserPrincipal().getString("access_token");
  //   Project project = listProject.first();
  //   if(project != null) {
  //     String hubId = project.getHubId();
  //     String clusterName = project.getClusterName();
  //     String projectName = project.getProjectName();
  //     JsonObject clusterJson = new JsonObject()
  //         .put(Cluster.VAR_hubId, hubId)
  //         .put(Cluster.VAR_clusterName, clusterName)
  //         ;
  //     DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.US);
  //     ZonedDateTime start = page.getDefaultRangeStart();
  //     ZonedDateTime end = page.getDefaultRangeEnd();
  //     String facetRangeGapVal = page.getDefaultRangeGap();
  //     String gapBackInTime = "31d";
  //     String gap = "1d";
  //     switch (facetRangeGapVal) {
  //       case "+1YEAR":
  //         gapBackInTime = String.format("%sd", Duration.between(start, end).toDays());
  //         gap = "1d";
  //         break;
  //       case "+1MONTH":
  //         gapBackInTime = String.format("%sd", Duration.between(start, end).toDays());
  //         gap = "1d";
  //         break;
  //       case "+1DAY":
  //         gapBackInTime = String.format("%sd", Duration.between(start, end).toDays());
  //         gap = "1d";
  //         break;
  //       case "+1HOUR":
  //         gapBackInTime = String.format("%sh", Duration.between(start, end).toHours());
  //         gap = "1h";
  //         break;
  //       case "+1MINUTE":
  //         gapBackInTime = String.format("%sm", Duration.between(start, end).toMinutes());
  //         gap = "1m";
  //         break;
  //       default:
  //         gap = "1d";
  //     }
  //     ProjectEnUSApiServiceImpl.queryGpuProjects(vertx, webClient, config, clusterJson, Project.CLASS_SIMPLE_NAME, accessToken, gapBackInTime, gap).onSuccess(gpuDevicesTotal -> {
  //       JsonObject gpuDeviceResult = gpuDevicesTotal.stream().map(o -> (JsonObject)o).filter(metrics -> 
  //           Objects.equals(clusterName, metrics.getJsonObject("metric").getString("cluster"))
  //           && projectName.equals(metrics.getJsonObject("metric").getString("exported_namespace"))
  //           ).findFirst().orElse(null);
  //       Boolean gpuEnabled = gpuDeviceResult != null;
  //       ctx.put(Project.VAR_gpuEnabled, gpuEnabled);
  //       promise.complete();
  //     }).onFailure(ex -> {
  //       promise.fail(ex);
  //     });
  //   } else {
  //     promise.complete();
  //   }
  // }

  ////////////////////
  // Project import //
  ////////////////////

  public static Future<Void> importProjectData(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson) {
    Promise<Void> promise = Promise.promise();
    String classSimpleName = Project.CLASS_SIMPLE_NAME;
    String classApiAddress = Project.CLASS_API_ADDRESS_Project;
    try {

      String authHostName = config.getString(ConfigKeys.AUTH_HOST_NAME);
      Integer authPort = Integer.parseInt(config.getString(ConfigKeys.AUTH_PORT));
      String authTokenUri = config.getString(ConfigKeys.AUTH_TOKEN_URI);
      Boolean authSsl = Boolean.parseBoolean(config.getString(ConfigKeys.AUTH_SSL));
      String authClient = config.getString(ConfigKeys.AUTH_CLIENT_SA);
      String authSecret = config.getString(ConfigKeys.AUTH_SECRET_SA);
      String hubId = clusterJson.getString(Cluster.VAR_hubId);
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
          ProjectEnUSApiServiceImpl.queryNonOpenShiftProjects(vertx, webClient, config, clusterJson, classSimpleName, accessToken).onSuccess(nonOpenShiftNamespacesTotal -> {
            ProjectEnUSApiServiceImpl.queryGpuProjects(vertx, webClient, config, clusterJson, classSimpleName, accessToken, "31d", "1d").onSuccess(gpuDevicesTotal -> {
              ProjectEnUSApiServiceImpl.queryPodRestarts(vertx, webClient, config, clusterJson, classSimpleName, accessToken).onSuccess(podRestartsResponse -> {
                ProjectEnUSApiServiceImpl.queryPodTerminating(vertx, webClient, config, clusterJson, classSimpleName, accessToken).onSuccess(podTerminatingResponse -> {
                  ProjectEnUSApiServiceImpl.queryInitPodRestarts(vertx, webClient, config, clusterJson, classSimpleName, accessToken).onSuccess(initPodRestartsResponse -> {
                    ProjectEnUSApiServiceImpl.queryPvcsFull(vertx, webClient, config, clusterJson, classSimpleName, accessToken).onSuccess(fullPvcsResponse -> {
                      List<Future<?>> futures = new ArrayList<>();
                      for(Integer i = 0; i < nonOpenShiftNamespacesTotal.size(); i++) {
                        JsonObject namespaceResult = nonOpenShiftNamespacesTotal.getJsonObject(i);
                        String clusterName = namespaceResult.getJsonObject("metric").getString("cluster");
                        String projectName = namespaceResult.getJsonObject("metric").getString("namespace");
                        String namespacePhaseTerminating = namespaceResult.getJsonArray("value").getString(1);
                        Boolean namespaceTerminating = "1".equals(namespacePhaseTerminating);

                        JsonObject gpuDeviceResult = gpuDevicesTotal.stream().map(o -> (JsonObject)o).filter(metrics -> 
                            Objects.equals(clusterName, metrics.getJsonObject("metric").getString("cluster"))
                            && projectName.equals(metrics.getJsonObject("metric").getString("exported_namespace"))
                            ).findFirst().orElse(null);

                        List<JsonObject> podRestartsResults = podRestartsResponse.stream().map(o -> (JsonObject)o).filter(metrics -> 
                            Objects.equals(clusterName, metrics.getJsonObject("metric").getString("cluster"))
                            && projectName.equals(metrics.getJsonObject("metric").getString("namespace"))
                            ).collect(Collectors.toList());
                        Integer podRestartCount = Optional.ofNullable(podRestartsResults).map(l -> l.size()).orElse(0);
                        List<String> podsRestarting = Optional.ofNullable(podRestartsResults).map(l -> 
                            l.stream().map(o -> o.getJsonObject("metric").getString("pod")).collect(Collectors.toList())
                            ).orElse(Arrays.asList());

                        List<JsonObject> podTerminatingResults = podTerminatingResponse.stream().map(o -> (JsonObject)o).filter(metrics -> 
                            Objects.equals(clusterName, metrics.getJsonObject("metric").getString("cluster"))
                            && projectName.equals(metrics.getJsonObject("metric").getString("namespace"))
                            ).collect(Collectors.toList());
                        Integer podTerminatingCount = Optional.ofNullable(podTerminatingResults).map(l -> l.size()).orElse(0);
                        List<String> podsTerminating = Optional.ofNullable(podTerminatingResults).map(l -> 
                            l.stream().map(o -> o.getJsonObject("metric").getString("pod")).collect(Collectors.toList())
                            ).orElse(Arrays.asList());

                        List<JsonObject> initPodRestartsResults = initPodRestartsResponse.stream().map(o -> (JsonObject)o).filter(metrics -> 
                            Objects.equals(clusterName, metrics.getJsonObject("metric").getString("cluster"))
                            && projectName.equals(metrics.getJsonObject("metric").getString("namespace"))
                            ).collect(Collectors.toList());
                        Integer initPodRestartCount = Optional.ofNullable(initPodRestartsResults).map(l -> l.size()).orElse(0);
                        List<String> initPodsRestarting = Optional.ofNullable(initPodRestartsResults).map(l -> 
                            l.stream().map(o -> o.getJsonObject("metric").getString("pod")).collect(Collectors.toList())
                            ).orElse(Arrays.asList());
                        Integer totalPodsRestarting = podRestartCount + initPodRestartCount;
                        Set<String> allPodsRestarting = new HashSet<>();
                        allPodsRestarting.addAll(podsRestarting);
                        allPodsRestarting.addAll(initPodsRestarting);

                        List<JsonObject> fullPvcsResults = fullPvcsResponse.stream().map(o -> (JsonObject)o).filter(metrics -> 
                            Objects.equals(clusterName, metrics.getJsonObject("metric").getString("cluster"))
                            && projectName.equals(metrics.getJsonObject("metric").getString("namespace"))
                            ).collect(Collectors.toList());
                        Integer fullPvcsCount = Optional.ofNullable(fullPvcsResults).map(l -> l.size()).orElse(0);
                        List<String> fullPvcs = Optional.ofNullable(fullPvcsResults).map(l -> 
                            l.stream().map(o -> o.getJsonObject("metric").getString("persistentvolumeclaim")).collect(Collectors.toList())
                            ).orElse(Arrays.asList());

                        if(projectName != null) {
                          futures.add(Future.future(promise1 -> {
                            try {
                              String hubResource = String.format("%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId);
                              String clusterResource = String.format("%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse(""));
                              String projectResource = String.format("%s-%s-%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse(""), Project.CLASS_AUTH_RESOURCE, projectName);
                              JsonObject body = new JsonObject();
                              body.put(Project.VAR_pk, projectResource);
                              body.put(Project.VAR_hubId, hubId);
                              body.put(Project.VAR_hubResource, hubResource);
                              body.put(Project.VAR_clusterName, clusterName);
                              body.put(Project.VAR_clusterResource, clusterResource);
                              body.put(Project.VAR_projectResource, projectResource);
                              body.put(Project.VAR_projectName, projectName);
                              body.put(Project.VAR_gpuEnabled, gpuDeviceResult != null);
                              body.put(Project.VAR_podRestartCount, totalPodsRestarting.toString());
                              body.put(Project.VAR_podsRestarting, new ArrayList<>(allPodsRestarting));
                              body.put(Project.VAR_podTerminatingCount, podTerminatingCount.toString());
                              body.put(Project.VAR_podsTerminating, new ArrayList<>(podsTerminating));
                              body.put(Project.VAR_fullPvcsCount, fullPvcsCount.toString());
                              body.put(Project.VAR_fullPvcs, new ArrayList<>(fullPvcs));
                              body.put(Project.VAR_namespaceTerminating, namespaceTerminating);

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
                                ProjectEnUSApiServiceImpl.importProjectAuth(vertx, webClient, config, hubId, classSimpleName, classApiAddress, body).onSuccess(c -> {
                                  LOG.info(String.format("Imported %s project", projectResource));
                                  promise1.complete();
                                }).onFailure(ex -> {
                                  LOG.error(String.format(importDataFail, classSimpleName), ex);
                                  promise1.fail(ex);
                                });
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

  public static Future<Void> importProjectAuth(Vertx vertx, WebClient webClient, JsonObject config, String hubId, String classSimpleName, String classApiAddress, JsonObject body) {
    Promise<Void> promise = Promise.promise();
    try {
      String clusterName = body.getString(Project.VAR_clusterName);
      String projectName = body.getString(Project.VAR_projectName);
      String groupName = String.format("%s-%s-%s-%s-%s-%s-GET", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse(""), Project.CLASS_AUTH_RESOURCE, projectName);
      String policyId = String.format("%s-%s-%s-%s-%s-%s-GET", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse(""), Project.CLASS_AUTH_RESOURCE, projectName);
      String policyName = String.format("%s-%s-%s-%s-%s-%s-GET", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse(""), Project.CLASS_AUTH_RESOURCE, projectName);
      String resourceName = String.format("%s-%s-%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse(""), Project.CLASS_AUTH_RESOURCE, projectName);
      String permissionName = String.format("%s-%s-%s-%s-%s-%s-GET-permission", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse(""), Project.CLASS_AUTH_RESOURCE, projectName);
      String resourceDisplayName = String.format("%s %s %s %s %s %s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse(""), Project.CLASS_AUTH_RESOURCE, projectName);
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
                        try {
                          webClient.get(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/resource?first=0&max=1&permission=false&name=%s", authRealm, authClient, URLEncoder.encode(resourceName, "UTF-8"))).ssl(authSsl)
                              .putHeader("Authorization", String.format("Bearer %s", authToken))
                              .send()
                              .expecting(HttpResponseExpectation.SC_OK)
                              .onSuccess(resourceResponse -> {
                            try {
                              JsonArray resourceBody = resourceResponse.bodyAsJsonArray();
                              JsonObject resource = resourceBody.getJsonObject(0);
                              String resourceId = resource.getString("_id");
                              SiteRequest siteRequest = new SiteRequest();
                              siteRequest.setConfig(config);
                              siteRequest.setWebClient(webClient);
                              siteRequest.initDeepSiteRequest(siteRequest);
                              siteRequest.addScopes("GET");
                              SearchList<Project> searchList = new SearchList<Project>();
                              searchList.setStore(true);
                              searchList.q("*:*");
                              searchList.fq(String.format("%s:%s", Project.varIndexedProject(Project.VAR_hubId), SearchTool.escapeQueryChars(hubId)));
                              searchList.fq(String.format("%s:%s", Project.varIndexedProject(Project.VAR_clusterName), SearchTool.escapeQueryChars(clusterName)));
                              searchList.fq(String.format("%s:%s", Project.varIndexedProject(Project.VAR_projectName), SearchTool.escapeQueryChars(projectName)));
                              searchList.setC(Project.class);
                              searchList.setSiteRequest_(siteRequest);
                              searchList.promiseDeepForClass(siteRequest).onSuccess(projectList -> {
                                Project first = projectList.getList().stream().findFirst().orElse(null);
                                if(first != null) {
                                  JsonArray policies = new JsonArray();
                                  policies.add(policyName);
                                  String tenantResource = first.getTenantResource();
                                  if(tenantResource != null) {
                                    String tenantPolicyName = String.format("%s-GET", tenantResource);
                                    policies.add(tenantPolicyName);
                                  }

                                  webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/permission/scope", authRealm, authClient)).ssl(authSsl)
                                      .putHeader("Authorization", String.format("Bearer %s", authToken))
                                      .sendJson(new JsonObject()
                                          .put("name", permissionName)
                                          .put("description", String.format("GET %s", groupName))
                                          .put("decisionStrategy", "AFFIRMATIVE")
                                          .put("resources", new JsonArray().add(resourceId))
                                          .put("policies", policies)
                                          .put("scopes", new JsonArray().add(String.format("%s-GET", authRealm)))
                                          )
                                      .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                                      .onSuccess(createPermissionResponse -> {
                                    LOG.info(String.format("Successfully granted %s access to %s", "GET", resourceName));
                                    promise.complete();
                                  }).onFailure(ex -> {
                                    LOG.error(String.format("Failed to create an auth permission %s for resource %s with policies %s. ", permissionName, resourceName, policies), ex);
                                    promise.fail(ex);
                                  });
                                } else {
                                  promise.complete();
                                }
                              }).onFailure(ex -> {
                                LOG.error(String.format("Failed to query project %s. ", projectName), ex);
                                promise.fail(ex);
                              });
                            } catch(Throwable ex) {
                              LOG.error("Failed to set up fine-grained resource permissions. ", ex);
                              promise.fail(ex);
                            }
                          }).onFailure(ex -> {
                            LOG.error(String.format("Failed to query the group %s. ", groupName), ex);
                            promise.fail(ex);
                          });
                        } catch(Throwable ex) {
                          LOG.error(String.format("Failed to create an auth permission for resource %s. ", resourceName), ex);
                          promise.fail(ex);
                        }
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

  public static Future<JsonArray> queryNonOpenShiftProjects(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = clusterJson.getString(Cluster.VAR_hubId);
      String hubIdEnv = hubId.toUpperCase().replace("-", "");
      String clusterName = clusterJson.getString(Cluster.VAR_clusterName);
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode("kube_namespace_status_phase{phase='Terminating', " + ("openshift-local".equals(hubId) ? "" : String.format("cluster='%s'", clusterName)) + "}"));

      webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
          .putHeader("Authorization", String.format("Bearer %s", accessToken))
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(metricsResponse -> {
        JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
        JsonArray results = new JsonArray();
        Optional.ofNullable(metricsBody.getJsonObject("data")).map(data -> data.getJsonArray("result")).orElse(new JsonArray()).stream()
            .map(o -> (JsonObject)o).filter(metrics -> 
            !metrics.getJsonObject("metric").getString("namespace").startsWith("openshift-")
            && !metrics.getJsonObject("metric").getString("namespace").startsWith("open-cluster-management")
            ).forEach(metrics -> results.add(metrics));
        promise.complete(results);
      }).onFailure(ex -> {
        LOG.error(String.format("Querying non-openshift namespaces failed at %s for %s", promKeycloakProxyHostName, promKeycloakProxyUri), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<JsonArray> queryGpuProjects(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String accessToken, String gapBackInTime, String gap) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = clusterJson.getString(Cluster.VAR_hubId);
      String hubIdEnv = hubId.toUpperCase().replace("-", "");
      String clusterName = clusterJson.getString(Cluster.VAR_clusterName);
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode("sum by (cluster, exported_namespace) (sum_over_time((max_over_time(DCGM_FI_DEV_GPU_UTIL{" + ("openshift-local".equals(hubId) ? "" : String.format("cluster='%s', ", clusterName)) + String.format("exported_namespace!=''}[%s:]) >= 0)[%s:%s]))", gap, gapBackInTime, gap)));

      webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
          .putHeader("Authorization", String.format("Bearer %s", accessToken))
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(metricsResponse -> {
        JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
        promise.complete(Optional.ofNullable(metricsBody.getJsonObject("data")).map(data -> data.getJsonArray("result")).orElse(new JsonArray()));
      }).onFailure(ex -> {
        LOG.error(String.format("Querying GPU projects failed at %s for %s", promKeycloakProxyHostName, promKeycloakProxyUri), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<JsonArray> queryPodRestarts(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = clusterJson.getString(Cluster.VAR_hubId);
      String hubIdEnv = hubId.toUpperCase().replace("-", "");
      String clusterName = clusterJson.getString(Cluster.VAR_clusterName);
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode("sum by (cluster, namespace, pod) (round(increase(kube_pod_container_status_restarts_total{" + ("openshift-local".equals(hubId) ? "" : String.format("cluster='%s'", clusterName)) + "}[15m]))) > 0"));

      webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
          .putHeader("Authorization", String.format("Bearer %s", accessToken))
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(metricsResponse -> {
        JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
        promise.complete(Optional.ofNullable(metricsBody.getJsonObject("data")).map(data -> data.getJsonArray("result")).orElse(new JsonArray()));
      }).onFailure(ex -> {
        LOG.error(String.format("Querying pod restarts failed at %s for %s", promKeycloakProxyHostName, promKeycloakProxyUri), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<JsonArray> queryPodTerminating(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = clusterJson.getString(Cluster.VAR_hubId);
      String hubIdEnv = hubId.toUpperCase().replace("-", "");
      String clusterName = clusterJson.getString(Cluster.VAR_clusterName);
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode("time() - kube_pod_deletion_timestamp{job='kube-state-metrics', " + ("openshift-local".equals(hubId) ? "" : String.format("cluster='%s'", clusterName)) + "} > 300"));

      webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
          .putHeader("Authorization", String.format("Bearer %s", accessToken))
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(metricsResponse -> {
        JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
        promise.complete(Optional.ofNullable(metricsBody.getJsonObject("data")).map(data -> data.getJsonArray("result")).orElse(new JsonArray()));
      }).onFailure(ex -> {
        LOG.error(String.format("Querying pods terminating failed at %s for %s", promKeycloakProxyHostName, promKeycloakProxyUri), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<JsonArray> queryInitPodRestarts(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = clusterJson.getString(Cluster.VAR_hubId);
      String hubIdEnv = hubId.toUpperCase().replace("-", "");
      String clusterName = clusterJson.getString(Cluster.VAR_clusterName);
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode("sum by (cluster, namespace, pod) (round(increase(kube_pod_init_container_status_restarts_total{" + ("openshift-local".equals(hubId) ? "" : String.format("cluster='%s'", clusterName)) + "}[15m]))) > 0"));

      webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
          .putHeader("Authorization", String.format("Bearer %s", accessToken))
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(metricsResponse -> {
        JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
        promise.complete(Optional.ofNullable(metricsBody.getJsonObject("data")).map(data -> data.getJsonArray("result")).orElse(new JsonArray()));
      }).onFailure(ex -> {
        LOG.error(String.format("Querying pod restarts failed at %s for %s", promKeycloakProxyHostName, promKeycloakProxyUri), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Future<JsonArray> queryPvcsFull(Vertx vertx, WebClient webClient, JsonObject config, JsonObject clusterJson, String classSimpleName, String accessToken) {
    Promise<JsonArray> promise = Promise.promise();
    try {
      String hubId = clusterJson.getString(Cluster.VAR_hubId);
      String hubIdEnv = hubId.toUpperCase().replace("-", "");
      String clusterName = clusterJson.getString(Cluster.VAR_clusterName);
      Integer promKeycloakProxyPort = Integer.parseInt(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_PORT, hubIdEnv)));
      String promKeycloakProxyHostName = config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_HOST_NAME, hubIdEnv));
      Boolean promKeycloakProxySsl = Boolean.parseBoolean(config.getString(String.format("%s_%s", ConfigKeys.PROM_KEYCLOAK_PROXY_SSL, hubIdEnv)));
      String promKeycloakProxyUri = String.format("/api/v1/query?query=%s", urlEncode("(sum(kubelet_volume_stats_used_bytes{" + ("openshift-local".equals(hubId) ? "" : String.format("cluster='%s'", clusterName)) + "}) by (cluster, namespace, persistentvolumeclaim) / sum(kubelet_volume_stats_capacity_bytes) by (cluster, namespace, persistentvolumeclaim)) > 0.95"));

      webClient.get(promKeycloakProxyPort, promKeycloakProxyHostName, promKeycloakProxyUri).ssl(promKeycloakProxySsl)
          .putHeader("Authorization", String.format("Bearer %s", accessToken))
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(metricsResponse -> {
        JsonObject metricsBody = metricsResponse.bodyAsJsonObject();
        promise.complete(Optional.ofNullable(metricsBody.getJsonObject("data")).map(data -> data.getJsonArray("result")).orElse(new JsonArray()));
      }).onFailure(ex -> {
        LOG.error(String.format("Querying full PVCs failed at %s for %s", promKeycloakProxyHostName, promKeycloakProxyUri), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }
}

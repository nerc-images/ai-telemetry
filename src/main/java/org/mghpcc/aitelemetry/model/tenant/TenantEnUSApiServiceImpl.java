package org.mghpcc.aitelemetry.model.tenant;

import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;

import java.net.URLEncoder;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.computate.search.tool.SearchTool;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.search.list.SearchList;
import org.mghpcc.aitelemetry.config.ConfigKeys;
import org.mghpcc.aitelemetry.model.project.Project;
import org.mghpcc.aitelemetry.request.SiteRequest;

/**
 * Translate: false
 **/
public class TenantEnUSApiServiceImpl extends TenantEnUSGenApiServiceImpl {

  @Override
  public void editpageTenantPageInit(JsonObject ctx, TenantPage page, SearchList<Tenant> listTenant, Promise<Void> promise) {
    try {
      Tenant result = page.getResult();
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
        searchList.fq("tenantResource_docvalues_string:" + SearchTool.escapeQueryChars(result.getTenantResource()));
        searchList.bf("sum(podRestartCount_docvalues_int)");
        searchList.bf("sum(fullPvcsCount_docvalues_int)");
        searchList.bq("namespaceTerminating_docvalues_boolean:true^1.0");
        searchList.defType("edismax");
        searchList.promiseDeepForClass(siteRequest).onSuccess(searchList2 -> {
          ctx.put("listProject", searchList.getList().stream()
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

  @Override
  public Future<Void> authorizeGroupData(String authToken, String classAuthResource, String groupName,
      String[] scopes) {
    // TODO Auto-generated method stub
    return super.authorizeGroupData(authToken, classAuthResource, groupName, scopes);
  }

  public Future<Void> importTenant(JsonObject tenantData, String classSimpleName, String classApiAddress, String tenantId) {
    Promise<Void> promise = Promise.promise();
    try {
      String tenantName = tenantData.getString(Tenant.VAR_tenantName);
      String tenantDescription = tenantData.getString(Tenant.VAR_description);
      String tenantResource = String.format("%s-%s", Tenant.CLASS_AUTH_RESOURCE, tenantId);
      String hubId = tenantData.getString(Tenant.VAR_hubId);
      String clusterName = tenantData.getString(Tenant.VAR_clusterName);
      JsonObject body = new JsonObject();
      body.put(Tenant.VAR_pk, tenantResource);
      body.put(Tenant.VAR_tenantId, tenantId);
      body.put(Tenant.VAR_tenantName, tenantName);
      body.put(Tenant.VAR_hubId, hubId);
      body.put(Tenant.VAR_clusterName, clusterName);
      body.put(Tenant.VAR_description, tenantDescription);
      body.put(Tenant.VAR_tenantResource, tenantResource);

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
        importTenantAuth(tenantId, classSimpleName, classApiAddress, body).onSuccess(a -> {
          LOG.info(String.format("Imported %s Tenant", tenantId));
          promise.complete();
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

  public Future<Void> importTenantAuth(String tenantId, String classSimpleName, String classApiAddress, JsonObject body) {
    Promise<Void> promise = Promise.promise();
    try {
      String groupName = String.format("%s-%s-GET", Tenant.CLASS_AUTH_RESOURCE, tenantId);
      String policyId = String.format("%s-%s-GET", Tenant.CLASS_AUTH_RESOURCE, tenantId);
      String policyName = String.format("%s-%s-GET", Tenant.CLASS_AUTH_RESOURCE, tenantId);
      String resourceName = String.format("%s-%s", Tenant.CLASS_AUTH_RESOURCE, tenantId);
      String permissionName = String.format("%s-%s-GET-permission", Tenant.CLASS_AUTH_RESOURCE, tenantId);
      String resourceDisplayName = String.format("%s %s", Tenant.CLASS_AUTH_RESOURCE, tenantId);
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

  protected Future<Void> importTenantsFromEnv(Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest, String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource, String varPageId, String varUserUrl, String varDownload) {
    Promise<Void> promise = Promise.promise();
    try {
      JsonObject tenants = new JsonObject(config.getString(ConfigKeys.TENANTS));
      List<Future<?>> futures = new ArrayList<>();
      for(String tenantId : tenants.fieldNames()) {
        JsonObject tenantData = tenants.getJsonObject(tenantId);
        futures.add(Future.future(promise1 -> {
          importTenant(tenantData, Tenant.CLASS_SIMPLE_NAME, Tenant.CLASS_API_ADDRESS_Tenant, tenantId).onComplete(b -> {
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format(importDataFail, Tenant.CLASS_SIMPLE_NAME), ex);
            promise1.fail(ex);
          });
        }));
      }
      Future.all(futures).onSuccess(b -> {
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, Tenant.CLASS_SIMPLE_NAME), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, Tenant.CLASS_SIMPLE_NAME), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  @Override
  public Future<Void> importData(Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest, String classCanonicalName,
      String classSimpleName, String classApiAddress, String classAuthResource, String varPageId, String varUserUrl, String varDownload) {
    Promise<Void> promise = Promise.promise();
    importTenantsFromEnv(pagePath, vertx, siteRequest, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, varPageId, varUserUrl, varDownload).onSuccess(a -> {
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
            promise.complete();
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

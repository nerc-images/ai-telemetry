package org.computate.aitelemetry.user;

import java.net.URLEncoder;
import java.text.Normalizer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.computate.search.wrap.Wrap;
import org.computate.aitelemetry.config.ConfigKeys;
import org.computate.aitelemetry.request.SiteRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.model.base.ComputateBaseModel;
import org.computate.aitelemetry.request.SiteRequest;
import java.lang.Object;
import org.computate.aitelemetry.model.BaseModel;
import io.vertx.core.json.JsonObject;
import java.util.Date;
import java.util.Set;
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
import java.lang.Long;
import java.lang.String;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.util.Locale;
import java.time.OffsetDateTime;
import java.lang.Boolean;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.computate.vertx.search.list.SearchList;
import org.computate.search.tool.SearchTool;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;
import org.computate.aitelemetry.request.SiteRequest;
import org.computate.aitelemetry.user.SiteUser;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.search.list.SearchResult;
import org.computate.vertx.verticle.EmailVerticle;
import org.computate.aitelemetry.config.ConfigKeys;
import org.computate.vertx.api.BaseApiServiceImpl;
import io.vertx.ext.web.client.WebClient;
import java.util.Objects;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.core.json.impl.JsonUtil;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import com.hubspot.jinjava.Jinjava;
import io.vertx.core.eventbus.DeliveryOptions;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.computate.search.response.solr.SolrResponse.StatsField;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import java.util.Collection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.apache.commons.lang3.math.NumberUtils;
import io.vertx.ext.web.Router;
import java.nio.file.Path;
import java.nio.file.Files;
import com.google.common.io.Resources;
import java.nio.charset.StandardCharsets;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import org.computate.i18n.I18n;
import org.yaml.snakeyaml.Yaml;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.sqlclient.Transaction;
import io.vertx.sqlclient.SqlConnection;
import io.vertx.sqlclient.Tuple;
import io.vertx.sqlclient.Row;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.AsyncResult;
import java.net.URLEncoder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.CompositeFuture;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpResponseExpectation;
import java.nio.charset.Charset;
import io.vertx.ext.auth.authorization.RoleBasedAuthorization;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.HttpResponse;
import java.util.HashMap;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map.Entry;
import java.util.Iterator;
import org.computate.search.tool.SearchTool;
import org.computate.search.response.solr.SolrResponse;
import java.util.Base64;
import java.time.ZonedDateTime;
import org.apache.commons.lang3.BooleanUtils;
import org.computate.vertx.search.list.SearchList;
import org.computate.aitelemetry.user.SiteUserPage;


/**
 * Translate: false
 * Generated: true
 **/
public class SiteUserEnUSGenApiServiceImpl extends BaseApiServiceImpl implements SiteUserEnUSGenApiService {

  protected static final Logger LOG = LoggerFactory.getLogger(SiteUserEnUSGenApiServiceImpl.class);

  // Search //

  @Override
  public void searchSiteUser(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = true;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        SiteUser.authorizationSiteUser(siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          SiteUser.authorizationScopesSiteUser(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchSiteUserList(siteRequest2, false, true, false, "GET").onSuccess(listSiteUser -> {
              response200SearchSiteUser(listSiteUser).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchSiteUser succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchSiteUser failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchSiteUser failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchSiteUser failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("searchSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200SearchSiteUser(SearchList<SiteUser> listSiteUser) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listSiteUser.getSiteRequest_(SiteRequest.class);
      List<String> fls = listSiteUser.getRequest().getFields();
      JsonObject json = new JsonObject();
      JsonArray l = new JsonArray();
      List<String> scopes = siteRequest.getScopes();
      listSiteUser.getList().stream().forEach(o -> {
        JsonObject json2 = JsonObject.mapFrom(o);
        if(fls.size() > 0) {
          Set<String> fieldNames = new HashSet<String>();
          for(String fieldName : json2.fieldNames()) {
            String v = SiteUser.varIndexedSiteUser(fieldName);
            if(v != null)
              fieldNames.add(SiteUser.varIndexedSiteUser(fieldName));
          }
          if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves_docvalues_strings")) {
            fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves_docvalues_strings")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
            fieldNames.remove("pk_docvalues_long");
            fieldNames.remove("created_docvalues_date");
          }
          else if(fls.size() >= 1) {
            fieldNames.removeAll(fls);
          }
          for(String fieldName : fieldNames) {
            if(!fls.contains(fieldName))
              json2.remove(fieldName);
          }
        }
        l.add(json2);
      });
      json.put("list", l);
      response200Search(listSiteUser.getRequest(), listSiteUser.getResponse(), json);
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchSiteUser(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
    if(pivots != null) {
      for(SolrResponse.Pivot pivotField : pivots) {
        String entityIndexed = pivotField.getField();
        String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
        JsonObject pivotJson = new JsonObject();
        pivotArray.add(pivotJson);
        pivotJson.put("field", entityVar);
        pivotJson.put("value", pivotField.getValue());
        pivotJson.put("count", pivotField.getCount());
        Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
        List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
        if(pivotRanges != null) {
          JsonObject rangeJson = new JsonObject();
          pivotJson.put("ranges", rangeJson);
          for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
            JsonObject rangeFacetJson = new JsonObject();
            String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
            rangeJson.put(rangeFacetVar, rangeFacetJson);
            JsonObject rangeFacetCountsObject = new JsonObject();
            rangeFacetJson.put("counts", rangeFacetCountsObject);
            rangeFacet.getCounts().forEach((value, count) -> {
              rangeFacetCountsObject.put(value, count);
            });
          }
        }
        if(pivotFields2 != null) {
          JsonArray pivotArray2 = new JsonArray();
          pivotJson.put("pivot", pivotArray2);
          responsePivotSearchSiteUser(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // PATCH //

  @Override
  public void patchSiteUser(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("patchSiteUser started. "));
    Boolean classPublicRead = true;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("username", config.getString(ComputateConfigKeys.AUTH_ADMIN_USERNAME));
        form.add("password", config.getString(ComputateConfigKeys.AUTH_ADMIN_PASSWORD));
        form.add("grant_type", "password");
        form.add("client_id", "admin-cli");
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , "/realms/master/protocol/openid-connect/token"
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .sendForm(form)
        .onSuccess(adminTokenResponse -> {
          try {
            String adminAuthToken = adminTokenResponse.bodyAsJsonObject().getString("access_token");
            String authRealm = config.getString(ComputateConfigKeys.AUTH_REALM);
            String userId = siteRequest.getUserId();
            webClient.get(
                config.getInteger(ComputateConfigKeys.AUTH_PORT)
                , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
                , String.format("/admin/realms/%s/users/%s", authRealm, userId)
                )
                .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
                .putHeader("Authorization", String.format("Bearer %s", adminAuthToken))
                .send()
                .expecting(HttpResponseExpectation.SC_OK)
            .onSuccess(userResponse -> {
              try {
                JsonObject userBody = userResponse.bodyAsJsonObject();
                if(userBody.getJsonObject("attributes") == null)
                  userBody.put("attributes", new JsonObject());
                body.stream().filter(entry -> entry.getKey().startsWith("set")).forEach(entry -> {
                  JsonArray attributes = new JsonArray();
                  if(!(entry.getValue() instanceof Boolean) || (Boolean)entry.getValue())
                    attributes.add(entry.getValue());
                  userBody.getJsonObject("attributes").put(StringUtils.uncapitalize(entry.getKey().substring(3)), attributes);
                });
                webClient.put(
                    config.getInteger(ComputateConfigKeys.AUTH_PORT)
                    , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
                    , String.format("/admin/realms/%s/users/%s", authRealm, userId)
                    )
                    .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
                    .putHeader("Authorization", String.format("Bearer %s", adminAuthToken))
                    .putHeader("Content-Type", "application/json")
                    .sendJsonObject(userBody)
                    .expecting(HttpResponseExpectation.SC_NO_CONTENT)
                .onSuccess(userUpdateResponse -> {
                  try {
                    response200PATCHSiteUser(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("patchSiteUser succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("patchSiteUser failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  } catch(Throwable ex) {
                    LOG.error(String.format("patchSiteUser failed. "), ex);
                    error(null, eventHandler, ex);
                  }
                }).onFailure(ex -> {
                  LOG.error(String.format("patchSiteUser failed. "), ex);
                  error(null, eventHandler, ex);
                });
              } catch(Throwable ex) {
                LOG.error(String.format("patchSiteUser failed. "), ex);
                error(null, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("patchSiteUser failed. "), ex);
              error(null, eventHandler, ex);
            });
          } catch(Throwable ex) {
            LOG.error(String.format("patchSiteUser failed. "), ex);
            error(null, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("patchSiteUser failed. "), ex);
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("patchSiteUser failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("patchSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPATCHSiteUser(ApiRequest apiRequest, SearchList<SiteUser> listSiteUser) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listSiteUser.getSiteRequest_(SiteRequest.class);
    listSiteUser.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      SiteUser o2 = jsonObject.mapTo(SiteUser.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        patchSiteUserFuture(o2, false).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listPATCHSiteUser failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listSiteUser.next().onSuccess(next -> {
        if(next) {
          listPATCHSiteUser(apiRequest, listSiteUser).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPATCHSiteUser failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listPATCHSiteUser failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listPATCHSiteUser failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void patchSiteUserFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = true;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        siteRequest.setJsonObject(body);
        serviceRequest.getParams().getJsonObject("query").put("rows", 1);
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        searchSiteUserList(siteRequest, false, true, true, "PATCH").onSuccess(listSiteUser -> {
          try {
            SiteUser o = listSiteUser.first();
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setRows(1L);
            apiRequest.setNumFound(1L);
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest);
            siteRequest.setApiRequest_(apiRequest);
            Boolean refresh = Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L;
            if(refresh) {
              siteRequest.getRequestVars().put( "refresh", "false" );
            }
            SiteUser o2;
            if(o != null) {
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listSiteUser.first()).map(o3 -> o3.getUserId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listSiteUser.first()).map(o3 -> o3.getSolrId()).orElse(null));
              JsonObject jsonObject = JsonObject.mapFrom(o);
              o2 = jsonObject.mapTo(SiteUser.class);
              o2.setSiteRequest_(siteRequest);
              patchSiteUserFuture(o2, false).onSuccess(o3 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else if(refresh) {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            } else {
              String m = String.format("%s %s not found", "site user", null);
              eventHandler.handle(Future.failedFuture(m));
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchSiteUser failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("patchSiteUser failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("patchSiteUser failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<SiteUser> patchSiteUserFuture(SiteUser o, Boolean inheritPrimaryKey) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<SiteUser> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<SiteUser> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsSiteUser(siteRequest).onSuccess(a -> {
          upsertSiteUser(o, inheritPrimaryKey, true).onSuccess(c -> {
            sqlPATCHSiteUser(o, inheritPrimaryKey).onSuccess(siteUser -> {
              persistSiteUser(siteUser, true).onSuccess(d -> {
                relateSiteUser(siteUser).onSuccess(e -> {
                  indexSiteUser(siteUser).onSuccess(o2 -> {
                    if(apiRequest != null) {
                      apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                      if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                        o2.apiRequestSiteUser();
                        if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                          eventBus.publish("websocketSiteUser", JsonObject.mapFrom(apiRequest).toString());
                      }
                    }
                    promise1.complete(siteUser);
                  }).onFailure(ex -> {
                    promise1.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise1.tryFail(ex);
                });
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }).onFailure(ex -> {
            promise1.tryFail(ex);
          });
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(siteUser -> {
        Promise<SiteUser> promise2 = Promise.promise();
        refreshSiteUser(siteUser).onSuccess(a -> {
          promise2.complete(siteUser);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(siteUser -> {
        promise.complete(siteUser);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("patchSiteUserFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SiteUser> sqlPATCHSiteUser(SiteUser o, Boolean inheritPrimaryKey) {
    Promise<SiteUser> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE SiteUser SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Set<String> methodNames = jsonObject.fieldNames();
      SiteUser o2 = new SiteUser();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      for(String entityVar : methodNames) {
        switch(entityVar) {
          case "setUserId":
              o2.setUserId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_userId + "=$" + num);
              num++;
              bParams.add(o2.sqlUserId());
            break;
          case "setUserName":
              o2.setUserName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_userName + "=$" + num);
              num++;
              bParams.add(o2.sqlUserName());
            break;
          case "setUserEmail":
              o2.setUserEmail(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_userEmail + "=$" + num);
              num++;
              bParams.add(o2.sqlUserEmail());
            break;
          case "setUserFirstName":
              o2.setUserFirstName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_userFirstName + "=$" + num);
              num++;
              bParams.add(o2.sqlUserFirstName());
            break;
          case "setUserLastName":
              o2.setUserLastName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_userLastName + "=$" + num);
              num++;
              bParams.add(o2.sqlUserLastName());
            break;
          case "setUserFullName":
              o2.setUserFullName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_userFullName + "=$" + num);
              num++;
              bParams.add(o2.sqlUserFullName());
            break;
          case "setUserProfileUrl":
              o2.setUserProfileUrl(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_userProfileUrl + "=$" + num);
              num++;
              bParams.add(o2.sqlUserProfileUrl());
            break;
          case "setSeeArchived":
              o2.setSeeArchived(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_seeArchived + "=$" + num);
              num++;
              bParams.add(o2.sqlSeeArchived());
            break;
          case "setDisplayName":
              o2.setDisplayName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_displayName + "=$" + num);
              num++;
              bParams.add(o2.sqlDisplayName());
            break;
          case "setSiteFontSize":
              o2.setSiteFontSize(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_siteFontSize + "=$" + num);
              num++;
              bParams.add(o2.sqlSiteFontSize());
            break;
          case "setSiteTheme":
              o2.setSiteTheme(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_siteTheme + "=$" + num);
              num++;
              bParams.add(o2.sqlSiteTheme());
            break;
          case "setCustomerProfileId":
              o2.setCustomerProfileId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_customerProfileId + "=$" + num);
              num++;
              bParams.add(o2.sqlCustomerProfileId());
            break;
          case "setCreated":
              o2.setCreated(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_created + "=$" + num);
              num++;
              bParams.add(o2.sqlCreated());
            break;
          case "setArchived":
              o2.setArchived(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_archived + "=$" + num);
              num++;
              bParams.add(o2.sqlArchived());
            break;
          case "setSessionId":
              o2.setSessionId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_sessionId + "=$" + num);
              num++;
              bParams.add(o2.sqlSessionId());
            break;
          case "setUserKey":
              o2.setUserKey(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_userKey + "=$" + num);
              num++;
              bParams.add(o2.sqlUserKey());
            break;
          case "setObjectTitle":
              o2.setObjectTitle(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_objectTitle + "=$" + num);
              num++;
              bParams.add(o2.sqlObjectTitle());
            break;
          case "setApiUrl":
              o2.setApiUrl(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_apiUrl + "=$" + num);
              num++;
              bParams.add(o2.sqlApiUrl());
            break;
          case "setDisplayPage":
              o2.setDisplayPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_displayPage + "=$" + num);
              num++;
              bParams.add(o2.sqlDisplayPage());
            break;
          case "setEditPage":
              o2.setEditPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_editPage + "=$" + num);
              num++;
              bParams.add(o2.sqlEditPage());
            break;
          case "setUserPage":
              o2.setUserPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_userPage + "=$" + num);
              num++;
              bParams.add(o2.sqlUserPage());
            break;
          case "setDownload":
              o2.setDownload(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SiteUser.VAR_download + "=$" + num);
              num++;
              bParams.add(o2.sqlDownload());
            break;
        }
      }
      bSql.append(" WHERE pk=$" + num);
      if(bParams.size() > 0) {
        bParams.add(pk);
        num++;
        futures2.add(0, Future.future(a -> {
          sqlConnection.preparedQuery(bSql.toString())
              .execute(Tuple.tuple(bParams)
              ).onSuccess(b -> {
            a.handle(Future.succeededFuture());
          }).onFailure(ex -> {
            RuntimeException ex2 = new RuntimeException("value SiteUser failed", ex);
            LOG.error(String.format("relateSiteUser failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          SiteUser o3 = new SiteUser();
          o3.setSiteRequest_(o.getSiteRequest_());
          o3.setPk(pk);
          promise.complete(o3);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPATCHSiteUser failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPATCHSiteUser failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPATCHSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200PATCHSiteUser(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PATCHSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // POST //

  @Override
  public void postSiteUser(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("postSiteUser started. "));
    Boolean classPublicRead = true;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        SiteUser.authorizationSiteUser(siteRequest, webClient, classPublicRead, "POST", "POST", "POST").onSuccess(authorizationDecisionResponse -> {
          SiteUser.authorizationScopesSiteUser(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "POST", "POST", "POST").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setRows(1L);
            apiRequest.setNumFound(1L);
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest2);
            siteRequest2.setApiRequest_(apiRequest);
            eventBus.publish("websocketSiteUser", JsonObject.mapFrom(apiRequest).toString());
            JsonObject params = new JsonObject();
            params.put("body", siteRequest2.getJsonObject());
            params.put("path", new JsonObject());
            params.put("scopes", scopes2);
            params.put("cookie", siteRequest2.getServiceRequest().getParams().getJsonObject("cookie"));
            params.put("header", siteRequest2.getServiceRequest().getParams().getJsonObject("header"));
            params.put("form", new JsonObject());
            JsonObject query = new JsonObject();
            Boolean softCommit = Optional.ofNullable(siteRequest2.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
            Integer commitWithin = Optional.ofNullable(siteRequest2.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
            if(softCommit == null && commitWithin == null)
              softCommit = true;
            if(softCommit != null)
              query.put("softCommit", softCommit);
            if(commitWithin != null)
              query.put("commitWithin", commitWithin);
            params.put("query", query);
            JsonObject context = new JsonObject().put("params", params).put("user", siteRequest2.getUserPrincipal());
            JsonObject json = new JsonObject().put("context", context);
            eventBus.request(SiteUser.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postSiteUserFuture")).onSuccess(a -> {
              JsonObject responseMessage = (JsonObject)a.body();
              JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
              apiRequest.setSolrId(responseBody.getString(SiteUser.VAR_solrId));
              response200POSTSiteUser(siteRequest2, responseBody).onSuccess(response -> {
                LOG.debug(String.format("postSiteUser succeeded. "));
                eventHandler.handle(Future.succeededFuture(response));
              }).onFailure(ex -> {
                LOG.error(String.format("postSiteUser failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("postSiteUser failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("postSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postSiteUser failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("postSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  @Override
  public void postSiteUserFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = true;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setRows(1L);
        apiRequest.setNumFound(1L);
        apiRequest.setNumPATCH(0L);
        apiRequest.initDeepApiRequest(siteRequest);
        siteRequest.setApiRequest_(apiRequest);
        if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
          siteRequest.getRequestVars().put( "refresh", "false" );
        }
        postSiteUserFuture(siteRequest, false).onSuccess(o -> {
          eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
        }).onFailure(ex -> {
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Throwable ex) {
        LOG.error(String.format("postSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postSiteUser failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("postSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<SiteUser> postSiteUserFuture(SiteRequest siteRequest, Boolean userId) {
    Promise<SiteUser> promise = Promise.promise();

    try {
      pgPool.withTransaction(sqlConnection -> {
        Promise<SiteUser> promise1 = Promise.promise();
        siteRequest.setSqlConnection(sqlConnection);
        varsSiteUser(siteRequest).onSuccess(a -> {
          createSiteUser(siteRequest).onSuccess(siteUser -> {
            upsertSiteUser(siteUser, userId, false).onSuccess(b -> {
              sqlPOSTSiteUser(siteUser, userId).onSuccess(c -> {
                persistSiteUser(siteUser, false).onSuccess(d -> {
                  relateSiteUser(siteUser).onSuccess(e -> {
                    indexSiteUser(siteUser).onSuccess(o2 -> {
                      promise1.complete(siteUser);
                    }).onFailure(ex -> {
                      promise1.tryFail(ex);
                    });
                  }).onFailure(ex -> {
                    promise1.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise1.tryFail(ex);
                });
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }).onFailure(ex -> {
            promise1.tryFail(ex);
          });
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(siteUser -> {
        Promise<SiteUser> promise2 = Promise.promise();
        refreshSiteUser(siteUser).onSuccess(a -> {
          try {
            ApiRequest apiRequest = siteRequest.getApiRequest_();
            if(apiRequest != null) {
              apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
              siteUser.apiRequestSiteUser();
              eventBus.publish("websocketSiteUser", JsonObject.mapFrom(apiRequest).toString());
            }
            promise2.complete(siteUser);
          } catch(Exception ex) {
            LOG.error(String.format("postSiteUserFuture failed. "), ex);
            promise2.tryFail(ex);
          }
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(siteUser -> {
        try {
          ApiRequest apiRequest = siteRequest.getApiRequest_();
          if(apiRequest != null) {
            apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
            siteUser.apiRequestSiteUser();
            eventBus.publish("websocketSiteUser", JsonObject.mapFrom(apiRequest).toString());
          }
          promise.complete(siteUser);
        } catch(Exception ex) {
          LOG.error(String.format("postSiteUserFuture failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("postSiteUserFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SiteUser> sqlPOSTSiteUser(SiteUser o, Boolean inheritPrimaryKey) {
    Promise<SiteUser> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE SiteUser SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      SiteUser o2 = new SiteUser();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(siteRequest.getSessionId() != null) {
        if(bParams.size() > 0) {
          bSql.append(", ");
        }
        bSql.append("sessionId=$" + num);
        num++;
        bParams.add(siteRequest.getSessionId());
      }
      if(siteRequest.getUserKey() != null) {
        if(bParams.size() > 0) {
          bSql.append(", ");
        }
        bSql.append("userKey=$" + num);
        num++;
        bParams.add(siteRequest.getUserKey());
      }
      if(siteRequest.getUserId() != null) {
        if(bParams.size() > 0) {
          bSql.append(", ");
        }
        bSql.append("userId=$" + num);
        num++;
        bParams.add(siteRequest.getUserId());
      }

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
          case SiteUser.VAR_userId:
            o2.setUserId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_userId + "=$" + num);
            num++;
            bParams.add(o2.sqlUserId());
            break;
          case SiteUser.VAR_userName:
            o2.setUserName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_userName + "=$" + num);
            num++;
            bParams.add(o2.sqlUserName());
            break;
          case SiteUser.VAR_userEmail:
            o2.setUserEmail(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_userEmail + "=$" + num);
            num++;
            bParams.add(o2.sqlUserEmail());
            break;
          case SiteUser.VAR_userFirstName:
            o2.setUserFirstName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_userFirstName + "=$" + num);
            num++;
            bParams.add(o2.sqlUserFirstName());
            break;
          case SiteUser.VAR_userLastName:
            o2.setUserLastName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_userLastName + "=$" + num);
            num++;
            bParams.add(o2.sqlUserLastName());
            break;
          case SiteUser.VAR_userFullName:
            o2.setUserFullName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_userFullName + "=$" + num);
            num++;
            bParams.add(o2.sqlUserFullName());
            break;
          case SiteUser.VAR_userProfileUrl:
            o2.setUserProfileUrl(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_userProfileUrl + "=$" + num);
            num++;
            bParams.add(o2.sqlUserProfileUrl());
            break;
          case SiteUser.VAR_seeArchived:
            o2.setSeeArchived(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_seeArchived + "=$" + num);
            num++;
            bParams.add(o2.sqlSeeArchived());
            break;
          case SiteUser.VAR_displayName:
            o2.setDisplayName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_displayName + "=$" + num);
            num++;
            bParams.add(o2.sqlDisplayName());
            break;
          case SiteUser.VAR_siteFontSize:
            o2.setSiteFontSize(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_siteFontSize + "=$" + num);
            num++;
            bParams.add(o2.sqlSiteFontSize());
            break;
          case SiteUser.VAR_siteTheme:
            o2.setSiteTheme(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_siteTheme + "=$" + num);
            num++;
            bParams.add(o2.sqlSiteTheme());
            break;
          case SiteUser.VAR_customerProfileId:
            o2.setCustomerProfileId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_customerProfileId + "=$" + num);
            num++;
            bParams.add(o2.sqlCustomerProfileId());
            break;
          case SiteUser.VAR_created:
            o2.setCreated(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_created + "=$" + num);
            num++;
            bParams.add(o2.sqlCreated());
            break;
          case SiteUser.VAR_archived:
            o2.setArchived(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_archived + "=$" + num);
            num++;
            bParams.add(o2.sqlArchived());
            break;
          case SiteUser.VAR_userKey:
            o2.setUserKey(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_userKey + "=$" + num);
            num++;
            bParams.add(o2.sqlUserKey());
            break;
          case SiteUser.VAR_objectTitle:
            o2.setObjectTitle(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_objectTitle + "=$" + num);
            num++;
            bParams.add(o2.sqlObjectTitle());
            break;
          case SiteUser.VAR_apiUrl:
            o2.setApiUrl(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_apiUrl + "=$" + num);
            num++;
            bParams.add(o2.sqlApiUrl());
            break;
          case SiteUser.VAR_displayPage:
            o2.setDisplayPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_displayPage + "=$" + num);
            num++;
            bParams.add(o2.sqlDisplayPage());
            break;
          case SiteUser.VAR_editPage:
            o2.setEditPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_editPage + "=$" + num);
            num++;
            bParams.add(o2.sqlEditPage());
            break;
          case SiteUser.VAR_userPage:
            o2.setUserPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_userPage + "=$" + num);
            num++;
            bParams.add(o2.sqlUserPage());
            break;
          case SiteUser.VAR_download:
            o2.setDownload(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SiteUser.VAR_download + "=$" + num);
            num++;
            bParams.add(o2.sqlDownload());
            break;
          }
        }
      }
      bSql.append(" WHERE pk=$" + num);
      if(bParams.size() > 0) {
      bParams.add(pk);
      num++;
        futures2.add(0, Future.future(a -> {
          sqlConnection.preparedQuery(bSql.toString())
              .execute(Tuple.tuple(bParams)
              ).onSuccess(b -> {
            a.handle(Future.succeededFuture());
          }).onFailure(ex -> {
            RuntimeException ex2 = new RuntimeException("value SiteUser failed", ex);
            LOG.error(String.format("relateSiteUser failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete(o2);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPOSTSiteUser failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPOSTSiteUser failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPOSTSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200POSTSiteUser(SiteRequest siteRequest, JsonObject json) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200POSTSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // SearchPage //

  @Override
  public void searchpageSiteUser(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = true;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        SiteUser.authorizationSiteUser(siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          SiteUser.authorizationScopesSiteUser(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchSiteUserList(siteRequest2, false, true, false, "GET").onSuccess(listSiteUser -> {
              response200SearchPageSiteUser(listSiteUser).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchpageSiteUser succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchpageSiteUser failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchpageSiteUser failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchpageSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageSiteUser failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("searchpageSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void searchpageSiteUserPageInit(JsonObject ctx, SiteUserPage page, SearchList<SiteUser> listSiteUser, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/user"));
    ctx.put("enUSUrlPage", String.format("%s%s", siteBaseUrl, "/en-us/search/user"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriSearchPageSiteUser(ServiceRequest serviceRequest, SiteUser result) {
    return "en-us/search/user/SiteUserSearchPage.htm";
  }
  public void templateSearchPageSiteUser(JsonObject ctx, SiteUserPage page, SearchList<SiteUser> listSiteUser, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listSiteUser.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      SiteUser result = listSiteUser.first();
      String pageTemplateUri = templateUriSearchPageSiteUser(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/search/user/SiteUserSearchPage.htm"), Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".yaml") || pageTemplateUri.endsWith(".yml")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        Map<String, Object> data = new HashMap<>();
        Yaml yaml = new Yaml();
        Map<String, Object> mapResult = yaml.load(template);
        if(mapResult.containsKey("result")) {
          Map<String, Object> map = (Map<String, Object>)mapResult.get("result");
          map.forEach((key, value) -> {
            String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
            if(val instanceof String) {
              String rendered = jinjava.render(val, ctx.getMap());
              data.put(key, rendered);
            }
          });
          map.forEach((key, value) -> {
            String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
            if(val instanceof String) {
              String rendered = jinjava.render(val, ctx.getMap());
              data.put(key, rendered);
            }
          });
        }
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/user/SiteUserGenEditPage.htm")).orElse("en-us/Article.htm");
        StringBuilder sb = new StringBuilder();
        sb.append("{% extends \"").append(pageExtends).append("\" %}\n");
        if(mapResult.containsKey("block")) {
          Map<String, Object> map = (Map<String, Object>)mapResult.get("block");
          map.forEach((resultKey, value) -> {
            if(!"result".equals(resultKey)) {
              String lineSpace = ((String)value).replaceAll("\\A(\\s*)[\\w\\W]+\\Z", "$1");
              sb.append(lineSpace).append("{% block ").append(resultKey).append(" -%}\n");
              sb.append(value);
              sb.append(lineSpace).append("{% endblock ").append(resultKey).append(" -%}{{''}}\n");
            }
          });
        }
        String htmTemplate = sb.toString();
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".md")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String metaPrefixResult = String.format("%s.", i18n.getString(I18n.var_resultat));
        Map<String, Object> data = new HashMap<>();
        String body = "";
        if(template.startsWith("---\n")) {
          Matcher mMeta = Pattern.compile("---\n([\\w\\W]+?)\n---\n([\\w\\W]+)", Pattern.MULTILINE).matcher(template);
          if(mMeta.find()) {
            String meta = mMeta.group(1);
            body = mMeta.group(2);
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(meta);
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
          }
        }
        org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().build();
        org.commonmark.node.Node document = parser.parse(body);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
        String pageExtends =  Optional.ofNullable((String)data.get("extends")).orElse("en-us/Article.htm");
        String htmTemplate = "{% extends \"" + pageExtends + "\" %}\n{% block htmBodyMiddleArticle %}\n" + renderer.render(document) + "\n{% endblock htmBodyMiddleArticle %}\n";
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateSearchPageSiteUser failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200SearchPageSiteUser(SearchList<SiteUser> listSiteUser) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listSiteUser.getSiteRequest_(SiteRequest.class);
      SiteUserPage page = new SiteUserPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listSiteUser.size() >= 1)
        siteRequest.setRequestPk(listSiteUser.get(0).getPk());
      page.setSearchListSiteUser_(listSiteUser);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepSiteUserPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          searchpageSiteUserPageInit(ctx, page, listSiteUser, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateSearchPageSiteUser(ctx, page, listSiteUser, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200SearchPageSiteUser failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200SearchPageSiteUser failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200SearchPageSiteUser failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchPageSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchPageSiteUser(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
    if(pivots != null) {
      for(SolrResponse.Pivot pivotField : pivots) {
        String entityIndexed = pivotField.getField();
        String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
        JsonObject pivotJson = new JsonObject();
        pivotArray.add(pivotJson);
        pivotJson.put("field", entityVar);
        pivotJson.put("value", pivotField.getValue());
        pivotJson.put("count", pivotField.getCount());
        Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
        List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
        if(pivotRanges != null) {
          JsonObject rangeJson = new JsonObject();
          pivotJson.put("ranges", rangeJson);
          for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
            JsonObject rangeFacetJson = new JsonObject();
            String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
            rangeJson.put(rangeFacetVar, rangeFacetJson);
            JsonObject rangeFacetCountsObject = new JsonObject();
            rangeFacetJson.put("counts", rangeFacetCountsObject);
            rangeFacet.getCounts().forEach((value, count) -> {
              rangeFacetCountsObject.put(value, count);
            });
          }
        }
        if(pivotFields2 != null) {
          JsonArray pivotArray2 = new JsonArray();
          pivotJson.put("pivot", pivotArray2);
          responsePivotSearchPageSiteUser(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // EditPage //

  @Override
  public void editpageSiteUser(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = true;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        SiteUser.authorizationSiteUser(siteRequest, webClient, classPublicRead, "EditPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          SiteUser.authorizationScopesSiteUser(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "EditPage", "GET", "GET").onSuccess(siteRequest2 -> {
            searchSiteUserList(siteRequest2, false, true, false, "GET").onSuccess(listSiteUser -> {
              response200EditPageSiteUser(listSiteUser).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("editpageSiteUser succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("editpageSiteUser failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
          }).onFailure(ex -> {
              LOG.error(String.format("editpageSiteUser failed. "), ex);
              error(siteRequest, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("editpageSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("editpageSiteUser failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("editpageSiteUser failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void editpageSiteUserPageInit(JsonObject ctx, SiteUserPage page, SearchList<SiteUser> listSiteUser, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/user"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriEditPageSiteUser(ServiceRequest serviceRequest, SiteUser result) {
    return "en-us/edit/user/SiteUserEditPage.htm";
  }
  public void templateEditPageSiteUser(JsonObject ctx, SiteUserPage page, SearchList<SiteUser> listSiteUser, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listSiteUser.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      SiteUser result = listSiteUser.first();
      String pageTemplateUri = templateUriEditPageSiteUser(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/edit/user/SiteUserEditPage.htm"), Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".yaml") || pageTemplateUri.endsWith(".yml")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        Map<String, Object> data = new HashMap<>();
        Yaml yaml = new Yaml();
        Map<String, Object> mapResult = yaml.load(template);
        if(mapResult.containsKey("result")) {
          Map<String, Object> map = (Map<String, Object>)mapResult.get("result");
          map.forEach((key, value) -> {
            String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
            if(val instanceof String) {
              String rendered = jinjava.render(val, ctx.getMap());
              data.put(key, rendered);
            }
          });
          map.forEach((key, value) -> {
            String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
            if(val instanceof String) {
              String rendered = jinjava.render(val, ctx.getMap());
              data.put(key, rendered);
            }
          });
        }
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/user/SiteUserGenEditPage.htm")).orElse("en-us/Article.htm");
        StringBuilder sb = new StringBuilder();
        sb.append("{% extends \"").append(pageExtends).append("\" %}\n");
        if(mapResult.containsKey("block")) {
          Map<String, Object> map = (Map<String, Object>)mapResult.get("block");
          map.forEach((resultKey, value) -> {
            if(!"result".equals(resultKey)) {
              String lineSpace = ((String)value).replaceAll("\\A(\\s*)[\\w\\W]+\\Z", "$1");
              sb.append(lineSpace).append("{% block ").append(resultKey).append(" -%}\n");
              sb.append(value);
              sb.append(lineSpace).append("{% endblock ").append(resultKey).append(" -%}{{''}}\n");
            }
          });
        }
        String htmTemplate = sb.toString();
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".md")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String metaPrefixResult = String.format("%s.", i18n.getString(I18n.var_resultat));
        Map<String, Object> data = new HashMap<>();
        String body = "";
        if(template.startsWith("---\n")) {
          Matcher mMeta = Pattern.compile("---\n([\\w\\W]+?)\n---\n([\\w\\W]+)", Pattern.MULTILINE).matcher(template);
          if(mMeta.find()) {
            String meta = mMeta.group(1);
            body = mMeta.group(2);
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(meta);
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
          }
        }
        org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().build();
        org.commonmark.node.Node document = parser.parse(body);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
        String pageExtends =  Optional.ofNullable((String)data.get("extends")).orElse("en-us/Article.htm");
        String htmTemplate = "{% extends \"" + pageExtends + "\" %}\n{% block htmBodyMiddleArticle %}\n" + renderer.render(document) + "\n{% endblock htmBodyMiddleArticle %}\n";
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateEditPageSiteUser failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200EditPageSiteUser(SearchList<SiteUser> listSiteUser) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listSiteUser.getSiteRequest_(SiteRequest.class);
      SiteUserPage page = new SiteUserPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listSiteUser.size() >= 1)
        siteRequest.setRequestPk(listSiteUser.get(0).getPk());
      page.setSearchListSiteUser_(listSiteUser);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepSiteUserPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          editpageSiteUserPageInit(ctx, page, listSiteUser, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateEditPageSiteUser(ctx, page, listSiteUser, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200EditPageSiteUser failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200EditPageSiteUser failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200EditPageSiteUser failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200EditPageSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotEditPageSiteUser(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
    if(pivots != null) {
      for(SolrResponse.Pivot pivotField : pivots) {
        String entityIndexed = pivotField.getField();
        String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
        JsonObject pivotJson = new JsonObject();
        pivotArray.add(pivotJson);
        pivotJson.put("field", entityVar);
        pivotJson.put("value", pivotField.getValue());
        pivotJson.put("count", pivotField.getCount());
        Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
        List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
        if(pivotRanges != null) {
          JsonObject rangeJson = new JsonObject();
          pivotJson.put("ranges", rangeJson);
          for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
            JsonObject rangeFacetJson = new JsonObject();
            String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
            rangeJson.put(rangeFacetVar, rangeFacetJson);
            JsonObject rangeFacetCountsObject = new JsonObject();
            rangeFacetJson.put("counts", rangeFacetCountsObject);
            rangeFacet.getCounts().forEach((value, count) -> {
              rangeFacetCountsObject.put(value, count);
            });
          }
        }
        if(pivotFields2 != null) {
          JsonArray pivotArray2 = new JsonArray();
          pivotJson.put("pivot", pivotArray2);
          responsePivotEditPageSiteUser(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // General //

  public Future<SiteUser> createSiteUser(SiteRequest siteRequest) {
    Promise<SiteUser> promise = Promise.promise();
    try {
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      String userId = siteRequest.getUserId();
      Long userKey = siteRequest.getUserKey();
      ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

      sqlConnection.preparedQuery("INSERT INTO SiteUser(created, userKey) VALUES($1, $2) RETURNING pk")
          .collecting(Collectors.toList())
          .execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
        Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
        Long pk = createLine.getLong(0);
        SiteUser o = new SiteUser();
        o.setPk(pk);
        o.setSiteRequest_(siteRequest);
        promise.complete(o);
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error("createSiteUser failed. ", ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("createSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public void searchSiteUserQ(SearchList<SiteUser> searchList, String entityVar, String valueIndexed, String varIndexed) {
    searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
    if(!"*".equals(entityVar)) {
    }
  }

  public String searchSiteUserFq(SearchList<SiteUser> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    if(StringUtils.startsWith(valueIndexed, "[")) {
      String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
      if(fqs.length != 2)
        throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
      String fq1 = fqs[0].equals("*") ? fqs[0] : SiteUser.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
      String fq2 = fqs[1].equals("*") ? fqs[1] : SiteUser.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
       return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
    } else {
      return varIndexed + ":" + SearchTool.escapeQueryChars(SiteUser.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
    }
  }

  public void searchSiteUserSort(SearchList<SiteUser> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    searchList.sort(varIndexed, valueIndexed);
  }

  public void searchSiteUserRows(SearchList<SiteUser> searchList, Long valueRows) {
      searchList.rows(valueRows != null ? valueRows : 10L);
  }

  public void searchSiteUserStart(SearchList<SiteUser> searchList, Long valueStart) {
    searchList.start(valueStart);
  }

  public void searchSiteUserVar(SearchList<SiteUser> searchList, String var, String value) {
    searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
  }

  public void searchSiteUserUri(SearchList<SiteUser> searchList) {
  }

  public Future<ServiceResponse> varsSiteUser(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();

      serviceRequest.getParams().getJsonObject("query").stream().filter(paramRequest -> "var".equals(paramRequest.getKey()) && paramRequest.getValue() != null).findFirst().ifPresent(paramRequest -> {
        String entityVar = null;
        String valueIndexed = null;
        Object paramValuesObject = paramRequest.getValue();
        JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

        try {
          for(Object paramObject : paramObjects) {
            entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
            valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
            siteRequest.getRequestVars().put(entityVar, valueIndexed);
          }
        } catch(Exception ex) {
          LOG.error(String.format("searchSiteUser failed. "), ex);
          promise.tryFail(ex);
        }
      });
      promise.complete();
    } catch(Exception ex) {
      LOG.error(String.format("searchSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SearchList<SiteUser>> searchSiteUserList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, String scope) {
    Promise<SearchList<SiteUser>> promise = Promise.promise();
    try {
      SiteUser siteUser = siteRequest.getSiteUser_();
      siteUser.promiseDeepForClass(siteRequest).onSuccess(a -> {
        SearchList<SiteUser> searchList = new SearchList<SiteUser>();
        searchList.setScope(scope);
        searchList.addList(siteUser);
        searchList.promiseDeepForClass(siteRequest).onSuccess(searchList2 -> {
          promise.complete(searchList);
        }).onFailure(ex -> {
          LOG.error("Unable to create site user", ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error("Unable to create site user", ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("searchSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void searchSiteUser2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<SiteUser> searchList) {
  }

  public Future<JsonObject> upsertSiteUser(SiteUser o, Boolean inheritPrimaryKey, Boolean patch) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
        promise.complete();
      } else {
        JsonObject json = o.getSiteRequest_().getJsonObject();

        String old_userId = SiteUser.staticJsonUserId(o.getUserId());
        String new_userId = json.getString(SiteUser.varJson(SiteUser.VAR_userId, patch));

        String old_userName = SiteUser.staticJsonUserName(o.getUserName());
        String new_userName = json.getString(SiteUser.varJson(SiteUser.VAR_userName, patch));

        String old_userEmail = SiteUser.staticJsonUserEmail(o.getUserEmail());
        String new_userEmail = json.getString(SiteUser.varJson(SiteUser.VAR_userEmail, patch));

        String old_userFirstName = SiteUser.staticJsonUserFirstName(o.getUserFirstName());
        String new_userFirstName = json.getString(SiteUser.varJson(SiteUser.VAR_userFirstName, patch));

        String old_userLastName = SiteUser.staticJsonUserLastName(o.getUserLastName());
        String new_userLastName = json.getString(SiteUser.varJson(SiteUser.VAR_userLastName, patch));

        String old_userFullName = SiteUser.staticJsonUserFullName(o.getUserFullName());
        String new_userFullName = json.getString(SiteUser.varJson(SiteUser.VAR_userFullName, patch));

        String old_userProfileUrl = SiteUser.staticJsonUserProfileUrl(o.getUserProfileUrl());
        String new_userProfileUrl = json.getString(SiteUser.varJson(SiteUser.VAR_userProfileUrl, patch));

        Boolean old_seeArchived = SiteUser.staticJsonSeeArchived(o.getSeeArchived());
        Boolean new_seeArchived = json.getBoolean(SiteUser.varJson(SiteUser.VAR_seeArchived, patch));

        String old_displayName = SiteUser.staticJsonDisplayName(o.getDisplayName());
        String new_displayName = json.getString(SiteUser.varJson(SiteUser.VAR_displayName, patch));

        String old_siteFontSize = SiteUser.staticJsonSiteFontSize(o.getSiteFontSize());
        String new_siteFontSize = json.getString(SiteUser.varJson(SiteUser.VAR_siteFontSize, patch));

        String old_siteTheme = SiteUser.staticJsonSiteTheme(o.getSiteTheme());
        String new_siteTheme = json.getString(SiteUser.varJson(SiteUser.VAR_siteTheme, patch));

        String old_customerProfileId = SiteUser.staticJsonCustomerProfileId(o.getCustomerProfileId());
        String new_customerProfileId = json.getString(SiteUser.varJson(SiteUser.VAR_customerProfileId, patch));

        String old_created = SiteUser.staticJsonCreated(o.getCreated());
        String new_created = json.getString(SiteUser.varJson(SiteUser.VAR_created, patch));

        Boolean old_archived = SiteUser.staticJsonArchived(o.getArchived());
        Boolean new_archived = json.getBoolean(SiteUser.varJson(SiteUser.VAR_archived, patch));

        String old_sessionId = SiteUser.staticJsonSessionId(o.getSessionId());
        String new_sessionId = json.getString(SiteUser.varJson(SiteUser.VAR_sessionId, patch));

        String old_userKey = SiteUser.staticJsonUserKey(o.getUserKey());
        String new_userKey = json.getString(SiteUser.varJson(SiteUser.VAR_userKey, patch));

        String old_objectTitle = SiteUser.staticJsonObjectTitle(o.getObjectTitle());
        String new_objectTitle = json.getString(SiteUser.varJson(SiteUser.VAR_objectTitle, patch));

        String old_apiUrl = SiteUser.staticJsonApiUrl(o.getApiUrl());
        String new_apiUrl = json.getString(SiteUser.varJson(SiteUser.VAR_apiUrl, patch));

        String old_displayPage = SiteUser.staticJsonDisplayPage(o.getDisplayPage());
        String new_displayPage = json.getString(SiteUser.varJson(SiteUser.VAR_displayPage, patch));

        String old_editPage = SiteUser.staticJsonEditPage(o.getEditPage());
        String new_editPage = json.getString(SiteUser.varJson(SiteUser.VAR_editPage, patch));

        String old_userPage = SiteUser.staticJsonUserPage(o.getUserPage());
        String new_userPage = json.getString(SiteUser.varJson(SiteUser.VAR_userPage, patch));

        String old_download = SiteUser.staticJsonDownload(o.getDownload());
        String new_download = json.getString(SiteUser.varJson(SiteUser.VAR_download, patch));

        String userId = Optional.ofNullable(Optional.ofNullable(new_userId).orElse(old_userId)).orElse(null);
        // if(!Objects.equals(old_userId, userId))
          // json.put(SiteUser.varJson(SiteUser.VAR_userId, patch), userId);
        String userName = Optional.ofNullable(Optional.ofNullable(new_userName).orElse(old_userName)).orElse(null);
        // if(!Objects.equals(old_userName, userName))
          // json.put(SiteUser.varJson(SiteUser.VAR_userName, patch), userName);
        String userEmail = Optional.ofNullable(Optional.ofNullable(new_userEmail).orElse(old_userEmail)).orElse(null);
        // if(!Objects.equals(old_userEmail, userEmail))
          // json.put(SiteUser.varJson(SiteUser.VAR_userEmail, patch), userEmail);
        String userFirstName = Optional.ofNullable(Optional.ofNullable(new_userFirstName).orElse(old_userFirstName)).orElse(null);
        // if(!Objects.equals(old_userFirstName, userFirstName))
          // json.put(SiteUser.varJson(SiteUser.VAR_userFirstName, patch), userFirstName);
        String userLastName = Optional.ofNullable(Optional.ofNullable(new_userLastName).orElse(old_userLastName)).orElse(null);
        // if(!Objects.equals(old_userLastName, userLastName))
          // json.put(SiteUser.varJson(SiteUser.VAR_userLastName, patch), userLastName);
        String userFullName = Optional.ofNullable(Optional.ofNullable(new_userFullName).orElse(old_userFullName)).orElse(null);
        // if(!Objects.equals(old_userFullName, userFullName))
          // json.put(SiteUser.varJson(SiteUser.VAR_userFullName, patch), userFullName);
        String userProfileUrl = Optional.ofNullable(Optional.ofNullable(new_userProfileUrl).orElse(old_userProfileUrl)).orElse(null);
        // if(!Objects.equals(old_userProfileUrl, userProfileUrl))
          // json.put(SiteUser.varJson(SiteUser.VAR_userProfileUrl, patch), userProfileUrl);
        Boolean seeArchived = Optional.ofNullable(Optional.ofNullable(new_seeArchived).orElse(old_seeArchived)).orElse(null);
        // if(!Objects.equals(old_seeArchived, seeArchived))
          // json.put(SiteUser.varJson(SiteUser.VAR_seeArchived, patch), seeArchived);
        String displayName = Optional.ofNullable(Optional.ofNullable(new_displayName).orElse(old_displayName)).orElse(null);
        // if(!Objects.equals(old_displayName, displayName))
          // json.put(SiteUser.varJson(SiteUser.VAR_displayName, patch), displayName);
        String siteFontSize = Optional.ofNullable(Optional.ofNullable(new_siteFontSize).orElse(old_siteFontSize)).orElse(null);
        // if(!Objects.equals(old_siteFontSize, siteFontSize))
          // json.put(SiteUser.varJson(SiteUser.VAR_siteFontSize, patch), siteFontSize);
        String siteTheme = Optional.ofNullable(Optional.ofNullable(new_siteTheme).orElse(old_siteTheme)).orElse(null);
        // if(!Objects.equals(old_siteTheme, siteTheme))
          // json.put(SiteUser.varJson(SiteUser.VAR_siteTheme, patch), siteTheme);
        String customerProfileId = Optional.ofNullable(Optional.ofNullable(new_customerProfileId).orElse(old_customerProfileId)).orElse(null);
        // if(!Objects.equals(old_customerProfileId, customerProfileId))
          // json.put(SiteUser.varJson(SiteUser.VAR_customerProfileId, patch), customerProfileId);
        String created = Optional.ofNullable(Optional.ofNullable(new_created).orElse(old_created)).orElse(null);
        // if(!Objects.equals(old_created, created))
          // json.put(SiteUser.varJson(SiteUser.VAR_created, patch), created);
        Boolean archived = Optional.ofNullable(Optional.ofNullable(new_archived).orElse(old_archived)).orElse(null);
        // if(!Objects.equals(old_archived, archived))
          // json.put(SiteUser.varJson(SiteUser.VAR_archived, patch), archived);
        String sessionId = Optional.ofNullable(Optional.ofNullable(new_sessionId).orElse(old_sessionId)).orElse(null);
        // if(!Objects.equals(old_sessionId, sessionId))
          // json.put(SiteUser.varJson(SiteUser.VAR_sessionId, patch), sessionId);
        String userKey = Optional.ofNullable(Optional.ofNullable(new_userKey).orElse(old_userKey)).orElse(null);
        // if(!Objects.equals(old_userKey, userKey))
          // json.put(SiteUser.varJson(SiteUser.VAR_userKey, patch), userKey);
        String objectTitle = Optional.ofNullable(Optional.ofNullable(new_objectTitle).orElse(old_objectTitle)).orElse(null);
        // if(!Objects.equals(old_objectTitle, objectTitle))
          // json.put(SiteUser.varJson(SiteUser.VAR_objectTitle, patch), objectTitle);
        String apiUrl = Optional.ofNullable(Optional.ofNullable(new_apiUrl).orElse(old_apiUrl)).orElse(null);
        // if(!Objects.equals(old_apiUrl, apiUrl))
          // json.put(SiteUser.varJson(SiteUser.VAR_apiUrl, patch), apiUrl);
        String displayPage = Optional.ofNullable(Optional.ofNullable(new_displayPage).orElse(old_displayPage)).orElse(null);
        // if(!Objects.equals(old_displayPage, displayPage))
          // json.put(SiteUser.varJson(SiteUser.VAR_displayPage, patch), displayPage);
        String editPage = Optional.ofNullable(Optional.ofNullable(new_editPage).orElse(old_editPage)).orElse(null);
        // if(!Objects.equals(old_editPage, editPage))
          // json.put(SiteUser.varJson(SiteUser.VAR_editPage, patch), editPage);
        String userPage = Optional.ofNullable(Optional.ofNullable(new_userPage).orElse(old_userPage)).orElse(null);
        // if(!Objects.equals(old_userPage, userPage))
          // json.put(SiteUser.varJson(SiteUser.VAR_userPage, patch), userPage);
        String download = Optional.ofNullable(Optional.ofNullable(new_download).orElse(old_download)).orElse(null);
        // if(!Objects.equals(old_download, download))
          // json.put(SiteUser.varJson(SiteUser.VAR_download, patch), download);

        promise.complete(json);
      }
    } catch(Exception ex) {
      LOG.error(String.format("upsertSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> persistSiteUser(SiteUser o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Long pk = o.getPk();
      sqlConnection.preparedQuery("SELECT userId, userName, userEmail, userFirstName, userLastName, userFullName, userProfileUrl, seeArchived, displayName, siteFontSize, siteTheme, customerProfileId, created, archived, sessionId, userKey, objectTitle, apiUrl, displayPage, editPage, userPage, download FROM SiteUser WHERE pk=$1")
          .collecting(Collectors.toList())
          .execute(Tuple.of(pk)
          ).onSuccess(result -> {
        try {
          for(Row definition : result.value()) {
            for(Integer i = 0; i < definition.size(); i++) {
              String columnName = definition.getColumnName(i);
              Object columnValue = definition.getValue(i);
              if(!"pk".equals(columnName)) {
                try {
                  o.persistForClass(columnName, columnValue);
                } catch(Exception e) {
                  LOG.error(String.format("persistSiteUser failed. "), e);
                }
              }
            }
          }
          o.promiseDeepForClass(siteRequest).onSuccess(a -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("persistSiteUser failed. "), ex);
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("persistSiteUser failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error(String.format("persistSiteUser failed. "), ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("persistSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> relateSiteUser(SiteUser o) {
    Promise<Void> promise = Promise.promise();
    promise.complete();
    return promise.future();
  }

  public String searchVar(String varIndexed) {
    return SiteUser.searchVarSiteUser(varIndexed);
  }

  @Override
  public String getClassApiAddress() {
    return SiteUser.CLASS_API_ADDRESS_SiteUser;
  }

  public Future<SiteUser> indexSiteUser(SiteUser o) {
    Promise<SiteUser> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      JsonObject json = new JsonObject();
      JsonObject add = new JsonObject();
      json.put("add", add);
      JsonObject doc = new JsonObject();
      add.put("doc", doc);
      o.indexSiteUser(doc);
      String solrUsername = siteRequest.getConfig().getString(ConfigKeys.SOLR_USERNAME);
      String solrPassword = siteRequest.getConfig().getString(ConfigKeys.SOLR_PASSWORD);
      String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
      Integer solrPort = Integer.parseInt(siteRequest.getConfig().getString(ConfigKeys.SOLR_PORT));
      String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
      Boolean solrSsl = Boolean.parseBoolean(siteRequest.getConfig().getString(ConfigKeys.SOLR_SSL));
      Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
      Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
        if(softCommit == null && commitWithin == null)
          softCommit = true;
        else if(softCommit == null)
          softCommit = false;
      String solrRequestUri = String.format("/solr/%s/update%s%s%s", solrCollection, "?overwrite=true&wt=json", softCommit ? "&softCommit=true" : "", commitWithin != null ? ("&commitWithin=" + commitWithin) : "");
      webClient.post(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).putHeader("Content-Type", "application/json").sendBuffer(json.toBuffer()).expecting(HttpResponseExpectation.SC_OK).onSuccess(b -> {
        promise.complete(o);
      }).onFailure(ex -> {
        LOG.error(String.format("indexSiteUser failed. "), new RuntimeException(ex));
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("indexSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SiteUser> unindexSiteUser(SiteUser o) {
    Promise<SiteUser> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      o.promiseDeepForClass(siteRequest).onSuccess(a -> {
        JsonObject json = new JsonObject();
        JsonObject delete = new JsonObject();
        json.put("delete", delete);
        String query = String.format("filter(%s:%s)", SiteUser.VAR_solrId, o.obtainForClass(SiteUser.VAR_solrId));
        delete.put("query", query);
        String solrUsername = siteRequest.getConfig().getString(ConfigKeys.SOLR_USERNAME);
        String solrPassword = siteRequest.getConfig().getString(ConfigKeys.SOLR_PASSWORD);
        String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
        Integer solrPort = Integer.parseInt(siteRequest.getConfig().getString(ConfigKeys.SOLR_PORT));
        String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
        Boolean solrSsl = Boolean.parseBoolean(siteRequest.getConfig().getString(ConfigKeys.SOLR_SSL));
        Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
        Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
          if(softCommit == null && commitWithin == null)
            softCommit = true;
          else if(softCommit == null)
            softCommit = false;
        String solrRequestUri = String.format("/solr/%s/update%s%s%s", solrCollection, "?overwrite=true&wt=json", softCommit ? "&softCommit=true" : "", commitWithin != null ? ("&commitWithin=" + commitWithin) : "");
        webClient.post(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).putHeader("Content-Type", "application/json").sendBuffer(json.toBuffer()).expecting(HttpResponseExpectation.SC_OK).onSuccess(b -> {
          promise.complete(o);
        }).onFailure(ex -> {
          LOG.error(String.format("unindexSiteUser failed. "), new RuntimeException(ex));
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("unindexSiteUser failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("unindexSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> refreshSiteUser(SiteUser o) {
    Promise<Void> promise = Promise.promise();
    SiteRequest siteRequest = o.getSiteRequest_();
    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
      if(refresh && !Optional.ofNullable(siteRequest.getJsonObject()).map(JsonObject::isEmpty).orElse(true)) {
        List<Future> futures = new ArrayList<>();

        for(int i=0; i < solrIds.size(); i++) {
          String solrId2 = solrIds.get(i);
          String classSimpleName2 = classes.get(i);
        }

        promise.complete();
      } else {
        promise.complete();
      }
    } catch(Exception ex) {
      LOG.error(String.format("refreshSiteUser failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public Future<JsonObject> generatePageBody(ComputateSiteRequest siteRequest, Map<String, Object> ctx, String templatePath, String classSimpleName, String pageTemplate) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      Map<String, Object> result = (Map<String, Object>)ctx.get("result");
      SiteRequest siteRequest2 = (SiteRequest)siteRequest;
      String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);
      SiteUser o = new SiteUser();
      o.setSiteRequest_((SiteRequest)siteRequest);

      o.persistForClass(SiteUser.VAR_userId, SiteUser.staticSetUserId(siteRequest2, (String)result.get(SiteUser.VAR_userId)));
      o.persistForClass(SiteUser.VAR_userName, SiteUser.staticSetUserName(siteRequest2, (String)result.get(SiteUser.VAR_userName)));
      o.persistForClass(SiteUser.VAR_userEmail, SiteUser.staticSetUserEmail(siteRequest2, (String)result.get(SiteUser.VAR_userEmail)));
      o.persistForClass(SiteUser.VAR_userFirstName, SiteUser.staticSetUserFirstName(siteRequest2, (String)result.get(SiteUser.VAR_userFirstName)));
      o.persistForClass(SiteUser.VAR_userLastName, SiteUser.staticSetUserLastName(siteRequest2, (String)result.get(SiteUser.VAR_userLastName)));
      o.persistForClass(SiteUser.VAR_userFullName, SiteUser.staticSetUserFullName(siteRequest2, (String)result.get(SiteUser.VAR_userFullName)));
      o.persistForClass(SiteUser.VAR_userProfileUrl, SiteUser.staticSetUserProfileUrl(siteRequest2, (String)result.get(SiteUser.VAR_userProfileUrl)));
      o.persistForClass(SiteUser.VAR_seeArchived, SiteUser.staticSetSeeArchived(siteRequest2, (String)result.get(SiteUser.VAR_seeArchived)));
      o.persistForClass(SiteUser.VAR_displayName, SiteUser.staticSetDisplayName(siteRequest2, (String)result.get(SiteUser.VAR_displayName)));
      o.persistForClass(SiteUser.VAR_siteFontSize, SiteUser.staticSetSiteFontSize(siteRequest2, (String)result.get(SiteUser.VAR_siteFontSize)));
      o.persistForClass(SiteUser.VAR_siteTheme, SiteUser.staticSetSiteTheme(siteRequest2, (String)result.get(SiteUser.VAR_siteTheme)));
      o.persistForClass(SiteUser.VAR_customerProfileId, SiteUser.staticSetCustomerProfileId(siteRequest2, (String)result.get(SiteUser.VAR_customerProfileId)));
      o.persistForClass(SiteUser.VAR_created, SiteUser.staticSetCreated(siteRequest2, (String)result.get(SiteUser.VAR_created), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(SiteUser.VAR_archived, SiteUser.staticSetArchived(siteRequest2, (String)result.get(SiteUser.VAR_archived)));
      o.persistForClass(SiteUser.VAR_sessionId, SiteUser.staticSetSessionId(siteRequest2, (String)result.get(SiteUser.VAR_sessionId)));
      o.persistForClass(SiteUser.VAR_userKey, SiteUser.staticSetUserKey(siteRequest2, (String)result.get(SiteUser.VAR_userKey)));
      o.persistForClass(SiteUser.VAR_objectTitle, SiteUser.staticSetObjectTitle(siteRequest2, (String)result.get(SiteUser.VAR_objectTitle)));
      o.persistForClass(SiteUser.VAR_apiUrl, SiteUser.staticSetApiUrl(siteRequest2, (String)result.get(SiteUser.VAR_apiUrl)));
      o.persistForClass(SiteUser.VAR_displayPage, SiteUser.staticSetDisplayPage(siteRequest2, (String)result.get(SiteUser.VAR_displayPage)));
      o.persistForClass(SiteUser.VAR_editPage, SiteUser.staticSetEditPage(siteRequest2, (String)result.get(SiteUser.VAR_editPage)));
      o.persistForClass(SiteUser.VAR_userPage, SiteUser.staticSetUserPage(siteRequest2, (String)result.get(SiteUser.VAR_userPage)));
      o.persistForClass(SiteUser.VAR_download, SiteUser.staticSetDownload(siteRequest2, (String)result.get(SiteUser.VAR_download)));

      o.promiseDeepForClass((SiteRequest)siteRequest).onSuccess(o2 -> {
        try {
          JsonObject data = JsonObject.mapFrom(o2);
          ctx.put("result", data.getMap());
          promise.complete(data);
        } catch(Exception ex) {
          LOG.error(String.format(importModelFail, classSimpleName), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("generatePageBody failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("generatePageBody failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
}

package org.mghpcc.aitelemetry.model.developer.aitelemetry;

import org.mghpcc.aitelemetry.request.SiteRequest;
import org.mghpcc.aitelemetry.user.SiteUser;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.search.list.SearchResult;
import org.computate.vertx.verticle.EmailVerticle;
import org.mghpcc.aitelemetry.config.ConfigKeys;
import org.computate.vertx.api.BaseApiServiceImpl;
import io.vertx.ext.web.client.WebClient;
import java.util.Objects;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.pgclient.PgPool;
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
import io.vertx.ext.web.client.predicate.ResponsePredicate;
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
import org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperPage;


/**
 * Translate: false
 * Generated: true
 **/
public class AiTelemetryDeveloperEnUSGenApiServiceImpl extends BaseApiServiceImpl implements AiTelemetryDeveloperEnUSGenApiService {

  protected static final Logger LOG = LoggerFactory.getLogger(AiTelemetryDeveloperEnUSGenApiServiceImpl.class);

  // Search //

  @Override
  public void searchAiTelemetryDeveloper(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "GET"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAiTelemetryDeveloperList(siteRequest, false, true, false).onSuccess(listAiTelemetryDeveloper -> {
                response200SearchAiTelemetryDeveloper(listAiTelemetryDeveloper).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("searchAiTelemetryDeveloper succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200SearchAiTelemetryDeveloper(SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
      List<String> fls = listAiTelemetryDeveloper.getRequest().getFields();
      JsonObject json = new JsonObject();
      JsonArray l = new JsonArray();
      listAiTelemetryDeveloper.getList().stream().forEach(o -> {
        JsonObject json2 = JsonObject.mapFrom(o);
        if(fls.size() > 0) {
          Set<String> fieldNames = new HashSet<String>();
          for(String fieldName : json2.fieldNames()) {
            String v = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(fieldName);
            if(v != null)
              fieldNames.add(AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(fieldName));
          }
          if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves_docvalues_strings")) {
            fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves_docvalues_strings")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
            fieldNames.remove("_docvalues_long");
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
      response200Search(listAiTelemetryDeveloper.getRequest(), listAiTelemetryDeveloper.getResponse(), json);
      if(json == null) {
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String m = String.format("%s %s not found", "AI Telemetry developer", pageId);
        promise.complete(new ServiceResponse(404
            , m
            , Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
      } else {
        promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
      }
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchAiTelemetryDeveloper(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchAiTelemetryDeveloper(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // GET //

  @Override
  public void getAiTelemetryDeveloper(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "GET"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAiTelemetryDeveloperList(siteRequest, false, true, false).onSuccess(listAiTelemetryDeveloper -> {
                response200GETAiTelemetryDeveloper(listAiTelemetryDeveloper).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("getAiTelemetryDeveloper succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("getAiTelemetryDeveloper failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("getAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("getAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("getAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("getAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("getAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200GETAiTelemetryDeveloper(SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
      JsonObject json = JsonObject.mapFrom(listAiTelemetryDeveloper.getList().stream().findFirst().orElse(null));
      if(json == null) {
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String m = String.format("%s %s not found", "AI Telemetry developer", pageId);
        promise.complete(new ServiceResponse(404
            , m
            , Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
      } else {
        promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
      }
    } catch(Exception ex) {
      LOG.error(String.format("response200GETAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PATCH //

  @Override
  public void patchAiTelemetryDeveloper(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("patchAiTelemetryDeveloper started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "PATCH"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("PATCH")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAiTelemetryDeveloperList(siteRequest, true, false, true).onSuccess(listAiTelemetryDeveloper -> {
                try {
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(listAiTelemetryDeveloper.getRequest().getRows());
                  apiRequest.setNumFound(listAiTelemetryDeveloper.getResponse().getResponse().getNumFound());
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);
                  if(apiRequest.getNumFound() == 1L)
                    apiRequest.setOriginal(listAiTelemetryDeveloper.first());
                  apiRequest.setId(Optional.ofNullable(listAiTelemetryDeveloper.first()).map(o2 -> o2.getPageId().toString()).orElse(null));
                  eventBus.publish("websocketAiTelemetryDeveloper", JsonObject.mapFrom(apiRequest).toString());

                  listPATCHAiTelemetryDeveloper(apiRequest, listAiTelemetryDeveloper).onSuccess(e -> {
                    response200PATCHAiTelemetryDeveloper(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("patchAiTelemetryDeveloper succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("patchAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPATCHAiTelemetryDeveloper(ApiRequest apiRequest, SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
    listAiTelemetryDeveloper.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      AiTelemetryDeveloper o2 = jsonObject.mapTo(AiTelemetryDeveloper.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        patchAiTelemetryDeveloperFuture(o2, false).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listPATCHAiTelemetryDeveloper failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listAiTelemetryDeveloper.next().onSuccess(next -> {
        if(next) {
          listPATCHAiTelemetryDeveloper(apiRequest, listAiTelemetryDeveloper).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPATCHAiTelemetryDeveloper failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listPATCHAiTelemetryDeveloper failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listPATCHAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void patchAiTelemetryDeveloperFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
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
        searchAiTelemetryDeveloperList(siteRequest, false, true, true).onSuccess(listAiTelemetryDeveloper -> {
          try {
            AiTelemetryDeveloper o = listAiTelemetryDeveloper.first();
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setRows(1L);
            apiRequest.setNumFound(1L);
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest);
            siteRequest.setApiRequest_(apiRequest);
            if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
              siteRequest.getRequestVars().put( "refresh", "false" );
            }
            AiTelemetryDeveloper o2;
            if(o != null) {
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listAiTelemetryDeveloper.first()).map(o3 -> o3.getPageId().toString()).orElse(null));
              JsonObject jsonObject = JsonObject.mapFrom(o);
              o2 = jsonObject.mapTo(AiTelemetryDeveloper.class);
              o2.setSiteRequest_(siteRequest);
              patchAiTelemetryDeveloperFuture(o2, false).onSuccess(o3 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              String m = String.format("%s %s not found", "AI Telemetry developer", null);
              eventHandler.handle(Future.failedFuture(m));
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("patchAiTelemetryDeveloper failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<AiTelemetryDeveloper> patchAiTelemetryDeveloperFuture(AiTelemetryDeveloper o, Boolean inheritPrimaryKey) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<AiTelemetryDeveloper> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      persistAiTelemetryDeveloper(o, true).onSuccess(c -> {
        indexAiTelemetryDeveloper(o).onSuccess(e -> {
          if(apiRequest != null) {
            apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
            if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
              o.apiRequestAiTelemetryDeveloper();
              if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                eventBus.publish("websocketAiTelemetryDeveloper", JsonObject.mapFrom(apiRequest).toString());
            }
          }
          promise.complete(o);
        }).onFailure(ex -> {
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("patchAiTelemetryDeveloperFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200PATCHAiTelemetryDeveloper(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      if(json == null) {
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String m = String.format("%s %s not found", "AI Telemetry developer", pageId);
        promise.complete(new ServiceResponse(404
            , m
            , Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
      } else {
        promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
      }
    } catch(Exception ex) {
      LOG.error(String.format("response200PATCHAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // POST //

  @Override
  public void postAiTelemetryDeveloper(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("postAiTelemetryDeveloper started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "POST"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("POST")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              ApiRequest apiRequest = new ApiRequest();
              apiRequest.setRows(1L);
              apiRequest.setNumFound(1L);
              apiRequest.setNumPATCH(0L);
              apiRequest.initDeepApiRequest(siteRequest);
              siteRequest.setApiRequest_(apiRequest);
              eventBus.publish("websocketAiTelemetryDeveloper", JsonObject.mapFrom(apiRequest).toString());
              JsonObject params = new JsonObject();
              params.put("body", siteRequest.getJsonObject());
              params.put("path", new JsonObject());
              params.put("scopes", scopes2);
              params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
              params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
              params.put("form", new JsonObject());
              JsonObject query = new JsonObject();
              Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
              Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
              if(softCommit == null && commitWithin == null)
                softCommit = true;
              if(softCommit != null)
                query.put("softCommit", softCommit);
              if(commitWithin != null)
                query.put("commitWithin", commitWithin);
              params.put("query", query);
              JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
              JsonObject json = new JsonObject().put("context", context);
              eventBus.request(AiTelemetryDeveloper.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postAiTelemetryDeveloperFuture")).onSuccess(a -> {
                JsonObject responseMessage = (JsonObject)a.body();
                JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(responseBody.encodePrettily()))));
                LOG.debug(String.format("postAiTelemetryDeveloper succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("postAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("postAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("postAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("postAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  @Override
  public void postAiTelemetryDeveloperFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
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
        postAiTelemetryDeveloperFuture(siteRequest, false).onSuccess(o -> {
          eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
        }).onFailure(ex -> {
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Throwable ex) {
        LOG.error(String.format("postAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("postAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<AiTelemetryDeveloper> postAiTelemetryDeveloperFuture(SiteRequest siteRequest, Boolean pageId) {
    Promise<AiTelemetryDeveloper> promise = Promise.promise();

    try {
      createAiTelemetryDeveloper(siteRequest).onSuccess(aiTelemetryDeveloper -> {
        persistAiTelemetryDeveloper(aiTelemetryDeveloper, false).onSuccess(c -> {
          indexAiTelemetryDeveloper(aiTelemetryDeveloper).onSuccess(o2 -> {
            promise.complete(aiTelemetryDeveloper);
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        }).onFailure(ex -> {
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("postAiTelemetryDeveloperFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200POSTAiTelemetryDeveloper(AiTelemetryDeveloper o) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      JsonObject json = JsonObject.mapFrom(o);
      if(json == null) {
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String m = String.format("%s %s not found", "AI Telemetry developer", pageId);
        promise.complete(new ServiceResponse(404
            , m
            , Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
      } else {
        promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
      }
    } catch(Exception ex) {
      LOG.error(String.format("response200POSTAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // DELETE //

  @Override
  public void deleteAiTelemetryDeveloper(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deleteAiTelemetryDeveloper started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "DELETE"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("DELETE")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAiTelemetryDeveloperList(siteRequest, true, false, true).onSuccess(listAiTelemetryDeveloper -> {
                try {
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(listAiTelemetryDeveloper.getRequest().getRows());
                  apiRequest.setNumFound(listAiTelemetryDeveloper.getResponse().getResponse().getNumFound());
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);
                  if(apiRequest.getNumFound() == 1L)
                    apiRequest.setOriginal(listAiTelemetryDeveloper.first());
                  eventBus.publish("websocketAiTelemetryDeveloper", JsonObject.mapFrom(apiRequest).toString());

                  listDELETEAiTelemetryDeveloper(apiRequest, listAiTelemetryDeveloper).onSuccess(e -> {
                    response200DELETEAiTelemetryDeveloper(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("deleteAiTelemetryDeveloper succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deleteAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEAiTelemetryDeveloper(ApiRequest apiRequest, SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
    listAiTelemetryDeveloper.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      AiTelemetryDeveloper o2 = jsonObject.mapTo(AiTelemetryDeveloper.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deleteAiTelemetryDeveloperFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEAiTelemetryDeveloper failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listAiTelemetryDeveloper.next().onSuccess(next -> {
        if(next) {
          listDELETEAiTelemetryDeveloper(apiRequest, listAiTelemetryDeveloper).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEAiTelemetryDeveloper failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEAiTelemetryDeveloper failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deleteAiTelemetryDeveloperFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
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
        searchAiTelemetryDeveloperList(siteRequest, false, true, true).onSuccess(listAiTelemetryDeveloper -> {
          try {
            AiTelemetryDeveloper o = listAiTelemetryDeveloper.first();
            if(o != null && listAiTelemetryDeveloper.getResponse().getResponse().getNumFound() == 1) {
              ApiRequest apiRequest = new ApiRequest();
              apiRequest.setRows(1L);
              apiRequest.setNumFound(1L);
              apiRequest.setNumPATCH(0L);
              apiRequest.initDeepApiRequest(siteRequest);
              siteRequest.setApiRequest_(apiRequest);
              if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
                siteRequest.getRequestVars().put( "refresh", "false" );
              }
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listAiTelemetryDeveloper.first()).map(o2 -> o2.getPageId().toString()).orElse(null));
              deleteAiTelemetryDeveloperFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deleteAiTelemetryDeveloper failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<AiTelemetryDeveloper> deleteAiTelemetryDeveloperFuture(AiTelemetryDeveloper o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<AiTelemetryDeveloper> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      unindexAiTelemetryDeveloper(o).onSuccess(e -> {
        promise.complete(o);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deleteAiTelemetryDeveloperFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEAiTelemetryDeveloper(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      if(json == null) {
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String m = String.format("%s %s not found", "AI Telemetry developer", pageId);
        promise.complete(new ServiceResponse(404
            , m
            , Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
      } else {
        promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
      }
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PUTImport //

  @Override
  public void putimportAiTelemetryDeveloper(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("putimportAiTelemetryDeveloper started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "PUT"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("PUT")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              ApiRequest apiRequest = new ApiRequest();
              JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
              apiRequest.setRows(Long.valueOf(jsonArray.size()));
              apiRequest.setNumFound(Long.valueOf(jsonArray.size()));
              apiRequest.setNumPATCH(0L);
              apiRequest.initDeepApiRequest(siteRequest);
              siteRequest.setApiRequest_(apiRequest);
              eventBus.publish("websocketAiTelemetryDeveloper", JsonObject.mapFrom(apiRequest).toString());
              varsAiTelemetryDeveloper(siteRequest).onSuccess(d -> {
                listPUTImportAiTelemetryDeveloper(apiRequest, siteRequest).onSuccess(e -> {
                  response200PUTImportAiTelemetryDeveloper(siteRequest).onSuccess(response -> {
                    LOG.debug(String.format("putimportAiTelemetryDeveloper succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportAiTelemetryDeveloper failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("putimportAiTelemetryDeveloper failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("putimportAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("putimportAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("putimportAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPUTImportAiTelemetryDeveloper(ApiRequest apiRequest, SiteRequest siteRequest) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
    try {
      jsonArray.forEach(obj -> {
        futures.add(Future.future(promise1 -> {
          JsonObject params = new JsonObject();
          params.put("body", obj);
          params.put("path", new JsonObject());
          params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
          params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
          params.put("form", new JsonObject());
          JsonObject query = new JsonObject();
          Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
          Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
          if(softCommit == null && commitWithin == null)
            softCommit = true;
          if(softCommit != null)
            query.put("softCommit", softCommit);
          if(commitWithin != null)
            query.put("commitWithin", commitWithin);
          params.put("query", query);
          JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
          JsonObject json = new JsonObject().put("context", context);
          eventBus.request(AiTelemetryDeveloper.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "putimportAiTelemetryDeveloperFuture")).onSuccess(a -> {
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPUTImportAiTelemetryDeveloper failed. "), ex);
            promise1.tryFail(ex);
          });
        }));
      });
      CompositeFuture.all(futures).onSuccess(a -> {
        apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("listPUTImportAiTelemetryDeveloper failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("listPUTImportAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public void putimportAiTelemetryDeveloperFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
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
        String pageId = Optional.ofNullable(body.getString(AiTelemetryDeveloper.VAR_pageId)).orElse(body.getString(AiTelemetryDeveloper.VAR_solrId));
        if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
          siteRequest.getRequestVars().put( "refresh", "false" );
        }

        SearchList<AiTelemetryDeveloper> searchList = new SearchList<AiTelemetryDeveloper>();
        searchList.setStore(true);
        searchList.q("*:*");
        searchList.setC(AiTelemetryDeveloper.class);
        searchList.fq("archived_docvalues_boolean:false");
        searchList.fq("pageId_docvalues_string:" + SearchTool.escapeQueryChars(pageId));
        searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
          try {
            if(searchList.size() >= 1) {
              AiTelemetryDeveloper o = searchList.getList().stream().findFirst().orElse(null);
              AiTelemetryDeveloper o2 = new AiTelemetryDeveloper();
              o2.setSiteRequest_(siteRequest);
              JsonObject body2 = new JsonObject();
              for(String f : body.fieldNames()) {
                Object bodyVal = body.getValue(f);
                if(bodyVal instanceof JsonArray) {
                  JsonArray bodyVals = (JsonArray)bodyVal;
                  Object valsObj = o.obtainForClass(f);
                  Collection<?> vals = valsObj instanceof JsonArray ? ((JsonArray)valsObj).getList() : (Collection<?>)valsObj;
                  if(vals != null && bodyVals.size() == vals.size()) {
                    Boolean match = true;
                    for(Object val : vals) {
                      if(val != null) {
                        if(!bodyVals.contains(val.toString())) {
                          match = false;
                          break;
                        }
                      } else {
                        match = false;
                        break;
                      }
                    }
                    vals.clear();
                    body2.put("set" + StringUtils.capitalize(f), bodyVal);
                  } else {
                    if(vals != null)
                      vals.clear();
                    body2.put("set" + StringUtils.capitalize(f), bodyVal);
                  }
                } else {
                  o2.persistForClass(f, bodyVal);
                  o2.relateForClass(f, bodyVal);
                  if(!StringUtils.containsAny(f, "pageId", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                    body2.put("set" + StringUtils.capitalize(f), bodyVal);
                }
              }
              for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
                if(!body.fieldNames().contains(f)) {
                  if(!StringUtils.containsAny(f, "pageId", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                    body2.putNull("set" + StringUtils.capitalize(f));
                }
              }
              if(searchList.size() == 1) {
                apiRequest.setOriginal(o);
                apiRequest.setId(Optional.ofNullable(o.getPageId()).map(v -> v.toString()).orElse(null));
              }
              siteRequest.setJsonObject(body2);
              patchAiTelemetryDeveloperFuture(o2, true).onSuccess(b -> {
                LOG.debug("Import AiTelemetryDeveloper {} succeeded, modified AiTelemetryDeveloper. ", body.getValue(AiTelemetryDeveloper.VAR_pageId));
                eventHandler.handle(Future.succeededFuture());
              }).onFailure(ex -> {
                LOG.error(String.format("putimportAiTelemetryDeveloperFuture failed. "), ex);
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              postAiTelemetryDeveloperFuture(siteRequest, true).onSuccess(b -> {
                LOG.debug("Import AiTelemetryDeveloper {} succeeded, created new AiTelemetryDeveloper. ", body.getValue(AiTelemetryDeveloper.VAR_pageId));
                eventHandler.handle(Future.succeededFuture());
              }).onFailure(ex -> {
                LOG.error(String.format("putimportAiTelemetryDeveloperFuture failed. "), ex);
                eventHandler.handle(Future.failedFuture(ex));
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("putimportAiTelemetryDeveloperFuture failed. "), ex);
            eventHandler.handle(Future.failedFuture(ex));
          }
        }).onFailure(ex -> {
          LOG.error(String.format("putimportAiTelemetryDeveloperFuture failed. "), ex);
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportAiTelemetryDeveloperFuture failed. "), ex);
        eventHandler.handle(Future.failedFuture(ex));
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("putimportAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200PUTImportAiTelemetryDeveloper(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      if(json == null) {
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String m = String.format("%s %s not found", "AI Telemetry developer", pageId);
        promise.complete(new ServiceResponse(404
            , m
            , Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
      } else {
        promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
      }
    } catch(Exception ex) {
      LOG.error(String.format("response200PUTImportAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // SearchPage //

  @Override
  public void searchpageAiTelemetryDeveloper(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "GET"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAiTelemetryDeveloperList(siteRequest, false, true, false).onSuccess(listAiTelemetryDeveloper -> {
                response200SearchPageAiTelemetryDeveloper(listAiTelemetryDeveloper).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("searchpageAiTelemetryDeveloper succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("searchpageAiTelemetryDeveloper failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("searchpageAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("searchpageAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchpageAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("searchpageAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void searchpageAiTelemetryDeveloperPageInit(JsonObject ctx, AiTelemetryDeveloperPage page, SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/ai-telemetry-developer"));
    ctx.put("enUSUrlPage", String.format("%s%s", siteBaseUrl, "/en-us/search/ai-telemetry-developer"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriSearchPageAiTelemetryDeveloper(ServiceRequest serviceRequest, AiTelemetryDeveloper result) {
    return "en-us/search/ai-telemetry-developer/AiTelemetryDeveloperSearchPage.htm";
  }
  public void templateSearchPageAiTelemetryDeveloper(JsonObject ctx, AiTelemetryDeveloperPage page, SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      AiTelemetryDeveloper result = listAiTelemetryDeveloper.first();
      String pageTemplateUri = templateUriSearchPageAiTelemetryDeveloper(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
      if(pageTemplateUri.endsWith(".md")) {
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
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateSearchPageAiTelemetryDeveloper failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200SearchPageAiTelemetryDeveloper(SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
      AiTelemetryDeveloperPage page = new AiTelemetryDeveloperPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      page.setSearchListAiTelemetryDeveloper_(listAiTelemetryDeveloper);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepAiTelemetryDeveloperPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          searchpageAiTelemetryDeveloperPageInit(ctx, page, listAiTelemetryDeveloper, promise1);
          promise1.future().onSuccess(b -> {
            Promise<String> promise2 = Promise.promise();
            templateSearchPageAiTelemetryDeveloper(ctx, page, listAiTelemetryDeveloper, promise2);
            promise2.future().onSuccess(renderedTemplate -> {
              try {
                Buffer buffer = Buffer.buffer(renderedTemplate);
                promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
              } catch(Throwable ex) {
                LOG.error(String.format("response200SearchPageAiTelemetryDeveloper failed. "), ex);
                promise.fail(ex);
              }
            }).onFailure(ex -> {
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200SearchPageAiTelemetryDeveloper failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchPageAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchPageAiTelemetryDeveloper(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchPageAiTelemetryDeveloper(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // EditPage //

  @Override
  public void editpageAiTelemetryDeveloper(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s-%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, pageId, "GET"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "GET"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
              , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
              , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
              )
              .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
              .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
              .sendForm(form)
              .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAiTelemetryDeveloperList(siteRequest, false, true, false).onSuccess(listAiTelemetryDeveloper -> {
                response200EditPageAiTelemetryDeveloper(listAiTelemetryDeveloper).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("editpageAiTelemetryDeveloper succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("editpageAiTelemetryDeveloper failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("editpageAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
            });
            }
          } catch(Exception ex) {
            LOG.error(String.format("editpageAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("editpageAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("editpageAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("editpageAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void editpageAiTelemetryDeveloperPageInit(JsonObject ctx, AiTelemetryDeveloperPage page, SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/ai-telemetry-developer"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriEditPageAiTelemetryDeveloper(ServiceRequest serviceRequest, AiTelemetryDeveloper result) {
    return "en-us/edit/ai-telemetry-developer/AiTelemetryDeveloperEditPage.htm";
  }
  public void templateEditPageAiTelemetryDeveloper(JsonObject ctx, AiTelemetryDeveloperPage page, SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      AiTelemetryDeveloper result = listAiTelemetryDeveloper.first();
      String pageTemplateUri = templateUriEditPageAiTelemetryDeveloper(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
      if(pageTemplateUri.endsWith(".md")) {
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
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateEditPageAiTelemetryDeveloper failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200EditPageAiTelemetryDeveloper(SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
      AiTelemetryDeveloperPage page = new AiTelemetryDeveloperPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      page.setSearchListAiTelemetryDeveloper_(listAiTelemetryDeveloper);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepAiTelemetryDeveloperPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          editpageAiTelemetryDeveloperPageInit(ctx, page, listAiTelemetryDeveloper, promise1);
          promise1.future().onSuccess(b -> {
            Promise<String> promise2 = Promise.promise();
            templateEditPageAiTelemetryDeveloper(ctx, page, listAiTelemetryDeveloper, promise2);
            promise2.future().onSuccess(renderedTemplate -> {
              try {
                Buffer buffer = Buffer.buffer(renderedTemplate);
                promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
              } catch(Throwable ex) {
                LOG.error(String.format("response200EditPageAiTelemetryDeveloper failed. "), ex);
                promise.fail(ex);
              }
            }).onFailure(ex -> {
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200EditPageAiTelemetryDeveloper failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200EditPageAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotEditPageAiTelemetryDeveloper(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotEditPageAiTelemetryDeveloper(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // UserPage //

  @Override
  public void userpageAiTelemetryDeveloper(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s-%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, pageId, "GET"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "GET"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
              , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
              , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
              )
              .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
              .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
              .sendForm(form)
              .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAiTelemetryDeveloperList(siteRequest, false, true, false).onSuccess(listAiTelemetryDeveloper -> {
                response200UserPageAiTelemetryDeveloper(listAiTelemetryDeveloper).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("userpageAiTelemetryDeveloper succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("userpageAiTelemetryDeveloper failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("userpageAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
            });
            }
          } catch(Exception ex) {
            LOG.error(String.format("userpageAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("userpageAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("userpageAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("userpageAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void userpageAiTelemetryDeveloperPageInit(JsonObject ctx, AiTelemetryDeveloperPage page, SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/ai-telemetry-developer"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriUserPageAiTelemetryDeveloper(ServiceRequest serviceRequest, AiTelemetryDeveloper result) {
    return String.format("%s.htm", StringUtils.substringBefore(serviceRequest.getExtra().getString("uri").substring(1), "?"));
  }
  public void templateUserPageAiTelemetryDeveloper(JsonObject ctx, AiTelemetryDeveloperPage page, SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      AiTelemetryDeveloper result = listAiTelemetryDeveloper.first();
      String pageTemplateUri = templateUriUserPageAiTelemetryDeveloper(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
      if(pageTemplateUri.endsWith(".md")) {
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
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateUserPageAiTelemetryDeveloper failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200UserPageAiTelemetryDeveloper(SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
      AiTelemetryDeveloperPage page = new AiTelemetryDeveloperPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      page.setSearchListAiTelemetryDeveloper_(listAiTelemetryDeveloper);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepAiTelemetryDeveloperPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          userpageAiTelemetryDeveloperPageInit(ctx, page, listAiTelemetryDeveloper, promise1);
          promise1.future().onSuccess(b -> {
            Promise<String> promise2 = Promise.promise();
            templateUserPageAiTelemetryDeveloper(ctx, page, listAiTelemetryDeveloper, promise2);
            promise2.future().onSuccess(renderedTemplate -> {
              try {
                Buffer buffer = Buffer.buffer(renderedTemplate);
                promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
              } catch(Throwable ex) {
                LOG.error(String.format("response200UserPageAiTelemetryDeveloper failed. "), ex);
                promise.fail(ex);
              }
            }).onFailure(ex -> {
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200UserPageAiTelemetryDeveloper failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200UserPageAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotUserPageAiTelemetryDeveloper(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotUserPageAiTelemetryDeveloper(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // DELETEFilter //

  @Override
  public void deletefilterAiTelemetryDeveloper(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deletefilterAiTelemetryDeveloper started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String AITELEMETRYDEVELOPER = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AITELEMETRYDEVELOPER");
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", AiTelemetryDeveloper.CLASS_AUTH_RESOURCE, "PUT"));
        if(pageId != null)
          form.add("permission", String.format("%s#%s", pageId, "DELETE"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("DELETE")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAiTelemetryDeveloperList(siteRequest, true, false, true).onSuccess(listAiTelemetryDeveloper -> {
                try {
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(listAiTelemetryDeveloper.getRequest().getRows());
                  apiRequest.setNumFound(listAiTelemetryDeveloper.getResponse().getResponse().getNumFound());
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);
                  if(apiRequest.getNumFound() == 1L)
                    apiRequest.setOriginal(listAiTelemetryDeveloper.first());
                  eventBus.publish("websocketAiTelemetryDeveloper", JsonObject.mapFrom(apiRequest).toString());

                  listDELETEFilterAiTelemetryDeveloper(apiRequest, listAiTelemetryDeveloper).onSuccess(e -> {
                    response200DELETEFilterAiTelemetryDeveloper(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("deletefilterAiTelemetryDeveloper succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. ", ex2));
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
        LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEFilterAiTelemetryDeveloper(ApiRequest apiRequest, SearchList<AiTelemetryDeveloper> listAiTelemetryDeveloper) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listAiTelemetryDeveloper.getSiteRequest_(SiteRequest.class);
    listAiTelemetryDeveloper.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      AiTelemetryDeveloper o2 = jsonObject.mapTo(AiTelemetryDeveloper.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deletefilterAiTelemetryDeveloperFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEFilterAiTelemetryDeveloper failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listAiTelemetryDeveloper.next().onSuccess(next -> {
        if(next) {
          listDELETEFilterAiTelemetryDeveloper(apiRequest, listAiTelemetryDeveloper).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEFilterAiTelemetryDeveloper failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEFilterAiTelemetryDeveloper failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEFilterAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deletefilterAiTelemetryDeveloperFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
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
        searchAiTelemetryDeveloperList(siteRequest, false, true, true).onSuccess(listAiTelemetryDeveloper -> {
          try {
            AiTelemetryDeveloper o = listAiTelemetryDeveloper.first();
            if(o != null && listAiTelemetryDeveloper.getResponse().getResponse().getNumFound() == 1) {
              ApiRequest apiRequest = new ApiRequest();
              apiRequest.setRows(1L);
              apiRequest.setNumFound(1L);
              apiRequest.setNumPATCH(0L);
              apiRequest.initDeepApiRequest(siteRequest);
              siteRequest.setApiRequest_(apiRequest);
              if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
                siteRequest.getRequestVars().put( "refresh", "false" );
              }
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listAiTelemetryDeveloper.first()).map(o2 -> o2.getPageId().toString()).orElse(null));
              deletefilterAiTelemetryDeveloperFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deletefilterAiTelemetryDeveloper failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<AiTelemetryDeveloper> deletefilterAiTelemetryDeveloperFuture(AiTelemetryDeveloper o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<AiTelemetryDeveloper> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      unindexAiTelemetryDeveloper(o).onSuccess(e -> {
        promise.complete(o);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deletefilterAiTelemetryDeveloperFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEFilterAiTelemetryDeveloper(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      if(json == null) {
        String pageId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pageId");
        String m = String.format("%s %s not found", "AI Telemetry developer", pageId);
        promise.complete(new ServiceResponse(404
            , m
            , Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
      } else {
        promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
      }
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEFilterAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // General //

  public Future<AiTelemetryDeveloper> createAiTelemetryDeveloper(SiteRequest siteRequest) {
    Promise<AiTelemetryDeveloper> promise = Promise.promise();
    try {
      AiTelemetryDeveloper o = new AiTelemetryDeveloper();
      o.setSiteRequest_(siteRequest);
      promise.complete(o);
    } catch(Exception ex) {
      LOG.error(String.format("createAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public void searchAiTelemetryDeveloperQ(SearchList<AiTelemetryDeveloper> searchList, String entityVar, String valueIndexed, String varIndexed) {
    searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
    if(!"*".equals(entityVar)) {
    }
  }

  public String searchAiTelemetryDeveloperFq(SearchList<AiTelemetryDeveloper> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    if(StringUtils.startsWith(valueIndexed, "[")) {
      String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
      if(fqs.length != 2)
        throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
      String fq1 = fqs[0].equals("*") ? fqs[0] : AiTelemetryDeveloper.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
      String fq2 = fqs[1].equals("*") ? fqs[1] : AiTelemetryDeveloper.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
       return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
    } else {
      return varIndexed + ":" + SearchTool.escapeQueryChars(AiTelemetryDeveloper.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
    }
  }

  public void searchAiTelemetryDeveloperSort(SearchList<AiTelemetryDeveloper> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    searchList.sort(varIndexed, valueIndexed);
  }

  public void searchAiTelemetryDeveloperRows(SearchList<AiTelemetryDeveloper> searchList, Long valueRows) {
      searchList.rows(valueRows != null ? valueRows : 10L);
  }

  public void searchAiTelemetryDeveloperStart(SearchList<AiTelemetryDeveloper> searchList, Long valueStart) {
    searchList.start(valueStart);
  }

  public void searchAiTelemetryDeveloperVar(SearchList<AiTelemetryDeveloper> searchList, String var, String value) {
    searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
  }

  public void searchAiTelemetryDeveloperUri(SearchList<AiTelemetryDeveloper> searchList) {
  }

  public Future<ServiceResponse> varsAiTelemetryDeveloper(SiteRequest siteRequest) {
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
          LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
          promise.tryFail(ex);
        }
      });
      promise.complete();
    } catch(Exception ex) {
      LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SearchList<AiTelemetryDeveloper>> searchAiTelemetryDeveloperList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify) {
    Promise<SearchList<AiTelemetryDeveloper>> promise = Promise.promise();
    try {
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
      String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
      SearchList<AiTelemetryDeveloper> searchList = new SearchList<AiTelemetryDeveloper>();
      String facetRange = null;
      Date facetRangeStart = null;
      Date facetRangeEnd = null;
      String facetRangeGap = null;
      String statsField = null;
      String statsFieldIndexed = null;
      searchList.setPopulate(populate);
      searchList.setStore(store);
      searchList.q("*:*");
      searchList.setC(AiTelemetryDeveloper.class);
      searchList.setSiteRequest_(siteRequest);
      searchList.facetMinCount(1);
      if(entityList != null) {
        for(String v : entityList) {
          searchList.fl(AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(v));
        }
      }

      String pageId = serviceRequest.getParams().getJsonObject("path").getString("pageId");
      if(pageId != null) {
        searchList.fq("pageId_docvalues_string:" + SearchTool.escapeQueryChars(pageId));
      }

      for(String paramName : serviceRequest.getParams().getJsonObject("query").fieldNames()) {
        Object paramValuesObject = serviceRequest.getParams().getJsonObject("query").getValue(paramName);
        String entityVar = null;
        String valueIndexed = null;
        String varIndexed = null;
        String valueSort = null;
        Long valueStart = null;
        Long valueRows = null;
        String valueCursorMark = null;
        JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

        try {
          if(paramValuesObject != null && "facet.pivot".equals(paramName)) {
            Matcher mFacetPivot = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher(StringUtils.join(paramObjects.getList().toArray(), ","));
            if(mFacetPivot.find()) {
              String solrLocalParams = mFacetPivot.group(1);
              String[] entityVars = mFacetPivot.group(2).trim().split(",");
              String[] varsIndexed = new String[entityVars.length];
              for(Integer i = 0; i < entityVars.length; i++) {
                entityVar = entityVars[i];
                varsIndexed[i] = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(entityVar);
              }
              searchList.facetPivot((solrLocalParams == null ? "" : solrLocalParams) + StringUtils.join(varsIndexed, ","));
            }
          } else if(paramValuesObject != null) {
            for(Object paramObject : paramObjects) {
              if(paramName.equals("q")) {
                Matcher mQ = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|\\^|$)))").matcher((String)paramObject);
                StringBuffer sb = new StringBuffer();
                while(mQ.find()) {
                  entityVar = mQ.group(1).trim();
                  valueIndexed = mQ.group(2).trim();
                  varIndexed = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(entityVar);
                  String entityQ = searchAiTelemetryDeveloperFq(searchList, entityVar, valueIndexed, varIndexed);
                  mQ.appendReplacement(sb, entityQ);
                }
                if(!sb.isEmpty()) {
                  mQ.appendTail(sb);
                  searchList.q(sb.toString());
                }
              } else if(paramName.equals("fq")) {
                Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher((String)paramObject);
                  StringBuffer sb = new StringBuffer();
                while(mFq.find()) {
                  entityVar = mFq.group(1).trim();
                  valueIndexed = mFq.group(2).trim();
                  varIndexed = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(entityVar);
                  String entityFq = searchAiTelemetryDeveloperFq(searchList, entityVar, valueIndexed, varIndexed);
                  mFq.appendReplacement(sb, entityFq);
                }
                if(!sb.isEmpty()) {
                  mFq.appendTail(sb);
                  searchList.fq(sb.toString());
                }
              } else if(paramName.equals("sort")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
                valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
                varIndexed = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(entityVar);
                searchAiTelemetryDeveloperSort(searchList, entityVar, valueIndexed, varIndexed);
              } else if(paramName.equals("start")) {
                valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchAiTelemetryDeveloperStart(searchList, valueStart);
              } else if(paramName.equals("rows")) {
                valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchAiTelemetryDeveloperRows(searchList, valueRows);
              } else if(paramName.equals("stats")) {
                searchList.stats((Boolean)paramObject);
              } else if(paramName.equals("stats.field")) {
                Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mStats.find()) {
                  String solrLocalParams = mStats.group(1);
                  entityVar = mStats.group(2).trim();
                  varIndexed = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(entityVar);
                  searchList.statsField((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  statsField = entityVar;
                  statsFieldIndexed = varIndexed;
                }
              } else if(paramName.equals("facet")) {
                searchList.facet((Boolean)paramObject);
              } else if(paramName.equals("facet.range.start")) {
                String startMathStr = (String)paramObject;
                Date start = SearchTool.parseMath(startMathStr);
                searchList.facetRangeStart(start.toInstant().toString());
                facetRangeStart = start;
              } else if(paramName.equals("facet.range.end")) {
                String endMathStr = (String)paramObject;
                Date end = SearchTool.parseMath(endMathStr);
                searchList.facetRangeEnd(end.toInstant().toString());
                facetRangeEnd = end;
              } else if(paramName.equals("facet.range.gap")) {
                String gap = (String)paramObject;
                searchList.facetRangeGap(gap);
                facetRangeGap = gap;
              } else if(paramName.equals("facet.range")) {
                Matcher mFacetRange = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mFacetRange.find()) {
                  String solrLocalParams = mFacetRange.group(1);
                  entityVar = mFacetRange.group(2).trim();
                  varIndexed = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(entityVar);
                  searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  facetRange = entityVar;
                }
              } else if(paramName.equals("facet.field")) {
                entityVar = (String)paramObject;
                varIndexed = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(entityVar);
                if(varIndexed != null)
                  searchList.facetField(varIndexed);
              } else if(paramName.equals("var")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
                valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
                searchAiTelemetryDeveloperVar(searchList, entityVar, valueIndexed);
              } else if(paramName.equals("cursorMark")) {
                valueCursorMark = (String)paramObject;
                searchList.cursorMark((String)paramObject);
              }
            }
            searchAiTelemetryDeveloperUri(searchList);
          }
        } catch(Exception e) {
          ExceptionUtils.rethrow(e);
        }
      }
      if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
        searchList.sort("courseNum_docvalues_int", "asc");
        searchList.setDefaultSort(true);
      }
      String facetRange2 = facetRange;
      Date facetRangeStart2 = facetRangeStart;
      Date facetRangeEnd2 = facetRangeEnd;
      String facetRangeGap2 = facetRangeGap;
      String statsField2 = statsField;
      String statsFieldIndexed2 = statsFieldIndexed;
      searchAiTelemetryDeveloper2(siteRequest, populate, store, modify, searchList);
      searchList.promiseDeepForClass(siteRequest).onSuccess(searchList2 -> {
        if(facetRange2 != null && statsField2 != null && facetRange2.equals(statsField2)) {
          StatsField stats = searchList.getResponse().getStats().getStatsFields().get(statsFieldIndexed2);
          Instant min = Optional.ofNullable(stats.getMin()).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
          Instant max = Optional.ofNullable(stats.getMax()).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
          if(min.equals(max)) {
            min = min.minus(1, ChronoUnit.DAYS);
            max = max.plus(2, ChronoUnit.DAYS);
          }
          Duration duration = Duration.between(min, max);
          String gap = "HOUR";
          if(duration.toDays() >= 365)
            gap = "YEAR";
          else if(duration.toDays() >= 28)
            gap = "MONTH";
          else if(duration.toDays() >= 1)
            gap = "DAY";
          else if(duration.toHours() >= 1)
            gap = "HOUR";
          else if(duration.toMinutes() >= 1)
            gap = "MINUTE";
          else if(duration.toMillis() >= 1000)
            gap = "SECOND";
          else if(duration.toMillis() >= 1)
            gap = "MILLI";

          if(facetRangeStart2 == null)
            searchList.facetRangeStart(min.toString());
          if(facetRangeEnd2 == null)
            searchList.facetRangeEnd(max.toString());
          if(facetRangeGap2 == null)
            searchList.facetRangeGap(String.format("+1%s", gap));
          searchList.query().onSuccess(b -> {
            promise.complete(searchList);
          }).onFailure(ex -> {
            LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete(searchList);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("searchAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void searchAiTelemetryDeveloper2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<AiTelemetryDeveloper> searchList) {
  }

  public Future<Void> persistAiTelemetryDeveloper(AiTelemetryDeveloper o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
        try {
          JsonObject jsonObject = siteRequest.getJsonObject();
          jsonObject.forEach(definition -> {
              String columnName;
              Object columnValue;
            if(patch && StringUtils.startsWith(definition.getKey(), "set")) {
              columnName = StringUtils.uncapitalize(StringUtils.substringAfter(definition.getKey(), "set"));
              columnValue = definition.getValue();
            } else {
              columnName = definition.getKey();
              columnValue = definition.getValue();
            }
            if(!"".equals(columnName)) {
              try {
                o.persistForClass(columnName, columnValue);
              } catch(Exception e) {
                LOG.error(String.format("persistAiTelemetryDeveloper failed. "), e);
              }
            }
          });
          o.promiseDeepForClass(siteRequest).onSuccess(a -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("persistAiTelemetryDeveloper failed. "), ex);
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("persistAiTelemetryDeveloper failed. "), ex);
          promise.tryFail(ex);
        }
    } catch(Exception ex) {
      LOG.error(String.format("persistAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public String searchVar(String varIndexed) {
    return AiTelemetryDeveloper.searchVarAiTelemetryDeveloper(varIndexed);
  }

  @Override
  public String getClassApiAddress() {
    return AiTelemetryDeveloper.CLASS_API_ADDRESS_AiTelemetryDeveloper;
  }

  public Future<AiTelemetryDeveloper> indexAiTelemetryDeveloper(AiTelemetryDeveloper o) {
    Promise<AiTelemetryDeveloper> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      JsonObject json = new JsonObject();
      JsonObject add = new JsonObject();
      json.put("add", add);
      JsonObject doc = new JsonObject();
      add.put("doc", doc);
      o.indexAiTelemetryDeveloper(doc);
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
        LOG.error(String.format("indexAiTelemetryDeveloper failed. "), new RuntimeException(ex));
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("indexAiTelemetryDeveloper failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<AiTelemetryDeveloper> unindexAiTelemetryDeveloper(AiTelemetryDeveloper o) {
    Promise<AiTelemetryDeveloper> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      o.promiseDeepForClass(siteRequest).onSuccess(a -> {
        JsonObject json = new JsonObject();
        JsonObject delete = new JsonObject();
        json.put("delete", delete);
        String query = String.format("filter(%s:%s)", AiTelemetryDeveloper.VAR_solrId, o.obtainForClass(AiTelemetryDeveloper.VAR_solrId));
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
          LOG.error(String.format("unindexAiTelemetryDeveloper failed. "), new RuntimeException(ex));
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("unindexAiTelemetryDeveloper failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("unindexAiTelemetryDeveloper failed. "), ex);
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
      AiTelemetryDeveloper o = new AiTelemetryDeveloper();
      o.setSiteRequest_((SiteRequest)siteRequest);

      o.persistForClass(AiTelemetryDeveloper.VAR_created, AiTelemetryDeveloper.staticSetCreated(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_created), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(AiTelemetryDeveloper.VAR_name, AiTelemetryDeveloper.staticSetName(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_name)));
      o.persistForClass(AiTelemetryDeveloper.VAR_description, AiTelemetryDeveloper.staticSetDescription(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_description)));
      o.persistForClass(AiTelemetryDeveloper.VAR_archived, AiTelemetryDeveloper.staticSetArchived(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_archived)));
      o.persistForClass(AiTelemetryDeveloper.VAR_pageId, AiTelemetryDeveloper.staticSetPageId(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_pageId)));
      o.persistForClass(AiTelemetryDeveloper.VAR_courseNum, AiTelemetryDeveloper.staticSetCourseNum(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_courseNum)));
      o.persistForClass(AiTelemetryDeveloper.VAR_lessonNum, AiTelemetryDeveloper.staticSetLessonNum(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_lessonNum)));
      o.persistForClass(AiTelemetryDeveloper.VAR_authorName, AiTelemetryDeveloper.staticSetAuthorName(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_authorName)));
      o.persistForClass(AiTelemetryDeveloper.VAR_authorUrl, AiTelemetryDeveloper.staticSetAuthorUrl(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_authorUrl)));
      o.persistForClass(AiTelemetryDeveloper.VAR_pageImageUri, AiTelemetryDeveloper.staticSetPageImageUri(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_pageImageUri)));
      o.persistForClass(AiTelemetryDeveloper.VAR_objectTitle, AiTelemetryDeveloper.staticSetObjectTitle(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_objectTitle)));
      o.persistForClass(AiTelemetryDeveloper.VAR_displayPage, AiTelemetryDeveloper.staticSetDisplayPage(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_displayPage)));
      o.persistForClass(AiTelemetryDeveloper.VAR_editPage, AiTelemetryDeveloper.staticSetEditPage(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_editPage)));
      o.persistForClass(AiTelemetryDeveloper.VAR_userPage, AiTelemetryDeveloper.staticSetUserPage(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_userPage)));
      o.persistForClass(AiTelemetryDeveloper.VAR_pageImageAlt, AiTelemetryDeveloper.staticSetPageImageAlt(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_pageImageAlt)));
      o.persistForClass(AiTelemetryDeveloper.VAR_download, AiTelemetryDeveloper.staticSetDownload(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_download)));
      o.persistForClass(AiTelemetryDeveloper.VAR_prerequisiteArticleIds, AiTelemetryDeveloper.staticSetPrerequisiteArticleIds(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_prerequisiteArticleIds)));
      o.persistForClass(AiTelemetryDeveloper.VAR_solrId, AiTelemetryDeveloper.staticSetSolrId(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_solrId)));
      o.persistForClass(AiTelemetryDeveloper.VAR_nextArticleIds, AiTelemetryDeveloper.staticSetNextArticleIds(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_nextArticleIds)));
      o.persistForClass(AiTelemetryDeveloper.VAR_labelsString, AiTelemetryDeveloper.staticSetLabelsString(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_labelsString)));
      o.persistForClass(AiTelemetryDeveloper.VAR_labels, AiTelemetryDeveloper.staticSetLabels(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_labels)));
      o.persistForClass(AiTelemetryDeveloper.VAR_relatedArticleIds, AiTelemetryDeveloper.staticSetRelatedArticleIds(siteRequest2, (String)result.get(AiTelemetryDeveloper.VAR_relatedArticleIds)));

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

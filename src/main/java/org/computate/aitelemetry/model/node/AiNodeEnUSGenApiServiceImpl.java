package org.computate.aitelemetry.model.node;

import org.computate.aitelemetry.model.hub.HubEnUSApiServiceImpl;
import org.computate.aitelemetry.model.hub.Hub;
import org.computate.aitelemetry.model.cluster.ClusterEnUSApiServiceImpl;
import org.computate.aitelemetry.model.cluster.Cluster;
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
import org.computate.aitelemetry.model.node.AiNodePage;


/**
 * Translate: false
 * Generated: true
 **/
public class AiNodeEnUSGenApiServiceImpl extends BaseApiServiceImpl implements AiNodeEnUSGenApiService {

  protected static final Logger LOG = LoggerFactory.getLogger(AiNodeEnUSGenApiServiceImpl.class);

  // Search //

  @Override
  public void searchAiNode(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchAiNodeList(siteRequest2, false, true, false, "GET").onSuccess(listAiNode -> {
              response200SearchAiNode(listAiNode).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchAiNode succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchAiNode failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchAiNode failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchAiNode failed. ", ex2));
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
        LOG.error(String.format("searchAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200SearchAiNode(SearchList<AiNode> listAiNode) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
      List<String> fls = listAiNode.getRequest().getFields();
      JsonObject json = new JsonObject();
      JsonArray l = new JsonArray();
      List<String> scopes = siteRequest.getScopes();
      listAiNode.getList().stream().forEach(o -> {
        JsonObject json2 = JsonObject.mapFrom(o);
        if(fls.size() > 0) {
          Set<String> fieldNames = new HashSet<String>();
          for(String fieldName : json2.fieldNames()) {
            String v = AiNode.varIndexedAiNode(fieldName);
            if(v != null)
              fieldNames.add(AiNode.varIndexedAiNode(fieldName));
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
      response200Search(listAiNode.getRequest(), listAiNode.getResponse(), json);
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchAiNode(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchAiNode(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // GET //

  @Override
  public void getAiNode(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "GET", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "GET", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchAiNodeList(siteRequest2, false, true, false, "GET").onSuccess(listAiNode -> {
              response200GETAiNode(listAiNode).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("getAiNode succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("getAiNode failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("getAiNode failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("getAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("getAiNode failed. ", ex2));
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
        LOG.error(String.format("getAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200GETAiNode(SearchList<AiNode> listAiNode) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
      JsonObject json = JsonObject.mapFrom(listAiNode.getList().stream().findFirst().orElse(null));
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200GETAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PATCH //

  @Override
  public void patchAiNode(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("patchAiNode started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "PATCH", "PATCH", "PATCH").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "PATCH", "PATCH", "PATCH").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchAiNodeList(siteRequest2, false, true, true, "PATCH").onSuccess(listAiNode -> {
              try {
                ApiRequest apiRequest = new ApiRequest();
                apiRequest.setRows(listAiNode.getRequest().getRows());
                apiRequest.setNumFound(listAiNode.getResponse().getResponse().getNumFound());
                apiRequest.setNumPATCH(0L);
                apiRequest.initDeepApiRequest(siteRequest2);
                siteRequest2.setApiRequest_(apiRequest);
                if(apiRequest.getNumFound() == 1L)
                  apiRequest.setOriginal(listAiNode.first());
                apiRequest.setId(Optional.ofNullable(listAiNode.first()).map(o2 -> o2.getNodeResource().toString()).orElse(null));
                apiRequest.setSolrId(Optional.ofNullable(listAiNode.first()).map(o2 -> o2.getSolrId()).orElse(null));
                eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());

                listPATCHAiNode(apiRequest, listAiNode).onSuccess(e -> {
                  response200PATCHAiNode(siteRequest2).onSuccess(response -> {
                    LOG.debug(String.format("patchAiNode succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("patchAiNode failed. "), ex);
                    error(siteRequest2, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("patchAiNode failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format("patchAiNode failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("patchAiNode failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("patchAiNode failed. ", ex2));
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
        LOG.error(String.format("patchAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPATCHAiNode(ApiRequest apiRequest, SearchList<AiNode> listAiNode) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
    listAiNode.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      AiNode o2 = jsonObject.mapTo(AiNode.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        patchAiNodeFuture(o2, false).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listPATCHAiNode failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listAiNode.next().onSuccess(next -> {
        if(next) {
          listPATCHAiNode(apiRequest, listAiNode).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPATCHAiNode failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listPATCHAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listPATCHAiNode failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void patchAiNodeFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        searchAiNodeList(siteRequest, false, true, true, "PATCH").onSuccess(listAiNode -> {
          try {
            AiNode o = listAiNode.first();
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
            AiNode o2;
            if(o != null) {
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listAiNode.first()).map(o3 -> o3.getNodeResource().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listAiNode.first()).map(o3 -> o3.getSolrId()).orElse(null));
              JsonObject jsonObject = JsonObject.mapFrom(o);
              o2 = jsonObject.mapTo(AiNode.class);
              o2.setSiteRequest_(siteRequest);
              patchAiNodeFuture(o2, false).onSuccess(o3 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else if(refresh) {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            } else {
              String m = String.format("%s %s not found", "AI node", null);
              eventHandler.handle(Future.failedFuture(m));
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchAiNode failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("patchAiNode failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("patchAiNode failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<AiNode> patchAiNodeFuture(AiNode o, Boolean inheritPrimaryKey) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<AiNode> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<AiNode> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsAiNode(siteRequest).onSuccess(a -> {
          upsertAiNode(o, inheritPrimaryKey, true).onSuccess(c -> {
            sqlPATCHAiNode(o, inheritPrimaryKey).onSuccess(aiNode -> {
              persistAiNode(aiNode, true).onSuccess(d -> {
                relateAiNode(aiNode).onSuccess(e -> {
                  indexAiNode(aiNode).onSuccess(o2 -> {
                    if(apiRequest != null) {
                      apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                      if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                        o2.apiRequestAiNode();
                        if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                          eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());
                      }
                    }
                    promise1.complete(aiNode);
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
      }).compose(aiNode -> {
        Promise<AiNode> promise2 = Promise.promise();
        refreshAiNode(aiNode).onSuccess(a -> {
          promise2.complete(aiNode);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(aiNode -> {
        promise.complete(aiNode);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("patchAiNodeFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<AiNode> sqlPATCHAiNode(AiNode o, Boolean inheritPrimaryKey) {
    Promise<AiNode> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE AiNode SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Set<String> methodNames = jsonObject.fieldNames();
      AiNode o2 = new AiNode();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      for(String entityVar : methodNames) {
        switch(entityVar) {
          case "setHubId":
              o2.setHubId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_hubId + "=$" + num);
              num++;
              bParams.add(o2.sqlHubId());
            break;
          case "setHubResource":
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Hub.varIndexedHub(Hub.VAR_hubResource), Hub.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Hub");
                  }
                  sql(siteRequest).update(AiNode.class, pk).set(AiNode.VAR_hubResource, Hub.class, solrId2, val).onSuccess(a -> {
                    promise2.complete();
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          case "removeHubResource":
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(solrId2 -> {
              futures2.add(Future.future(promise2 -> {
                sql(siteRequest).update(AiNode.class, pk).setToNull(AiNode.VAR_hubResource, Hub.class, null).onSuccess(a -> {
                  promise2.complete();
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          case "setClusterName":
              o2.setClusterName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_clusterName + "=$" + num);
              num++;
              bParams.add(o2.sqlClusterName());
            break;
          case "setClusterResource":
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Cluster.varIndexedCluster(Cluster.VAR_clusterResource), Cluster.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Cluster");
                  }
                  sql(siteRequest).update(AiNode.class, pk).set(AiNode.VAR_clusterResource, Cluster.class, solrId2, val).onSuccess(a -> {
                    promise2.complete();
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          case "removeClusterResource":
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(solrId2 -> {
              futures2.add(Future.future(promise2 -> {
                sql(siteRequest).update(AiNode.class, pk).setToNull(AiNode.VAR_clusterResource, Cluster.class, null).onSuccess(a -> {
                  promise2.complete();
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          case "setNodeName":
              o2.setNodeName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_nodeName + "=$" + num);
              num++;
              bParams.add(o2.sqlNodeName());
            break;
          case "setNodeResource":
              o2.setNodeResource(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_nodeResource + "=$" + num);
              num++;
              bParams.add(o2.sqlNodeResource());
            break;
          case "setDescription":
              o2.setDescription(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_description + "=$" + num);
              num++;
              bParams.add(o2.sqlDescription());
            break;
          case "setLocation":
              o2.setLocation(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_location + "=$" + num);
              num++;
              bParams.add(o2.sqlLocation());
            break;
          case "setGpuDevicesTotal":
              o2.setGpuDevicesTotal(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_gpuDevicesTotal + "=$" + num);
              num++;
              bParams.add(o2.sqlGpuDevicesTotal());
            break;
          case "setId":
              o2.setId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_id + "=$" + num);
              num++;
              bParams.add(o2.sqlId());
            break;
          case "setNgsildTenant":
              o2.setNgsildTenant(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_ngsildTenant + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildTenant());
            break;
          case "setNgsildPath":
              o2.setNgsildPath(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_ngsildPath + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildPath());
            break;
          case "setNgsildContext":
              o2.setNgsildContext(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_ngsildContext + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildContext());
            break;
          case "setNgsildData":
              o2.setNgsildData(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_ngsildData + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildData());
            break;
          case "setCreated":
              o2.setCreated(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_created + "=$" + num);
              num++;
              bParams.add(o2.sqlCreated());
            break;
          case "setArchived":
              o2.setArchived(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_archived + "=$" + num);
              num++;
              bParams.add(o2.sqlArchived());
            break;
          case "setSessionId":
              o2.setSessionId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_sessionId + "=$" + num);
              num++;
              bParams.add(o2.sqlSessionId());
            break;
          case "setUserKey":
              o2.setUserKey(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_userKey + "=$" + num);
              num++;
              bParams.add(o2.sqlUserKey());
            break;
          case "setObjectTitle":
              o2.setObjectTitle(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_objectTitle + "=$" + num);
              num++;
              bParams.add(o2.sqlObjectTitle());
            break;
          case "setApiUrl":
              o2.setApiUrl(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_apiUrl + "=$" + num);
              num++;
              bParams.add(o2.sqlApiUrl());
            break;
          case "setDisplayPage":
              o2.setDisplayPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_displayPage + "=$" + num);
              num++;
              bParams.add(o2.sqlDisplayPage());
            break;
          case "setEditPage":
              o2.setEditPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_editPage + "=$" + num);
              num++;
              bParams.add(o2.sqlEditPage());
            break;
          case "setUserPage":
              o2.setUserPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_userPage + "=$" + num);
              num++;
              bParams.add(o2.sqlUserPage());
            break;
          case "setDownload":
              o2.setDownload(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(AiNode.VAR_download + "=$" + num);
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
            RuntimeException ex2 = new RuntimeException("value AiNode failed", ex);
            LOG.error(String.format("relateAiNode failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          AiNode o3 = new AiNode();
          o3.setSiteRequest_(o.getSiteRequest_());
          o3.setPk(pk);
          promise.complete(o3);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPATCHAiNode failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPATCHAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPATCHAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200PATCHAiNode(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PATCHAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // POST //

  @Override
  public void postAiNode(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("postAiNode started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "POST", "POST", "POST").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "POST", "POST", "POST").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setRows(1L);
            apiRequest.setNumFound(1L);
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest2);
            siteRequest2.setApiRequest_(apiRequest);
            eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());
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
            eventBus.request(AiNode.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postAiNodeFuture")).onSuccess(a -> {
              JsonObject responseMessage = (JsonObject)a.body();
              JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
              apiRequest.setSolrId(responseBody.getString(AiNode.VAR_solrId));
              response200POSTAiNode(siteRequest2, responseBody).onSuccess(response -> {
                LOG.debug(String.format("postAiNode succeeded. "));
                eventHandler.handle(Future.succeededFuture(response));
              }).onFailure(ex -> {
                LOG.error(String.format("postAiNode failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("postAiNode failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("postAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postAiNode failed. ", ex2));
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
        LOG.error(String.format("postAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  @Override
  public void postAiNodeFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        postAiNodeFuture(siteRequest, false).onSuccess(o -> {
          eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
        }).onFailure(ex -> {
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Throwable ex) {
        LOG.error(String.format("postAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postAiNode failed. ", ex2));
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
        LOG.error(String.format("postAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<AiNode> postAiNodeFuture(SiteRequest siteRequest, Boolean nodeResource) {
    Promise<AiNode> promise = Promise.promise();

    try {
      pgPool.withTransaction(sqlConnection -> {
        Promise<AiNode> promise1 = Promise.promise();
        siteRequest.setSqlConnection(sqlConnection);
        varsAiNode(siteRequest).onSuccess(a -> {
          createAiNode(siteRequest).onSuccess(aiNode -> {
            upsertAiNode(aiNode, nodeResource, false).onSuccess(b -> {
              sqlPOSTAiNode(aiNode, nodeResource).onSuccess(c -> {
                persistAiNode(aiNode, false).onSuccess(d -> {
                  relateAiNode(aiNode).onSuccess(e -> {
                    indexAiNode(aiNode).onSuccess(o2 -> {
                      promise1.complete(aiNode);
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
      }).compose(aiNode -> {
        Promise<AiNode> promise2 = Promise.promise();
        refreshAiNode(aiNode).onSuccess(a -> {
          try {
            ApiRequest apiRequest = siteRequest.getApiRequest_();
            if(apiRequest != null) {
              apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
              aiNode.apiRequestAiNode();
              eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());
            }
            promise2.complete(aiNode);
          } catch(Exception ex) {
            LOG.error(String.format("postAiNodeFuture failed. "), ex);
            promise2.tryFail(ex);
          }
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(aiNode -> {
        try {
          ApiRequest apiRequest = siteRequest.getApiRequest_();
          if(apiRequest != null) {
            apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
            aiNode.apiRequestAiNode();
            eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());
          }
          promise.complete(aiNode);
        } catch(Exception ex) {
          LOG.error(String.format("postAiNodeFuture failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("postAiNodeFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<AiNode> sqlPOSTAiNode(AiNode o, Boolean inheritPrimaryKey) {
    Promise<AiNode> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE AiNode SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      AiNode o2 = new AiNode();
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

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
          case AiNode.VAR_hubId:
            o2.setHubId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_hubId + "=$" + num);
            num++;
            bParams.add(o2.sqlHubId());
            break;
          case AiNode.VAR_hubResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Hub.varIndexedHub(Hub.VAR_hubResource), Hub.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Hub");
                  }
                  sql(siteRequest).update(AiNode.class, pk).set(AiNode.VAR_hubResource, Hub.class, solrId2, val).onSuccess(a -> {
                    promise2.complete();
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          case AiNode.VAR_clusterName:
            o2.setClusterName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_clusterName + "=$" + num);
            num++;
            bParams.add(o2.sqlClusterName());
            break;
          case AiNode.VAR_clusterResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Cluster.varIndexedCluster(Cluster.VAR_clusterResource), Cluster.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Cluster");
                  }
                  sql(siteRequest).update(AiNode.class, pk).set(AiNode.VAR_clusterResource, Cluster.class, solrId2, val).onSuccess(a -> {
                    promise2.complete();
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          case AiNode.VAR_nodeName:
            o2.setNodeName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_nodeName + "=$" + num);
            num++;
            bParams.add(o2.sqlNodeName());
            break;
          case AiNode.VAR_nodeResource:
            o2.setNodeResource(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_nodeResource + "=$" + num);
            num++;
            bParams.add(o2.sqlNodeResource());
            break;
          case AiNode.VAR_description:
            o2.setDescription(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_description + "=$" + num);
            num++;
            bParams.add(o2.sqlDescription());
            break;
          case AiNode.VAR_location:
            o2.setLocation(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_location + "=$" + num);
            num++;
            bParams.add(o2.sqlLocation());
            break;
          case AiNode.VAR_gpuDevicesTotal:
            o2.setGpuDevicesTotal(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_gpuDevicesTotal + "=$" + num);
            num++;
            bParams.add(o2.sqlGpuDevicesTotal());
            break;
          case AiNode.VAR_id:
            o2.setId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_id + "=$" + num);
            num++;
            bParams.add(o2.sqlId());
            break;
          case AiNode.VAR_ngsildTenant:
            o2.setNgsildTenant(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_ngsildTenant + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildTenant());
            break;
          case AiNode.VAR_ngsildPath:
            o2.setNgsildPath(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_ngsildPath + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildPath());
            break;
          case AiNode.VAR_ngsildContext:
            o2.setNgsildContext(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_ngsildContext + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildContext());
            break;
          case AiNode.VAR_ngsildData:
            o2.setNgsildData(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_ngsildData + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildData());
            break;
          case AiNode.VAR_created:
            o2.setCreated(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_created + "=$" + num);
            num++;
            bParams.add(o2.sqlCreated());
            break;
          case AiNode.VAR_archived:
            o2.setArchived(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_archived + "=$" + num);
            num++;
            bParams.add(o2.sqlArchived());
            break;
          case AiNode.VAR_userKey:
            o2.setUserKey(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_userKey + "=$" + num);
            num++;
            bParams.add(o2.sqlUserKey());
            break;
          case AiNode.VAR_objectTitle:
            o2.setObjectTitle(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_objectTitle + "=$" + num);
            num++;
            bParams.add(o2.sqlObjectTitle());
            break;
          case AiNode.VAR_apiUrl:
            o2.setApiUrl(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_apiUrl + "=$" + num);
            num++;
            bParams.add(o2.sqlApiUrl());
            break;
          case AiNode.VAR_displayPage:
            o2.setDisplayPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_displayPage + "=$" + num);
            num++;
            bParams.add(o2.sqlDisplayPage());
            break;
          case AiNode.VAR_editPage:
            o2.setEditPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_editPage + "=$" + num);
            num++;
            bParams.add(o2.sqlEditPage());
            break;
          case AiNode.VAR_userPage:
            o2.setUserPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_userPage + "=$" + num);
            num++;
            bParams.add(o2.sqlUserPage());
            break;
          case AiNode.VAR_download:
            o2.setDownload(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(AiNode.VAR_download + "=$" + num);
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
            RuntimeException ex2 = new RuntimeException("value AiNode failed", ex);
            LOG.error(String.format("relateAiNode failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete(o2);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPOSTAiNode failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPOSTAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPOSTAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200POSTAiNode(SiteRequest siteRequest, JsonObject json) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200POSTAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // DELETE //

  @Override
  public void deleteAiNode(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deleteAiNode started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "DELETE", "DELETE", "DELETE").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "DELETE", "DELETE", "DELETE").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchAiNodeList(siteRequest2, false, true, true, "DELETE").onSuccess(listAiNode -> {
              try {
                ApiRequest apiRequest = new ApiRequest();
                apiRequest.setRows(listAiNode.getRequest().getRows());
                apiRequest.setNumFound(listAiNode.getResponse().getResponse().getNumFound());
                apiRequest.setNumPATCH(0L);
                apiRequest.initDeepApiRequest(siteRequest2);
                siteRequest2.setApiRequest_(apiRequest);
                if(apiRequest.getNumFound() == 1L)
                  apiRequest.setOriginal(listAiNode.first());
                apiRequest.setSolrId(Optional.ofNullable(listAiNode.first()).map(o2 -> o2.getSolrId()).orElse(null));
                eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());

                listDELETEAiNode(apiRequest, listAiNode).onSuccess(e -> {
                  response200DELETEAiNode(siteRequest2).onSuccess(response -> {
                    LOG.debug(String.format("deleteAiNode succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("deleteAiNode failed. "), ex);
                    error(siteRequest2, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("deleteAiNode failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format("deleteAiNode failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("deleteAiNode failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deleteAiNode failed. ", ex2));
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
        LOG.error(String.format("deleteAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEAiNode(ApiRequest apiRequest, SearchList<AiNode> listAiNode) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
    listAiNode.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      AiNode o2 = jsonObject.mapTo(AiNode.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deleteAiNodeFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEAiNode failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listAiNode.next().onSuccess(next -> {
        if(next) {
          listDELETEAiNode(apiRequest, listAiNode).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEAiNode failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEAiNode failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deleteAiNodeFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        searchAiNodeList(siteRequest, false, true, true, "DELETE").onSuccess(listAiNode -> {
          try {
            AiNode o = listAiNode.first();
            if(o != null && listAiNode.getResponse().getResponse().getNumFound() == 1) {
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
              apiRequest.setId(Optional.ofNullable(listAiNode.first()).map(o2 -> o2.getNodeResource().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listAiNode.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deleteAiNodeFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deleteAiNode failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deleteAiNode failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deleteAiNode failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<AiNode> deleteAiNodeFuture(AiNode o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<AiNode> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<AiNode> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsAiNode(siteRequest).onSuccess(a -> {
          sqlDELETEAiNode(o).onSuccess(aiNode -> {
            relateAiNode(o).onSuccess(d -> {
              unindexAiNode(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestAiNode();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());
                  }
                }
                promise1.complete();
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
      }).compose(aiNode -> {
        Promise<AiNode> promise2 = Promise.promise();
        refreshAiNode(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(aiNode -> {
        promise.complete(aiNode);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deleteAiNodeFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETEAiNode(AiNode o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM AiNode ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      AiNode o2 = new AiNode();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
          case AiNode.VAR_hubResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Hub.varIndexedHub(Hub.VAR_hubResource), Hub.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Hub");
                  }
                  sql(siteRequest).update(AiNode.class, pk).set(AiNode.VAR_hubResource, Hub.class, null, null).onSuccess(a -> {
                    promise2.complete();
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          case AiNode.VAR_clusterResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Cluster.varIndexedCluster(Cluster.VAR_clusterResource), Cluster.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Cluster");
                  }
                  sql(siteRequest).update(AiNode.class, pk).set(AiNode.VAR_clusterResource, Cluster.class, null, null).onSuccess(a -> {
                    promise2.complete();
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          }
        }
      }
      bSql.append(" WHERE pk=$" + num);
      bParams.add(pk);
      num++;
      futures2.add(0, Future.future(a -> {
        sqlConnection.preparedQuery(bSql.toString())
            .execute(Tuple.tuple(bParams)
            ).onSuccess(b -> {
          a.handle(Future.succeededFuture());
        }).onFailure(ex -> {
          RuntimeException ex2 = new RuntimeException("value AiNode failed", ex);
          LOG.error(String.format("unrelateAiNode failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETEAiNode failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETEAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETEAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEAiNode(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PUTImport //

  @Override
  public void putimportAiNode(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("putimportAiNode started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "PUTImport", "PUT", "PUT").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "PUTImport", "PUT", "PUT").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            ApiRequest apiRequest = new ApiRequest();
            JsonArray jsonArray = Optional.ofNullable(siteRequest2.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
            apiRequest.setRows(Long.valueOf(jsonArray.size()));
            apiRequest.setNumFound(Long.valueOf(jsonArray.size()));
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest2);
            siteRequest2.setApiRequest_(apiRequest);
            eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());
            varsAiNode(siteRequest2).onSuccess(d -> {
              listPUTImportAiNode(apiRequest, siteRequest2).onSuccess(e -> {
                response200PUTImportAiNode(siteRequest2).onSuccess(response -> {
                  LOG.debug(String.format("putimportAiNode succeeded. "));
                  eventHandler.handle(Future.succeededFuture(response));
                }).onFailure(ex -> {
                  LOG.error(String.format("putimportAiNode failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("putimportAiNode failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("putimportAiNode failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportAiNode failed. ", ex2));
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
        LOG.error(String.format("putimportAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPUTImportAiNode(ApiRequest apiRequest, SiteRequest siteRequest) {
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
          eventBus.request(AiNode.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "putimportAiNodeFuture")).onSuccess(a -> {
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPUTImportAiNode failed. "), ex);
            promise1.tryFail(ex);
          });
        }));
      });
      CompositeFuture.all(futures).onSuccess(a -> {
        apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("listPUTImportAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("listPUTImportAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public void putimportAiNodeFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        String nodeResource = Optional.ofNullable(body.getString(AiNode.VAR_nodeResource)).orElse(body.getString(AiNode.VAR_solrId));
        if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
          siteRequest.getRequestVars().put( "refresh", "false" );
        }
        pgPool.getConnection().onSuccess(sqlConnection -> {
          String sqlQuery = String.format("select * from %s WHERE nodeResource=$1", AiNode.CLASS_SIMPLE_NAME);
          sqlConnection.preparedQuery(sqlQuery)
              .execute(Tuple.tuple(Arrays.asList(nodeResource))
              ).onSuccess(result -> {
            sqlConnection.close().onSuccess(a -> {
              try {
                if(result.size() >= 1) {
                  AiNode o = new AiNode();
                  o.setSiteRequest_(siteRequest);
                  for(Row definition : result.value()) {
                    for(Integer i = 0; i < definition.size(); i++) {
                      try {
                        String columnName = definition.getColumnName(i);
                        Object columnValue = definition.getValue(i);
                        o.persistForClass(columnName, columnValue);
                      } catch(Exception e) {
                        LOG.error(String.format("persistAiNode failed. "), e);
                      }
                    }
                  }
                  AiNode o2 = new AiNode();
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
                      if(!StringUtils.containsAny(f, "nodeResource", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                        body2.put("set" + StringUtils.capitalize(f), bodyVal);
                    }
                  }
                  for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
                    if(!body.fieldNames().contains(f)) {
                      if(!StringUtils.containsAny(f, "nodeResource", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                        body2.putNull("set" + StringUtils.capitalize(f));
                    }
                  }
                  if(result.size() >= 1) {
                    apiRequest.setOriginal(o);
                    apiRequest.setId(Optional.ofNullable(o.getNodeResource()).map(v -> v.toString()).orElse(null));
                    apiRequest.setSolrId(o.getSolrId());
                  }
                  siteRequest.setJsonObject(body2);
                  patchAiNodeFuture(o, true).onSuccess(b -> {
                    LOG.debug("Import AiNode {} succeeded, modified AiNode. ", body.getValue(AiNode.VAR_nodeResource));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportAiNodeFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                } else {
                  postAiNodeFuture(siteRequest, true).onSuccess(b -> {
                    LOG.debug("Import AiNode {} succeeded, created new AiNode. ", body.getValue(AiNode.VAR_nodeResource));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportAiNodeFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                }
              } catch(Exception ex) {
                LOG.error(String.format("putimportAiNodeFuture failed. "), ex);
                eventHandler.handle(Future.failedFuture(ex));
              }
            }).onFailure(ex -> {
              LOG.error(String.format("putimportAiNodeFuture failed. "), ex);
              eventHandler.handle(Future.failedFuture(ex));
            });
          }).onFailure(ex -> {
            LOG.error(String.format("putimportAiNodeFuture failed. "), ex);
            eventHandler.handle(Future.failedFuture(ex));
          });
        }).onFailure(ex -> {
          LOG.error(String.format("putimportAiNodeFuture failed. "), ex);
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportAiNodeFuture failed. "), ex);
        eventHandler.handle(Future.failedFuture(ex));
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportAiNode failed. ", ex2));
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
        LOG.error(String.format("putimportAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200PUTImportAiNode(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PUTImportAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // SearchPage //

  @Override
  public void searchpageAiNode(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    oauth2AuthenticationProvider.refresh(User.create(serviceRequest.getUser())).onSuccess(user -> {
      serviceRequest.setUser(user.principal());
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchAiNodeList(siteRequest2, false, true, false, "GET").onSuccess(listAiNode -> {
              response200SearchPageAiNode(listAiNode).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchpageAiNode succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchpageAiNode failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchpageAiNode failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchpageAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageAiNode failed. ", ex2));
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
        LOG.error(String.format("searchpageAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageAiNode failed. ", ex2));
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
        LOG.error(String.format("searchpageAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void searchpageAiNodePageInit(JsonObject ctx, AiNodePage page, SearchList<AiNode> listAiNode, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/ai-node"));
    ctx.put("enUSUrlPage", String.format("%s%s", siteBaseUrl, "/en-us/search/ai-node"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriSearchPageAiNode(ServiceRequest serviceRequest, AiNode result) {
    return "en-us/search/ai-node/AiNodeSearchPage.htm";
  }
  public void templateSearchPageAiNode(JsonObject ctx, AiNodePage page, SearchList<AiNode> listAiNode, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      AiNode result = listAiNode.first();
      String pageTemplateUri = templateUriSearchPageAiNode(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/search/ai-node/AiNodeSearchPage.htm"), Charset.forName("UTF-8"));
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
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/ai-node/AiNodeGenEditPage.htm")).orElse("en-us/Article.htm");
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
      LOG.error(String.format("templateSearchPageAiNode failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200SearchPageAiNode(SearchList<AiNode> listAiNode) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
      AiNodePage page = new AiNodePage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listAiNode.size() >= 1)
        siteRequest.setRequestPk(listAiNode.get(0).getPk());
      page.setSearchListAiNode_(listAiNode);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepAiNodePage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          searchpageAiNodePageInit(ctx, page, listAiNode, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateSearchPageAiNode(ctx, page, listAiNode, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200SearchPageAiNode failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200SearchPageAiNode failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200SearchPageAiNode failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchPageAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchPageAiNode(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchPageAiNode(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // EditPage //

  @Override
  public void editpageAiNode(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "EditPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "EditPage", "GET", "GET").onSuccess(siteRequest2 -> {
            searchAiNodeList(siteRequest2, false, true, false, "GET").onSuccess(listAiNode -> {
              response200EditPageAiNode(listAiNode).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("editpageAiNode succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("editpageAiNode failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
          }).onFailure(ex -> {
              LOG.error(String.format("editpageAiNode failed. "), ex);
              error(siteRequest, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("editpageAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("editpageAiNode failed. ", ex2));
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
        LOG.error(String.format("editpageAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void editpageAiNodePageInit(JsonObject ctx, AiNodePage page, SearchList<AiNode> listAiNode, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/ai-node"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriEditPageAiNode(ServiceRequest serviceRequest, AiNode result) {
    return "en-us/edit/ai-node/AiNodeEditPage.htm";
  }
  public void templateEditPageAiNode(JsonObject ctx, AiNodePage page, SearchList<AiNode> listAiNode, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      AiNode result = listAiNode.first();
      String pageTemplateUri = templateUriEditPageAiNode(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/edit/ai-node/AiNodeEditPage.htm"), Charset.forName("UTF-8"));
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
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/ai-node/AiNodeGenEditPage.htm")).orElse("en-us/Article.htm");
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
      LOG.error(String.format("templateEditPageAiNode failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200EditPageAiNode(SearchList<AiNode> listAiNode) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
      AiNodePage page = new AiNodePage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listAiNode.size() >= 1)
        siteRequest.setRequestPk(listAiNode.get(0).getPk());
      page.setSearchListAiNode_(listAiNode);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepAiNodePage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          editpageAiNodePageInit(ctx, page, listAiNode, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateEditPageAiNode(ctx, page, listAiNode, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200EditPageAiNode failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200EditPageAiNode failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200EditPageAiNode failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200EditPageAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotEditPageAiNode(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotEditPageAiNode(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // UserPage //

  @Override
  public void userpageAiNode(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "UserPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "UserPage", "GET", "GET").onSuccess(siteRequest2 -> {
            searchAiNodeList(siteRequest2, false, true, false, "GET").onSuccess(listAiNode -> {
              response200UserPageAiNode(listAiNode).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("userpageAiNode succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("userpageAiNode failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
          }).onFailure(ex -> {
              LOG.error(String.format("userpageAiNode failed. "), ex);
              error(siteRequest, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("userpageAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("userpageAiNode failed. ", ex2));
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
        LOG.error(String.format("userpageAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void userpageAiNodePageInit(JsonObject ctx, AiNodePage page, SearchList<AiNode> listAiNode, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/ai-node"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriUserPageAiNode(ServiceRequest serviceRequest, AiNode result) {
    return String.format("%s.htm", StringUtils.substringBefore(serviceRequest.getExtra().getString("uri").substring(1), "?"));
  }
  public void templateUserPageAiNode(JsonObject ctx, AiNodePage page, SearchList<AiNode> listAiNode, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      AiNode result = listAiNode.first();
      String pageTemplateUri = templateUriUserPageAiNode(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "%s.htm"), Charset.forName("UTF-8"));
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
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/ai-node/AiNodeGenEditPage.htm")).orElse("en-us/Article.htm");
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
      LOG.error(String.format("templateUserPageAiNode failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200UserPageAiNode(SearchList<AiNode> listAiNode) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
      AiNodePage page = new AiNodePage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listAiNode.size() >= 1)
        siteRequest.setRequestPk(listAiNode.get(0).getPk());
      page.setSearchListAiNode_(listAiNode);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepAiNodePage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          userpageAiNodePageInit(ctx, page, listAiNode, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateUserPageAiNode(ctx, page, listAiNode, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200UserPageAiNode failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200UserPageAiNode failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200UserPageAiNode failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200UserPageAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotUserPageAiNode(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotUserPageAiNode(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // DELETEFilter //

  @Override
  public void deletefilterAiNode(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deletefilterAiNode started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        AiNode.authorizationAiNode(siteRequest, webClient, classPublicRead, "DELETEFilter", "DELETE", "DELETE").onSuccess(authorizationDecisionResponse -> {
          AiNode.authorizationScopesAiNode(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "DELETEFilter", "DELETE", "DELETE").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchAiNodeList(siteRequest2, false, true, true, "DELETE").onSuccess(listAiNode -> {
              try {
                ApiRequest apiRequest = new ApiRequest();
                apiRequest.setRows(listAiNode.getRequest().getRows());
                apiRequest.setNumFound(listAiNode.getResponse().getResponse().getNumFound());
                apiRequest.setNumPATCH(0L);
                apiRequest.initDeepApiRequest(siteRequest2);
                siteRequest2.setApiRequest_(apiRequest);
                if(apiRequest.getNumFound() == 1L)
                  apiRequest.setOriginal(listAiNode.first());
                apiRequest.setSolrId(Optional.ofNullable(listAiNode.first()).map(o2 -> o2.getSolrId()).orElse(null));
                eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());

                listDELETEFilterAiNode(apiRequest, listAiNode).onSuccess(e -> {
                  response200DELETEFilterAiNode(siteRequest2).onSuccess(response -> {
                    LOG.debug(String.format("deletefilterAiNode succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("deletefilterAiNode failed. "), ex);
                    error(siteRequest2, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("deletefilterAiNode failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format("deletefilterAiNode failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("deletefilterAiNode failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deletefilterAiNode failed. ", ex2));
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
        LOG.error(String.format("deletefilterAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEFilterAiNode(ApiRequest apiRequest, SearchList<AiNode> listAiNode) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listAiNode.getSiteRequest_(SiteRequest.class);
    listAiNode.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      AiNode o2 = jsonObject.mapTo(AiNode.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deletefilterAiNodeFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEFilterAiNode failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listAiNode.next().onSuccess(next -> {
        if(next) {
          listDELETEFilterAiNode(apiRequest, listAiNode).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEFilterAiNode failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEFilterAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEFilterAiNode failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deletefilterAiNodeFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        searchAiNodeList(siteRequest, false, true, true, "DELETE").onSuccess(listAiNode -> {
          try {
            AiNode o = listAiNode.first();
            if(o != null && listAiNode.getResponse().getResponse().getNumFound() == 1) {
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
              apiRequest.setId(Optional.ofNullable(listAiNode.first()).map(o2 -> o2.getNodeResource().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listAiNode.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deletefilterAiNodeFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deletefilterAiNode failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deletefilterAiNode failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterAiNode failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deletefilterAiNode failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<AiNode> deletefilterAiNodeFuture(AiNode o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<AiNode> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<AiNode> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsAiNode(siteRequest).onSuccess(a -> {
          sqlDELETEFilterAiNode(o).onSuccess(aiNode -> {
            relateAiNode(o).onSuccess(d -> {
              unindexAiNode(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestAiNode();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketAiNode", JsonObject.mapFrom(apiRequest).toString());
                  }
                }
                promise1.complete();
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
      }).compose(aiNode -> {
        Promise<AiNode> promise2 = Promise.promise();
        refreshAiNode(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(aiNode -> {
        promise.complete(aiNode);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deletefilterAiNodeFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETEFilterAiNode(AiNode o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM AiNode ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      AiNode o2 = new AiNode();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
          case AiNode.VAR_hubResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Hub.varIndexedHub(Hub.VAR_hubResource), Hub.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Hub");
                  }
                  sql(siteRequest).update(AiNode.class, pk).set(AiNode.VAR_hubResource, Hub.class, null, null).onSuccess(a -> {
                    promise2.complete();
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          case AiNode.VAR_clusterResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Cluster.varIndexedCluster(Cluster.VAR_clusterResource), Cluster.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Cluster");
                  }
                  sql(siteRequest).update(AiNode.class, pk).set(AiNode.VAR_clusterResource, Cluster.class, null, null).onSuccess(a -> {
                    promise2.complete();
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          }
        }
      }
      bSql.append(" WHERE pk=$" + num);
      bParams.add(pk);
      num++;
      futures2.add(0, Future.future(a -> {
        sqlConnection.preparedQuery(bSql.toString())
            .execute(Tuple.tuple(bParams)
            ).onSuccess(b -> {
          a.handle(Future.succeededFuture());
        }).onFailure(ex -> {
          RuntimeException ex2 = new RuntimeException("value AiNode failed", ex);
          LOG.error(String.format("unrelateAiNode failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETEFilterAiNode failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETEFilterAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETEFilterAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEFilterAiNode(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEFilterAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // General //

  public Future<AiNode> createAiNode(SiteRequest siteRequest) {
    Promise<AiNode> promise = Promise.promise();
    try {
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      String userId = siteRequest.getUserId();
      Long userKey = siteRequest.getUserKey();
      ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

      sqlConnection.preparedQuery("INSERT INTO AiNode(created, userKey) VALUES($1, $2) RETURNING pk")
          .collecting(Collectors.toList())
          .execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
        Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
        Long pk = createLine.getLong(0);
        AiNode o = new AiNode();
        o.setPk(pk);
        o.setSiteRequest_(siteRequest);
        promise.complete(o);
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error("createAiNode failed. ", ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("createAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public void searchAiNodeQ(SearchList<AiNode> searchList, String entityVar, String valueIndexed, String varIndexed) {
    searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
    if(!"*".equals(entityVar)) {
    }
  }

  public String searchAiNodeFq(SearchList<AiNode> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    if(StringUtils.startsWith(valueIndexed, "[")) {
      String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
      if(fqs.length != 2)
        throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
      String fq1 = fqs[0].equals("*") ? fqs[0] : AiNode.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
      String fq2 = fqs[1].equals("*") ? fqs[1] : AiNode.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
       return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
    } else {
      return varIndexed + ":" + SearchTool.escapeQueryChars(AiNode.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
    }
  }

  public void searchAiNodeSort(SearchList<AiNode> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    searchList.sort(varIndexed, valueIndexed);
  }

  public void searchAiNodeRows(SearchList<AiNode> searchList, Long valueRows) {
      searchList.rows(valueRows != null ? valueRows : 10L);
  }

  public void searchAiNodeStart(SearchList<AiNode> searchList, Long valueStart) {
    searchList.start(valueStart);
  }

  public void searchAiNodeVar(SearchList<AiNode> searchList, String var, String value) {
    searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
  }

  public void searchAiNodeUri(SearchList<AiNode> searchList) {
  }

  public Future<ServiceResponse> varsAiNode(SiteRequest siteRequest) {
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
          LOG.error(String.format("searchAiNode failed. "), ex);
          promise.tryFail(ex);
        }
      });
      promise.complete();
    } catch(Exception ex) {
      LOG.error(String.format("searchAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SearchList<AiNode>> searchAiNodeList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, String scope) {
    Promise<SearchList<AiNode>> promise = Promise.promise();
    try {
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
      String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
      SearchList<AiNode> searchList = new SearchList<AiNode>();
      searchList.setScope(scope);
      String facetRange = null;
      Date facetRangeStart = null;
      Date facetRangeEnd = null;
      String facetRangeGap = null;
      String statsField = null;
      String statsFieldIndexed = null;
      searchList.setPopulate(populate);
      searchList.setStore(store);
      searchList.q("*:*");
      searchList.setC(AiNode.class);
      searchList.setSiteRequest_(siteRequest);
      searchList.facetMinCount(1);
      if(entityList != null) {
        for(String v : entityList) {
          searchList.fl(AiNode.varIndexedAiNode(v));
        }
      }

      String nodeResource = serviceRequest.getParams().getJsonObject("path").getString("nodeResource");
      if(nodeResource != null) {
        searchList.fq("nodeResource_docvalues_string:" + SearchTool.escapeQueryChars(nodeResource));
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
                varsIndexed[i] = AiNode.varIndexedAiNode(entityVar);
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
                  varIndexed = AiNode.varIndexedAiNode(entityVar);
                  String entityQ = searchAiNodeFq(searchList, entityVar, valueIndexed, varIndexed);
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
                  varIndexed = AiNode.varIndexedAiNode(entityVar);
                  String entityFq = searchAiNodeFq(searchList, entityVar, valueIndexed, varIndexed);
                  mFq.appendReplacement(sb, entityFq);
                }
                if(!sb.isEmpty()) {
                  mFq.appendTail(sb);
                  searchList.fq(sb.toString());
                }
              } else if(paramName.equals("sort")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
                valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
                varIndexed = AiNode.varIndexedAiNode(entityVar);
                searchAiNodeSort(searchList, entityVar, valueIndexed, varIndexed);
              } else if(paramName.equals("start")) {
                valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchAiNodeStart(searchList, valueStart);
              } else if(paramName.equals("rows")) {
                valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchAiNodeRows(searchList, valueRows);
              } else if(paramName.equals("stats")) {
                searchList.stats((Boolean)paramObject);
              } else if(paramName.equals("stats.field")) {
                Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mStats.find()) {
                  String solrLocalParams = mStats.group(1);
                  entityVar = mStats.group(2).trim();
                  varIndexed = AiNode.varIndexedAiNode(entityVar);
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
                  varIndexed = AiNode.varIndexedAiNode(entityVar);
                  searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  facetRange = entityVar;
                }
              } else if(paramName.equals("facet.field")) {
                entityVar = (String)paramObject;
                varIndexed = AiNode.varIndexedAiNode(entityVar);
                if(varIndexed != null)
                  searchList.facetField(varIndexed);
              } else if(paramName.equals("var")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
                valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
                searchAiNodeVar(searchList, entityVar, valueIndexed);
              } else if(paramName.equals("cursorMark")) {
                valueCursorMark = (String)paramObject;
                searchList.cursorMark((String)paramObject);
              }
            }
            searchAiNodeUri(searchList);
          }
        } catch(Exception e) {
          ExceptionUtils.rethrow(e);
        }
      }
      if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
        searchList.sort("hubId_docvalues_string", "asc");
        searchList.sort("clusterName_docvalues_string", "asc");
        searchList.sort("nodeName_docvalues_string", "asc");
        searchList.setDefaultSort(true);
      }
      String facetRange2 = facetRange;
      Date facetRangeStart2 = facetRangeStart;
      Date facetRangeEnd2 = facetRangeEnd;
      String facetRangeGap2 = facetRangeGap;
      String statsField2 = statsField;
      String statsFieldIndexed2 = statsFieldIndexed;
      searchAiNode2(siteRequest, populate, store, modify, searchList);
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
            LOG.error(String.format("searchAiNode failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete(searchList);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("searchAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("searchAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void searchAiNode2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<AiNode> searchList) {
  }

  public Future<JsonObject> upsertAiNode(AiNode o, Boolean inheritPrimaryKey, Boolean patch) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
        promise.complete();
      } else {
        JsonObject json = o.getSiteRequest_().getJsonObject();
        String old_hubResource = AiNode.staticJsonHubResource(o.getHubResource());
        String new_hubResource = json.getString(AiNode.varJson(AiNode.VAR_hubResource, patch));
        String hubResource = Optional.ofNullable(Optional.ofNullable(new_hubResource).orElse(old_hubResource)).orElse(null);
        Hub.authorizationHub(siteRequest, webClient, false, "GET", "GET", "GET").onSuccess(hubResourceAuthorizationDecisionResponse -> {
          Hub.authorizationScopesHub(hubResourceAuthorizationDecisionResponse, siteRequest, webClient, false, "GET", "GET", "GET").onSuccess(hubResourceSiteRequest -> {
            Hub.fqHub(hubResourceSiteRequest, Hub.VAR_hubResource, hubResource).onSuccess(oHub -> {
              try {
                if(oHub == null) {
                  RuntimeException ex = new RuntimeException(String.format("Could not find a matching Hub %s", hubResource));
                  LOG.error(ex.getMessage(), ex);
                  promise.fail(ex);
                } else {
                  if(!Objects.equals(old_hubResource, hubResource))
                    json.put(Hub.varJson(Hub.VAR_hubResource, patch), hubResource);
                  String old_clusterResource = AiNode.staticJsonClusterResource(o.getClusterResource());
                  String new_clusterResource = json.getString(AiNode.varJson(AiNode.VAR_clusterResource, patch));
                  String clusterResource = Optional.ofNullable(Optional.ofNullable(new_clusterResource).orElse(old_clusterResource)).orElse(null);
                  Cluster.authorizationCluster(siteRequest, webClient, false, "GET", "GET", "GET").onSuccess(clusterResourceAuthorizationDecisionResponse -> {
                    Cluster.authorizationScopesCluster(clusterResourceAuthorizationDecisionResponse, siteRequest, webClient, false, "GET", "GET", "GET").onSuccess(clusterResourceSiteRequest -> {
                      Cluster.fqCluster(clusterResourceSiteRequest, Cluster.VAR_clusterResource, clusterResource).onSuccess(oCluster -> {
                        try {
                          if(oCluster == null) {
                            RuntimeException ex = new RuntimeException(String.format("Could not find a matching Cluster %s", clusterResource));
                            LOG.error(ex.getMessage(), ex);
                            promise.fail(ex);
                          } else {
                            if(!Objects.equals(old_clusterResource, clusterResource))
                              json.put(Cluster.varJson(Cluster.VAR_clusterResource, patch), clusterResource);

                            String old_hubId = AiNode.staticJsonHubId(o.getHubId());
                            String new_hubId = json.getString(AiNode.varJson(AiNode.VAR_hubId, patch));

                            String old_clusterName = AiNode.staticJsonClusterName(o.getClusterName());
                            String new_clusterName = json.getString(AiNode.varJson(AiNode.VAR_clusterName, patch));

                            String old_nodeName = AiNode.staticJsonNodeName(o.getNodeName());
                            String new_nodeName = json.getString(AiNode.varJson(AiNode.VAR_nodeName, patch));

                            String old_nodeResource = AiNode.staticJsonNodeResource(o.getNodeResource());
                            String new_nodeResource = json.getString(AiNode.varJson(AiNode.VAR_nodeResource, patch));

                            String old_description = AiNode.staticJsonDescription(o.getDescription());
                            String new_description = json.getString(AiNode.varJson(AiNode.VAR_description, patch));

                            JsonObject old_location = AiNode.staticJsonLocation(o.getLocation());
                            JsonObject new_location = json.getJsonObject(AiNode.varJson(AiNode.VAR_location, patch));

                            String old_gpuDevicesTotal = AiNode.staticJsonGpuDevicesTotal(o.getGpuDevicesTotal());
                            String new_gpuDevicesTotal = json.getString(AiNode.varJson(AiNode.VAR_gpuDevicesTotal, patch));

                            String old_id = AiNode.staticJsonId(o.getId());
                            String new_id = json.getString(AiNode.varJson(AiNode.VAR_id, patch));

                            String old_ngsildTenant = AiNode.staticJsonNgsildTenant(o.getNgsildTenant());
                            String new_ngsildTenant = json.getString(AiNode.varJson(AiNode.VAR_ngsildTenant, patch));

                            String old_ngsildPath = AiNode.staticJsonNgsildPath(o.getNgsildPath());
                            String new_ngsildPath = json.getString(AiNode.varJson(AiNode.VAR_ngsildPath, patch));

                            String old_ngsildContext = AiNode.staticJsonNgsildContext(o.getNgsildContext());
                            String new_ngsildContext = json.getString(AiNode.varJson(AiNode.VAR_ngsildContext, patch));

                            JsonObject old_ngsildData = AiNode.staticJsonNgsildData(o.getNgsildData());
                            JsonObject new_ngsildData = json.getJsonObject(AiNode.varJson(AiNode.VAR_ngsildData, patch));

                            String old_created = AiNode.staticJsonCreated(o.getCreated());
                            String new_created = json.getString(AiNode.varJson(AiNode.VAR_created, patch));

                            Boolean old_archived = AiNode.staticJsonArchived(o.getArchived());
                            Boolean new_archived = json.getBoolean(AiNode.varJson(AiNode.VAR_archived, patch));

                            String old_sessionId = AiNode.staticJsonSessionId(o.getSessionId());
                            String new_sessionId = json.getString(AiNode.varJson(AiNode.VAR_sessionId, patch));

                            String old_userKey = AiNode.staticJsonUserKey(o.getUserKey());
                            String new_userKey = json.getString(AiNode.varJson(AiNode.VAR_userKey, patch));

                            String old_objectTitle = AiNode.staticJsonObjectTitle(o.getObjectTitle());
                            String new_objectTitle = json.getString(AiNode.varJson(AiNode.VAR_objectTitle, patch));

                            String old_apiUrl = AiNode.staticJsonApiUrl(o.getApiUrl());
                            String new_apiUrl = json.getString(AiNode.varJson(AiNode.VAR_apiUrl, patch));

                            String old_displayPage = AiNode.staticJsonDisplayPage(o.getDisplayPage());
                            String new_displayPage = json.getString(AiNode.varJson(AiNode.VAR_displayPage, patch));

                            String old_editPage = AiNode.staticJsonEditPage(o.getEditPage());
                            String new_editPage = json.getString(AiNode.varJson(AiNode.VAR_editPage, patch));

                            String old_userPage = AiNode.staticJsonUserPage(o.getUserPage());
                            String new_userPage = json.getString(AiNode.varJson(AiNode.VAR_userPage, patch));

                            String old_download = AiNode.staticJsonDownload(o.getDownload());
                            String new_download = json.getString(AiNode.varJson(AiNode.VAR_download, patch));

                            String hubId = Optional.ofNullable(Optional.ofNullable(new_hubId).orElse(old_hubId)).orElse(null);
                            // if(!Objects.equals(old_hubId, hubId))
                              // json.put(AiNode.varJson(AiNode.VAR_hubId, patch), hubId);
                            String clusterName = Optional.ofNullable(Optional.ofNullable(new_clusterName).orElse(old_clusterName)).orElse(null);
                            // if(!Objects.equals(old_clusterName, clusterName))
                              // json.put(AiNode.varJson(AiNode.VAR_clusterName, patch), clusterName);
                            String nodeName = Optional.ofNullable(Optional.ofNullable(new_nodeName).orElse(old_nodeName)).orElse(null);
                            // if(!Objects.equals(old_nodeName, nodeName))
                              // json.put(AiNode.varJson(AiNode.VAR_nodeName, patch), nodeName);
                            String nodeResource = Optional.ofNullable(Optional.ofNullable(new_nodeResource).orElse(old_nodeResource)).orElse(null);
                            // if(!Objects.equals(old_nodeResource, nodeResource))
                              // json.put(AiNode.varJson(AiNode.VAR_nodeResource, patch), nodeResource);
                            String description = Optional.ofNullable(Optional.ofNullable(new_description).orElse(old_description)).orElse(null);
                            // if(!Objects.equals(old_description, description))
                              // json.put(AiNode.varJson(AiNode.VAR_description, patch), description);
                            JsonObject location = Optional.ofNullable(Optional.ofNullable(new_location).orElse(old_location)).orElse(null);
                            // if(!Objects.equals(old_location, location))
                              // json.put(AiNode.varJson(AiNode.VAR_location, patch), location);
                            String gpuDevicesTotal = Optional.ofNullable(Optional.ofNullable(new_gpuDevicesTotal).orElse(old_gpuDevicesTotal)).orElse(null);
                            // if(!Objects.equals(old_gpuDevicesTotal, gpuDevicesTotal))
                              // json.put(AiNode.varJson(AiNode.VAR_gpuDevicesTotal, patch), gpuDevicesTotal);
                            String id = Optional.ofNullable(Optional.ofNullable(new_id).orElse(old_id)).orElse(null);
                            // if(!Objects.equals(old_id, id))
                              // json.put(AiNode.varJson(AiNode.VAR_id, patch), id);
                            String ngsildTenant = Optional.ofNullable(Optional.ofNullable(new_ngsildTenant).orElse(old_ngsildTenant)).orElse(null);
                            // if(!Objects.equals(old_ngsildTenant, ngsildTenant))
                              // json.put(AiNode.varJson(AiNode.VAR_ngsildTenant, patch), ngsildTenant);
                            String ngsildPath = Optional.ofNullable(Optional.ofNullable(new_ngsildPath).orElse(old_ngsildPath)).orElse(null);
                            // if(!Objects.equals(old_ngsildPath, ngsildPath))
                              // json.put(AiNode.varJson(AiNode.VAR_ngsildPath, patch), ngsildPath);
                            String ngsildContext = Optional.ofNullable(Optional.ofNullable(new_ngsildContext).orElse(old_ngsildContext)).orElse(null);
                            // if(!Objects.equals(old_ngsildContext, ngsildContext))
                              // json.put(AiNode.varJson(AiNode.VAR_ngsildContext, patch), ngsildContext);
                            JsonObject ngsildData = Optional.ofNullable(Optional.ofNullable(new_ngsildData).orElse(old_ngsildData)).orElse(null);
                            // if(!Objects.equals(old_ngsildData, ngsildData))
                              // json.put(AiNode.varJson(AiNode.VAR_ngsildData, patch), ngsildData);
                            String created = Optional.ofNullable(Optional.ofNullable(new_created).orElse(old_created)).orElse(null);
                            // if(!Objects.equals(old_created, created))
                              // json.put(AiNode.varJson(AiNode.VAR_created, patch), created);
                            Boolean archived = Optional.ofNullable(Optional.ofNullable(new_archived).orElse(old_archived)).orElse(null);
                            // if(!Objects.equals(old_archived, archived))
                              // json.put(AiNode.varJson(AiNode.VAR_archived, patch), archived);
                            String sessionId = Optional.ofNullable(Optional.ofNullable(new_sessionId).orElse(old_sessionId)).orElse(null);
                            // if(!Objects.equals(old_sessionId, sessionId))
                              // json.put(AiNode.varJson(AiNode.VAR_sessionId, patch), sessionId);
                            String userKey = Optional.ofNullable(Optional.ofNullable(new_userKey).orElse(old_userKey)).orElse(null);
                            // if(!Objects.equals(old_userKey, userKey))
                              // json.put(AiNode.varJson(AiNode.VAR_userKey, patch), userKey);
                            String objectTitle = Optional.ofNullable(Optional.ofNullable(new_objectTitle).orElse(old_objectTitle)).orElse(null);
                            // if(!Objects.equals(old_objectTitle, objectTitle))
                              // json.put(AiNode.varJson(AiNode.VAR_objectTitle, patch), objectTitle);
                            String apiUrl = Optional.ofNullable(Optional.ofNullable(new_apiUrl).orElse(old_apiUrl)).orElse(null);
                            // if(!Objects.equals(old_apiUrl, apiUrl))
                              // json.put(AiNode.varJson(AiNode.VAR_apiUrl, patch), apiUrl);
                            String displayPage = Optional.ofNullable(Optional.ofNullable(new_displayPage).orElse(old_displayPage)).orElse(null);
                            // if(!Objects.equals(old_displayPage, displayPage))
                              // json.put(AiNode.varJson(AiNode.VAR_displayPage, patch), displayPage);
                            String editPage = Optional.ofNullable(Optional.ofNullable(new_editPage).orElse(old_editPage)).orElse(null);
                            // if(!Objects.equals(old_editPage, editPage))
                              // json.put(AiNode.varJson(AiNode.VAR_editPage, patch), editPage);
                            String userPage = Optional.ofNullable(Optional.ofNullable(new_userPage).orElse(old_userPage)).orElse(null);
                            // if(!Objects.equals(old_userPage, userPage))
                              // json.put(AiNode.varJson(AiNode.VAR_userPage, patch), userPage);
                            String download = Optional.ofNullable(Optional.ofNullable(new_download).orElse(old_download)).orElse(null);
                            // if(!Objects.equals(old_download, download))
                              // json.put(AiNode.varJson(AiNode.VAR_download, patch), download);

                            promise.complete(json);
                          }
                        } catch(Exception ex) {
                          LOG.error(String.format("upsertAiNode failed. "), ex);
                          promise.tryFail(ex);
                        }
                      }).onFailure(ex -> {
                        promise.fail(ex);
                      });
                    }).onFailure(ex -> {
                      promise.fail(ex);
                    });
                  }).onFailure(ex -> {
                    promise.fail(ex);
                  });
                }
              } catch(Exception ex) {
                LOG.error(String.format("upsertAiNode failed. "), ex);
                promise.tryFail(ex);
              }
            }).onFailure(ex -> {
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            promise.fail(ex);
          });
        }).onFailure(ex -> {
          promise.fail(ex);
        });
      }
    } catch(Exception ex) {
      LOG.error(String.format("upsertAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> persistAiNode(AiNode o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Long pk = o.getPk();
      sqlConnection.preparedQuery("SELECT hubId, hubResource, clusterName, clusterResource, nodeName, nodeResource, description, location, gpuDevicesTotal, id, ngsildTenant, ngsildPath, ngsildContext, ngsildData, created, archived, sessionId, userKey, objectTitle, apiUrl, displayPage, editPage, userPage, download FROM AiNode WHERE pk=$1")
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
                  LOG.error(String.format("persistAiNode failed. "), e);
                }
              }
            }
          }
          o.promiseDeepForClass(siteRequest).onSuccess(a -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("persistAiNode failed. "), ex);
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("persistAiNode failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error(String.format("persistAiNode failed. "), ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("persistAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> relateAiNode(AiNode o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      sqlConnection.preparedQuery("SELECT hubResource as pk2, 'hubResource' FROM Hub WHERE hubResource=$1 UNION SELECT clusterResource as pk2, 'clusterResource' FROM Cluster WHERE clusterResource=$2")
          .collecting(Collectors.toList())
          .execute(Tuple.of(o.getHubResource(), o.getClusterResource())
          ).onSuccess(result -> {
        try {
          if(result != null) {
            for(Row definition : result.value()) {
              o.relateForClass(definition.getString(1), definition.getValue(0));
            }
          }
          promise.complete();
        } catch(Exception ex) {
          LOG.error(String.format("relateAiNode failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error(String.format("relateAiNode failed. "), ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("relateAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public String searchVar(String varIndexed) {
    return AiNode.searchVarAiNode(varIndexed);
  }

  @Override
  public String getClassApiAddress() {
    return AiNode.CLASS_API_ADDRESS_AiNode;
  }

  public Future<AiNode> indexAiNode(AiNode o) {
    Promise<AiNode> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      JsonObject json = new JsonObject();
      JsonObject add = new JsonObject();
      json.put("add", add);
      JsonObject doc = new JsonObject();
      add.put("doc", doc);
      o.indexAiNode(doc);
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
        LOG.error(String.format("indexAiNode failed. "), new RuntimeException(ex));
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("indexAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<AiNode> unindexAiNode(AiNode o) {
    Promise<AiNode> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      o.promiseDeepForClass(siteRequest).onSuccess(a -> {
        JsonObject json = new JsonObject();
        JsonObject delete = new JsonObject();
        json.put("delete", delete);
        String query = String.format("filter(%s:%s)", AiNode.VAR_solrId, o.obtainForClass(AiNode.VAR_solrId));
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
          LOG.error(String.format("unindexAiNode failed. "), new RuntimeException(ex));
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("unindexAiNode failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("unindexAiNode failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> refreshAiNode(AiNode o) {
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

          if("Hub".equals(classSimpleName2) && solrId2 != null) {
            SearchList<Hub> searchList2 = new SearchList<Hub>();
            searchList2.setStore(true);
            searchList2.q("*:*");
            searchList2.setC(Hub.class);
            searchList2.fq("solrId:" + solrId2);
            searchList2.rows(1L);
            futures.add(Future.future(promise2 -> {
              searchList2.promiseDeepSearchList(siteRequest).onSuccess(b -> {
                Hub o2 = searchList2.getList().stream().findFirst().orElse(null);
                if(o2 != null) {
                  JsonObject params = new JsonObject();
                  params.put("body", new JsonObject());
                  params.put("scopes", siteRequest.getScopes());
                  params.put("cookie", new JsonObject());
                  params.put("path", new JsonObject());
                  params.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("solrId:" + solrId2)).put("var", new JsonArray().add("refresh:false")));
                  JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
                  JsonObject json = new JsonObject().put("context", context);
                  eventBus.request("ai-telemetry-enUS-Hub", json, new DeliveryOptions().addHeader("action", "patchHubFuture")).onSuccess(c -> {
                    JsonObject responseMessage = (JsonObject)c.body();
                    Integer statusCode = responseMessage.getInteger("statusCode");
                    if(statusCode.equals(200))
                      promise2.complete();
                    else
                      promise2.fail(new RuntimeException(responseMessage.getString("statusMessage")));
                  }).onFailure(ex -> {
                    promise2.fail(ex);
                  });
                }
              }).onFailure(ex -> {
                promise2.fail(ex);
              });
            }));
          }

          if("Cluster".equals(classSimpleName2) && solrId2 != null) {
            SearchList<Cluster> searchList2 = new SearchList<Cluster>();
            searchList2.setStore(true);
            searchList2.q("*:*");
            searchList2.setC(Cluster.class);
            searchList2.fq("solrId:" + solrId2);
            searchList2.rows(1L);
            futures.add(Future.future(promise2 -> {
              searchList2.promiseDeepSearchList(siteRequest).onSuccess(b -> {
                Cluster o2 = searchList2.getList().stream().findFirst().orElse(null);
                if(o2 != null) {
                  JsonObject params = new JsonObject();
                  params.put("body", new JsonObject());
                  params.put("scopes", siteRequest.getScopes());
                  params.put("cookie", new JsonObject());
                  params.put("path", new JsonObject());
                  params.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("solrId:" + solrId2)).put("var", new JsonArray().add("refresh:false")));
                  JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
                  JsonObject json = new JsonObject().put("context", context);
                  eventBus.request("ai-telemetry-enUS-Cluster", json, new DeliveryOptions().addHeader("action", "patchClusterFuture")).onSuccess(c -> {
                    JsonObject responseMessage = (JsonObject)c.body();
                    Integer statusCode = responseMessage.getInteger("statusCode");
                    if(statusCode.equals(200))
                      promise2.complete();
                    else
                      promise2.fail(new RuntimeException(responseMessage.getString("statusMessage")));
                  }).onFailure(ex -> {
                    promise2.fail(ex);
                  });
                }
              }).onFailure(ex -> {
                promise2.fail(ex);
              });
            }));
          }
        }

        CompositeFuture.all(futures).onSuccess(b -> {
          JsonObject params = new JsonObject();
          params.put("body", new JsonObject());
          params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
          params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
          params.put("form", new JsonObject());
          params.put("path", new JsonObject());
          params.put("scopes", siteRequest.getScopes());
          JsonObject query = new JsonObject();
          Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
          Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
          if(softCommit == null && commitWithin == null)
            softCommit = true;
          if(softCommit != null)
            query.put("softCommit", softCommit);
          if(commitWithin != null)
            query.put("commitWithin", commitWithin);
          query.put("q", "*:*").put("fq", new JsonArray().add("pk:" + o.getPk())).put("var", new JsonArray().add("refresh:false"));
          params.put("query", query);
          JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
          JsonObject json = new JsonObject().put("context", context);
          eventBus.request(AiNode.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "patchAiNodeFuture")).onSuccess(c -> {
            JsonObject responseMessage = (JsonObject)c.body();
            Integer statusCode = responseMessage.getInteger("statusCode");
            if(statusCode.equals(200))
              promise.complete();
            else
              promise.tryFail(new RuntimeException(responseMessage.getString("statusMessage")));
          }).onFailure(ex -> {
            LOG.error("Refresh relations failed. ", ex);
            promise.tryFail(ex);
          });
        }).onFailure(ex -> {
          LOG.error("Refresh relations failed. ", ex);
          promise.tryFail(ex);
        });
      } else {
        promise.complete();
      }
    } catch(Exception ex) {
      LOG.error(String.format("refreshAiNode failed. "), ex);
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
      AiNode o = new AiNode();
      o.setSiteRequest_((SiteRequest)siteRequest);

      o.persistForClass(AiNode.VAR_hubId, AiNode.staticSetHubId(siteRequest2, (String)result.get(AiNode.VAR_hubId)));
      o.persistForClass(AiNode.VAR_hubResource, AiNode.staticSetHubResource(siteRequest2, (String)result.get(AiNode.VAR_hubResource)));
      o.persistForClass(AiNode.VAR_clusterName, AiNode.staticSetClusterName(siteRequest2, (String)result.get(AiNode.VAR_clusterName)));
      o.persistForClass(AiNode.VAR_clusterResource, AiNode.staticSetClusterResource(siteRequest2, (String)result.get(AiNode.VAR_clusterResource)));
      o.persistForClass(AiNode.VAR_nodeName, AiNode.staticSetNodeName(siteRequest2, (String)result.get(AiNode.VAR_nodeName)));
      o.persistForClass(AiNode.VAR_nodeResource, AiNode.staticSetNodeResource(siteRequest2, (String)result.get(AiNode.VAR_nodeResource)));
      o.persistForClass(AiNode.VAR_description, AiNode.staticSetDescription(siteRequest2, (String)result.get(AiNode.VAR_description)));
      o.persistForClass(AiNode.VAR_location, AiNode.staticSetLocation(siteRequest2, (String)result.get(AiNode.VAR_location)));
      o.persistForClass(AiNode.VAR_gpuDevicesTotal, AiNode.staticSetGpuDevicesTotal(siteRequest2, (String)result.get(AiNode.VAR_gpuDevicesTotal)));
      o.persistForClass(AiNode.VAR_id, AiNode.staticSetId(siteRequest2, (String)result.get(AiNode.VAR_id)));
      o.persistForClass(AiNode.VAR_ngsildTenant, AiNode.staticSetNgsildTenant(siteRequest2, (String)result.get(AiNode.VAR_ngsildTenant)));
      o.persistForClass(AiNode.VAR_ngsildPath, AiNode.staticSetNgsildPath(siteRequest2, (String)result.get(AiNode.VAR_ngsildPath)));
      o.persistForClass(AiNode.VAR_ngsildContext, AiNode.staticSetNgsildContext(siteRequest2, (String)result.get(AiNode.VAR_ngsildContext)));
      o.persistForClass(AiNode.VAR_ngsildData, AiNode.staticSetNgsildData(siteRequest2, (String)result.get(AiNode.VAR_ngsildData)));
      o.persistForClass(AiNode.VAR_created, AiNode.staticSetCreated(siteRequest2, (String)result.get(AiNode.VAR_created), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(AiNode.VAR_archived, AiNode.staticSetArchived(siteRequest2, (String)result.get(AiNode.VAR_archived)));
      o.persistForClass(AiNode.VAR_sessionId, AiNode.staticSetSessionId(siteRequest2, (String)result.get(AiNode.VAR_sessionId)));
      o.persistForClass(AiNode.VAR_userKey, AiNode.staticSetUserKey(siteRequest2, (String)result.get(AiNode.VAR_userKey)));
      o.persistForClass(AiNode.VAR_objectTitle, AiNode.staticSetObjectTitle(siteRequest2, (String)result.get(AiNode.VAR_objectTitle)));
      o.persistForClass(AiNode.VAR_apiUrl, AiNode.staticSetApiUrl(siteRequest2, (String)result.get(AiNode.VAR_apiUrl)));
      o.persistForClass(AiNode.VAR_displayPage, AiNode.staticSetDisplayPage(siteRequest2, (String)result.get(AiNode.VAR_displayPage)));
      o.persistForClass(AiNode.VAR_editPage, AiNode.staticSetEditPage(siteRequest2, (String)result.get(AiNode.VAR_editPage)));
      o.persistForClass(AiNode.VAR_userPage, AiNode.staticSetUserPage(siteRequest2, (String)result.get(AiNode.VAR_userPage)));
      o.persistForClass(AiNode.VAR_download, AiNode.staticSetDownload(siteRequest2, (String)result.get(AiNode.VAR_download)));

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

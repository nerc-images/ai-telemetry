package org.computate.aitelemetry.model.baremetalnetwork;

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
import org.computate.aitelemetry.model.baremetalnetwork.BareMetalNetworkPage;


/**
 * Translate: false
 * Generated: true
 **/
public class BareMetalNetworkEnUSGenApiServiceImpl extends BaseApiServiceImpl implements BareMetalNetworkEnUSGenApiService {

  protected static final Logger LOG = LoggerFactory.getLogger(BareMetalNetworkEnUSGenApiServiceImpl.class);

  // Search //

  @Override
  public void searchBareMetalNetwork(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        BareMetalNetwork.authorizationBareMetalNetwork(siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          BareMetalNetwork.authorizationScopesBareMetalNetwork(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchBareMetalNetworkList(siteRequest2, false, true, false, "GET").onSuccess(listBareMetalNetwork -> {
              response200SearchBareMetalNetwork(listBareMetalNetwork).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchBareMetalNetwork succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchBareMetalNetwork failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchBareMetalNetwork failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("searchBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200SearchBareMetalNetwork(SearchList<BareMetalNetwork> listBareMetalNetwork) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listBareMetalNetwork.getSiteRequest_(SiteRequest.class);
      List<String> fls = listBareMetalNetwork.getRequest().getFields();
      JsonObject json = new JsonObject();
      JsonArray l = new JsonArray();
      List<String> scopes = siteRequest.getScopes();
      listBareMetalNetwork.getList().stream().forEach(o -> {
        JsonObject json2 = JsonObject.mapFrom(o);
        if(fls.size() > 0) {
          Set<String> fieldNames = new HashSet<String>();
          for(String fieldName : json2.fieldNames()) {
            String v = BareMetalNetwork.varIndexedBareMetalNetwork(fieldName);
            if(v != null)
              fieldNames.add(BareMetalNetwork.varIndexedBareMetalNetwork(fieldName));
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
      response200Search(listBareMetalNetwork.getRequest(), listBareMetalNetwork.getResponse(), json);
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchBareMetalNetwork(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchBareMetalNetwork(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // GET //

  @Override
  public void getBareMetalNetwork(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        BareMetalNetwork.authorizationBareMetalNetwork(siteRequest, webClient, classPublicRead, "GET", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          BareMetalNetwork.authorizationScopesBareMetalNetwork(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "GET", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchBareMetalNetworkList(siteRequest2, false, true, false, "GET").onSuccess(listBareMetalNetwork -> {
              response200GETBareMetalNetwork(listBareMetalNetwork).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("getBareMetalNetwork succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("getBareMetalNetwork failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("getBareMetalNetwork failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("getBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("getBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("getBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200GETBareMetalNetwork(SearchList<BareMetalNetwork> listBareMetalNetwork) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listBareMetalNetwork.getSiteRequest_(SiteRequest.class);
      JsonObject json = JsonObject.mapFrom(listBareMetalNetwork.getList().stream().findFirst().orElse(null));
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200GETBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PATCH //

  @Override
  public void patchBareMetalNetwork(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("patchBareMetalNetwork started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        BareMetalNetwork.authorizationBareMetalNetwork(siteRequest, webClient, classPublicRead, "PATCH", "PATCH", "PATCH").onSuccess(authorizationDecisionResponse -> {
          BareMetalNetwork.authorizationScopesBareMetalNetwork(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "PATCH", "PATCH", "PATCH").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchBareMetalNetworkList(siteRequest2, false, true, true, "PATCH").onSuccess(listBareMetalNetwork -> {
              try {
                ApiRequest apiRequest = new ApiRequest();
                apiRequest.setRows(listBareMetalNetwork.getRequest().getRows());
                apiRequest.setNumFound(listBareMetalNetwork.getResponse().getResponse().getNumFound());
                apiRequest.setNumPATCH(0L);
                apiRequest.initDeepApiRequest(siteRequest2);
                siteRequest2.setApiRequest_(apiRequest);
                if(apiRequest.getNumFound() == 1L)
                  apiRequest.setOriginal(listBareMetalNetwork.first());
                apiRequest.setId(Optional.ofNullable(listBareMetalNetwork.first()).map(o2 -> o2.getId().toString()).orElse(null));
                apiRequest.setSolrId(Optional.ofNullable(listBareMetalNetwork.first()).map(o2 -> o2.getSolrId()).orElse(null));
                eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());

                listPATCHBareMetalNetwork(apiRequest, listBareMetalNetwork).onSuccess(e -> {
                  response200PATCHBareMetalNetwork(siteRequest2).onSuccess(response -> {
                    LOG.debug(String.format("patchBareMetalNetwork succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
                    error(siteRequest2, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("patchBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPATCHBareMetalNetwork(ApiRequest apiRequest, SearchList<BareMetalNetwork> listBareMetalNetwork) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listBareMetalNetwork.getSiteRequest_(SiteRequest.class);
    listBareMetalNetwork.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      BareMetalNetwork o2 = jsonObject.mapTo(BareMetalNetwork.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        patchBareMetalNetworkFuture(o2, false).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listPATCHBareMetalNetwork failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listBareMetalNetwork.next().onSuccess(next -> {
        if(next) {
          listPATCHBareMetalNetwork(apiRequest, listBareMetalNetwork).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPATCHBareMetalNetwork failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listPATCHBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listPATCHBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void patchBareMetalNetworkFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        searchBareMetalNetworkList(siteRequest, false, true, true, "PATCH").onSuccess(listBareMetalNetwork -> {
          try {
            BareMetalNetwork o = listBareMetalNetwork.first();
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
            BareMetalNetwork o2;
            if(o != null) {
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listBareMetalNetwork.first()).map(o3 -> o3.getId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listBareMetalNetwork.first()).map(o3 -> o3.getSolrId()).orElse(null));
              JsonObject jsonObject = JsonObject.mapFrom(o);
              o2 = jsonObject.mapTo(BareMetalNetwork.class);
              o2.setSiteRequest_(siteRequest);
              patchBareMetalNetworkFuture(o2, false).onSuccess(o3 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else if(refresh) {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            } else {
              String m = String.format("%s %s not found", "bare metal network", null);
              eventHandler.handle(Future.failedFuture(m));
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("patchBareMetalNetwork failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<BareMetalNetwork> patchBareMetalNetworkFuture(BareMetalNetwork o, Boolean inheritPrimaryKey) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<BareMetalNetwork> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<BareMetalNetwork> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsBareMetalNetwork(siteRequest).onSuccess(a -> {
          upsertBareMetalNetwork(o, inheritPrimaryKey, true).onSuccess(c -> {
            sqlPATCHBareMetalNetwork(o, inheritPrimaryKey).onSuccess(bareMetalNetwork -> {
              persistBareMetalNetwork(bareMetalNetwork, true).onSuccess(d -> {
                relateBareMetalNetwork(bareMetalNetwork).onSuccess(e -> {
                  indexBareMetalNetwork(bareMetalNetwork).onSuccess(o2 -> {
                    if(apiRequest != null) {
                      apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                      if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                        o2.apiRequestBareMetalNetwork();
                        if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                          eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());
                      }
                    }
                    promise1.complete(bareMetalNetwork);
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
      }).compose(bareMetalNetwork -> {
        Promise<BareMetalNetwork> promise2 = Promise.promise();
        refreshBareMetalNetwork(bareMetalNetwork).onSuccess(a -> {
          promise2.complete(bareMetalNetwork);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(bareMetalNetwork -> {
        promise.complete(bareMetalNetwork);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("patchBareMetalNetworkFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<BareMetalNetwork> sqlPATCHBareMetalNetwork(BareMetalNetwork o, Boolean inheritPrimaryKey) {
    Promise<BareMetalNetwork> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE BareMetalNetwork SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Set<String> methodNames = jsonObject.fieldNames();
      BareMetalNetwork o2 = new BareMetalNetwork();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      for(String entityVar : methodNames) {
        switch(entityVar) {
          case "setId":
              o2.setId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_id + "=$" + num);
              num++;
              bParams.add(o2.sqlId());
            break;
          case "setName":
              o2.setName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_name + "=$" + num);
              num++;
              bParams.add(o2.sqlName());
            break;
          case "setDescription":
              o2.setDescription(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_description + "=$" + num);
              num++;
              bParams.add(o2.sqlDescription());
            break;
          case "setAvailabilityZoneHints":
              o2.setAvailabilityZoneHints(jsonObject.getJsonArray(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_availabilityZoneHints + "=$" + num);
              num++;
              bParams.add(o2.sqlAvailabilityZoneHints());
            break;
          case "setAvailabilityZones":
              o2.setAvailabilityZones(jsonObject.getJsonArray(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_availabilityZones + "=$" + num);
              num++;
              bParams.add(o2.sqlAvailabilityZones());
            break;
          case "setCreatedAt":
              o2.setCreatedAt(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_createdAt + "=$" + num);
              num++;
              bParams.add(o2.sqlCreatedAt());
            break;
          case "setDnsDomain":
              o2.setDnsDomain(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_dnsDomain + "=$" + num);
              num++;
              bParams.add(o2.sqlDnsDomain());
            break;
          case "setMtu":
              o2.setMtu(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_mtu + "=$" + num);
              num++;
              bParams.add(o2.sqlMtu());
            break;
          case "setProjectId":
              o2.setProjectId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_projectId + "=$" + num);
              num++;
              bParams.add(o2.sqlProjectId());
            break;
          case "setProviderNetworkType":
              o2.setProviderNetworkType(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_providerNetworkType + "=$" + num);
              num++;
              bParams.add(o2.sqlProviderNetworkType());
            break;
          case "setProviderPhysicalNetwork":
              o2.setProviderPhysicalNetwork(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_providerPhysicalNetwork + "=$" + num);
              num++;
              bParams.add(o2.sqlProviderPhysicalNetwork());
            break;
          case "setProviderSegmentationId":
              o2.setProviderSegmentationId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_providerSegmentationId + "=$" + num);
              num++;
              bParams.add(o2.sqlProviderSegmentationId());
            break;
          case "setQosPolicyId":
              o2.setQosPolicyId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_qosPolicyId + "=$" + num);
              num++;
              bParams.add(o2.sqlQosPolicyId());
            break;
          case "setRevisionNumber":
              o2.setRevisionNumber(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_revisionNumber + "=$" + num);
              num++;
              bParams.add(o2.sqlRevisionNumber());
            break;
          case "setStatus":
              o2.setStatus(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_status + "=$" + num);
              num++;
              bParams.add(o2.sqlStatus());
            break;
          case "setSubnetIds":
              o2.setSubnetIds(jsonObject.getJsonArray(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_subnetIds + "=$" + num);
              num++;
              bParams.add(o2.sqlSubnetIds());
            break;
          case "setTags":
              o2.setTags(jsonObject.getJsonArray(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_tags + "=$" + num);
              num++;
              bParams.add(o2.sqlTags());
            break;
          case "setTenantId":
              o2.setTenantId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_tenantId + "=$" + num);
              num++;
              bParams.add(o2.sqlTenantId());
            break;
          case "setUpdatedAt":
              o2.setUpdatedAt(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_updatedAt + "=$" + num);
              num++;
              bParams.add(o2.sqlUpdatedAt());
            break;
          case "setIsAdminStateUp":
              o2.setIsAdminStateUp(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_isAdminStateUp + "=$" + num);
              num++;
              bParams.add(o2.sqlIsAdminStateUp());
            break;
          case "setIsDefault":
              o2.setIsDefault(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_isDefault + "=$" + num);
              num++;
              bParams.add(o2.sqlIsDefault());
            break;
          case "setIsPortSecurityEnabled":
              o2.setIsPortSecurityEnabled(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_isPortSecurityEnabled + "=$" + num);
              num++;
              bParams.add(o2.sqlIsPortSecurityEnabled());
            break;
          case "setIsRouterExternal":
              o2.setIsRouterExternal(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_isRouterExternal + "=$" + num);
              num++;
              bParams.add(o2.sqlIsRouterExternal());
            break;
          case "setIsShared":
              o2.setIsShared(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_isShared + "=$" + num);
              num++;
              bParams.add(o2.sqlIsShared());
            break;
          case "setIsVlanQueing":
              o2.setIsVlanQueing(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_isVlanQueing + "=$" + num);
              num++;
              bParams.add(o2.sqlIsVlanQueing());
            break;
          case "setIsVlanTransparent":
              o2.setIsVlanTransparent(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_isVlanTransparent + "=$" + num);
              num++;
              bParams.add(o2.sqlIsVlanTransparent());
            break;
          case "setL2Adjacency":
              o2.setL2Adjacency(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_l2Adjacency + "=$" + num);
              num++;
              bParams.add(o2.sqlL2Adjacency());
            break;
          case "setLocationCloud":
              o2.setLocationCloud(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_locationCloud + "=$" + num);
              num++;
              bParams.add(o2.sqlLocationCloud());
            break;
          case "setLocationProjectDomainId":
              o2.setLocationProjectDomainId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_locationProjectDomainId + "=$" + num);
              num++;
              bParams.add(o2.sqlLocationProjectDomainId());
            break;
          case "setLocationProjectDomainName":
              o2.setLocationProjectDomainName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_locationProjectDomainName + "=$" + num);
              num++;
              bParams.add(o2.sqlLocationProjectDomainName());
            break;
          case "setLocationProjectId":
              o2.setLocationProjectId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_locationProjectId + "=$" + num);
              num++;
              bParams.add(o2.sqlLocationProjectId());
            break;
          case "setLocationProjectName":
              o2.setLocationProjectName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_locationProjectName + "=$" + num);
              num++;
              bParams.add(o2.sqlLocationProjectName());
            break;
          case "setLocationRegionName":
              o2.setLocationRegionName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_locationRegionName + "=$" + num);
              num++;
              bParams.add(o2.sqlLocationRegionName());
            break;
          case "setLocationZone":
              o2.setLocationZone(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_locationZone + "=$" + num);
              num++;
              bParams.add(o2.sqlLocationZone());
            break;
          case "setCreated":
              o2.setCreated(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_created + "=$" + num);
              num++;
              bParams.add(o2.sqlCreated());
            break;
          case "setArchived":
              o2.setArchived(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_archived + "=$" + num);
              num++;
              bParams.add(o2.sqlArchived());
            break;
          case "setSessionId":
              o2.setSessionId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_sessionId + "=$" + num);
              num++;
              bParams.add(o2.sqlSessionId());
            break;
          case "setUserKey":
              o2.setUserKey(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_userKey + "=$" + num);
              num++;
              bParams.add(o2.sqlUserKey());
            break;
          case "setObjectTitle":
              o2.setObjectTitle(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_objectTitle + "=$" + num);
              num++;
              bParams.add(o2.sqlObjectTitle());
            break;
          case "setApiUrl":
              o2.setApiUrl(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_apiUrl + "=$" + num);
              num++;
              bParams.add(o2.sqlApiUrl());
            break;
          case "setDisplayPage":
              o2.setDisplayPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_displayPage + "=$" + num);
              num++;
              bParams.add(o2.sqlDisplayPage());
            break;
          case "setEditPage":
              o2.setEditPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_editPage + "=$" + num);
              num++;
              bParams.add(o2.sqlEditPage());
            break;
          case "setUserPage":
              o2.setUserPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_userPage + "=$" + num);
              num++;
              bParams.add(o2.sqlUserPage());
            break;
          case "setDownload":
              o2.setDownload(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(BareMetalNetwork.VAR_download + "=$" + num);
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
            RuntimeException ex2 = new RuntimeException("value BareMetalNetwork failed", ex);
            LOG.error(String.format("relateBareMetalNetwork failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          BareMetalNetwork o3 = new BareMetalNetwork();
          o3.setSiteRequest_(o.getSiteRequest_());
          o3.setPk(pk);
          promise.complete(o3);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPATCHBareMetalNetwork failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPATCHBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPATCHBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200PATCHBareMetalNetwork(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PATCHBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // POST //

  @Override
  public void postBareMetalNetwork(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("postBareMetalNetwork started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        BareMetalNetwork.authorizationBareMetalNetwork(siteRequest, webClient, classPublicRead, "POST", "POST", "POST").onSuccess(authorizationDecisionResponse -> {
          BareMetalNetwork.authorizationScopesBareMetalNetwork(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "POST", "POST", "POST").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setRows(1L);
            apiRequest.setNumFound(1L);
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest2);
            siteRequest2.setApiRequest_(apiRequest);
            eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());
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
            eventBus.request(BareMetalNetwork.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postBareMetalNetworkFuture")).onSuccess(a -> {
              JsonObject responseMessage = (JsonObject)a.body();
              JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
              apiRequest.setSolrId(responseBody.getString(BareMetalNetwork.VAR_solrId));
              response200POSTBareMetalNetwork(siteRequest2, responseBody).onSuccess(response -> {
                LOG.debug(String.format("postBareMetalNetwork succeeded. "));
                eventHandler.handle(Future.succeededFuture(response));
              }).onFailure(ex -> {
                LOG.error(String.format("postBareMetalNetwork failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("postBareMetalNetwork failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("postBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("postBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  @Override
  public void postBareMetalNetworkFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        postBareMetalNetworkFuture(siteRequest, false).onSuccess(o -> {
          eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
        }).onFailure(ex -> {
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Throwable ex) {
        LOG.error(String.format("postBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("postBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<BareMetalNetwork> postBareMetalNetworkFuture(SiteRequest siteRequest, Boolean id) {
    Promise<BareMetalNetwork> promise = Promise.promise();

    try {
      pgPool.withTransaction(sqlConnection -> {
        Promise<BareMetalNetwork> promise1 = Promise.promise();
        siteRequest.setSqlConnection(sqlConnection);
        varsBareMetalNetwork(siteRequest).onSuccess(a -> {
          createBareMetalNetwork(siteRequest).onSuccess(bareMetalNetwork -> {
            upsertBareMetalNetwork(bareMetalNetwork, id, false).onSuccess(b -> {
              sqlPOSTBareMetalNetwork(bareMetalNetwork, id).onSuccess(c -> {
                persistBareMetalNetwork(bareMetalNetwork, false).onSuccess(d -> {
                  relateBareMetalNetwork(bareMetalNetwork).onSuccess(e -> {
                    indexBareMetalNetwork(bareMetalNetwork).onSuccess(o2 -> {
                      promise1.complete(bareMetalNetwork);
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
      }).compose(bareMetalNetwork -> {
        Promise<BareMetalNetwork> promise2 = Promise.promise();
        refreshBareMetalNetwork(bareMetalNetwork).onSuccess(a -> {
          try {
            ApiRequest apiRequest = siteRequest.getApiRequest_();
            if(apiRequest != null) {
              apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
              bareMetalNetwork.apiRequestBareMetalNetwork();
              eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());
            }
            promise2.complete(bareMetalNetwork);
          } catch(Exception ex) {
            LOG.error(String.format("postBareMetalNetworkFuture failed. "), ex);
            promise2.tryFail(ex);
          }
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(bareMetalNetwork -> {
        try {
          ApiRequest apiRequest = siteRequest.getApiRequest_();
          if(apiRequest != null) {
            apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
            bareMetalNetwork.apiRequestBareMetalNetwork();
            eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());
          }
          promise.complete(bareMetalNetwork);
        } catch(Exception ex) {
          LOG.error(String.format("postBareMetalNetworkFuture failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("postBareMetalNetworkFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<BareMetalNetwork> sqlPOSTBareMetalNetwork(BareMetalNetwork o, Boolean inheritPrimaryKey) {
    Promise<BareMetalNetwork> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE BareMetalNetwork SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      BareMetalNetwork o2 = new BareMetalNetwork();
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
          case BareMetalNetwork.VAR_id:
            o2.setId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_id + "=$" + num);
            num++;
            bParams.add(o2.sqlId());
            break;
          case BareMetalNetwork.VAR_name:
            o2.setName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_name + "=$" + num);
            num++;
            bParams.add(o2.sqlName());
            break;
          case BareMetalNetwork.VAR_description:
            o2.setDescription(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_description + "=$" + num);
            num++;
            bParams.add(o2.sqlDescription());
            break;
          case BareMetalNetwork.VAR_availabilityZoneHints:
            o2.setAvailabilityZoneHints(jsonObject.getJsonArray(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_availabilityZoneHints + "=$" + num);
            num++;
            bParams.add(o2.sqlAvailabilityZoneHints());
            break;
          case BareMetalNetwork.VAR_availabilityZones:
            o2.setAvailabilityZones(jsonObject.getJsonArray(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_availabilityZones + "=$" + num);
            num++;
            bParams.add(o2.sqlAvailabilityZones());
            break;
          case BareMetalNetwork.VAR_createdAt:
            o2.setCreatedAt(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_createdAt + "=$" + num);
            num++;
            bParams.add(o2.sqlCreatedAt());
            break;
          case BareMetalNetwork.VAR_dnsDomain:
            o2.setDnsDomain(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_dnsDomain + "=$" + num);
            num++;
            bParams.add(o2.sqlDnsDomain());
            break;
          case BareMetalNetwork.VAR_mtu:
            o2.setMtu(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_mtu + "=$" + num);
            num++;
            bParams.add(o2.sqlMtu());
            break;
          case BareMetalNetwork.VAR_projectId:
            o2.setProjectId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_projectId + "=$" + num);
            num++;
            bParams.add(o2.sqlProjectId());
            break;
          case BareMetalNetwork.VAR_providerNetworkType:
            o2.setProviderNetworkType(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_providerNetworkType + "=$" + num);
            num++;
            bParams.add(o2.sqlProviderNetworkType());
            break;
          case BareMetalNetwork.VAR_providerPhysicalNetwork:
            o2.setProviderPhysicalNetwork(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_providerPhysicalNetwork + "=$" + num);
            num++;
            bParams.add(o2.sqlProviderPhysicalNetwork());
            break;
          case BareMetalNetwork.VAR_providerSegmentationId:
            o2.setProviderSegmentationId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_providerSegmentationId + "=$" + num);
            num++;
            bParams.add(o2.sqlProviderSegmentationId());
            break;
          case BareMetalNetwork.VAR_qosPolicyId:
            o2.setQosPolicyId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_qosPolicyId + "=$" + num);
            num++;
            bParams.add(o2.sqlQosPolicyId());
            break;
          case BareMetalNetwork.VAR_revisionNumber:
            o2.setRevisionNumber(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_revisionNumber + "=$" + num);
            num++;
            bParams.add(o2.sqlRevisionNumber());
            break;
          case BareMetalNetwork.VAR_status:
            o2.setStatus(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_status + "=$" + num);
            num++;
            bParams.add(o2.sqlStatus());
            break;
          case BareMetalNetwork.VAR_subnetIds:
            o2.setSubnetIds(jsonObject.getJsonArray(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_subnetIds + "=$" + num);
            num++;
            bParams.add(o2.sqlSubnetIds());
            break;
          case BareMetalNetwork.VAR_tags:
            o2.setTags(jsonObject.getJsonArray(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_tags + "=$" + num);
            num++;
            bParams.add(o2.sqlTags());
            break;
          case BareMetalNetwork.VAR_tenantId:
            o2.setTenantId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_tenantId + "=$" + num);
            num++;
            bParams.add(o2.sqlTenantId());
            break;
          case BareMetalNetwork.VAR_updatedAt:
            o2.setUpdatedAt(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_updatedAt + "=$" + num);
            num++;
            bParams.add(o2.sqlUpdatedAt());
            break;
          case BareMetalNetwork.VAR_isAdminStateUp:
            o2.setIsAdminStateUp(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_isAdminStateUp + "=$" + num);
            num++;
            bParams.add(o2.sqlIsAdminStateUp());
            break;
          case BareMetalNetwork.VAR_isDefault:
            o2.setIsDefault(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_isDefault + "=$" + num);
            num++;
            bParams.add(o2.sqlIsDefault());
            break;
          case BareMetalNetwork.VAR_isPortSecurityEnabled:
            o2.setIsPortSecurityEnabled(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_isPortSecurityEnabled + "=$" + num);
            num++;
            bParams.add(o2.sqlIsPortSecurityEnabled());
            break;
          case BareMetalNetwork.VAR_isRouterExternal:
            o2.setIsRouterExternal(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_isRouterExternal + "=$" + num);
            num++;
            bParams.add(o2.sqlIsRouterExternal());
            break;
          case BareMetalNetwork.VAR_isShared:
            o2.setIsShared(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_isShared + "=$" + num);
            num++;
            bParams.add(o2.sqlIsShared());
            break;
          case BareMetalNetwork.VAR_isVlanQueing:
            o2.setIsVlanQueing(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_isVlanQueing + "=$" + num);
            num++;
            bParams.add(o2.sqlIsVlanQueing());
            break;
          case BareMetalNetwork.VAR_isVlanTransparent:
            o2.setIsVlanTransparent(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_isVlanTransparent + "=$" + num);
            num++;
            bParams.add(o2.sqlIsVlanTransparent());
            break;
          case BareMetalNetwork.VAR_l2Adjacency:
            o2.setL2Adjacency(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_l2Adjacency + "=$" + num);
            num++;
            bParams.add(o2.sqlL2Adjacency());
            break;
          case BareMetalNetwork.VAR_locationCloud:
            o2.setLocationCloud(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_locationCloud + "=$" + num);
            num++;
            bParams.add(o2.sqlLocationCloud());
            break;
          case BareMetalNetwork.VAR_locationProjectDomainId:
            o2.setLocationProjectDomainId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_locationProjectDomainId + "=$" + num);
            num++;
            bParams.add(o2.sqlLocationProjectDomainId());
            break;
          case BareMetalNetwork.VAR_locationProjectDomainName:
            o2.setLocationProjectDomainName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_locationProjectDomainName + "=$" + num);
            num++;
            bParams.add(o2.sqlLocationProjectDomainName());
            break;
          case BareMetalNetwork.VAR_locationProjectId:
            o2.setLocationProjectId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_locationProjectId + "=$" + num);
            num++;
            bParams.add(o2.sqlLocationProjectId());
            break;
          case BareMetalNetwork.VAR_locationProjectName:
            o2.setLocationProjectName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_locationProjectName + "=$" + num);
            num++;
            bParams.add(o2.sqlLocationProjectName());
            break;
          case BareMetalNetwork.VAR_locationRegionName:
            o2.setLocationRegionName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_locationRegionName + "=$" + num);
            num++;
            bParams.add(o2.sqlLocationRegionName());
            break;
          case BareMetalNetwork.VAR_locationZone:
            o2.setLocationZone(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_locationZone + "=$" + num);
            num++;
            bParams.add(o2.sqlLocationZone());
            break;
          case BareMetalNetwork.VAR_created:
            o2.setCreated(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_created + "=$" + num);
            num++;
            bParams.add(o2.sqlCreated());
            break;
          case BareMetalNetwork.VAR_archived:
            o2.setArchived(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_archived + "=$" + num);
            num++;
            bParams.add(o2.sqlArchived());
            break;
          case BareMetalNetwork.VAR_userKey:
            o2.setUserKey(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_userKey + "=$" + num);
            num++;
            bParams.add(o2.sqlUserKey());
            break;
          case BareMetalNetwork.VAR_objectTitle:
            o2.setObjectTitle(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_objectTitle + "=$" + num);
            num++;
            bParams.add(o2.sqlObjectTitle());
            break;
          case BareMetalNetwork.VAR_apiUrl:
            o2.setApiUrl(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_apiUrl + "=$" + num);
            num++;
            bParams.add(o2.sqlApiUrl());
            break;
          case BareMetalNetwork.VAR_displayPage:
            o2.setDisplayPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_displayPage + "=$" + num);
            num++;
            bParams.add(o2.sqlDisplayPage());
            break;
          case BareMetalNetwork.VAR_editPage:
            o2.setEditPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_editPage + "=$" + num);
            num++;
            bParams.add(o2.sqlEditPage());
            break;
          case BareMetalNetwork.VAR_userPage:
            o2.setUserPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_userPage + "=$" + num);
            num++;
            bParams.add(o2.sqlUserPage());
            break;
          case BareMetalNetwork.VAR_download:
            o2.setDownload(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(BareMetalNetwork.VAR_download + "=$" + num);
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
            RuntimeException ex2 = new RuntimeException("value BareMetalNetwork failed", ex);
            LOG.error(String.format("relateBareMetalNetwork failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete(o2);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPOSTBareMetalNetwork failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPOSTBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPOSTBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200POSTBareMetalNetwork(SiteRequest siteRequest, JsonObject json) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200POSTBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // DELETE //

  @Override
  public void deleteBareMetalNetwork(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deleteBareMetalNetwork started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        BareMetalNetwork.authorizationBareMetalNetwork(siteRequest, webClient, classPublicRead, "DELETE", "DELETE", "DELETE").onSuccess(authorizationDecisionResponse -> {
          BareMetalNetwork.authorizationScopesBareMetalNetwork(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "DELETE", "DELETE", "DELETE").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchBareMetalNetworkList(siteRequest2, false, true, true, "DELETE").onSuccess(listBareMetalNetwork -> {
              try {
                ApiRequest apiRequest = new ApiRequest();
                apiRequest.setRows(listBareMetalNetwork.getRequest().getRows());
                apiRequest.setNumFound(listBareMetalNetwork.getResponse().getResponse().getNumFound());
                apiRequest.setNumPATCH(0L);
                apiRequest.initDeepApiRequest(siteRequest2);
                siteRequest2.setApiRequest_(apiRequest);
                if(apiRequest.getNumFound() == 1L)
                  apiRequest.setOriginal(listBareMetalNetwork.first());
                apiRequest.setSolrId(Optional.ofNullable(listBareMetalNetwork.first()).map(o2 -> o2.getSolrId()).orElse(null));
                eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());

                listDELETEBareMetalNetwork(apiRequest, listBareMetalNetwork).onSuccess(e -> {
                  response200DELETEBareMetalNetwork(siteRequest2).onSuccess(response -> {
                    LOG.debug(String.format("deleteBareMetalNetwork succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
                    error(siteRequest2, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deleteBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEBareMetalNetwork(ApiRequest apiRequest, SearchList<BareMetalNetwork> listBareMetalNetwork) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listBareMetalNetwork.getSiteRequest_(SiteRequest.class);
    listBareMetalNetwork.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      BareMetalNetwork o2 = jsonObject.mapTo(BareMetalNetwork.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deleteBareMetalNetworkFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEBareMetalNetwork failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listBareMetalNetwork.next().onSuccess(next -> {
        if(next) {
          listDELETEBareMetalNetwork(apiRequest, listBareMetalNetwork).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEBareMetalNetwork failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deleteBareMetalNetworkFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        searchBareMetalNetworkList(siteRequest, false, true, true, "DELETE").onSuccess(listBareMetalNetwork -> {
          try {
            BareMetalNetwork o = listBareMetalNetwork.first();
            if(o != null && listBareMetalNetwork.getResponse().getResponse().getNumFound() == 1) {
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
              apiRequest.setId(Optional.ofNullable(listBareMetalNetwork.first()).map(o2 -> o2.getId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listBareMetalNetwork.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deleteBareMetalNetworkFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deleteBareMetalNetwork failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<BareMetalNetwork> deleteBareMetalNetworkFuture(BareMetalNetwork o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<BareMetalNetwork> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<BareMetalNetwork> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsBareMetalNetwork(siteRequest).onSuccess(a -> {
          sqlDELETEBareMetalNetwork(o).onSuccess(bareMetalNetwork -> {
            relateBareMetalNetwork(o).onSuccess(d -> {
              unindexBareMetalNetwork(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestBareMetalNetwork();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());
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
      }).compose(bareMetalNetwork -> {
        Promise<BareMetalNetwork> promise2 = Promise.promise();
        refreshBareMetalNetwork(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(bareMetalNetwork -> {
        promise.complete(bareMetalNetwork);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deleteBareMetalNetworkFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETEBareMetalNetwork(BareMetalNetwork o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM BareMetalNetwork ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      BareMetalNetwork o2 = new BareMetalNetwork();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
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
          RuntimeException ex2 = new RuntimeException("value BareMetalNetwork failed", ex);
          LOG.error(String.format("unrelateBareMetalNetwork failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETEBareMetalNetwork failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETEBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETEBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEBareMetalNetwork(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PUTImport //

  @Override
  public void putimportBareMetalNetwork(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("putimportBareMetalNetwork started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        BareMetalNetwork.authorizationBareMetalNetwork(siteRequest, webClient, classPublicRead, "PUTImport", "PUT", "PUT").onSuccess(authorizationDecisionResponse -> {
          BareMetalNetwork.authorizationScopesBareMetalNetwork(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "PUTImport", "PUT", "PUT").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            ApiRequest apiRequest = new ApiRequest();
            JsonArray jsonArray = Optional.ofNullable(siteRequest2.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
            apiRequest.setRows(Long.valueOf(jsonArray.size()));
            apiRequest.setNumFound(Long.valueOf(jsonArray.size()));
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest2);
            siteRequest2.setApiRequest_(apiRequest);
            eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());
            varsBareMetalNetwork(siteRequest2).onSuccess(d -> {
              listPUTImportBareMetalNetwork(apiRequest, siteRequest2).onSuccess(e -> {
                response200PUTImportBareMetalNetwork(siteRequest2).onSuccess(response -> {
                  LOG.debug(String.format("putimportBareMetalNetwork succeeded. "));
                  eventHandler.handle(Future.succeededFuture(response));
                }).onFailure(ex -> {
                  LOG.error(String.format("putimportBareMetalNetwork failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("putimportBareMetalNetwork failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("putimportBareMetalNetwork failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("putimportBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPUTImportBareMetalNetwork(ApiRequest apiRequest, SiteRequest siteRequest) {
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
          eventBus.request(BareMetalNetwork.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "putimportBareMetalNetworkFuture")).onSuccess(a -> {
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPUTImportBareMetalNetwork failed. "), ex);
            promise1.tryFail(ex);
          });
        }));
      });
      CompositeFuture.all(futures).onSuccess(a -> {
        apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("listPUTImportBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("listPUTImportBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public void putimportBareMetalNetworkFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        String id = Optional.ofNullable(body.getString(BareMetalNetwork.VAR_id)).orElse(body.getString(BareMetalNetwork.VAR_solrId));
        if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
          siteRequest.getRequestVars().put( "refresh", "false" );
        }
        pgPool.getConnection().onSuccess(sqlConnection -> {
          String sqlQuery = String.format("select * from %s WHERE id=$1", BareMetalNetwork.CLASS_SIMPLE_NAME);
          sqlConnection.preparedQuery(sqlQuery)
              .execute(Tuple.tuple(Arrays.asList(id))
              ).onSuccess(result -> {
            sqlConnection.close().onSuccess(a -> {
              try {
                if(result.size() >= 1) {
                  BareMetalNetwork o = new BareMetalNetwork();
                  o.setSiteRequest_(siteRequest);
                  for(Row definition : result.value()) {
                    for(Integer i = 0; i < definition.size(); i++) {
                      try {
                        String columnName = definition.getColumnName(i);
                        Object columnValue = definition.getValue(i);
                        o.persistForClass(columnName, columnValue);
                      } catch(Exception e) {
                        LOG.error(String.format("persistBareMetalNetwork failed. "), e);
                      }
                    }
                  }
                  BareMetalNetwork o2 = new BareMetalNetwork();
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
                      if(!StringUtils.containsAny(f, "id", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                        body2.put("set" + StringUtils.capitalize(f), bodyVal);
                    }
                  }
                  for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
                    if(!body.fieldNames().contains(f)) {
                      if(!StringUtils.containsAny(f, "id", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                        body2.putNull("set" + StringUtils.capitalize(f));
                    }
                  }
                  if(result.size() >= 1) {
                    apiRequest.setOriginal(o);
                    apiRequest.setId(Optional.ofNullable(o.getId()).map(v -> v.toString()).orElse(null));
                    apiRequest.setSolrId(o.getSolrId());
                  }
                  siteRequest.setJsonObject(body2);
                  patchBareMetalNetworkFuture(o, true).onSuccess(b -> {
                    LOG.debug("Import BareMetalNetwork {} succeeded, modified BareMetalNetwork. ", body.getValue(BareMetalNetwork.VAR_id));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportBareMetalNetworkFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                } else {
                  postBareMetalNetworkFuture(siteRequest, true).onSuccess(b -> {
                    LOG.debug("Import BareMetalNetwork {} succeeded, created new BareMetalNetwork. ", body.getValue(BareMetalNetwork.VAR_id));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportBareMetalNetworkFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                }
              } catch(Exception ex) {
                LOG.error(String.format("putimportBareMetalNetworkFuture failed. "), ex);
                eventHandler.handle(Future.failedFuture(ex));
              }
            }).onFailure(ex -> {
              LOG.error(String.format("putimportBareMetalNetworkFuture failed. "), ex);
              eventHandler.handle(Future.failedFuture(ex));
            });
          }).onFailure(ex -> {
            LOG.error(String.format("putimportBareMetalNetworkFuture failed. "), ex);
            eventHandler.handle(Future.failedFuture(ex));
          });
        }).onFailure(ex -> {
          LOG.error(String.format("putimportBareMetalNetworkFuture failed. "), ex);
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportBareMetalNetworkFuture failed. "), ex);
        eventHandler.handle(Future.failedFuture(ex));
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("putimportBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200PUTImportBareMetalNetwork(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PUTImportBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // SearchPage //

  @Override
  public void searchpageBareMetalNetwork(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        BareMetalNetwork.authorizationBareMetalNetwork(siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          BareMetalNetwork.authorizationScopesBareMetalNetwork(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchBareMetalNetworkList(siteRequest2, false, true, false, "GET").onSuccess(listBareMetalNetwork -> {
              response200SearchPageBareMetalNetwork(listBareMetalNetwork).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchpageBareMetalNetwork succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchpageBareMetalNetwork failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchpageBareMetalNetwork failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchpageBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("searchpageBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void searchpageBareMetalNetworkPageInit(JsonObject ctx, BareMetalNetworkPage page, SearchList<BareMetalNetwork> listBareMetalNetwork, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/bare-metal-network"));
    ctx.put("enUSUrlPage", String.format("%s%s", siteBaseUrl, "/en-us/search/bare-metal-network"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriSearchPageBareMetalNetwork(ServiceRequest serviceRequest, BareMetalNetwork result) {
    return "en-us/search/bare-metal-network/BareMetalNetworkSearchPage.htm";
  }
  public void templateSearchPageBareMetalNetwork(JsonObject ctx, BareMetalNetworkPage page, SearchList<BareMetalNetwork> listBareMetalNetwork, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listBareMetalNetwork.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      BareMetalNetwork result = listBareMetalNetwork.first();
      String pageTemplateUri = templateUriSearchPageBareMetalNetwork(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/search/bare-metal-network/BareMetalNetworkSearchPage.htm"), Charset.forName("UTF-8"));
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
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/bare-metal-network/BareMetalNetworkGenEditPage.htm")).orElse("en-us/Article.htm");
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
      LOG.error(String.format("templateSearchPageBareMetalNetwork failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200SearchPageBareMetalNetwork(SearchList<BareMetalNetwork> listBareMetalNetwork) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listBareMetalNetwork.getSiteRequest_(SiteRequest.class);
      BareMetalNetworkPage page = new BareMetalNetworkPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listBareMetalNetwork.size() >= 1)
        siteRequest.setRequestPk(listBareMetalNetwork.get(0).getPk());
      page.setSearchListBareMetalNetwork_(listBareMetalNetwork);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepBareMetalNetworkPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          searchpageBareMetalNetworkPageInit(ctx, page, listBareMetalNetwork, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateSearchPageBareMetalNetwork(ctx, page, listBareMetalNetwork, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200SearchPageBareMetalNetwork failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200SearchPageBareMetalNetwork failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200SearchPageBareMetalNetwork failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchPageBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchPageBareMetalNetwork(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchPageBareMetalNetwork(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // EditPage //

  @Override
  public void editpageBareMetalNetwork(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        BareMetalNetwork.authorizationBareMetalNetwork(siteRequest, webClient, classPublicRead, "EditPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          BareMetalNetwork.authorizationScopesBareMetalNetwork(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "EditPage", "GET", "GET").onSuccess(siteRequest2 -> {
            searchBareMetalNetworkList(siteRequest2, false, true, false, "GET").onSuccess(listBareMetalNetwork -> {
              response200EditPageBareMetalNetwork(listBareMetalNetwork).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("editpageBareMetalNetwork succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("editpageBareMetalNetwork failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
          }).onFailure(ex -> {
              LOG.error(String.format("editpageBareMetalNetwork failed. "), ex);
              error(siteRequest, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("editpageBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("editpageBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("editpageBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void editpageBareMetalNetworkPageInit(JsonObject ctx, BareMetalNetworkPage page, SearchList<BareMetalNetwork> listBareMetalNetwork, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/bare-metal-network"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriEditPageBareMetalNetwork(ServiceRequest serviceRequest, BareMetalNetwork result) {
    return "en-us/edit/bare-metal-network/BareMetalNetworkEditPage.htm";
  }
  public void templateEditPageBareMetalNetwork(JsonObject ctx, BareMetalNetworkPage page, SearchList<BareMetalNetwork> listBareMetalNetwork, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listBareMetalNetwork.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      BareMetalNetwork result = listBareMetalNetwork.first();
      String pageTemplateUri = templateUriEditPageBareMetalNetwork(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/edit/bare-metal-network/BareMetalNetworkEditPage.htm"), Charset.forName("UTF-8"));
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
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/bare-metal-network/BareMetalNetworkGenEditPage.htm")).orElse("en-us/Article.htm");
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
      LOG.error(String.format("templateEditPageBareMetalNetwork failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200EditPageBareMetalNetwork(SearchList<BareMetalNetwork> listBareMetalNetwork) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listBareMetalNetwork.getSiteRequest_(SiteRequest.class);
      BareMetalNetworkPage page = new BareMetalNetworkPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listBareMetalNetwork.size() >= 1)
        siteRequest.setRequestPk(listBareMetalNetwork.get(0).getPk());
      page.setSearchListBareMetalNetwork_(listBareMetalNetwork);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepBareMetalNetworkPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          editpageBareMetalNetworkPageInit(ctx, page, listBareMetalNetwork, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateEditPageBareMetalNetwork(ctx, page, listBareMetalNetwork, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200EditPageBareMetalNetwork failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200EditPageBareMetalNetwork failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200EditPageBareMetalNetwork failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200EditPageBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotEditPageBareMetalNetwork(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotEditPageBareMetalNetwork(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // DELETEFilter //

  @Override
  public void deletefilterBareMetalNetwork(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deletefilterBareMetalNetwork started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        BareMetalNetwork.authorizationBareMetalNetwork(siteRequest, webClient, classPublicRead, "DELETEFilter", "DELETE", "DELETE").onSuccess(authorizationDecisionResponse -> {
          BareMetalNetwork.authorizationScopesBareMetalNetwork(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "DELETEFilter", "DELETE", "DELETE").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchBareMetalNetworkList(siteRequest2, false, true, true, "DELETE").onSuccess(listBareMetalNetwork -> {
              try {
                ApiRequest apiRequest = new ApiRequest();
                apiRequest.setRows(listBareMetalNetwork.getRequest().getRows());
                apiRequest.setNumFound(listBareMetalNetwork.getResponse().getResponse().getNumFound());
                apiRequest.setNumPATCH(0L);
                apiRequest.initDeepApiRequest(siteRequest2);
                siteRequest2.setApiRequest_(apiRequest);
                if(apiRequest.getNumFound() == 1L)
                  apiRequest.setOriginal(listBareMetalNetwork.first());
                apiRequest.setSolrId(Optional.ofNullable(listBareMetalNetwork.first()).map(o2 -> o2.getSolrId()).orElse(null));
                eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());

                listDELETEFilterBareMetalNetwork(apiRequest, listBareMetalNetwork).onSuccess(e -> {
                  response200DELETEFilterBareMetalNetwork(siteRequest2).onSuccess(response -> {
                    LOG.debug(String.format("deletefilterBareMetalNetwork succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
                    error(siteRequest2, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deletefilterBareMetalNetwork failed. ", ex2));
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
        LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEFilterBareMetalNetwork(ApiRequest apiRequest, SearchList<BareMetalNetwork> listBareMetalNetwork) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listBareMetalNetwork.getSiteRequest_(SiteRequest.class);
    listBareMetalNetwork.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      BareMetalNetwork o2 = jsonObject.mapTo(BareMetalNetwork.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deletefilterBareMetalNetworkFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEFilterBareMetalNetwork failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listBareMetalNetwork.next().onSuccess(next -> {
        if(next) {
          listDELETEFilterBareMetalNetwork(apiRequest, listBareMetalNetwork).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEFilterBareMetalNetwork failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEFilterBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEFilterBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deletefilterBareMetalNetworkFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        searchBareMetalNetworkList(siteRequest, false, true, true, "DELETE").onSuccess(listBareMetalNetwork -> {
          try {
            BareMetalNetwork o = listBareMetalNetwork.first();
            if(o != null && listBareMetalNetwork.getResponse().getResponse().getNumFound() == 1) {
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
              apiRequest.setId(Optional.ofNullable(listBareMetalNetwork.first()).map(o2 -> o2.getId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listBareMetalNetwork.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deletefilterBareMetalNetworkFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deletefilterBareMetalNetwork failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<BareMetalNetwork> deletefilterBareMetalNetworkFuture(BareMetalNetwork o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<BareMetalNetwork> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<BareMetalNetwork> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsBareMetalNetwork(siteRequest).onSuccess(a -> {
          sqlDELETEFilterBareMetalNetwork(o).onSuccess(bareMetalNetwork -> {
            relateBareMetalNetwork(o).onSuccess(d -> {
              unindexBareMetalNetwork(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestBareMetalNetwork();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketBareMetalNetwork", JsonObject.mapFrom(apiRequest).toString());
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
      }).compose(bareMetalNetwork -> {
        Promise<BareMetalNetwork> promise2 = Promise.promise();
        refreshBareMetalNetwork(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(bareMetalNetwork -> {
        promise.complete(bareMetalNetwork);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deletefilterBareMetalNetworkFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETEFilterBareMetalNetwork(BareMetalNetwork o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM BareMetalNetwork ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      BareMetalNetwork o2 = new BareMetalNetwork();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
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
          RuntimeException ex2 = new RuntimeException("value BareMetalNetwork failed", ex);
          LOG.error(String.format("unrelateBareMetalNetwork failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETEFilterBareMetalNetwork failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETEFilterBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETEFilterBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEFilterBareMetalNetwork(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEFilterBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // General //

  public Future<BareMetalNetwork> createBareMetalNetwork(SiteRequest siteRequest) {
    Promise<BareMetalNetwork> promise = Promise.promise();
    try {
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      String userId = siteRequest.getUserId();
      Long userKey = siteRequest.getUserKey();
      ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

      sqlConnection.preparedQuery("INSERT INTO BareMetalNetwork(created, userKey) VALUES($1, $2) RETURNING pk")
          .collecting(Collectors.toList())
          .execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
        Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
        Long pk = createLine.getLong(0);
        BareMetalNetwork o = new BareMetalNetwork();
        o.setPk(pk);
        o.setSiteRequest_(siteRequest);
        promise.complete(o);
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error("createBareMetalNetwork failed. ", ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("createBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public void searchBareMetalNetworkQ(SearchList<BareMetalNetwork> searchList, String entityVar, String valueIndexed, String varIndexed) {
    searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
    if(!"*".equals(entityVar)) {
    }
  }

  public String searchBareMetalNetworkFq(SearchList<BareMetalNetwork> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    if(StringUtils.startsWith(valueIndexed, "[")) {
      String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
      if(fqs.length != 2)
        throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
      String fq1 = fqs[0].equals("*") ? fqs[0] : BareMetalNetwork.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
      String fq2 = fqs[1].equals("*") ? fqs[1] : BareMetalNetwork.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
       return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
    } else {
      return varIndexed + ":" + SearchTool.escapeQueryChars(BareMetalNetwork.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
    }
  }

  public void searchBareMetalNetworkSort(SearchList<BareMetalNetwork> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    searchList.sort(varIndexed, valueIndexed);
  }

  public void searchBareMetalNetworkRows(SearchList<BareMetalNetwork> searchList, Long valueRows) {
      searchList.rows(valueRows != null ? valueRows : 10L);
  }

  public void searchBareMetalNetworkStart(SearchList<BareMetalNetwork> searchList, Long valueStart) {
    searchList.start(valueStart);
  }

  public void searchBareMetalNetworkVar(SearchList<BareMetalNetwork> searchList, String var, String value) {
    searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
  }

  public void searchBareMetalNetworkUri(SearchList<BareMetalNetwork> searchList) {
  }

  public Future<ServiceResponse> varsBareMetalNetwork(SiteRequest siteRequest) {
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
          LOG.error(String.format("searchBareMetalNetwork failed. "), ex);
          promise.tryFail(ex);
        }
      });
      promise.complete();
    } catch(Exception ex) {
      LOG.error(String.format("searchBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SearchList<BareMetalNetwork>> searchBareMetalNetworkList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, String scope) {
    Promise<SearchList<BareMetalNetwork>> promise = Promise.promise();
    try {
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
      String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
      SearchList<BareMetalNetwork> searchList = new SearchList<BareMetalNetwork>();
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
      searchList.setC(BareMetalNetwork.class);
      searchList.setSiteRequest_(siteRequest);
      searchList.facetMinCount(1);
      if(entityList != null) {
        for(String v : entityList) {
          searchList.fl(BareMetalNetwork.varIndexedBareMetalNetwork(v));
        }
      }

      String id = serviceRequest.getParams().getJsonObject("path").getString("id");
      if(id != null) {
        searchList.fq("id_docvalues_string:" + SearchTool.escapeQueryChars(id));
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
                varsIndexed[i] = BareMetalNetwork.varIndexedBareMetalNetwork(entityVar);
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
                  varIndexed = BareMetalNetwork.varIndexedBareMetalNetwork(entityVar);
                  String entityQ = searchBareMetalNetworkFq(searchList, entityVar, valueIndexed, varIndexed);
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
                  varIndexed = BareMetalNetwork.varIndexedBareMetalNetwork(entityVar);
                  String entityFq = searchBareMetalNetworkFq(searchList, entityVar, valueIndexed, varIndexed);
                  mFq.appendReplacement(sb, entityFq);
                }
                if(!sb.isEmpty()) {
                  mFq.appendTail(sb);
                  searchList.fq(sb.toString());
                }
              } else if(paramName.equals("sort")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
                valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
                varIndexed = BareMetalNetwork.varIndexedBareMetalNetwork(entityVar);
                searchBareMetalNetworkSort(searchList, entityVar, valueIndexed, varIndexed);
              } else if(paramName.equals("start")) {
                valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchBareMetalNetworkStart(searchList, valueStart);
              } else if(paramName.equals("rows")) {
                valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchBareMetalNetworkRows(searchList, valueRows);
              } else if(paramName.equals("stats")) {
                searchList.stats((Boolean)paramObject);
              } else if(paramName.equals("stats.field")) {
                Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mStats.find()) {
                  String solrLocalParams = mStats.group(1);
                  entityVar = mStats.group(2).trim();
                  varIndexed = BareMetalNetwork.varIndexedBareMetalNetwork(entityVar);
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
                  varIndexed = BareMetalNetwork.varIndexedBareMetalNetwork(entityVar);
                  searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  facetRange = entityVar;
                }
              } else if(paramName.equals("facet.field")) {
                entityVar = (String)paramObject;
                varIndexed = BareMetalNetwork.varIndexedBareMetalNetwork(entityVar);
                if(varIndexed != null)
                  searchList.facetField(varIndexed);
              } else if(paramName.equals("var")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
                valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
                searchBareMetalNetworkVar(searchList, entityVar, valueIndexed);
              } else if(paramName.equals("cursorMark")) {
                valueCursorMark = (String)paramObject;
                searchList.cursorMark((String)paramObject);
              }
            }
            searchBareMetalNetworkUri(searchList);
          }
        } catch(Exception e) {
          ExceptionUtils.rethrow(e);
        }
      }
      if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
        searchList.sort("created_docvalues_date", "desc");
      }
      String facetRange2 = facetRange;
      Date facetRangeStart2 = facetRangeStart;
      Date facetRangeEnd2 = facetRangeEnd;
      String facetRangeGap2 = facetRangeGap;
      String statsField2 = statsField;
      String statsFieldIndexed2 = statsFieldIndexed;
      searchBareMetalNetwork2(siteRequest, populate, store, modify, searchList);
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
            LOG.error(String.format("searchBareMetalNetwork failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete(searchList);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("searchBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("searchBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void searchBareMetalNetwork2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<BareMetalNetwork> searchList) {
  }

  public Future<JsonObject> upsertBareMetalNetwork(BareMetalNetwork o, Boolean inheritPrimaryKey, Boolean patch) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
        promise.complete();
      } else {
        JsonObject json = o.getSiteRequest_().getJsonObject();

        String old_id = BareMetalNetwork.staticJsonId(o.getId());
        String new_id = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_id, patch));

        String old_name = BareMetalNetwork.staticJsonName(o.getName());
        String new_name = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_name, patch));

        String old_description = BareMetalNetwork.staticJsonDescription(o.getDescription());
        String new_description = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_description, patch));

        JsonArray old_availabilityZoneHints = BareMetalNetwork.staticJsonAvailabilityZoneHints(o.getAvailabilityZoneHints());
        JsonArray new_availabilityZoneHints = json.getJsonArray(BareMetalNetwork.varJson(BareMetalNetwork.VAR_availabilityZoneHints, patch));

        JsonArray old_availabilityZones = BareMetalNetwork.staticJsonAvailabilityZones(o.getAvailabilityZones());
        JsonArray new_availabilityZones = json.getJsonArray(BareMetalNetwork.varJson(BareMetalNetwork.VAR_availabilityZones, patch));

        String old_createdAt = BareMetalNetwork.staticJsonCreatedAt(o.getCreatedAt());
        String new_createdAt = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_createdAt, patch));

        String old_dnsDomain = BareMetalNetwork.staticJsonDnsDomain(o.getDnsDomain());
        String new_dnsDomain = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_dnsDomain, patch));

        String old_mtu = BareMetalNetwork.staticJsonMtu(o.getMtu());
        String new_mtu = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_mtu, patch));

        String old_projectId = BareMetalNetwork.staticJsonProjectId(o.getProjectId());
        String new_projectId = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_projectId, patch));

        String old_providerNetworkType = BareMetalNetwork.staticJsonProviderNetworkType(o.getProviderNetworkType());
        String new_providerNetworkType = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_providerNetworkType, patch));

        String old_providerPhysicalNetwork = BareMetalNetwork.staticJsonProviderPhysicalNetwork(o.getProviderPhysicalNetwork());
        String new_providerPhysicalNetwork = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_providerPhysicalNetwork, patch));

        String old_providerSegmentationId = BareMetalNetwork.staticJsonProviderSegmentationId(o.getProviderSegmentationId());
        String new_providerSegmentationId = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_providerSegmentationId, patch));

        String old_qosPolicyId = BareMetalNetwork.staticJsonQosPolicyId(o.getQosPolicyId());
        String new_qosPolicyId = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_qosPolicyId, patch));

        String old_revisionNumber = BareMetalNetwork.staticJsonRevisionNumber(o.getRevisionNumber());
        String new_revisionNumber = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_revisionNumber, patch));

        String old_status = BareMetalNetwork.staticJsonStatus(o.getStatus());
        String new_status = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_status, patch));

        JsonArray old_subnetIds = BareMetalNetwork.staticJsonSubnetIds(o.getSubnetIds());
        JsonArray new_subnetIds = json.getJsonArray(BareMetalNetwork.varJson(BareMetalNetwork.VAR_subnetIds, patch));

        JsonArray old_tags = BareMetalNetwork.staticJsonTags(o.getTags());
        JsonArray new_tags = json.getJsonArray(BareMetalNetwork.varJson(BareMetalNetwork.VAR_tags, patch));

        String old_tenantId = BareMetalNetwork.staticJsonTenantId(o.getTenantId());
        String new_tenantId = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_tenantId, patch));

        String old_updatedAt = BareMetalNetwork.staticJsonUpdatedAt(o.getUpdatedAt());
        String new_updatedAt = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_updatedAt, patch));

        Boolean old_isAdminStateUp = BareMetalNetwork.staticJsonIsAdminStateUp(o.getIsAdminStateUp());
        Boolean new_isAdminStateUp = json.getBoolean(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isAdminStateUp, patch));

        Boolean old_isDefault = BareMetalNetwork.staticJsonIsDefault(o.getIsDefault());
        Boolean new_isDefault = json.getBoolean(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isDefault, patch));

        Boolean old_isPortSecurityEnabled = BareMetalNetwork.staticJsonIsPortSecurityEnabled(o.getIsPortSecurityEnabled());
        Boolean new_isPortSecurityEnabled = json.getBoolean(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isPortSecurityEnabled, patch));

        Boolean old_isRouterExternal = BareMetalNetwork.staticJsonIsRouterExternal(o.getIsRouterExternal());
        Boolean new_isRouterExternal = json.getBoolean(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isRouterExternal, patch));

        Boolean old_isShared = BareMetalNetwork.staticJsonIsShared(o.getIsShared());
        Boolean new_isShared = json.getBoolean(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isShared, patch));

        Boolean old_isVlanQueing = BareMetalNetwork.staticJsonIsVlanQueing(o.getIsVlanQueing());
        Boolean new_isVlanQueing = json.getBoolean(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isVlanQueing, patch));

        Boolean old_isVlanTransparent = BareMetalNetwork.staticJsonIsVlanTransparent(o.getIsVlanTransparent());
        Boolean new_isVlanTransparent = json.getBoolean(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isVlanTransparent, patch));

        Boolean old_l2Adjacency = BareMetalNetwork.staticJsonL2Adjacency(o.getL2Adjacency());
        Boolean new_l2Adjacency = json.getBoolean(BareMetalNetwork.varJson(BareMetalNetwork.VAR_l2Adjacency, patch));

        String old_locationCloud = BareMetalNetwork.staticJsonLocationCloud(o.getLocationCloud());
        String new_locationCloud = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationCloud, patch));

        String old_locationProjectDomainId = BareMetalNetwork.staticJsonLocationProjectDomainId(o.getLocationProjectDomainId());
        String new_locationProjectDomainId = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationProjectDomainId, patch));

        String old_locationProjectDomainName = BareMetalNetwork.staticJsonLocationProjectDomainName(o.getLocationProjectDomainName());
        String new_locationProjectDomainName = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationProjectDomainName, patch));

        String old_locationProjectId = BareMetalNetwork.staticJsonLocationProjectId(o.getLocationProjectId());
        String new_locationProjectId = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationProjectId, patch));

        String old_locationProjectName = BareMetalNetwork.staticJsonLocationProjectName(o.getLocationProjectName());
        String new_locationProjectName = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationProjectName, patch));

        String old_locationRegionName = BareMetalNetwork.staticJsonLocationRegionName(o.getLocationRegionName());
        String new_locationRegionName = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationRegionName, patch));

        String old_locationZone = BareMetalNetwork.staticJsonLocationZone(o.getLocationZone());
        String new_locationZone = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationZone, patch));

        String old_created = BareMetalNetwork.staticJsonCreated(o.getCreated());
        String new_created = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_created, patch));

        Boolean old_archived = BareMetalNetwork.staticJsonArchived(o.getArchived());
        Boolean new_archived = json.getBoolean(BareMetalNetwork.varJson(BareMetalNetwork.VAR_archived, patch));

        String old_sessionId = BareMetalNetwork.staticJsonSessionId(o.getSessionId());
        String new_sessionId = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_sessionId, patch));

        String old_userKey = BareMetalNetwork.staticJsonUserKey(o.getUserKey());
        String new_userKey = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_userKey, patch));

        String old_objectTitle = BareMetalNetwork.staticJsonObjectTitle(o.getObjectTitle());
        String new_objectTitle = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_objectTitle, patch));

        String old_apiUrl = BareMetalNetwork.staticJsonApiUrl(o.getApiUrl());
        String new_apiUrl = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_apiUrl, patch));

        String old_displayPage = BareMetalNetwork.staticJsonDisplayPage(o.getDisplayPage());
        String new_displayPage = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_displayPage, patch));

        String old_editPage = BareMetalNetwork.staticJsonEditPage(o.getEditPage());
        String new_editPage = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_editPage, patch));

        String old_userPage = BareMetalNetwork.staticJsonUserPage(o.getUserPage());
        String new_userPage = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_userPage, patch));

        String old_download = BareMetalNetwork.staticJsonDownload(o.getDownload());
        String new_download = json.getString(BareMetalNetwork.varJson(BareMetalNetwork.VAR_download, patch));

        String id = Optional.ofNullable(Optional.ofNullable(new_id).orElse(old_id)).orElse(null);
        // if(!Objects.equals(old_id, id))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_id, patch), id);
        String name = Optional.ofNullable(Optional.ofNullable(new_name).orElse(old_name)).orElse(null);
        // if(!Objects.equals(old_name, name))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_name, patch), name);
        String description = Optional.ofNullable(Optional.ofNullable(new_description).orElse(old_description)).orElse(null);
        // if(!Objects.equals(old_description, description))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_description, patch), description);
        JsonArray availabilityZoneHints = Optional.ofNullable(Optional.ofNullable(new_availabilityZoneHints).orElse(old_availabilityZoneHints)).orElse(null);
        // if(!Objects.equals(old_availabilityZoneHints, availabilityZoneHints))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_availabilityZoneHints, patch), availabilityZoneHints);
        JsonArray availabilityZones = Optional.ofNullable(Optional.ofNullable(new_availabilityZones).orElse(old_availabilityZones)).orElse(null);
        // if(!Objects.equals(old_availabilityZones, availabilityZones))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_availabilityZones, patch), availabilityZones);
        String createdAt = Optional.ofNullable(Optional.ofNullable(new_createdAt).orElse(old_createdAt)).orElse(null);
        // if(!Objects.equals(old_createdAt, createdAt))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_createdAt, patch), createdAt);
        String dnsDomain = Optional.ofNullable(Optional.ofNullable(new_dnsDomain).orElse(old_dnsDomain)).orElse(null);
        // if(!Objects.equals(old_dnsDomain, dnsDomain))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_dnsDomain, patch), dnsDomain);
        String mtu = Optional.ofNullable(Optional.ofNullable(new_mtu).orElse(old_mtu)).orElse(null);
        // if(!Objects.equals(old_mtu, mtu))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_mtu, patch), mtu);
        String projectId = Optional.ofNullable(Optional.ofNullable(new_projectId).orElse(old_projectId)).orElse(null);
        // if(!Objects.equals(old_projectId, projectId))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_projectId, patch), projectId);
        String providerNetworkType = Optional.ofNullable(Optional.ofNullable(new_providerNetworkType).orElse(old_providerNetworkType)).orElse(null);
        // if(!Objects.equals(old_providerNetworkType, providerNetworkType))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_providerNetworkType, patch), providerNetworkType);
        String providerPhysicalNetwork = Optional.ofNullable(Optional.ofNullable(new_providerPhysicalNetwork).orElse(old_providerPhysicalNetwork)).orElse(null);
        // if(!Objects.equals(old_providerPhysicalNetwork, providerPhysicalNetwork))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_providerPhysicalNetwork, patch), providerPhysicalNetwork);
        String providerSegmentationId = Optional.ofNullable(Optional.ofNullable(new_providerSegmentationId).orElse(old_providerSegmentationId)).orElse(null);
        // if(!Objects.equals(old_providerSegmentationId, providerSegmentationId))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_providerSegmentationId, patch), providerSegmentationId);
        String qosPolicyId = Optional.ofNullable(Optional.ofNullable(new_qosPolicyId).orElse(old_qosPolicyId)).orElse(null);
        // if(!Objects.equals(old_qosPolicyId, qosPolicyId))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_qosPolicyId, patch), qosPolicyId);
        String revisionNumber = Optional.ofNullable(Optional.ofNullable(new_revisionNumber).orElse(old_revisionNumber)).orElse(null);
        // if(!Objects.equals(old_revisionNumber, revisionNumber))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_revisionNumber, patch), revisionNumber);
        String status = Optional.ofNullable(Optional.ofNullable(new_status).orElse(old_status)).orElse(null);
        // if(!Objects.equals(old_status, status))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_status, patch), status);
        JsonArray subnetIds = Optional.ofNullable(Optional.ofNullable(new_subnetIds).orElse(old_subnetIds)).orElse(null);
        // if(!Objects.equals(old_subnetIds, subnetIds))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_subnetIds, patch), subnetIds);
        JsonArray tags = Optional.ofNullable(Optional.ofNullable(new_tags).orElse(old_tags)).orElse(null);
        // if(!Objects.equals(old_tags, tags))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_tags, patch), tags);
        String tenantId = Optional.ofNullable(Optional.ofNullable(new_tenantId).orElse(old_tenantId)).orElse(null);
        // if(!Objects.equals(old_tenantId, tenantId))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_tenantId, patch), tenantId);
        String updatedAt = Optional.ofNullable(Optional.ofNullable(new_updatedAt).orElse(old_updatedAt)).orElse(null);
        // if(!Objects.equals(old_updatedAt, updatedAt))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_updatedAt, patch), updatedAt);
        Boolean isAdminStateUp = Optional.ofNullable(Optional.ofNullable(new_isAdminStateUp).orElse(old_isAdminStateUp)).orElse(null);
        // if(!Objects.equals(old_isAdminStateUp, isAdminStateUp))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isAdminStateUp, patch), isAdminStateUp);
        Boolean isDefault = Optional.ofNullable(Optional.ofNullable(new_isDefault).orElse(old_isDefault)).orElse(null);
        // if(!Objects.equals(old_isDefault, isDefault))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isDefault, patch), isDefault);
        Boolean isPortSecurityEnabled = Optional.ofNullable(Optional.ofNullable(new_isPortSecurityEnabled).orElse(old_isPortSecurityEnabled)).orElse(null);
        // if(!Objects.equals(old_isPortSecurityEnabled, isPortSecurityEnabled))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isPortSecurityEnabled, patch), isPortSecurityEnabled);
        Boolean isRouterExternal = Optional.ofNullable(Optional.ofNullable(new_isRouterExternal).orElse(old_isRouterExternal)).orElse(null);
        // if(!Objects.equals(old_isRouterExternal, isRouterExternal))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isRouterExternal, patch), isRouterExternal);
        Boolean isShared = Optional.ofNullable(Optional.ofNullable(new_isShared).orElse(old_isShared)).orElse(null);
        // if(!Objects.equals(old_isShared, isShared))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isShared, patch), isShared);
        Boolean isVlanQueing = Optional.ofNullable(Optional.ofNullable(new_isVlanQueing).orElse(old_isVlanQueing)).orElse(null);
        // if(!Objects.equals(old_isVlanQueing, isVlanQueing))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isVlanQueing, patch), isVlanQueing);
        Boolean isVlanTransparent = Optional.ofNullable(Optional.ofNullable(new_isVlanTransparent).orElse(old_isVlanTransparent)).orElse(null);
        // if(!Objects.equals(old_isVlanTransparent, isVlanTransparent))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_isVlanTransparent, patch), isVlanTransparent);
        Boolean l2Adjacency = Optional.ofNullable(Optional.ofNullable(new_l2Adjacency).orElse(old_l2Adjacency)).orElse(null);
        // if(!Objects.equals(old_l2Adjacency, l2Adjacency))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_l2Adjacency, patch), l2Adjacency);
        String locationCloud = Optional.ofNullable(Optional.ofNullable(new_locationCloud).orElse(old_locationCloud)).orElse(null);
        // if(!Objects.equals(old_locationCloud, locationCloud))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationCloud, patch), locationCloud);
        String locationProjectDomainId = Optional.ofNullable(Optional.ofNullable(new_locationProjectDomainId).orElse(old_locationProjectDomainId)).orElse(null);
        // if(!Objects.equals(old_locationProjectDomainId, locationProjectDomainId))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationProjectDomainId, patch), locationProjectDomainId);
        String locationProjectDomainName = Optional.ofNullable(Optional.ofNullable(new_locationProjectDomainName).orElse(old_locationProjectDomainName)).orElse(null);
        // if(!Objects.equals(old_locationProjectDomainName, locationProjectDomainName))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationProjectDomainName, patch), locationProjectDomainName);
        String locationProjectId = Optional.ofNullable(Optional.ofNullable(new_locationProjectId).orElse(old_locationProjectId)).orElse(null);
        // if(!Objects.equals(old_locationProjectId, locationProjectId))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationProjectId, patch), locationProjectId);
        String locationProjectName = Optional.ofNullable(Optional.ofNullable(new_locationProjectName).orElse(old_locationProjectName)).orElse(null);
        // if(!Objects.equals(old_locationProjectName, locationProjectName))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationProjectName, patch), locationProjectName);
        String locationRegionName = Optional.ofNullable(Optional.ofNullable(new_locationRegionName).orElse(old_locationRegionName)).orElse(null);
        // if(!Objects.equals(old_locationRegionName, locationRegionName))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationRegionName, patch), locationRegionName);
        String locationZone = Optional.ofNullable(Optional.ofNullable(new_locationZone).orElse(old_locationZone)).orElse(null);
        // if(!Objects.equals(old_locationZone, locationZone))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_locationZone, patch), locationZone);
        String created = Optional.ofNullable(Optional.ofNullable(new_created).orElse(old_created)).orElse(null);
        // if(!Objects.equals(old_created, created))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_created, patch), created);
        Boolean archived = Optional.ofNullable(Optional.ofNullable(new_archived).orElse(old_archived)).orElse(null);
        // if(!Objects.equals(old_archived, archived))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_archived, patch), archived);
        String sessionId = Optional.ofNullable(Optional.ofNullable(new_sessionId).orElse(old_sessionId)).orElse(null);
        // if(!Objects.equals(old_sessionId, sessionId))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_sessionId, patch), sessionId);
        String userKey = Optional.ofNullable(Optional.ofNullable(new_userKey).orElse(old_userKey)).orElse(null);
        // if(!Objects.equals(old_userKey, userKey))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_userKey, patch), userKey);
        String objectTitle = Optional.ofNullable(Optional.ofNullable(new_objectTitle).orElse(old_objectTitle)).orElse(null);
        // if(!Objects.equals(old_objectTitle, objectTitle))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_objectTitle, patch), objectTitle);
        String apiUrl = Optional.ofNullable(Optional.ofNullable(new_apiUrl).orElse(old_apiUrl)).orElse(null);
        // if(!Objects.equals(old_apiUrl, apiUrl))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_apiUrl, patch), apiUrl);
        String displayPage = Optional.ofNullable(Optional.ofNullable(new_displayPage).orElse(old_displayPage)).orElse(null);
        // if(!Objects.equals(old_displayPage, displayPage))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_displayPage, patch), displayPage);
        String editPage = Optional.ofNullable(Optional.ofNullable(new_editPage).orElse(old_editPage)).orElse(null);
        // if(!Objects.equals(old_editPage, editPage))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_editPage, patch), editPage);
        String userPage = Optional.ofNullable(Optional.ofNullable(new_userPage).orElse(old_userPage)).orElse(null);
        // if(!Objects.equals(old_userPage, userPage))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_userPage, patch), userPage);
        String download = Optional.ofNullable(Optional.ofNullable(new_download).orElse(old_download)).orElse(null);
        // if(!Objects.equals(old_download, download))
          // json.put(BareMetalNetwork.varJson(BareMetalNetwork.VAR_download, patch), download);

        promise.complete(json);
      }
    } catch(Exception ex) {
      LOG.error(String.format("upsertBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> persistBareMetalNetwork(BareMetalNetwork o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Long pk = o.getPk();
      sqlConnection.preparedQuery("SELECT id, name, description, availabilityZoneHints, availabilityZones, createdAt, dnsDomain, mtu, projectId, providerNetworkType, providerPhysicalNetwork, providerSegmentationId, qosPolicyId, revisionNumber, status, subnetIds, tags, tenantId, updatedAt, isAdminStateUp, isDefault, isPortSecurityEnabled, isRouterExternal, isShared, isVlanQueing, isVlanTransparent, l2Adjacency, locationCloud, locationProjectDomainId, locationProjectDomainName, locationProjectId, locationProjectName, locationRegionName, locationZone, created, archived, sessionId, userKey, objectTitle, apiUrl, displayPage, editPage, userPage, download FROM BareMetalNetwork WHERE pk=$1")
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
                  LOG.error(String.format("persistBareMetalNetwork failed. "), e);
                }
              }
            }
          }
          o.promiseDeepForClass(siteRequest).onSuccess(a -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("persistBareMetalNetwork failed. "), ex);
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("persistBareMetalNetwork failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error(String.format("persistBareMetalNetwork failed. "), ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("persistBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> relateBareMetalNetwork(BareMetalNetwork o) {
    Promise<Void> promise = Promise.promise();
    promise.complete();
    return promise.future();
  }

  public String searchVar(String varIndexed) {
    return BareMetalNetwork.searchVarBareMetalNetwork(varIndexed);
  }

  @Override
  public String getClassApiAddress() {
    return BareMetalNetwork.CLASS_API_ADDRESS_BareMetalNetwork;
  }

  public Future<BareMetalNetwork> indexBareMetalNetwork(BareMetalNetwork o) {
    Promise<BareMetalNetwork> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      JsonObject json = new JsonObject();
      JsonObject add = new JsonObject();
      json.put("add", add);
      JsonObject doc = new JsonObject();
      add.put("doc", doc);
      o.indexBareMetalNetwork(doc);
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
        LOG.error(String.format("indexBareMetalNetwork failed. "), new RuntimeException(ex));
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("indexBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<BareMetalNetwork> unindexBareMetalNetwork(BareMetalNetwork o) {
    Promise<BareMetalNetwork> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      o.promiseDeepForClass(siteRequest).onSuccess(a -> {
        JsonObject json = new JsonObject();
        JsonObject delete = new JsonObject();
        json.put("delete", delete);
        String query = String.format("filter(%s:%s)", BareMetalNetwork.VAR_solrId, o.obtainForClass(BareMetalNetwork.VAR_solrId));
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
          LOG.error(String.format("unindexBareMetalNetwork failed. "), new RuntimeException(ex));
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("unindexBareMetalNetwork failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("unindexBareMetalNetwork failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> refreshBareMetalNetwork(BareMetalNetwork o) {
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
          eventBus.request(BareMetalNetwork.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "patchBareMetalNetworkFuture")).onSuccess(c -> {
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
      LOG.error(String.format("refreshBareMetalNetwork failed. "), ex);
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
      BareMetalNetwork o = new BareMetalNetwork();
      o.setSiteRequest_((SiteRequest)siteRequest);

      o.persistForClass(BareMetalNetwork.VAR_id, BareMetalNetwork.staticSetId(siteRequest2, (String)result.get(BareMetalNetwork.VAR_id)));
      o.persistForClass(BareMetalNetwork.VAR_name, BareMetalNetwork.staticSetName(siteRequest2, (String)result.get(BareMetalNetwork.VAR_name)));
      o.persistForClass(BareMetalNetwork.VAR_description, BareMetalNetwork.staticSetDescription(siteRequest2, (String)result.get(BareMetalNetwork.VAR_description)));
      o.persistForClass(BareMetalNetwork.VAR_availabilityZoneHints, BareMetalNetwork.staticSetAvailabilityZoneHints(siteRequest2, (String)result.get(BareMetalNetwork.VAR_availabilityZoneHints)));
      o.persistForClass(BareMetalNetwork.VAR_availabilityZones, result.get(BareMetalNetwork.VAR_availabilityZones));
      o.persistForClass(BareMetalNetwork.VAR_createdAt, BareMetalNetwork.staticSetCreatedAt(siteRequest2, (String)result.get(BareMetalNetwork.VAR_createdAt), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(BareMetalNetwork.VAR_dnsDomain, BareMetalNetwork.staticSetDnsDomain(siteRequest2, (String)result.get(BareMetalNetwork.VAR_dnsDomain)));
      o.persistForClass(BareMetalNetwork.VAR_mtu, BareMetalNetwork.staticSetMtu(siteRequest2, (String)result.get(BareMetalNetwork.VAR_mtu)));
      o.persistForClass(BareMetalNetwork.VAR_projectId, BareMetalNetwork.staticSetProjectId(siteRequest2, (String)result.get(BareMetalNetwork.VAR_projectId)));
      o.persistForClass(BareMetalNetwork.VAR_providerNetworkType, BareMetalNetwork.staticSetProviderNetworkType(siteRequest2, (String)result.get(BareMetalNetwork.VAR_providerNetworkType)));
      o.persistForClass(BareMetalNetwork.VAR_providerPhysicalNetwork, BareMetalNetwork.staticSetProviderPhysicalNetwork(siteRequest2, (String)result.get(BareMetalNetwork.VAR_providerPhysicalNetwork)));
      o.persistForClass(BareMetalNetwork.VAR_providerSegmentationId, BareMetalNetwork.staticSetProviderSegmentationId(siteRequest2, (String)result.get(BareMetalNetwork.VAR_providerSegmentationId)));
      o.persistForClass(BareMetalNetwork.VAR_qosPolicyId, BareMetalNetwork.staticSetQosPolicyId(siteRequest2, (String)result.get(BareMetalNetwork.VAR_qosPolicyId)));
      o.persistForClass(BareMetalNetwork.VAR_revisionNumber, BareMetalNetwork.staticSetRevisionNumber(siteRequest2, (String)result.get(BareMetalNetwork.VAR_revisionNumber)));
      o.persistForClass(BareMetalNetwork.VAR_status, BareMetalNetwork.staticSetStatus(siteRequest2, (String)result.get(BareMetalNetwork.VAR_status)));
      o.persistForClass(BareMetalNetwork.VAR_subnetIds, result.get(BareMetalNetwork.VAR_subnetIds));
      o.persistForClass(BareMetalNetwork.VAR_tags, result.get(BareMetalNetwork.VAR_tags));
      o.persistForClass(BareMetalNetwork.VAR_tenantId, BareMetalNetwork.staticSetTenantId(siteRequest2, (String)result.get(BareMetalNetwork.VAR_tenantId)));
      o.persistForClass(BareMetalNetwork.VAR_updatedAt, BareMetalNetwork.staticSetUpdatedAt(siteRequest2, (String)result.get(BareMetalNetwork.VAR_updatedAt), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(BareMetalNetwork.VAR_isAdminStateUp, BareMetalNetwork.staticSetIsAdminStateUp(siteRequest2, (String)result.get(BareMetalNetwork.VAR_isAdminStateUp)));
      o.persistForClass(BareMetalNetwork.VAR_isDefault, BareMetalNetwork.staticSetIsDefault(siteRequest2, (String)result.get(BareMetalNetwork.VAR_isDefault)));
      o.persistForClass(BareMetalNetwork.VAR_isPortSecurityEnabled, BareMetalNetwork.staticSetIsPortSecurityEnabled(siteRequest2, (String)result.get(BareMetalNetwork.VAR_isPortSecurityEnabled)));
      o.persistForClass(BareMetalNetwork.VAR_isRouterExternal, BareMetalNetwork.staticSetIsRouterExternal(siteRequest2, (String)result.get(BareMetalNetwork.VAR_isRouterExternal)));
      o.persistForClass(BareMetalNetwork.VAR_isShared, BareMetalNetwork.staticSetIsShared(siteRequest2, (String)result.get(BareMetalNetwork.VAR_isShared)));
      o.persistForClass(BareMetalNetwork.VAR_isVlanQueing, BareMetalNetwork.staticSetIsVlanQueing(siteRequest2, (String)result.get(BareMetalNetwork.VAR_isVlanQueing)));
      o.persistForClass(BareMetalNetwork.VAR_isVlanTransparent, BareMetalNetwork.staticSetIsVlanTransparent(siteRequest2, (String)result.get(BareMetalNetwork.VAR_isVlanTransparent)));
      o.persistForClass(BareMetalNetwork.VAR_l2Adjacency, BareMetalNetwork.staticSetL2Adjacency(siteRequest2, (String)result.get(BareMetalNetwork.VAR_l2Adjacency)));
      o.persistForClass(BareMetalNetwork.VAR_locationCloud, BareMetalNetwork.staticSetLocationCloud(siteRequest2, (String)result.get(BareMetalNetwork.VAR_locationCloud)));
      o.persistForClass(BareMetalNetwork.VAR_locationProjectDomainId, BareMetalNetwork.staticSetLocationProjectDomainId(siteRequest2, (String)result.get(BareMetalNetwork.VAR_locationProjectDomainId)));
      o.persistForClass(BareMetalNetwork.VAR_locationProjectDomainName, BareMetalNetwork.staticSetLocationProjectDomainName(siteRequest2, (String)result.get(BareMetalNetwork.VAR_locationProjectDomainName)));
      o.persistForClass(BareMetalNetwork.VAR_locationProjectId, BareMetalNetwork.staticSetLocationProjectId(siteRequest2, (String)result.get(BareMetalNetwork.VAR_locationProjectId)));
      o.persistForClass(BareMetalNetwork.VAR_locationProjectName, BareMetalNetwork.staticSetLocationProjectName(siteRequest2, (String)result.get(BareMetalNetwork.VAR_locationProjectName)));
      o.persistForClass(BareMetalNetwork.VAR_locationRegionName, BareMetalNetwork.staticSetLocationRegionName(siteRequest2, (String)result.get(BareMetalNetwork.VAR_locationRegionName)));
      o.persistForClass(BareMetalNetwork.VAR_locationZone, BareMetalNetwork.staticSetLocationZone(siteRequest2, (String)result.get(BareMetalNetwork.VAR_locationZone)));
      o.persistForClass(BareMetalNetwork.VAR_created, BareMetalNetwork.staticSetCreated(siteRequest2, (String)result.get(BareMetalNetwork.VAR_created), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(BareMetalNetwork.VAR_archived, BareMetalNetwork.staticSetArchived(siteRequest2, (String)result.get(BareMetalNetwork.VAR_archived)));
      o.persistForClass(BareMetalNetwork.VAR_sessionId, BareMetalNetwork.staticSetSessionId(siteRequest2, (String)result.get(BareMetalNetwork.VAR_sessionId)));
      o.persistForClass(BareMetalNetwork.VAR_userKey, BareMetalNetwork.staticSetUserKey(siteRequest2, (String)result.get(BareMetalNetwork.VAR_userKey)));
      o.persistForClass(BareMetalNetwork.VAR_objectTitle, BareMetalNetwork.staticSetObjectTitle(siteRequest2, (String)result.get(BareMetalNetwork.VAR_objectTitle)));
      o.persistForClass(BareMetalNetwork.VAR_apiUrl, BareMetalNetwork.staticSetApiUrl(siteRequest2, (String)result.get(BareMetalNetwork.VAR_apiUrl)));
      o.persistForClass(BareMetalNetwork.VAR_displayPage, BareMetalNetwork.staticSetDisplayPage(siteRequest2, (String)result.get(BareMetalNetwork.VAR_displayPage)));
      o.persistForClass(BareMetalNetwork.VAR_editPage, BareMetalNetwork.staticSetEditPage(siteRequest2, (String)result.get(BareMetalNetwork.VAR_editPage)));
      o.persistForClass(BareMetalNetwork.VAR_userPage, BareMetalNetwork.staticSetUserPage(siteRequest2, (String)result.get(BareMetalNetwork.VAR_userPage)));
      o.persistForClass(BareMetalNetwork.VAR_download, BareMetalNetwork.staticSetDownload(siteRequest2, (String)result.get(BareMetalNetwork.VAR_download)));

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

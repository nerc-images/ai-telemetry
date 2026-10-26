package org.computate.aitelemetry.model.gpudevice;

import org.computate.aitelemetry.model.hub.HubEnUSApiServiceImpl;
import org.computate.aitelemetry.model.hub.Hub;
import org.computate.aitelemetry.model.cluster.ClusterEnUSApiServiceImpl;
import org.computate.aitelemetry.model.cluster.Cluster;
import org.computate.aitelemetry.model.node.AiNodeEnUSApiServiceImpl;
import org.computate.aitelemetry.model.node.AiNode;
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
import org.computate.aitelemetry.model.gpudevice.GpuDevicePage;


/**
 * Translate: false
 * Generated: true
 **/
public class GpuDeviceEnUSGenApiServiceImpl extends BaseApiServiceImpl implements GpuDeviceEnUSGenApiService {

  protected static final Logger LOG = LoggerFactory.getLogger(GpuDeviceEnUSGenApiServiceImpl.class);

  // Search //

  @Override
  public void searchGpuDevice(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchGpuDeviceList(siteRequest2, false, true, false, "GET").onSuccess(listGpuDevice -> {
              response200SearchGpuDevice(listGpuDevice).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchGpuDevice succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchGpuDevice failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchGpuDevice failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchGpuDevice failed. ", ex2));
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
        LOG.error(String.format("searchGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200SearchGpuDevice(SearchList<GpuDevice> listGpuDevice) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
      List<String> fls = listGpuDevice.getRequest().getFields();
      JsonObject json = new JsonObject();
      JsonArray l = new JsonArray();
      List<String> scopes = siteRequest.getScopes();
      listGpuDevice.getList().stream().forEach(o -> {
        JsonObject json2 = JsonObject.mapFrom(o);
        if(fls.size() > 0) {
          Set<String> fieldNames = new HashSet<String>();
          for(String fieldName : json2.fieldNames()) {
            String v = GpuDevice.varIndexedGpuDevice(fieldName);
            if(v != null)
              fieldNames.add(GpuDevice.varIndexedGpuDevice(fieldName));
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
      response200Search(listGpuDevice.getRequest(), listGpuDevice.getResponse(), json);
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchGpuDevice(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchGpuDevice(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // GET //

  @Override
  public void getGpuDevice(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "GET", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "GET", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchGpuDeviceList(siteRequest2, false, true, false, "GET").onSuccess(listGpuDevice -> {
              response200GETGpuDevice(listGpuDevice).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("getGpuDevice succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("getGpuDevice failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("getGpuDevice failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("getGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("getGpuDevice failed. ", ex2));
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
        LOG.error(String.format("getGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200GETGpuDevice(SearchList<GpuDevice> listGpuDevice) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
      JsonObject json = JsonObject.mapFrom(listGpuDevice.getList().stream().findFirst().orElse(null));
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200GETGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PATCH //

  @Override
  public void patchGpuDevice(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("patchGpuDevice started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "PATCH", "PATCH", "PATCH").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "PATCH", "PATCH", "PATCH").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchGpuDeviceList(siteRequest2, false, true, true, "PATCH").onSuccess(listGpuDevice -> {
              try {
                ApiRequest apiRequest = new ApiRequest();
                apiRequest.setRows(listGpuDevice.getRequest().getRows());
                apiRequest.setNumFound(listGpuDevice.getResponse().getResponse().getNumFound());
                apiRequest.setNumPATCH(0L);
                apiRequest.initDeepApiRequest(siteRequest2);
                siteRequest2.setApiRequest_(apiRequest);
                if(apiRequest.getNumFound() == 1L)
                  apiRequest.setOriginal(listGpuDevice.first());
                apiRequest.setId(Optional.ofNullable(listGpuDevice.first()).map(o2 -> o2.getGpuDeviceResource().toString()).orElse(null));
                apiRequest.setSolrId(Optional.ofNullable(listGpuDevice.first()).map(o2 -> o2.getSolrId()).orElse(null));
                eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());

                listPATCHGpuDevice(apiRequest, listGpuDevice).onSuccess(e -> {
                  response200PATCHGpuDevice(siteRequest2).onSuccess(response -> {
                    LOG.debug(String.format("patchGpuDevice succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("patchGpuDevice failed. "), ex);
                    error(siteRequest2, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("patchGpuDevice failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format("patchGpuDevice failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("patchGpuDevice failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("patchGpuDevice failed. ", ex2));
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
        LOG.error(String.format("patchGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPATCHGpuDevice(ApiRequest apiRequest, SearchList<GpuDevice> listGpuDevice) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
    listGpuDevice.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      GpuDevice o2 = jsonObject.mapTo(GpuDevice.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        patchGpuDeviceFuture(o2, false).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listPATCHGpuDevice failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listGpuDevice.next().onSuccess(next -> {
        if(next) {
          listPATCHGpuDevice(apiRequest, listGpuDevice).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPATCHGpuDevice failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listPATCHGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listPATCHGpuDevice failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void patchGpuDeviceFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        searchGpuDeviceList(siteRequest, false, true, true, "PATCH").onSuccess(listGpuDevice -> {
          try {
            GpuDevice o = listGpuDevice.first();
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
            GpuDevice o2;
            if(o != null) {
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listGpuDevice.first()).map(o3 -> o3.getGpuDeviceResource().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listGpuDevice.first()).map(o3 -> o3.getSolrId()).orElse(null));
              JsonObject jsonObject = JsonObject.mapFrom(o);
              o2 = jsonObject.mapTo(GpuDevice.class);
              o2.setSiteRequest_(siteRequest);
              patchGpuDeviceFuture(o2, false).onSuccess(o3 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else if(refresh) {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            } else {
              String m = String.format("%s %s not found", "GPU device", null);
              eventHandler.handle(Future.failedFuture(m));
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchGpuDevice failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("patchGpuDevice failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("patchGpuDevice failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<GpuDevice> patchGpuDeviceFuture(GpuDevice o, Boolean inheritPrimaryKey) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<GpuDevice> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<GpuDevice> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsGpuDevice(siteRequest).onSuccess(a -> {
          upsertGpuDevice(o, inheritPrimaryKey, true).onSuccess(c -> {
            sqlPATCHGpuDevice(o, inheritPrimaryKey).onSuccess(gpuDevice -> {
              persistGpuDevice(gpuDevice, true).onSuccess(d -> {
                relateGpuDevice(gpuDevice).onSuccess(e -> {
                  indexGpuDevice(gpuDevice).onSuccess(o2 -> {
                    if(apiRequest != null) {
                      apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                      if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                        o2.apiRequestGpuDevice();
                        if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                          eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());
                      }
                    }
                    promise1.complete(gpuDevice);
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
      }).compose(gpuDevice -> {
        Promise<GpuDevice> promise2 = Promise.promise();
        refreshGpuDevice(gpuDevice).onSuccess(a -> {
          promise2.complete(gpuDevice);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(gpuDevice -> {
        promise.complete(gpuDevice);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("patchGpuDeviceFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<GpuDevice> sqlPATCHGpuDevice(GpuDevice o, Boolean inheritPrimaryKey) {
    Promise<GpuDevice> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE GpuDevice SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Set<String> methodNames = jsonObject.fieldNames();
      GpuDevice o2 = new GpuDevice();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      for(String entityVar : methodNames) {
        switch(entityVar) {
          case "setHubId":
              o2.setHubId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_hubId + "=$" + num);
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
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_hubResource, Hub.class, solrId2, val).onSuccess(a -> {
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
                sql(siteRequest).update(GpuDevice.class, pk).setToNull(GpuDevice.VAR_hubResource, Hub.class, null).onSuccess(a -> {
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
              bSql.append(GpuDevice.VAR_clusterName + "=$" + num);
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
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_clusterResource, Cluster.class, solrId2, val).onSuccess(a -> {
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
                sql(siteRequest).update(GpuDevice.class, pk).setToNull(GpuDevice.VAR_clusterResource, Cluster.class, null).onSuccess(a -> {
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
              bSql.append(GpuDevice.VAR_nodeName + "=$" + num);
              num++;
              bParams.add(o2.sqlNodeName());
            break;
          case "setNodeResource":
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(AiNode.varIndexedAiNode(AiNode.VAR_nodeResource), AiNode.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("AiNode");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_nodeResource, AiNode.class, solrId2, val).onSuccess(a -> {
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
          case "removeNodeResource":
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(solrId2 -> {
              futures2.add(Future.future(promise2 -> {
                sql(siteRequest).update(GpuDevice.class, pk).setToNull(GpuDevice.VAR_nodeResource, AiNode.class, null).onSuccess(a -> {
                  promise2.complete();
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }));
            });
            break;
          case "setGpuDeviceNumber":
              o2.setGpuDeviceNumber(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_gpuDeviceNumber + "=$" + num);
              num++;
              bParams.add(o2.sqlGpuDeviceNumber());
            break;
          case "setGpuDeviceResource":
              o2.setGpuDeviceResource(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_gpuDeviceResource + "=$" + num);
              num++;
              bParams.add(o2.sqlGpuDeviceResource());
            break;
          case "setModelName":
              o2.setModelName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_modelName + "=$" + num);
              num++;
              bParams.add(o2.sqlModelName());
            break;
          case "setGpuDeviceUtilization":
              o2.setGpuDeviceUtilization(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_gpuDeviceUtilization + "=$" + num);
              num++;
              bParams.add(o2.sqlGpuDeviceUtilization());
            break;
          case "setDescription":
              o2.setDescription(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_description + "=$" + num);
              num++;
              bParams.add(o2.sqlDescription());
            break;
          case "setLocation":
              o2.setLocation(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_location + "=$" + num);
              num++;
              bParams.add(o2.sqlLocation());
            break;
          case "setId":
              o2.setId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_id + "=$" + num);
              num++;
              bParams.add(o2.sqlId());
            break;
          case "setNgsildTenant":
              o2.setNgsildTenant(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_ngsildTenant + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildTenant());
            break;
          case "setNgsildPath":
              o2.setNgsildPath(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_ngsildPath + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildPath());
            break;
          case "setNgsildContext":
              o2.setNgsildContext(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_ngsildContext + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildContext());
            break;
          case "setNgsildData":
              o2.setNgsildData(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_ngsildData + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildData());
            break;
          case "setCreated":
              o2.setCreated(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_created + "=$" + num);
              num++;
              bParams.add(o2.sqlCreated());
            break;
          case "setArchived":
              o2.setArchived(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_archived + "=$" + num);
              num++;
              bParams.add(o2.sqlArchived());
            break;
          case "setSessionId":
              o2.setSessionId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_sessionId + "=$" + num);
              num++;
              bParams.add(o2.sqlSessionId());
            break;
          case "setUserKey":
              o2.setUserKey(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_userKey + "=$" + num);
              num++;
              bParams.add(o2.sqlUserKey());
            break;
          case "setObjectTitle":
              o2.setObjectTitle(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_objectTitle + "=$" + num);
              num++;
              bParams.add(o2.sqlObjectTitle());
            break;
          case "setApiUrl":
              o2.setApiUrl(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_apiUrl + "=$" + num);
              num++;
              bParams.add(o2.sqlApiUrl());
            break;
          case "setDisplayPage":
              o2.setDisplayPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_displayPage + "=$" + num);
              num++;
              bParams.add(o2.sqlDisplayPage());
            break;
          case "setEditPage":
              o2.setEditPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_editPage + "=$" + num);
              num++;
              bParams.add(o2.sqlEditPage());
            break;
          case "setUserPage":
              o2.setUserPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_userPage + "=$" + num);
              num++;
              bParams.add(o2.sqlUserPage());
            break;
          case "setDownload":
              o2.setDownload(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(GpuDevice.VAR_download + "=$" + num);
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
            RuntimeException ex2 = new RuntimeException("value GpuDevice failed", ex);
            LOG.error(String.format("relateGpuDevice failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          GpuDevice o3 = new GpuDevice();
          o3.setSiteRequest_(o.getSiteRequest_());
          o3.setPk(pk);
          promise.complete(o3);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPATCHGpuDevice failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPATCHGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPATCHGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200PATCHGpuDevice(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PATCHGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // POST //

  @Override
  public void postGpuDevice(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("postGpuDevice started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "POST", "POST", "POST").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "POST", "POST", "POST").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setRows(1L);
            apiRequest.setNumFound(1L);
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest2);
            siteRequest2.setApiRequest_(apiRequest);
            eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());
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
            eventBus.request(GpuDevice.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postGpuDeviceFuture")).onSuccess(a -> {
              JsonObject responseMessage = (JsonObject)a.body();
              JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
              apiRequest.setSolrId(responseBody.getString(GpuDevice.VAR_solrId));
              response200POSTGpuDevice(siteRequest2, responseBody).onSuccess(response -> {
                LOG.debug(String.format("postGpuDevice succeeded. "));
                eventHandler.handle(Future.succeededFuture(response));
              }).onFailure(ex -> {
                LOG.error(String.format("postGpuDevice failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("postGpuDevice failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("postGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postGpuDevice failed. ", ex2));
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
        LOG.error(String.format("postGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  @Override
  public void postGpuDeviceFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        postGpuDeviceFuture(siteRequest, false).onSuccess(o -> {
          eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
        }).onFailure(ex -> {
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Throwable ex) {
        LOG.error(String.format("postGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postGpuDevice failed. ", ex2));
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
        LOG.error(String.format("postGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<GpuDevice> postGpuDeviceFuture(SiteRequest siteRequest, Boolean gpuDeviceResource) {
    Promise<GpuDevice> promise = Promise.promise();

    try {
      pgPool.withTransaction(sqlConnection -> {
        Promise<GpuDevice> promise1 = Promise.promise();
        siteRequest.setSqlConnection(sqlConnection);
        varsGpuDevice(siteRequest).onSuccess(a -> {
          createGpuDevice(siteRequest).onSuccess(gpuDevice -> {
            upsertGpuDevice(gpuDevice, gpuDeviceResource, false).onSuccess(b -> {
              sqlPOSTGpuDevice(gpuDevice, gpuDeviceResource).onSuccess(c -> {
                persistGpuDevice(gpuDevice, false).onSuccess(d -> {
                  relateGpuDevice(gpuDevice).onSuccess(e -> {
                    indexGpuDevice(gpuDevice).onSuccess(o2 -> {
                      promise1.complete(gpuDevice);
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
      }).compose(gpuDevice -> {
        Promise<GpuDevice> promise2 = Promise.promise();
        refreshGpuDevice(gpuDevice).onSuccess(a -> {
          try {
            ApiRequest apiRequest = siteRequest.getApiRequest_();
            if(apiRequest != null) {
              apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
              gpuDevice.apiRequestGpuDevice();
              eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());
            }
            promise2.complete(gpuDevice);
          } catch(Exception ex) {
            LOG.error(String.format("postGpuDeviceFuture failed. "), ex);
            promise2.tryFail(ex);
          }
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(gpuDevice -> {
        try {
          ApiRequest apiRequest = siteRequest.getApiRequest_();
          if(apiRequest != null) {
            apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
            gpuDevice.apiRequestGpuDevice();
            eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());
          }
          promise.complete(gpuDevice);
        } catch(Exception ex) {
          LOG.error(String.format("postGpuDeviceFuture failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("postGpuDeviceFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<GpuDevice> sqlPOSTGpuDevice(GpuDevice o, Boolean inheritPrimaryKey) {
    Promise<GpuDevice> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE GpuDevice SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      GpuDevice o2 = new GpuDevice();
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
          case GpuDevice.VAR_hubId:
            o2.setHubId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_hubId + "=$" + num);
            num++;
            bParams.add(o2.sqlHubId());
            break;
          case GpuDevice.VAR_hubResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Hub.varIndexedHub(Hub.VAR_hubResource), Hub.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Hub");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_hubResource, Hub.class, solrId2, val).onSuccess(a -> {
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
          case GpuDevice.VAR_clusterName:
            o2.setClusterName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_clusterName + "=$" + num);
            num++;
            bParams.add(o2.sqlClusterName());
            break;
          case GpuDevice.VAR_clusterResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Cluster.varIndexedCluster(Cluster.VAR_clusterResource), Cluster.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Cluster");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_clusterResource, Cluster.class, solrId2, val).onSuccess(a -> {
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
          case GpuDevice.VAR_nodeName:
            o2.setNodeName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_nodeName + "=$" + num);
            num++;
            bParams.add(o2.sqlNodeName());
            break;
          case GpuDevice.VAR_nodeResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(AiNode.varIndexedAiNode(AiNode.VAR_nodeResource), AiNode.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("AiNode");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_nodeResource, AiNode.class, solrId2, val).onSuccess(a -> {
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
          case GpuDevice.VAR_gpuDeviceNumber:
            o2.setGpuDeviceNumber(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_gpuDeviceNumber + "=$" + num);
            num++;
            bParams.add(o2.sqlGpuDeviceNumber());
            break;
          case GpuDevice.VAR_gpuDeviceResource:
            o2.setGpuDeviceResource(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_gpuDeviceResource + "=$" + num);
            num++;
            bParams.add(o2.sqlGpuDeviceResource());
            break;
          case GpuDevice.VAR_modelName:
            o2.setModelName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_modelName + "=$" + num);
            num++;
            bParams.add(o2.sqlModelName());
            break;
          case GpuDevice.VAR_gpuDeviceUtilization:
            o2.setGpuDeviceUtilization(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_gpuDeviceUtilization + "=$" + num);
            num++;
            bParams.add(o2.sqlGpuDeviceUtilization());
            break;
          case GpuDevice.VAR_description:
            o2.setDescription(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_description + "=$" + num);
            num++;
            bParams.add(o2.sqlDescription());
            break;
          case GpuDevice.VAR_location:
            o2.setLocation(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_location + "=$" + num);
            num++;
            bParams.add(o2.sqlLocation());
            break;
          case GpuDevice.VAR_id:
            o2.setId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_id + "=$" + num);
            num++;
            bParams.add(o2.sqlId());
            break;
          case GpuDevice.VAR_ngsildTenant:
            o2.setNgsildTenant(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_ngsildTenant + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildTenant());
            break;
          case GpuDevice.VAR_ngsildPath:
            o2.setNgsildPath(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_ngsildPath + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildPath());
            break;
          case GpuDevice.VAR_ngsildContext:
            o2.setNgsildContext(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_ngsildContext + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildContext());
            break;
          case GpuDevice.VAR_ngsildData:
            o2.setNgsildData(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_ngsildData + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildData());
            break;
          case GpuDevice.VAR_created:
            o2.setCreated(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_created + "=$" + num);
            num++;
            bParams.add(o2.sqlCreated());
            break;
          case GpuDevice.VAR_archived:
            o2.setArchived(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_archived + "=$" + num);
            num++;
            bParams.add(o2.sqlArchived());
            break;
          case GpuDevice.VAR_userKey:
            o2.setUserKey(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_userKey + "=$" + num);
            num++;
            bParams.add(o2.sqlUserKey());
            break;
          case GpuDevice.VAR_objectTitle:
            o2.setObjectTitle(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_objectTitle + "=$" + num);
            num++;
            bParams.add(o2.sqlObjectTitle());
            break;
          case GpuDevice.VAR_apiUrl:
            o2.setApiUrl(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_apiUrl + "=$" + num);
            num++;
            bParams.add(o2.sqlApiUrl());
            break;
          case GpuDevice.VAR_displayPage:
            o2.setDisplayPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_displayPage + "=$" + num);
            num++;
            bParams.add(o2.sqlDisplayPage());
            break;
          case GpuDevice.VAR_editPage:
            o2.setEditPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_editPage + "=$" + num);
            num++;
            bParams.add(o2.sqlEditPage());
            break;
          case GpuDevice.VAR_userPage:
            o2.setUserPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_userPage + "=$" + num);
            num++;
            bParams.add(o2.sqlUserPage());
            break;
          case GpuDevice.VAR_download:
            o2.setDownload(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(GpuDevice.VAR_download + "=$" + num);
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
            RuntimeException ex2 = new RuntimeException("value GpuDevice failed", ex);
            LOG.error(String.format("relateGpuDevice failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete(o2);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPOSTGpuDevice failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPOSTGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPOSTGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200POSTGpuDevice(SiteRequest siteRequest, JsonObject json) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200POSTGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // DELETE //

  @Override
  public void deleteGpuDevice(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deleteGpuDevice started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "DELETE", "DELETE", "DELETE").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "DELETE", "DELETE", "DELETE").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchGpuDeviceList(siteRequest2, false, true, true, "DELETE").onSuccess(listGpuDevice -> {
              try {
                ApiRequest apiRequest = new ApiRequest();
                apiRequest.setRows(listGpuDevice.getRequest().getRows());
                apiRequest.setNumFound(listGpuDevice.getResponse().getResponse().getNumFound());
                apiRequest.setNumPATCH(0L);
                apiRequest.initDeepApiRequest(siteRequest2);
                siteRequest2.setApiRequest_(apiRequest);
                if(apiRequest.getNumFound() == 1L)
                  apiRequest.setOriginal(listGpuDevice.first());
                apiRequest.setSolrId(Optional.ofNullable(listGpuDevice.first()).map(o2 -> o2.getSolrId()).orElse(null));
                eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());

                listDELETEGpuDevice(apiRequest, listGpuDevice).onSuccess(e -> {
                  response200DELETEGpuDevice(siteRequest2).onSuccess(response -> {
                    LOG.debug(String.format("deleteGpuDevice succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("deleteGpuDevice failed. "), ex);
                    error(siteRequest2, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("deleteGpuDevice failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format("deleteGpuDevice failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("deleteGpuDevice failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deleteGpuDevice failed. ", ex2));
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
        LOG.error(String.format("deleteGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEGpuDevice(ApiRequest apiRequest, SearchList<GpuDevice> listGpuDevice) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
    listGpuDevice.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      GpuDevice o2 = jsonObject.mapTo(GpuDevice.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deleteGpuDeviceFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEGpuDevice failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listGpuDevice.next().onSuccess(next -> {
        if(next) {
          listDELETEGpuDevice(apiRequest, listGpuDevice).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEGpuDevice failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEGpuDevice failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deleteGpuDeviceFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        searchGpuDeviceList(siteRequest, false, true, true, "DELETE").onSuccess(listGpuDevice -> {
          try {
            GpuDevice o = listGpuDevice.first();
            if(o != null && listGpuDevice.getResponse().getResponse().getNumFound() == 1) {
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
              apiRequest.setId(Optional.ofNullable(listGpuDevice.first()).map(o2 -> o2.getGpuDeviceResource().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listGpuDevice.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deleteGpuDeviceFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deleteGpuDevice failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deleteGpuDevice failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deleteGpuDevice failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<GpuDevice> deleteGpuDeviceFuture(GpuDevice o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<GpuDevice> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<GpuDevice> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsGpuDevice(siteRequest).onSuccess(a -> {
          sqlDELETEGpuDevice(o).onSuccess(gpuDevice -> {
            relateGpuDevice(o).onSuccess(d -> {
              unindexGpuDevice(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestGpuDevice();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());
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
      }).compose(gpuDevice -> {
        Promise<GpuDevice> promise2 = Promise.promise();
        refreshGpuDevice(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(gpuDevice -> {
        promise.complete(gpuDevice);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deleteGpuDeviceFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETEGpuDevice(GpuDevice o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM GpuDevice ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      GpuDevice o2 = new GpuDevice();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
          case GpuDevice.VAR_hubResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Hub.varIndexedHub(Hub.VAR_hubResource), Hub.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Hub");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_hubResource, Hub.class, null, null).onSuccess(a -> {
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
          case GpuDevice.VAR_clusterResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Cluster.varIndexedCluster(Cluster.VAR_clusterResource), Cluster.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Cluster");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_clusterResource, Cluster.class, null, null).onSuccess(a -> {
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
          case GpuDevice.VAR_nodeResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(AiNode.varIndexedAiNode(AiNode.VAR_nodeResource), AiNode.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("AiNode");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_nodeResource, AiNode.class, null, null).onSuccess(a -> {
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
          RuntimeException ex2 = new RuntimeException("value GpuDevice failed", ex);
          LOG.error(String.format("unrelateGpuDevice failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETEGpuDevice failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETEGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETEGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEGpuDevice(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PUTImport //

  @Override
  public void putimportGpuDevice(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("putimportGpuDevice started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "PUTImport", "PUT", "PUT").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "PUTImport", "PUT", "PUT").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            ApiRequest apiRequest = new ApiRequest();
            JsonArray jsonArray = Optional.ofNullable(siteRequest2.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
            apiRequest.setRows(Long.valueOf(jsonArray.size()));
            apiRequest.setNumFound(Long.valueOf(jsonArray.size()));
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest2);
            siteRequest2.setApiRequest_(apiRequest);
            eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());
            varsGpuDevice(siteRequest2).onSuccess(d -> {
              listPUTImportGpuDevice(apiRequest, siteRequest2).onSuccess(e -> {
                response200PUTImportGpuDevice(siteRequest2).onSuccess(response -> {
                  LOG.debug(String.format("putimportGpuDevice succeeded. "));
                  eventHandler.handle(Future.succeededFuture(response));
                }).onFailure(ex -> {
                  LOG.error(String.format("putimportGpuDevice failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("putimportGpuDevice failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("putimportGpuDevice failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportGpuDevice failed. ", ex2));
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
        LOG.error(String.format("putimportGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPUTImportGpuDevice(ApiRequest apiRequest, SiteRequest siteRequest) {
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
          eventBus.request(GpuDevice.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "putimportGpuDeviceFuture")).onSuccess(a -> {
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPUTImportGpuDevice failed. "), ex);
            promise1.tryFail(ex);
          });
        }));
      });
      CompositeFuture.all(futures).onSuccess(a -> {
        apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("listPUTImportGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("listPUTImportGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public void putimportGpuDeviceFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        String gpuDeviceResource = Optional.ofNullable(body.getString(GpuDevice.VAR_gpuDeviceResource)).orElse(body.getString(GpuDevice.VAR_solrId));
        if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
          siteRequest.getRequestVars().put( "refresh", "false" );
        }
        pgPool.getConnection().onSuccess(sqlConnection -> {
          String sqlQuery = String.format("select * from %s WHERE gpuDeviceResource=$1", GpuDevice.CLASS_SIMPLE_NAME);
          sqlConnection.preparedQuery(sqlQuery)
              .execute(Tuple.tuple(Arrays.asList(gpuDeviceResource))
              ).onSuccess(result -> {
            sqlConnection.close().onSuccess(a -> {
              try {
                if(result.size() >= 1) {
                  GpuDevice o = new GpuDevice();
                  o.setSiteRequest_(siteRequest);
                  for(Row definition : result.value()) {
                    for(Integer i = 0; i < definition.size(); i++) {
                      try {
                        String columnName = definition.getColumnName(i);
                        Object columnValue = definition.getValue(i);
                        o.persistForClass(columnName, columnValue);
                      } catch(Exception e) {
                        LOG.error(String.format("persistGpuDevice failed. "), e);
                      }
                    }
                  }
                  GpuDevice o2 = new GpuDevice();
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
                      if(!StringUtils.containsAny(f, "gpuDeviceResource", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                        body2.put("set" + StringUtils.capitalize(f), bodyVal);
                    }
                  }
                  for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
                    if(!body.fieldNames().contains(f)) {
                      if(!StringUtils.containsAny(f, "gpuDeviceResource", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                        body2.putNull("set" + StringUtils.capitalize(f));
                    }
                  }
                  if(result.size() >= 1) {
                    apiRequest.setOriginal(o);
                    apiRequest.setId(Optional.ofNullable(o.getGpuDeviceResource()).map(v -> v.toString()).orElse(null));
                    apiRequest.setSolrId(o.getSolrId());
                  }
                  siteRequest.setJsonObject(body2);
                  patchGpuDeviceFuture(o, true).onSuccess(b -> {
                    LOG.debug("Import GpuDevice {} succeeded, modified GpuDevice. ", body.getValue(GpuDevice.VAR_gpuDeviceResource));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportGpuDeviceFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                } else {
                  postGpuDeviceFuture(siteRequest, true).onSuccess(b -> {
                    LOG.debug("Import GpuDevice {} succeeded, created new GpuDevice. ", body.getValue(GpuDevice.VAR_gpuDeviceResource));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportGpuDeviceFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                }
              } catch(Exception ex) {
                LOG.error(String.format("putimportGpuDeviceFuture failed. "), ex);
                eventHandler.handle(Future.failedFuture(ex));
              }
            }).onFailure(ex -> {
              LOG.error(String.format("putimportGpuDeviceFuture failed. "), ex);
              eventHandler.handle(Future.failedFuture(ex));
            });
          }).onFailure(ex -> {
            LOG.error(String.format("putimportGpuDeviceFuture failed. "), ex);
            eventHandler.handle(Future.failedFuture(ex));
          });
        }).onFailure(ex -> {
          LOG.error(String.format("putimportGpuDeviceFuture failed. "), ex);
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportGpuDeviceFuture failed. "), ex);
        eventHandler.handle(Future.failedFuture(ex));
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportGpuDevice failed. ", ex2));
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
        LOG.error(String.format("putimportGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200PUTImportGpuDevice(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PUTImportGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // SearchPage //

  @Override
  public void searchpageGpuDevice(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    oauth2AuthenticationProvider.refresh(User.create(serviceRequest.getUser())).onSuccess(user -> {
      serviceRequest.setUser(user.principal());
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchGpuDeviceList(siteRequest2, false, true, false, "GET").onSuccess(listGpuDevice -> {
              response200SearchPageGpuDevice(listGpuDevice).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchpageGpuDevice succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchpageGpuDevice failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchpageGpuDevice failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchpageGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageGpuDevice failed. ", ex2));
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
        LOG.error(String.format("searchpageGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageGpuDevice failed. ", ex2));
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
        LOG.error(String.format("searchpageGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void searchpageGpuDevicePageInit(JsonObject ctx, GpuDevicePage page, SearchList<GpuDevice> listGpuDevice, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/gpu-device"));
    ctx.put("enUSUrlPage", String.format("%s%s", siteBaseUrl, "/en-us/search/gpu-device"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriSearchPageGpuDevice(ServiceRequest serviceRequest, GpuDevice result) {
    return "en-us/search/gpu-device/GpuDeviceSearchPage.htm";
  }
  public void templateSearchPageGpuDevice(JsonObject ctx, GpuDevicePage page, SearchList<GpuDevice> listGpuDevice, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      GpuDevice result = listGpuDevice.first();
      String pageTemplateUri = templateUriSearchPageGpuDevice(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/search/gpu-device/GpuDeviceSearchPage.htm"), Charset.forName("UTF-8"));
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
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/gpu-device/GpuDeviceGenEditPage.htm")).orElse("en-us/Article.htm");
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
      LOG.error(String.format("templateSearchPageGpuDevice failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200SearchPageGpuDevice(SearchList<GpuDevice> listGpuDevice) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
      GpuDevicePage page = new GpuDevicePage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listGpuDevice.size() >= 1)
        siteRequest.setRequestPk(listGpuDevice.get(0).getPk());
      page.setSearchListGpuDevice_(listGpuDevice);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepGpuDevicePage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          searchpageGpuDevicePageInit(ctx, page, listGpuDevice, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateSearchPageGpuDevice(ctx, page, listGpuDevice, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200SearchPageGpuDevice failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200SearchPageGpuDevice failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200SearchPageGpuDevice failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchPageGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchPageGpuDevice(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchPageGpuDevice(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // EditPage //

  @Override
  public void editpageGpuDevice(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "EditPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "EditPage", "GET", "GET").onSuccess(siteRequest2 -> {
            searchGpuDeviceList(siteRequest2, false, true, false, "GET").onSuccess(listGpuDevice -> {
              response200EditPageGpuDevice(listGpuDevice).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("editpageGpuDevice succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("editpageGpuDevice failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
          }).onFailure(ex -> {
              LOG.error(String.format("editpageGpuDevice failed. "), ex);
              error(siteRequest, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("editpageGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("editpageGpuDevice failed. ", ex2));
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
        LOG.error(String.format("editpageGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void editpageGpuDevicePageInit(JsonObject ctx, GpuDevicePage page, SearchList<GpuDevice> listGpuDevice, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/gpu-device"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriEditPageGpuDevice(ServiceRequest serviceRequest, GpuDevice result) {
    return "en-us/edit/gpu-device/GpuDeviceEditPage.htm";
  }
  public void templateEditPageGpuDevice(JsonObject ctx, GpuDevicePage page, SearchList<GpuDevice> listGpuDevice, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      GpuDevice result = listGpuDevice.first();
      String pageTemplateUri = templateUriEditPageGpuDevice(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/edit/gpu-device/GpuDeviceEditPage.htm"), Charset.forName("UTF-8"));
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
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/gpu-device/GpuDeviceGenEditPage.htm")).orElse("en-us/Article.htm");
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
      LOG.error(String.format("templateEditPageGpuDevice failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200EditPageGpuDevice(SearchList<GpuDevice> listGpuDevice) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
      GpuDevicePage page = new GpuDevicePage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listGpuDevice.size() >= 1)
        siteRequest.setRequestPk(listGpuDevice.get(0).getPk());
      page.setSearchListGpuDevice_(listGpuDevice);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepGpuDevicePage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          editpageGpuDevicePageInit(ctx, page, listGpuDevice, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateEditPageGpuDevice(ctx, page, listGpuDevice, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200EditPageGpuDevice failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200EditPageGpuDevice failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200EditPageGpuDevice failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200EditPageGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotEditPageGpuDevice(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotEditPageGpuDevice(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // UserPage //

  @Override
  public void userpageGpuDevice(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "UserPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "UserPage", "GET", "GET").onSuccess(siteRequest2 -> {
            searchGpuDeviceList(siteRequest2, false, true, false, "GET").onSuccess(listGpuDevice -> {
              response200UserPageGpuDevice(listGpuDevice).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("userpageGpuDevice succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("userpageGpuDevice failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
          }).onFailure(ex -> {
              LOG.error(String.format("userpageGpuDevice failed. "), ex);
              error(siteRequest, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("userpageGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("userpageGpuDevice failed. ", ex2));
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
        LOG.error(String.format("userpageGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void userpageGpuDevicePageInit(JsonObject ctx, GpuDevicePage page, SearchList<GpuDevice> listGpuDevice, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/gpu-device"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriUserPageGpuDevice(ServiceRequest serviceRequest, GpuDevice result) {
    return String.format("%s.htm", StringUtils.substringBefore(serviceRequest.getExtra().getString("uri").substring(1), "?"));
  }
  public void templateUserPageGpuDevice(JsonObject ctx, GpuDevicePage page, SearchList<GpuDevice> listGpuDevice, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      GpuDevice result = listGpuDevice.first();
      String pageTemplateUri = templateUriUserPageGpuDevice(serviceRequest, result);
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
        String pageExtends = Optional.ofNullable(Optional.ofNullable((String)data.get("extends")).orElse("en-us/edit/gpu-device/GpuDeviceGenEditPage.htm")).orElse("en-us/Article.htm");
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
      LOG.error(String.format("templateUserPageGpuDevice failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200UserPageGpuDevice(SearchList<GpuDevice> listGpuDevice) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
      GpuDevicePage page = new GpuDevicePage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listGpuDevice.size() >= 1)
        siteRequest.setRequestPk(listGpuDevice.get(0).getPk());
      page.setSearchListGpuDevice_(listGpuDevice);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepGpuDevicePage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          userpageGpuDevicePageInit(ctx, page, listGpuDevice, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateUserPageGpuDevice(ctx, page, listGpuDevice, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200UserPageGpuDevice failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200UserPageGpuDevice failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200UserPageGpuDevice failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200UserPageGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotUserPageGpuDevice(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotUserPageGpuDevice(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // DELETEFilter //

  @Override
  public void deletefilterGpuDevice(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deletefilterGpuDevice started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        GpuDevice.authorizationGpuDevice(siteRequest, webClient, classPublicRead, "DELETEFilter", "DELETE", "DELETE").onSuccess(authorizationDecisionResponse -> {
          GpuDevice.authorizationScopesGpuDevice(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "DELETEFilter", "DELETE", "DELETE").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchGpuDeviceList(siteRequest2, false, true, true, "DELETE").onSuccess(listGpuDevice -> {
              try {
                ApiRequest apiRequest = new ApiRequest();
                apiRequest.setRows(listGpuDevice.getRequest().getRows());
                apiRequest.setNumFound(listGpuDevice.getResponse().getResponse().getNumFound());
                apiRequest.setNumPATCH(0L);
                apiRequest.initDeepApiRequest(siteRequest2);
                siteRequest2.setApiRequest_(apiRequest);
                if(apiRequest.getNumFound() == 1L)
                  apiRequest.setOriginal(listGpuDevice.first());
                apiRequest.setSolrId(Optional.ofNullable(listGpuDevice.first()).map(o2 -> o2.getSolrId()).orElse(null));
                eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());

                listDELETEFilterGpuDevice(apiRequest, listGpuDevice).onSuccess(e -> {
                  response200DELETEFilterGpuDevice(siteRequest2).onSuccess(response -> {
                    LOG.debug(String.format("deletefilterGpuDevice succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
                    error(siteRequest2, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
                  error(siteRequest2, eventHandler, ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deletefilterGpuDevice failed. ", ex2));
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
        LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEFilterGpuDevice(ApiRequest apiRequest, SearchList<GpuDevice> listGpuDevice) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listGpuDevice.getSiteRequest_(SiteRequest.class);
    listGpuDevice.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      GpuDevice o2 = jsonObject.mapTo(GpuDevice.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deletefilterGpuDeviceFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEFilterGpuDevice failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listGpuDevice.next().onSuccess(next -> {
        if(next) {
          listDELETEFilterGpuDevice(apiRequest, listGpuDevice).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEFilterGpuDevice failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEFilterGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEFilterGpuDevice failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deletefilterGpuDeviceFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
        searchGpuDeviceList(siteRequest, false, true, true, "DELETE").onSuccess(listGpuDevice -> {
          try {
            GpuDevice o = listGpuDevice.first();
            if(o != null && listGpuDevice.getResponse().getResponse().getNumFound() == 1) {
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
              apiRequest.setId(Optional.ofNullable(listGpuDevice.first()).map(o2 -> o2.getGpuDeviceResource().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listGpuDevice.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deletefilterGpuDeviceFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deletefilterGpuDevice failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<GpuDevice> deletefilterGpuDeviceFuture(GpuDevice o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<GpuDevice> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<GpuDevice> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsGpuDevice(siteRequest).onSuccess(a -> {
          sqlDELETEFilterGpuDevice(o).onSuccess(gpuDevice -> {
            relateGpuDevice(o).onSuccess(d -> {
              unindexGpuDevice(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestGpuDevice();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketGpuDevice", JsonObject.mapFrom(apiRequest).toString());
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
      }).compose(gpuDevice -> {
        Promise<GpuDevice> promise2 = Promise.promise();
        refreshGpuDevice(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(gpuDevice -> {
        promise.complete(gpuDevice);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deletefilterGpuDeviceFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETEFilterGpuDevice(GpuDevice o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM GpuDevice ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      GpuDevice o2 = new GpuDevice();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
          case GpuDevice.VAR_hubResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Hub.varIndexedHub(Hub.VAR_hubResource), Hub.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Hub");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_hubResource, Hub.class, null, null).onSuccess(a -> {
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
          case GpuDevice.VAR_clusterResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(Cluster.varIndexedCluster(Cluster.VAR_clusterResource), Cluster.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("Cluster");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_clusterResource, Cluster.class, null, null).onSuccess(a -> {
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
          case GpuDevice.VAR_nodeResource:
            Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
              futures1.add(Future.future(promise2 -> {
                searchModel(siteRequest).query(AiNode.varIndexedAiNode(AiNode.VAR_nodeResource), AiNode.class, val).onSuccess(o3 -> {
                  String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
                  if(solrId2 != null) {
                    solrIds.add(solrId2);
                    classes.add("AiNode");
                  }
                  sql(siteRequest).update(GpuDevice.class, pk).set(GpuDevice.VAR_nodeResource, AiNode.class, null, null).onSuccess(a -> {
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
          RuntimeException ex2 = new RuntimeException("value GpuDevice failed", ex);
          LOG.error(String.format("unrelateGpuDevice failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETEFilterGpuDevice failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETEFilterGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETEFilterGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEFilterGpuDevice(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEFilterGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // General //

  public Future<GpuDevice> createGpuDevice(SiteRequest siteRequest) {
    Promise<GpuDevice> promise = Promise.promise();
    try {
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      String userId = siteRequest.getUserId();
      Long userKey = siteRequest.getUserKey();
      ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

      sqlConnection.preparedQuery("INSERT INTO GpuDevice(created, userKey) VALUES($1, $2) RETURNING pk")
          .collecting(Collectors.toList())
          .execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
        Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
        Long pk = createLine.getLong(0);
        GpuDevice o = new GpuDevice();
        o.setPk(pk);
        o.setSiteRequest_(siteRequest);
        promise.complete(o);
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error("createGpuDevice failed. ", ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("createGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public void searchGpuDeviceQ(SearchList<GpuDevice> searchList, String entityVar, String valueIndexed, String varIndexed) {
    searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
    if(!"*".equals(entityVar)) {
    }
  }

  public String searchGpuDeviceFq(SearchList<GpuDevice> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    if(StringUtils.startsWith(valueIndexed, "[")) {
      String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
      if(fqs.length != 2)
        throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
      String fq1 = fqs[0].equals("*") ? fqs[0] : GpuDevice.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
      String fq2 = fqs[1].equals("*") ? fqs[1] : GpuDevice.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
       return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
    } else {
      return varIndexed + ":" + SearchTool.escapeQueryChars(GpuDevice.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
    }
  }

  public void searchGpuDeviceSort(SearchList<GpuDevice> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    searchList.sort(varIndexed, valueIndexed);
  }

  public void searchGpuDeviceRows(SearchList<GpuDevice> searchList, Long valueRows) {
      searchList.rows(valueRows != null ? valueRows : 10L);
  }

  public void searchGpuDeviceStart(SearchList<GpuDevice> searchList, Long valueStart) {
    searchList.start(valueStart);
  }

  public void searchGpuDeviceVar(SearchList<GpuDevice> searchList, String var, String value) {
    searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
  }

  public void searchGpuDeviceUri(SearchList<GpuDevice> searchList) {
  }

  public Future<ServiceResponse> varsGpuDevice(SiteRequest siteRequest) {
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
          LOG.error(String.format("searchGpuDevice failed. "), ex);
          promise.tryFail(ex);
        }
      });
      promise.complete();
    } catch(Exception ex) {
      LOG.error(String.format("searchGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SearchList<GpuDevice>> searchGpuDeviceList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, String scope) {
    Promise<SearchList<GpuDevice>> promise = Promise.promise();
    try {
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
      String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
      SearchList<GpuDevice> searchList = new SearchList<GpuDevice>();
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
      searchList.setC(GpuDevice.class);
      searchList.setSiteRequest_(siteRequest);
      searchList.facetMinCount(1);
      if(entityList != null) {
        for(String v : entityList) {
          searchList.fl(GpuDevice.varIndexedGpuDevice(v));
        }
      }

      String gpuDeviceResource = serviceRequest.getParams().getJsonObject("path").getString("gpuDeviceResource");
      if(gpuDeviceResource != null) {
        searchList.fq("gpuDeviceResource_docvalues_string:" + SearchTool.escapeQueryChars(gpuDeviceResource));
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
                varsIndexed[i] = GpuDevice.varIndexedGpuDevice(entityVar);
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
                  varIndexed = GpuDevice.varIndexedGpuDevice(entityVar);
                  String entityQ = searchGpuDeviceFq(searchList, entityVar, valueIndexed, varIndexed);
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
                  varIndexed = GpuDevice.varIndexedGpuDevice(entityVar);
                  String entityFq = searchGpuDeviceFq(searchList, entityVar, valueIndexed, varIndexed);
                  mFq.appendReplacement(sb, entityFq);
                }
                if(!sb.isEmpty()) {
                  mFq.appendTail(sb);
                  searchList.fq(sb.toString());
                }
              } else if(paramName.equals("sort")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
                valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
                varIndexed = GpuDevice.varIndexedGpuDevice(entityVar);
                searchGpuDeviceSort(searchList, entityVar, valueIndexed, varIndexed);
              } else if(paramName.equals("start")) {
                valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchGpuDeviceStart(searchList, valueStart);
              } else if(paramName.equals("rows")) {
                valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchGpuDeviceRows(searchList, valueRows);
              } else if(paramName.equals("stats")) {
                searchList.stats((Boolean)paramObject);
              } else if(paramName.equals("stats.field")) {
                Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mStats.find()) {
                  String solrLocalParams = mStats.group(1);
                  entityVar = mStats.group(2).trim();
                  varIndexed = GpuDevice.varIndexedGpuDevice(entityVar);
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
                  varIndexed = GpuDevice.varIndexedGpuDevice(entityVar);
                  searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  facetRange = entityVar;
                }
              } else if(paramName.equals("facet.field")) {
                entityVar = (String)paramObject;
                varIndexed = GpuDevice.varIndexedGpuDevice(entityVar);
                if(varIndexed != null)
                  searchList.facetField(varIndexed);
              } else if(paramName.equals("var")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
                valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
                searchGpuDeviceVar(searchList, entityVar, valueIndexed);
              } else if(paramName.equals("cursorMark")) {
                valueCursorMark = (String)paramObject;
                searchList.cursorMark((String)paramObject);
              }
            }
            searchGpuDeviceUri(searchList);
          }
        } catch(Exception e) {
          ExceptionUtils.rethrow(e);
        }
      }
      if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
        searchList.sort("hubId_docvalues_string", "asc");
        searchList.sort("clusterName_docvalues_string", "asc");
        searchList.sort("nodeName_docvalues_string", "asc");
        searchList.sort("gpuDeviceNumber_docvalues_int", "asc");
        searchList.setDefaultSort(true);
      }
      String facetRange2 = facetRange;
      Date facetRangeStart2 = facetRangeStart;
      Date facetRangeEnd2 = facetRangeEnd;
      String facetRangeGap2 = facetRangeGap;
      String statsField2 = statsField;
      String statsFieldIndexed2 = statsFieldIndexed;
      searchGpuDevice2(siteRequest, populate, store, modify, searchList);
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
            LOG.error(String.format("searchGpuDevice failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete(searchList);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("searchGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("searchGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void searchGpuDevice2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<GpuDevice> searchList) {
  }

  public Future<JsonObject> upsertGpuDevice(GpuDevice o, Boolean inheritPrimaryKey, Boolean patch) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
        promise.complete();
      } else {
        JsonObject json = o.getSiteRequest_().getJsonObject();
        String old_hubResource = GpuDevice.staticJsonHubResource(o.getHubResource());
        String new_hubResource = json.getString(GpuDevice.varJson(GpuDevice.VAR_hubResource, patch));
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
                  String old_clusterResource = GpuDevice.staticJsonClusterResource(o.getClusterResource());
                  String new_clusterResource = json.getString(GpuDevice.varJson(GpuDevice.VAR_clusterResource, patch));
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

                            String old_hubId = GpuDevice.staticJsonHubId(o.getHubId());
                            String new_hubId = json.getString(GpuDevice.varJson(GpuDevice.VAR_hubId, patch));

                            String old_clusterName = GpuDevice.staticJsonClusterName(o.getClusterName());
                            String new_clusterName = json.getString(GpuDevice.varJson(GpuDevice.VAR_clusterName, patch));

                            String old_nodeName = GpuDevice.staticJsonNodeName(o.getNodeName());
                            String new_nodeName = json.getString(GpuDevice.varJson(GpuDevice.VAR_nodeName, patch));

                            String old_nodeResource = GpuDevice.staticJsonNodeResource(o.getNodeResource());
                            String new_nodeResource = json.getString(GpuDevice.varJson(GpuDevice.VAR_nodeResource, patch));

                            String old_gpuDeviceNumber = GpuDevice.staticJsonGpuDeviceNumber(o.getGpuDeviceNumber());
                            String new_gpuDeviceNumber = json.getString(GpuDevice.varJson(GpuDevice.VAR_gpuDeviceNumber, patch));

                            String old_gpuDeviceResource = GpuDevice.staticJsonGpuDeviceResource(o.getGpuDeviceResource());
                            String new_gpuDeviceResource = json.getString(GpuDevice.varJson(GpuDevice.VAR_gpuDeviceResource, patch));

                            String old_modelName = GpuDevice.staticJsonModelName(o.getModelName());
                            String new_modelName = json.getString(GpuDevice.varJson(GpuDevice.VAR_modelName, patch));

                            String old_gpuDeviceUtilization = GpuDevice.staticJsonGpuDeviceUtilization(o.getGpuDeviceUtilization());
                            String new_gpuDeviceUtilization = json.getString(GpuDevice.varJson(GpuDevice.VAR_gpuDeviceUtilization, patch));

                            String old_description = GpuDevice.staticJsonDescription(o.getDescription());
                            String new_description = json.getString(GpuDevice.varJson(GpuDevice.VAR_description, patch));

                            JsonObject old_location = GpuDevice.staticJsonLocation(o.getLocation());
                            JsonObject new_location = json.getJsonObject(GpuDevice.varJson(GpuDevice.VAR_location, patch));

                            String old_id = GpuDevice.staticJsonId(o.getId());
                            String new_id = json.getString(GpuDevice.varJson(GpuDevice.VAR_id, patch));

                            String old_ngsildTenant = GpuDevice.staticJsonNgsildTenant(o.getNgsildTenant());
                            String new_ngsildTenant = json.getString(GpuDevice.varJson(GpuDevice.VAR_ngsildTenant, patch));

                            String old_ngsildPath = GpuDevice.staticJsonNgsildPath(o.getNgsildPath());
                            String new_ngsildPath = json.getString(GpuDevice.varJson(GpuDevice.VAR_ngsildPath, patch));

                            String old_ngsildContext = GpuDevice.staticJsonNgsildContext(o.getNgsildContext());
                            String new_ngsildContext = json.getString(GpuDevice.varJson(GpuDevice.VAR_ngsildContext, patch));

                            JsonObject old_ngsildData = GpuDevice.staticJsonNgsildData(o.getNgsildData());
                            JsonObject new_ngsildData = json.getJsonObject(GpuDevice.varJson(GpuDevice.VAR_ngsildData, patch));

                            String old_created = GpuDevice.staticJsonCreated(o.getCreated());
                            String new_created = json.getString(GpuDevice.varJson(GpuDevice.VAR_created, patch));

                            Boolean old_archived = GpuDevice.staticJsonArchived(o.getArchived());
                            Boolean new_archived = json.getBoolean(GpuDevice.varJson(GpuDevice.VAR_archived, patch));

                            String old_sessionId = GpuDevice.staticJsonSessionId(o.getSessionId());
                            String new_sessionId = json.getString(GpuDevice.varJson(GpuDevice.VAR_sessionId, patch));

                            String old_userKey = GpuDevice.staticJsonUserKey(o.getUserKey());
                            String new_userKey = json.getString(GpuDevice.varJson(GpuDevice.VAR_userKey, patch));

                            String old_objectTitle = GpuDevice.staticJsonObjectTitle(o.getObjectTitle());
                            String new_objectTitle = json.getString(GpuDevice.varJson(GpuDevice.VAR_objectTitle, patch));

                            String old_apiUrl = GpuDevice.staticJsonApiUrl(o.getApiUrl());
                            String new_apiUrl = json.getString(GpuDevice.varJson(GpuDevice.VAR_apiUrl, patch));

                            String old_displayPage = GpuDevice.staticJsonDisplayPage(o.getDisplayPage());
                            String new_displayPage = json.getString(GpuDevice.varJson(GpuDevice.VAR_displayPage, patch));

                            String old_editPage = GpuDevice.staticJsonEditPage(o.getEditPage());
                            String new_editPage = json.getString(GpuDevice.varJson(GpuDevice.VAR_editPage, patch));

                            String old_userPage = GpuDevice.staticJsonUserPage(o.getUserPage());
                            String new_userPage = json.getString(GpuDevice.varJson(GpuDevice.VAR_userPage, patch));

                            String old_download = GpuDevice.staticJsonDownload(o.getDownload());
                            String new_download = json.getString(GpuDevice.varJson(GpuDevice.VAR_download, patch));

                            String hubId = Optional.ofNullable(Optional.ofNullable(new_hubId).orElse(old_hubId)).orElse(null);
                            // if(!Objects.equals(old_hubId, hubId))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_hubId, patch), hubId);
                            String clusterName = Optional.ofNullable(Optional.ofNullable(new_clusterName).orElse(old_clusterName)).orElse(null);
                            // if(!Objects.equals(old_clusterName, clusterName))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_clusterName, patch), clusterName);
                            String nodeName = Optional.ofNullable(Optional.ofNullable(new_nodeName).orElse(old_nodeName)).orElse(null);
                            // if(!Objects.equals(old_nodeName, nodeName))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_nodeName, patch), nodeName);
                            String nodeResource = Optional.ofNullable(Optional.ofNullable(new_nodeResource).orElse(old_nodeResource)).orElse(null);
                            // if(!Objects.equals(old_nodeResource, nodeResource))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_nodeResource, patch), nodeResource);
                            String gpuDeviceNumber = Optional.ofNullable(Optional.ofNullable(new_gpuDeviceNumber).orElse(old_gpuDeviceNumber)).orElse(null);
                            // if(!Objects.equals(old_gpuDeviceNumber, gpuDeviceNumber))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_gpuDeviceNumber, patch), gpuDeviceNumber);
                            String gpuDeviceResource = Optional.ofNullable(Optional.ofNullable(new_gpuDeviceResource).orElse(old_gpuDeviceResource)).orElse(null);
                            // if(!Objects.equals(old_gpuDeviceResource, gpuDeviceResource))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_gpuDeviceResource, patch), gpuDeviceResource);
                            String modelName = Optional.ofNullable(Optional.ofNullable(new_modelName).orElse(old_modelName)).orElse(null);
                            // if(!Objects.equals(old_modelName, modelName))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_modelName, patch), modelName);
                            String gpuDeviceUtilization = Optional.ofNullable(Optional.ofNullable(new_gpuDeviceUtilization).orElse(old_gpuDeviceUtilization)).orElse(null);
                            // if(!Objects.equals(old_gpuDeviceUtilization, gpuDeviceUtilization))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_gpuDeviceUtilization, patch), gpuDeviceUtilization);
                            String description = Optional.ofNullable(Optional.ofNullable(new_description).orElse(old_description)).orElse(null);
                            // if(!Objects.equals(old_description, description))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_description, patch), description);
                            JsonObject location = Optional.ofNullable(Optional.ofNullable(new_location).orElse(old_location)).orElse(null);
                            // if(!Objects.equals(old_location, location))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_location, patch), location);
                            String id = Optional.ofNullable(Optional.ofNullable(new_id).orElse(old_id)).orElse(null);
                            // if(!Objects.equals(old_id, id))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_id, patch), id);
                            String ngsildTenant = Optional.ofNullable(Optional.ofNullable(new_ngsildTenant).orElse(old_ngsildTenant)).orElse(null);
                            // if(!Objects.equals(old_ngsildTenant, ngsildTenant))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_ngsildTenant, patch), ngsildTenant);
                            String ngsildPath = Optional.ofNullable(Optional.ofNullable(new_ngsildPath).orElse(old_ngsildPath)).orElse(null);
                            // if(!Objects.equals(old_ngsildPath, ngsildPath))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_ngsildPath, patch), ngsildPath);
                            String ngsildContext = Optional.ofNullable(Optional.ofNullable(new_ngsildContext).orElse(old_ngsildContext)).orElse(null);
                            // if(!Objects.equals(old_ngsildContext, ngsildContext))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_ngsildContext, patch), ngsildContext);
                            JsonObject ngsildData = Optional.ofNullable(Optional.ofNullable(new_ngsildData).orElse(old_ngsildData)).orElse(null);
                            // if(!Objects.equals(old_ngsildData, ngsildData))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_ngsildData, patch), ngsildData);
                            String created = Optional.ofNullable(Optional.ofNullable(new_created).orElse(old_created)).orElse(null);
                            // if(!Objects.equals(old_created, created))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_created, patch), created);
                            Boolean archived = Optional.ofNullable(Optional.ofNullable(new_archived).orElse(old_archived)).orElse(null);
                            // if(!Objects.equals(old_archived, archived))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_archived, patch), archived);
                            String sessionId = Optional.ofNullable(Optional.ofNullable(new_sessionId).orElse(old_sessionId)).orElse(null);
                            // if(!Objects.equals(old_sessionId, sessionId))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_sessionId, patch), sessionId);
                            String userKey = Optional.ofNullable(Optional.ofNullable(new_userKey).orElse(old_userKey)).orElse(null);
                            // if(!Objects.equals(old_userKey, userKey))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_userKey, patch), userKey);
                            String objectTitle = Optional.ofNullable(Optional.ofNullable(new_objectTitle).orElse(old_objectTitle)).orElse(null);
                            // if(!Objects.equals(old_objectTitle, objectTitle))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_objectTitle, patch), objectTitle);
                            String apiUrl = Optional.ofNullable(Optional.ofNullable(new_apiUrl).orElse(old_apiUrl)).orElse(null);
                            // if(!Objects.equals(old_apiUrl, apiUrl))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_apiUrl, patch), apiUrl);
                            String displayPage = Optional.ofNullable(Optional.ofNullable(new_displayPage).orElse(old_displayPage)).orElse(null);
                            // if(!Objects.equals(old_displayPage, displayPage))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_displayPage, patch), displayPage);
                            String editPage = Optional.ofNullable(Optional.ofNullable(new_editPage).orElse(old_editPage)).orElse(null);
                            // if(!Objects.equals(old_editPage, editPage))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_editPage, patch), editPage);
                            String userPage = Optional.ofNullable(Optional.ofNullable(new_userPage).orElse(old_userPage)).orElse(null);
                            // if(!Objects.equals(old_userPage, userPage))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_userPage, patch), userPage);
                            String download = Optional.ofNullable(Optional.ofNullable(new_download).orElse(old_download)).orElse(null);
                            // if(!Objects.equals(old_download, download))
                              // json.put(GpuDevice.varJson(GpuDevice.VAR_download, patch), download);

                            promise.complete(json);
                          }
                        } catch(Exception ex) {
                          LOG.error(String.format("upsertGpuDevice failed. "), ex);
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
                LOG.error(String.format("upsertGpuDevice failed. "), ex);
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
      LOG.error(String.format("upsertGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> persistGpuDevice(GpuDevice o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Long pk = o.getPk();
      sqlConnection.preparedQuery("SELECT hubId, hubResource, clusterName, clusterResource, nodeName, nodeResource, gpuDeviceNumber, gpuDeviceResource, modelName, gpuDeviceUtilization, description, location, id, ngsildTenant, ngsildPath, ngsildContext, ngsildData, created, archived, sessionId, userKey, objectTitle, apiUrl, displayPage, editPage, userPage, download FROM GpuDevice WHERE pk=$1")
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
                  LOG.error(String.format("persistGpuDevice failed. "), e);
                }
              }
            }
          }
          o.promiseDeepForClass(siteRequest).onSuccess(a -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("persistGpuDevice failed. "), ex);
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("persistGpuDevice failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error(String.format("persistGpuDevice failed. "), ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("persistGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> relateGpuDevice(GpuDevice o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      sqlConnection.preparedQuery("SELECT hubResource as pk2, 'hubResource' FROM Hub WHERE hubResource=$1 UNION SELECT clusterResource as pk2, 'clusterResource' FROM Cluster WHERE clusterResource=$2 UNION SELECT nodeResource as pk2, 'nodeResource' FROM AiNode WHERE nodeResource=$3")
          .collecting(Collectors.toList())
          .execute(Tuple.of(o.getHubResource(), o.getClusterResource(), o.getNodeResource())
          ).onSuccess(result -> {
        try {
          if(result != null) {
            for(Row definition : result.value()) {
              o.relateForClass(definition.getString(1), definition.getValue(0));
            }
          }
          promise.complete();
        } catch(Exception ex) {
          LOG.error(String.format("relateGpuDevice failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error(String.format("relateGpuDevice failed. "), ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("relateGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public String searchVar(String varIndexed) {
    return GpuDevice.searchVarGpuDevice(varIndexed);
  }

  @Override
  public String getClassApiAddress() {
    return GpuDevice.CLASS_API_ADDRESS_GpuDevice;
  }

  public Future<GpuDevice> indexGpuDevice(GpuDevice o) {
    Promise<GpuDevice> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      JsonObject json = new JsonObject();
      JsonObject add = new JsonObject();
      json.put("add", add);
      JsonObject doc = new JsonObject();
      add.put("doc", doc);
      o.indexGpuDevice(doc);
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
        LOG.error(String.format("indexGpuDevice failed. "), new RuntimeException(ex));
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("indexGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<GpuDevice> unindexGpuDevice(GpuDevice o) {
    Promise<GpuDevice> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      o.promiseDeepForClass(siteRequest).onSuccess(a -> {
        JsonObject json = new JsonObject();
        JsonObject delete = new JsonObject();
        json.put("delete", delete);
        String query = String.format("filter(%s:%s)", GpuDevice.VAR_solrId, o.obtainForClass(GpuDevice.VAR_solrId));
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
          LOG.error(String.format("unindexGpuDevice failed. "), new RuntimeException(ex));
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("unindexGpuDevice failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("unindexGpuDevice failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> refreshGpuDevice(GpuDevice o) {
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

          if("AiNode".equals(classSimpleName2) && solrId2 != null) {
            SearchList<AiNode> searchList2 = new SearchList<AiNode>();
            searchList2.setStore(true);
            searchList2.q("*:*");
            searchList2.setC(AiNode.class);
            searchList2.fq("solrId:" + solrId2);
            searchList2.rows(1L);
            futures.add(Future.future(promise2 -> {
              searchList2.promiseDeepSearchList(siteRequest).onSuccess(b -> {
                AiNode o2 = searchList2.getList().stream().findFirst().orElse(null);
                if(o2 != null) {
                  JsonObject params = new JsonObject();
                  params.put("body", new JsonObject());
                  params.put("scopes", siteRequest.getScopes());
                  params.put("cookie", new JsonObject());
                  params.put("path", new JsonObject());
                  params.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("solrId:" + solrId2)).put("var", new JsonArray().add("refresh:false")));
                  JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
                  JsonObject json = new JsonObject().put("context", context);
                  eventBus.request("ai-telemetry-enUS-AiNode", json, new DeliveryOptions().addHeader("action", "patchAiNodeFuture")).onSuccess(c -> {
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
          eventBus.request(GpuDevice.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "patchGpuDeviceFuture")).onSuccess(c -> {
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
      LOG.error(String.format("refreshGpuDevice failed. "), ex);
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
      GpuDevice o = new GpuDevice();
      o.setSiteRequest_((SiteRequest)siteRequest);

      o.persistForClass(GpuDevice.VAR_hubId, GpuDevice.staticSetHubId(siteRequest2, (String)result.get(GpuDevice.VAR_hubId)));
      o.persistForClass(GpuDevice.VAR_hubResource, GpuDevice.staticSetHubResource(siteRequest2, (String)result.get(GpuDevice.VAR_hubResource)));
      o.persistForClass(GpuDevice.VAR_clusterName, GpuDevice.staticSetClusterName(siteRequest2, (String)result.get(GpuDevice.VAR_clusterName)));
      o.persistForClass(GpuDevice.VAR_clusterResource, GpuDevice.staticSetClusterResource(siteRequest2, (String)result.get(GpuDevice.VAR_clusterResource)));
      o.persistForClass(GpuDevice.VAR_nodeName, GpuDevice.staticSetNodeName(siteRequest2, (String)result.get(GpuDevice.VAR_nodeName)));
      o.persistForClass(GpuDevice.VAR_nodeResource, GpuDevice.staticSetNodeResource(siteRequest2, (String)result.get(GpuDevice.VAR_nodeResource)));
      o.persistForClass(GpuDevice.VAR_gpuDeviceNumber, GpuDevice.staticSetGpuDeviceNumber(siteRequest2, (String)result.get(GpuDevice.VAR_gpuDeviceNumber)));
      o.persistForClass(GpuDevice.VAR_gpuDeviceResource, GpuDevice.staticSetGpuDeviceResource(siteRequest2, (String)result.get(GpuDevice.VAR_gpuDeviceResource)));
      o.persistForClass(GpuDevice.VAR_modelName, GpuDevice.staticSetModelName(siteRequest2, (String)result.get(GpuDevice.VAR_modelName)));
      o.persistForClass(GpuDevice.VAR_gpuDeviceUtilization, GpuDevice.staticSetGpuDeviceUtilization(siteRequest2, (String)result.get(GpuDevice.VAR_gpuDeviceUtilization)));
      o.persistForClass(GpuDevice.VAR_description, GpuDevice.staticSetDescription(siteRequest2, (String)result.get(GpuDevice.VAR_description)));
      o.persistForClass(GpuDevice.VAR_location, GpuDevice.staticSetLocation(siteRequest2, (String)result.get(GpuDevice.VAR_location)));
      o.persistForClass(GpuDevice.VAR_id, GpuDevice.staticSetId(siteRequest2, (String)result.get(GpuDevice.VAR_id)));
      o.persistForClass(GpuDevice.VAR_ngsildTenant, GpuDevice.staticSetNgsildTenant(siteRequest2, (String)result.get(GpuDevice.VAR_ngsildTenant)));
      o.persistForClass(GpuDevice.VAR_ngsildPath, GpuDevice.staticSetNgsildPath(siteRequest2, (String)result.get(GpuDevice.VAR_ngsildPath)));
      o.persistForClass(GpuDevice.VAR_ngsildContext, GpuDevice.staticSetNgsildContext(siteRequest2, (String)result.get(GpuDevice.VAR_ngsildContext)));
      o.persistForClass(GpuDevice.VAR_ngsildData, GpuDevice.staticSetNgsildData(siteRequest2, (String)result.get(GpuDevice.VAR_ngsildData)));
      o.persistForClass(GpuDevice.VAR_created, GpuDevice.staticSetCreated(siteRequest2, (String)result.get(GpuDevice.VAR_created), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(GpuDevice.VAR_archived, GpuDevice.staticSetArchived(siteRequest2, (String)result.get(GpuDevice.VAR_archived)));
      o.persistForClass(GpuDevice.VAR_sessionId, GpuDevice.staticSetSessionId(siteRequest2, (String)result.get(GpuDevice.VAR_sessionId)));
      o.persistForClass(GpuDevice.VAR_userKey, GpuDevice.staticSetUserKey(siteRequest2, (String)result.get(GpuDevice.VAR_userKey)));
      o.persistForClass(GpuDevice.VAR_objectTitle, GpuDevice.staticSetObjectTitle(siteRequest2, (String)result.get(GpuDevice.VAR_objectTitle)));
      o.persistForClass(GpuDevice.VAR_apiUrl, GpuDevice.staticSetApiUrl(siteRequest2, (String)result.get(GpuDevice.VAR_apiUrl)));
      o.persistForClass(GpuDevice.VAR_displayPage, GpuDevice.staticSetDisplayPage(siteRequest2, (String)result.get(GpuDevice.VAR_displayPage)));
      o.persistForClass(GpuDevice.VAR_editPage, GpuDevice.staticSetEditPage(siteRequest2, (String)result.get(GpuDevice.VAR_editPage)));
      o.persistForClass(GpuDevice.VAR_userPage, GpuDevice.staticSetUserPage(siteRequest2, (String)result.get(GpuDevice.VAR_userPage)));
      o.persistForClass(GpuDevice.VAR_download, GpuDevice.staticSetDownload(siteRequest2, (String)result.get(GpuDevice.VAR_download)));

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

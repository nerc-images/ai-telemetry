package org.computate.aitelemetry.model;

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
import org.computate.aitelemetry.model.MapModelPage;


/**
 * Translate: false
 * Generated: true
 **/
public class MapModelEnUSGenApiServiceImpl extends BaseApiServiceImpl implements MapModelEnUSGenApiService {

  protected static final Logger LOG = LoggerFactory.getLogger(MapModelEnUSGenApiServiceImpl.class);

  // Search //

  @Override
  public void searchMapModel(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        MapModel.authorizationMapModel(siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          MapModel.authorizationScopesMapModel(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "Search", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchMapModelList(siteRequest2, false, true, false, "GET").onSuccess(listMapModel -> {
              response200SearchMapModel(listMapModel).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchMapModel succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchMapModel failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchMapModel failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchMapModel failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchMapModel failed. ", ex2));
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
        LOG.error(String.format("searchMapModel failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200SearchMapModel(SearchList<MapModel> listMapModel) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listMapModel.getSiteRequest_(SiteRequest.class);
      List<String> fls = listMapModel.getRequest().getFields();
      JsonObject json = new JsonObject();
      JsonArray l = new JsonArray();
      List<String> scopes = siteRequest.getScopes();
      listMapModel.getList().stream().forEach(o -> {
        JsonObject json2 = JsonObject.mapFrom(o);
        if(fls.size() > 0) {
          Set<String> fieldNames = new HashSet<String>();
          for(String fieldName : json2.fieldNames()) {
            String v = MapModel.varIndexedMapModel(fieldName);
            if(v != null)
              fieldNames.add(MapModel.varIndexedMapModel(fieldName));
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
      response200Search(listMapModel.getRequest(), listMapModel.getResponse(), json);
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchMapModel failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchMapModel(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchMapModel(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // GET //

  @Override
  public void getMapModel(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        MapModel.authorizationMapModel(siteRequest, webClient, classPublicRead, "GET", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          MapModel.authorizationScopesMapModel(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "GET", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchMapModelList(siteRequest2, false, true, false, "GET").onSuccess(listMapModel -> {
              response200GETMapModel(listMapModel).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("getMapModel succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("getMapModel failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("getMapModel failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("getMapModel failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("getMapModel failed. ", ex2));
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
        LOG.error(String.format("getMapModel failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200GETMapModel(SearchList<MapModel> listMapModel) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listMapModel.getSiteRequest_(SiteRequest.class);
      JsonObject json = JsonObject.mapFrom(listMapModel.getList().stream().findFirst().orElse(null));
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200GETMapModel failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // SearchPage //

  @Override
  public void searchpageMapModel(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        MapModel.authorizationMapModel(siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(authorizationDecisionResponse -> {
          MapModel.authorizationScopesMapModel(authorizationDecisionResponse, siteRequest, webClient, classPublicRead, "SearchPage", "GET", "GET").onSuccess(siteRequest2 -> {
            List<String> scopes2 = siteRequest2.getScopes();
            searchMapModelList(siteRequest2, false, true, false, "GET").onSuccess(listMapModel -> {
              response200SearchPageMapModel(listMapModel).onSuccess(response -> {
                eventHandler.handle(Future.succeededFuture(response));
                LOG.debug(String.format("searchpageMapModel succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("searchpageMapModel failed. "), ex);
                error(siteRequest2, eventHandler, ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("searchpageMapModel failed. "), ex);
              error(siteRequest2, eventHandler, ex);
            });
          }).onFailure(ex -> {
            error(null, eventHandler, ex);
          });
        }).onFailure(ex -> {
          error(null, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchpageMapModel failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageMapModel failed. ", ex2));
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
        LOG.error(String.format("searchpageMapModel failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void searchpageMapModelPageInit(JsonObject ctx, MapModelPage page, SearchList<MapModel> listMapModel, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/map-model"));
    ctx.put("enUSUrlPage", String.format("%s%s", siteBaseUrl, "/en-us/search/map-model"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriSearchPageMapModel(ServiceRequest serviceRequest, MapModel result) {
    return "en-us/search/map-model/MapModelSearchPage.htm";
  }
  public void templateSearchPageMapModel(JsonObject ctx, MapModelPage page, SearchList<MapModel> listMapModel, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listMapModel.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      MapModel result = listMapModel.first();
      String pageTemplateUri = templateUriSearchPageMapModel(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/search/map-model/MapModelSearchPage.htm"), Charset.forName("UTF-8"));
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
        String pageExtends = Optional.ofNullable((String)data.get("extends")).orElse("en-us/Article.htm");
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
      LOG.error(String.format("templateSearchPageMapModel failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200SearchPageMapModel(SearchList<MapModel> listMapModel) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listMapModel.getSiteRequest_(SiteRequest.class);
      MapModelPage page = new MapModelPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listMapModel.size() >= 1)
        siteRequest.setRequestPk(listMapModel.get(0).getPk());
      page.setSearchListMapModel_(listMapModel);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepMapModelPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          searchpageMapModelPageInit(ctx, page, listMapModel, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateSearchPageMapModel(ctx, page, listMapModel, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200SearchPageMapModel failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200SearchPageMapModel failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200SearchPageMapModel failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchPageMapModel failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchPageMapModel(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchPageMapModel(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // General //

  public void searchMapModelQ(SearchList<MapModel> searchList, String entityVar, String valueIndexed, String varIndexed) {
    searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
    if(!"*".equals(entityVar)) {
    }
  }

  public String searchMapModelFq(SearchList<MapModel> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    if(StringUtils.startsWith(valueIndexed, "[")) {
      String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
      if(fqs.length != 2)
        throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
      String fq1 = fqs[0].equals("*") ? fqs[0] : MapModel.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
      String fq2 = fqs[1].equals("*") ? fqs[1] : MapModel.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
       return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
    } else {
      return varIndexed + ":" + SearchTool.escapeQueryChars(MapModel.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
    }
  }

  public void searchMapModelSort(SearchList<MapModel> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    searchList.sort(varIndexed, valueIndexed);
  }

  public void searchMapModelRows(SearchList<MapModel> searchList, Long valueRows) {
      searchList.rows(valueRows != null ? valueRows : 10L);
  }

  public void searchMapModelStart(SearchList<MapModel> searchList, Long valueStart) {
    searchList.start(valueStart);
  }

  public void searchMapModelVar(SearchList<MapModel> searchList, String var, String value) {
    searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
  }

  public void searchMapModelUri(SearchList<MapModel> searchList) {
  }

  public Future<ServiceResponse> varsMapModel(SiteRequest siteRequest) {
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
          LOG.error(String.format("searchMapModel failed. "), ex);
          promise.tryFail(ex);
        }
      });
      promise.complete();
    } catch(Exception ex) {
      LOG.error(String.format("searchMapModel failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SearchList<MapModel>> searchMapModelList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, String scope) {
    Promise<SearchList<MapModel>> promise = Promise.promise();
    try {
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
      String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
      SearchList<MapModel> searchList = new SearchList<MapModel>();
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
      searchList.setC(MapModel.class);
      searchList.setSiteRequest_(siteRequest);
      searchList.facetMinCount(1);
      if(entityList != null) {
        for(String v : entityList) {
          searchList.fl(MapModel.varIndexedMapModel(v));
        }
      }

      String entityShortId = serviceRequest.getParams().getJsonObject("path").getString("entityShortId");
      if(entityShortId != null) {
        searchList.fq("entityShortId_docvalues_string:" + SearchTool.escapeQueryChars(entityShortId));
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
                varsIndexed[i] = MapModel.varIndexedMapModel(entityVar);
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
                  varIndexed = MapModel.varIndexedMapModel(entityVar);
                  String entityQ = searchMapModelFq(searchList, entityVar, valueIndexed, varIndexed);
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
                  varIndexed = MapModel.varIndexedMapModel(entityVar);
                  String entityFq = searchMapModelFq(searchList, entityVar, valueIndexed, varIndexed);
                  mFq.appendReplacement(sb, entityFq);
                }
                if(!sb.isEmpty()) {
                  mFq.appendTail(sb);
                  searchList.fq(sb.toString());
                }
              } else if(paramName.equals("sort")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
                valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
                varIndexed = MapModel.varIndexedMapModel(entityVar);
                searchMapModelSort(searchList, entityVar, valueIndexed, varIndexed);
              } else if(paramName.equals("start")) {
                valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchMapModelStart(searchList, valueStart);
              } else if(paramName.equals("rows")) {
                valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchMapModelRows(searchList, valueRows);
              } else if(paramName.equals("stats")) {
                searchList.stats((Boolean)paramObject);
              } else if(paramName.equals("stats.field")) {
                Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mStats.find()) {
                  String solrLocalParams = mStats.group(1);
                  entityVar = mStats.group(2).trim();
                  varIndexed = MapModel.varIndexedMapModel(entityVar);
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
                  varIndexed = MapModel.varIndexedMapModel(entityVar);
                  searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  facetRange = entityVar;
                }
              } else if(paramName.equals("facet.field")) {
                entityVar = (String)paramObject;
                varIndexed = MapModel.varIndexedMapModel(entityVar);
                if(varIndexed != null)
                  searchList.facetField(varIndexed);
              } else if(paramName.equals("var")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
                valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
                searchMapModelVar(searchList, entityVar, valueIndexed);
              } else if(paramName.equals("cursorMark")) {
                valueCursorMark = (String)paramObject;
                searchList.cursorMark((String)paramObject);
              }
            }
            searchMapModelUri(searchList);
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
      searchMapModel2(siteRequest, populate, store, modify, searchList);
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
            LOG.error(String.format("searchMapModel failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete(searchList);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("searchMapModel failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("searchMapModel failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void searchMapModel2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<MapModel> searchList) {
  }

  public Future<JsonObject> upsertMapModel(MapModel o, Boolean inheritPrimaryKey, Boolean patch) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
        promise.complete();
      } else {
        JsonObject json = o.getSiteRequest_().getJsonObject();

        String old_name = MapModel.staticJsonName(o.getName());
        String new_name = json.getString(MapModel.varJson(MapModel.VAR_name, patch));

        String old_description = MapModel.staticJsonDescription(o.getDescription());
        String new_description = json.getString(MapModel.varJson(MapModel.VAR_description, patch));

        JsonObject old_location = MapModel.staticJsonLocation(o.getLocation());
        JsonObject new_location = json.getJsonObject(MapModel.varJson(MapModel.VAR_location, patch));

        String old_id = MapModel.staticJsonId(o.getId());
        String new_id = json.getString(MapModel.varJson(MapModel.VAR_id, patch));

        String old_entityShortId = MapModel.staticJsonEntityShortId(o.getEntityShortId());
        String new_entityShortId = json.getString(MapModel.varJson(MapModel.VAR_entityShortId, patch));

        String old_ngsildTenant = MapModel.staticJsonNgsildTenant(o.getNgsildTenant());
        String new_ngsildTenant = json.getString(MapModel.varJson(MapModel.VAR_ngsildTenant, patch));

        String old_ngsildPath = MapModel.staticJsonNgsildPath(o.getNgsildPath());
        String new_ngsildPath = json.getString(MapModel.varJson(MapModel.VAR_ngsildPath, patch));

        String old_ngsildContext = MapModel.staticJsonNgsildContext(o.getNgsildContext());
        String new_ngsildContext = json.getString(MapModel.varJson(MapModel.VAR_ngsildContext, patch));

        JsonObject old_ngsildData = MapModel.staticJsonNgsildData(o.getNgsildData());
        JsonObject new_ngsildData = json.getJsonObject(MapModel.varJson(MapModel.VAR_ngsildData, patch));

        String old_color = MapModel.staticJsonColor(o.getColor());
        String new_color = json.getString(MapModel.varJson(MapModel.VAR_color, patch));

        String old_altitude = MapModel.staticJsonAltitude(o.getAltitude());
        String new_altitude = json.getString(MapModel.varJson(MapModel.VAR_altitude, patch));

        String old_pitch = MapModel.staticJsonPitch(o.getPitch());
        String new_pitch = json.getString(MapModel.varJson(MapModel.VAR_pitch, patch));

        String old_yaw = MapModel.staticJsonYaw(o.getYaw());
        String new_yaw = json.getString(MapModel.varJson(MapModel.VAR_yaw, patch));

        String old_roll = MapModel.staticJsonRoll(o.getRoll());
        String new_roll = json.getString(MapModel.varJson(MapModel.VAR_roll, patch));

        String old_gltfPath = MapModel.staticJsonGltfPath(o.getGltfPath());
        String new_gltfPath = json.getString(MapModel.varJson(MapModel.VAR_gltfPath, patch));

        String old_created = MapModel.staticJsonCreated(o.getCreated());
        String new_created = json.getString(MapModel.varJson(MapModel.VAR_created, patch));

        Boolean old_archived = MapModel.staticJsonArchived(o.getArchived());
        Boolean new_archived = json.getBoolean(MapModel.varJson(MapModel.VAR_archived, patch));

        String old_sessionId = MapModel.staticJsonSessionId(o.getSessionId());
        String new_sessionId = json.getString(MapModel.varJson(MapModel.VAR_sessionId, patch));

        String old_userKey = MapModel.staticJsonUserKey(o.getUserKey());
        String new_userKey = json.getString(MapModel.varJson(MapModel.VAR_userKey, patch));

        String old_objectTitle = MapModel.staticJsonObjectTitle(o.getObjectTitle());
        String new_objectTitle = json.getString(MapModel.varJson(MapModel.VAR_objectTitle, patch));

        String old_apiUrl = MapModel.staticJsonApiUrl(o.getApiUrl());
        String new_apiUrl = json.getString(MapModel.varJson(MapModel.VAR_apiUrl, patch));

        String old_displayPage = MapModel.staticJsonDisplayPage(o.getDisplayPage());
        String new_displayPage = json.getString(MapModel.varJson(MapModel.VAR_displayPage, patch));

        String old_editPage = MapModel.staticJsonEditPage(o.getEditPage());
        String new_editPage = json.getString(MapModel.varJson(MapModel.VAR_editPage, patch));

        String old_userPage = MapModel.staticJsonUserPage(o.getUserPage());
        String new_userPage = json.getString(MapModel.varJson(MapModel.VAR_userPage, patch));

        String old_download = MapModel.staticJsonDownload(o.getDownload());
        String new_download = json.getString(MapModel.varJson(MapModel.VAR_download, patch));

        String name = Optional.ofNullable(Optional.ofNullable(new_name).orElse(old_name)).orElse(null);
        // if(!Objects.equals(old_name, name))
          // json.put(MapModel.varJson(MapModel.VAR_name, patch), name);
        String description = Optional.ofNullable(Optional.ofNullable(new_description).orElse(old_description)).orElse(null);
        // if(!Objects.equals(old_description, description))
          // json.put(MapModel.varJson(MapModel.VAR_description, patch), description);
        JsonObject location = Optional.ofNullable(Optional.ofNullable(new_location).orElse(old_location)).orElse(null);
        // if(!Objects.equals(old_location, location))
          // json.put(MapModel.varJson(MapModel.VAR_location, patch), location);
        String id = Optional.ofNullable(Optional.ofNullable(new_id).orElse(old_id)).orElse(null);
        // if(!Objects.equals(old_id, id))
          // json.put(MapModel.varJson(MapModel.VAR_id, patch), id);
        String entityShortId = Optional.ofNullable(Optional.ofNullable(new_entityShortId).orElse(old_entityShortId)).orElse(null);
        // if(!Objects.equals(old_entityShortId, entityShortId))
          // json.put(MapModel.varJson(MapModel.VAR_entityShortId, patch), entityShortId);
        String ngsildTenant = Optional.ofNullable(Optional.ofNullable(new_ngsildTenant).orElse(old_ngsildTenant)).orElse(null);
        // if(!Objects.equals(old_ngsildTenant, ngsildTenant))
          // json.put(MapModel.varJson(MapModel.VAR_ngsildTenant, patch), ngsildTenant);
        String ngsildPath = Optional.ofNullable(Optional.ofNullable(new_ngsildPath).orElse(old_ngsildPath)).orElse(null);
        // if(!Objects.equals(old_ngsildPath, ngsildPath))
          // json.put(MapModel.varJson(MapModel.VAR_ngsildPath, patch), ngsildPath);
        String ngsildContext = Optional.ofNullable(Optional.ofNullable(new_ngsildContext).orElse(old_ngsildContext)).orElse(null);
        // if(!Objects.equals(old_ngsildContext, ngsildContext))
          // json.put(MapModel.varJson(MapModel.VAR_ngsildContext, patch), ngsildContext);
        JsonObject ngsildData = Optional.ofNullable(Optional.ofNullable(new_ngsildData).orElse(old_ngsildData)).orElse(null);
        // if(!Objects.equals(old_ngsildData, ngsildData))
          // json.put(MapModel.varJson(MapModel.VAR_ngsildData, patch), ngsildData);
        String color = Optional.ofNullable(Optional.ofNullable(new_color).orElse(old_color)).orElse(null);
        // if(!Objects.equals(old_color, color))
          // json.put(MapModel.varJson(MapModel.VAR_color, patch), color);
        String altitude = Optional.ofNullable(Optional.ofNullable(new_altitude).orElse(old_altitude)).orElse(null);
        // if(!Objects.equals(old_altitude, altitude))
          // json.put(MapModel.varJson(MapModel.VAR_altitude, patch), altitude);
        String pitch = Optional.ofNullable(Optional.ofNullable(new_pitch).orElse(old_pitch)).orElse(null);
        // if(!Objects.equals(old_pitch, pitch))
          // json.put(MapModel.varJson(MapModel.VAR_pitch, patch), pitch);
        String yaw = Optional.ofNullable(Optional.ofNullable(new_yaw).orElse(old_yaw)).orElse(null);
        // if(!Objects.equals(old_yaw, yaw))
          // json.put(MapModel.varJson(MapModel.VAR_yaw, patch), yaw);
        String roll = Optional.ofNullable(Optional.ofNullable(new_roll).orElse(old_roll)).orElse(null);
        // if(!Objects.equals(old_roll, roll))
          // json.put(MapModel.varJson(MapModel.VAR_roll, patch), roll);
        String gltfPath = Optional.ofNullable(Optional.ofNullable(new_gltfPath).orElse(old_gltfPath)).orElse(null);
        // if(!Objects.equals(old_gltfPath, gltfPath))
          // json.put(MapModel.varJson(MapModel.VAR_gltfPath, patch), gltfPath);
        String created = Optional.ofNullable(Optional.ofNullable(new_created).orElse(old_created)).orElse(null);
        // if(!Objects.equals(old_created, created))
          // json.put(MapModel.varJson(MapModel.VAR_created, patch), created);
        Boolean archived = Optional.ofNullable(Optional.ofNullable(new_archived).orElse(old_archived)).orElse(null);
        // if(!Objects.equals(old_archived, archived))
          // json.put(MapModel.varJson(MapModel.VAR_archived, patch), archived);
        String sessionId = Optional.ofNullable(Optional.ofNullable(new_sessionId).orElse(old_sessionId)).orElse(null);
        // if(!Objects.equals(old_sessionId, sessionId))
          // json.put(MapModel.varJson(MapModel.VAR_sessionId, patch), sessionId);
        String userKey = Optional.ofNullable(Optional.ofNullable(new_userKey).orElse(old_userKey)).orElse(null);
        // if(!Objects.equals(old_userKey, userKey))
          // json.put(MapModel.varJson(MapModel.VAR_userKey, patch), userKey);
        String objectTitle = Optional.ofNullable(Optional.ofNullable(new_objectTitle).orElse(old_objectTitle)).orElse(null);
        // if(!Objects.equals(old_objectTitle, objectTitle))
          // json.put(MapModel.varJson(MapModel.VAR_objectTitle, patch), objectTitle);
        String apiUrl = Optional.ofNullable(Optional.ofNullable(new_apiUrl).orElse(old_apiUrl)).orElse(null);
        // if(!Objects.equals(old_apiUrl, apiUrl))
          // json.put(MapModel.varJson(MapModel.VAR_apiUrl, patch), apiUrl);
        String displayPage = Optional.ofNullable(Optional.ofNullable(new_displayPage).orElse(old_displayPage)).orElse(null);
        // if(!Objects.equals(old_displayPage, displayPage))
          // json.put(MapModel.varJson(MapModel.VAR_displayPage, patch), displayPage);
        String editPage = Optional.ofNullable(Optional.ofNullable(new_editPage).orElse(old_editPage)).orElse(null);
        // if(!Objects.equals(old_editPage, editPage))
          // json.put(MapModel.varJson(MapModel.VAR_editPage, patch), editPage);
        String userPage = Optional.ofNullable(Optional.ofNullable(new_userPage).orElse(old_userPage)).orElse(null);
        // if(!Objects.equals(old_userPage, userPage))
          // json.put(MapModel.varJson(MapModel.VAR_userPage, patch), userPage);
        String download = Optional.ofNullable(Optional.ofNullable(new_download).orElse(old_download)).orElse(null);
        // if(!Objects.equals(old_download, download))
          // json.put(MapModel.varJson(MapModel.VAR_download, patch), download);

        promise.complete(json);
      }
    } catch(Exception ex) {
      LOG.error(String.format("upsertMapModel failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> persistMapModel(MapModel o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Long pk = o.getPk();
      sqlConnection.preparedQuery("SELECT name, description, location, id, entityShortId, ngsildTenant, ngsildPath, ngsildContext, ngsildData, color, altitude, pitch, yaw, roll, gltfPath, created, archived, sessionId, userKey, objectTitle, apiUrl, displayPage, editPage, userPage, download FROM MapModel WHERE pk=$1")
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
                  LOG.error(String.format("persistMapModel failed. "), e);
                }
              }
            }
          }
          o.promiseDeepForClass(siteRequest).onSuccess(a -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("persistMapModel failed. "), ex);
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("persistMapModel failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error(String.format("persistMapModel failed. "), ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("persistMapModel failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> relateMapModel(MapModel o) {
    Promise<Void> promise = Promise.promise();
    promise.complete();
    return promise.future();
  }

  public String searchVar(String varIndexed) {
    return MapModel.searchVarMapModel(varIndexed);
  }

  @Override
  public String getClassApiAddress() {
    return MapModel.CLASS_API_ADDRESS_MapModel;
  }

  public Future<MapModel> indexMapModel(MapModel o) {
    Promise<MapModel> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      JsonObject json = new JsonObject();
      JsonObject add = new JsonObject();
      json.put("add", add);
      JsonObject doc = new JsonObject();
      add.put("doc", doc);
      o.indexMapModel(doc);
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
        LOG.error(String.format("indexMapModel failed. "), new RuntimeException(ex));
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("indexMapModel failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<MapModel> unindexMapModel(MapModel o) {
    Promise<MapModel> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      o.promiseDeepForClass(siteRequest).onSuccess(a -> {
        JsonObject json = new JsonObject();
        JsonObject delete = new JsonObject();
        json.put("delete", delete);
        String query = String.format("filter(%s:%s)", MapModel.VAR_solrId, o.obtainForClass(MapModel.VAR_solrId));
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
          LOG.error(String.format("unindexMapModel failed. "), new RuntimeException(ex));
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("unindexMapModel failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("unindexMapModel failed. "), ex);
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
      MapModel o = new MapModel();
      o.setSiteRequest_((SiteRequest)siteRequest);

      o.persistForClass(MapModel.VAR_name, MapModel.staticSetName(siteRequest2, (String)result.get(MapModel.VAR_name)));
      o.persistForClass(MapModel.VAR_description, MapModel.staticSetDescription(siteRequest2, (String)result.get(MapModel.VAR_description)));
      o.persistForClass(MapModel.VAR_location, MapModel.staticSetLocation(siteRequest2, (String)result.get(MapModel.VAR_location)));
      o.persistForClass(MapModel.VAR_id, MapModel.staticSetId(siteRequest2, (String)result.get(MapModel.VAR_id)));
      o.persistForClass(MapModel.VAR_entityShortId, MapModel.staticSetEntityShortId(siteRequest2, (String)result.get(MapModel.VAR_entityShortId)));
      o.persistForClass(MapModel.VAR_ngsildTenant, MapModel.staticSetNgsildTenant(siteRequest2, (String)result.get(MapModel.VAR_ngsildTenant)));
      o.persistForClass(MapModel.VAR_ngsildPath, MapModel.staticSetNgsildPath(siteRequest2, (String)result.get(MapModel.VAR_ngsildPath)));
      o.persistForClass(MapModel.VAR_ngsildContext, MapModel.staticSetNgsildContext(siteRequest2, (String)result.get(MapModel.VAR_ngsildContext)));
      o.persistForClass(MapModel.VAR_ngsildData, MapModel.staticSetNgsildData(siteRequest2, (String)result.get(MapModel.VAR_ngsildData)));
      o.persistForClass(MapModel.VAR_color, MapModel.staticSetColor(siteRequest2, (String)result.get(MapModel.VAR_color)));
      o.persistForClass(MapModel.VAR_altitude, MapModel.staticSetAltitude(siteRequest2, (String)result.get(MapModel.VAR_altitude)));
      o.persistForClass(MapModel.VAR_pitch, MapModel.staticSetPitch(siteRequest2, (String)result.get(MapModel.VAR_pitch)));
      o.persistForClass(MapModel.VAR_yaw, MapModel.staticSetYaw(siteRequest2, (String)result.get(MapModel.VAR_yaw)));
      o.persistForClass(MapModel.VAR_roll, MapModel.staticSetRoll(siteRequest2, (String)result.get(MapModel.VAR_roll)));
      o.persistForClass(MapModel.VAR_gltfPath, MapModel.staticSetGltfPath(siteRequest2, (String)result.get(MapModel.VAR_gltfPath)));
      o.persistForClass(MapModel.VAR_created, MapModel.staticSetCreated(siteRequest2, (String)result.get(MapModel.VAR_created), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(MapModel.VAR_archived, MapModel.staticSetArchived(siteRequest2, (String)result.get(MapModel.VAR_archived)));
      o.persistForClass(MapModel.VAR_sessionId, MapModel.staticSetSessionId(siteRequest2, (String)result.get(MapModel.VAR_sessionId)));
      o.persistForClass(MapModel.VAR_userKey, MapModel.staticSetUserKey(siteRequest2, (String)result.get(MapModel.VAR_userKey)));
      o.persistForClass(MapModel.VAR_objectTitle, MapModel.staticSetObjectTitle(siteRequest2, (String)result.get(MapModel.VAR_objectTitle)));
      o.persistForClass(MapModel.VAR_apiUrl, MapModel.staticSetApiUrl(siteRequest2, (String)result.get(MapModel.VAR_apiUrl)));
      o.persistForClass(MapModel.VAR_displayPage, MapModel.staticSetDisplayPage(siteRequest2, (String)result.get(MapModel.VAR_displayPage)));
      o.persistForClass(MapModel.VAR_editPage, MapModel.staticSetEditPage(siteRequest2, (String)result.get(MapModel.VAR_editPage)));
      o.persistForClass(MapModel.VAR_userPage, MapModel.staticSetUserPage(siteRequest2, (String)result.get(MapModel.VAR_userPage)));
      o.persistForClass(MapModel.VAR_download, MapModel.staticSetDownload(siteRequest2, (String)result.get(MapModel.VAR_download)));

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

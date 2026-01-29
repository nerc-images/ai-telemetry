package org.mghpcc.aitelemetry.model.developer.aitelemetry;

import org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloper;
import java.lang.Boolean;
import java.lang.String;
import java.lang.Integer;
import org.computate.vertx.search.list.SearchList;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.mghpcc.aitelemetry.page.PageLayout;
import org.mghpcc.aitelemetry.request.SiteRequest;
import org.mghpcc.aitelemetry.user.SiteUser;
import java.io.IOException;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.computate.search.wrap.Wrap;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.service.ServiceRequest;
import java.net.URLDecoder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;
import java.util.Objects;
import io.vertx.core.Promise;
import org.mghpcc.aitelemetry.config.ConfigKeys;
import org.computate.search.response.solr.SolrResponse;
import java.util.HashMap;
import org.computate.search.tool.TimeTool;
import org.computate.search.tool.SearchTool;
import java.time.ZoneId;
import io.vertx.pgclient.data.Point;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Translate: false
 * Generated: true
 **/
public class AiTelemetryDeveloperGenPage extends AiTelemetryDeveloperGenPageGen<PageLayout> {

  /**
   * {@inheritDoc}
   * Ignore: true
   **/
  protected void _searchListAiTelemetryDeveloper_(Wrap<SearchList<AiTelemetryDeveloper>> w) {
  }

  @Override
  protected void _pageResponse(Wrap<String> w) {
    if(searchListAiTelemetryDeveloper_ != null)
      w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getResponse()).map(response -> JsonObject.mapFrom(response).toString()).orElse(null));
  }

  @Override
  protected void _stats(Wrap<SolrResponse.Stats> w) {
    w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getResponse()).map(response -> response.getStats()).orElse(null));
  }

  @Override
  protected void _facetCounts(Wrap<SolrResponse.FacetCounts> w) {
    w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getResponse()).map(response -> response.getFacetCounts()).orElse(null));
  }

  @Override
  protected void _pagination(JsonObject pagination) {
    JsonArray pages = new JsonArray();
    Long start = searchListAiTelemetryDeveloper_.getStart().longValue();
    Long rows = searchListAiTelemetryDeveloper_.getRows().longValue();
    Long foundNum = Optional.ofNullable(searchListAiTelemetryDeveloper_.getResponse()).map(response -> response.getResponse().getNumFound().longValue()).orElse(Long.valueOf(searchListAiTelemetryDeveloper_.getList().size()));
    Long startNum = start + 1L;
    Long endNum = start + rows;
    Long floorMod = (rows == 0L ? 0L : Math.floorMod(foundNum, rows));
    Long last = (rows == 0L ? 0L : Math.floorDiv(foundNum, rows) - (floorMod.equals(0L) ? 1L : 0L) * rows);
    endNum = endNum < foundNum ? endNum : foundNum;
    startNum = foundNum == 0L ? 0L : startNum;
    Long paginationStart = start - 10L * rows;
    if(paginationStart < 0L)
      paginationStart = 0L;
    Long paginationEnd = start + 10L * rows;
    if(paginationEnd > foundNum)
      paginationEnd = foundNum;

    pagination.put("1L", 1L);
    pagination.put("0L", 0L);
    pagination.put("start", start);
    pagination.put("rows", rows);
    pagination.put("rowsPrevious", rows / 2);
    pagination.put("rowsNext", rows * 2);
    pagination.put("startNum", startNum);
    pagination.put("endNum", endNum);
    pagination.put("foundNum", foundNum);
    pagination.put("pageStart", new JsonObject().put("start", 0L).put("pageNumber", 1L));
    if(start > 0L)
      pagination.put("pagePrevious", new JsonObject().put("start", start - rows).put("pageNumber", start - rows + 1L));
    if(start + rows < foundNum)
      pagination.put("pageNext", new JsonObject().put("start", start + rows).put("pageNumber", start + rows + 1L));
    pagination.put("pageEnd", new JsonObject().put("start", last).put("pageNumber", last + 1L));
    pagination.put("pages", pages);
    for(Long i = paginationStart; i < paginationEnd; i += rows) {
      Long pageNumber = Math.floorDiv(i, rows) + 1L;
      JsonObject page = new JsonObject();
      page.put("pageNumber", pageNumber);
      page.put("currentPage", start.equals(i));
      page.put("start", i);
      pages.add(page);
    }
  }

  @Override
  protected void _varsQ(JsonObject vars) {
    AiTelemetryDeveloper.varsQForClass().forEach(var -> {
      JsonObject json = new JsonObject();
      json.put("var", var);
      json.put("displayName", Optional.ofNullable(AiTelemetryDeveloper.displayNameAiTelemetryDeveloper(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
      json.put("classSimpleName", Optional.ofNullable(AiTelemetryDeveloper.classSimpleNameAiTelemetryDeveloper(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
      json.put("val", Optional.ofNullable(searchListAiTelemetryDeveloper_.getRequest().getQuery()).filter(fq -> fq.startsWith(AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(var) + ":")).map(s -> SearchTool.unescapeQueryChars(StringUtils.substringAfter(s, ":"))).orElse(null));
      vars.put(var, json);
    });
  }

  @Override
  protected void _varsFqCount(Wrap<Integer> w) {
  }

  @Override
  protected void _varsFq(JsonObject vars) {
    Map<String, SolrResponse.FacetField> facetFields = Optional.ofNullable(facetCounts).map(c -> c.getFacetFields()).map(f -> f.getFacets()).orElse(new HashMap<String,SolrResponse.FacetField>());
    varsFqCount = 0;
    for(String var : AiTelemetryDeveloper.varsFqForClass()) {
      String varIndexed = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(var);
      String varStored = AiTelemetryDeveloper.varStoredAiTelemetryDeveloper(var);
      JsonObject json = new JsonObject();
      json.put("var", var);
      json.put("varStored", varStored);
      json.put("varIndexed", varIndexed);
      String type = StringUtils.substringAfterLast(varIndexed, "_");
      json.put("displayName", Optional.ofNullable(AiTelemetryDeveloper.displayNameAiTelemetryDeveloper(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
      json.put("classSimpleName", Optional.ofNullable(AiTelemetryDeveloper.classSimpleNameAiTelemetryDeveloper(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
      Object v = searchListAiTelemetryDeveloper_.getRequest().getFilterQueries().stream().filter(fq -> fq.startsWith(AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(var) + ":")).findFirst().map(s -> SearchTool.unescapeQueryChars(StringUtils.substringAfter(s, ":"))).orElse(null);
      if(v != null) {
        Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher(SearchTool.unescapeQueryChars((String)v));
        StringBuffer sb = new StringBuffer();
        while(mFq.find()) {
          String entityVar = AiTelemetryDeveloper.searchVarAiTelemetryDeveloper(varIndexed);
          String valueIndexed = mFq.group(2).trim();
          String entityFq = entityVar + ":" + valueIndexed;
          if(var.equals(entityVar))
            mFq.appendReplacement(sb, valueIndexed);
          else
            mFq.appendReplacement(sb, entityFq);
        }
        if(!sb.isEmpty()) {
          mFq.appendTail(sb);
          json.put("val", sb.toString());
        }
        varsFqCount++;
      }
      Optional.ofNullable(stats).map(s -> s.get(varIndexed)).ifPresent(stat -> {
        json.put("stats", JsonObject.mapFrom(stat));
      });
      Optional.ofNullable(facetFields.get(varIndexed)).ifPresent(facetField -> {
        JsonObject facetJson = new JsonObject();
        JsonObject counts = new JsonObject();
        facetJson.put("var", var);
        facetField.getCounts().forEach((val, count) -> {
          counts.put(val, count);
        });
        facetJson.put("counts", counts);
        json.put("facetField", facetJson);
      });
      if(defaultFieldListVars.contains(var)) {
        json.put("fieldList", true);
      }
      if(StringUtils.equalsAny(type, "date") && json.containsKey("stats")) {
        JsonObject stats = json.getJsonObject("stats");
        Instant min = Optional.ofNullable(stats.getString("min")).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
        Instant max = Optional.ofNullable(stats.getString("max")).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
        if(min.equals(max)) {
          min = min.minus(1, ChronoUnit.DAYS);
          max = max.plus(2, ChronoUnit.DAYS);
        }
        Duration duration = Duration.between(min, max);
        String gap = "DAY";
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
        json.put("defaultRangeGap", String.format("+1%s", gap));
        json.put("defaultRangeEnd", max.toString());
        json.put("defaultRangeStart", min.toString());
        json.put("enableCalendar", true);
        setDefaultRangeStats(json);
      }
      json.put("enableStats", !StringUtils.equalsAny(type, "boolean", "location"));
      if(defaultStatsVars.contains(var)) {
        SolrResponse.StatsField varStats = stats.get(varIndexed);
        if(varStats != null)
          json.put("stats", varStats);
      }
      if(defaultPivotVars.contains(var)) {
        json.put("pivot", true);
      }
      if(defaultSortVars.contains(String.format("%s asc", var))) {
        json.put("sort", "asc");
      } else if(defaultSortVars.contains(String.format("%s desc", var))) {
        json.put("sort", "desc");
      }
      vars.put(var, json);
    }
  }

  @Override
  protected void _varsRange(JsonObject vars) {
    AiTelemetryDeveloper.varsRangeForClass().forEach(var -> {
      String varIndexed = AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(var);
      JsonObject json = new JsonObject();
      json.put("var", var);
      json.put("displayName", Optional.ofNullable(AiTelemetryDeveloper.displayNameAiTelemetryDeveloper(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
      json.put("classSimpleName", Optional.ofNullable(AiTelemetryDeveloper.classSimpleNameAiTelemetryDeveloper(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
      json.put("val", searchListAiTelemetryDeveloper_.getRequest().getFilterQueries().stream().filter(fq -> fq.startsWith(AiTelemetryDeveloper.varIndexedAiTelemetryDeveloper(var) + ":")).findFirst().map(s -> SearchTool.unescapeQueryChars(StringUtils.substringAfter(s, ":"))).orElse(null));
      vars.put(var, json);
    });
  }

  @Override
  protected void _query(JsonObject query) {
    ServiceRequest serviceRequest = siteRequest_.getServiceRequest();
    JsonObject params = serviceRequest.getParams();

    JsonObject queryParams = Optional.ofNullable(serviceRequest).map(ServiceRequest::getParams).map(or -> or.getJsonObject("query")).orElse(new JsonObject());
    Long num = Optional.ofNullable(searchListAiTelemetryDeveloper_.getResponse()).map(response -> response.getResponse().getNumFound().longValue()).orElse(Long.valueOf(searchListAiTelemetryDeveloper_.getList().size()));
    String q = "*:*";
    String q1 = "objectText";
    String q2 = "";
    for(String paramName : queryParams.fieldNames()) {
      String entityVar = null;
      String valueIndexed = null;
      Object paramObjectValues = queryParams.getValue(paramName);
      JsonArray paramObjects = paramObjectValues instanceof JsonArray ? (JsonArray)paramObjectValues : new JsonArray().add(paramObjectValues);

      try {
        for(Object paramObject : paramObjects) {
          switch(paramName) {
          case "q":
            q = (String)paramObject;
            entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
            valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
            q1 = entityVar.equals("*") ? q1 : entityVar;
            q2 = valueIndexed;
            q = q1 + ":" + q2;
          }
        }
      } catch(Exception e) {
        ExceptionUtils.rethrow(e);
      }
    }
    query.put("q", q);

    Long rows1 = Optional.ofNullable(searchListAiTelemetryDeveloper_).map(l -> l.getRows()).orElse(10L);
    Long start1 = Optional.ofNullable(searchListAiTelemetryDeveloper_).map(l -> l.getStart()).orElse(1L);
    Long start2 = start1 - rows1;
    Long start3 = start1 + rows1;
    Long rows2 = rows1 / 2;
    Long rows3 = rows1 * 2;
    start2 = start2 < 0 ? 0 : start2;
    JsonObject fqs = new JsonObject();
    for(String fq : Optional.ofNullable(searchListAiTelemetryDeveloper_).map(l -> l.getFilterQueries()).orElse(Arrays.asList())) {
      if(!StringUtils.contains(fq, "(")) {
        String fq1 = AiTelemetryDeveloper.searchVarAiTelemetryDeveloper(StringUtils.substringBefore(fq, ":"));
        String fq2 = StringUtils.substringAfter(fq, ":");
        if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "sessionId", "userKeys"))
          fqs.put(fq1, new JsonObject().put("var", fq1).put("val", fq2).put("displayName", AiTelemetryDeveloper.displayNameForClass(fq1)));
        }
      }
    query.put("fq", fqs);

    JsonArray sorts = new JsonArray();
    for(String sort : Optional.ofNullable(searchListAiTelemetryDeveloper_).map(l -> l.getSorts()).orElse(Arrays.asList())) {
      String sort1 = AiTelemetryDeveloper.searchVarAiTelemetryDeveloper(StringUtils.substringBefore(sort, " "));
      sorts.add(new JsonObject().put("var", sort1).put("order", StringUtils.substringAfter(sort, " ")).put("displayName", AiTelemetryDeveloper.displayNameForClass(sort1)));
    }
    query.put("sort", sorts);
  }

  @Override
  protected void _defaultZoneId(Wrap<String> w) {
    w.o(Optional.ofNullable(siteRequest_.getRequestVars().get(VAR_defaultZoneId)).orElse(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE)));
  }

  /**
   * Ignore: true
   **/
  @Override
  protected void _defaultTimeZone(Wrap<ZoneId> w) {
    w.o(ZoneId.of(defaultZoneId));
  }

  @Override
  protected void _defaultLocaleId(Wrap<String> w) {
    w.o(Optional.ofNullable(siteRequest_.getRequestHeaders().get("Accept-Language")).map(acceptLanguage -> StringUtils.substringBefore(acceptLanguage, ",")).orElse(siteRequest_.getConfig().getString(ConfigKeys.SITE_LOCALE)));
  }

  /**
   * Ignore: true
   **/
  @Override
  protected void _defaultLocale(Wrap<Locale> w) {
    w.o(Locale.forLanguageTag(defaultLocaleId));
  }

  @Override
  protected void _rows(Wrap<Long> w) {
    if(serviceRequest.getParams().getJsonObject("query").getString("rows", null) != null)
      w.o(searchListAiTelemetryDeveloper_.getRows());
  }

  @Override
  protected void _start(Wrap<Long> w) {
    if(serviceRequest.getParams().getJsonObject("query").getString("start", null) != null)
      w.o(searchListAiTelemetryDeveloper_.getStart());
  }

  @Override
  protected void _rangeGap(Wrap<String> w) {
    if(serviceRequest.getParams().getJsonObject("query").getString("facet.range.gap", null) != null)
      w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getFacetRangeGap()).orElse(null));
  }

  @Override
  protected void _rangeEnd(Wrap<ZonedDateTime> w) {
    if(serviceRequest.getParams().getJsonObject("query").getString("facet.range.end", null) != null)
      w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getFacetRangeEnd()).map(s -> TimeTool.parseZonedDateTime(defaultTimeZone, s)).orElse(null));
  }

  @Override
  protected void _rangeStart(Wrap<ZonedDateTime> w) {
    if(serviceRequest.getParams().getJsonObject("query").getString("facet.range.start", null) != null)
      w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getFacetRangeStart()).map(s -> TimeTool.parseZonedDateTime(defaultTimeZone, s)).orElse(null));
  }

  @Override
  protected void _defaultRangeGap(Wrap<String> w) {
    w.o(Optional.ofNullable(rangeGap).orElse(Optional.ofNullable(defaultRangeStats).map(s -> s.getString("defaultRangeGap")).orElse("+1HOUR")));
  }

  @Override
  protected void _defaultRangeEnd(Wrap<ZonedDateTime> w) {
    w.o(Optional.ofNullable(rangeEnd).orElse(Optional.ofNullable(defaultRangeStats).map(s -> Instant.parse(s.getString("defaultRangeEnd")).atZone(defaultTimeZone)).orElse(ZonedDateTime.now(defaultTimeZone).toLocalDate().atStartOfDay(defaultTimeZone).plusDays(1))));
  }

  @Override
  protected void _defaultRangeStart(Wrap<ZonedDateTime> w) {
    w.o(Optional.ofNullable(rangeStart).orElse(Optional.ofNullable(defaultRangeStats).map(s -> Instant.parse(s.getString("defaultRangeStart")).atZone(defaultTimeZone)).orElse(defaultRangeEnd.minusDays(7).toLocalDate().atStartOfDay(defaultTimeZone))));
  }

  @Override
  protected void _defaultRangeVar(Wrap<String> w) {
    w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getFacetRanges()).orElse(Optional.ofNullable(defaultRangeStats).map(s -> Arrays.asList(s.getString("defaultRangeVar"))).orElse(Arrays.asList())).stream().findFirst().map(v -> { if(v.contains("}")) return StringUtils.substringBefore(StringUtils.substringAfterLast(v, "}"), "_"); else return AiTelemetryDeveloper.searchVarAiTelemetryDeveloper(v); }).orElse("created"));
  }

  @Override
  protected void _defaultFacetSort(Wrap<String> w) {
    w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getFacetSort()).orElse("index"));
  }

  @Override
  protected void _defaultFacetLimit(Wrap<Integer> w) {
    w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getFacetLimit()).orElse(1));
  }

  @Override
  protected void _defaultFacetMinCount(Wrap<Integer> w) {
    w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getFacetMinCount()).orElse(1));
  }

  @Override
  protected void _defaultPivotMinCount(Wrap<Integer> w) {
    w.o(Optional.ofNullable(searchListAiTelemetryDeveloper_.getFacetPivotMinCount()).orElse(0));
  }

  @Override
  protected void _DEFAULT_MAP_LOCATION(Wrap<JsonObject> w) {
  }

  @Override
  protected void _DEFAULT_MAP_ZOOM(Wrap<BigDecimal> w) {
    String s = Optional.ofNullable(siteRequest_.getRequestVars().get(VAR_DEFAULT_MAP_ZOOM)).orElse(siteRequest_.getConfig().getString(ConfigKeys.DEFAULT_MAP_ZOOM));
    if(s != null)
      w.o(new BigDecimal(s));
  }

  @Override
  protected void _defaultSortVars(List<String> l) {
    if(!searchListAiTelemetryDeveloper_.getDefaultSort()) {
      Optional.ofNullable(searchListAiTelemetryDeveloper_.getSorts()).orElse(Arrays.asList()).forEach(varSortStr -> {
        String varSortParts[] = varSortStr.split(" ");
        String varSort = AiTelemetryDeveloper.searchVarAiTelemetryDeveloper(varSortParts[0]);
        String varSortDirection = varSortParts[1];
        l.add(String.format("%s %s", varSort, varSortDirection));
      });
    }
  }

  @Override
  protected void _defaultFieldListVars(List<String> l) {
    Optional.ofNullable(searchListAiTelemetryDeveloper_.getFields()).orElse(Arrays.asList()).forEach(varStored -> {
      String varStored2 = varStored;
      if(StringUtils.contains(varStored2, "}"))
        varStored2 = StringUtils.substringAfterLast(varStored2, "}");
      String[] parts = varStored2.split(",");
      for(String part : parts) {
        if(StringUtils.isNotBlank(part)) {
          String var = AiTelemetryDeveloper.searchVarAiTelemetryDeveloper(part);
          if(StringUtils.isNotBlank(var))
            l.add(var);
        }
      }
    });
  }

  @Override
  protected void _defaultStatsVars(List<String> l) {
    Optional.ofNullable(searchListAiTelemetryDeveloper_.getStatsFields()).orElse(Arrays.asList()).forEach(varIndexed -> {
      String varIndexed2 = varIndexed;
      if(StringUtils.contains(varIndexed2, "}"))
        varIndexed2 = StringUtils.substringAfterLast(varIndexed2, "}");
      String[] parts = varIndexed2.split(",");
      for(String part : parts) {
        if(StringUtils.isNotBlank(part)) {
          String var = AiTelemetryDeveloper.searchVarAiTelemetryDeveloper(part);
          if(StringUtils.isNotBlank(var))
            l.add(var);
        }
      }
    });
  }

  @Override
  protected void _defaultPivotVars(List<String> l) {
    Optional.ofNullable(searchListAiTelemetryDeveloper_.getFacetPivots()).orElse(Arrays.asList()).forEach(facetPivot -> {
      String facetPivot2 = facetPivot;
      if(StringUtils.contains(facetPivot2, "}"))
        facetPivot2 = StringUtils.substringAfterLast(facetPivot2, "}");
      String[] parts = facetPivot2.split(",");
      for(String part : parts) {
        if(StringUtils.isNotBlank(part)) {
          String var = AiTelemetryDeveloper.searchVarAiTelemetryDeveloper(part);
          if(StringUtils.isNotBlank(var))
            l.add(var);
        }
      }
    });
  }

  /**
   * {@inheritDoc}
   **/
  protected void _listAiTelemetryDeveloper(JsonArray l) {
    Optional.ofNullable(searchListAiTelemetryDeveloper_).map(o -> o.getList()).orElse(Arrays.asList()).stream().map(o -> JsonObject.mapFrom(o)).forEach(o -> l.add(o));
  }

  protected void _resultCount(Wrap<Integer> w) {
    w.o(searchListAiTelemetryDeveloper_ == null ? 0 : searchListAiTelemetryDeveloper_.size());
  }

  /**
   * Initialized: false
  **/
  protected void _result(Wrap<AiTelemetryDeveloper> w) {
    if(resultCount >= 1 && Optional.ofNullable(siteRequest_.getServiceRequest().getParams().getJsonObject("path")).map(o -> o.getString("pageId")).orElse(null) != null)
      w.o(searchListAiTelemetryDeveloper_.get(0));
  }

  protected void _solrId(Wrap<String> w) {
    if(result != null)
      w.o(result.getSolrId());
  }

  @Override
  protected void _promiseBefore(Promise<Void> promise) {
    promise.complete();
  }

  @Override
  protected void _classSimpleName(Wrap<String> w) {
    w.o("AiTelemetryDeveloper");
  }

  @Override
  protected void _pageTitle(Wrap<String> c) {
    if(result != null && result.getObjectTitle() != null)
      c.o(result.getObjectTitle());
    else if(result != null)
      c.o("AI Telemetry developers");
    else if(searchListAiTelemetryDeveloper_ == null || resultCount == 0)
      c.o("no AI Telemetry developer found");
    else
      c.o("AI Telemetry developers");
  }

  @Override
  protected void _pageUri(Wrap<String> w) {
    if("enUS".equals(lang))
      w.o("/en-us/search/ai-telemetry-developer");
  }

  @Override
  protected void _apiUri(Wrap<String> w) {
    w.o("/en-us/api/ai-telemetry-developer");
  }

  @Override
  protected void _promiseAfter(Promise<Void> promise) {
    promise.complete();
  }

  @Override
  protected void _pageDescription(Wrap<String> c) {
      c.o("Learn how to become an AI Telemetry platform developer — Providing access control to observability metrics for cloud environments, ACM hubs, OpenShift Clusters, virtual machines, bare metal hardware, and cloud projects. ");
  }

  @Override
  protected void _pageImageUri(Wrap<String> c) {
      c.o("/png/en-us/search/ai-telemetry-developer-999.png");
  }

  @Override
  protected void _classIcon(Wrap<String> c) {
      c.o("<i class=\"fa-duotone fa-regular fa-chart-fft\"></i>");
  }

  protected void _pageUriAiTelemetryDeveloper(Wrap<String> c) {
      c.o("/en-us/search/ai-telemetry-developer");
  }
}

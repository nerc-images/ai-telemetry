package org.mghpcc.aitelemetry.model.developer.aitelemetry;

import org.mghpcc.aitelemetry.request.SiteRequest;
import org.mghpcc.aitelemetry.page.PageLayout;
import org.mghpcc.aitelemetry.model.BaseModel;
import org.computate.vertx.api.ApiRequest;
import org.mghpcc.aitelemetry.config.ConfigKeys;
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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
import org.computate.vertx.search.list.SearchList;
import org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloper;
import java.lang.String;
import org.computate.search.response.solr.SolrResponse.Stats;
import org.computate.search.response.solr.SolrResponse.FacetCounts;
import io.vertx.core.json.JsonObject;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import java.lang.Integer;
import java.time.ZoneId;
import java.util.Locale;
import java.lang.Long;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.math.BigDecimal;
import io.vertx.core.json.JsonArray;
import org.computate.vertx.serialize.vertx.JsonArrayDeserializer;
import java.lang.Void;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these AiTelemetryDeveloperGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class AiTelemetryDeveloperGenPageGen into the class AiTelemetryDeveloperGenPage. 
 * </li>
 * <h3>About the AiTelemetryDeveloperGenPage class and it's generated class AiTelemetryDeveloperGenPageGen&lt;PageLayout&gt;: </h3>extends AiTelemetryDeveloperGenPageGen
 * <p>
 * This Java class extends a generated Java class AiTelemetryDeveloperGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperGenPage">Find the class AiTelemetryDeveloperGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends AiTelemetryDeveloperGenPageGen<PageLayout>
 * <p>This <code>class AiTelemetryDeveloperGenPage extends AiTelemetryDeveloperGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated AiTelemetryDeveloperGenPageGen. 
 * The generated <code>class AiTelemetryDeveloperGenPageGen extends PageLayout</code> which means that AiTelemetryDeveloperGenPage extends AiTelemetryDeveloperGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the AiTelemetryDeveloperGenPage class will inherit the helpful inherited class comments from the super class AiTelemetryDeveloperGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the AiTelemetryDeveloperGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
 * </p>
 * <p>
 *   Adding protected void methods beginning with an underscore with a Promise as the only parameter will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   <pre>
 *   
 *   	protected void _promiseBefore(Promise&lt;Void&gt; promise) {
 *   		promise.complete();
 *   	}
 *   </pre>
 * </p>
 * <p>
 *   Java classes with the `Model: true` will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   If a super class of this Java class with `Model: true`, then the child class will also inherit `Promise: true`. 
 * </p>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class AiTelemetryDeveloperGenPage in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.mghpcc.aitelemetry.model.developer.aitelemetry in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.mghpcc.aitelemetry.model.developer.aitelemetry&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project ai-telemetry in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:ai\-telemetry&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class AiTelemetryDeveloperGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(AiTelemetryDeveloperGenPage.class);

	/////////////////////////////////////
  // searchListAiTelemetryDeveloper_ //
	/////////////////////////////////////


  /**
   *  The entity searchListAiTelemetryDeveloper_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<AiTelemetryDeveloper> searchListAiTelemetryDeveloper_;

  /**
   * <br> The entity searchListAiTelemetryDeveloper_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperGenPage&fq=entiteVar_enUS_indexed_string:searchListAiTelemetryDeveloper_">Find the entity searchListAiTelemetryDeveloper_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListAiTelemetryDeveloper_(Wrap<SearchList<AiTelemetryDeveloper>> w);

  public SearchList<AiTelemetryDeveloper> getSearchListAiTelemetryDeveloper_() {
    return searchListAiTelemetryDeveloper_;
  }

  public void setSearchListAiTelemetryDeveloper_(SearchList<AiTelemetryDeveloper> searchListAiTelemetryDeveloper_) {
    this.searchListAiTelemetryDeveloper_ = searchListAiTelemetryDeveloper_;
  }
  public static SearchList<AiTelemetryDeveloper> staticSetSearchListAiTelemetryDeveloper_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected AiTelemetryDeveloperGenPage searchListAiTelemetryDeveloper_Init() {
    Wrap<SearchList<AiTelemetryDeveloper>> searchListAiTelemetryDeveloper_Wrap = new Wrap<SearchList<AiTelemetryDeveloper>>().var("searchListAiTelemetryDeveloper_");
    if(searchListAiTelemetryDeveloper_ == null) {
      _searchListAiTelemetryDeveloper_(searchListAiTelemetryDeveloper_Wrap);
      Optional.ofNullable(searchListAiTelemetryDeveloper_Wrap.getO()).ifPresent(o -> {
        setSearchListAiTelemetryDeveloper_(o);
      });
    }
    return (AiTelemetryDeveloperGenPage)this;
  }

	//////////////////////////////
  // listAiTelemetryDeveloper //
	//////////////////////////////


  /**
   *  The entity listAiTelemetryDeveloper
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listAiTelemetryDeveloper = new JsonArray();

  /**
   * <br> The entity listAiTelemetryDeveloper
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperGenPage&fq=entiteVar_enUS_indexed_string:listAiTelemetryDeveloper">Find the entity listAiTelemetryDeveloper in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listAiTelemetryDeveloper(JsonArray l);

  public JsonArray getListAiTelemetryDeveloper() {
    return listAiTelemetryDeveloper;
  }

  public void setListAiTelemetryDeveloper(JsonArray listAiTelemetryDeveloper) {
    this.listAiTelemetryDeveloper = listAiTelemetryDeveloper;
  }
  @JsonIgnore
  public void setListAiTelemetryDeveloper(String o) {
    this.listAiTelemetryDeveloper = AiTelemetryDeveloperGenPage.staticSetListAiTelemetryDeveloper(siteRequest_, o);
  }
  public static JsonArray staticSetListAiTelemetryDeveloper(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected AiTelemetryDeveloperGenPage listAiTelemetryDeveloperInit() {
    _listAiTelemetryDeveloper(listAiTelemetryDeveloper);
    return (AiTelemetryDeveloperGenPage)this;
  }

  public static String staticSearchListAiTelemetryDeveloper(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListAiTelemetryDeveloper(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListAiTelemetryDeveloper(SiteRequest siteRequest_, String o) {
    return AiTelemetryDeveloperGenPage.staticSearchListAiTelemetryDeveloper(siteRequest_, AiTelemetryDeveloperGenPage.staticSetListAiTelemetryDeveloper(siteRequest_, o)).toString();
  }

	/////////////////
  // resultCount //
	/////////////////


  /**
   *  The entity resultCount
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer resultCount;

  /**
   * <br> The entity resultCount
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _resultCount(Wrap<Integer> w);

  public Integer getResultCount() {
    return resultCount;
  }

  public void setResultCount(Integer resultCount) {
    this.resultCount = resultCount;
  }
  @JsonIgnore
  public void setResultCount(String o) {
    this.resultCount = AiTelemetryDeveloperGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected AiTelemetryDeveloperGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (AiTelemetryDeveloperGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return AiTelemetryDeveloperGenPage.staticSearchResultCount(siteRequest_, AiTelemetryDeveloperGenPage.staticSetResultCount(siteRequest_, o)).toString();
  }

	////////////
  // result //
	////////////


  /**
   *  The entity result
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected AiTelemetryDeveloper result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<AiTelemetryDeveloper> w);

  public AiTelemetryDeveloper getResult() {
    return result;
  }

  public void setResult(AiTelemetryDeveloper result) {
    this.result = result;
  }
  public static AiTelemetryDeveloper staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected AiTelemetryDeveloperGenPage resultInit() {
    Wrap<AiTelemetryDeveloper> resultWrap = new Wrap<AiTelemetryDeveloper>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (AiTelemetryDeveloperGenPage)this;
  }

	////////////
  // solrId //
	////////////


  /**
   *  The entity solrId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String solrId;

  /**
   * <br> The entity solrId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = AiTelemetryDeveloperGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected AiTelemetryDeveloperGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (AiTelemetryDeveloperGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return AiTelemetryDeveloperGenPage.staticSearchSolrId(siteRequest_, AiTelemetryDeveloperGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	/////////////////////////////////
  // pageUriAiTelemetryDeveloper //
	/////////////////////////////////


  /**
   *  The entity pageUriAiTelemetryDeveloper
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriAiTelemetryDeveloper;

  /**
   * <br> The entity pageUriAiTelemetryDeveloper
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperGenPage&fq=entiteVar_enUS_indexed_string:pageUriAiTelemetryDeveloper">Find the entity pageUriAiTelemetryDeveloper in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriAiTelemetryDeveloper(Wrap<String> c);

  public String getPageUriAiTelemetryDeveloper() {
    return pageUriAiTelemetryDeveloper;
  }
  public void setPageUriAiTelemetryDeveloper(String o) {
    this.pageUriAiTelemetryDeveloper = AiTelemetryDeveloperGenPage.staticSetPageUriAiTelemetryDeveloper(siteRequest_, o);
  }
  public static String staticSetPageUriAiTelemetryDeveloper(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected AiTelemetryDeveloperGenPage pageUriAiTelemetryDeveloperInit() {
    Wrap<String> pageUriAiTelemetryDeveloperWrap = new Wrap<String>().var("pageUriAiTelemetryDeveloper");
    if(pageUriAiTelemetryDeveloper == null) {
      _pageUriAiTelemetryDeveloper(pageUriAiTelemetryDeveloperWrap);
      Optional.ofNullable(pageUriAiTelemetryDeveloperWrap.getO()).ifPresent(o -> {
        setPageUriAiTelemetryDeveloper(o);
      });
    }
    return (AiTelemetryDeveloperGenPage)this;
  }

  public static String staticSearchPageUriAiTelemetryDeveloper(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriAiTelemetryDeveloper(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriAiTelemetryDeveloper(SiteRequest siteRequest_, String o) {
    return AiTelemetryDeveloperGenPage.staticSearchPageUriAiTelemetryDeveloper(siteRequest_, AiTelemetryDeveloperGenPage.staticSetPageUriAiTelemetryDeveloper(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<AiTelemetryDeveloperGenPageGen<DEV>> promiseDeepAiTelemetryDeveloperGenPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepAiTelemetryDeveloperGenPage();
  }

  public Future<AiTelemetryDeveloperGenPageGen<DEV>> promiseDeepAiTelemetryDeveloperGenPage() {
    Promise<AiTelemetryDeveloperGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseAiTelemetryDeveloperGenPage(promise2);
    promise2.future().onSuccess(a -> {
      super.promiseDeepPageLayout(siteRequest_).onSuccess(b -> {
        promise.complete(this);
      }).onFailure(ex -> {
        promise.fail(ex);
      });
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<Void> promiseAiTelemetryDeveloperGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListAiTelemetryDeveloper_Init();
        listAiTelemetryDeveloperInit();
        resultCountInit();
        resultInit();
        solrIdInit();
        pageUriAiTelemetryDeveloperInit();
        promise2.complete();
      } catch(Exception ex) {
        promise2.fail(ex);
      }
      return promise2.future();
    }).onSuccess(a -> {
      promise.complete();
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  @Override public Future<? extends AiTelemetryDeveloperGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepAiTelemetryDeveloperGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestAiTelemetryDeveloperGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestAiTelemetryDeveloperGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainAiTelemetryDeveloperGenPage(v);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.obtainForClass(v);
      }
      else if(o instanceof Map) {
        Map<?, ?> map = (Map<?, ?>)o;
        o = map.get(v);
      }
    }
    return o;
  }
  public Object obtainAiTelemetryDeveloperGenPage(String var) {
    AiTelemetryDeveloperGenPage oAiTelemetryDeveloperGenPage = (AiTelemetryDeveloperGenPage)this;
    switch(var) {
      case "searchListAiTelemetryDeveloper_":
        return oAiTelemetryDeveloperGenPage.searchListAiTelemetryDeveloper_;
      case "listAiTelemetryDeveloper":
        return oAiTelemetryDeveloperGenPage.listAiTelemetryDeveloper;
      case "resultCount":
        return oAiTelemetryDeveloperGenPage.resultCount;
      case "result":
        return oAiTelemetryDeveloperGenPage.result;
      case "solrId":
        return oAiTelemetryDeveloperGenPage.solrId;
      case "pageUriAiTelemetryDeveloper":
        return oAiTelemetryDeveloperGenPage.pageUriAiTelemetryDeveloper;
      default:
        return super.obtainPageLayout(var);
    }
  }

  ///////////////
  // relate //
  ///////////////

  @Override public boolean relateForClass(String var, Object val) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = relateAiTelemetryDeveloperGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateAiTelemetryDeveloperGenPage(String var, Object val) {
    AiTelemetryDeveloperGenPage oAiTelemetryDeveloperGenPage = (AiTelemetryDeveloperGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, AiTelemetryDeveloperGenPage o) {
    return staticSetAiTelemetryDeveloperGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetAiTelemetryDeveloperGenPage(String entityVar, SiteRequest siteRequest_, String v, AiTelemetryDeveloperGenPage o) {
    switch(entityVar) {
    case "listAiTelemetryDeveloper":
      return AiTelemetryDeveloperGenPage.staticSetListAiTelemetryDeveloper(siteRequest_, v);
    case "resultCount":
      return AiTelemetryDeveloperGenPage.staticSetResultCount(siteRequest_, v);
    case "solrId":
      return AiTelemetryDeveloperGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriAiTelemetryDeveloper":
      return AiTelemetryDeveloperGenPage.staticSetPageUriAiTelemetryDeveloper(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchAiTelemetryDeveloperGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchAiTelemetryDeveloperGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listAiTelemetryDeveloper":
      return AiTelemetryDeveloperGenPage.staticSearchListAiTelemetryDeveloper(siteRequest_, (JsonArray)o);
    case "resultCount":
      return AiTelemetryDeveloperGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "solrId":
      return AiTelemetryDeveloperGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriAiTelemetryDeveloper":
      return AiTelemetryDeveloperGenPage.staticSearchPageUriAiTelemetryDeveloper(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrAiTelemetryDeveloperGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrAiTelemetryDeveloperGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listAiTelemetryDeveloper":
      return AiTelemetryDeveloperGenPage.staticSearchStrListAiTelemetryDeveloper(siteRequest_, (String)o);
    case "resultCount":
      return AiTelemetryDeveloperGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "solrId":
      return AiTelemetryDeveloperGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriAiTelemetryDeveloper":
      return AiTelemetryDeveloperGenPage.staticSearchStrPageUriAiTelemetryDeveloper(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqAiTelemetryDeveloperGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqAiTelemetryDeveloperGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listAiTelemetryDeveloper":
      return AiTelemetryDeveloperGenPage.staticSearchFqListAiTelemetryDeveloper(siteRequest_, o);
    case "resultCount":
      return AiTelemetryDeveloperGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "solrId":
      return AiTelemetryDeveloperGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriAiTelemetryDeveloper":
      return AiTelemetryDeveloperGenPage.staticSearchFqPageUriAiTelemetryDeveloper(siteRequest_, o);
      default:
        return PageLayout.staticSearchFqPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "AiTelemetryDeveloperGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.mghpcc.aitelemetry.model.developer.aitelemetry.AiTelemetryDeveloperGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListAiTelemetryDeveloper_ = "searchListAiTelemetryDeveloper_";
  public static final String VAR_listAiTelemetryDeveloper = "listAiTelemetryDeveloper";
  public static final String VAR_resultCount = "resultCount";
  public static final String VAR_result = "result";
  public static final String VAR_solrId = "solrId";
  public static final String VAR_pageUriAiTelemetryDeveloper = "pageUriAiTelemetryDeveloper";

  public static final String DISPLAY_NAME_searchListAiTelemetryDeveloper_ = "";
  public static final String DISPLAY_NAME_listAiTelemetryDeveloper = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriAiTelemetryDeveloper = "";

  @Override
  public String idForClass() {
    return null;
  }

  @Override
  public String titleForClass() {
    return null;
  }

  @Override
  public String nameForClass() {
    return null;
  }

  @Override
  public String classNameAdjectiveSingularForClass() {
    return null;
  }

  @Override
  public String descriptionForClass() {
    return null;
  }

  @Override
  public String classStringFormatUrlEditPageForClass() {
    return null;
  }

  @Override
  public String classStringFormatUrlDisplayPageForClass() {
    return null;
  }

  @Override
  public String classStringFormatUrlUserPageForClass() {
    return null;
  }

  @Override
  public String classStringFormatUrlDownloadForClass() {
    return null;
  }

  public static String displayNameForClass(String var) {
    return AiTelemetryDeveloperGenPage.displayNameAiTelemetryDeveloperGenPage(var);
  }
  public static String displayNameAiTelemetryDeveloperGenPage(String var) {
    switch(var) {
    case VAR_searchListAiTelemetryDeveloper_:
      return DISPLAY_NAME_searchListAiTelemetryDeveloper_;
    case VAR_listAiTelemetryDeveloper:
      return DISPLAY_NAME_listAiTelemetryDeveloper;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriAiTelemetryDeveloper:
      return DISPLAY_NAME_pageUriAiTelemetryDeveloper;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }

  public static String descriptionAiTelemetryDeveloperGenPage(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return PageLayout.descriptionPageLayout(var);
    }
  }

  public static String classSimpleNameAiTelemetryDeveloperGenPage(String var) {
    switch(var) {
    case VAR_searchListAiTelemetryDeveloper_:
      return "SearchList";
    case VAR_listAiTelemetryDeveloper:
      return "JsonArray";
    case VAR_resultCount:
      return "Integer";
    case VAR_result:
      return "AiTelemetryDeveloper";
    case VAR_solrId:
      return "String";
    case VAR_pageUriAiTelemetryDeveloper:
      return "String";
      default:
        return PageLayout.classSimpleNamePageLayout(var);
    }
  }

  public static Integer htmColumnAiTelemetryDeveloperGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmColumnPageLayout(var);
    }
  }

  public static Integer htmRowAiTelemetryDeveloperGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmRowPageLayout(var);
    }
  }

  public static Integer htmCellAiTelemetryDeveloperGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmCellPageLayout(var);
    }
  }

  public static Integer lengthMinAiTelemetryDeveloperGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMinPageLayout(var);
    }
  }

  public static Integer lengthMaxAiTelemetryDeveloperGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMaxPageLayout(var);
    }
  }

  public static Integer maxAiTelemetryDeveloperGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.maxPageLayout(var);
    }
  }

  public static Integer minAiTelemetryDeveloperGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.minPageLayout(var);
    }
  }
}

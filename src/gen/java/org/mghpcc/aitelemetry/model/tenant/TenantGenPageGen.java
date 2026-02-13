package org.mghpcc.aitelemetry.model.tenant;

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
import org.mghpcc.aitelemetry.model.tenant.Tenant;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these TenantGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class TenantGenPageGen into the class TenantGenPage. 
 * </li>
 * <h3>About the TenantGenPage class and it's generated class TenantGenPageGen&lt;PageLayout&gt;: </h3>extends TenantGenPageGen
 * <p>
 * This Java class extends a generated Java class TenantGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant.TenantGenPage">Find the class TenantGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends TenantGenPageGen<PageLayout>
 * <p>This <code>class TenantGenPage extends TenantGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated TenantGenPageGen. 
 * The generated <code>class TenantGenPageGen extends PageLayout</code> which means that TenantGenPage extends TenantGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the TenantGenPage class will inherit the helpful inherited class comments from the super class TenantGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the TenantGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class TenantGenPage in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate-computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant.TenantGenPage&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.mghpcc.aitelemetry.model.tenant in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate-computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the project ai-telemetry in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate-computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:ai\-telemetry&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * Generated: true
 **/
public abstract class TenantGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(TenantGenPage.class);

	///////////////////////
  // searchListTenant_ //
	///////////////////////


  /**
   *  The entity searchListTenant_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<Tenant> searchListTenant_;

  /**
   * <br> The entity searchListTenant_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant.TenantGenPage&fq=entiteVar_enUS_indexed_string:searchListTenant_">Find the entity searchListTenant_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListTenant_(Wrap<SearchList<Tenant>> w);

  public SearchList<Tenant> getSearchListTenant_() {
    return searchListTenant_;
  }

  public void setSearchListTenant_(SearchList<Tenant> searchListTenant_) {
    this.searchListTenant_ = searchListTenant_;
  }
  public static SearchList<Tenant> staticSetSearchListTenant_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected TenantGenPage searchListTenant_Init() {
    Wrap<SearchList<Tenant>> searchListTenant_Wrap = new Wrap<SearchList<Tenant>>().var("searchListTenant_");
    if(searchListTenant_ == null) {
      _searchListTenant_(searchListTenant_Wrap);
      Optional.ofNullable(searchListTenant_Wrap.getO()).ifPresent(o -> {
        setSearchListTenant_(o);
      });
    }
    return (TenantGenPage)this;
  }

	////////////////
  // listTenant //
	////////////////


  /**
   *  The entity listTenant
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listTenant = new JsonArray();

  /**
   * <br> The entity listTenant
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant.TenantGenPage&fq=entiteVar_enUS_indexed_string:listTenant">Find the entity listTenant in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listTenant(JsonArray l);

  public JsonArray getListTenant() {
    return listTenant;
  }

  public void setListTenant(JsonArray listTenant) {
    this.listTenant = listTenant;
  }
  @JsonIgnore
  public void setListTenant(String o) {
    this.listTenant = TenantGenPage.staticSetListTenant(siteRequest_, o);
  }
  public static JsonArray staticSetListTenant(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected TenantGenPage listTenantInit() {
    _listTenant(listTenant);
    return (TenantGenPage)this;
  }

  public static String staticSearchListTenant(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListTenant(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListTenant(SiteRequest siteRequest_, String o) {
    return TenantGenPage.staticSearchListTenant(siteRequest_, TenantGenPage.staticSetListTenant(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant.TenantGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
    this.resultCount = TenantGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected TenantGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (TenantGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return TenantGenPage.staticSearchResultCount(siteRequest_, TenantGenPage.staticSetResultCount(siteRequest_, o)).toString();
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
  protected Tenant result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant.TenantGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<Tenant> w);

  public Tenant getResult() {
    return result;
  }

  public void setResult(Tenant result) {
    this.result = result;
  }
  public static Tenant staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected TenantGenPage resultInit() {
    Wrap<Tenant> resultWrap = new Wrap<Tenant>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (TenantGenPage)this;
  }

	////////
  // pk //
	////////


  /**
   *  The entity pk
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long pk;

  /**
   * <br> The entity pk
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant.TenantGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pk(Wrap<Long> w);

  public Long getPk() {
    return pk;
  }

  public void setPk(Long pk) {
    this.pk = pk;
  }
  @JsonIgnore
  public void setPk(String o) {
    this.pk = TenantGenPage.staticSetPk(siteRequest_, o);
  }
  public static Long staticSetPk(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected TenantGenPage pkInit() {
    Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
    if(pk == null) {
      _pk(pkWrap);
      Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
        setPk(o);
      });
    }
    return (TenantGenPage)this;
  }

  public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
    return TenantGenPage.staticSearchPk(siteRequest_, TenantGenPage.staticSetPk(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant.TenantGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = TenantGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected TenantGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (TenantGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return TenantGenPage.staticSearchSolrId(siteRequest_, TenantGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	///////////////////
  // pageUriTenant //
	///////////////////


  /**
   *  The entity pageUriTenant
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriTenant;

  /**
   * <br> The entity pageUriTenant
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.tenant.TenantGenPage&fq=entiteVar_enUS_indexed_string:pageUriTenant">Find the entity pageUriTenant in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriTenant(Wrap<String> c);

  public String getPageUriTenant() {
    return pageUriTenant;
  }
  public void setPageUriTenant(String o) {
    this.pageUriTenant = TenantGenPage.staticSetPageUriTenant(siteRequest_, o);
  }
  public static String staticSetPageUriTenant(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected TenantGenPage pageUriTenantInit() {
    Wrap<String> pageUriTenantWrap = new Wrap<String>().var("pageUriTenant");
    if(pageUriTenant == null) {
      _pageUriTenant(pageUriTenantWrap);
      Optional.ofNullable(pageUriTenantWrap.getO()).ifPresent(o -> {
        setPageUriTenant(o);
      });
    }
    return (TenantGenPage)this;
  }

  public static String staticSearchPageUriTenant(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriTenant(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriTenant(SiteRequest siteRequest_, String o) {
    return TenantGenPage.staticSearchPageUriTenant(siteRequest_, TenantGenPage.staticSetPageUriTenant(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<TenantGenPageGen<DEV>> promiseDeepTenantGenPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepTenantGenPage();
  }

  public Future<TenantGenPageGen<DEV>> promiseDeepTenantGenPage() {
    Promise<TenantGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseTenantGenPage(promise2);
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

  public Future<Void> promiseTenantGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListTenant_Init();
        listTenantInit();
        resultCountInit();
        resultInit();
        pkInit();
        solrIdInit();
        pageUriTenantInit();
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

  @Override public Future<? extends TenantGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepTenantGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestTenantGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestTenantGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainTenantGenPage(v);
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
  public Object obtainTenantGenPage(String var) {
    TenantGenPage oTenantGenPage = (TenantGenPage)this;
    switch(var) {
      case "searchListTenant_":
        return oTenantGenPage.searchListTenant_;
      case "listTenant":
        return oTenantGenPage.listTenant;
      case "resultCount":
        return oTenantGenPage.resultCount;
      case "result":
        return oTenantGenPage.result;
      case "pk":
        return oTenantGenPage.pk;
      case "solrId":
        return oTenantGenPage.solrId;
      case "pageUriTenant":
        return oTenantGenPage.pageUriTenant;
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
        o = relateTenantGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateTenantGenPage(String var, Object val) {
    TenantGenPage oTenantGenPage = (TenantGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, TenantGenPage o) {
    return staticSetTenantGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetTenantGenPage(String entityVar, SiteRequest siteRequest_, String v, TenantGenPage o) {
    switch(entityVar) {
    case "listTenant":
      return TenantGenPage.staticSetListTenant(siteRequest_, v);
    case "resultCount":
      return TenantGenPage.staticSetResultCount(siteRequest_, v);
    case "pk":
      return TenantGenPage.staticSetPk(siteRequest_, v);
    case "solrId":
      return TenantGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriTenant":
      return TenantGenPage.staticSetPageUriTenant(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchTenantGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchTenantGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listTenant":
      return TenantGenPage.staticSearchListTenant(siteRequest_, (JsonArray)o);
    case "resultCount":
      return TenantGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "pk":
      return TenantGenPage.staticSearchPk(siteRequest_, (Long)o);
    case "solrId":
      return TenantGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriTenant":
      return TenantGenPage.staticSearchPageUriTenant(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrTenantGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrTenantGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listTenant":
      return TenantGenPage.staticSearchStrListTenant(siteRequest_, (String)o);
    case "resultCount":
      return TenantGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "pk":
      return TenantGenPage.staticSearchStrPk(siteRequest_, (Long)o);
    case "solrId":
      return TenantGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriTenant":
      return TenantGenPage.staticSearchStrPageUriTenant(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqTenantGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqTenantGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listTenant":
      return TenantGenPage.staticSearchFqListTenant(siteRequest_, o);
    case "resultCount":
      return TenantGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "pk":
      return TenantGenPage.staticSearchFqPk(siteRequest_, o);
    case "solrId":
      return TenantGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriTenant":
      return TenantGenPage.staticSearchFqPageUriTenant(siteRequest_, o);
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

  public static final String CLASS_SIMPLE_NAME = "TenantGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.mghpcc.aitelemetry.model.tenant.TenantGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListTenant_ = "searchListTenant_";
  public static final String VAR_listTenant = "listTenant";
  public static final String VAR_resultCount = "resultCount";
  public static final String VAR_result = "result";
  public static final String VAR_pk = "pk";
  public static final String VAR_solrId = "solrId";
  public static final String VAR_pageUriTenant = "pageUriTenant";

  public static final String DISPLAY_NAME_searchListTenant_ = "";
  public static final String DISPLAY_NAME_listTenant = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_pk = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriTenant = "";

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
  public String enUSStringFormatUrlEditPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlDisplayPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlUserPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlDownloadForClass() {
    return null;
  }

  public static String displayNameForClass(String var) {
    return TenantGenPage.displayNameTenantGenPage(var);
  }
  public static String displayNameTenantGenPage(String var) {
    switch(var) {
    case VAR_searchListTenant_:
      return DISPLAY_NAME_searchListTenant_;
    case VAR_listTenant:
      return DISPLAY_NAME_listTenant;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_pk:
      return DISPLAY_NAME_pk;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriTenant:
      return DISPLAY_NAME_pageUriTenant;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }

  public static String descriptionTenantGenPage(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return PageLayout.descriptionPageLayout(var);
    }
  }

  public static String classSimpleNameTenantGenPage(String var) {
    switch(var) {
    case VAR_searchListTenant_:
      return "SearchList";
    case VAR_listTenant:
      return "JsonArray";
    case VAR_resultCount:
      return "Integer";
    case VAR_result:
      return "Tenant";
    case VAR_pk:
      return "Long";
    case VAR_solrId:
      return "String";
    case VAR_pageUriTenant:
      return "String";
      default:
        return PageLayout.classSimpleNamePageLayout(var);
    }
  }

  public static Integer htmColumnTenantGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmColumnPageLayout(var);
    }
  }

  public static Integer htmRowTenantGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmRowPageLayout(var);
    }
  }

  public static Integer htmCellTenantGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmCellPageLayout(var);
    }
  }

  public static Integer lengthMinTenantGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMinPageLayout(var);
    }
  }

  public static Integer lengthMaxTenantGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMaxPageLayout(var);
    }
  }

  public static Integer maxTenantGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.maxPageLayout(var);
    }
  }

  public static Integer minTenantGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.minPageLayout(var);
    }
  }
}

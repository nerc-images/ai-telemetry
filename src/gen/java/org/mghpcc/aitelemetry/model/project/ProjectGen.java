package org.mghpcc.aitelemetry.model.project;

import org.mghpcc.aitelemetry.request.SiteRequest;
import org.mghpcc.aitelemetry.model.BaseModel;
import io.vertx.core.json.JsonObject;
import java.util.Date;
import java.util.Set;
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
import java.lang.String;
import org.mghpcc.aitelemetry.model.tenant.Tenant;
import org.mghpcc.aitelemetry.model.hub.Hub;
import org.mghpcc.aitelemetry.model.cluster.Cluster;
import java.lang.Boolean;
import java.lang.Integer;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ProjectGen into the class Project. 
 * </li>
 * <h3>About the Project class and it's generated class ProjectGen&lt;BaseModel&gt;: </h3>extends ProjectGen
 * <p>
 * This Java class extends a generated Java class ProjectGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project">Find the class Project in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ProjectGen<BaseModel>
 * <p>This <code>class Project extends ProjectGen&lt;BaseModel&gt;</code>, which means it extends a newly generated ProjectGen. 
 * The generated <code>class ProjectGen extends BaseModel</code> which means that Project extends ProjectGen which extends BaseModel. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <p>This class contains a comment <b>"Api: true"</b>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <b>"ApiTag: projects"</b>, which groups all of the OpenAPIs for Project objects under the tag "projects". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/project</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/project"</b>, which defines the base API URI for Project objects as "/en-us/api/project" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the Project class will inherit the helpful inherited class comments from the super class ProjectGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the Project API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 10</h2>
 * <p>This class contains a comment <b>"Order: 10"</b>, which means this class will be sorted by the given number 10 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 10</h2>
 * <p>This class contains a comment <b>"SqlOrder: 10"</b>, which means this class will be sorted by the given number 10 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <b>"Model: true"</b>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.mghpcc.aitelemetry.model.project.ProjectPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.mghpcc.aitelemetry.model.project.ProjectPage extends org.mghpcc.aitelemetry.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the Project Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: an project</h2>
 * <p>This class contains a comment <b>"AName.enUS: an project"</b>, which identifies the language context to describe a Project as "an project". 
 * </p>
 * <p>
 * Delete the class Project in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.mghpcc.aitelemetry.model.project in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.mghpcc.aitelemetry.model.project&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project ai-telemetry in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:ai\-telemetry&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class ProjectGen<DEV> extends BaseModel {
  protected static final Logger LOG = LoggerFactory.getLogger(Project.class);

  public static final String Description_enUS = "A research project using AI and GPUs";
  public static final String AName_enUS = "an project";
  public static final String This_enUS = "this ";
  public static final String ThisName_enUS = "this project";
  public static final String A_enUS = "a ";
  public static final String TheName_enUS = "the project";
  public static final String SingularName_enUS = "project";
  public static final String PluralName_enUS = "projects";
  public static final String NameActual_enUS = "current project";
  public static final String AllName_enUS = "all projects";
  public static final String SearchAllNameBy_enUS = "search projects by ";
  public static final String SearchAllName_enUS = "search projects";
  public static final String Title_enUS = "projects";
  public static final String ThePluralName_enUS = "the projects";
  public static final String NoNameFound_enUS = "no project found";
  public static final String ApiUri_enUS = "/en-us/api/project";
  public static final String ApiUriSearchPage_enUS = "/en-us/search/project";
  public static final String ApiUriEditPage_enUS = "/en-us/edit/project/{projectResource}";
  public static final String OfName_enUS = "of project";
  public static final String ANameAdjective_enUS = "a project";
  public static final String NameAdjectiveSingular_enUS = "project";
  public static final String NameAdjectivePlural_enUS = "projects";
  public static final String Search_enUS_OpenApiUri = "/en-us/api/project";
  public static final String Search_enUS_StringFormatUri = "/en-us/api/project";
  public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/project";
  public static final String GET_enUS_OpenApiUri = "/en-us/api/project/{projectResource}";
  public static final String GET_enUS_StringFormatUri = "/en-us/api/project/%s";
  public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/project/%s";
  public static final String PATCH_enUS_OpenApiUri = "/en-us/api/project";
  public static final String PATCH_enUS_StringFormatUri = "/en-us/api/project";
  public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/project";
  public static final String POST_enUS_OpenApiUri = "/en-us/api/project";
  public static final String POST_enUS_StringFormatUri = "/en-us/api/project";
  public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/project";
  public static final String DELETE_enUS_OpenApiUri = "/en-us/api/project/{projectResource}";
  public static final String DELETE_enUS_StringFormatUri = "/en-us/api/project/%s";
  public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/project/%s";
  public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/project-import";
  public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/project-import";
  public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/project-import";
  public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/project";
  public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/project";
  public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/project";
  public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/project/{projectResource}";
  public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/project/%s";
  public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/project/%s";
  public static final String UserPage_enUS_OpenApiUri = "/en-us/user/project/{projectResource}";
  public static final String UserPage_enUS_StringFormatUri = "/en-us/user/project/%s";
  public static final String UserPage_enUS_StringFormatUrl = "%s/en-us/user/project/%s";
  public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/project";
  public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/project";
  public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/project";

  public static final String Icon = "<i class=\"fa-regular fa-people-line\"></i>";
  public static final Integer Rows = 100;

	////////////////////
  // tenantResource //
	////////////////////


  /**
   *  The entity tenantResource
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String tenantResource;

  /**
   * <br> The entity tenantResource
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:tenantResource">Find the entity tenantResource in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _tenantResource(Wrap<String> w);

  public String getTenantResource() {
    return tenantResource;
  }
  public void setTenantResource(String o) {
    this.tenantResource = Project.staticSetTenantResource(siteRequest_, o);
  }
  public static String staticSetTenantResource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project tenantResourceInit() {
    Wrap<String> tenantResourceWrap = new Wrap<String>().var("tenantResource");
    if(tenantResource == null) {
      _tenantResource(tenantResourceWrap);
      Optional.ofNullable(tenantResourceWrap.getO()).ifPresent(o -> {
        setTenantResource(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchTenantResource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrTenantResource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTenantResource(SiteRequest siteRequest_, String o) {
    return Project.staticSearchTenantResource(siteRequest_, Project.staticSetTenantResource(siteRequest_, o)).toString();
  }

  public String sqlTenantResource() {
    return tenantResource;
  }

  public static String staticJsonTenantResource(String tenantResource) {
    return tenantResource;
  }

	//////////////////////
  // localClusterName //
	//////////////////////


  /**
   *  The entity localClusterName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String localClusterName;

  /**
   * <br> The entity localClusterName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:localClusterName">Find the entity localClusterName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _localClusterName(Wrap<String> w);

  public String getLocalClusterName() {
    return localClusterName;
  }
  public void setLocalClusterName(String o) {
    this.localClusterName = Project.staticSetLocalClusterName(siteRequest_, o);
  }
  public static String staticSetLocalClusterName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project localClusterNameInit() {
    Wrap<String> localClusterNameWrap = new Wrap<String>().var("localClusterName");
    if(localClusterName == null) {
      _localClusterName(localClusterNameWrap);
      Optional.ofNullable(localClusterNameWrap.getO()).ifPresent(o -> {
        setLocalClusterName(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchLocalClusterName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLocalClusterName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLocalClusterName(SiteRequest siteRequest_, String o) {
    return Project.staticSearchLocalClusterName(siteRequest_, Project.staticSetLocalClusterName(siteRequest_, o)).toString();
  }

  public String sqlLocalClusterName() {
    return localClusterName;
  }

  public static String staticJsonLocalClusterName(String localClusterName) {
    return localClusterName;
  }

	///////////
  // hubId //
	///////////


  /**
   *  The entity hubId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String hubId;

  /**
   * <br> The entity hubId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:hubId">Find the entity hubId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _hubId(Wrap<String> w);

  public String getHubId() {
    return hubId;
  }
  public void setHubId(String o) {
    this.hubId = Project.staticSetHubId(siteRequest_, o);
  }
  public static String staticSetHubId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project hubIdInit() {
    Wrap<String> hubIdWrap = new Wrap<String>().var("hubId");
    if(hubId == null) {
      _hubId(hubIdWrap);
      Optional.ofNullable(hubIdWrap.getO()).ifPresent(o -> {
        setHubId(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchHubId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrHubId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqHubId(SiteRequest siteRequest_, String o) {
    return Project.staticSearchHubId(siteRequest_, Project.staticSetHubId(siteRequest_, o)).toString();
  }

  public String sqlHubId() {
    return hubId;
  }

  public static String staticJsonHubId(String hubId) {
    return hubId;
  }

	/////////////////
  // hubResource //
	/////////////////


  /**
   *  The entity hubResource
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String hubResource;

  /**
   * <br> The entity hubResource
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:hubResource">Find the entity hubResource in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _hubResource(Wrap<String> w);

  public String getHubResource() {
    return hubResource;
  }
  public void setHubResource(String o) {
    this.hubResource = Project.staticSetHubResource(siteRequest_, o);
  }
  public static String staticSetHubResource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project hubResourceInit() {
    Wrap<String> hubResourceWrap = new Wrap<String>().var("hubResource");
    if(hubResource == null) {
      _hubResource(hubResourceWrap);
      Optional.ofNullable(hubResourceWrap.getO()).ifPresent(o -> {
        setHubResource(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchHubResource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrHubResource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqHubResource(SiteRequest siteRequest_, String o) {
    return Project.staticSearchHubResource(siteRequest_, Project.staticSetHubResource(siteRequest_, o)).toString();
  }

  public String sqlHubResource() {
    return hubResource;
  }

  public static String staticJsonHubResource(String hubResource) {
    return hubResource;
  }

	/////////////////
  // clusterName //
	/////////////////


  /**
   *  The entity clusterName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String clusterName;

  /**
   * <br> The entity clusterName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:clusterName">Find the entity clusterName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _clusterName(Wrap<String> w);

  public String getClusterName() {
    return clusterName;
  }
  public void setClusterName(String o) {
    this.clusterName = Project.staticSetClusterName(siteRequest_, o);
  }
  public static String staticSetClusterName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project clusterNameInit() {
    Wrap<String> clusterNameWrap = new Wrap<String>().var("clusterName");
    if(clusterName == null) {
      _clusterName(clusterNameWrap);
      Optional.ofNullable(clusterNameWrap.getO()).ifPresent(o -> {
        setClusterName(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchClusterName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClusterName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClusterName(SiteRequest siteRequest_, String o) {
    return Project.staticSearchClusterName(siteRequest_, Project.staticSetClusterName(siteRequest_, o)).toString();
  }

  public String sqlClusterName() {
    return clusterName;
  }

  public static String staticJsonClusterName(String clusterName) {
    return clusterName;
  }

	/////////////////////
  // clusterResource //
	/////////////////////


  /**
   *  The entity clusterResource
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String clusterResource;

  /**
   * <br> The entity clusterResource
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:clusterResource">Find the entity clusterResource in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _clusterResource(Wrap<String> w);

  public String getClusterResource() {
    return clusterResource;
  }
  public void setClusterResource(String o) {
    this.clusterResource = Project.staticSetClusterResource(siteRequest_, o);
  }
  public static String staticSetClusterResource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project clusterResourceInit() {
    Wrap<String> clusterResourceWrap = new Wrap<String>().var("clusterResource");
    if(clusterResource == null) {
      _clusterResource(clusterResourceWrap);
      Optional.ofNullable(clusterResourceWrap.getO()).ifPresent(o -> {
        setClusterResource(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchClusterResource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClusterResource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClusterResource(SiteRequest siteRequest_, String o) {
    return Project.staticSearchClusterResource(siteRequest_, Project.staticSetClusterResource(siteRequest_, o)).toString();
  }

  public String sqlClusterResource() {
    return clusterResource;
  }

  public static String staticJsonClusterResource(String clusterResource) {
    return clusterResource;
  }

	/////////////////
  // projectName //
	/////////////////


  /**
   *  The entity projectName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String projectName;

  /**
   * <br> The entity projectName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:projectName">Find the entity projectName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _projectName(Wrap<String> w);

  public String getProjectName() {
    return projectName;
  }
  public void setProjectName(String o) {
    this.projectName = Project.staticSetProjectName(siteRequest_, o);
  }
  public static String staticSetProjectName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project projectNameInit() {
    Wrap<String> projectNameWrap = new Wrap<String>().var("projectName");
    if(projectName == null) {
      _projectName(projectNameWrap);
      Optional.ofNullable(projectNameWrap.getO()).ifPresent(o -> {
        setProjectName(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchProjectName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrProjectName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqProjectName(SiteRequest siteRequest_, String o) {
    return Project.staticSearchProjectName(siteRequest_, Project.staticSetProjectName(siteRequest_, o)).toString();
  }

  public String sqlProjectName() {
    return projectName;
  }

  public static String staticJsonProjectName(String projectName) {
    return projectName;
  }

	/////////////////////
  // projectResource //
	/////////////////////


  /**
   *  The entity projectResource
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String projectResource;

  /**
   * <br> The entity projectResource
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:projectResource">Find the entity projectResource in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _projectResource(Wrap<String> w);

  public String getProjectResource() {
    return projectResource;
  }
  public void setProjectResource(String o) {
    this.projectResource = Project.staticSetProjectResource(siteRequest_, o);
  }
  public static String staticSetProjectResource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project projectResourceInit() {
    Wrap<String> projectResourceWrap = new Wrap<String>().var("projectResource");
    if(projectResource == null) {
      _projectResource(projectResourceWrap);
      Optional.ofNullable(projectResourceWrap.getO()).ifPresent(o -> {
        setProjectResource(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchProjectResource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrProjectResource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqProjectResource(SiteRequest siteRequest_, String o) {
    return Project.staticSearchProjectResource(siteRequest_, Project.staticSetProjectResource(siteRequest_, o)).toString();
  }

  public String sqlProjectResource() {
    return projectResource;
  }

  public static String staticJsonProjectResource(String projectResource) {
    return projectResource;
  }

	////////////////////////
  // projectDisplayName //
	////////////////////////


  /**
   *  The entity projectDisplayName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String projectDisplayName;

  /**
   * <br> The entity projectDisplayName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:projectDisplayName">Find the entity projectDisplayName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _projectDisplayName(Wrap<String> w);

  public String getProjectDisplayName() {
    return projectDisplayName;
  }
  public void setProjectDisplayName(String o) {
    this.projectDisplayName = Project.staticSetProjectDisplayName(siteRequest_, o);
  }
  public static String staticSetProjectDisplayName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project projectDisplayNameInit() {
    Wrap<String> projectDisplayNameWrap = new Wrap<String>().var("projectDisplayName");
    if(projectDisplayName == null) {
      _projectDisplayName(projectDisplayNameWrap);
      Optional.ofNullable(projectDisplayNameWrap.getO()).ifPresent(o -> {
        setProjectDisplayName(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchProjectDisplayName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrProjectDisplayName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqProjectDisplayName(SiteRequest siteRequest_, String o) {
    return Project.staticSearchProjectDisplayName(siteRequest_, Project.staticSetProjectDisplayName(siteRequest_, o)).toString();
  }

	/////////////////
  // description //
	/////////////////


  /**
   *  The entity description
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String description;

  /**
   * <br> The entity description
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _description(Wrap<String> w);

  public String getDescription() {
    return description;
  }
  public void setDescription(String o) {
    this.description = Project.staticSetDescription(siteRequest_, o);
  }
  public static String staticSetDescription(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Project descriptionInit() {
    Wrap<String> descriptionWrap = new Wrap<String>().var("description");
    if(description == null) {
      _description(descriptionWrap);
      Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
        setDescription(o);
      });
    }
    return (Project)this;
  }

  public static String staticSearchDescription(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDescription(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDescription(SiteRequest siteRequest_, String o) {
    return Project.staticSearchDescription(siteRequest_, Project.staticSetDescription(siteRequest_, o)).toString();
  }

  public String sqlDescription() {
    return description;
  }

  public static String staticJsonDescription(String description) {
    return description;
  }

	////////////////
  // gpuEnabled //
	////////////////


  /**
   *  The entity gpuEnabled
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean gpuEnabled;

  /**
   * <br> The entity gpuEnabled
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:gpuEnabled">Find the entity gpuEnabled in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _gpuEnabled(Wrap<Boolean> w);

  public Boolean getGpuEnabled() {
    return gpuEnabled;
  }

  public void setGpuEnabled(Boolean gpuEnabled) {
    this.gpuEnabled = gpuEnabled;
  }
  @JsonIgnore
  public void setGpuEnabled(String o) {
    this.gpuEnabled = Project.staticSetGpuEnabled(siteRequest_, o);
  }
  public static Boolean staticSetGpuEnabled(SiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected Project gpuEnabledInit() {
    Wrap<Boolean> gpuEnabledWrap = new Wrap<Boolean>().var("gpuEnabled");
    if(gpuEnabled == null) {
      _gpuEnabled(gpuEnabledWrap);
      Optional.ofNullable(gpuEnabledWrap.getO()).ifPresent(o -> {
        setGpuEnabled(o);
      });
    }
    return (Project)this;
  }

  public static Boolean staticSearchGpuEnabled(SiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrGpuEnabled(SiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqGpuEnabled(SiteRequest siteRequest_, String o) {
    return Project.staticSearchGpuEnabled(siteRequest_, Project.staticSetGpuEnabled(siteRequest_, o)).toString();
  }

  public Boolean sqlGpuEnabled() {
    return gpuEnabled;
  }

  public static Boolean staticJsonGpuEnabled(Boolean gpuEnabled) {
    return gpuEnabled;
  }

	/////////////////////
  // podRestartCount //
	/////////////////////


  /**
   *  The entity podRestartCount
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer podRestartCount;

  /**
   * <br> The entity podRestartCount
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:podRestartCount">Find the entity podRestartCount in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _podRestartCount(Wrap<Integer> w);

  public Integer getPodRestartCount() {
    return podRestartCount;
  }

  public void setPodRestartCount(Integer podRestartCount) {
    this.podRestartCount = podRestartCount;
  }
  @JsonIgnore
  public void setPodRestartCount(String o) {
    this.podRestartCount = Project.staticSetPodRestartCount(siteRequest_, o);
  }
  public static Integer staticSetPodRestartCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Project podRestartCountInit() {
    Wrap<Integer> podRestartCountWrap = new Wrap<Integer>().var("podRestartCount");
    if(podRestartCount == null) {
      _podRestartCount(podRestartCountWrap);
      Optional.ofNullable(podRestartCountWrap.getO()).ifPresent(o -> {
        setPodRestartCount(o);
      });
    }
    return (Project)this;
  }

  public static Integer staticSearchPodRestartCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrPodRestartCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPodRestartCount(SiteRequest siteRequest_, String o) {
    return Project.staticSearchPodRestartCount(siteRequest_, Project.staticSetPodRestartCount(siteRequest_, o)).toString();
  }

  public Integer sqlPodRestartCount() {
    return podRestartCount;
  }

  public static String staticJsonPodRestartCount(Integer podRestartCount) {
    return Optional.ofNullable(podRestartCount).map(v -> v.toString()).orElse(null);
  }

	////////////////////
  // podsRestarting //
	////////////////////


  /**
   *  The entity podsRestarting
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> podsRestarting = new ArrayList<String>();

  /**
   * <br> The entity podsRestarting
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:podsRestarting">Find the entity podsRestarting in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _podsRestarting(List<String> l);

  public List<String> getPodsRestarting() {
    return podsRestarting;
  }

  public void setPodsRestarting(List<String> podsRestarting) {
    this.podsRestarting = podsRestarting;
  }
  @JsonIgnore
  public void setPodsRestarting(String o) {
    String l = Project.staticSetPodsRestarting(siteRequest_, o);
    if(l != null)
      addPodsRestarting(l);
  }
  public static String staticSetPodsRestarting(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Project addPodsRestarting(String...objects) {
    for(String o : objects) {
      addPodsRestarting(o);
    }
    return (Project)this;
  }
  public Project addPodsRestarting(String o) {
    if(o != null)
      this.podsRestarting.add(o);
    return (Project)this;
  }
  @JsonIgnore
  public void setPodsRestarting(JsonArray objects) {
    podsRestarting.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addPodsRestarting(o);
    }
  }
  protected Project podsRestartingInit() {
    _podsRestarting(podsRestarting);
    return (Project)this;
  }

  public static String staticSearchPodsRestarting(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPodsRestarting(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPodsRestarting(SiteRequest siteRequest_, String o) {
    return Project.staticSearchPodsRestarting(siteRequest_, Project.staticSetPodsRestarting(siteRequest_, o)).toString();
  }

  public String[] sqlPodsRestarting() {
    return podsRestarting.stream().map(v -> (String)v).toArray(String[]::new);
  }

  public static JsonArray staticJsonPodsRestarting(List<String> podsRestarting) {
    JsonArray a = new JsonArray();
    podsRestarting.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	/////////////////////////
  // podTerminatingCount //
	/////////////////////////


  /**
   *  The entity podTerminatingCount
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer podTerminatingCount;

  /**
   * <br> The entity podTerminatingCount
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:podTerminatingCount">Find the entity podTerminatingCount in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _podTerminatingCount(Wrap<Integer> w);

  public Integer getPodTerminatingCount() {
    return podTerminatingCount;
  }

  public void setPodTerminatingCount(Integer podTerminatingCount) {
    this.podTerminatingCount = podTerminatingCount;
  }
  @JsonIgnore
  public void setPodTerminatingCount(String o) {
    this.podTerminatingCount = Project.staticSetPodTerminatingCount(siteRequest_, o);
  }
  public static Integer staticSetPodTerminatingCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Project podTerminatingCountInit() {
    Wrap<Integer> podTerminatingCountWrap = new Wrap<Integer>().var("podTerminatingCount");
    if(podTerminatingCount == null) {
      _podTerminatingCount(podTerminatingCountWrap);
      Optional.ofNullable(podTerminatingCountWrap.getO()).ifPresent(o -> {
        setPodTerminatingCount(o);
      });
    }
    return (Project)this;
  }

  public static Integer staticSearchPodTerminatingCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrPodTerminatingCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPodTerminatingCount(SiteRequest siteRequest_, String o) {
    return Project.staticSearchPodTerminatingCount(siteRequest_, Project.staticSetPodTerminatingCount(siteRequest_, o)).toString();
  }

  public Integer sqlPodTerminatingCount() {
    return podTerminatingCount;
  }

  public static String staticJsonPodTerminatingCount(Integer podTerminatingCount) {
    return Optional.ofNullable(podTerminatingCount).map(v -> v.toString()).orElse(null);
  }

	/////////////////////
  // podsTerminating //
	/////////////////////


  /**
   *  The entity podsTerminating
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> podsTerminating = new ArrayList<String>();

  /**
   * <br> The entity podsTerminating
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:podsTerminating">Find the entity podsTerminating in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _podsTerminating(List<String> l);

  public List<String> getPodsTerminating() {
    return podsTerminating;
  }

  public void setPodsTerminating(List<String> podsTerminating) {
    this.podsTerminating = podsTerminating;
  }
  @JsonIgnore
  public void setPodsTerminating(String o) {
    String l = Project.staticSetPodsTerminating(siteRequest_, o);
    if(l != null)
      addPodsTerminating(l);
  }
  public static String staticSetPodsTerminating(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Project addPodsTerminating(String...objects) {
    for(String o : objects) {
      addPodsTerminating(o);
    }
    return (Project)this;
  }
  public Project addPodsTerminating(String o) {
    if(o != null)
      this.podsTerminating.add(o);
    return (Project)this;
  }
  @JsonIgnore
  public void setPodsTerminating(JsonArray objects) {
    podsTerminating.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addPodsTerminating(o);
    }
  }
  protected Project podsTerminatingInit() {
    _podsTerminating(podsTerminating);
    return (Project)this;
  }

  public static String staticSearchPodsTerminating(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPodsTerminating(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPodsTerminating(SiteRequest siteRequest_, String o) {
    return Project.staticSearchPodsTerminating(siteRequest_, Project.staticSetPodsTerminating(siteRequest_, o)).toString();
  }

  public String[] sqlPodsTerminating() {
    return podsTerminating.stream().map(v -> (String)v).toArray(String[]::new);
  }

  public static JsonArray staticJsonPodsTerminating(List<String> podsTerminating) {
    JsonArray a = new JsonArray();
    podsTerminating.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	///////////////////
  // fullPvcsCount //
	///////////////////


  /**
   *  The entity fullPvcsCount
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer fullPvcsCount;

  /**
   * <br> The entity fullPvcsCount
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:fullPvcsCount">Find the entity fullPvcsCount in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _fullPvcsCount(Wrap<Integer> w);

  public Integer getFullPvcsCount() {
    return fullPvcsCount;
  }

  public void setFullPvcsCount(Integer fullPvcsCount) {
    this.fullPvcsCount = fullPvcsCount;
  }
  @JsonIgnore
  public void setFullPvcsCount(String o) {
    this.fullPvcsCount = Project.staticSetFullPvcsCount(siteRequest_, o);
  }
  public static Integer staticSetFullPvcsCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Project fullPvcsCountInit() {
    Wrap<Integer> fullPvcsCountWrap = new Wrap<Integer>().var("fullPvcsCount");
    if(fullPvcsCount == null) {
      _fullPvcsCount(fullPvcsCountWrap);
      Optional.ofNullable(fullPvcsCountWrap.getO()).ifPresent(o -> {
        setFullPvcsCount(o);
      });
    }
    return (Project)this;
  }

  public static Integer staticSearchFullPvcsCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrFullPvcsCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqFullPvcsCount(SiteRequest siteRequest_, String o) {
    return Project.staticSearchFullPvcsCount(siteRequest_, Project.staticSetFullPvcsCount(siteRequest_, o)).toString();
  }

  public Integer sqlFullPvcsCount() {
    return fullPvcsCount;
  }

  public static String staticJsonFullPvcsCount(Integer fullPvcsCount) {
    return Optional.ofNullable(fullPvcsCount).map(v -> v.toString()).orElse(null);
  }

	//////////////
  // fullPvcs //
	//////////////


  /**
   *  The entity fullPvcs
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> fullPvcs = new ArrayList<String>();

  /**
   * <br> The entity fullPvcs
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:fullPvcs">Find the entity fullPvcs in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _fullPvcs(List<String> l);

  public List<String> getFullPvcs() {
    return fullPvcs;
  }

  public void setFullPvcs(List<String> fullPvcs) {
    this.fullPvcs = fullPvcs;
  }
  @JsonIgnore
  public void setFullPvcs(String o) {
    String l = Project.staticSetFullPvcs(siteRequest_, o);
    if(l != null)
      addFullPvcs(l);
  }
  public static String staticSetFullPvcs(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Project addFullPvcs(String...objects) {
    for(String o : objects) {
      addFullPvcs(o);
    }
    return (Project)this;
  }
  public Project addFullPvcs(String o) {
    if(o != null)
      this.fullPvcs.add(o);
    return (Project)this;
  }
  @JsonIgnore
  public void setFullPvcs(JsonArray objects) {
    fullPvcs.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addFullPvcs(o);
    }
  }
  protected Project fullPvcsInit() {
    _fullPvcs(fullPvcs);
    return (Project)this;
  }

  public static String staticSearchFullPvcs(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrFullPvcs(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqFullPvcs(SiteRequest siteRequest_, String o) {
    return Project.staticSearchFullPvcs(siteRequest_, Project.staticSetFullPvcs(siteRequest_, o)).toString();
  }

  public String[] sqlFullPvcs() {
    return fullPvcs.stream().map(v -> (String)v).toArray(String[]::new);
  }

  public static JsonArray staticJsonFullPvcs(List<String> fullPvcs) {
    JsonArray a = new JsonArray();
    fullPvcs.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	//////////////////////////
  // namespaceTerminating //
	//////////////////////////


  /**
   *  The entity namespaceTerminating
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean namespaceTerminating;

  /**
   * <br> The entity namespaceTerminating
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.project.Project&fq=entiteVar_enUS_indexed_string:namespaceTerminating">Find the entity namespaceTerminating in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _namespaceTerminating(Wrap<Boolean> w);

  public Boolean getNamespaceTerminating() {
    return namespaceTerminating;
  }

  public void setNamespaceTerminating(Boolean namespaceTerminating) {
    this.namespaceTerminating = namespaceTerminating;
  }
  @JsonIgnore
  public void setNamespaceTerminating(String o) {
    this.namespaceTerminating = Project.staticSetNamespaceTerminating(siteRequest_, o);
  }
  public static Boolean staticSetNamespaceTerminating(SiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected Project namespaceTerminatingInit() {
    Wrap<Boolean> namespaceTerminatingWrap = new Wrap<Boolean>().var("namespaceTerminating");
    if(namespaceTerminating == null) {
      _namespaceTerminating(namespaceTerminatingWrap);
      Optional.ofNullable(namespaceTerminatingWrap.getO()).ifPresent(o -> {
        setNamespaceTerminating(o);
      });
    }
    return (Project)this;
  }

  public static Boolean staticSearchNamespaceTerminating(SiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrNamespaceTerminating(SiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNamespaceTerminating(SiteRequest siteRequest_, String o) {
    return Project.staticSearchNamespaceTerminating(siteRequest_, Project.staticSetNamespaceTerminating(siteRequest_, o)).toString();
  }

  public Boolean sqlNamespaceTerminating() {
    return namespaceTerminating;
  }

  public static Boolean staticJsonNamespaceTerminating(Boolean namespaceTerminating) {
    return namespaceTerminating;
  }

  //////////////
  // initDeep //
  //////////////

  public Future<ProjectGen<DEV>> promiseDeepProject(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepProject();
  }

  public Future<ProjectGen<DEV>> promiseDeepProject() {
    Promise<ProjectGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseProject(promise2);
    promise2.future().onSuccess(a -> {
      super.promiseDeepBaseModel(siteRequest_).onSuccess(b -> {
        promise.complete(this);
      }).onFailure(ex -> {
        promise.fail(ex);
      });
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<Void> promiseProject(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        tenantResourceInit();
        localClusterNameInit();
        hubIdInit();
        hubResourceInit();
        clusterNameInit();
        clusterResourceInit();
        projectNameInit();
        projectResourceInit();
        projectDisplayNameInit();
        descriptionInit();
        gpuEnabledInit();
        podRestartCountInit();
        podsRestartingInit();
        podTerminatingCountInit();
        podsTerminatingInit();
        fullPvcsCountInit();
        fullPvcsInit();
        namespaceTerminatingInit();
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

  @Override public Future<? extends ProjectGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepProject(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestProject(SiteRequest siteRequest_) {
      super.siteRequestBaseModel(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestProject(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainProject(v);
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
  public Object obtainProject(String var) {
    Project oProject = (Project)this;
    switch(var) {
      case "tenantResource":
        return oProject.tenantResource;
      case "localClusterName":
        return oProject.localClusterName;
      case "hubId":
        return oProject.hubId;
      case "hubResource":
        return oProject.hubResource;
      case "clusterName":
        return oProject.clusterName;
      case "clusterResource":
        return oProject.clusterResource;
      case "projectName":
        return oProject.projectName;
      case "projectResource":
        return oProject.projectResource;
      case "projectDisplayName":
        return oProject.projectDisplayName;
      case "description":
        return oProject.description;
      case "gpuEnabled":
        return oProject.gpuEnabled;
      case "podRestartCount":
        return oProject.podRestartCount;
      case "podsRestarting":
        return oProject.podsRestarting;
      case "podTerminatingCount":
        return oProject.podTerminatingCount;
      case "podsTerminating":
        return oProject.podsTerminating;
      case "fullPvcsCount":
        return oProject.fullPvcsCount;
      case "fullPvcs":
        return oProject.fullPvcs;
      case "namespaceTerminating":
        return oProject.namespaceTerminating;
      default:
        return super.obtainBaseModel(var);
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
        o = relateProject(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateProject(String var, Object val) {
    Project oProject = (Project)this;
    switch(var) {
      case "tenantResource":
        if(oProject.getTenantResource() == null)
          oProject.setTenantResource(Optional.ofNullable(val).map(v -> v.toString()).orElse(null));
        if(!saves.contains("tenantResource"))
          saves.add("tenantResource");
        return val;
      case "hubResource":
        if(oProject.getHubResource() == null)
          oProject.setHubResource(Optional.ofNullable(val).map(v -> v.toString()).orElse(null));
        if(!saves.contains("hubResource"))
          saves.add("hubResource");
        return val;
      case "clusterResource":
        if(oProject.getClusterResource() == null)
          oProject.setClusterResource(Optional.ofNullable(val).map(v -> v.toString()).orElse(null));
        if(!saves.contains("clusterResource"))
          saves.add("clusterResource");
        return val;
      default:
        return super.relateBaseModel(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, Project o) {
    return staticSetProject(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetProject(String entityVar, SiteRequest siteRequest_, String v, Project o) {
    switch(entityVar) {
    case "tenantResource":
      return Project.staticSetTenantResource(siteRequest_, v);
    case "localClusterName":
      return Project.staticSetLocalClusterName(siteRequest_, v);
    case "hubId":
      return Project.staticSetHubId(siteRequest_, v);
    case "hubResource":
      return Project.staticSetHubResource(siteRequest_, v);
    case "clusterName":
      return Project.staticSetClusterName(siteRequest_, v);
    case "clusterResource":
      return Project.staticSetClusterResource(siteRequest_, v);
    case "projectName":
      return Project.staticSetProjectName(siteRequest_, v);
    case "projectResource":
      return Project.staticSetProjectResource(siteRequest_, v);
    case "projectDisplayName":
      return Project.staticSetProjectDisplayName(siteRequest_, v);
    case "description":
      return Project.staticSetDescription(siteRequest_, v);
    case "gpuEnabled":
      return Project.staticSetGpuEnabled(siteRequest_, v);
    case "podRestartCount":
      return Project.staticSetPodRestartCount(siteRequest_, v);
    case "podsRestarting":
      return Project.staticSetPodsRestarting(siteRequest_, v);
    case "podTerminatingCount":
      return Project.staticSetPodTerminatingCount(siteRequest_, v);
    case "podsTerminating":
      return Project.staticSetPodsTerminating(siteRequest_, v);
    case "fullPvcsCount":
      return Project.staticSetFullPvcsCount(siteRequest_, v);
    case "fullPvcs":
      return Project.staticSetFullPvcs(siteRequest_, v);
    case "namespaceTerminating":
      return Project.staticSetNamespaceTerminating(siteRequest_, v);
      default:
        return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchProject(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchProject(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "tenantResource":
      return Project.staticSearchTenantResource(siteRequest_, (String)o);
    case "localClusterName":
      return Project.staticSearchLocalClusterName(siteRequest_, (String)o);
    case "hubId":
      return Project.staticSearchHubId(siteRequest_, (String)o);
    case "hubResource":
      return Project.staticSearchHubResource(siteRequest_, (String)o);
    case "clusterName":
      return Project.staticSearchClusterName(siteRequest_, (String)o);
    case "clusterResource":
      return Project.staticSearchClusterResource(siteRequest_, (String)o);
    case "projectName":
      return Project.staticSearchProjectName(siteRequest_, (String)o);
    case "projectResource":
      return Project.staticSearchProjectResource(siteRequest_, (String)o);
    case "projectDisplayName":
      return Project.staticSearchProjectDisplayName(siteRequest_, (String)o);
    case "description":
      return Project.staticSearchDescription(siteRequest_, (String)o);
    case "gpuEnabled":
      return Project.staticSearchGpuEnabled(siteRequest_, (Boolean)o);
    case "podRestartCount":
      return Project.staticSearchPodRestartCount(siteRequest_, (Integer)o);
    case "podsRestarting":
      return Project.staticSearchPodsRestarting(siteRequest_, (String)o);
    case "podTerminatingCount":
      return Project.staticSearchPodTerminatingCount(siteRequest_, (Integer)o);
    case "podsTerminating":
      return Project.staticSearchPodsTerminating(siteRequest_, (String)o);
    case "fullPvcsCount":
      return Project.staticSearchFullPvcsCount(siteRequest_, (Integer)o);
    case "fullPvcs":
      return Project.staticSearchFullPvcs(siteRequest_, (String)o);
    case "namespaceTerminating":
      return Project.staticSearchNamespaceTerminating(siteRequest_, (Boolean)o);
      default:
        return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrProject(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrProject(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "tenantResource":
      return Project.staticSearchStrTenantResource(siteRequest_, (String)o);
    case "localClusterName":
      return Project.staticSearchStrLocalClusterName(siteRequest_, (String)o);
    case "hubId":
      return Project.staticSearchStrHubId(siteRequest_, (String)o);
    case "hubResource":
      return Project.staticSearchStrHubResource(siteRequest_, (String)o);
    case "clusterName":
      return Project.staticSearchStrClusterName(siteRequest_, (String)o);
    case "clusterResource":
      return Project.staticSearchStrClusterResource(siteRequest_, (String)o);
    case "projectName":
      return Project.staticSearchStrProjectName(siteRequest_, (String)o);
    case "projectResource":
      return Project.staticSearchStrProjectResource(siteRequest_, (String)o);
    case "projectDisplayName":
      return Project.staticSearchStrProjectDisplayName(siteRequest_, (String)o);
    case "description":
      return Project.staticSearchStrDescription(siteRequest_, (String)o);
    case "gpuEnabled":
      return Project.staticSearchStrGpuEnabled(siteRequest_, (Boolean)o);
    case "podRestartCount":
      return Project.staticSearchStrPodRestartCount(siteRequest_, (Integer)o);
    case "podsRestarting":
      return Project.staticSearchStrPodsRestarting(siteRequest_, (String)o);
    case "podTerminatingCount":
      return Project.staticSearchStrPodTerminatingCount(siteRequest_, (Integer)o);
    case "podsTerminating":
      return Project.staticSearchStrPodsTerminating(siteRequest_, (String)o);
    case "fullPvcsCount":
      return Project.staticSearchStrFullPvcsCount(siteRequest_, (Integer)o);
    case "fullPvcs":
      return Project.staticSearchStrFullPvcs(siteRequest_, (String)o);
    case "namespaceTerminating":
      return Project.staticSearchStrNamespaceTerminating(siteRequest_, (Boolean)o);
      default:
        return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqProject(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqProject(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "tenantResource":
      return Project.staticSearchFqTenantResource(siteRequest_, o);
    case "localClusterName":
      return Project.staticSearchFqLocalClusterName(siteRequest_, o);
    case "hubId":
      return Project.staticSearchFqHubId(siteRequest_, o);
    case "hubResource":
      return Project.staticSearchFqHubResource(siteRequest_, o);
    case "clusterName":
      return Project.staticSearchFqClusterName(siteRequest_, o);
    case "clusterResource":
      return Project.staticSearchFqClusterResource(siteRequest_, o);
    case "projectName":
      return Project.staticSearchFqProjectName(siteRequest_, o);
    case "projectResource":
      return Project.staticSearchFqProjectResource(siteRequest_, o);
    case "projectDisplayName":
      return Project.staticSearchFqProjectDisplayName(siteRequest_, o);
    case "description":
      return Project.staticSearchFqDescription(siteRequest_, o);
    case "gpuEnabled":
      return Project.staticSearchFqGpuEnabled(siteRequest_, o);
    case "podRestartCount":
      return Project.staticSearchFqPodRestartCount(siteRequest_, o);
    case "podsRestarting":
      return Project.staticSearchFqPodsRestarting(siteRequest_, o);
    case "podTerminatingCount":
      return Project.staticSearchFqPodTerminatingCount(siteRequest_, o);
    case "podsTerminating":
      return Project.staticSearchFqPodsTerminating(siteRequest_, o);
    case "fullPvcsCount":
      return Project.staticSearchFqFullPvcsCount(siteRequest_, o);
    case "fullPvcs":
      return Project.staticSearchFqFullPvcs(siteRequest_, o);
    case "namespaceTerminating":
      return Project.staticSearchFqNamespaceTerminating(siteRequest_, o);
      default:
        return BaseModel.staticSearchFqBaseModel(entityVar,  siteRequest_, o);
    }
  }

  /////////////
  // persist //
  /////////////

  @Override public boolean persistForClass(String var, Object val) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    if(val != null) {
      for(String v : vars) {
        if(o == null)
          o = persistProject(v, val);
        else if(o instanceof BaseModel) {
          BaseModel oBaseModel = (BaseModel)o;
          o = oBaseModel.persistForClass(v, val);
        }
      }
    }
    return o != null;
  }
  public Object persistProject(String var, Object val) {
    String varLower = var.toLowerCase();
      if("tenantresource".equals(varLower)) {
        if(val instanceof String) {
          setTenantResource((String)val);
        }
        saves.add("tenantResource");
        return val;
      } else if("localclustername".equals(varLower)) {
        if(val instanceof String) {
          setLocalClusterName((String)val);
        }
        saves.add("localClusterName");
        return val;
      } else if("hubid".equals(varLower)) {
        if(val instanceof String) {
          setHubId((String)val);
        }
        saves.add("hubId");
        return val;
      } else if("hubresource".equals(varLower)) {
        if(val instanceof String) {
          setHubResource((String)val);
        }
        saves.add("hubResource");
        return val;
      } else if("clustername".equals(varLower)) {
        if(val instanceof String) {
          setClusterName((String)val);
        }
        saves.add("clusterName");
        return val;
      } else if("clusterresource".equals(varLower)) {
        if(val instanceof String) {
          setClusterResource((String)val);
        }
        saves.add("clusterResource");
        return val;
      } else if("projectname".equals(varLower)) {
        if(val instanceof String) {
          setProjectName((String)val);
        }
        saves.add("projectName");
        return val;
      } else if("projectresource".equals(varLower)) {
        if(val instanceof String) {
          setProjectResource((String)val);
        }
        saves.add("projectResource");
        return val;
      } else if("description".equals(varLower)) {
        if(val instanceof String) {
          setDescription((String)val);
        }
        saves.add("description");
        return val;
      } else if("gpuenabled".equals(varLower)) {
        if(val instanceof Boolean) {
          setGpuEnabled((Boolean)val);
        } else {
          setGpuEnabled(val == null ? null : val.toString());
        }
        saves.add("gpuEnabled");
        return val;
      } else if("podrestartcount".equals(varLower)) {
        if(val instanceof Integer) {
          setPodRestartCount((Integer)val);
        } else {
          setPodRestartCount(val == null ? null : val.toString());
        }
        saves.add("podRestartCount");
        return val;
      } else if("podsrestarting".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<String>)val).stream().forEach(v -> addPodsRestarting(v));
        } else if(val instanceof String[]) {
          Arrays.asList((String[])val).stream().forEach(v -> addPodsRestarting((String)v));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addPodsRestarting(staticSetPodsRestarting(siteRequest_, v.toString())));
        }
        if(!saves.contains("podsRestarting")) {
          saves.add("podsRestarting");
        }
        return val;
      } else if("podterminatingcount".equals(varLower)) {
        if(val instanceof Integer) {
          setPodTerminatingCount((Integer)val);
        } else {
          setPodTerminatingCount(val == null ? null : val.toString());
        }
        saves.add("podTerminatingCount");
        return val;
      } else if("podsterminating".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<String>)val).stream().forEach(v -> addPodsTerminating(v));
        } else if(val instanceof String[]) {
          Arrays.asList((String[])val).stream().forEach(v -> addPodsTerminating((String)v));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addPodsTerminating(staticSetPodsTerminating(siteRequest_, v.toString())));
        }
        if(!saves.contains("podsTerminating")) {
          saves.add("podsTerminating");
        }
        return val;
      } else if("fullpvcscount".equals(varLower)) {
        if(val instanceof Integer) {
          setFullPvcsCount((Integer)val);
        } else {
          setFullPvcsCount(val == null ? null : val.toString());
        }
        saves.add("fullPvcsCount");
        return val;
      } else if("fullpvcs".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<String>)val).stream().forEach(v -> addFullPvcs(v));
        } else if(val instanceof String[]) {
          Arrays.asList((String[])val).stream().forEach(v -> addFullPvcs((String)v));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addFullPvcs(staticSetFullPvcs(siteRequest_, v.toString())));
        }
        if(!saves.contains("fullPvcs")) {
          saves.add("fullPvcs");
        }
        return val;
      } else if("namespaceterminating".equals(varLower)) {
        if(val instanceof Boolean) {
          setNamespaceTerminating((Boolean)val);
        } else {
          setNamespaceTerminating(val == null ? null : val.toString());
        }
        saves.add("namespaceTerminating");
        return val;
    } else {
      return super.persistBaseModel(var, val);
    }
  }

  /////////////
  // populate //
  /////////////

  @Override public void populateForClass(SolrResponse.Doc doc) {
    populateProject(doc);
  }
  public void populateProject(SolrResponse.Doc doc) {
    Project oProject = (Project)this;
    saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
    if(saves != null) {

      String tenantResource = (String)doc.get("tenantResource_docvalues_string");
      if(tenantResource != null)
        oProject.setTenantResource(tenantResource);

      if(saves.contains("localClusterName")) {
        String localClusterName = (String)doc.get("localClusterName_docvalues_string");
        if(localClusterName != null)
          oProject.setLocalClusterName(localClusterName);
      }

      if(saves.contains("hubId")) {
        String hubId = (String)doc.get("hubId_docvalues_string");
        if(hubId != null)
          oProject.setHubId(hubId);
      }

      String hubResource = (String)doc.get("hubResource_docvalues_string");
      if(hubResource != null)
        oProject.setHubResource(hubResource);

      if(saves.contains("clusterName")) {
        String clusterName = (String)doc.get("clusterName_docvalues_string");
        if(clusterName != null)
          oProject.setClusterName(clusterName);
      }

      String clusterResource = (String)doc.get("clusterResource_docvalues_string");
      if(clusterResource != null)
        oProject.setClusterResource(clusterResource);

      if(saves.contains("projectName")) {
        String projectName = (String)doc.get("projectName_docvalues_string");
        if(projectName != null)
          oProject.setProjectName(projectName);
      }

      if(saves.contains("projectResource")) {
        String projectResource = (String)doc.get("projectResource_docvalues_string");
        if(projectResource != null)
          oProject.setProjectResource(projectResource);
      }

      if(saves.contains("projectDisplayName")) {
        String projectDisplayName = (String)doc.get("projectDisplayName_docvalues_string");
        if(projectDisplayName != null)
          oProject.setProjectDisplayName(projectDisplayName);
      }

      if(saves.contains("description")) {
        String description = (String)doc.get("description_docvalues_string");
        if(description != null)
          oProject.setDescription(description);
      }

      if(saves.contains("gpuEnabled")) {
        Boolean gpuEnabled = (Boolean)doc.get("gpuEnabled_docvalues_boolean");
        if(gpuEnabled != null)
          oProject.setGpuEnabled(gpuEnabled);
      }

      if(saves.contains("podRestartCount")) {
        Integer podRestartCount = (Integer)doc.get("podRestartCount_docvalues_int");
        if(podRestartCount != null)
          oProject.setPodRestartCount(podRestartCount);
      }

      if(saves.contains("podsRestarting")) {
        List<String> podsRestarting = (List<String>)doc.get("podsRestarting_docvalues_strings");
        if(podsRestarting != null) {
          podsRestarting.stream().forEach( v -> {
            oProject.podsRestarting.add(Project.staticSetPodsRestarting(siteRequest_, v));
          });
        }
      }

      if(saves.contains("podTerminatingCount")) {
        Integer podTerminatingCount = (Integer)doc.get("podTerminatingCount_docvalues_int");
        if(podTerminatingCount != null)
          oProject.setPodTerminatingCount(podTerminatingCount);
      }

      if(saves.contains("podsTerminating")) {
        List<String> podsTerminating = (List<String>)doc.get("podsTerminating_docvalues_strings");
        if(podsTerminating != null) {
          podsTerminating.stream().forEach( v -> {
            oProject.podsTerminating.add(Project.staticSetPodsTerminating(siteRequest_, v));
          });
        }
      }

      if(saves.contains("fullPvcsCount")) {
        Integer fullPvcsCount = (Integer)doc.get("fullPvcsCount_docvalues_int");
        if(fullPvcsCount != null)
          oProject.setFullPvcsCount(fullPvcsCount);
      }

      if(saves.contains("fullPvcs")) {
        List<String> fullPvcs = (List<String>)doc.get("fullPvcs_docvalues_strings");
        if(fullPvcs != null) {
          fullPvcs.stream().forEach( v -> {
            oProject.fullPvcs.add(Project.staticSetFullPvcs(siteRequest_, v));
          });
        }
      }

      if(saves.contains("namespaceTerminating")) {
        Boolean namespaceTerminating = (Boolean)doc.get("namespaceTerminating_docvalues_boolean");
        if(namespaceTerminating != null)
          oProject.setNamespaceTerminating(namespaceTerminating);
      }
    }

    super.populateBaseModel(doc);
  }

  public void indexProject(JsonObject doc) {
    if(tenantResource != null) {
      doc.put("tenantResource_docvalues_string", tenantResource);
    }
    if(localClusterName != null) {
      doc.put("localClusterName_docvalues_string", localClusterName);
    }
    if(hubId != null) {
      doc.put("hubId_docvalues_string", hubId);
    }
    if(hubResource != null) {
      doc.put("hubResource_docvalues_string", hubResource);
    }
    if(clusterName != null) {
      doc.put("clusterName_docvalues_string", clusterName);
    }
    if(clusterResource != null) {
      doc.put("clusterResource_docvalues_string", clusterResource);
    }
    if(projectName != null) {
      doc.put("projectName_docvalues_string", projectName);
    }
    if(projectResource != null) {
      doc.put("projectResource_docvalues_string", projectResource);
    }
    if(projectDisplayName != null) {
      doc.put("projectDisplayName_docvalues_string", projectDisplayName);
    }
    if(description != null) {
      doc.put("description_docvalues_string", description);
    }
    if(gpuEnabled != null) {
      doc.put("gpuEnabled_docvalues_boolean", gpuEnabled);
    }
    if(podRestartCount != null) {
      doc.put("podRestartCount_docvalues_int", podRestartCount);
    }
    if(podsRestarting != null) {
      JsonArray l = new JsonArray();
      doc.put("podsRestarting_docvalues_strings", l);
      for(String o : podsRestarting) {
        l.add(Project.staticSearchPodsRestarting(siteRequest_, o));
      }
    }
    if(podTerminatingCount != null) {
      doc.put("podTerminatingCount_docvalues_int", podTerminatingCount);
    }
    if(podsTerminating != null) {
      JsonArray l = new JsonArray();
      doc.put("podsTerminating_docvalues_strings", l);
      for(String o : podsTerminating) {
        l.add(Project.staticSearchPodsTerminating(siteRequest_, o));
      }
    }
    if(fullPvcsCount != null) {
      doc.put("fullPvcsCount_docvalues_int", fullPvcsCount);
    }
    if(fullPvcs != null) {
      JsonArray l = new JsonArray();
      doc.put("fullPvcs_docvalues_strings", l);
      for(String o : fullPvcs) {
        l.add(Project.staticSearchFullPvcs(siteRequest_, o));
      }
    }
    if(namespaceTerminating != null) {
      doc.put("namespaceTerminating_docvalues_boolean", namespaceTerminating);
    }
    super.indexBaseModel(doc);

	}

  public static String varStoredProject(String entityVar) {
    switch(entityVar) {
      case "tenantResource":
        return "tenantResource_docvalues_string";
      case "localClusterName":
        return "localClusterName_docvalues_string";
      case "hubId":
        return "hubId_docvalues_string";
      case "hubResource":
        return "hubResource_docvalues_string";
      case "clusterName":
        return "clusterName_docvalues_string";
      case "clusterResource":
        return "clusterResource_docvalues_string";
      case "projectName":
        return "projectName_docvalues_string";
      case "projectResource":
        return "projectResource_docvalues_string";
      case "projectDisplayName":
        return "projectDisplayName_docvalues_string";
      case "description":
        return "description_docvalues_string";
      case "gpuEnabled":
        return "gpuEnabled_docvalues_boolean";
      case "podRestartCount":
        return "podRestartCount_docvalues_int";
      case "podsRestarting":
        return "podsRestarting_docvalues_strings";
      case "podTerminatingCount":
        return "podTerminatingCount_docvalues_int";
      case "podsTerminating":
        return "podsTerminating_docvalues_strings";
      case "fullPvcsCount":
        return "fullPvcsCount_docvalues_int";
      case "fullPvcs":
        return "fullPvcs_docvalues_strings";
      case "namespaceTerminating":
        return "namespaceTerminating_docvalues_boolean";
      default:
        return BaseModel.varStoredBaseModel(entityVar);
    }
  }

  public static String varIndexedProject(String entityVar) {
    switch(entityVar) {
      case "tenantResource":
        return "tenantResource_docvalues_string";
      case "localClusterName":
        return "localClusterName_docvalues_string";
      case "hubId":
        return "hubId_docvalues_string";
      case "hubResource":
        return "hubResource_docvalues_string";
      case "clusterName":
        return "clusterName_docvalues_string";
      case "clusterResource":
        return "clusterResource_docvalues_string";
      case "projectName":
        return "projectName_docvalues_string";
      case "projectResource":
        return "projectResource_docvalues_string";
      case "projectDisplayName":
        return "projectDisplayName_docvalues_string";
      case "description":
        return "description_docvalues_string";
      case "gpuEnabled":
        return "gpuEnabled_docvalues_boolean";
      case "podRestartCount":
        return "podRestartCount_docvalues_int";
      case "podsRestarting":
        return "podsRestarting_docvalues_strings";
      case "podTerminatingCount":
        return "podTerminatingCount_docvalues_int";
      case "podsTerminating":
        return "podsTerminating_docvalues_strings";
      case "fullPvcsCount":
        return "fullPvcsCount_docvalues_int";
      case "fullPvcs":
        return "fullPvcs_docvalues_strings";
      case "namespaceTerminating":
        return "namespaceTerminating_docvalues_boolean";
      default:
        return BaseModel.varIndexedBaseModel(entityVar);
    }
  }

  public static String searchVarProject(String searchVar) {
    switch(searchVar) {
      case "tenantResource_docvalues_string":
        return "tenantResource";
      case "localClusterName_docvalues_string":
        return "localClusterName";
      case "hubId_docvalues_string":
        return "hubId";
      case "hubResource_docvalues_string":
        return "hubResource";
      case "clusterName_docvalues_string":
        return "clusterName";
      case "clusterResource_docvalues_string":
        return "clusterResource";
      case "projectName_docvalues_string":
        return "projectName";
      case "projectResource_docvalues_string":
        return "projectResource";
      case "projectDisplayName_docvalues_string":
        return "projectDisplayName";
      case "description_docvalues_string":
        return "description";
      case "gpuEnabled_docvalues_boolean":
        return "gpuEnabled";
      case "podRestartCount_docvalues_int":
        return "podRestartCount";
      case "podsRestarting_docvalues_strings":
        return "podsRestarting";
      case "podTerminatingCount_docvalues_int":
        return "podTerminatingCount";
      case "podsTerminating_docvalues_strings":
        return "podsTerminating";
      case "fullPvcsCount_docvalues_int":
        return "fullPvcsCount";
      case "fullPvcs_docvalues_strings":
        return "fullPvcs";
      case "namespaceTerminating_docvalues_boolean":
        return "namespaceTerminating";
      default:
        return BaseModel.searchVarBaseModel(searchVar);
    }
  }

  public static String varSearchProject(String entityVar) {
    switch(entityVar) {
      default:
        return BaseModel.varSearchBaseModel(entityVar);
    }
  }

  public static String varSuggestedProject(String entityVar) {
    switch(entityVar) {
      default:
        return BaseModel.varSuggestedBaseModel(entityVar);
    }
  }

  /////////////
  // store //
  /////////////

  @Override public void storeForClass(SolrResponse.Doc doc) {
    storeProject(doc);
  }
  public void storeProject(SolrResponse.Doc doc) {
    Project oProject = (Project)this;
    SiteRequest siteRequest = oProject.getSiteRequest_();

    oProject.setTenantResource(Optional.ofNullable(doc.get("tenantResource_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setLocalClusterName(Optional.ofNullable(doc.get("localClusterName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setHubId(Optional.ofNullable(doc.get("hubId_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setHubResource(Optional.ofNullable(doc.get("hubResource_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setClusterName(Optional.ofNullable(doc.get("clusterName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setClusterResource(Optional.ofNullable(doc.get("clusterResource_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setProjectName(Optional.ofNullable(doc.get("projectName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setProjectResource(Optional.ofNullable(doc.get("projectResource_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setProjectDisplayName(Optional.ofNullable(doc.get("projectDisplayName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
    oProject.setGpuEnabled(Optional.ofNullable(doc.get("gpuEnabled_docvalues_boolean")).map(v -> v.toString()).orElse(null));
    oProject.setPodRestartCount(Optional.ofNullable(doc.get("podRestartCount_docvalues_int")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("podsRestarting_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oProject.addPodsRestarting(Project.staticSetPodsRestarting(siteRequest, v.toString()));
    });
    oProject.setPodTerminatingCount(Optional.ofNullable(doc.get("podTerminatingCount_docvalues_int")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("podsTerminating_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oProject.addPodsTerminating(Project.staticSetPodsTerminating(siteRequest, v.toString()));
    });
    oProject.setFullPvcsCount(Optional.ofNullable(doc.get("fullPvcsCount_docvalues_int")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("fullPvcs_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oProject.addFullPvcs(Project.staticSetFullPvcs(siteRequest, v.toString()));
    });
    oProject.setNamespaceTerminating(Optional.ofNullable(doc.get("namespaceTerminating_docvalues_boolean")).map(v -> v.toString()).orElse(null));

    super.storeBaseModel(doc);
  }

  //////////////////
  // apiRequest //
  //////////////////

  public void apiRequestProject() {
    ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
    Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
    if(o != null && o instanceof Project) {
      Project original = (Project)o;
      if(!Objects.equals(tenantResource, original.getTenantResource()))
        apiRequest.addVars("tenantResource");
      if(!Objects.equals(localClusterName, original.getLocalClusterName()))
        apiRequest.addVars("localClusterName");
      if(!Objects.equals(hubId, original.getHubId()))
        apiRequest.addVars("hubId");
      if(!Objects.equals(hubResource, original.getHubResource()))
        apiRequest.addVars("hubResource");
      if(!Objects.equals(clusterName, original.getClusterName()))
        apiRequest.addVars("clusterName");
      if(!Objects.equals(clusterResource, original.getClusterResource()))
        apiRequest.addVars("clusterResource");
      if(!Objects.equals(projectName, original.getProjectName()))
        apiRequest.addVars("projectName");
      if(!Objects.equals(projectResource, original.getProjectResource()))
        apiRequest.addVars("projectResource");
      if(!Objects.equals(projectDisplayName, original.getProjectDisplayName()))
        apiRequest.addVars("projectDisplayName");
      if(!Objects.equals(description, original.getDescription()))
        apiRequest.addVars("description");
      if(!Objects.equals(gpuEnabled, original.getGpuEnabled()))
        apiRequest.addVars("gpuEnabled");
      if(!Objects.equals(podRestartCount, original.getPodRestartCount()))
        apiRequest.addVars("podRestartCount");
      if(!Objects.equals(podsRestarting, original.getPodsRestarting()))
        apiRequest.addVars("podsRestarting");
      if(!Objects.equals(podTerminatingCount, original.getPodTerminatingCount()))
        apiRequest.addVars("podTerminatingCount");
      if(!Objects.equals(podsTerminating, original.getPodsTerminating()))
        apiRequest.addVars("podsTerminating");
      if(!Objects.equals(fullPvcsCount, original.getFullPvcsCount()))
        apiRequest.addVars("fullPvcsCount");
      if(!Objects.equals(fullPvcs, original.getFullPvcs()))
        apiRequest.addVars("fullPvcs");
      if(!Objects.equals(namespaceTerminating, original.getNamespaceTerminating()))
        apiRequest.addVars("namespaceTerminating");
      super.apiRequestBaseModel();
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append(Optional.ofNullable(tenantResource).map(v -> "tenantResource: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(localClusterName).map(v -> "localClusterName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(hubId).map(v -> "hubId: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(hubResource).map(v -> "hubResource: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(clusterName).map(v -> "clusterName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(clusterResource).map(v -> "clusterResource: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(projectName).map(v -> "projectName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(projectResource).map(v -> "projectResource: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(projectDisplayName).map(v -> "projectDisplayName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(description).map(v -> "description: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(gpuEnabled).map(v -> "gpuEnabled: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(podRestartCount).map(v -> "podRestartCount: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(podsRestarting).map(v -> "podsRestarting: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(podTerminatingCount).map(v -> "podTerminatingCount: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(podsTerminating).map(v -> "podsTerminating: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(fullPvcsCount).map(v -> "fullPvcsCount: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(fullPvcs).map(v -> "fullPvcs: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(namespaceTerminating).map(v -> "namespaceTerminating: " + v + "\n").orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "Project";
  public static final String CLASS_CANONICAL_NAME = "org.mghpcc.aitelemetry.model.project.Project";
  public static final String CLASS_AUTH_RESOURCE = "PROJECT";
  public static final String CLASS_API_ADDRESS_Project = "ai-telemetry-enUS-Project";
  public static String getClassApiAddress() {
    return CLASS_API_ADDRESS_Project;
  }
  public static final String VAR_tenantResource = "tenantResource";
  public static final String VAR_localClusterName = "localClusterName";
  public static final String VAR_hubId = "hubId";
  public static final String VAR_hubResource = "hubResource";
  public static final String VAR_clusterName = "clusterName";
  public static final String VAR_clusterResource = "clusterResource";
  public static final String VAR_projectName = "projectName";
  public static final String VAR_projectResource = "projectResource";
  public static final String VAR_projectDisplayName = "projectDisplayName";
  public static final String VAR_description = "description";
  public static final String VAR_gpuEnabled = "gpuEnabled";
  public static final String VAR_podRestartCount = "podRestartCount";
  public static final String VAR_podsRestarting = "podsRestarting";
  public static final String VAR_podTerminatingCount = "podTerminatingCount";
  public static final String VAR_podsTerminating = "podsTerminating";
  public static final String VAR_fullPvcsCount = "fullPvcsCount";
  public static final String VAR_fullPvcs = "fullPvcs";
  public static final String VAR_namespaceTerminating = "namespaceTerminating";

  public static List<String> varsQForClass() {
    return Project.varsQProject(new ArrayList<String>());
  }
  public static List<String> varsQProject(List<String> vars) {
    BaseModel.varsQBaseModel(vars);
    return vars;
  }

  public static List<String> varsFqForClass() {
    return Project.varsFqProject(new ArrayList<String>());
  }
  public static List<String> varsFqProject(List<String> vars) {
    vars.add(VAR_localClusterName);
    vars.add(VAR_hubId);
    vars.add(VAR_hubResource);
    vars.add(VAR_clusterName);
    vars.add(VAR_clusterResource);
    vars.add(VAR_projectName);
    vars.add(VAR_projectResource);
    vars.add(VAR_projectDisplayName);
    vars.add(VAR_description);
    vars.add(VAR_gpuEnabled);
    vars.add(VAR_podRestartCount);
    vars.add(VAR_podsRestarting);
    vars.add(VAR_podTerminatingCount);
    vars.add(VAR_podsTerminating);
    vars.add(VAR_fullPvcsCount);
    vars.add(VAR_fullPvcs);
    vars.add(VAR_namespaceTerminating);
    BaseModel.varsFqBaseModel(vars);
    return vars;
  }

  public static List<String> varsRangeForClass() {
    return Project.varsRangeProject(new ArrayList<String>());
  }
  public static List<String> varsRangeProject(List<String> vars) {
    vars.add(VAR_podRestartCount);
    vars.add(VAR_podTerminatingCount);
    vars.add(VAR_fullPvcsCount);
    BaseModel.varsRangeBaseModel(vars);
    return vars;
  }

  public static final String DISPLAY_NAME_tenantResource = "tenant auth resource";
  public static final String DISPLAY_NAME_localClusterName = "ACM cluster name";
  public static final String DISPLAY_NAME_hubId = "ACM Hub";
  public static final String DISPLAY_NAME_hubResource = "hub auth resource";
  public static final String DISPLAY_NAME_clusterName = "cluster name";
  public static final String DISPLAY_NAME_clusterResource = "cluster auth resource";
  public static final String DISPLAY_NAME_projectName = "project name";
  public static final String DISPLAY_NAME_projectResource = "project auth resource";
  public static final String DISPLAY_NAME_projectDisplayName = "project display name";
  public static final String DISPLAY_NAME_description = "description";
  public static final String DISPLAY_NAME_gpuEnabled = "GPU enabled";
  public static final String DISPLAY_NAME_podRestartCount = "pod restarts";
  public static final String DISPLAY_NAME_podsRestarting = "pods restarting";
  public static final String DISPLAY_NAME_podTerminatingCount = "pods terminating";
  public static final String DISPLAY_NAME_podsTerminating = "pods terminating";
  public static final String DISPLAY_NAME_fullPvcsCount = "Full PVCs count";
  public static final String DISPLAY_NAME_fullPvcs = "pods restarting";
  public static final String DISPLAY_NAME_namespaceTerminating = "namespace terminating";

  @Override
  public String idForClass() {
    return projectResource;
  }

  @Override
  public String titleForClass() {
    return objectTitle;
  }

  @Override
  public String nameForClass() {
    return projectDisplayName;
  }

  @Override
  public String classNameAdjectiveSingularForClass() {
    return Project.NameAdjectiveSingular_enUS;
  }

  @Override
  public String descriptionForClass() {
    return description;
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/project/%s";
  }

  @Override
  public String enUSStringFormatUrlDisplayPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlUserPageForClass() {
    return "%s/en-us/user/project/%s";
  }

  @Override
  public String enUSStringFormatUrlDownloadForClass() {
    return null;
  }

  public static String displayNameForClass(String var) {
    return Project.displayNameProject(var);
  }
  public static String displayNameProject(String var) {
    switch(var) {
    case VAR_tenantResource:
      return DISPLAY_NAME_tenantResource;
    case VAR_localClusterName:
      return DISPLAY_NAME_localClusterName;
    case VAR_hubId:
      return DISPLAY_NAME_hubId;
    case VAR_hubResource:
      return DISPLAY_NAME_hubResource;
    case VAR_clusterName:
      return DISPLAY_NAME_clusterName;
    case VAR_clusterResource:
      return DISPLAY_NAME_clusterResource;
    case VAR_projectName:
      return DISPLAY_NAME_projectName;
    case VAR_projectResource:
      return DISPLAY_NAME_projectResource;
    case VAR_projectDisplayName:
      return DISPLAY_NAME_projectDisplayName;
    case VAR_description:
      return DISPLAY_NAME_description;
    case VAR_gpuEnabled:
      return DISPLAY_NAME_gpuEnabled;
    case VAR_podRestartCount:
      return DISPLAY_NAME_podRestartCount;
    case VAR_podsRestarting:
      return DISPLAY_NAME_podsRestarting;
    case VAR_podTerminatingCount:
      return DISPLAY_NAME_podTerminatingCount;
    case VAR_podsTerminating:
      return DISPLAY_NAME_podsTerminating;
    case VAR_fullPvcsCount:
      return DISPLAY_NAME_fullPvcsCount;
    case VAR_fullPvcs:
      return DISPLAY_NAME_fullPvcs;
    case VAR_namespaceTerminating:
      return DISPLAY_NAME_namespaceTerminating;
    default:
      return BaseModel.displayNameBaseModel(var);
    }
  }

  public static String descriptionProject(String var) {
    if(var == null)
      return null;
    switch(var) {
    case VAR_tenantResource:
      return "The unique authorization resource for the tenant for multi-tenancy";
    case VAR_localClusterName:
      return "The actual name of the ACM local cluster. ";
    case VAR_hubId:
      return "The name of the ACM Hub for this cluster in Prometheus Keycloak Proxy. ";
    case VAR_hubResource:
      return "The unique authorization resource for the hub for multi-tenancy";
    case VAR_clusterName:
      return "The name of this cluster";
    case VAR_clusterResource:
      return "The unique authorization resource for the cluster for multi-tenancy";
    case VAR_projectName:
      return "The name of this project";
    case VAR_projectResource:
      return "The unique authorization resource for the project for multi-tenancy";
    case VAR_projectDisplayName:
      return "The display name of this project";
    case VAR_description:
      return "A description of this project";
    case VAR_gpuEnabled:
      return "Whether GPUs are enabled for this project. ";
    case VAR_podRestartCount:
      return "The number of pod restarts in this project. ";
    case VAR_podsRestarting:
      return "The names of the pods restarting in this project. ";
    case VAR_podTerminatingCount:
      return "The number of pods terminating in this project. ";
    case VAR_podsTerminating:
      return "The names of the pods terminating in this project. ";
    case VAR_fullPvcsCount:
      return "The number of persistent volume claims that are running out of disk space in this project. ";
    case VAR_fullPvcs:
      return "The names of the persistent volume claims that are running out of disk space in this project. ";
    case VAR_namespaceTerminating:
      return "Whether namespace is stuck in terminating status. ";
      default:
        return BaseModel.descriptionBaseModel(var);
    }
  }

  public static String classSimpleNameProject(String var) {
    switch(var) {
    case VAR_tenantResource:
      return "String";
    case VAR_localClusterName:
      return "String";
    case VAR_hubId:
      return "String";
    case VAR_hubResource:
      return "String";
    case VAR_clusterName:
      return "String";
    case VAR_clusterResource:
      return "String";
    case VAR_projectName:
      return "String";
    case VAR_projectResource:
      return "String";
    case VAR_projectDisplayName:
      return "String";
    case VAR_description:
      return "String";
    case VAR_gpuEnabled:
      return "Boolean";
    case VAR_podRestartCount:
      return "Integer";
    case VAR_podsRestarting:
      return "List";
    case VAR_podTerminatingCount:
      return "Integer";
    case VAR_podsTerminating:
      return "List";
    case VAR_fullPvcsCount:
      return "Integer";
    case VAR_fullPvcs:
      return "List";
    case VAR_namespaceTerminating:
      return "Boolean";
      default:
        return BaseModel.classSimpleNameBaseModel(var);
    }
  }

  public static Integer htmColumnProject(String var) {
    switch(var) {
    case VAR_hubId:
      return 1;
    case VAR_clusterName:
      return 2;
    case VAR_projectName:
      return 3;
      default:
        return BaseModel.htmColumnBaseModel(var);
    }
  }

  public static Integer htmRowProject(String var) {
    switch(var) {
    case VAR_tenantResource:
      return 3;
    case VAR_hubId:
      return 3;
    case VAR_clusterName:
      return 3;
    case VAR_projectName:
      return 3;
    case VAR_description:
      return 3;
    case VAR_gpuEnabled:
      return 3;
    case VAR_podRestartCount:
      return 4;
    case VAR_podsRestarting:
      return 4;
    case VAR_podTerminatingCount:
      return 4;
    case VAR_podsTerminating:
      return 4;
    case VAR_fullPvcsCount:
      return 4;
    case VAR_fullPvcs:
      return 4;
    case VAR_namespaceTerminating:
      return 4;
      default:
        return BaseModel.htmRowBaseModel(var);
    }
  }

  public static Integer htmCellProject(String var) {
    switch(var) {
    case VAR_tenantResource:
      return 0;
    case VAR_hubId:
      return 1;
    case VAR_clusterName:
      return 3;
    case VAR_projectName:
      return 5;
    case VAR_description:
      return 7;
    case VAR_gpuEnabled:
      return 8;
    case VAR_podRestartCount:
      return 0;
    case VAR_podsRestarting:
      return 1;
    case VAR_podTerminatingCount:
      return 1;
    case VAR_podsTerminating:
      return 2;
    case VAR_fullPvcsCount:
      return 3;
    case VAR_fullPvcs:
      return 4;
    case VAR_namespaceTerminating:
      return 5;
      default:
        return BaseModel.htmCellBaseModel(var);
    }
  }

  public static Integer lengthMinProject(String var) {
    switch(var) {
      default:
        return BaseModel.lengthMinBaseModel(var);
    }
  }

  public static Integer lengthMaxProject(String var) {
    switch(var) {
      default:
        return BaseModel.lengthMaxBaseModel(var);
    }
  }

  public static Integer maxProject(String var) {
    switch(var) {
      default:
        return BaseModel.maxBaseModel(var);
    }
  }

  public static Integer minProject(String var) {
    switch(var) {
      default:
        return BaseModel.minBaseModel(var);
    }
  }
}

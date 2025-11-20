package org.mghpcc.aitelemetry.model.virtualmachine;

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
import org.mghpcc.aitelemetry.model.hub.Hub;
import org.mghpcc.aitelemetry.model.cluster.Cluster;
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Point;
import org.computate.vertx.serialize.pgclient.PgClientPointSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPointDeserializer;
import org.computate.vertx.tool.VertxTool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class VirtualMachineGen into the class VirtualMachine. 
 * </li>
 * <h3>About the VirtualMachine class and it's generated class VirtualMachineGen&lt;BaseModel&gt;: </h3>extends VirtualMachineGen
 * <p>
 * This Java class extends a generated Java class VirtualMachineGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine">Find the class VirtualMachine in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends VirtualMachineGen<BaseModel>
 * <p>This <code>class VirtualMachine extends VirtualMachineGen&lt;BaseModel&gt;</code>, which means it extends a newly generated VirtualMachineGen. 
 * The generated <code>class VirtualMachineGen extends BaseModel</code> which means that VirtualMachine extends VirtualMachineGen which extends BaseModel. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <p>This class contains a comment <b>"Api: true"</b>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiMethode: Search</h2>
 * <p>This class contains a comment <b>"ApiMethod: Search"</b>, which creates an API "Search". 
 * </p>
 * <h2>ApiMethode: GET</h2>
 * <p>This class contains a comment <b>"ApiMethod: GET"</b>, which creates an API "GET". 
 * </p>
 * <h2>ApiMethode: PATCH</h2>
 * <p>This class contains a comment <b>"ApiMethod: PATCH"</b>, which creates an API "PATCH". 
 * </p>
 * <h2>ApiMethode: POST</h2>
 * <p>This class contains a comment <b>"ApiMethod: POST"</b>, which creates an API "POST". 
 * </p>
 * <h2>ApiMethode: DELETE</h2>
 * <p>This class contains a comment <b>"ApiMethod: DELETE"</b>, which creates an API "DELETE". 
 * </p>
 * <h2>ApiMethode: PUTImport</h2>
 * <p>This class contains a comment <b>"ApiMethod: PUTImport"</b>, which creates an API "PUTImport". 
 * </p>
 * <h2>ApiMethode: SearchPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: SearchPage"</b>, which creates an API "SearchPage". 
 * </p>
 * <h2>ApiMethode: EditPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: EditPage"</b>, which creates an API "EditPage". 
 * </p>
 * <h2>ApiMethode: UserPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: UserPage"</b>, which creates an API "UserPage". 
 * </p>
 * <h2>ApiMethode: DELETEFilter</h2>
 * <p>This class contains a comment <b>"ApiMethod: DELETEFilter"</b>, which creates an API "DELETEFilter". 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <b>"ApiTag: virtual machines"</b>, which groups all of the OpenAPIs for VirtualMachine objects under the tag "virtual machines". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/vm</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/vm"</b>, which defines the base API URI for VirtualMachine objects as "/en-us/api/vm" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the VirtualMachine class will inherit the helpful inherited class comments from the super class VirtualMachineGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the VirtualMachine API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 17</h2>
 * <p>This class contains a comment <b>"Order: 17"</b>, which means this class will be sorted by the given number 17 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 17</h2>
 * <p>This class contains a comment <b>"SqlOrder: 17"</b>, which means this class will be sorted by the given number 17 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <b>"Model: true"</b>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachinePage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachinePage extends org.mghpcc.aitelemetry.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the VirtualMachine Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a virtual machine</h2>
 * <p>This class contains a comment <b>"AName.enUS: a virtual machine"</b>, which identifies the language context to describe a VirtualMachine as "a virtual machine". 
 * </p>
 * <p>
 * Delete the class VirtualMachine in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.mghpcc.aitelemetry.model.virtualmachine in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project ai-telemetry in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:ai\-telemetry&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class VirtualMachineGen<DEV> extends BaseModel {
  protected static final Logger LOG = LoggerFactory.getLogger(VirtualMachine.class);

  public static final String Description_enUS = "A Red Hat OpenShift virtual machine";
  public static final String AName_enUS = "a virtual machine";
  public static final String This_enUS = "this ";
  public static final String ThisName_enUS = "this virtual machine";
  public static final String A_enUS = "a ";
  public static final String TheName_enUS = "the virtual machine";
  public static final String SingularName_enUS = "virtual machine";
  public static final String PluralName_enUS = "virtual machines";
  public static final String NameActual_enUS = "current virtual machine";
  public static final String AllName_enUS = "all virtual machines";
  public static final String SearchAllNameBy_enUS = "search virtual machines by ";
  public static final String SearchAllName_enUS = "search virtual machines";
  public static final String Title_enUS = "virtual machines";
  public static final String ThePluralName_enUS = "the virtual machines";
  public static final String NoNameFound_enUS = "no virtual machine found";
  public static final String ApiUri_enUS = "/en-us/api/vm";
  public static final String ApiUriSearchPage_enUS = "/en-us/search/vm";
  public static final String ApiUriEditPage_enUS = "/en-us/edit/vm/{vmResource}";
  public static final String OfName_enUS = "of virtual machine";
  public static final String ANameAdjective_enUS = "a virtual machine";
  public static final String NameAdjectiveSingular_enUS = "virtual machine";
  public static final String NameAdjectivePlural_enUS = "virtual machines";
  public static final String Search_enUS_OpenApiUri = "/en-us/api/vm";
  public static final String Search_enUS_StringFormatUri = "/en-us/api/vm";
  public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/vm";
  public static final String GET_enUS_OpenApiUri = "/en-us/api/vm/{vmResource}";
  public static final String GET_enUS_StringFormatUri = "/en-us/api/vm/%s";
  public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/vm/%s";
  public static final String PATCH_enUS_OpenApiUri = "/en-us/api/vm";
  public static final String PATCH_enUS_StringFormatUri = "/en-us/api/vm";
  public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/vm";
  public static final String POST_enUS_OpenApiUri = "/en-us/api/vm";
  public static final String POST_enUS_StringFormatUri = "/en-us/api/vm";
  public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/vm";
  public static final String DELETE_enUS_OpenApiUri = "/en-us/api/vm/{vmResource}";
  public static final String DELETE_enUS_StringFormatUri = "/en-us/api/vm/%s";
  public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/vm/%s";
  public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/vm-import";
  public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/vm-import";
  public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/vm-import";
  public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/vm";
  public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/vm";
  public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/vm";
  public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/vm/{vmResource}";
  public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/vm/%s";
  public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/vm/%s";
  public static final String UserPage_enUS_OpenApiUri = "/en-us/user/vm/{vmResource}";
  public static final String UserPage_enUS_StringFormatUri = "/en-us/user/vm/%s";
  public static final String UserPage_enUS_StringFormatUrl = "%s/en-us/user/vm/%s";
  public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/vm";
  public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/vm";
  public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/vm";

  public static final String Icon = "<i class=\"fa-regular fa-sidebar\"></i>";
  public static final Integer Rows = 100;

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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:hubId">Find the entity hubId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _hubId(Wrap<String> w);

  public String getHubId() {
    return hubId;
  }
  public void setHubId(String o) {
    this.hubId = VirtualMachine.staticSetHubId(siteRequest_, o);
  }
  public static String staticSetHubId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine hubIdInit() {
    Wrap<String> hubIdWrap = new Wrap<String>().var("hubId");
    if(hubId == null) {
      _hubId(hubIdWrap);
      Optional.ofNullable(hubIdWrap.getO()).ifPresent(o -> {
        setHubId(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchHubId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrHubId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqHubId(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchHubId(siteRequest_, VirtualMachine.staticSetHubId(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:hubResource">Find the entity hubResource in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _hubResource(Wrap<String> w);

  public String getHubResource() {
    return hubResource;
  }
  public void setHubResource(String o) {
    this.hubResource = VirtualMachine.staticSetHubResource(siteRequest_, o);
  }
  public static String staticSetHubResource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine hubResourceInit() {
    Wrap<String> hubResourceWrap = new Wrap<String>().var("hubResource");
    if(hubResource == null) {
      _hubResource(hubResourceWrap);
      Optional.ofNullable(hubResourceWrap.getO()).ifPresent(o -> {
        setHubResource(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchHubResource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrHubResource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqHubResource(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchHubResource(siteRequest_, VirtualMachine.staticSetHubResource(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:clusterName">Find the entity clusterName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _clusterName(Wrap<String> w);

  public String getClusterName() {
    return clusterName;
  }
  public void setClusterName(String o) {
    this.clusterName = VirtualMachine.staticSetClusterName(siteRequest_, o);
  }
  public static String staticSetClusterName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine clusterNameInit() {
    Wrap<String> clusterNameWrap = new Wrap<String>().var("clusterName");
    if(clusterName == null) {
      _clusterName(clusterNameWrap);
      Optional.ofNullable(clusterNameWrap.getO()).ifPresent(o -> {
        setClusterName(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchClusterName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClusterName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClusterName(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchClusterName(siteRequest_, VirtualMachine.staticSetClusterName(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:clusterResource">Find the entity clusterResource in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _clusterResource(Wrap<String> w);

  public String getClusterResource() {
    return clusterResource;
  }
  public void setClusterResource(String o) {
    this.clusterResource = VirtualMachine.staticSetClusterResource(siteRequest_, o);
  }
  public static String staticSetClusterResource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine clusterResourceInit() {
    Wrap<String> clusterResourceWrap = new Wrap<String>().var("clusterResource");
    if(clusterResource == null) {
      _clusterResource(clusterResourceWrap);
      Optional.ofNullable(clusterResourceWrap.getO()).ifPresent(o -> {
        setClusterResource(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchClusterResource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClusterResource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClusterResource(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchClusterResource(siteRequest_, VirtualMachine.staticSetClusterResource(siteRequest_, o)).toString();
  }

  public String sqlClusterResource() {
    return clusterResource;
  }

  public static String staticJsonClusterResource(String clusterResource) {
    return clusterResource;
  }

	///////////////
  // vmProject //
	///////////////


  /**
   *  The entity vmProject
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String vmProject;

  /**
   * <br> The entity vmProject
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:vmProject">Find the entity vmProject in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _vmProject(Wrap<String> w);

  public String getVmProject() {
    return vmProject;
  }
  public void setVmProject(String o) {
    this.vmProject = VirtualMachine.staticSetVmProject(siteRequest_, o);
  }
  public static String staticSetVmProject(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine vmProjectInit() {
    Wrap<String> vmProjectWrap = new Wrap<String>().var("vmProject");
    if(vmProject == null) {
      _vmProject(vmProjectWrap);
      Optional.ofNullable(vmProjectWrap.getO()).ifPresent(o -> {
        setVmProject(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchVmProject(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrVmProject(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVmProject(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchVmProject(siteRequest_, VirtualMachine.staticSetVmProject(siteRequest_, o)).toString();
  }

  public String sqlVmProject() {
    return vmProject;
  }

  public static String staticJsonVmProject(String vmProject) {
    return vmProject;
  }

	////////////
  // vmName //
	////////////


  /**
   *  The entity vmName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String vmName;

  /**
   * <br> The entity vmName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:vmName">Find the entity vmName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _vmName(Wrap<String> w);

  public String getVmName() {
    return vmName;
  }
  public void setVmName(String o) {
    this.vmName = VirtualMachine.staticSetVmName(siteRequest_, o);
  }
  public static String staticSetVmName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine vmNameInit() {
    Wrap<String> vmNameWrap = new Wrap<String>().var("vmName");
    if(vmName == null) {
      _vmName(vmNameWrap);
      Optional.ofNullable(vmNameWrap.getO()).ifPresent(o -> {
        setVmName(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchVmName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrVmName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVmName(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchVmName(siteRequest_, VirtualMachine.staticSetVmName(siteRequest_, o)).toString();
  }

  public String sqlVmName() {
    return vmName;
  }

  public static String staticJsonVmName(String vmName) {
    return vmName;
  }

	////////
  // os //
	////////


  /**
   *  The entity os
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String os;

  /**
   * <br> The entity os
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:os">Find the entity os in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _os(Wrap<String> w);

  public String getOs() {
    return os;
  }
  public void setOs(String o) {
    this.os = VirtualMachine.staticSetOs(siteRequest_, o);
  }
  public static String staticSetOs(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine osInit() {
    Wrap<String> osWrap = new Wrap<String>().var("os");
    if(os == null) {
      _os(osWrap);
      Optional.ofNullable(osWrap.getO()).ifPresent(o -> {
        setOs(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchOs(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrOs(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOs(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchOs(siteRequest_, VirtualMachine.staticSetOs(siteRequest_, o)).toString();
  }

  public String sqlOs() {
    return os;
  }

  public static String staticJsonOs(String os) {
    return os;
  }

	////////////////
  // vmResource //
	////////////////


  /**
   *  The entity vmResource
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String vmResource;

  /**
   * <br> The entity vmResource
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:vmResource">Find the entity vmResource in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _vmResource(Wrap<String> w);

  public String getVmResource() {
    return vmResource;
  }
  public void setVmResource(String o) {
    this.vmResource = VirtualMachine.staticSetVmResource(siteRequest_, o);
  }
  public static String staticSetVmResource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine vmResourceInit() {
    Wrap<String> vmResourceWrap = new Wrap<String>().var("vmResource");
    if(vmResource == null) {
      _vmResource(vmResourceWrap);
      Optional.ofNullable(vmResourceWrap.getO()).ifPresent(o -> {
        setVmResource(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchVmResource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrVmResource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVmResource(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchVmResource(siteRequest_, VirtualMachine.staticSetVmResource(siteRequest_, o)).toString();
  }

  public String sqlVmResource() {
    return vmResource;
  }

  public static String staticJsonVmResource(String vmResource) {
    return vmResource;
  }

	///////////////////
  // vmDisplayName //
	///////////////////


  /**
   *  The entity vmDisplayName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String vmDisplayName;

  /**
   * <br> The entity vmDisplayName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:vmDisplayName">Find the entity vmDisplayName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _vmDisplayName(Wrap<String> w);

  public String getVmDisplayName() {
    return vmDisplayName;
  }
  public void setVmDisplayName(String o) {
    this.vmDisplayName = VirtualMachine.staticSetVmDisplayName(siteRequest_, o);
  }
  public static String staticSetVmDisplayName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine vmDisplayNameInit() {
    Wrap<String> vmDisplayNameWrap = new Wrap<String>().var("vmDisplayName");
    if(vmDisplayName == null) {
      _vmDisplayName(vmDisplayNameWrap);
      Optional.ofNullable(vmDisplayNameWrap.getO()).ifPresent(o -> {
        setVmDisplayName(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchVmDisplayName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrVmDisplayName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVmDisplayName(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchVmDisplayName(siteRequest_, VirtualMachine.staticSetVmDisplayName(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _description(Wrap<String> w);

  public String getDescription() {
    return description;
  }
  public void setDescription(String o) {
    this.description = VirtualMachine.staticSetDescription(siteRequest_, o);
  }
  public static String staticSetDescription(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine descriptionInit() {
    Wrap<String> descriptionWrap = new Wrap<String>().var("description");
    if(description == null) {
      _description(descriptionWrap);
      Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
        setDescription(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchDescription(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDescription(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDescription(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchDescription(siteRequest_, VirtualMachine.staticSetDescription(siteRequest_, o)).toString();
  }

  public String sqlDescription() {
    return description;
  }

  public static String staticJsonDescription(String description) {
    return description;
  }

	////////////////////
  // locationColors //
	////////////////////


  /**
   *  The entity locationColors
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> locationColors = new ArrayList<String>();

  /**
   * <br> The entity locationColors
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:locationColors">Find the entity locationColors in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _locationColors(List<String> l);

  public List<String> getLocationColors() {
    return locationColors;
  }

  public void setLocationColors(List<String> locationColors) {
    this.locationColors = locationColors;
  }
  @JsonIgnore
  public void setLocationColors(String o) {
    String l = VirtualMachine.staticSetLocationColors(siteRequest_, o);
    if(l != null)
      addLocationColors(l);
  }
  public static String staticSetLocationColors(SiteRequest siteRequest_, String o) {
    return o;
  }
  public VirtualMachine addLocationColors(String...objects) {
    for(String o : objects) {
      addLocationColors(o);
    }
    return (VirtualMachine)this;
  }
  public VirtualMachine addLocationColors(String o) {
    if(o != null)
      this.locationColors.add(o);
    return (VirtualMachine)this;
  }
  @JsonIgnore
  public void setLocationColors(JsonArray objects) {
    locationColors.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addLocationColors(o);
    }
  }
  protected VirtualMachine locationColorsInit() {
    _locationColors(locationColors);
    return (VirtualMachine)this;
  }

  public static String staticSearchLocationColors(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLocationColors(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLocationColors(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchLocationColors(siteRequest_, VirtualMachine.staticSetLocationColors(siteRequest_, o)).toString();
  }

	////////////////////
  // locationTitles //
	////////////////////


  /**
   *  The entity locationTitles
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> locationTitles = new ArrayList<String>();

  /**
   * <br> The entity locationTitles
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:locationTitles">Find the entity locationTitles in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _locationTitles(List<String> l);

  public List<String> getLocationTitles() {
    return locationTitles;
  }

  public void setLocationTitles(List<String> locationTitles) {
    this.locationTitles = locationTitles;
  }
  @JsonIgnore
  public void setLocationTitles(String o) {
    String l = VirtualMachine.staticSetLocationTitles(siteRequest_, o);
    if(l != null)
      addLocationTitles(l);
  }
  public static String staticSetLocationTitles(SiteRequest siteRequest_, String o) {
    return o;
  }
  public VirtualMachine addLocationTitles(String...objects) {
    for(String o : objects) {
      addLocationTitles(o);
    }
    return (VirtualMachine)this;
  }
  public VirtualMachine addLocationTitles(String o) {
    if(o != null)
      this.locationTitles.add(o);
    return (VirtualMachine)this;
  }
  @JsonIgnore
  public void setLocationTitles(JsonArray objects) {
    locationTitles.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addLocationTitles(o);
    }
  }
  protected VirtualMachine locationTitlesInit() {
    _locationTitles(locationTitles);
    return (VirtualMachine)this;
  }

  public static String staticSearchLocationTitles(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLocationTitles(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLocationTitles(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchLocationTitles(siteRequest_, VirtualMachine.staticSetLocationTitles(siteRequest_, o)).toString();
  }

	///////////////////
  // locationLinks //
	///////////////////


  /**
   *  The entity locationLinks
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> locationLinks = new ArrayList<String>();

  /**
   * <br> The entity locationLinks
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:locationLinks">Find the entity locationLinks in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _locationLinks(List<String> l);

  public List<String> getLocationLinks() {
    return locationLinks;
  }

  public void setLocationLinks(List<String> locationLinks) {
    this.locationLinks = locationLinks;
  }
  @JsonIgnore
  public void setLocationLinks(String o) {
    String l = VirtualMachine.staticSetLocationLinks(siteRequest_, o);
    if(l != null)
      addLocationLinks(l);
  }
  public static String staticSetLocationLinks(SiteRequest siteRequest_, String o) {
    return o;
  }
  public VirtualMachine addLocationLinks(String...objects) {
    for(String o : objects) {
      addLocationLinks(o);
    }
    return (VirtualMachine)this;
  }
  public VirtualMachine addLocationLinks(String o) {
    if(o != null)
      this.locationLinks.add(o);
    return (VirtualMachine)this;
  }
  @JsonIgnore
  public void setLocationLinks(JsonArray objects) {
    locationLinks.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addLocationLinks(o);
    }
  }
  protected VirtualMachine locationLinksInit() {
    _locationLinks(locationLinks);
    return (VirtualMachine)this;
  }

  public static String staticSearchLocationLinks(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLocationLinks(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLocationLinks(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchLocationLinks(siteRequest_, VirtualMachine.staticSetLocationLinks(siteRequest_, o)).toString();
  }

	//////////////
  // location //
	//////////////


  /**
   *  The entity location
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = PgClientPointDeserializer.class)
  @JsonSerialize(using = PgClientPointSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Point location;

  /**
   * <br> The entity location
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:location">Find the entity location in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _location(Wrap<Point> w);

  public Point getLocation() {
    return location;
  }

  public void setLocation(Point location) {
    this.location = location;
  }
  @JsonIgnore
  public void setLocation(String o) {
    this.location = VirtualMachine.staticSetLocation(siteRequest_, o);
  }
  public static Point staticSetLocation(SiteRequest siteRequest_, String o) {
    if(o != null) {
      try {
        Point shape = null;
        if(StringUtils.isNotBlank(o)) {
          ObjectMapper objectMapper = new ObjectMapper();
          SimpleModule module = new SimpleModule();
          module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
              if (beanDesc.getBeanClass() == Point.class) {
                return new PgClientPointDeserializer();
              }
              return deserializer;
            }
          });
          objectMapper.registerModule(module);
          shape = objectMapper.readValue(Json.encode(o), Point.class);
        }
        return shape;
      } catch(Exception ex) {
        ExceptionUtils.rethrow(ex);
      }
    }
    return null;
  }
  @JsonIgnore
  public void setLocation(JsonObject o) {
    this.location = VirtualMachine.staticSetLocation(siteRequest_, o);
  }
  public static Point staticSetLocation(SiteRequest siteRequest_, JsonObject o) {
    if(o != null) {
      try {
        Point shape = new Point();
        JsonArray coordinates = o.getJsonArray("coordinates");
        shape.setX(coordinates.getDouble(0));
        shape.setY(coordinates.getDouble(1));
        return shape;
      } catch(Exception ex) {
        ExceptionUtils.rethrow(ex);
      }
    }
    return null;
  }
  protected VirtualMachine locationInit() {
    Wrap<Point> locationWrap = new Wrap<Point>().var("location");
    if(location == null) {
      _location(locationWrap);
      Optional.ofNullable(locationWrap.getO()).ifPresent(o -> {
        setLocation(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static Point staticSearchLocation(SiteRequest siteRequest_, Point o) {
    return o;
  }

  public static String staticSearchStrLocation(SiteRequest siteRequest_, Point o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLocation(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchLocation(siteRequest_, VirtualMachine.staticSetLocation(siteRequest_, o)).toString();
  }

  public Point sqlLocation() {
    return location;
  }

  public static JsonObject staticJsonLocation(Point location) {
    return Optional.ofNullable(location).map(v -> VertxTool.toGeoJson(v)).orElse(null);
  }

	////////
  // id //
	////////


  /**
   *  The entity id
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String id;

  /**
   * <br> The entity id
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _id(Wrap<String> w);

  public String getId() {
    return id;
  }
  public void setId(String o) {
    this.id = VirtualMachine.staticSetId(siteRequest_, o);
  }
  public static String staticSetId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine idInit() {
    Wrap<String> idWrap = new Wrap<String>().var("id");
    if(id == null) {
      _id(idWrap);
      Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
        setId(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqId(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchId(siteRequest_, VirtualMachine.staticSetId(siteRequest_, o)).toString();
  }

  public String sqlId() {
    return id;
  }

  public static String staticJsonId(String id) {
    return id;
  }

	///////////////////
  // entityShortId //
	///////////////////


  /**
   *  The entity entityShortId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String entityShortId;

  /**
   * <br> The entity entityShortId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:entityShortId">Find the entity entityShortId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _entityShortId(Wrap<String> w);

  public String getEntityShortId() {
    return entityShortId;
  }
  public void setEntityShortId(String o) {
    this.entityShortId = VirtualMachine.staticSetEntityShortId(siteRequest_, o);
  }
  public static String staticSetEntityShortId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine entityShortIdInit() {
    Wrap<String> entityShortIdWrap = new Wrap<String>().var("entityShortId");
    if(entityShortId == null) {
      _entityShortId(entityShortIdWrap);
      Optional.ofNullable(entityShortIdWrap.getO()).ifPresent(o -> {
        setEntityShortId(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchEntityShortId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrEntityShortId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEntityShortId(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchEntityShortId(siteRequest_, VirtualMachine.staticSetEntityShortId(siteRequest_, o)).toString();
  }

	//////////////////
  // ngsildTenant //
	//////////////////


  /**
   *  The entity ngsildTenant
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String ngsildTenant;

  /**
   * <br> The entity ngsildTenant
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:ngsildTenant">Find the entity ngsildTenant in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _ngsildTenant(Wrap<String> w);

  public String getNgsildTenant() {
    return ngsildTenant;
  }
  public void setNgsildTenant(String o) {
    this.ngsildTenant = VirtualMachine.staticSetNgsildTenant(siteRequest_, o);
  }
  public static String staticSetNgsildTenant(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine ngsildTenantInit() {
    Wrap<String> ngsildTenantWrap = new Wrap<String>().var("ngsildTenant");
    if(ngsildTenant == null) {
      _ngsildTenant(ngsildTenantWrap);
      Optional.ofNullable(ngsildTenantWrap.getO()).ifPresent(o -> {
        setNgsildTenant(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchNgsildTenant(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrNgsildTenant(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNgsildTenant(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchNgsildTenant(siteRequest_, VirtualMachine.staticSetNgsildTenant(siteRequest_, o)).toString();
  }

  public String sqlNgsildTenant() {
    return ngsildTenant;
  }

  public static String staticJsonNgsildTenant(String ngsildTenant) {
    return ngsildTenant;
  }

	////////////////
  // ngsildPath //
	////////////////


  /**
   *  The entity ngsildPath
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String ngsildPath;

  /**
   * <br> The entity ngsildPath
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:ngsildPath">Find the entity ngsildPath in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _ngsildPath(Wrap<String> w);

  public String getNgsildPath() {
    return ngsildPath;
  }
  public void setNgsildPath(String o) {
    this.ngsildPath = VirtualMachine.staticSetNgsildPath(siteRequest_, o);
  }
  public static String staticSetNgsildPath(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine ngsildPathInit() {
    Wrap<String> ngsildPathWrap = new Wrap<String>().var("ngsildPath");
    if(ngsildPath == null) {
      _ngsildPath(ngsildPathWrap);
      Optional.ofNullable(ngsildPathWrap.getO()).ifPresent(o -> {
        setNgsildPath(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchNgsildPath(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrNgsildPath(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNgsildPath(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchNgsildPath(siteRequest_, VirtualMachine.staticSetNgsildPath(siteRequest_, o)).toString();
  }

  public String sqlNgsildPath() {
    return ngsildPath;
  }

  public static String staticJsonNgsildPath(String ngsildPath) {
    return ngsildPath;
  }

	///////////////////
  // ngsildContext //
	///////////////////


  /**
   *  The entity ngsildContext
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String ngsildContext;

  /**
   * <br> The entity ngsildContext
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:ngsildContext">Find the entity ngsildContext in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _ngsildContext(Wrap<String> w);

  public String getNgsildContext() {
    return ngsildContext;
  }
  public void setNgsildContext(String o) {
    this.ngsildContext = VirtualMachine.staticSetNgsildContext(siteRequest_, o);
  }
  public static String staticSetNgsildContext(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected VirtualMachine ngsildContextInit() {
    Wrap<String> ngsildContextWrap = new Wrap<String>().var("ngsildContext");
    if(ngsildContext == null) {
      _ngsildContext(ngsildContextWrap);
      Optional.ofNullable(ngsildContextWrap.getO()).ifPresent(o -> {
        setNgsildContext(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchNgsildContext(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrNgsildContext(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNgsildContext(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchNgsildContext(siteRequest_, VirtualMachine.staticSetNgsildContext(siteRequest_, o)).toString();
  }

  public String sqlNgsildContext() {
    return ngsildContext;
  }

  public static String staticJsonNgsildContext(String ngsildContext) {
    return ngsildContext;
  }

	////////////////
  // ngsildData //
	////////////////


  /**
   *  The entity ngsildData
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject ngsildData;

  /**
   * <br> The entity ngsildData
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine&fq=entiteVar_enUS_indexed_string:ngsildData">Find the entity ngsildData in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _ngsildData(Wrap<JsonObject> w);

  public JsonObject getNgsildData() {
    return ngsildData;
  }

  public void setNgsildData(JsonObject ngsildData) {
    this.ngsildData = ngsildData;
  }
  @JsonIgnore
  public void setNgsildData(String o) {
    this.ngsildData = VirtualMachine.staticSetNgsildData(siteRequest_, o);
  }
  public static JsonObject staticSetNgsildData(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected VirtualMachine ngsildDataInit() {
    Wrap<JsonObject> ngsildDataWrap = new Wrap<JsonObject>().var("ngsildData");
    if(ngsildData == null) {
      _ngsildData(ngsildDataWrap);
      Optional.ofNullable(ngsildDataWrap.getO()).ifPresent(o -> {
        setNgsildData(o);
      });
    }
    return (VirtualMachine)this;
  }

  public static String staticSearchNgsildData(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrNgsildData(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNgsildData(SiteRequest siteRequest_, String o) {
    return VirtualMachine.staticSearchNgsildData(siteRequest_, VirtualMachine.staticSetNgsildData(siteRequest_, o)).toString();
  }

  public JsonObject sqlNgsildData() {
    return ngsildData;
  }

  public static JsonObject staticJsonNgsildData(JsonObject ngsildData) {
    return ngsildData;
  }

  //////////////
  // initDeep //
  //////////////

  public Future<VirtualMachineGen<DEV>> promiseDeepVirtualMachine(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepVirtualMachine();
  }

  public Future<VirtualMachineGen<DEV>> promiseDeepVirtualMachine() {
    Promise<VirtualMachineGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseVirtualMachine(promise2);
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

  public Future<Void> promiseVirtualMachine(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        hubIdInit();
        hubResourceInit();
        clusterNameInit();
        clusterResourceInit();
        vmProjectInit();
        vmNameInit();
        osInit();
        vmResourceInit();
        vmDisplayNameInit();
        descriptionInit();
        locationColorsInit();
        locationTitlesInit();
        locationLinksInit();
        locationInit();
        idInit();
        entityShortIdInit();
        ngsildTenantInit();
        ngsildPathInit();
        ngsildContextInit();
        ngsildDataInit();
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

  @Override public Future<? extends VirtualMachineGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepVirtualMachine(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestVirtualMachine(SiteRequest siteRequest_) {
      super.siteRequestBaseModel(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestVirtualMachine(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainVirtualMachine(v);
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
  public Object obtainVirtualMachine(String var) {
    VirtualMachine oVirtualMachine = (VirtualMachine)this;
    switch(var) {
      case "hubId":
        return oVirtualMachine.hubId;
      case "hubResource":
        return oVirtualMachine.hubResource;
      case "clusterName":
        return oVirtualMachine.clusterName;
      case "clusterResource":
        return oVirtualMachine.clusterResource;
      case "vmProject":
        return oVirtualMachine.vmProject;
      case "vmName":
        return oVirtualMachine.vmName;
      case "os":
        return oVirtualMachine.os;
      case "vmResource":
        return oVirtualMachine.vmResource;
      case "vmDisplayName":
        return oVirtualMachine.vmDisplayName;
      case "description":
        return oVirtualMachine.description;
      case "locationColors":
        return oVirtualMachine.locationColors;
      case "locationTitles":
        return oVirtualMachine.locationTitles;
      case "locationLinks":
        return oVirtualMachine.locationLinks;
      case "location":
        return oVirtualMachine.location;
      case "id":
        return oVirtualMachine.id;
      case "entityShortId":
        return oVirtualMachine.entityShortId;
      case "ngsildTenant":
        return oVirtualMachine.ngsildTenant;
      case "ngsildPath":
        return oVirtualMachine.ngsildPath;
      case "ngsildContext":
        return oVirtualMachine.ngsildContext;
      case "ngsildData":
        return oVirtualMachine.ngsildData;
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
        o = relateVirtualMachine(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateVirtualMachine(String var, Object val) {
    VirtualMachine oVirtualMachine = (VirtualMachine)this;
    switch(var) {
      case "hubResource":
        if(oVirtualMachine.getHubResource() == null)
          oVirtualMachine.setHubResource(Optional.ofNullable(val).map(v -> v.toString()).orElse(null));
        if(!saves.contains("hubResource"))
          saves.add("hubResource");
        return val;
      case "clusterResource":
        if(oVirtualMachine.getClusterResource() == null)
          oVirtualMachine.setClusterResource(Optional.ofNullable(val).map(v -> v.toString()).orElse(null));
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

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, VirtualMachine o) {
    return staticSetVirtualMachine(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetVirtualMachine(String entityVar, SiteRequest siteRequest_, String v, VirtualMachine o) {
    switch(entityVar) {
    case "hubId":
      return VirtualMachine.staticSetHubId(siteRequest_, v);
    case "hubResource":
      return VirtualMachine.staticSetHubResource(siteRequest_, v);
    case "clusterName":
      return VirtualMachine.staticSetClusterName(siteRequest_, v);
    case "clusterResource":
      return VirtualMachine.staticSetClusterResource(siteRequest_, v);
    case "vmProject":
      return VirtualMachine.staticSetVmProject(siteRequest_, v);
    case "vmName":
      return VirtualMachine.staticSetVmName(siteRequest_, v);
    case "os":
      return VirtualMachine.staticSetOs(siteRequest_, v);
    case "vmResource":
      return VirtualMachine.staticSetVmResource(siteRequest_, v);
    case "vmDisplayName":
      return VirtualMachine.staticSetVmDisplayName(siteRequest_, v);
    case "description":
      return VirtualMachine.staticSetDescription(siteRequest_, v);
    case "locationColors":
      return VirtualMachine.staticSetLocationColors(siteRequest_, v);
    case "locationTitles":
      return VirtualMachine.staticSetLocationTitles(siteRequest_, v);
    case "locationLinks":
      return VirtualMachine.staticSetLocationLinks(siteRequest_, v);
    case "location":
      return VirtualMachine.staticSetLocation(siteRequest_, v);
    case "id":
      return VirtualMachine.staticSetId(siteRequest_, v);
    case "entityShortId":
      return VirtualMachine.staticSetEntityShortId(siteRequest_, v);
    case "ngsildTenant":
      return VirtualMachine.staticSetNgsildTenant(siteRequest_, v);
    case "ngsildPath":
      return VirtualMachine.staticSetNgsildPath(siteRequest_, v);
    case "ngsildContext":
      return VirtualMachine.staticSetNgsildContext(siteRequest_, v);
    case "ngsildData":
      return VirtualMachine.staticSetNgsildData(siteRequest_, v);
      default:
        return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchVirtualMachine(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchVirtualMachine(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "hubId":
      return VirtualMachine.staticSearchHubId(siteRequest_, (String)o);
    case "hubResource":
      return VirtualMachine.staticSearchHubResource(siteRequest_, (String)o);
    case "clusterName":
      return VirtualMachine.staticSearchClusterName(siteRequest_, (String)o);
    case "clusterResource":
      return VirtualMachine.staticSearchClusterResource(siteRequest_, (String)o);
    case "vmProject":
      return VirtualMachine.staticSearchVmProject(siteRequest_, (String)o);
    case "vmName":
      return VirtualMachine.staticSearchVmName(siteRequest_, (String)o);
    case "os":
      return VirtualMachine.staticSearchOs(siteRequest_, (String)o);
    case "vmResource":
      return VirtualMachine.staticSearchVmResource(siteRequest_, (String)o);
    case "vmDisplayName":
      return VirtualMachine.staticSearchVmDisplayName(siteRequest_, (String)o);
    case "description":
      return VirtualMachine.staticSearchDescription(siteRequest_, (String)o);
    case "locationColors":
      return VirtualMachine.staticSearchLocationColors(siteRequest_, (String)o);
    case "locationTitles":
      return VirtualMachine.staticSearchLocationTitles(siteRequest_, (String)o);
    case "locationLinks":
      return VirtualMachine.staticSearchLocationLinks(siteRequest_, (String)o);
    case "location":
      return VirtualMachine.staticSearchLocation(siteRequest_, (Point)o);
    case "id":
      return VirtualMachine.staticSearchId(siteRequest_, (String)o);
    case "entityShortId":
      return VirtualMachine.staticSearchEntityShortId(siteRequest_, (String)o);
    case "ngsildTenant":
      return VirtualMachine.staticSearchNgsildTenant(siteRequest_, (String)o);
    case "ngsildPath":
      return VirtualMachine.staticSearchNgsildPath(siteRequest_, (String)o);
    case "ngsildContext":
      return VirtualMachine.staticSearchNgsildContext(siteRequest_, (String)o);
    case "ngsildData":
      return VirtualMachine.staticSearchNgsildData(siteRequest_, (JsonObject)o);
      default:
        return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrVirtualMachine(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrVirtualMachine(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "hubId":
      return VirtualMachine.staticSearchStrHubId(siteRequest_, (String)o);
    case "hubResource":
      return VirtualMachine.staticSearchStrHubResource(siteRequest_, (String)o);
    case "clusterName":
      return VirtualMachine.staticSearchStrClusterName(siteRequest_, (String)o);
    case "clusterResource":
      return VirtualMachine.staticSearchStrClusterResource(siteRequest_, (String)o);
    case "vmProject":
      return VirtualMachine.staticSearchStrVmProject(siteRequest_, (String)o);
    case "vmName":
      return VirtualMachine.staticSearchStrVmName(siteRequest_, (String)o);
    case "os":
      return VirtualMachine.staticSearchStrOs(siteRequest_, (String)o);
    case "vmResource":
      return VirtualMachine.staticSearchStrVmResource(siteRequest_, (String)o);
    case "vmDisplayName":
      return VirtualMachine.staticSearchStrVmDisplayName(siteRequest_, (String)o);
    case "description":
      return VirtualMachine.staticSearchStrDescription(siteRequest_, (String)o);
    case "locationColors":
      return VirtualMachine.staticSearchStrLocationColors(siteRequest_, (String)o);
    case "locationTitles":
      return VirtualMachine.staticSearchStrLocationTitles(siteRequest_, (String)o);
    case "locationLinks":
      return VirtualMachine.staticSearchStrLocationLinks(siteRequest_, (String)o);
    case "location":
      return VirtualMachine.staticSearchStrLocation(siteRequest_, (Point)o);
    case "id":
      return VirtualMachine.staticSearchStrId(siteRequest_, (String)o);
    case "entityShortId":
      return VirtualMachine.staticSearchStrEntityShortId(siteRequest_, (String)o);
    case "ngsildTenant":
      return VirtualMachine.staticSearchStrNgsildTenant(siteRequest_, (String)o);
    case "ngsildPath":
      return VirtualMachine.staticSearchStrNgsildPath(siteRequest_, (String)o);
    case "ngsildContext":
      return VirtualMachine.staticSearchStrNgsildContext(siteRequest_, (String)o);
    case "ngsildData":
      return VirtualMachine.staticSearchStrNgsildData(siteRequest_, (String)o);
      default:
        return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqVirtualMachine(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqVirtualMachine(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "hubId":
      return VirtualMachine.staticSearchFqHubId(siteRequest_, o);
    case "hubResource":
      return VirtualMachine.staticSearchFqHubResource(siteRequest_, o);
    case "clusterName":
      return VirtualMachine.staticSearchFqClusterName(siteRequest_, o);
    case "clusterResource":
      return VirtualMachine.staticSearchFqClusterResource(siteRequest_, o);
    case "vmProject":
      return VirtualMachine.staticSearchFqVmProject(siteRequest_, o);
    case "vmName":
      return VirtualMachine.staticSearchFqVmName(siteRequest_, o);
    case "os":
      return VirtualMachine.staticSearchFqOs(siteRequest_, o);
    case "vmResource":
      return VirtualMachine.staticSearchFqVmResource(siteRequest_, o);
    case "vmDisplayName":
      return VirtualMachine.staticSearchFqVmDisplayName(siteRequest_, o);
    case "description":
      return VirtualMachine.staticSearchFqDescription(siteRequest_, o);
    case "locationColors":
      return VirtualMachine.staticSearchFqLocationColors(siteRequest_, o);
    case "locationTitles":
      return VirtualMachine.staticSearchFqLocationTitles(siteRequest_, o);
    case "locationLinks":
      return VirtualMachine.staticSearchFqLocationLinks(siteRequest_, o);
    case "location":
      return VirtualMachine.staticSearchFqLocation(siteRequest_, o);
    case "id":
      return VirtualMachine.staticSearchFqId(siteRequest_, o);
    case "entityShortId":
      return VirtualMachine.staticSearchFqEntityShortId(siteRequest_, o);
    case "ngsildTenant":
      return VirtualMachine.staticSearchFqNgsildTenant(siteRequest_, o);
    case "ngsildPath":
      return VirtualMachine.staticSearchFqNgsildPath(siteRequest_, o);
    case "ngsildContext":
      return VirtualMachine.staticSearchFqNgsildContext(siteRequest_, o);
    case "ngsildData":
      return VirtualMachine.staticSearchFqNgsildData(siteRequest_, o);
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
          o = persistVirtualMachine(v, val);
        else if(o instanceof BaseModel) {
          BaseModel oBaseModel = (BaseModel)o;
          o = oBaseModel.persistForClass(v, val);
        }
      }
    }
    return o != null;
  }
  public Object persistVirtualMachine(String var, Object val) {
    String varLower = var.toLowerCase();
      if("hubid".equals(varLower)) {
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
      } else if("vmproject".equals(varLower)) {
        if(val instanceof String) {
          setVmProject((String)val);
        }
        saves.add("vmProject");
        return val;
      } else if("vmname".equals(varLower)) {
        if(val instanceof String) {
          setVmName((String)val);
        }
        saves.add("vmName");
        return val;
      } else if("os".equals(varLower)) {
        if(val instanceof String) {
          setOs((String)val);
        }
        saves.add("os");
        return val;
      } else if("vmresource".equals(varLower)) {
        if(val instanceof String) {
          setVmResource((String)val);
        }
        saves.add("vmResource");
        return val;
      } else if("description".equals(varLower)) {
        if(val instanceof String) {
          setDescription((String)val);
        }
        saves.add("description");
        return val;
      } else if("location".equals(varLower)) {
        if(val instanceof String) {
          setLocation((String)val);
        } else if(val instanceof Point) {
          setLocation((Point)val);
        }
        saves.add("location");
        return val;
      } else if("id".equals(varLower)) {
        if(val instanceof String) {
          setId((String)val);
        }
        saves.add("id");
        return val;
      } else if("ngsildtenant".equals(varLower)) {
        if(val instanceof String) {
          setNgsildTenant((String)val);
        }
        saves.add("ngsildTenant");
        return val;
      } else if("ngsildpath".equals(varLower)) {
        if(val instanceof String) {
          setNgsildPath((String)val);
        }
        saves.add("ngsildPath");
        return val;
      } else if("ngsildcontext".equals(varLower)) {
        if(val instanceof String) {
          setNgsildContext((String)val);
        }
        saves.add("ngsildContext");
        return val;
      } else if("ngsilddata".equals(varLower)) {
        if(val instanceof String) {
          setNgsildData((String)val);
        } else if(val instanceof JsonObject) {
          setNgsildData((JsonObject)val);
        }
        saves.add("ngsildData");
        return val;
    } else {
      return super.persistBaseModel(var, val);
    }
  }

  /////////////
  // populate //
  /////////////

  @Override public void populateForClass(SolrResponse.Doc doc) {
    populateVirtualMachine(doc);
  }
  public void populateVirtualMachine(SolrResponse.Doc doc) {
    VirtualMachine oVirtualMachine = (VirtualMachine)this;
    saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
    if(saves != null) {

      if(saves.contains("hubId")) {
        String hubId = (String)doc.get("hubId_docvalues_string");
        if(hubId != null)
          oVirtualMachine.setHubId(hubId);
      }

      String hubResource = (String)doc.get("hubResource_docvalues_string");
      if(hubResource != null)
        oVirtualMachine.setHubResource(hubResource);

      if(saves.contains("clusterName")) {
        String clusterName = (String)doc.get("clusterName_docvalues_string");
        if(clusterName != null)
          oVirtualMachine.setClusterName(clusterName);
      }

      String clusterResource = (String)doc.get("clusterResource_docvalues_string");
      if(clusterResource != null)
        oVirtualMachine.setClusterResource(clusterResource);

      if(saves.contains("vmProject")) {
        String vmProject = (String)doc.get("vmProject_docvalues_string");
        if(vmProject != null)
          oVirtualMachine.setVmProject(vmProject);
      }

      if(saves.contains("vmName")) {
        String vmName = (String)doc.get("vmName_docvalues_string");
        if(vmName != null)
          oVirtualMachine.setVmName(vmName);
      }

      if(saves.contains("os")) {
        String os = (String)doc.get("os_docvalues_string");
        if(os != null)
          oVirtualMachine.setOs(os);
      }

      if(saves.contains("vmResource")) {
        String vmResource = (String)doc.get("vmResource_docvalues_string");
        if(vmResource != null)
          oVirtualMachine.setVmResource(vmResource);
      }

      if(saves.contains("vmDisplayName")) {
        String vmDisplayName = (String)doc.get("vmDisplayName_docvalues_string");
        if(vmDisplayName != null)
          oVirtualMachine.setVmDisplayName(vmDisplayName);
      }

      if(saves.contains("description")) {
        String description = (String)doc.get("description_docvalues_string");
        if(description != null)
          oVirtualMachine.setDescription(description);
      }

      if(saves.contains("locationColors")) {
        List<String> locationColors = (List<String>)doc.get("locationColors_indexedstored_strings");
        if(locationColors != null) {
          locationColors.stream().forEach( v -> {
            oVirtualMachine.locationColors.add(VirtualMachine.staticSetLocationColors(siteRequest_, v));
          });
        }
      }

      if(saves.contains("locationTitles")) {
        List<String> locationTitles = (List<String>)doc.get("locationTitles_indexedstored_strings");
        if(locationTitles != null) {
          locationTitles.stream().forEach( v -> {
            oVirtualMachine.locationTitles.add(VirtualMachine.staticSetLocationTitles(siteRequest_, v));
          });
        }
      }

      if(saves.contains("locationLinks")) {
        List<String> locationLinks = (List<String>)doc.get("locationLinks_indexedstored_strings");
        if(locationLinks != null) {
          locationLinks.stream().forEach( v -> {
            oVirtualMachine.locationLinks.add(VirtualMachine.staticSetLocationLinks(siteRequest_, v));
          });
        }
      }

      if(saves.contains("location")) {
        Point location = (Point)doc.get("location_docvalues_location");
        if(location != null)
          oVirtualMachine.setLocation(location);
      }

      if(saves.contains("id")) {
        String id = (String)doc.get("id_docvalues_string");
        if(id != null)
          oVirtualMachine.setId(id);
      }

      if(saves.contains("entityShortId")) {
        String entityShortId = (String)doc.get("entityShortId_docvalues_string");
        if(entityShortId != null)
          oVirtualMachine.setEntityShortId(entityShortId);
      }

      if(saves.contains("ngsildTenant")) {
        String ngsildTenant = (String)doc.get("ngsildTenant_docvalues_string");
        if(ngsildTenant != null)
          oVirtualMachine.setNgsildTenant(ngsildTenant);
      }

      if(saves.contains("ngsildPath")) {
        String ngsildPath = (String)doc.get("ngsildPath_docvalues_string");
        if(ngsildPath != null)
          oVirtualMachine.setNgsildPath(ngsildPath);
      }

      if(saves.contains("ngsildContext")) {
        String ngsildContext = (String)doc.get("ngsildContext_docvalues_string");
        if(ngsildContext != null)
          oVirtualMachine.setNgsildContext(ngsildContext);
      }

      if(saves.contains("ngsildData")) {
        String ngsildData = (String)doc.get("ngsildData_docvalues_string");
        if(ngsildData != null)
          oVirtualMachine.setNgsildData(ngsildData);
      }
    }

    super.populateBaseModel(doc);
  }

  public void indexVirtualMachine(JsonObject doc) {
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
    if(vmProject != null) {
      doc.put("vmProject_docvalues_string", vmProject);
    }
    if(vmName != null) {
      doc.put("vmName_docvalues_string", vmName);
    }
    if(os != null) {
      doc.put("os_docvalues_string", os);
    }
    if(vmResource != null) {
      doc.put("vmResource_docvalues_string", vmResource);
    }
    if(vmDisplayName != null) {
      doc.put("vmDisplayName_docvalues_string", vmDisplayName);
    }
    if(description != null) {
      doc.put("description_docvalues_string", description);
    }
    if(locationColors != null) {
      JsonArray l = new JsonArray();
      doc.put("locationColors_indexedstored_strings", l);
      for(String o : locationColors) {
        l.add(VirtualMachine.staticSearchLocationColors(siteRequest_, o));
      }
    }
    if(locationTitles != null) {
      JsonArray l = new JsonArray();
      doc.put("locationTitles_indexedstored_strings", l);
      for(String o : locationTitles) {
        l.add(VirtualMachine.staticSearchLocationTitles(siteRequest_, o));
      }
    }
    if(locationLinks != null) {
      JsonArray l = new JsonArray();
      doc.put("locationLinks_indexedstored_strings", l);
      for(String o : locationLinks) {
        l.add(VirtualMachine.staticSearchLocationLinks(siteRequest_, o));
      }
    }
    if(location != null) {
      doc.put("location_docvalues_location", String.format("%s,%s", location.getY(), location.getX()));
    }
    if(id != null) {
      doc.put("id_docvalues_string", id);
    }
    if(entityShortId != null) {
      doc.put("entityShortId_docvalues_string", entityShortId);
    }
    if(ngsildTenant != null) {
      doc.put("ngsildTenant_docvalues_string", ngsildTenant);
    }
    if(ngsildPath != null) {
      doc.put("ngsildPath_docvalues_string", ngsildPath);
    }
    if(ngsildContext != null) {
      doc.put("ngsildContext_docvalues_string", ngsildContext);
    }
    if(ngsildData != null) {
      doc.put("ngsildData_docvalues_string", ngsildData.encode());
    }
    super.indexBaseModel(doc);

	}

  public static String varStoredVirtualMachine(String entityVar) {
    switch(entityVar) {
      case "hubId":
        return "hubId_docvalues_string";
      case "hubResource":
        return "hubResource_docvalues_string";
      case "clusterName":
        return "clusterName_docvalues_string";
      case "clusterResource":
        return "clusterResource_docvalues_string";
      case "vmProject":
        return "vmProject_docvalues_string";
      case "vmName":
        return "vmName_docvalues_string";
      case "os":
        return "os_docvalues_string";
      case "vmResource":
        return "vmResource_docvalues_string";
      case "vmDisplayName":
        return "vmDisplayName_docvalues_string";
      case "description":
        return "description_docvalues_string";
      case "locationColors":
        return "locationColors_indexedstored_strings";
      case "locationTitles":
        return "locationTitles_indexedstored_strings";
      case "locationLinks":
        return "locationLinks_indexedstored_strings";
      case "location":
        return "location_docvalues_location";
      case "id":
        return "id_docvalues_string";
      case "entityShortId":
        return "entityShortId_docvalues_string";
      case "ngsildTenant":
        return "ngsildTenant_docvalues_string";
      case "ngsildPath":
        return "ngsildPath_docvalues_string";
      case "ngsildContext":
        return "ngsildContext_docvalues_string";
      case "ngsildData":
        return "ngsildData_docvalues_string";
      default:
        return BaseModel.varStoredBaseModel(entityVar);
    }
  }

  public static String varIndexedVirtualMachine(String entityVar) {
    switch(entityVar) {
      case "hubId":
        return "hubId_docvalues_string";
      case "hubResource":
        return "hubResource_docvalues_string";
      case "clusterName":
        return "clusterName_docvalues_string";
      case "clusterResource":
        return "clusterResource_docvalues_string";
      case "vmProject":
        return "vmProject_docvalues_string";
      case "vmName":
        return "vmName_docvalues_string";
      case "os":
        return "os_docvalues_string";
      case "vmResource":
        return "vmResource_docvalues_string";
      case "vmDisplayName":
        return "vmDisplayName_docvalues_string";
      case "description":
        return "description_docvalues_string";
      case "locationColors":
        return "locationColors_indexedstored_strings";
      case "locationTitles":
        return "locationTitles_indexedstored_strings";
      case "locationLinks":
        return "locationLinks_indexedstored_strings";
      case "location":
        return "location_docvalues_location";
      case "id":
        return "id_docvalues_string";
      case "entityShortId":
        return "entityShortId_docvalues_string";
      case "ngsildTenant":
        return "ngsildTenant_docvalues_string";
      case "ngsildPath":
        return "ngsildPath_docvalues_string";
      case "ngsildContext":
        return "ngsildContext_docvalues_string";
      case "ngsildData":
        return "ngsildData_docvalues_string";
      default:
        return BaseModel.varIndexedBaseModel(entityVar);
    }
  }

  public static String searchVarVirtualMachine(String searchVar) {
    switch(searchVar) {
      case "hubId_docvalues_string":
        return "hubId";
      case "hubResource_docvalues_string":
        return "hubResource";
      case "clusterName_docvalues_string":
        return "clusterName";
      case "clusterResource_docvalues_string":
        return "clusterResource";
      case "vmProject_docvalues_string":
        return "vmProject";
      case "vmName_docvalues_string":
        return "vmName";
      case "os_docvalues_string":
        return "os";
      case "vmResource_docvalues_string":
        return "vmResource";
      case "vmDisplayName_docvalues_string":
        return "vmDisplayName";
      case "description_docvalues_string":
        return "description";
      case "locationColors_indexedstored_strings":
        return "locationColors";
      case "locationTitles_indexedstored_strings":
        return "locationTitles";
      case "locationLinks_indexedstored_strings":
        return "locationLinks";
      case "location_docvalues_location":
        return "location";
      case "id_docvalues_string":
        return "id";
      case "entityShortId_docvalues_string":
        return "entityShortId";
      case "ngsildTenant_docvalues_string":
        return "ngsildTenant";
      case "ngsildPath_docvalues_string":
        return "ngsildPath";
      case "ngsildContext_docvalues_string":
        return "ngsildContext";
      case "ngsildData_docvalues_string":
        return "ngsildData";
      default:
        return BaseModel.searchVarBaseModel(searchVar);
    }
  }

  public static String varSearchVirtualMachine(String entityVar) {
    switch(entityVar) {
      default:
        return BaseModel.varSearchBaseModel(entityVar);
    }
  }

  public static String varSuggestedVirtualMachine(String entityVar) {
    switch(entityVar) {
      default:
        return BaseModel.varSuggestedBaseModel(entityVar);
    }
  }

  /////////////
  // store //
  /////////////

  @Override public void storeForClass(SolrResponse.Doc doc) {
    storeVirtualMachine(doc);
  }
  public void storeVirtualMachine(SolrResponse.Doc doc) {
    VirtualMachine oVirtualMachine = (VirtualMachine)this;
    SiteRequest siteRequest = oVirtualMachine.getSiteRequest_();

    oVirtualMachine.setHubId(Optional.ofNullable(doc.get("hubId_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setHubResource(Optional.ofNullable(doc.get("hubResource_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setClusterName(Optional.ofNullable(doc.get("clusterName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setClusterResource(Optional.ofNullable(doc.get("clusterResource_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setVmProject(Optional.ofNullable(doc.get("vmProject_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setVmName(Optional.ofNullable(doc.get("vmName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setOs(Optional.ofNullable(doc.get("os_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setVmResource(Optional.ofNullable(doc.get("vmResource_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setVmDisplayName(Optional.ofNullable(doc.get("vmDisplayName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("locationColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oVirtualMachine.addLocationColors(VirtualMachine.staticSetLocationColors(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("locationTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oVirtualMachine.addLocationTitles(VirtualMachine.staticSetLocationTitles(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("locationLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oVirtualMachine.addLocationLinks(VirtualMachine.staticSetLocationLinks(siteRequest, v.toString()));
    });
    oVirtualMachine.setLocation(Optional.ofNullable(doc.get("location_docvalues_location")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setId(Optional.ofNullable(doc.get("id_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setEntityShortId(Optional.ofNullable(doc.get("entityShortId_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setNgsildTenant(Optional.ofNullable(doc.get("ngsildTenant_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setNgsildPath(Optional.ofNullable(doc.get("ngsildPath_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setNgsildContext(Optional.ofNullable(doc.get("ngsildContext_docvalues_string")).map(v -> v.toString()).orElse(null));
    oVirtualMachine.setNgsildData(Optional.ofNullable(doc.get("ngsildData_docvalues_string")).map(v -> v.toString()).orElse(null));

    super.storeBaseModel(doc);
  }

  //////////////////
  // apiRequest //
  //////////////////

  public void apiRequestVirtualMachine() {
    ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
    Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
    if(o != null && o instanceof VirtualMachine) {
      VirtualMachine original = (VirtualMachine)o;
      if(!Objects.equals(hubId, original.getHubId()))
        apiRequest.addVars("hubId");
      if(!Objects.equals(hubResource, original.getHubResource()))
        apiRequest.addVars("hubResource");
      if(!Objects.equals(clusterName, original.getClusterName()))
        apiRequest.addVars("clusterName");
      if(!Objects.equals(clusterResource, original.getClusterResource()))
        apiRequest.addVars("clusterResource");
      if(!Objects.equals(vmProject, original.getVmProject()))
        apiRequest.addVars("vmProject");
      if(!Objects.equals(vmName, original.getVmName()))
        apiRequest.addVars("vmName");
      if(!Objects.equals(os, original.getOs()))
        apiRequest.addVars("os");
      if(!Objects.equals(vmResource, original.getVmResource()))
        apiRequest.addVars("vmResource");
      if(!Objects.equals(vmDisplayName, original.getVmDisplayName()))
        apiRequest.addVars("vmDisplayName");
      if(!Objects.equals(description, original.getDescription()))
        apiRequest.addVars("description");
      if(!Objects.equals(locationColors, original.getLocationColors()))
        apiRequest.addVars("locationColors");
      if(!Objects.equals(locationTitles, original.getLocationTitles()))
        apiRequest.addVars("locationTitles");
      if(!Objects.equals(locationLinks, original.getLocationLinks()))
        apiRequest.addVars("locationLinks");
      if(!Objects.equals(location, original.getLocation()))
        apiRequest.addVars("location");
      if(!Objects.equals(id, original.getId()))
        apiRequest.addVars("id");
      if(!Objects.equals(entityShortId, original.getEntityShortId()))
        apiRequest.addVars("entityShortId");
      if(!Objects.equals(ngsildTenant, original.getNgsildTenant()))
        apiRequest.addVars("ngsildTenant");
      if(!Objects.equals(ngsildPath, original.getNgsildPath()))
        apiRequest.addVars("ngsildPath");
      if(!Objects.equals(ngsildContext, original.getNgsildContext()))
        apiRequest.addVars("ngsildContext");
      if(!Objects.equals(ngsildData, original.getNgsildData()))
        apiRequest.addVars("ngsildData");
      super.apiRequestBaseModel();
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append(Optional.ofNullable(hubId).map(v -> "hubId: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(hubResource).map(v -> "hubResource: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(clusterName).map(v -> "clusterName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(clusterResource).map(v -> "clusterResource: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(vmProject).map(v -> "vmProject: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(vmName).map(v -> "vmName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(os).map(v -> "os: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(vmResource).map(v -> "vmResource: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(vmDisplayName).map(v -> "vmDisplayName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(description).map(v -> "description: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(locationColors).map(v -> "locationColors: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(locationTitles).map(v -> "locationTitles: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(locationLinks).map(v -> "locationLinks: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(location).map(v -> "location: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(id).map(v -> "id: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(entityShortId).map(v -> "entityShortId: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(ngsildTenant).map(v -> "ngsildTenant: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(ngsildPath).map(v -> "ngsildPath: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(ngsildContext).map(v -> "ngsildContext: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(ngsildData).map(v -> "ngsildData: " + v + "\n").orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "VirtualMachine";
  public static final String CLASS_CANONICAL_NAME = "org.mghpcc.aitelemetry.model.virtualmachine.VirtualMachine";
  public static final String CLASS_AUTH_RESOURCE = "VIRTUALMACHINE";
  public static final String CLASS_API_ADDRESS_VirtualMachine = "ai-telemetry-enUS-VirtualMachine";
  public static String getClassApiAddress() {
    return CLASS_API_ADDRESS_VirtualMachine;
  }
  public static final String VAR_hubId = "hubId";
  public static final String VAR_hubResource = "hubResource";
  public static final String VAR_clusterName = "clusterName";
  public static final String VAR_clusterResource = "clusterResource";
  public static final String VAR_vmProject = "vmProject";
  public static final String VAR_vmName = "vmName";
  public static final String VAR_os = "os";
  public static final String VAR_vmResource = "vmResource";
  public static final String VAR_vmDisplayName = "vmDisplayName";
  public static final String VAR_description = "description";
  public static final String VAR_locationColors = "locationColors";
  public static final String VAR_locationTitles = "locationTitles";
  public static final String VAR_locationLinks = "locationLinks";
  public static final String VAR_location = "location";
  public static final String VAR_id = "id";
  public static final String VAR_entityShortId = "entityShortId";
  public static final String VAR_ngsildTenant = "ngsildTenant";
  public static final String VAR_ngsildPath = "ngsildPath";
  public static final String VAR_ngsildContext = "ngsildContext";
  public static final String VAR_ngsildData = "ngsildData";

  public static List<String> varsQForClass() {
    return VirtualMachine.varsQVirtualMachine(new ArrayList<String>());
  }
  public static List<String> varsQVirtualMachine(List<String> vars) {
    BaseModel.varsQBaseModel(vars);
    return vars;
  }

  public static List<String> varsFqForClass() {
    return VirtualMachine.varsFqVirtualMachine(new ArrayList<String>());
  }
  public static List<String> varsFqVirtualMachine(List<String> vars) {
    vars.add(VAR_hubId);
    vars.add(VAR_hubResource);
    vars.add(VAR_clusterName);
    vars.add(VAR_clusterResource);
    vars.add(VAR_vmProject);
    vars.add(VAR_vmName);
    vars.add(VAR_os);
    vars.add(VAR_vmResource);
    vars.add(VAR_vmDisplayName);
    vars.add(VAR_location);
    vars.add(VAR_id);
    vars.add(VAR_entityShortId);
    vars.add(VAR_ngsildTenant);
    vars.add(VAR_ngsildPath);
    vars.add(VAR_ngsildContext);
    vars.add(VAR_ngsildData);
    BaseModel.varsFqBaseModel(vars);
    return vars;
  }

  public static List<String> varsRangeForClass() {
    return VirtualMachine.varsRangeVirtualMachine(new ArrayList<String>());
  }
  public static List<String> varsRangeVirtualMachine(List<String> vars) {
    vars.add(VAR_location);
    vars.add(VAR_ngsildData);
    BaseModel.varsRangeBaseModel(vars);
    return vars;
  }

  public static final String DISPLAY_NAME_hubId = "ACM Hub";
  public static final String DISPLAY_NAME_hubResource = "hub auth resource";
  public static final String DISPLAY_NAME_clusterName = "cluster name";
  public static final String DISPLAY_NAME_clusterResource = "cluster auth resource";
  public static final String DISPLAY_NAME_vmProject = "VM project";
  public static final String DISPLAY_NAME_vmName = "VM name";
  public static final String DISPLAY_NAME_os = "OS";
  public static final String DISPLAY_NAME_vmResource = "VM auth resource";
  public static final String DISPLAY_NAME_vmDisplayName = "VM display name";
  public static final String DISPLAY_NAME_description = "description";
  public static final String DISPLAY_NAME_locationColors = "area served colors";
  public static final String DISPLAY_NAME_locationTitles = "area served titles";
  public static final String DISPLAY_NAME_locationLinks = "area served links";
  public static final String DISPLAY_NAME_location = "location";
  public static final String DISPLAY_NAME_id = "entity ID";
  public static final String DISPLAY_NAME_entityShortId = "short entity ID";
  public static final String DISPLAY_NAME_ngsildTenant = "NGSILD-Tenant";
  public static final String DISPLAY_NAME_ngsildPath = "NGSILD-Path";
  public static final String DISPLAY_NAME_ngsildContext = "NGSILD context";
  public static final String DISPLAY_NAME_ngsildData = "NGSILD data";

  @Override
  public String idForClass() {
    return vmResource;
  }

  @Override
  public String titleForClass() {
    return objectTitle;
  }

  @Override
  public String nameForClass() {
    return vmDisplayName;
  }

  @Override
  public String classNameAdjectiveSingularForClass() {
    return VirtualMachine.NameAdjectiveSingular_enUS;
  }

  @Override
  public String descriptionForClass() {
    return description;
  }

  @Override
  public String classStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/vm/%s";
  }

  @Override
  public String classStringFormatUrlDisplayPageForClass() {
    return null;
  }

  @Override
  public String classStringFormatUrlUserPageForClass() {
    return "%s/en-us/user/vm/%s";
  }

  @Override
  public String classStringFormatUrlDownloadForClass() {
    return null;
  }

  public static String displayNameForClass(String var) {
    return VirtualMachine.displayNameVirtualMachine(var);
  }
  public static String displayNameVirtualMachine(String var) {
    switch(var) {
    case VAR_hubId:
      return DISPLAY_NAME_hubId;
    case VAR_hubResource:
      return DISPLAY_NAME_hubResource;
    case VAR_clusterName:
      return DISPLAY_NAME_clusterName;
    case VAR_clusterResource:
      return DISPLAY_NAME_clusterResource;
    case VAR_vmProject:
      return DISPLAY_NAME_vmProject;
    case VAR_vmName:
      return DISPLAY_NAME_vmName;
    case VAR_os:
      return DISPLAY_NAME_os;
    case VAR_vmResource:
      return DISPLAY_NAME_vmResource;
    case VAR_vmDisplayName:
      return DISPLAY_NAME_vmDisplayName;
    case VAR_description:
      return DISPLAY_NAME_description;
    case VAR_locationColors:
      return DISPLAY_NAME_locationColors;
    case VAR_locationTitles:
      return DISPLAY_NAME_locationTitles;
    case VAR_locationLinks:
      return DISPLAY_NAME_locationLinks;
    case VAR_location:
      return DISPLAY_NAME_location;
    case VAR_id:
      return DISPLAY_NAME_id;
    case VAR_entityShortId:
      return DISPLAY_NAME_entityShortId;
    case VAR_ngsildTenant:
      return DISPLAY_NAME_ngsildTenant;
    case VAR_ngsildPath:
      return DISPLAY_NAME_ngsildPath;
    case VAR_ngsildContext:
      return DISPLAY_NAME_ngsildContext;
    case VAR_ngsildData:
      return DISPLAY_NAME_ngsildData;
    default:
      return BaseModel.displayNameBaseModel(var);
    }
  }

  public static String descriptionVirtualMachine(String var) {
    if(var == null)
      return null;
    switch(var) {
    case VAR_hubId:
      return "The name of the ACM Hub for this cluster in Prometheus Keycloak Proxy. ";
    case VAR_hubResource:
      return "The unique authorization resource for the hub for multi-tenancy";
    case VAR_clusterName:
      return "The name of this cluster";
    case VAR_clusterResource:
      return "The unique authorization resource for the cluster for multi-tenancy";
    case VAR_vmProject:
      return "The project or namespace of this VM";
    case VAR_vmName:
      return "The name of this VM";
    case VAR_os:
      return "The operating system of this VM";
    case VAR_vmResource:
      return "The unique authorization resource for the VM for multi-tenancy";
    case VAR_vmDisplayName:
      return "The display name of this VM";
    case VAR_description:
      return "A description of this VM";
    case VAR_locationColors:
      return "The colors of each location Paths. ";
    case VAR_locationTitles:
      return "The titles of each location Paths. ";
    case VAR_locationLinks:
      return "The links of each location Paths. ";
    case VAR_location:
      return "Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon";
    case VAR_id:
      return "A unique ID for this Smart Data Model";
    case VAR_entityShortId:
      return "A short ID for this Smart Data Model";
    case VAR_ngsildTenant:
      return "The NGSILD-Tenant or Fiware-Service";
    case VAR_ngsildPath:
      return "The NGSILD-Path or Fiware-ServicePath";
    case VAR_ngsildContext:
      return "The NGSILD context URL for @context data";
    case VAR_ngsildData:
      return "The NGSILD data with @context from the context broker";
      default:
        return BaseModel.descriptionBaseModel(var);
    }
  }

  public static String classSimpleNameVirtualMachine(String var) {
    switch(var) {
    case VAR_hubId:
      return "String";
    case VAR_hubResource:
      return "String";
    case VAR_clusterName:
      return "String";
    case VAR_clusterResource:
      return "String";
    case VAR_vmProject:
      return "String";
    case VAR_vmName:
      return "String";
    case VAR_os:
      return "String";
    case VAR_vmResource:
      return "String";
    case VAR_vmDisplayName:
      return "String";
    case VAR_description:
      return "String";
    case VAR_locationColors:
      return "List";
    case VAR_locationTitles:
      return "List";
    case VAR_locationLinks:
      return "List";
    case VAR_location:
      return "Point";
    case VAR_id:
      return "String";
    case VAR_entityShortId:
      return "String";
    case VAR_ngsildTenant:
      return "String";
    case VAR_ngsildPath:
      return "String";
    case VAR_ngsildContext:
      return "String";
    case VAR_ngsildData:
      return "JsonObject";
      default:
        return BaseModel.classSimpleNameBaseModel(var);
    }
  }

  public static Integer htmColumnVirtualMachine(String var) {
    switch(var) {
    case VAR_hubId:
      return 1;
    case VAR_clusterName:
      return 1;
    case VAR_vmProject:
      return 2;
    case VAR_vmName:
      return 3;
    case VAR_os:
      return 4;
      default:
        return BaseModel.htmColumnBaseModel(var);
    }
  }

  public static Integer htmRowVirtualMachine(String var) {
    switch(var) {
    case VAR_hubId:
      return 3;
    case VAR_clusterName:
      return 3;
    case VAR_clusterResource:
      return 3;
    case VAR_vmProject:
      return 3;
    case VAR_vmName:
      return 3;
    case VAR_os:
      return 3;
    case VAR_description:
      return 3;
    case VAR_location:
      return 10;
    case VAR_id:
      return 3;
    case VAR_ngsildTenant:
      return 5;
    case VAR_ngsildPath:
      return 5;
    case VAR_ngsildContext:
      return 5;
    case VAR_ngsildData:
      return 5;
      default:
        return BaseModel.htmRowBaseModel(var);
    }
  }

  public static Integer htmCellVirtualMachine(String var) {
    switch(var) {
    case VAR_hubId:
      return 1;
    case VAR_clusterName:
      return 1;
    case VAR_clusterResource:
      return 2;
    case VAR_vmProject:
      return 2;
    case VAR_vmName:
      return 3;
    case VAR_os:
      return 4;
    case VAR_description:
      return 2;
    case VAR_location:
      return 1;
    case VAR_id:
      return 4;
    case VAR_ngsildTenant:
      return 1;
    case VAR_ngsildPath:
      return 2;
    case VAR_ngsildContext:
      return 3;
    case VAR_ngsildData:
      return 4;
      default:
        return BaseModel.htmCellBaseModel(var);
    }
  }

  public static Integer lengthMinVirtualMachine(String var) {
    switch(var) {
      default:
        return BaseModel.lengthMinBaseModel(var);
    }
  }

  public static Integer lengthMaxVirtualMachine(String var) {
    switch(var) {
      default:
        return BaseModel.lengthMaxBaseModel(var);
    }
  }

  public static Integer maxVirtualMachine(String var) {
    switch(var) {
      default:
        return BaseModel.maxBaseModel(var);
    }
  }

  public static Integer minVirtualMachine(String var) {
    switch(var) {
      default:
        return BaseModel.minBaseModel(var);
    }
  }
}

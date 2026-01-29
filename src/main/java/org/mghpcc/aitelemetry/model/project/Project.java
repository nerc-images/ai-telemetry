package org.mghpcc.aitelemetry.model.project;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.search.list.SearchList;
import org.mghpcc.aitelemetry.model.BaseModel;
import org.mghpcc.aitelemetry.model.cluster.Cluster;
import org.mghpcc.aitelemetry.model.hub.Hub;
import org.mghpcc.aitelemetry.model.tenant.Tenant;

import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

/**
 * Order: 10
 * Description: A research project using AI and GPUs
 * AName: an project
 * PluralName: projects
 * Icon: <i class="fa-regular fa-people-line"></i>
 * Sort.asc: hubId
 * Sort.asc: clusterName
 * Sort.asc: projectName
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/project
 * EditPageUri: /en-us/edit/project/{projectResource}
 * UserPageUri: /en-us/user/project/{projectResource}
 * ApiUri: /en-us/api/project
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * 
 * AuthGroup:
 *   HubAdmin:
 *     GET:
 *   Admin:
 *     GET:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     DELETE:
 *     Admin:
 *     SuperAdmin:
 */
public class Project extends ProjectGen<BaseModel> {

  /**
   * DocValues: true
   * Persist: true
   * DisplayName: tenant auth resource
   * Description: The unique authorization resource for the tenant for multi-tenancy
   * AuthorizationResource: TENANT
   * Relate: Tenant.tenantResource
   * HtmRowTitleOpen: project details
   * HtmRow: 3
   * HtmCell: 0
   **/
  protected void _tenantResource(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: ACM cluster name
   * Description: The actual name of the ACM local cluster. 
   * Facet: true
   **/
  protected void _localClusterName(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: ACM Hub
   * Description: The name of the ACM Hub for this cluster in Prometheus Keycloak Proxy. 
   * HtmRow: 3
   * HtmCell: 1
   * HtmColumn: 1
   * Facet: true
   * DefaultFacet: true
   **/
  protected void _hubId(Wrap<String> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: hub auth resource
   * Description: The unique authorization resource for the hub for multi-tenancy
   * Facet: true
   * Relate: Hub.hubResource
   * AuthorizationResource: HUB
   **/
  protected void _hubResource(Wrap<String> w) {
    w.o(String.format("%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: cluster name
   * Description: The name of this cluster
   * HtmRow: 3
   * HtmCell: 3
   * HtmColumn: 2
   * Facet: true
   * DefaultFacet: true
   **/
  protected void _clusterName(Wrap<String> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: cluster auth resource
   * Description: The unique authorization resource for the cluster for multi-tenancy
   * Facet: true
   * AuthorizationResource: CLUSTER
   * Relate: Cluster.clusterResource
   **/
  protected void _clusterResource(Wrap<String> w) {
    w.o(String.format("%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: project name
   * Description: The name of this project
   * HtmRow: 3
   * HtmCell: 5
   * HtmColumn: 3
   * Facet: true
   **/
  protected void _projectName(Wrap<String> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: project auth resource
   * Description: The unique authorization resource for the project for multi-tenancy
   * Facet: true
   * AuthorizationResource: PROJECT
   * VarId: true
   **/
  protected void _projectResource(Wrap<String> w) {
    w.o(String.format("%s-%s-%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, clusterName, Project.CLASS_AUTH_RESOURCE, projectName));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * DisplayName: project display name
   * Description: The display name of this project
   * Facet: true
   * VarName: true
   **/
  protected void _projectDisplayName(Wrap<String> w) {
    w.o(String.format("%s project in the %s cluster of %s hub", projectName, clusterName, hubId));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: description
   * Description: A description of this project
   * HtmRow: 3
   * HtmCell: 7
   * Facet: true
   * VarDescription: true
   * Multiline: true
   **/
  protected void _description(Wrap<String> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: GPU enabled
   * Description: Whether GPUs are enabled for this project. 
   * HtmRow: 3
   * HtmCell: 8
   **/
  protected void _gpuEnabled(Wrap<Boolean> w) {
    w.o(false);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: pod restarts
   * Description: The number of pod restarts in this project. 
   * HtmRowTitleOpen: health checks
   * HtmRow: 4
   * HtmCell: 0
   **/
  protected void _podRestartCount(Wrap<Integer> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: pods restarting
   * Description: The names of the pods restarting in this project. 
   * HtmRow: 4
   * HtmCell: 1
   **/
  protected void _podsRestarting(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: pods terminating
   * Description: The number of pods terminating in this project. 
   * HtmRow: 4
   * HtmCell: 1
   **/
  protected void _podTerminatingCount(Wrap<Integer> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: pods terminating
   * Description: The names of the pods terminating in this project. 
   * HtmRow: 4
   * HtmCell: 2
   **/
  protected void _podsTerminating(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: Full PVCs count
   * Description: The number of persistent volume claims that are running out of disk space in this project. 
   * HtmRow: 4
   * HtmCell: 3
   **/
  protected void _fullPvcsCount(Wrap<Integer> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: pods restarting
   * Description: The names of the persistent volume claims that are running out of disk space in this project. 
   * HtmRow: 4
   * HtmCell: 4
   **/
  protected void _fullPvcs(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: namespace terminating
   * Description: Whether namespace is stuck in terminating status. 
   * HtmRow: 4
   * HtmCell: 5
   **/
  protected void _namespaceTerminating(Wrap<Boolean> w) {
    w.o(false);
  }
}

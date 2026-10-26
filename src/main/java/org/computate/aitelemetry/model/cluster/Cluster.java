package org.computate.aitelemetry.model.cluster;


import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import javax.measure.Quantity;

import org.apache.commons.lang3.StringUtils;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.api.BaseApiServiceImpl;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.aitelemetry.config.ConfigKeys;
import org.computate.aitelemetry.model.BaseModel;
import org.computate.aitelemetry.model.hub.Hub;

import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Point;
import systems.uom.quantity.Information;

/**
 * Order: 7
 * Description: A Red Hat OpenShift cluster containing GPUs
 * AName: an OpenShift cluster
 * Icon: <i class="{{ FONTAWESOME_STYLE }} fa-server"></i>
 * Sort.asc: hubId
 * Sort.asc: clusterName
 * Rows: 100
 *
 * SearchPageUri: /en-us/search/cluster
 * EditPageUri: /en-us/edit/cluster/{clusterResource}
 * UserPageUri: /en-us/user/cluster/{clusterResource}
 * ApiUri: /en-us/api/cluster
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
 **/
public class Cluster extends ClusterGen<BaseModel> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: ACM Hub
   * Description: The name of the ACM Hub for this cluster in Prometheus Keycloak Proxy. 
   * HtmRow: 4
   * HtmCell: 1
   * HtmColumn: 1
   * HtmRowTitleOpen: cluster details
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
   * HtmRow: 4
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
   * DisplayName: hub cluster
   * Description: Whether this cluster is a hub cluster
   * HtmRow: 4
   * HtmCell: 4
   * Facet: true
   **/
  protected void _hubCluster(Wrap<Boolean> w) {
    w.o(false);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * DisplayName: cluster name for metrics
   * Description: The name of this cluster in ACM Observability metrics
   * HtmRow: 4
   * HtmCell: 5
   * Facet: true
   **/
  protected void _clusterNameMetrics(Wrap<String> w) {
    w.o(hubCluster ? "local-cluster" : clusterName);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: cluster auth resource
   * Description: The unique authorization resource for the cluster for multi-tenancy
   * Facet: true
   * VarId: true
   * AuthorizationResource: CLUSTER
   * Unique: true
   **/
  protected void _clusterResource(Wrap<String> w) {
    w.o(String.format("%s-%s-%s-%s", Hub.CLASS_AUTH_RESOURCE, hubId, Cluster.CLASS_AUTH_RESOURCE, Optional.ofNullable(clusterName).orElse("")));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * DisplayName: unique name
   * Description: The unique name of this cluster
   * HtmRow: 4
   * HtmCell: 6
   * Facet: true
   * VarName: true
   **/
  protected void _uniqueName(Wrap<String> w) {
    w.o(String.format("%s in %s Hub", Optional.ofNullable(clusterName).orElse("local-cluster"), hubId));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: description
   * Description: A description of this cluster
   * HtmRow: 4
   * HtmCell: 7
   * VarDescription: true
   * Multiline: true
   **/
  protected void _description(Wrap<String> w) {
    w.o(String.format("Contains %s AI nodes and %s GPU devices", aiNodesTotal, gpuDevicesTotal));
  }


  /**
   * {@inheritDoc}
  
   * LocationColor: true
   * Indexed: true
   * Stored: true
   * DisplayName: area served colors
   * Description: The colors of each location Paths. 
   */
  protected void _locationColors(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * LocationTitle: true
   * Indexed: true
   * Stored: true
   * DisplayName: area served titles
   * Description: The titles of each location Paths. 
   */
  protected void _locationTitles(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * LocationUrl: true
   * Indexed: true
   * Stored: true
   * DisplayName: area served links
   * Description: The links of each location Paths. 
   */
  protected void _locationLinks(List<String> l) {
  }


  /**
   * {@inheritDoc}
   * FiwareType: geo:point
   * Location: true
   * DocValues: true
   * Persist: true
   * DisplayName: location
   * Description: Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon
   * HtmRow: 4
   * HtmCell: 8
   * Facet: true
   **/
  protected void _location(Wrap<Point> w) {
    w.o(staticSetLocation(siteRequest_, siteRequest_.getConfig().getString(ComputateConfigKeys.DEFAULT_MAP_LOCATION)));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: entity ID
   * Description: A unique ID for this Smart Data Model
   * HtmRowTitle: NGSI-LD data
   * HtmRow: 6
   * HtmCell: 1
   * Facet: true
   */
  protected void _id(Wrap<String> w) {
    w.o(String.format("urn:ngsi-ld:%s:%s", CLASS_SIMPLE_NAME, toId(Optional.ofNullable(clusterName).orElse(""))));
  }

  /**
   * {@inheritDoc}
   * DisplayName: short entity ID
   * Description: A short ID for this Smart Data Model
   * DocValues: true
   * Facet: true
   */
  protected void _entityShortId(Wrap<String> w) {
    if(id != null) {
      w.o(StringUtils.substringAfter(id, String.format("urn:ngsi-ld:%s:", CLASS_SIMPLE_NAME)));
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: NGSILD-Tenant
   * Description: The NGSILD-Tenant or Fiware-Service
   * HtmRow: 6
   * HtmCell: 2
   * Facet: true
   */
  protected void _ngsildTenant(Wrap<String> w) {
    w.o(System.getenv("NGSILD_TENANT"));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: NGSILD-Path
   * Description: The NGSILD-Path or Fiware-ServicePath
   * HtmRow: 6
   * HtmCell: 3
   * Facet: true
   */
  protected void _ngsildPath(Wrap<String> w) {
    w.o(System.getenv("NGSILD_PATH"));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: NGSILD context
   * Description: The NGSILD context URL for @context data
   * HtmRow: 6
   * HtmCell: 4
   * Facet: true
   */
  protected void _ngsildContext(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ComputateConfigKeys.CONTEXT_BROKER_CONTEXT));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: NGSILD data
   * Description: The NGSILD data with @context from the context broker
   * HtmRow: 6
   * HtmCell: 5
   * Facet: true
   * Multiline: true
   */
  protected void _ngsildData(Wrap<JsonObject> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: AI nodes total
   * Description: The total number of AI nodes on this cluster. 
   * HtmRowTitleOpen: cluster totals
   * HtmRow: 5
   * HtmCell: 1
   * Facet: true
   */
  protected void _aiNodesTotal(Wrap<Integer> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: GPU devices total
   * Description: The total number of GPU devices on this cluster. 
   * HtmRow: 5
   * HtmCell: 2
   * Facet: true
   */
  protected void _gpuDevicesTotal(Wrap<Integer> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: VMs total
   * Description: The total number of VMs on this cluster. 
   * HtmRow: 5
   * HtmCell: 3
   * Facet: true
   */
  protected void _vmsTotal(Wrap<Integer> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: CPU cores total
   * Description: The total number of CPU cores on this cluster. 
   * HtmRow: 5
   * HtmCell: 4
   * Facet: true
   */
  protected void _cpuCoresTotal(Wrap<Integer> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: memory bytes total
   * Description: The total number of memory bytes on this cluster. 
   * HtmRow: 5
   * HtmCell: 4
   * Facet: true
   */
  protected void _memoryBytesTotal(Wrap<Long> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: Ceph used bytes
   * Description: The amount of Ceph storage used on this cluster. 
   * HtmRow: 5
   * HtmCell: 4
   * Facet: true
   */
  protected void _cephUsedBytes(Wrap<Quantity<Information>> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: Ceph capacity bytes
   * Description: The amount of Ceph storage total capacity on this cluster. 
   * HtmRow: 5
   * HtmCell: 4
   * Facet: true
   */
  protected void _cephCapacityBytes(Wrap<Quantity<Information>> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * DisplayName: Grafana GPU utilization
   * Description: Explore this cluster's GPU utilization in Grafana. 
   * HtmRow: 5
   * HtmRowTitleOpen: Useful URLs
   * HtmCell: 3
   * Facet: true
   * Link: true
   */
  protected void _grafanaUrl(Wrap<String> w) {
    w.o(String.format("%s/explore?orgId=1&left=%s"
        , siteRequest_.getConfig().getString(ConfigKeys.GRAFANA_BASE_URL, ConfigKeys.GRAFANA_BASE_URL)
        , BaseApiServiceImpl.urlEncode(
            String.format("[\"now-1h\",\"now\",\"observability-metrics\",{\"exemplar\":true,\"expr\":\"DCGM_FI_DEV_GPU_UTIL{cluster=\\\"%s\\\"}\"}]"
                , Optional.ofNullable(clusterName).map(n -> BaseApiServiceImpl.urlEncode(n)).orElse("-----")
            )
        )
    ));
  }

  /**
   * HtmColumn: 3
   */
  @Override
  protected void _modified(Wrap<ZonedDateTime> w) {
    super._modified(w);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: Storage
   * Description: {{ 'Warning, no storage metrics were found. The system cannot determine the health of the storage of this cluster. ' if (cephUsedBytes is not defined or cephCapacityBytes is not defined) else 'Ceph storage status' }}
   * HtmRowTitleOpen: {{ result.clusterName }} cluster status
   * HtmRow: 3
   * HtmCell: 0
   * Option:
   *   success: Successful
   *   neutral: Neutral
   *   warning: Warning
   *   danger: Danger
   * wa-step:
   *   start: true
   *   end: true
   *   completed: "{{ result.statusStorage == 'success' }}"
   *   variant: "{{ result.statusStorage }}"
   * Icon: <i slot="icon" class="{{ FONTAWESOME_STYLE }} fa-{{ 'check' if result.statusStorage == 'success' else ('check' if result.statusStorage == 'neutral' else ('bell-exclamation' if result.statusStorage == 'danger' else result.statusStorage)) }}"></i>
   **/
  protected void _statusStorage(Wrap<String> w) {
    w.o((cephUsedBytes == null || cephCapacityBytes == null) ? "warning" : "neutral");
  }
}



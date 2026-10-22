
package org.computate.aitelemetry.model;

import java.math.BigDecimal;
import java.util.List;

import javax.measure.Quantity;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Length;

import org.apache.commons.lang3.StringUtils;
import org.computate.search.wrap.Wrap;
import org.computate.aitelemetry.config.ConfigKeys;
import org.computate.aitelemetry.request.SiteRequest;
import org.computate.vertx.config.ComputateConfigKeys;

import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

/**
 * Fiware: true
 * Order: 4
 * Description.enUS: A map model
 * AName.enUS: a map model
 * Icon: <i class="fa-regular  fa-map-location-dot"></i>
 * Rows: 100
 * Ignore: true
 * 
 * SearchPageUri: /en-us/search/map-model
 * ApiUri: /en-us/api/map-model
 * ApiMethod:
 *   Search:
 *   GET:
 * AuthGroup:
 *   MapModelViewer:
 *     GET:
 *   Admin:
 *     GET:
 **/
public class MapModel extends MapModelGen<BaseModel> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: name
   * DisplayName.frFR: nom
   * Description.enUS: The name. 
   * Description.frFR: Le nom. 
   * HtmRowTitleOpen.enUS: name and description
   * HtmRowTitleOpen.frFR: nom et description
   * HtmColumn: 0
   * VarName: true
   * HtmRow: 4
   * HtmCell: 0
   * Facet: true
   * LocationTitle: true
   * AreaTitle: true
   **/
  protected void _name(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: description
   * DisplayName.frFR: description
   * Description.enUS: The description. 
   * Description.frFR: La description. 
   * HtmColumn: 3
   * VarDescription: true
   * HtmRow: 4
   * HtmCell: 1
   * Facet: true
   **/
  protected void _description(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * HtmRowTitleOpen.enUS: GeoJSON details
   * HtmRowTitleOpen.frFR: Détails GeoJSON
   * FiwareType: geo:point
   * Location: true
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: location
   * DisplayName.frFR: emplacement
   * Description.enUS: Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon
   * Description.frFR: Référence Geojson à l'élément. Il peut s'agir d'un Point, LineString, Polygon, MultiPoint, MultiLineString ou MultiPolygon
   * HtmRow: 4
   * HtmCell: 2
   * Facet: true
   **/
  protected void _location(Wrap<Point> w) {
    w.o(staticSetLocation(siteRequest_, siteRequest_.getConfig().getString(ComputateConfigKeys.DEFAULT_MAP_LOCATION)));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: id
   * DisplayName.frFR: identifiant
   * Description.enUS: Unique identifier of the entity
   * Description.frFR: Identifiant unique de l'entité
   * HtmRowTitleOpen.enUS: NGSI-LD details
   * HtmRowTitleOpen.frFR: Détails NGSI-LD
   * HtmRow: 5
   * HtmCell: 0
   * Facet: true
   **/
  protected void _id(Wrap<String> w) {
    w.o(String.format("urn:ngsi-ld:%s:%s", getClass().getSimpleName(), toId(name)));
  }

  /**
   * {@inheritDoc}
   * DisplayName.enUS: short entity ID
   * DisplayName.frFR: identifiant court de l'entité
   * Description.enUS: A short ID for this Smart Data Model
   * Description.frFR: Un identifiant court pour ce modèle de données intelligent
   * DocValues: true
   * Persist: true
   * Facet: true
   * VarId: true
   */
  protected void _entityShortId(Wrap<String> w) {
    if(id != null) {
      w.o(StringUtils.substringAfter(id, String.format("urn:ngsi-ld:%s:", getClass().getSimpleName())));
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: NGSILD-Tenant
   * DisplayName.frFR: NGSILD-Tenant
   * Description.enUS: The NGSILD-Tenant or Fiware-Service
   * Description.frFR: Le NGSILD-Tenant ou Fiware-Service
   * HtmRow: 5
   * HtmCell: 1
   * Facet: true
   */
  protected void _ngsildTenant(Wrap<String> w) {
    w.o(System.getenv("NGSILD_TENANT"));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: NGSILD-Path
   * DisplayName.frFR: NGSILD-Path
   * Description.enUS: The NGSILD-Path or Fiware-ServicePath
   * Description.frFR: Le NGSILD-Path ou Fiware-ServicePath
   * HtmRow: 5
   * HtmCell: 2
   * Facet: true
   */
  protected void _ngsildPath(Wrap<String> w) {
    w.o(System.getenv("NGSILD_PATH"));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: NGSILD context
   * DisplayName.frFR: NGSILD context
   * Description.enUS: The NGSILD context URL for @context data
   * Description.frFR: L'URL du contexte NGSILD pour les données @context
   * HtmRow: 5
   * HtmCell: 3
   * Facet: true
   */
  protected void _ngsildContext(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ComputateConfigKeys.CONTEXT_BROKER_CONTEXT));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: NGSILD data
   * DisplayName.frFR: données NGSILD
   * Description.enUS: The NGSILD data with @context from the context broker
   * Description.frFR: Les données NGSILD avec @context du context broker
   * HtmRow: 5
   * HtmCell: 4
   * Facet: true
   * Multiline: true
   */
  protected void _ngsildData(Wrap<JsonObject> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: color
   * DisplayName.frFR: couleur
   * Description.enUS: The color of the map item
   * Description.frFR: La couleur de l'élément de la carte
   * HtmRow: 4
   * HtmCell: 3
   * Facet: true
   * Color: true
   * LocationColor: true
   * AreaColor: true
   */
  protected void _color(Wrap<String> w) {
    w.o("magenta");
  }

  @Override
  protected void _classCanonicalNames(List<String> l) { 
    l.add(MapModel.class.getCanonicalName());
    super._classCanonicalNames(l);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: altitude
   * Description.enUS: The altitude of the model. 
   * HtmRow: 6
   * HtmCell: 0
   * Facet: true
   * Altitude: true
   **/
  protected void _altitude(Wrap<Quantity<Length>> w) {
    w.o(staticSetAltitude("0 m"));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Facet: true
   * AltitudeMeters: true
   **/
  protected void _altitudeMeters(Wrap<Double> w) {
    if(altitude != null)
      w.o(altitude.to(Units.METRE).getValue().doubleValue());
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: pitch
   * Description.enUS: Rotation around the side-to-side (lateral) axis (e.g., tilting the nose up or down). 
   * HtmRow: 6
   * HtmCell: 1
   * Facet: true
   * Pitch: true
   **/
  protected void _pitch(Wrap<Quantity<Angle>> w) {
    w.o(Quantities.getQuantity(Math.PI / 2, Units.RADIAN));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: yaw
   * Description.enUS: Rotation around the vertical axis (e.g., turning the nose left or right). 
   * HtmRow: 6
   * HtmCell: 2
   * Facet: true
   * Yaw: true
   **/
  protected void _yaw(Wrap<Quantity<Angle>> w) {
    w.o(Quantities.getQuantity(BigDecimal.ZERO, Units.RADIAN));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: roll
   * Description.enUS: Rotation around the front-to-back (longitudinal) axis (e.g., tilting wings left or right). 
   * HtmRow: 6
   * HtmCell: 3
   * Facet: true
   * Roll: true
   **/
  protected void _roll(Wrap<Quantity<Angle>> w) {
    w.o(Quantities.getQuantity(BigDecimal.ZERO, Units.RADIAN));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * DisplayName.enUS: yaw
   * Description.enUS: Rotation around the vertical axis (e.g., turning the nose left or right). 
   * Rotation: true
   **/
  protected void _rotation(List<Double> l) {
    l.add(pitch.to(Units.RADIAN).getValue().doubleValue());
    l.add(yaw.to(Units.RADIAN).getValue().doubleValue());
    l.add(roll.to(Units.RADIAN).getValue().doubleValue());
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: GLTF path
   * Description.enUS: The path within the static content where the 3D GLTF file for this model is found. 
   * HtmRow: 6
   * HtmCell: 4
   * Facet: true
   * GLTF: true
   **/
  protected void _gltfPath(Wrap<String> w) {
  }
}

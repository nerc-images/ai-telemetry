package org.mghpcc.aitelemetry.model.tenant;

import io.vertx.ext.web.client.WebClient;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.api.service.WebApiServiceGen;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import com.hubspot.jinjava.Jinjava;
import io.vertx.core.WorkerExecutor;
import io.vertx.sqlclient.Pool;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.auth.authorization.AuthorizationProvider;

/**
 * Translate: false
 * Gen: false
 * Generated: true
 **/
@WebApiServiceGen
@ProxyGen
public interface TenantEnUSGenApiService {

  public void searchTenant(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void getTenant(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void patchTenant(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void patchTenantFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void postTenant(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void postTenantFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deleteTenant(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deleteTenantFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void putimportTenant(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void putimportTenantFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void searchpageTenant(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void editpageTenant(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deletefilterTenant(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deletefilterTenantFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
}

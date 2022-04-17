package com.ethen.registry.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;

/**
 * 服务状态变更事件监听
 * <p>
 * <li>{@link EurekaInstanceCanceledEvent} 服务下线事件</li>
 * <li>{@link EurekaInstanceRegisteredEvent} 服务注册事件</li>
 * <li>{@link EurekaInstanceRenewedEvent} 服务续约事件</li>
 * <li>{@link EurekaRegistryAvailableEvent} 注册中心可访问事件</li>
 * <li>{@link EurekaServerStartedEvent} 注册服务器启动事件</li>
 *
 * @author ethen
 * @since 2022/04/17
 */
@Slf4j
@Component
public class EurekaStatusChangeListener {

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.debug("@@eureka server started {}", event.getTimestamp());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.debug("@@eureka server available {}", event.getTimestamp());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        log.info("@@eureka received instance {} registered", event.getInstanceInfo().toString());
    }

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.error("@@eureka canceled instance {}", event.getServerId());
    }

}

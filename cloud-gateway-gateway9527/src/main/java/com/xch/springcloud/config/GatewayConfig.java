package com.xch.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiech
 * @create 2021-03-22 14:31
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder builder=routeLocatorBuilder.routes();
        builder.route("path_route_atguigu",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return builder.build();
    }
}

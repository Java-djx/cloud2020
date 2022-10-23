package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/23 15:35
 * @creatd 这是gateWay路由配置
 */
@Configuration
public class GateWayConfig {

    /**
     * 构造一个路由对象 指定路由规则
     * 当访问地址为 http:localhost:9527/guonei 会自动装发到地址 https://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        //获取路由对象
        RouteLocatorBuilder.Builder routes = builder.routes();
        //https://news.baidu.com/guonei
        routes.route("path route_atguigu",
                r -> r.path("/guonei").
                        uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }

    /**
     * 构造一个路由对象 指定路由规则
     * 当访问地址为 http:localhost:9527/guoji 会自动装发到地址 https://news.baidu.com/guoji
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        //获取路由对象
        RouteLocatorBuilder.Builder routes = builder.routes();
        //https://news.baidu.com/guonei
        routes.route("path route_atguigu2",
                r -> r.path("/guoji").
                        uri("https://news.baidu.com/guoji")).build();
        return routes.build();
    }

}

package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  Zookeeper消费端
 *  @author 戴俊翔
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class OrderZK80 {

    public static void main(String[] args)
    {
        SpringApplication.run(OrderZK80.class,args);
    }
}

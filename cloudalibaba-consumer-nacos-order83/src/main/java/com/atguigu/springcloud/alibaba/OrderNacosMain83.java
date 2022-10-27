package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/24 20:44
 */
@SpringBootApplication
@EnableDiscoveryClient //开启 nacos 配置中心
public class OrderNacosMain83 {

    public static void main(String[] args)
    {
        SpringApplication.run(OrderNacosMain83.class,args);
    }
}

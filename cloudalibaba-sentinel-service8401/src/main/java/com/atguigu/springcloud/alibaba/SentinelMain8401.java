package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/26 15:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8401 {
    
    public static void main(String[] args){
        SpringApplication.run(SentinelMain8401.class,args);
    }
}

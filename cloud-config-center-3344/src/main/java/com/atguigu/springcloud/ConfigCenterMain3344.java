package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/24 10:06
 * @creatd
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    
    public static void main(String[] args){
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}

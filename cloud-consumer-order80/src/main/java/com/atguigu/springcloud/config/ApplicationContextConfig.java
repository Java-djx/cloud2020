 
package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther 戴俊翔
 * @create 2022年10月18日20:46:50
 * boot主配置类
 */
@Configuration
public class ApplicationContextConfig
{
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
 
 

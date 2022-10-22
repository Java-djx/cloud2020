package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author djx
 * @date 2022年10月22日19:53:28
 */
@SpringBootApplication
@EnableHystrixDashboard //开启Hystrix 可视化页面
public class HystrixDashboardMain9001 {

    public static void main(String[] args){
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }

}


package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @auther 戴俊翔
 * @create 2022年10月21日11:04:35
 */

/**
 * 自定义轮循接口
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
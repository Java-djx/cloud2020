package com.atguigu.springcloud.alibaba.service;

import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/26 17:28
 */
@Component
public class OrderQueryService {

    public String queryOrderInfo(String orderId) {
        System.out.println("获取订单信息:" + orderId);
        return "return OrderInfo :" + orderId;
    }
}
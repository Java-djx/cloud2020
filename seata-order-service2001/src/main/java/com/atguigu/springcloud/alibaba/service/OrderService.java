package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * @version 1.0
 * @author: djx
 * @createTime: 2022/10/29 11:49
 */
public interface OrderService {


    /**
     * 创建订单
     */
    void create(Order order);

}

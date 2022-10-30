package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: djx
 * @createTime: 2022/10/29 11:52
 * 创建订单扣减库存，扣减余额,修改订单状态
 * 下订单->减库存->扣余额->改(订单)状态
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    //扣减余额
    @Resource
    private AccountService accountService;

    //扣减库存
    @Resource
    private StorageService storageService;

    /*
     * @param 订单
     * @return kong
     * @author djx
     * @deprecated: Talk is cheap,show me the code
     * @date 2022/10/29 11:58
     */
    @Override
    public void create(Order order) {
        log.info("-----下单开始");
        //创建订单
        orderDao.create(order);
        //远程调用库存服务扣减库存
        log.info("-----order-service中扣减库存开始");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-----order-service中扣减库存开始");
        //远程调用账号服务扣减余额
        log.info("-----order-service中扣减余额开始");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-----order-service中扣减余额结束");
        //修改订单状态为完成
        log.info("-----order-service修改订单状态结束");
        orderDao.update(order.getUserId(), 1);
        log.info("------->order-service中修改订单状态结束");
        log.info("------->下单结束");
    }
}

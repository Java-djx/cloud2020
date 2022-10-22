package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author djx
 * @date 2022年10月22日17:35:48
 * @creatd 消费端给接口提供的服务降级的方法
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {


    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80---paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80---paymentInfo_TimeOut";

    }
}

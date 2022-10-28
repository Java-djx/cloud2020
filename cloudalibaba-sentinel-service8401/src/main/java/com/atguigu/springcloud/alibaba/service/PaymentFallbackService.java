package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/27 22:12
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4441, "当前服务异常,熔断限流降级", new Payment(id, "空空"));
    }
}

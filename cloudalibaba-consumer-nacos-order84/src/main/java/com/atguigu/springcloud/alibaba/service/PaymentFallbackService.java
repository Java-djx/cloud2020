package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/27 21:50
 *  服务降级兜底的方法
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(445,"服务调用失败,服务降级--PaymentFallbackService--paymentSQL",new Payment(id,"errorSerial"));
    }
}

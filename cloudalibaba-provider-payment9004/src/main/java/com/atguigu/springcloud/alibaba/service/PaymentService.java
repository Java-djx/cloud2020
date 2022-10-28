package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 戴俊翔
 * @create 2022年10月27日19:05:08
 */
public interface PaymentService
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
 
 

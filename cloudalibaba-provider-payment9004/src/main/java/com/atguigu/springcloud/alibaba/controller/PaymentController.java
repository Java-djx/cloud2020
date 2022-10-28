
package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 戴俊翔
 * @create 2022年10月27日19:05:08
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;


    /**
     * 查询数据库记录
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        CommonResult<Payment> result = new CommonResult(200, "from mysql,serverPort:  " + serverPort, payment);
        return result;
    }


}
 
 

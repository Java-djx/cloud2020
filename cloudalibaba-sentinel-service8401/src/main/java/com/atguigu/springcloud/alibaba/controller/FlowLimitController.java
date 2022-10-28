package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.OrderQueryService;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/26 15:05
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private OrderQueryService orderQueryService;

    @GetMapping("/getOrder/{id}")
    public String queryOrder1(@PathVariable(value = "id") String id) {

        //模仿异常
        int age = 10 / 0;

        log.info("异常比例");

        return orderQueryService.queryOrderInfo(id);
    }


    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }


    @GetMapping("/testB")
    public String testB() throws ClassNotFoundException {
        log.info(Thread.currentThread().getName() + "\t" + "....testB..." + Class.forName("com.atguigu.springcloud.alibaba.controller.FlowLimitController"));
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        //模仿异常
        int age = 1 / 0;
        log.info("testE 测试数量");
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_testHotKey")
    public String testHotKey(
            @RequestParam(value = "p1", required = false) String p1,
            @RequestParam(value = "p2", required = false) String p2
    ) {
        String returnStr = null;
        try {

            returnStr = "-----testHotKey" + Class.forName("com.atguigu.springcloud.alibaba.controller.FlowLimitController")
                    + p1
                    + p2;
            log.info("****返回结果:" + returnStr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return returnStr;
    }

    /**
     * 服务降级兜底的方法
     *
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey 服务繁忙";
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfegin/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
 
 

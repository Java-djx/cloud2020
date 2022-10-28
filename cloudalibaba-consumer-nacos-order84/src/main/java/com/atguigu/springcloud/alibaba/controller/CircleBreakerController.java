package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/27 19:20
 * 84 订单接口调用 93 94 服务接口
 * ribbon+restTemplate 服务调用
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    /**
     * fallback 系统降级的方法
     * blockHandler： sentinel 降级的方法
     * exceptionsToIgnore： 能够处理的异常类型
     *
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class, NullPointerException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        log.info("返回的结果" + result);
        if (id == 4) {
            log.info("IllegalArgumentException:非法参数异常", IllegalArgumentException.class);
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            log.info("NullPointerException:空指针异常", NullPointerException.class);
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    /**
     * 兜底异常的方法 降级的方法
     *
     * @param id
     * @param e
     * @return
     */
    public CommonResult<Payment> handlerFallback(@PathVariable Long id, Throwable e) {
        return new CommonResult<Payment>(502, "兜底方法handlerFallback,exception" + e.getMessage());
    }


    /**
     * sentinel 限流降级
     *
     * @param id
     * @param blockException
     * @return
     */
    public CommonResult<Payment> blockHandler(@PathVariable Long id, BlockException blockException) {
        return new CommonResult<Payment>(502, "blockHandler兜底方法 sentinel限流没有流水,exception" + blockException.getMessage());
    }

    //启用OpenFegin
    @Resource
    private PaymentService paymentService;

    /**
     * 使用OpenFegin 调用服务者提供的方法
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/openFegin/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }

}

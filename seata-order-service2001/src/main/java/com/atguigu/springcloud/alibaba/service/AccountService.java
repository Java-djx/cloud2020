package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @author: djx
 * @createTime: 2022/10/29 11:49
 * 账号月娥 OpenFegin 接口 扣减余额
 *
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 扣减余额
     * @param userId
     * @param money
     * @return
     */
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}

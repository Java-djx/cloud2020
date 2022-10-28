package com.atguigu.springcloud.alibaba.hander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/27 18:45
 * 自定义的限流处理信息
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(502, "自定义的限流处理信息1......CustomerBlockHandler");
    }


    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(502, "自定义的限流处理信息2......CustomerBlockHandler");
    }
}

package com.atguigu.springcloud.service;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/24 15:42
 */
public interface IMessageProvider {

    //发送消息到MQ
    public String send();

}

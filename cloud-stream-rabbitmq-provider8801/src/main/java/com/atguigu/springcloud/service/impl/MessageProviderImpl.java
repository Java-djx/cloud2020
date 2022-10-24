package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @version 1.0
 * @Author djx
 * @Date 2022/10/24 15:43
 * @creatd 可以理解为是一个消息的发送管道的定义,绑定MQ发送消息到Mq中
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息的管道发送

    @Override
    public String send() {
        String serial  = UUID.randomUUID().toString();
        //管道发送消息
        output.send(MessageBuilder.withPayload(serial)
                .build());
        log.info("***** serial:"+serial);
        return serial;
    }
}

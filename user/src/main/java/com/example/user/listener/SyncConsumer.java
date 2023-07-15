package com.example.user.listener;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "order_topic", selectorExpression = "*",
        consumerGroup = "user-consumer",
        consumeMode = ConsumeMode.ORDERLY,
        messageModel = MessageModel.CLUSTERING)
public class SyncConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("user reserve message:" + s);
    }
}

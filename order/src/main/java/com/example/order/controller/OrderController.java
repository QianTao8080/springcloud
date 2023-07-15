package com.example.order.controller;

import com.example.order.service.OrderService;
import entity.Order;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RocketMQTemplate template;

    @RequestMapping("/{uid}")
    public Object getOrder(@PathVariable long uid) {
        Order order = orderService.getByUid(uid);
        template.syncSend("order_topic", order, 3000);
        return order;
    }

}

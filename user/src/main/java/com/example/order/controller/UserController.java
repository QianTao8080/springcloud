package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate template;

    @RequestMapping("/order")
    public Object queryOrder() {
        template.getForObject("http://order-service/order/1", Integer.class);
        return null;
    }
}

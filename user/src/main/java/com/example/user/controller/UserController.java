package com.example.user.controller;

import com.example.user.openfeign.OrderFeignService;
import com.example.user.service.UserService;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate template;
    @Autowired
    private OrderFeignService orderFeignService;
    @Autowired
    private UserService userService;

    @RequestMapping("/order")
    public Object queryOrder() {
//        template.getForObject("http://order-service/order/1", Integer.class);
        User user = userService.getById(2);
        orderFeignService.getOrder(1);
        return user;
    }
}

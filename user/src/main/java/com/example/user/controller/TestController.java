package com.example.user.controller;

import com.example.user.config.UserPer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
@RefreshScope//使@Value注解 能热更新读到最新配置
public class TestController {

    @Autowired
    private UserPer user;
    @Value("${userper.name}")
    private String name;

    @RequestMapping("user")
    public Object testUser() {
        return user;
    }

    @RequestMapping("name")
    public Object testName(){
        return name;
    }
}

package com.example.user.controller;

import com.example.user.config.UserPer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("/test/")
@RefreshScope//使@Value注解 能热更新读到最新配置
public class TestController {

    @Autowired
    private UserPer user;
    @Value("${userper.name}")
    private String name;
    @Autowired
    private ThreadPoolExecutor executor;
//    @Value("${common.thread.corePoolSize}")
//    private int maxSize;

    @RequestMapping("user")
    public Object testUser() {
        executor.execute(() -> System.out.println("aaaa"));
        return user;
    }

    @RequestMapping("name")
    public Object testName() {
        return name;
    }
}

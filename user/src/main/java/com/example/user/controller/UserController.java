package com.example.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.user.openfeign.OrderFeignService;
import com.example.user.service.UserService;
import com.google.common.collect.Maps;
import dto.PageParam;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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
        orderFeignService.getOrder(1);
        return null;
    }

    //    @RequestMapping("/list")
    @PostMapping("/list")
    public Object queryUserByPage(PageParam param) {
        IPage<User> page = userService.queryByPage(param.getPageNo(), param.getPageSize(), param.getName());
        Map<String, Object> result = Maps.newHashMap();
        result.put("list", page.getRecords());
        result.put("pageNo", page.getCurrent());
        result.put("pageNum0", page.getPages());
        return result;
    }
}

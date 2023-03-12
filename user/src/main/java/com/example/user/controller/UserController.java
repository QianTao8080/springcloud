package com.example.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.user.openfeign.OrderFeignService;
import com.example.user.service.UserService;
import dto.PageParam;
import dto.PageResult;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private RestTemplate template;
    @Autowired
    private OrderFeignService orderFeignService;
    @Autowired
    private UserService userService;

    @RequestMapping("order")
    public Object queryOrder() {
//        template.getForObject("http://order-service/order/1", Integer.class);
        return orderFeignService.getOrder(1);
    }

    @PostMapping("list")
    public Object queryUserByPage(@RequestBody PageParam param) {
        IPage<User> page = userService.queryByPage(param.getPageNo(), param.getPageSize(), param.getName());
        PageResult<User> result = new PageResult<>();
        result.setResult(page.getRecords());
        result.setPageNum(page.getPages());
        result.setTotal(page.getTotal());
        result.setParam(param);
        return result;
    }

    @PostMapping("add")
    public Object addUser(User user) {
        userService.addUser(user);
        return user;
    }
}

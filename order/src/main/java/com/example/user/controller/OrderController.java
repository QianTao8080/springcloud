package com.example.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/{id}")
    public Object getOrder(@PathVariable int id) {
        System.out.println("~~~~~~~~~~~~~~~~~" + id);
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.DELETE)
    public Object add(@PathVariable int id) {
        System.out.println("------------------" + id);
        return null;
    }
}

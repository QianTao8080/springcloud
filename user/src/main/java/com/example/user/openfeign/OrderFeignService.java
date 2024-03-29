package com.example.user.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order-service", path = "/order")
public interface OrderFeignService {

    @RequestMapping("/{uid}")
    public Object getOrder(@PathVariable(name = "uid") int uid);
}

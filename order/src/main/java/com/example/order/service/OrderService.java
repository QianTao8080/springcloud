package com.example.order.service;

import com.example.order.dao.OrderDao;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public Order getByUid(long uid){
        return orderDao.getByUid(uid);
    }
}

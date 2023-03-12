package com.example.order.dao;

import com.example.order.mappr.IOrderMapper;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

    @Autowired
    private IOrderMapper mapper;

    public Order getByUid(long uid){
        return mapper.selectById(uid);
    }
}

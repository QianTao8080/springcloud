package com.example.order.mappr;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOrderMapper extends BaseMapper<Order> {
}

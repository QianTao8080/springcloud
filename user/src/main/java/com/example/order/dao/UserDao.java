package com.example.order.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.order.mapper.IUserMapper;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

@Repository
public class UserDao {

    @Autowired
    private IUserMapper userMapper;

    private User getById(int id) {
        return userMapper.selectById(id);
    }

    private void queryByPage(int pageNo, int pageSize, String name) {
        IPage<User> page = new Page<User>(pageNo, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.lambda().like(User::getName, name);
        }
        page = userMapper.selectPage(page, queryWrapper);
    }
}

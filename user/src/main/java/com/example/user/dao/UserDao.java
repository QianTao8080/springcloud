package com.example.user.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.user.mapper.IUserMapper;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

@Repository
public class UserDao {

    @Autowired
    private IUserMapper userMapper;

    public User getById(int id) {
        return userMapper.selectById(id);
    }

    public void queryByPage(int pageNo, int pageSize, String name) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.lambda().like(User::getName, name);
        }
        page = userMapper.selectPage(page, queryWrapper);
    }
}

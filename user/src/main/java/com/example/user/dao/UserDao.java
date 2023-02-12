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

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public User getById(int id) {
        return userMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param pageNo
     * @param pageSize
     * @param name
     * @return
     */
    public IPage<User> queryByPage(int pageNo, int pageSize, String name) {
        IPage<User> page = new Page<User>(pageNo, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.lambda().like(User::getName, name);
        }
        return userMapper.selectPage(page, queryWrapper);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    public User addUser(User user) {
        userMapper.insert(user);
        return user;
    }
}

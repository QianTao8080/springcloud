package com.example.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.user.dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void update(User user) {
        userDao.addUser(user);
    }

    public IPage<User> queryByPage(int pageNo, int pageSize, String name) {
        return userDao.queryByPage(pageNo, pageSize, name);
    }
}

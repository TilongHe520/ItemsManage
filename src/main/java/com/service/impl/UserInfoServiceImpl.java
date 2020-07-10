package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryUser(User user){
        return userDao.queryUser(user);
    }

    @Override
    public void registerUser(User user){
        userDao.registerUser(user.getUsername(),user.getPassword());
    }
}

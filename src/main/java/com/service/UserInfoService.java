package com.service;

import com.pojo.User;

public interface UserInfoService {
    User queryUser(User user);

    void registerUser(User user);
}

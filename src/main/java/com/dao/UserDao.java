package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User queryUser(User user);
    void registerUser(@Param("username")String username,
                      @Param("password")String password);
}

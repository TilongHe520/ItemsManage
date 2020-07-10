package com.dao;

import com.pojo.Image;

import java.util.List;

public interface ImageDao {

    /**
     * 通过id查询用户
     */
    Image selectById(Integer id);
    /**
     * 添加用户信息
     */
    void insertUser(Image user);

    /**
     * 修改用户信息
     */
    void updateUser(Image user);

    /**
     * 显示用户信息
     */
    List<Image> selectAll();

    /**
     * 删除用户信息
     */
    void deleteUser(Integer id);
}

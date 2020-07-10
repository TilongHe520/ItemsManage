package com.service.impl;

import com.dao.ImageDao;
import com.pojo.Image;
import com.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao imageDao;
    @Override
    public Image selectById(Integer id) {
        return imageDao.selectById(id);
    }

    @Override
    public void insertUser(Image user) {
        imageDao.insertUser(user);
    }

    @Override
    public void updateUser(Image user) {
        imageDao.updateUser(user);
    }

    @Override
    public List<Image> selectAll() {
        return imageDao.selectAll();
    }

    @Override
    public void deleteUser(Integer id) {
        imageDao.deleteUser(id);
    }
}

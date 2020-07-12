package com.service;

import com.pojo.Items;
import com.pojo.PageBean;

import java.io.File;
import java.util.List;

public interface ItemsService {

    public List<Items> findAllItems();

    int save(Items items);

    int update(Items items);

    int delete(Integer id);

    Items findById(Integer id);

    File exportItems();

    int selectCount();
    PageBean<Items> findByPage(int currentPage);
}

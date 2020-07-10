package com.dao;

import com.pojo.Items;

import java.util.List;

public interface ItemsDao {

    int insert(Items items);
    int update(Items items);
    int delete(Integer id);
    Items findById(Integer id);
    public List<Items> findAllItems();
}

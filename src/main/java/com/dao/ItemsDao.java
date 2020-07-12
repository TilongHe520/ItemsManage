package com.dao;

import com.pojo.Items;

import java.util.HashMap;
import java.util.List;

public interface ItemsDao {

    int insert(Items items);
    int update(Items items);
    int delete(Integer id);
    Items findById(Integer id);
    List<Items> findAllItems();

    int selectCount();
    List<Items> findByPage(HashMap<String,Object> map);
}

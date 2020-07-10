package com.dao;

import com.pojo.Items;

import java.util.HashMap;
import java.util.List;

public interface PageDao {

    List<Items> queryAllItems();
    int selectCount();
    List<Items> findByPage(HashMap<String,Object> map);

}

package com.service;

import com.pojo.Items;

import java.util.List;

public interface ItemsService {

    public List<Items> findAllItems();

    int save(Items items);

    int update(Items items);

    int delete(Integer id);

    Items findById(Integer id);
}

package com.service.impl;

import com.dao.ItemsDao;
import com.pojo.Items;
import com.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;

    @Override
    public List<Items> findAllItems() {

        return itemsDao.findAllItems();
    }

    @Override
    public int save(Items items) {

        return itemsDao.insert(items);
    }

    @Override
    public int update(Items items) {

        return itemsDao.update(items);
    }

    @Override
    public int delete(Integer id) {
        return itemsDao.delete(id);
    }

    @Override
    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }
}

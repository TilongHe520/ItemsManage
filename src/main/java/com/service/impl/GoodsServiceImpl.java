package com.service.impl;

import com.dao.GoodsDao;
import com.pojo.Goods;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public int insert(Goods goods) {
        return goodsDao.insert(goods);
    }
}

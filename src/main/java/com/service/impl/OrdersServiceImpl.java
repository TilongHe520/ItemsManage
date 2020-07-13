package com.service.impl;

import com.dao.OrdersDao;
import com.pojo.Goods;
import com.pojo.Orders;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Goods> findAllOrders() {
        return ordersDao.findAllOrders();
    }

    @Override
    public List<Goods> finaOrdersByUserId(Integer userId) {

        return ordersDao.findOrdersByUserId(userId);
    }
}

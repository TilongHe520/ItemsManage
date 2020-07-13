package com.dao;

import com.pojo.Goods;

import java.util.List;

public interface OrdersDao {
    List<Goods> findAllOrders();

    List<Goods> findOrdersByUserId(int userId);

}

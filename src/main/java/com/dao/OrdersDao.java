package com.dao;

import com.pojo.Orders;

import java.util.List;

public interface OrdersDao {
    public List<Orders> findAllOrders();
}

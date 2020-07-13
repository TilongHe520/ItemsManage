package com.service;

import com.pojo.Goods;
import com.pojo.Orders;

import java.util.List;

public interface OrdersService {
    List<Goods> findAllOrders();
    List<Goods> finaOrdersByUserId(Integer userId);
}

package com.controller;


import com.pojo.Orders;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("list")
    public String list(Model model){

        List<Orders> ordersList = ordersService.findAllOrders();

        System.out.println(ordersList);

        model.addAttribute("ordersList",ordersList);
        return "orders/list";
    }
}

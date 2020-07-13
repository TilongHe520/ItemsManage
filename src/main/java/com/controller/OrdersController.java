package com.controller;


import com.pojo.Goods;
import com.pojo.User;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("list")
    public String list(HttpSession session,Model model){
        User user=(User) session.getAttribute("user");
        List<Goods> ordersList=null;
        if(user.getIsManager()==1){
            ordersList = ordersService.findAllOrders();

        }else{
             ordersList = ordersService.finaOrdersByUserId(user.getId());

        }
        model.addAttribute("ordersList",ordersList);
        return "orders/list";
    }
}

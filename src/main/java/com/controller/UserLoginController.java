package com.controller;

import com.pojo.Items;
import com.pojo.User;
import com.service.ItemsService;
import com.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserLoginController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ItemsService itemsService;


    @RequestMapping(value = "/login")
    public String login(HttpSession session,User user, Model model, @RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage){
        User userInfo = userInfoService.queryUser(user);
        System.out.println(userInfo);

        session.setAttribute("user", userInfo);

        if(userInfo != null){
            if (userInfo.getIsManager()==1){

                List<Items> itemsList = itemsService.findAllItems();
                int sum=0;
                for (Items items:itemsList){
                    sum+=(items.getTotalcount()-items.getRemaincount())*items.getPrice();
                }

                model.addAttribute("sum",sum);
                model.addAttribute("pagemsg",itemsService.findByPage(currentPage));
                return "items/list";
            }else {
                model.addAttribute("pagemsg",itemsService.findByPage(currentPage));
                return "custom/list";
            }

        }
        else {
            return "login/fail";
        }
    }

    @RequestMapping(value = "/toLogin.action")
    public String toLogin() {
        return "login/login";
    }

    @RequestMapping("/register")
    public String register(){
        return "login/register";
    }

    @RequestMapping("/doRegister")
    public String doRegister(User user, Model model){
        System.out.println(user.getUsername());
        userInfoService.registerUser(user);
        List<Items> itemsList = itemsService.findAllItems();
        model.addAttribute("itemsList", itemsList);
        return "items/list";
    }

}

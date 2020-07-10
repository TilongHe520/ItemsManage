package com.controller;

import com.pojo.Items;
import com.service.ItemsService;
import com.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private PageService pageService;

    @RequestMapping("list")
    private String list(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage, Model model){

        List<Items> itemsList = itemsService.findAllItems();
        int sum=0;

        for (Items items:itemsList){
            sum+=(items.getTotalcount()-items.getRemaincount())*items.getPrice();
        }

        System.out.println(sum);
        model.addAttribute("sum",sum);

        model.addAttribute("pagemsg",pageService.findByPage(currentPage));
        return "items/list";
    }

    @RequestMapping("save")
    public String save(Items items){
        items.setCreatetime(new Date());

        int a = itemsService.save(items);
        System.out.println(a);

        return "forward:list";
    }

    @RequestMapping("update")
    public String update(Items items,Model model){

        //items.setCreatetime(new Date());
        System.out.println(items);

        itemsService.update(items);

        return "forward:list";
    }

    @RequestMapping("delete")
    public String delete(Integer id,Model model){
        itemsService.delete(id);

        //跳转
        return "forward:list";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        System.out.println("id"+id);
        Items item = itemsService.findById(id);
        if(item!=null){
            model.addAttribute("item", item);
        }

        //跳转
        return "items/edit";
    }

    @RequestMapping("add")
    public String add(){

        //跳转
        return "items/add";
    }
}

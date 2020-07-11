package com.controller;

import com.pojo.Items;
import com.service.ItemsService;
import com.service.PageService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public String save(Items items, MultipartFile file, HttpServletRequest request) throws IOException {
        items.setCreatetime(new Date());
        System.out.println("提交的用户："+items);
        String filePath = request.getSession().getServletContext().getRealPath("/upload"); //定义图片上传后的路径
        System.out.println(filePath);
        String newFileName = fileOperate(file,filePath);
        items.setPic(newFileName);
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

    @GetMapping("export")
    public ResponseEntity<byte[]> exportItem(HttpServletRequest request) throws IOException{

        File file = itemsService.exportItems();
        HttpHeaders headers = new HttpHeaders();

        String downloadFileName = new String(file.getName().getBytes("UTF-8"), "iso-8859-1");

        headers.setContentDispositionFormData("attachment",downloadFileName);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

    /**
     * 封装操作文件方法， 添加用户 和修改用户都会用到
     * @param file
     * @param filePath
     * @return
     */
    private String fileOperate(MultipartFile file,String filePath) {
        String originalFileName = file.getOriginalFilename();//获取原始图片的扩展名
        System.out.println("图片原始名称："+originalFileName);
        String newFileName = UUID.randomUUID()+originalFileName;  //新的文件名称
        System.out.println("新的文件名称："+newFileName);
        File targetFile = new File(filePath,newFileName); //创建新文件
        try {
            file.transferTo(targetFile); //把本地文件上传到文件位置 , transferTo()是springmvc封装的方法，用于图片上传时，把内存中图片写入磁盘
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }
}

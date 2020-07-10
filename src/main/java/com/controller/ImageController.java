package com.controller;

import com.pojo.Image;
import com.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @RequestMapping("index")
    public String index(Model model){

        List<Image> imageList = imageService.selectAll();
        model.addAttribute("imageList",imageList);

        return "images/showAll";
    }

    @RequestMapping("/addUser")
    public String addUser(Image user, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("提交的用户："+user);
        String filePath = request.getSession().getServletContext().getRealPath("/upload"); //定义图片上传后的路径
        System.out.println(filePath);
        String newFileName = fileOperate(file,filePath);
        user.setUserImg(newFileName);
        System.out.println("最后的user:"+user);
        imageService.insertUser(user);
        return "forward:index";
    }



    /**
     * 跳转到修改用户信息页面
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/toUpdateUser")
    public String toUpdateUserPage(Integer id,Model model) {
        System.out.println("id:"+id);
        Image user = imageService.selectById(id);
        System.out.println("修改后获取的user："+user);
        model.addAttribute("user",user);
        return "images/updateUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(Image user,MultipartFile file,HttpServletRequest request) throws Exception{
        System.out.println("修改提交的用户："+user);
        String filePath = request.getSession().getServletContext().getRealPath("/upload");; //定义图片上传后的路径
        String newFileName = fileOperate(file,filePath);
        user.setUserImg(newFileName);
        System.out.println("修改最后的user:"+user);
        imageService.updateUser(user);
        return "redirect:/index";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id) {
        System.out.println("id"+id);
        imageService.deleteUser(id);
        return "redirect:/index";
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

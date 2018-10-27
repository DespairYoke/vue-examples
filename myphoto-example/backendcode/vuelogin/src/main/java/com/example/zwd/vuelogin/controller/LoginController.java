package com.example.zwd.vuelogin.controller;

import com.alibaba.fastjson.JSON;
import com.example.zwd.vuelogin.entity.PhotoInfo;
import com.example.zwd.vuelogin.model.Photo;
import com.example.zwd.vuelogin.model.User;
import com.example.zwd.vuelogin.service.PhotoService;
import com.example.zwd.vuelogin.status.RespInfo;
import com.example.zwd.vuelogin.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * @author zwd
 * @date 2018/10/18 09:52
 * @Email stephen.zwd@gmail.com
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private PhotoService photoService;

    @Value(value = "${zwd.path}")
    private String path;
    @RequestMapping("/login")
    public String Login(@RequestBody User user) {
        RespInfo respInfo = new RespInfo();
        if (("zwd").equals(user.getUsername())&&("12345678").equals(user.getPassword())) {
            respInfo.setMsg("登录成功！");
            respInfo.setStatus(Status.SUCCESS);
            return JSON.toJSONString(respInfo);
        }else {
            respInfo.setMsg("登录错误！");
            respInfo.setStatus(Status.ERROR);
            return JSON.toJSONString(respInfo);
        }
    }

    @RequestMapping("/uploadimg")
    public String UploadImg(@RequestParam("file") MultipartFile multipartFile) {
        RespInfo respInfo = new RespInfo();
        String originalFile =multipartFile.getOriginalFilename();
        String substring = originalFile.substring(originalFile.lastIndexOf("."),originalFile.length());

        File file = new File(path+new Date().getTime()+substring);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
           }
        try {
            byte[] bytes = multipartFile.getBytes();

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(bytes);
             bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            respInfo.setStatus(Status.ERROR);
            respInfo.setMsg("fail");
            return JSON.toJSONString(respInfo);
        }
        Photo photo = new Photo();
        photo.setCreatedate(new Date());
        photo.setUrl(file.getPath());
        photo.setName(file.getName());
        photoService.addPhoto(photo);
        respInfo.setStatus(Status.SUCCESS);
        respInfo.setMsg("success");
        respInfo.setContent(file.getName());
        return JSON.toJSONString(respInfo);
    }

    @RequestMapping(value = "/selectphoto")
    public String selectPhoto(@RequestBody PhotoInfo photoInfo) {
        RespInfo respInfo = new RespInfo();
        Map<String,Object> map = photoService.selectPhoto(photoInfo);
        respInfo.setStatus(Status.SUCCESS);
        respInfo.setContent(map);
        respInfo.setMsg("查询成功！");
        return JSON.toJSONString(respInfo);
    }

    @RequestMapping("/deletephoto")
    public String deletePhoto(@RequestBody String name) {
        System.out.println(name);
        RespInfo respInfo = new RespInfo();
        File file = new File(path+name);
        if (file.exists()) {
            file.delete();
        }
        photoService.deletePhoto(name);
        respInfo.setStatus(Status.SUCCESS);
        return JSON.toJSONString(respInfo);
    }
}

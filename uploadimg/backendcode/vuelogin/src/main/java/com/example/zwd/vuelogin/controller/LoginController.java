package com.example.zwd.vuelogin.controller;

import com.alibaba.fastjson.JSON;
import com.example.zwd.vuelogin.model.User;
import com.example.zwd.vuelogin.status.RespInfo;
import com.example.zwd.vuelogin.status.Status;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

/**
 * @author zwd
 * @date 2018/10/18 09:52
 * @Email stephen.zwd@gmail.com
 */
@RestController
@RequestMapping("/user")
public class LoginController {

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
        File file = new File("/Users/zwd-admin/learndemo/vue-examples/uploadimg/src/assets/"+multipartFile.getOriginalFilename());
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
        respInfo.setStatus(Status.SUCCESS);
        respInfo.setMsg("success");
        respInfo.setContent(multipartFile.getOriginalFilename());
        return JSON.toJSONString(respInfo);
    }
}

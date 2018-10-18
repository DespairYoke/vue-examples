package com.example.zwd.vuelogin.controller;

import com.alibaba.fastjson.JSON;
import com.example.zwd.vuelogin.model.User;
import com.example.zwd.vuelogin.status.RespInfo;
import com.example.zwd.vuelogin.status.Status;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

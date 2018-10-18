package com.example.zwd.vuelogin.status;

/**
 * @author zwd
 * @date 2018/10/18 14:04
 * @Email stephen.zwd@gmail.com
 */
public class RespInfo {

    private String msg;

    private Integer status;

    private Object content;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}

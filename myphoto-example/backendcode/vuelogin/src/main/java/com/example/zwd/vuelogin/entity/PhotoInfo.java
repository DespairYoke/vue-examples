package com.example.zwd.vuelogin.entity;

/**
 * @author zwd
 * @date 2018/10/26 11:25
 * @Email stephen.zwd@gmail.com
 */
public class PhotoInfo {

    private Integer currpage;

    private Integer pagesize;

    private Integer begin;

    public Integer getCurrpage() {
        return currpage;
    }

    public void setCurrpage(Integer currpage) {
        this.currpage = currpage;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }
}

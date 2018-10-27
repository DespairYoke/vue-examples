package com.example.zwd.vuelogin.service;

import com.example.zwd.vuelogin.entity.PhotoInfo;
import com.example.zwd.vuelogin.model.Photo;

import java.util.List;
import java.util.Map;

/**
 * @author zwd
 * @date 2018/10/26 11:21
 * @Email stephen.zwd@gmail.com
 */
public interface PhotoService {

    void addPhoto(Photo photo);

    Map<String,Object> selectPhoto(PhotoInfo photoInfo);

    void deletePhoto(String name);
}

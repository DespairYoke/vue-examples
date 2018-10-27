package com.example.zwd.vuelogin.serviceImpl;

import com.example.zwd.vuelogin.entity.PhotoInfo;
import com.example.zwd.vuelogin.mapper.PhotoMapper;
import com.example.zwd.vuelogin.model.Photo;
import com.example.zwd.vuelogin.model.PhotoExample;
import com.example.zwd.vuelogin.service.PhotoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zwd
 * @date 2018/10/26 11:22
 * @Email stephen.zwd@gmail.com
 */
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoMapper photoMapper;
    @Override
    public void addPhoto(Photo photo) {

        photoMapper.insertSelective(photo);
    }

    public Map<String,Object> selectPhoto(PhotoInfo photoInfo) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(photoInfo.getCurrpage(),photoInfo.getPagesize());
        PhotoExample example = new PhotoExample();
        example.createCriteria();
        Page<Photo> photos = (Page<Photo>) photoMapper.selectByExample(example);
        long count = photoMapper.countByExample(example);
        map.put("photos",photos);
        map.put("count",count);
        return map;
    }

    @Override
    public void deletePhoto(String name) {
        PhotoExample example = new PhotoExample();
        example.createCriteria().andNameEqualTo(name);
        photoMapper.deleteByExample(example);
    }
}

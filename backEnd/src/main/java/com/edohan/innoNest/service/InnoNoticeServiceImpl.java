package com.edohan.innoNest.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edohan.innoNest.mapper.InnoNoticeMapper;

@Service("innoNoticeService")
public class InnoNoticeServiceImpl implements InnoNoticeSerive {
    
    @Autowired
    private InnoNoticeMapper mapper;
    
    @Override
    public List<Map<String, Object>> innoNoticeList(){
        return mapper.innoNoticeList();
    };

    @Override
    public Map<String, Object> getNoticeDetail(int id) {
        return mapper.getNoticeDetail(id);
    }

    @Override
    public void saveNotice(String userId, String title, String content) {
        mapper.saveNotice(userId, title, content);
    }

    @Override
    public void updateNotice(int id, String title, String content){
        mapper.updateNotice(id, title, content);
    }
    
    @Override
    public void deleteNotice(int id){
        mapper.deleteNotice(id);
    }
}

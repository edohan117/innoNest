package com.edohan.innoNest.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edohan.innoNest.mapper.MainMapper;
import com.edohan.innoNest.service.MainService;

@Service("MainService")
public class MainServiceImpl implements MainService {
    
    @Autowired
    private MainMapper mapper;
    
    @Override
    public List<Map<String, Object>> highViewCountSelect(){
        return mapper.highViewCountSelect();
    };
    @Override
    public List<Map<String, Object>> recentPostsSelect(){
        return mapper.recentPostsSelect();
    };
    @Override
    public List<Map<String, Object>> topLikedPostsSelect(){
        return mapper.topLikedPostsSelect();
    };
}

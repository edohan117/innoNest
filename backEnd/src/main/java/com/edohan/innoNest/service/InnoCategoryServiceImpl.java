package com.edohan.innoNest.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edohan.innoNest.mapper.InnoCategoryMapper;

@Service("innoCategoryService")
public class InnoCategoryServiceImpl implements InnoCategorySerive {
    
    @Autowired
    private InnoCategoryMapper mapper;
    
    @Override
    public List<Map<String, Object>> innoCategoryList(){
        return mapper.innoCategoryList();
    };
}

package com.edohan.innoNest.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edohan.innoNest.mapper.InnoCategoryMapper;
import com.edohan.innoNest.service.InnoCategorySerice;

@Service("innoCategoryService")
public class InnoCategoryServiceImpl implements InnoCategorySerice {
    
    @Autowired
    private InnoCategoryMapper mapper;
    
    @Override
    public List<Map<String, Object>> innoCategoryList(){
        return mapper.innoCategoryList();
    };
}

package com.edohan.innoNest.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edohan.innoNest.mapper.InnoMainMapper;

@Service("innoMainService")
public class InnoMainServiceImpl implements InnoMainSerive {
    
    @Autowired
    private InnoMainMapper mapper;
    
    @Override
    public List<Map<String, Object>> innoMainList(){
        return mapper.innoMainList();
    };
}

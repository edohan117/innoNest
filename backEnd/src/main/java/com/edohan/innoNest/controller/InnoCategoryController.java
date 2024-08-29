package com.edohan.innoNest.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edohan.innoNest.service.InnoCategorySerice;

@RestController
@RequestMapping("/api/category")
public class InnoCategoryController {
    
    @Autowired
    private InnoCategorySerice service;

    @GetMapping("/list")
    public List<Map<String, Object>> ideaList() {
        return service.innoCategoryList();
    }
}

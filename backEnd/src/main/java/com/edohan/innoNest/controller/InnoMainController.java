package com.edohan.innoNest.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edohan.innoNest.service.InnoMainSerive;

@RestController
@RequestMapping("/api/main")
public class InnoMainController {
    
    @Autowired
    private InnoMainSerive service;

    @GetMapping("/list")
    public Map<String, Object> list() {
        // 예제 데이터 생성
        List<Map<String, Object>> featuredIdeas = List.of(
            Map.of("id", 1, "title", "Innovative Idea", "description", "This is an innovative idea.", "author", "Alice", "likes", 120),
            Map.of("id", 2, "title", "Creative Idea", "description", "This is a creative idea.", "author", "Bob", "likes", 85)
        );
        
        List<Map<String, Object>> ideas = List.of(
            Map.of("id", 1, "title", "Idea A", "description", "Description for Idea A", "author", "Author A", "likes", 10),
            Map.of("id", 2, "title", "Idea B", "description", "Description for Idea B", "author", "Author B", "likes", 20)
        );
        
        List<Map<String, Object>> trendingTags = List.of(
            Map.of("id", 1, "title", "Idea A", "description", "Description for Idea A", "author", "Author A", "likes", 10),
            Map.of("id", 2, "title", "Idea B", "description", "Description for Idea B", "author", "Author B", "likes", 20)
        );
        
        // List<Map<String, Object>> testList = new ArrayList<>();
        // testList = service.innoMainList();
        // System.out.println("########################"+testList);

        return Map.of(
            "featuredIdeas", featuredIdeas,
            "ideas", ideas,
            "trendingTags", trendingTags
        );
    }
}

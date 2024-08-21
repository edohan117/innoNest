package com.edohan.innoNest.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edohan.innoNest.service.InnoIdeaSerive;

@RestController
@RequestMapping("/api/idea")
public class InnoIdeaController {
    
    @Autowired
    private InnoIdeaSerive service;

    @GetMapping("/list")
    public List<Map<String, Object>> ideaList() {
        return service.innoIdeaList();
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> getIdeaDetail(@PathVariable int id, @RequestHeader(value = "User-Id", required = false) String userId) {
        Map<String, Object> ideaDetail = service.getIdeaDetail(id);
    
        if (userId != null && !userId.equals(ideaDetail.get("WRITER"))) {
            service.incViewCount(id);

            ideaDetail = service.getIdeaDetail(id);
        }
    
        return ideaDetail;
    }

    // 아이디어 제출
    @PostMapping("/submit")
    public void saveIdea(@RequestBody Map<String, Object> idea) {
        String userId = (String) idea.get("userId"); 
        String title = (String) idea.get("title");
        String content = (String) idea.get("content");
        String category = (String) idea.get("category");
        String tags = (String) idea.get("tags");
        service.saveIdea(userId, title, content, tags, category);
    }


    // 아이디어 수정
    @PutMapping("/update/{id}")
    public void updateIdea(@PathVariable int id, @RequestBody Map<String, String> idea) {
        String title = idea.get("TITLE");
        String content = idea.get("CONTENT");
        service.updateIdea(id, title, content);
    }

    // 아이디어 삭제
    @DeleteMapping("/delete/{id}")
    public void deleteIdea(@PathVariable int id) {
        service.deleteIdea(id);
    }
}

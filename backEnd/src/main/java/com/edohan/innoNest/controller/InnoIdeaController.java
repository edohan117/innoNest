package com.edohan.innoNest.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edohan.innoNest.service.InnoIdeaSerice;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/idea")
public class InnoIdeaController {
    
    @Autowired
    private InnoIdeaSerice service;

    @GetMapping("/list")
    public List<Map<String, Object>> ideaList() {
        return service.innoIdeaList();
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> getIdeaDetail(@PathVariable int id, HttpServletRequest request, @RequestHeader(value = "User-Id", required = false) String userId) {
        Map<String, Object> ideaDetail = service.getIdeaDetail(id);
    
        if (userId != null && !userId.equals(ideaDetail.get("WRITER"))) {
            String referrer = request.getHeader("Referer");
            
            // 좋아요, 싫어요 요청이 아닌 경우에만 조회수 증가
            if (!"LIKE".equals(referrer) && !"DISLIKE".equals(referrer)) {
                service.incViewCount(id);
                ideaDetail = service.getIdeaDetail(id);  // 조회수 증가 후 다시 데이터를 가져옵니다.
            }
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

    // 좋아요/싫어요 추가
    @PostMapping("/reaction/{id}")
    public void addReaction(@PathVariable int id, @RequestBody Map<String, String> request) {
        String userId = request.get("userId");
        String reactionType = request.get("reactionType"); // "LIKE" or "DISLIKE"
        service.addReaction(userId, id, reactionType);
    }

    // 좋아요/싫어요 취소
    @DeleteMapping("/reaction/{id}")
    public void removeReaction(@PathVariable int id, @RequestBody Map<String, String> request) {
        String userId = request.get("userId");
        String reactionType = request.get("reactionType"); // "LIKE" or "DISLIKE"
        service.removeReaction(userId, id, reactionType);
    }

    @GetMapping("/reaction/count/{id}")
    public Map<String, Integer> getReactionCounts(@PathVariable int id) {
        System.out.println(" /reaction/count/{id}  id :  "+id);
        return service.getReactionCounts(id);
    }
}

package com.edohan.innoNest.service;

import java.util.*;

public interface InnoIdeaSerive {
    List<Map<String, Object>> innoIdeaList();
    Map<String, Object> getIdeaDetail(int id);
    void saveIdea(String userId, String title, String content, String tags, String category);
    void updateIdea(int id, String title, String content);
    void deleteIdea(int id);
} 
package com.edohan.innoNest.mapper;

import java.util.List;
import java.util.Map;

public interface InnoIdeaMapper {
    List<Map<String, Object>> innoIdeaList();
    Map<String, Object> getIdeaDetail(int id);
    void saveIdea(String userId, String title, String content, String tags, String category);
    void updateIdea(int id, String title, String content);
    void deleteIdea(int id);
    void incViewCount(int id);
}

package com.edohan.innoNest.service;

import java.util.*;

public interface InnoIdeaSerice {
    List<Map<String, Object>> innoIdeaList();
    Map<String, Object> getIdeaDetail(int id);
    void saveIdea(String userId, String title, String content, String tags, String category);
    void updateIdea(int id, String title, String content);
    void deleteIdea(int id);
    void incViewCount(int id);

    void addReaction(String userId, int ideaId, String reactionType);
    void removeReaction(String userId, int ideaId, String reactionType);
    Map<String, Integer> getReactionCounts(int ideaId);
}

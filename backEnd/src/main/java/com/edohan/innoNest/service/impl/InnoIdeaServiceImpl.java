package com.edohan.innoNest.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edohan.innoNest.mapper.InnoIdeaMapper;
import com.edohan.innoNest.service.InnoIdeaSerice;

@Service("innoIdeaService")
public class InnoIdeaServiceImpl implements InnoIdeaSerice {
    
    @Autowired
    private InnoIdeaMapper mapper;
    
    @Override
    public List<Map<String, Object>> innoIdeaList() {
        return mapper.innoIdeaList();
    }

    @Override
    public Map<String, Object> getIdeaDetail(int id) {
        return mapper.getIdeaDetail(id);
    }
    
    @Override
    public void saveIdea(String userId, String title, String content, String tags, String category) {
        mapper.saveIdea(userId, title, content, tags, category);
    }
    
    @Override
    public void updateIdea(int id, String title, String content) {
        mapper.updateIdea(id, title, content);
    }
    
    @Override
    public void deleteIdea(int id) {
        mapper.deleteIdea(id);
    }
    
    @Override
    public void incViewCount(int id) {
        mapper.incViewCount(id);
    }

    @Override
    public void addReaction(String userId, int ideaId, String reactionType) {
        mapper.addReaction(userId, ideaId, reactionType);
    }

    @Override
    public void removeReaction(String userId, int ideaId, String reactionType) {
        mapper.removeReaction(userId, ideaId, reactionType);
    }

    @Override
    public Map<String, Integer> getReactionCounts(int ideaId) {
        return mapper.getReactionCounts(ideaId);
    }
}

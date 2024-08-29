package com.edohan.innoNest.service;

import java.util.*;

public interface InnoNoticeSerice {
    List<Map<String, Object>> innoNoticeList();
    Map<String, Object> getNoticeDetail(int id);
    void saveNotice(String userId, String title, String content);
    void updateNotice(int id, String title, String content);
    void deleteNotice(int id);
} 
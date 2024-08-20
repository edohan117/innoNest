package com.edohan.innoNest.mapper;

import java.util.List;
import java.util.Map;

public interface InnoNoticeMapper {
    List<Map<String, Object>> innoNoticeList();
    Map<String, Object> getNoticeDetail(int id);
    void saveNotice(String userId, String title, String content);
    void updateNotice(int id, String title, String content);
    void deleteNotice(int id);
}

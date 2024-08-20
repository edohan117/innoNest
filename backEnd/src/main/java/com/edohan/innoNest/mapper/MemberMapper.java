package com.edohan.innoNest.mapper;

import java.util.Map;

public interface MemberMapper {

    void insertMember(Map<String, String> member);

    String getPasswordByUsername(String id);

    String getUsernameById(String id);

    String getRoleById(String id);
}

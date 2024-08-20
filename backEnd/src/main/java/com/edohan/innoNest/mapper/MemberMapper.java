package com.edohan.innoNest.mapper;

import java.util.*;

public interface MemberMapper {

    void insertMember(Map<String, String> member);

    String getPasswordByUsername(String id);

    String getUsernameById(String id);

    String getRoleById(String id);

    List<Map<String, Object>> memberList();
}

package com.edohan.innoNest.service;

import java.util.Map;

public interface MemberService {
    Map<String, Object> register(Map<String, String> memberRequest);
    Map<String, Object> authenticate(String id, String password);
}

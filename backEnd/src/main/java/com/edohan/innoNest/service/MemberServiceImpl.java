package com.edohan.innoNest.service;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edohan.innoNest.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private MemberMapper mapper;

    @Override
    public Map<String, Object> register(Map<String, String> memberRequest) {
        // 전달받은 id를 그대로 사용
        String id = memberRequest.get("id");
        memberRequest.put("id", id); 
        mapper.insertMember(memberRequest);
        return Collections.singletonMap("status", "registered");
    }

    @Override
    public Map<String, Object> authenticate(String id, String password) {
        String storedPassword = mapper.getPasswordByUsername(id);
        if (password.equals(storedPassword)) {
            String username = mapper.getUsernameById(id);
            String role = mapper.getRoleById(id); // 사용자 권한 조회

            // 사용자 정보와 권한을 반환
            return Map.of(
                "status", "success",
                "username", username,
                "role", role
            );
        } else {
            return Map.of("status", "failure", "message", "Invalid credentials");
        }
    }
    
}

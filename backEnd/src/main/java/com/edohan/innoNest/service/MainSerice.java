package com.edohan.innoNest.service;

import java.util.*;

public interface MainSerice {
    List<Map<String, Object>> highViewCountSelect();
    List<Map<String, Object>> recentPostsSelect();
    List<Map<String, Object>> topLikedPostsSelect();
} 
package com.rrc.learnspring.service;

import com.rrc.learnspring.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    String add(User user);
    String get(int id);
}

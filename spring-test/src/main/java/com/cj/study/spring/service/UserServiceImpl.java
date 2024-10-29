package com.cj.study.spring.service;

import com.cj.study.spring.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * UserServiceImpl 简介
 *
 * @author caojun44
 * @date 2024-10-28
 **/
@Service
public class UserServiceImpl implements UserService {
    Map<String, User> userMap = new HashMap<>();


    @Override
    public void addUser(User user) {
        userMap.put(user.getCode(), user);
    }

    @Override
    public User queryUser(String code) {
        return userMap.get(code);
    }
}

package com.cj.study.spring.service;

import com.cj.study.spring.entity.User;

/**
 * UserService 简介
 *
 * @author caojun44
 * @date 2024-10-25
 **/
public interface UserService {
    void addUser(User user);
    User queryUser(String code);
}

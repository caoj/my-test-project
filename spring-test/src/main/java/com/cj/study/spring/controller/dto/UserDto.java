package com.cj.study.spring.controller.dto;

import com.cj.study.spring.entity.User;
import lombok.Data;

/**
 * UserDto 简介
 *
 * @author caojun44
 * @date 2024-10-28
 **/
@Data
public class UserDto {
    private Long  id;
    private String code;
    private String name;

    public User mappingToUser(){
        User user = new User();
        user.setId(id);
        user.setCode(code);
        user.setName(name);
        return user;
    }

    public static User initUser1() {
        User user = new User();
        user.setId(1L);
        user.setCode("liming");
        user.setName("李明");
        return user;
    }
}

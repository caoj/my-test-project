package com.cj.study.mock.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * UserInfo 简介
 *
 * @author caojun44
 * @date 2024-03-13
 **/
@Slf4j
@Data
@NoArgsConstructor
public class UserInfo {
    private Long id ;
    private String code;
    private String Name;
    private String orgCode;

    public UserInfo(String code, String name, String orgCode) {
        this.code = code;
        Name = name;
        this.orgCode = orgCode;
    }
}

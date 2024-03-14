package com.cj.study.mock.utils;

import org.springframework.util.StringUtils;

/**
 * ParseUtil 简介
 *
 * @author caojun44
 * @date 2024-03-14
 **/
public class ParseUtil {
    public static String[] parse(String s){
        if(null == s || s.isEmpty()){
            return null;
        }
        return s.split(",");
    }
}

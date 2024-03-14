package com.cj.study.mock.dao;

import com.cj.study.mock.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * UserDao 简介
 *
 * @author caojun44
 * @date 2024-03-13
 **/
@Service
public class UserDao {
    public static final Map<String, String> USER_INFO_MAP = new HashMap();

    static {
        USER_INFO_MAP.put("zhangsan", "张三");
        USER_INFO_MAP.put("lisi", "李四");
    }


    public String queryUserName(String code) {
        return USER_INFO_MAP.get(code);
    }

    public String[] queryAllUserName(){
        return USER_INFO_MAP.values().toArray(new String[0]);
    }

    public String queryUserCode(String name){
        for(Map.Entry<String, String> entry : USER_INFO_MAP.entrySet()){
            if(entry.getValue().equals(name)){
                return entry.getKey();
            }
        }
        return null;
    }

    public boolean save(UserInfo userInfo){
        return true;
    }
}

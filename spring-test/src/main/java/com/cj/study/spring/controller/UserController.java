package com.cj.study.spring.controller;

import com.cj.study.spring.controller.dto.UserDto;
import com.cj.study.spring.service.ThreadLocalService;
import com.cj.study.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * UserController 简介
 *
 * @author caojun44
 * @date 2024-10-28
 **/
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    private Map<Integer, ThreadLocalService> threadLocalServiceMap = new HashMap<>();

    @Autowired
    public void setThreadLocalServiceMap(List<ThreadLocalService> threadLocalServices){
        threadLocalServices.forEach(threadLocalService -> threadLocalServiceMap.put(threadLocalService.type(), threadLocalService));
    }

    @RequestMapping("/add")
    public String add(UserDto userDto) {
        userService.addUser(userDto.mappingToUser());
        return "success";
    }

    @RequestMapping("/test1")
    public String test1(UserDto userDto) {
        String uuid = UUID.randomUUID().toString();
        log.info("uuid:{}", uuid);

        threadLocalServiceMap.get(1).process(uuid);
        return "success";
    }

    @RequestMapping("/test2")
    public String test2(UserDto userDto) {
        String uuid = UUID.randomUUID().toString();
        log.info("uuid:{}", uuid);
        threadLocalServiceMap.get(2).process(uuid);
        return "success";
    }

    @RequestMapping("/test3")
    public String test3(UserDto userDto) {
        String uuid = UUID.randomUUID().toString();
        log.info("uuid:{}", uuid);
        threadLocalServiceMap.get(3).process(uuid);
        return "success";
    }
}

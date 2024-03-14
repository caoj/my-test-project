package com.cj.study.mock.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserController 简介
 *
 * @author caojun44
 * @date 2024-03-07
 **/
@Service
public class UserController {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}

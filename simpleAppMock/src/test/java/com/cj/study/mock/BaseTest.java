package com.cj.study.mock;

import com.cj.study.mock.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * BaseTest 简介
 *
 * @author caojun44
 * @date 2024-03-13
 **/
@SpringBootTest(classes = ApplicationTest.class)
public class BaseTest {
    @Resource
    private UserService userService;
}

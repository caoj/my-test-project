package com.cj.study.mock.service;

import com.cj.study.mock.BaseTest;
import com.cj.study.mock.dao.UserDao;
import com.cj.study.mock.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * MockTest 简介
 *
 * @author caojun44
 * @date 2024-03-14
 **/
@Slf4j
public class MockPrivateTest extends BaseTest {
    @Spy
    private UserService userService;
    @Mock
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        log.info("do BeforeEach annotated method");
        userService.setUserDao(userDao);
    }

    @AfterEach
    public void tearDown() {
        log.info("do AfterEach annotated method");
    }

    @Test
    void testPrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = UserService.class.getDeclaredMethod("saveUserInfo", UserInfo.class);
        method.setAccessible(true);
        when(userDao.save(any())).thenReturn(true);
        Assertions.assertTrue((Boolean) method.invoke(userService, new UserInfo()));
    }
}

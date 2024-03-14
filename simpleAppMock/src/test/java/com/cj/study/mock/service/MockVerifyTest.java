package com.cj.study.mock.service;

import com.cj.study.mock.dao.UserDao;
import com.cj.study.mock.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;

/**
 * MockTest 简介
 *
 * @author caojun44
 * @date 2024-03-14
 **/
@Slf4j
public class MockVerifyTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserDao userDao;
    @Captor
    private ArgumentCaptor<UserInfo> userInfoArgumentCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        log.info("do BeforeEach annotated method");
    }

    @AfterEach
    public void tearDown() {
        log.info("do AfterEach annotated method");
    }

    @Test
    void save() {
        UserInfo userInfo1 = new UserInfo("zhangsan", "张三", "001001");
        UserInfo userInfo2 = new UserInfo("zhangsan1", "张三", "001002");

        userService.save(Arrays.asList(userInfo1, userInfo2));

        Mockito.verify(userDao, times(2)).save(userInfoArgumentCaptor.capture());
        List<UserInfo> userInfoList = userInfoArgumentCaptor.getAllValues();
        Assertions.assertAll("保存用户信息", () -> {
            UserInfo userInfo1Captor = userInfoList.get(0);
            Assertions.assertEquals("zhangsan", userInfo1Captor.getCode());
            Assertions.assertEquals("张三", userInfo1Captor.getName());
            Assertions.assertEquals("001001", userInfo1Captor.getOrgCode());
        }, () -> {
            UserInfo userInfo1Captor = userInfoList.get(1);
            Assertions.assertEquals("zhangsan1", userInfo1Captor.getCode());
            Assertions.assertEquals("张三", userInfo1Captor.getName());
            Assertions.assertEquals("001002", userInfo1Captor.getOrgCode());
        });
    }
}

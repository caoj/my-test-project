package com.cj.study.mock.service;

import com.cj.study.mock.BaseTest;
import com.cj.study.mock.dao.UserDao;
import com.cj.study.mock.entity.OrgInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * MockBeanTest 简介
 *  自动注入 二选一
 *  方式一：MockitoAnnotations.openMocks(this);
 *  方式二：@ExtendWith(MockitoExtension.class)
 * @author caojun44
 * @date 2024-04-17
 **/
@Slf4j
@ExtendWith(MockitoExtension.class)
public class InjectMockBeanTest extends BaseTest {

    @InjectMocks
    private UserService userService;
    @MockBean
    private UserDao userDao;
    @MockBean
    private UserOrgService userOrgService;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() {
        log.info("do AfterEach annotated method");
    }

    @Test
    void queryUserOrgInfo() {
        OrgInfo mockOrgInfo = new OrgInfo();
        when(userOrgService.queryUserOrgInfo(any())).thenReturn(mockOrgInfo);
        OrgInfo orgInfo = userService.queryOrgInfo("a");
        Assertions.assertEquals(mockOrgInfo, orgInfo);
    }
}

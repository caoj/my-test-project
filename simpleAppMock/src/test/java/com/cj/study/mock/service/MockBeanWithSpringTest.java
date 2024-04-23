package com.cj.study.mock.service;

import com.cj.study.mock.BaseTest;
import com.cj.study.mock.dao.UserDao;
import com.cj.study.mock.entity.OrgInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

/**
 * MockBeanTest 简介
 *
 * @author caojun44
 * @date 2024-04-17
 **/
@Slf4j
public class MockBeanWithSpringTest extends BaseTest {

    @Resource
    private UserService userService;
    @MockBean
    private UserDao userDao;
    @MockBean
    private UserOrgService userOrgService;

    @BeforeEach
    void setUp() {
        log.info("setUp");
    }

    @AfterEach
    public void tearDown() {
        log.info("do AfterEach annotated method");
    }

    @Test
    void queryUserOrgInfo() {
        OrgInfo orgInfo = userService.queryOrgInfo("a");
        Assertions.assertNull(orgInfo);
    }
}

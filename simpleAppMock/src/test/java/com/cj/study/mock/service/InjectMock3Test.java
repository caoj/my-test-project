package com.cj.study.mock.service;

import com.cj.study.mock.dao.UserDao;
import com.cj.study.mock.entity.OrgInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * MockBeanTest 简介
 *
 * @author caojun44
 * @date 2024-04-17
 **/
@Slf4j
public class InjectMock3Test extends BaseMockitoExtension {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserDao userDao;
    @Mock
    private UserOrgService userOrgService;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
        log.info("setUp");
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

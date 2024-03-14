package com.cj.study.mock.service;

import com.cj.study.mock.BaseTest;
import com.cj.study.mock.entity.OrgInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 *
 */
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest extends BaseTest {

    @Resource
    private UserService userService;
    @MockBean
    private UserOrgService userOrgService;

    @BeforeEach
    void setUp() {
        log.info("do BeforeEach annotated method");
    }

    @AfterEach
    void setDown() {
        log.info("do AfterEach annotated method");
    }

    @BeforeAll
    void beforeAll() {
        log.info("do BeforeAll annotated method");
    }

    @AfterAll
    void AfterAll() {
        log.info("do AfterAll annotated method");
    }

    @Test
    void queryUserInfo() {
        Assertions.assertEquals("张三", userService.queryUserInfo("zhangsan"));
    }

    @Test
    void queryAllUserName() {
        Assertions.assertArrayEquals(new String[]{"李四", "张三"}, userService.queryAllUserName());
    }

    @Test
    void queryUserOrgInfo(){
        when(userOrgService.queryUserOrgInfo(any())).thenReturn(buildOrgInfo());
        OrgInfo orgInfo = userService.queryUserOrgInfo("张三");

        Assertions.assertAll("用户机构信息", () -> {
            Assertions.assertEquals("000001", orgInfo.getCode());
        }, () -> {
            Assertions.assertEquals("北京市", orgInfo.getName());
        }, () -> {
            Assertions.assertEquals(1, orgInfo.getLevel());
        });
    }

    private static OrgInfo buildOrgInfo() {
        OrgInfo orgInfo1 = new OrgInfo();
        orgInfo1.setName("北京市");
        orgInfo1.setCode("000001");
        orgInfo1.setLevel(1);
        return orgInfo1;
    }
}
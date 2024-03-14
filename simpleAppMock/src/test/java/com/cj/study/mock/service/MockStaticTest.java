package com.cj.study.mock.service;

import com.cj.study.mock.BaseTest;
import com.cj.study.mock.utils.ParseUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.annotation.Resource;

import static org.mockito.ArgumentMatchers.any;

/**
 * MockTest 简介
 *
 * @author caojun44
 * @date 2024-03-14
 **/
@Slf4j
public class MockStaticTest extends BaseTest {
    @Resource
    private UserService userService;
    private MockedStatic<ParseUtil> parseUtilMockedStatic;

    @BeforeEach
    void setUp() {
        log.info("do BeforeEach annotated method");
    }

    @AfterEach
    public void tearDown() {
        log.info("do AfterEach annotated method");
    }

    @Test
    void testStaticMethod() {
        Assertions.assertEquals("001000", userService.queryOneLevelOrg("001000,001002"));
    }

    @Test
    void testMockStaticMethod() {
        parseUtilMockedStatic = Mockito.mockStatic(ParseUtil.class);
        Mockito.when(ParseUtil.parse(any())).thenReturn(new String[]{"100000", "200000"});
        Assertions.assertEquals("100000", userService.queryOneLevelOrg("001000,001002"));
        parseUtilMockedStatic.close();
    }
}

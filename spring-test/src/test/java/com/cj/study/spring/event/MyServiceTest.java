package com.cj.study.spring.event;

import com.cj.study.spring.BaseTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class MyServiceTest extends BaseTest {
    @Resource
    private MyService myService;


    @Test
    void performBusinessLogic(){
        myService.performBusinessLogic();
    }

}
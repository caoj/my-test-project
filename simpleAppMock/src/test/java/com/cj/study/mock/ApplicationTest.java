package com.cj.study.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApplicationTest 简介
 *
 * @author caojun44
 * @date 2024-03-13
 **/
@RestController
@EnableAutoConfiguration
@ComponentScan("com.cj.study")
@PropertySource(value = { "classpath:application.properties"}, encoding = "utf-8")
public class ApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTest.class, args);
    }
}

package com.cj.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Application 简介
 *
 * @author caojun44
 * @date 2024-03-07
 **/
@SpringBootApplication(scanBasePackages = {"com.cj"})
@RestController
@EnableAutoConfiguration
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}

package com.cj.study.spring.service;

/**
 * ThreadLocalService 简介
 *
 * @author caojun44
 * @date 2024-10-29
 **/
public interface ThreadLocalService {

    Integer type();

    void process(String value);

    void asyncTask();

    String culValue();
}

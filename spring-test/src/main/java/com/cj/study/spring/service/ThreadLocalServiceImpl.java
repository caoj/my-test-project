package com.cj.study.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

/**
 * ThreadLocalServiceImpl 简介
 *
 * @author caojun44
 * @date 2024-10-29
 **/
@Service
@Slf4j
public class ThreadLocalServiceImpl implements ThreadLocalService {
    private static final ThreadLocal<String> CONTENT = new ThreadLocal<>();
    @Autowired
    private Executor taskExecutor;

    @Override
    public Integer type() {
        return 1;
    }

    @Override
    public void process(String value) {
        String threadLocalValue = CONTENT.get();
        log.info("Context threadLocalValue in async task: " + threadLocalValue);

        // 设置上下文
        CONTENT.set(value);
        // 异步调用
        taskExecutor.execute(() -> asyncTask());
    }

    @Override
    public void asyncTask() {
        // 获取上下文
        String newValue = CONTENT.get();
        log.info("Context newValue in async task: " + newValue);
//        threadLocal.remove();
    }

    @Override
    public String culValue() {
        return CONTENT.get();
    }
}

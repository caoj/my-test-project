package com.cj.study.spring.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolConfig 简介
 *
 * @author caojun44
 * @date 2024-10-28
 **/
@Configuration
public class ThreadPoolConfig {

    @Bean
    public Executor taskExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, // core pool size
                1, // maximum pool size
                30, // keep alive time
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20) // work queue
        );
        return TtlExecutors.getTtlExecutor(threadPoolExecutor);
    }
}

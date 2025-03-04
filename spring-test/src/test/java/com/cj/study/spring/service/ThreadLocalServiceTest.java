package com.cj.study.spring.service;

import com.cj.study.spring.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;

@Slf4j
class ThreadLocalServiceTest extends BaseTest {
    private Map<Integer, ThreadLocalService> threadLocalServiceMap = new HashMap<>();

    @Autowired
    public void setThreadLocalServiceMap(List<ThreadLocalService> threadLocalServices) {
        threadLocalServices.forEach(threadLocalService -> threadLocalServiceMap.put(threadLocalService.type(), threadLocalService));
    }

    @Autowired
    private Executor taskExecutor;

    @Test
    void process_1() {
        new Thread(this::doProcess1).start();
//        doProcess1();
    }

    private void doProcess1() {
        ThreadLocalService threadLocalService = threadLocalServiceMap.get(1);

        String uuid1 = UUID.randomUUID().toString();
        log.info("uuid2-1:{}", uuid1);
        threadLocalService.process(uuid1);
        taskExecutor.execute(() -> Assertions.assertNull(threadLocalService.culValue()));

        String uuid2 = UUID.randomUUID().toString();
        log.info("uuid2-2:{}", uuid2);
        threadLocalService.process(uuid2);
        taskExecutor.execute(() -> Assertions.assertNull(threadLocalService.culValue()));

        String uuid3 = UUID.randomUUID().toString();
        log.info("uuid2-3:{}", uuid3);
        threadLocalService.process(uuid3);
        taskExecutor.execute(() -> Assertions.assertNull(threadLocalService.culValue()));
    }

    @Test
    void process_2() {
        new Thread(this::doProcess2).start();
//        doProcess2();
    }

    private void doProcess2() {
        ThreadLocalService threadLocalService = threadLocalServiceMap.get(2);

        String uuid1 = UUID.randomUUID().toString();
        log.info("uuid2-1:{}", uuid1);
        threadLocalService.process(uuid1);
        taskExecutor.execute(() -> {
            String curValue = threadLocalService.culValue();
            log.info("当前值：{}", curValue);
        });
        taskExecutor.execute(() -> Assertions.assertEquals(null, threadLocalService.culValue()));

        String uuid2 = UUID.randomUUID().toString();
        log.info("uuid2-2:{}", uuid2);
        threadLocalService.process(uuid2);
        taskExecutor.execute(() -> Assertions.assertEquals(null, threadLocalService.culValue()));

        String uuid3 = UUID.randomUUID().toString();
        log.info("uuid2-3:{}", uuid3);
        threadLocalService.process(uuid3);
        taskExecutor.execute(() -> Assertions.assertEquals(null, threadLocalService.culValue()));
    }

    @Test
    void process_3() {
        new Thread(this::doProcess3).start();
//        doProcess3();
    }

    private void doProcess3() {
        ThreadLocalService threadLocalService = threadLocalServiceMap.get(3);

        String uuid1 = UUID.randomUUID().toString();
        log.info("uuid2-1:{}", uuid1);
        threadLocalService.process(uuid1);
        taskExecutor.execute(() -> Assertions.assertEquals(uuid1, threadLocalService.culValue()));

        String uuid2 = UUID.randomUUID().toString();
        log.info("uuid2-2:{}", uuid2);
        threadLocalService.process(uuid2);
        taskExecutor.execute(() -> Assertions.assertEquals(uuid2, threadLocalService.culValue()));

        String uuid3 = UUID.randomUUID().toString();
        log.info("uuid2-3:{}", uuid3);
        threadLocalService.process(uuid3);
        taskExecutor.execute(() -> Assertions.assertEquals(uuid3, threadLocalService.culValue()));
    }
}
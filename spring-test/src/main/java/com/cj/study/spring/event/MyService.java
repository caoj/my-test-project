package com.cj.study.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MyService {

    @Autowired
    private ApplicationContext applicationContext;

    @Transactional
    public void performBusinessLogic() {
        // 执行业务逻辑
        log.info("Executing business logic");
        // 发布事件
        MyCustomEvent event = new MyCustomEvent("Hello, World!");
        applicationContext.publishEvent(event);
        log.info("发布事件完成");
    }
}

package com.cj.study.spring.event;

/**
 * MyCustomEvent 简介
 *
 * @author caojun44
 * @date 2025-01-02
 **/
public class MyCustomEvent {
    private final String message;

    public MyCustomEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

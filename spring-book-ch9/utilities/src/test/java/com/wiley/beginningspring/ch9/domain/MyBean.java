package com.wiley.beginningspring.ch9.domain;

import org.springframework.stereotype.Component;

/**
 * Created by mertcaliskan
 * on 14/08/14.
 */
@Component
public class MyBean {

    public String sayHello() {
        return "Hello!";
    }
}

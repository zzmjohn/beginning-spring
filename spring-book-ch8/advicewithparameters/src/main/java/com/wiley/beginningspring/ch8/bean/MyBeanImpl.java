package com.wiley.beginningspring.ch8.bean;

import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
public class MyBeanImpl implements MyBean {

    @Override
    public String sayHello(String param) {
        System.out.println("Actual method execution with param: " + param);
        return "bye";
    }
}

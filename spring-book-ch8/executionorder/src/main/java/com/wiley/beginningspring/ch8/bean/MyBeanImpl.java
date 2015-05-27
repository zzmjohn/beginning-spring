package com.wiley.beginningspring.ch8.bean;

import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
public class MyBeanImpl implements MyBean {

    @Override
    public void sayHello() {
        System.out.println("===3. Actual method execution.");
        System.out.println("Hello..!");
    }
}

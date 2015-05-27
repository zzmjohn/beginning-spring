package com.wiley.beginningspring.ch8.bean;

import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
public class MyBean {

    public MyBean() {
        System.out.println("MyBean constructor");
    }

    public void sayHello() {
        System.out.println("Hello..!");
    }
}

package com.wiley.beginningspring.ch8.bean;

import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
public class MyOtherBean {

    public MyOtherBean() {
        System.out.println("MyOtherBean constructor");
    }

    public void sayHelloDelayed() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Hello..!");
    }
}

package com.wiley.beginningspring.ch8.bean;

import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
public class MyOtherBeanImpl implements MyOtherBean {

    @Override
    public void sayHelloWithAnException() throws InterruptedException {
        Thread.sleep(1000);
        throw new RuntimeException("Oops!");
    }
}

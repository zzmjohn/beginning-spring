package com.wiley.beginningspring;

import org.springframework.stereotype.Component;

/**
 * Created by mertcaliskan
 * on 23/11/14.
 */
@Component
public class MyBeanImpl implements MyBean {

    @MyAnnotation
    public void sayHi() {
        System.out.println("Hi..!");
    }
}

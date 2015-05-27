package com.wiley.beginningspring.ch8.bean;

import com.wiley.beginningspring.ch8.markers.MarkerAnnotation;

import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
@MarkerAnnotation
public class MySecondBeanImpl implements MySecondBean {

    @Override
    public void sayHello()  {
        System.out.println("Hello..! Second");
    }
}

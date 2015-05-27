package com.wiley.beginningspring.ch8.bean;

import com.wiley.beginningspring.ch8.markers.MarkerInterface;

import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
public class MyBeanImpl implements MyBean, MarkerInterface {

    @Override
    public void sayHello() {
        System.out.println("Hello..!");
    }
}
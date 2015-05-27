package com.wiley.beginningspring.ch8.bean;

/**
 * User: mertcaliskan
 * Date: 05/07/14
 */
public class Bird implements IBird {

    @Override
    public void fly() {
        System.out.println("Pegasus is flying..!");
    }
}

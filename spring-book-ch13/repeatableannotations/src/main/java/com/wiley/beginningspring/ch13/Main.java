package com.wiley.beginningspring.ch13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mertcaliskan
 * on 21/10/14.
 */
public class Main {

    public static void main(String... args) {
        new AnnotationConfigApplicationContext(ApplicationConfig.class);
        while(true);
    }
}
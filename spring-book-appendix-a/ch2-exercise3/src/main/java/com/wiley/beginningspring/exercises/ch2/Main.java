package com.wiley.beginningspring.exercises.ch2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = 
            new AnnotationConfigApplicationContext();
        applicationContext.register(Ch2Exercise3Configuration.class);
        applicationContext.refresh();
    }


}

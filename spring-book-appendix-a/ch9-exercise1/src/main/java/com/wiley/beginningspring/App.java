package com.wiley.beginningspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MyBean myBean = context.getBean(MyBean.class);
        System.out.println(myBean.getMessage());
    }
}
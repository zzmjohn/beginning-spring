package com.wiley.beginningspring.ch9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mertcaliskan
 * on 11/08/14.
 */
public class Main {

    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean myBean = context.getBean(MyBean.class);
        System.out.println(myBean.getMessage());
    }
}

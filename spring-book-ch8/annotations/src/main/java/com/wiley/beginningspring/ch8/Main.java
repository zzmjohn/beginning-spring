package com.wiley.beginningspring.ch8;

import com.wiley.beginningspring.ch8.bean.MyBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
public class Main {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        MyBean myBean = context.getBean(MyBean.class);
        myBean.sayHello();
    }
}

package com.wiley.beginningspring.ch8;

import com.wiley.beginningspring.ch8.bean.MyBean;
import com.wiley.beginningspring.ch8.bean.MyOtherBean;
import com.wiley.beginningspring.ch8.bean.MyOtherBeanImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
public class Main {

    public static void main(String... args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MyBean myBean = context.getBean(MyBean.class);
        myBean.sayHello();

        MyOtherBean myOtherBean = context.getBean(MyOtherBean.class);
        myOtherBean.sayHelloDelayed();
    }
}

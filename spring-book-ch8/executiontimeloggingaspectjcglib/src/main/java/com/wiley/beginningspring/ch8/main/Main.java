package com.wiley.beginningspring.ch8.main;

import com.wiley.beginningspring.ch8.bean.MyBean;
import com.wiley.beginningspring.ch8.bean.MyOtherBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
public class Main {

    public static void main(String... args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml", Main.class);

        MyBean myBean = context.getBean(MyBean.class);
        myBean.sayHello();
        System.out.println("We will see some $$EnhancerBySpringCGLIB$$ in the class name: " + myBean.getClass());

        MyOtherBean myOtherBean = context.getBean(MyOtherBean.class);
        myOtherBean.sayHelloDelayed();
        System.out.println("We will see some $$EnhancerBySpringCGLIB$$ in the class name: " + myOtherBean.getClass());
    }
}

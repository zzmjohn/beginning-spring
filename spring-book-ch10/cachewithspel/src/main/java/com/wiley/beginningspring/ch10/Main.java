package com.wiley.beginningspring.ch10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class Main {

    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);

        User userFetch1 = userService.getUser1(1);
        System.out.println(userFetch1);
        User userFetch2 = userService.getUser1(1);
        System.out.println(userFetch2);

        System.out.println("------------");

        User userFetch3 = userService.getUser2(1);
        System.out.println(userFetch3);
        User userFetch4 = userService.getUser2(1);
        System.out.println(userFetch4);

        System.out.println("------------");

        User userFetch5 = userService.getUser3(1);
        System.out.println(userFetch5);
        User userFetch6 = userService.getUser3(1);
        System.out.println(userFetch6);

        System.out.println("------------");

        User userFetch7 = userService.getUser4(1);
        System.out.println(userFetch7);
        User userFetch8 = userService.getUser4(1);
        System.out.println(userFetch8);

        System.out.println("------------");

        User userFetch9 = userService.getUser5(1);
        System.out.println(userFetch9);
        User userFetch10 = userService.getUser5(1);
        System.out.println(userFetch10);

        System.out.println("------------");

        User userFetch11 = userService.getUser6(1);
        System.out.println(userFetch11);
        User userFetch12 = userService.getUser6(1);
        System.out.println(userFetch12);

        System.out.println("------------");

        User userFetch13 = userService.getUser7(1);
        System.out.println(userFetch13);
        User userFetch14 = userService.getUser7(1);
        System.out.println(userFetch14);

        System.out.println("------------");

        User userFetch15 = userService.getUser8(1);
        System.out.println(userFetch15);
        User userFetch16 = userService.getUser8(1);
        System.out.println(userFetch16);

        System.out.println("------------");

        User userFetch17 = userService.getUser9(1);
        System.out.println(userFetch17);
        User userFetch18 = userService.getUser9(1);
        System.out.println(userFetch18);
    }
}

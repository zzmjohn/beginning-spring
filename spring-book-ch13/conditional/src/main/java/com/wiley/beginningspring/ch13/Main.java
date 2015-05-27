package com.wiley.beginningspring.ch13;

import com.wiley.beginningspring.ch13.service.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mertcaliskan
 * on 21/10/14.
 */
public class Main {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        NotificationService notificationService = (NotificationService) context.getBean("notificationService");
        notificationService.notify("johndoe");
    }
}


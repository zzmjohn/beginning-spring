package com.wiley.beginningspring.ch13;

import com.wiley.beginningspring.ch13.bean.Classroom;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mertcaliskan
 * on 21/10/14.
 */
public class Main {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Classroom classroom = context.getBean(Classroom.class);

        System.out.println(classroom.getClassroomList());
    }
}


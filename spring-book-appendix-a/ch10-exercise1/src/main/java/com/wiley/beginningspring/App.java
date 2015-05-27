package com.wiley.beginningspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseService = context.getBean(CourseService.class);

        Course course1 = new Course(1, "BBM490 - Enterprise Web Architecture");
        Course courseFetch1 = courseService.getCourse(course1);
        System.out.println(courseFetch1);
        Course courseFetch2 = courseService.getCourse(course1);
        System.out.println(courseFetch2);

        Course course2 = new Course(2, "ART101 - Introduction Photography");
        Course courseFetch3 = courseService.getCourse(course2);
        System.out.println(courseFetch3);
        Course courseFetch4 = courseService.getCourse(course2);
        System.out.println(courseFetch4);
    }
}

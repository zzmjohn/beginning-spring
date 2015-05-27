package com.wiley.beginningspring.ch10;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class Main {

    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassroomService classroomService = context.getBean(ClassroomService.class);

        Teacher teacher = new Teacher(1, "Mert");
        Student student1 = new Student(2, "Tugce");

        Person personFetch1 = classroomService.getPerson(teacher);
        System.out.println(personFetch1);

        Person personFetch2 = classroomService.getPerson(student1);
        System.out.println(personFetch2);

        CacheManager cacheManager = context.getBean(CacheManager.class);
        Cache students = cacheManager.getCache("students");
        System.out.println("students cache storage: " + ((ConcurrentHashMap)students.getNativeCache()).values());
        Cache teachers = cacheManager.getCache("teachers");
        System.out.println("teachers cache storage: " + ((ConcurrentHashMap)teachers.getNativeCache()).values());

    }
}

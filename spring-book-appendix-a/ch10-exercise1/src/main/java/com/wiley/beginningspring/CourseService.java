package com.wiley.beginningspring;

import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mertcaliskan
 * on 23/11/14.
 */
public class CourseService {

    private Map<Integer, Course> courses = new HashMap<>();
    {
        courses.put(1, new Course(1, "BBM490 - Enterprise Web Architecture"));
        courses.put(2, new Course(2, "ART101 - Introduction Photography"));
    }

    @Cacheable(value = "courses", condition = "#course.name.startsWith('BBM')")
    public Course getCourse(Course course) {
        System.out.println("Course with id " + course.getId() + " requested.");
        return courses.get(course.getId());
    }
}

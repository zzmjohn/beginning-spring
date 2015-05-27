package com.wiley.beginningspring.ch13.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by mertcaliskan
 * on 22/10/14.
 */
@Component
public class Classroom {

    @Autowired
    private List<Person> classroomList;

    public List<Person> getClassroomList() {
        return classroomList;
    }
}

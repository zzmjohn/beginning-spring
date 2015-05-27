package com.wiley.beginningspring.ch10;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class ClassroomService {

    private Map<Integer, Person> ppl = new HashMap<Integer, Person>();
    {
        ppl.put(1, new Teacher(1, "Mert"));
        ppl.put(2, new Student(2, "Tugce"));
    }

    @Caching(cacheable = {
        @Cacheable(value = "students", condition = "#obj instanceof T(com.wiley.beginningspring.ch10.Student)"),
        @Cacheable(value = "teachers", condition = "#obj instanceof T(com.wiley.beginningspring.ch10.Teacher)")
    })
    public Person getPerson(Person obj) {
        return ppl.get(obj.getId());
    }
}

package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
@Aspect
public class AtWithinPointcut {

    @Before("@within(com.wiley.beginningspring.ch8.markers.MarkerAnnotation)")
    public void before() {
        System.out.println("Before Advice with pointcut for Marker Method Annotation.");
    }
}

package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
@Aspect
public class ExecutionOrderBefore {

    @Before(value = "execution(public * *(..)) and args(param)")
    public void before(JoinPoint joinPoint, String param) {
        System.out.println("Before Advice. Argument: " + param);
    }
}

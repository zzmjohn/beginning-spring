package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
@Aspect
@Order(100)
public class ExecutionOrderBefore {

    @Before(value = "execution(public * *(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("===1. Before Advice.");
    }
}

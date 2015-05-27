package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
@Aspect
@Order(100)
public class ExecutionOrderAfterReturning {

    @AfterReturning(value = "execution(public * *(..))")
    public void afterReturning(JoinPoint joinPoint) {
       System.out.println("===6. After Returning Advice.");
    }
}

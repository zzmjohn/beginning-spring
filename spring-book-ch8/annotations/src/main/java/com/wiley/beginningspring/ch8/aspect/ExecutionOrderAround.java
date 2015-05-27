package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
@Aspect
@Order(200)
public class ExecutionOrderAround {

    @Around("execution(public * *(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("===2. Before proceeding part of the Around advice.");
        jp.proceed();
        System.out.println("===4. After proceeding part of the Around advice.");
    }
}

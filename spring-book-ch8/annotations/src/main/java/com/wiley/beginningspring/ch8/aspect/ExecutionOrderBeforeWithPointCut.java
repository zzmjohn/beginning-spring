package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 03/07/14
 */
@Component
@Aspect
@Order(110)
public class ExecutionOrderBeforeWithPointCut {

    @Pointcut("execution(public * *(..))")
    public void anyPublicMethod()  {
    }

    @Before("anyPublicMethod()")
    public void beforeWithPointCut(JoinPoint joinPoint) {
        System.out.println("===1.1. Before Advice with @PointCut.");
    }
}

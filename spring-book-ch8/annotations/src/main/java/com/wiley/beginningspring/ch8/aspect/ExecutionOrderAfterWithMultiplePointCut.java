package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
@Component
@Aspect
@Order(110)
public class ExecutionOrderAfterWithMultiplePointCut {

    @Pointcut("execution(public * *(..))")
    public void anyPublicMethod()  {
    }

    @Pointcut("@annotation(com.wiley.beginningspring.ch8.MarkerAnnotation)")
    public void annotatedWithMarkerAnnotation()  {
    }

    @After(value = "anyPublicMethod() & annotatedWithMarkerAnnotation()")
    public void afterWithMultiplePointcut(JoinPoint joinPoint) {
        System.out.println("===5.1. After Advice with Multiple Pointcut applied on method.");
    }
}

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
@Order(100)
public class ExecutionOrderAfterWithPointCut {

    @Pointcut("execution(public * *(..))")
    public void anyPublicMethod()  {
    }

    @After(value = "anyPublicMethod()")
    public void after(JoinPoint joinPoint) {
        System.out.println("===5.2. After Advice with pointcut.");
    }
}

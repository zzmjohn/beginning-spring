package com.wiley.beginningspring.ch8.aspect;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.core.Ordered;

import java.lang.reflect.Method;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
public class ExecutionOrderAfter implements AfterReturningAdvice, Ordered {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("===5. After Returning Advice.");
    }

    @Override
    public int getOrder() {
        return 150;
    }
}

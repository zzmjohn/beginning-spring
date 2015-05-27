package com.wiley.beginningspring.ch8.aspect;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
public class ExecutionTimeLoggingThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        String className = target.getClass().getCanonicalName();
        String methodName = method.getName();
        System.out.println("Execution of " + className + "#" + methodName + " ended with exception: " + ex.getMessage());
    }
}

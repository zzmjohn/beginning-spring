package com.wiley.beginningspring.ch8.aspect;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.core.Ordered;

import java.lang.reflect.Method;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
public class ExecutionOrderBefore implements MethodBeforeAdvice, Ordered {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("===1. Before Advice.");
    }

    @Override
    public int getOrder() {
        return 100;
    }
}

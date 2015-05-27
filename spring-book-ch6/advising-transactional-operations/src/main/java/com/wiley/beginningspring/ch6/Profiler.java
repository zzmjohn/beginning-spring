package com.wiley.beginningspring.ch6;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Profiler implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Long start = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            Long end = System.currentTimeMillis();
            System.out.println("Execution time of method " + 
            invocation.getMethod().getName() + " :" + (end - start) + " msec");
        }
    }
}


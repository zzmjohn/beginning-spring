package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
public class ExecutionOrderAround implements Ordered {

    public void executionOrder(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("===2. Before proceeding part of the Around advice.");
        jp.proceed();
        System.out.println("===4. After proceeding part of the Around advice.");
    }

    @Override
    public int getOrder() {
        return 200;
    }
}

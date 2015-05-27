package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.JoinPoint;
import org.springframework.core.Ordered;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
public class ExecutionOrderAfterFinally implements Ordered {

    public void executionOrder(JoinPoint jp) throws Throwable {
        System.out.println("===6. After (Finally) Advice.");
    }

    @Override
    public int getOrder() {
        return 100;
    }
}

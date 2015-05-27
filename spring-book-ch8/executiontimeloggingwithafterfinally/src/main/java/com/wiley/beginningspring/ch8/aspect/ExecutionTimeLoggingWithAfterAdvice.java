package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * User: mertcaliskan
 * Date: 25/06/14
 */
public class ExecutionTimeLoggingWithAfterAdvice {

    public void executiontimeLogging(JoinPoint jp) throws Throwable {
        String className = jp.getTarget().getClass().getCanonicalName();
        String methodName = jp.getSignature().getName();

        System.out.println("Execution of " + className + "#" + methodName + " ended");
    }
}

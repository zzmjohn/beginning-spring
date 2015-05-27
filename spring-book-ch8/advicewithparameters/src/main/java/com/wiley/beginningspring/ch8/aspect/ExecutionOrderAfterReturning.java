package com.wiley.beginningspring.ch8.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 09/07/14
 */
@Component
@Aspect
public class ExecutionOrderAfterReturning {

    @AfterReturning(value = "execution(public * *(..))", returning = "result")
    public void after(String result) {
        System.out.println("After Returning Advice with result: " + result);
    }
}
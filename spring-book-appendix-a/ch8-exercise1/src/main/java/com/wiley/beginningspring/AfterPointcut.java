package com.wiley.beginningspring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by mertcaliskan
 * on 23/11/14.
 */
@Component
@Aspect
public class AfterPointcut {

    @Pointcut("@annotation(com.wiley.beginningspring.MyAnnotation)")
    public void annotatedWithMyAnnotation()  {
    }

    @After(value = "annotatedWithMyAnnotation()")
    public void afterWithMultiplePointcut() {
        System.out.println("Method intercepted with @MyAnnotation");
    }
}

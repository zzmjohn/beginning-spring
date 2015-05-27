package com.wiley.beginningspring.ch8.aspect;

import com.wiley.beginningspring.ch8.bean.Bird;
import com.wiley.beginningspring.ch8.bean.IBird;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * User: mertcaliskan
 * Date: 05/07/14
 */
@Component
@Aspect
public class GreekMythologyIntroducer {
    @DeclareParents(
            value = "com.wiley.beginningspring.ch8.bean.Pegasus+",
            defaultImpl = Bird.class)
    public static IBird iBird;
}

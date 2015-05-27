package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by mertcaliskan
 * on 14/08/14.
 */
public class CollectionElementAccessTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void collectionFirstElementAccessOK() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Integer element = parser.parseExpression("#root.^[#this>3]").getValue(context, Integer.class);
        assertThat(element, is(4));
    }

    @Test
    public void collectionLastElementAccessOK() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Integer element = parser.parseExpression("#root.$[#this>3]").getValue(context, Integer.class);
        assertThat(element, is(9));
    }
}

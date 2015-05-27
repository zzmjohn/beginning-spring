package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mertcaliskan
 * on 15/08/14.
 */
public class FunctionRegistrationTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void functionRegisteredOK() throws NoSuchMethodException {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.registerFunction("capitalize",
                StringUtils.class.getDeclaredMethod("capitalize", new Class[] { String.class }));

        String value = parser.parseExpression("#capitalize('hello')").getValue(context, String.class);
        assertThat(value, is("Hello"));
    }
}
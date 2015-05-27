package com.wiley.beginningspring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mertcaliskan
 * on 23/11/14.
 */
public class ReverseFunctionTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void reverseFunctionRegisteredOK() throws NoSuchMethodException {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.registerFunction("reverse",
                MyStringUtils.class.getDeclaredMethod("reverse", new Class[] { String.class }));

        String value = parser.parseExpression("#reverse('hello')").getValue(context, String.class);
        assertThat(value, is("olleh"));
    }
}

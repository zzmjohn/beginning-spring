package com.wiley.beginningspring.ch9;

import com.wiley.beginningspring.ch9.domain.MyBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import static org.junit.Assert.assertTrue;

/**
 * Created by mertcaliskan
 * on 14/08/14.
 */
public class RootVariablesTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void rootVariableRegisteredOK() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(new MyBean());
        assertTrue(parser.parseExpression("#root").getValue(context) instanceof MyBean);
    }
}

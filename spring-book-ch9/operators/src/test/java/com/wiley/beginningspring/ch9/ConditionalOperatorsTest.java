package com.wiley.beginningspring.ch9;

import com.wiley.beginningspring.ch9.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by mertcaliskan
 * on 10/08/14.
 */
public class ConditionalOperatorsTest {

    ExpressionParser p;

    @Before
    public void setup() {
        p = new SpelExpressionParser();
    }

    @Test
    public void ternaryOperatorWorksOK() {
        User user1 = new User();
        StandardEvaluationContext context1 = new StandardEvaluationContext(user1);
        assertThat(p.parseExpression("Name != null ? 'Mert' : 'Funda'").getValue(context1, String.class), is("Funda"));

        User user2 = new User("Mert");
        StandardEvaluationContext context2 = new StandardEvaluationContext(user2);
        assertThat(p.parseExpression("Name != null ? 'Mert' : 'Funda'").getValue(context2, String.class), is("Mert"));
    }

    @Test
    public void elvisOperatorWorksOK() {
        User user1 = new User();
        StandardEvaluationContext context1 = new StandardEvaluationContext(user1);
        assertThat(p.parseExpression("Name ?: 'Funda'").getValue(context1, String.class), is("Funda"));

        User user2 = new User("Mert");
        StandardEvaluationContext context2 = new StandardEvaluationContext(user2);
        assertThat(p.parseExpression("Name ?: 'Funda'").getValue(context2, String.class), is("Mert"));
    }
}

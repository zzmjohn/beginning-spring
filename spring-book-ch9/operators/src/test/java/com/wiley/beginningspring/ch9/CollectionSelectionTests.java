package com.wiley.beginningspring.ch9;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mertcaliskan
 * on 14/08/14.
 */
public class CollectionSelectionTests {

    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void collectionSelectedOK() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> evenNumbers = parser.parseExpression("#root.?[#this%2 == 0 ?: false]").getValue(context, List.class);
        assertThat(evenNumbers, hasItems(2, 4, 6, 8));
    }
}

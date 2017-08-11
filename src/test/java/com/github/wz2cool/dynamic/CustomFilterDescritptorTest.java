package com.github.wz2cool.dynamic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Frank
 * \* Date: 8/11/2017
 * \* Time: 2:16 PM
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class CustomFilterDescritptorTest {

    @Test
    public void testDefaultConstructor() {
        CustomFilterDescriptor customFilterDescriptor =
                new CustomFilterDescriptor(FilterCondition.AND, "age > {0}", 1);

        assertEquals("age > {0}", customFilterDescriptor.getExpression());
        assertEquals(1, customFilterDescriptor.getParams()[0]);

    }
}
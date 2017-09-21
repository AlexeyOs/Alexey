package ru.pro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 19.09.2017.
 */
public class TestSimpleStack {
    /**
     * Test class SimpleStack when add(push) object in SimpleStack and poll them.
     */
    @Test
    public void whenSimpleStack() {
        SimpleStack simpleStack = new SimpleStack();
        simpleStack.push(1);
        simpleStack.push(2);
        assertThat(simpleStack.poll(), is(2));
    }
    /**
     * Test class SimpleStack when add(push) object in SimpleStack and poll them.
     */
    @Test
    public void whenSimpleStack2() {
        SimpleStack simpleStack = new SimpleStack();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.poll();
        assertThat(simpleStack.poll(), is(1));
    }
}

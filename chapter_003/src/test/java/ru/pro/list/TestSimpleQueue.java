package ru.pro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 19.09.2017.
 */
public class TestSimpleQueue {
    /**
     * Test class SimpleQueue when add(push) object in SimpleQueue and poll them.
     */
    @Test
    public void whenSimpleQueue() {
        SimpleQueue simpleQueue =  new SimpleQueue();
        simpleQueue.push(1);
        simpleQueue.push(2);
        assertThat(simpleQueue.poll(), is(1));
    }

    /**
     * Test class SimpleQueue when add(push) object in SimpleQueue and poll them.
     */
    @Test
    public void whenSimpleQueue2() {
        SimpleQueue simpleQueue =  new SimpleQueue();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.poll();
        assertThat(simpleQueue.poll(), is(2));
    }
}

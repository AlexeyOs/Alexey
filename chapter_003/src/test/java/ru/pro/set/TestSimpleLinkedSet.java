package ru.pro.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 04.10.2017.
 */
public class TestSimpleLinkedSet {
    /**
     * Create set.
     */
    private SimpleLinkedSet<Integer> set;

    /**
     * Before the test, initialize set and add three elements.
     */
    @Before
    public void beforeTheTest() {
        this.set = new SimpleLinkedSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
}

    /**
     * test method add(), if add success, then size on SimpleListSet class equals 4.
     */
    @Test
    public void whenAddOriginalElementThenItAddToTheSet() {
        set.add(4);
        assertThat(set.getSize(), is(4));
    }
    /**
     * test method add(), if add success, then size on SimpleListSet class equals 5.
     */
    @Test
    public void whenAddOriginalElementThenItAddToTheSet2() {
        set.add(3);
        set.add(5);
        assertThat(set.getSize(), is(4));
    }
}

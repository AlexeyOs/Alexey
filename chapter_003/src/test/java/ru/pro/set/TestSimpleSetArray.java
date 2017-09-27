package ru.pro.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 27.09.2017.
 */
public class TestSimpleSetArray {
    /**
     * whenAddInSimpleArray.
     */
    @Test
    public void whenAddInSimpleArray() {
        SimpleSetArray<String> ss = new SimpleSetArray<>();
        ss.add("first");
        ss.add("second");
        ss.add("first");
        ss.add("first");
        ss.add("second");

        int result = ss.getCount();
        int testData = 2;

        assertThat(result, is(testData));
    }
}

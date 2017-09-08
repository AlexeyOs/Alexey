package ru.pro.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 07.09.2017.
 */
public class TestSimpleArray {
    /**
     * Method whenCreateContainerShoulReturnTheSameType.
     */
    @Test
    public void whenCreateContainerShoulReturnTheSameType() {
        SimpleArray<String> simple = new SimpleArray<String>(4);
        simple.add("test");
        String result = simple.get(0);

        assertThat(result, is("test"));
    }

    /**
     * Method is whenUpdateObjectTypeInteger.
     */
    @Test
    public void whenUpdateObjectTypeInteger() {
        SimpleArray<Integer> simple = new SimpleArray<Integer>(4);
        simple.add(2);
        simple.add(3);
        simple.update(1, 2);
        int result = simple.get(0);
        assertThat(result, is(2));
    }

    /**
     * Method whenDeleteObjectTypeInteger.
     */
    @Test
    public void whenDeleteObjectTypeInteger() {
        SimpleArray<Integer> simple = new SimpleArray<Integer>(4);
        simple.add(2);
        simple.add(3);
        simple.add(4);
        simple.delete(0);
        Integer result = simple.get(0);

        assertThat(result, is(nullValue()));
    }

}

package ru.pro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 17.09.2017.
 */
public class TestLinkedContList {
    /**
     * Test when Add String To LinkedContList.
     */
    @Test
    public void whenAddStringToLinkedContList() {
        LinkedContList<String> list = new LinkedContList();
        list.add("Hi");
        list.add("Alex");
        String testData = "Hi";
        String result = list.get(0);
        assertThat(testData, is(result));
    }

    /**
     * Test when Add Integer To LinkedContList.
     */
    @Test
    public void whenAddIntToLinkedContList() {
        LinkedContList<Integer> list = new LinkedContList();
        list.add(1);
        list.add(2);
        int testData = 1;
        int result = list.get(0);
        assertThat(testData, is(result));
    }
    /**
     * Test when Add Integer To LinkedContList.
     */
    @Test
    public void whenGetToLastElementToLinkedContList() {
        LinkedContList<Integer> list = new LinkedContList();
        list.add(1);
        list.add(2);
        list.add(3);
        int testData = 3;
        int result = list.get(2);
        assertThat(testData, is(result));
    }
}

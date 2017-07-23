package ru.osetsky;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 23.07.2017.
 */
public class TestConvertList {
    /**
     * Test convert array to arrayList.
     */
    @Test
    public void whenArrayThenArrayList() {
        ConvertList conv = new ConvertList();
        List<Integer> testData = new ArrayList<Integer>();
        testData.add(1); testData.add(2); testData.add(3); testData.add(4); testData.add(5); testData.add(6);
        int[][] mas = new int[][] {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> result = conv.toList(mas);
        assertThat(testData, is(result));
    }
}

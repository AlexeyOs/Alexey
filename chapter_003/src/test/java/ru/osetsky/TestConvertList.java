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
    /**
     * Test convert array to arrayList.
     */
    @Test
    public void whenArray1ThenArrayList1() {
        ConvertList conv = new ConvertList();
        List<Integer> testData = new ArrayList<Integer>();
        testData.add(1); testData.add(2); testData.add(3); testData.add(4); testData.add(5); testData.add(6);
        testData.add(7); testData.add(8);
        int[][] mas = new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        List<Integer> result = conv.toList(mas);
        assertThat(testData, is(result));
    }

    /**
     * Test convert array to arrayList.
     */
    @Test
    public void whenArrayListThenArray() {
        ConvertList conv = new ConvertList();
        int[][] testData = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        List<Integer> list = new ArrayList<Integer>();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6);
        list.add(7);
        int[][] result = conv.toArray(list, 3);
        assertThat(testData, is(result));
    }

    /**
     * Test add List to List_General.
     */
    @Test
    public  void whenListIntegerThenGeneralListInteger() {
        ConvertList conv = new ConvertList();
        List<Integer> testData = new ArrayList<Integer>();
        testData.add(1); testData.add(2); testData.add(3); testData.add(4); testData.add(5); testData.add(6);
        List<Integer> result;
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{1, 2, 3, 4, 5, 6});
        result = conv.convert(list);
        assertThat(testData, is(result));
    }
}

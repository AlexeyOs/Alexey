package ru.pro.list;

import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 13.09.2017.
 */
public class TestDynamicList {
    /**
     * Test when add Text To Default Constructor DinamicList.
     */
    @Test
    public void whenTextToDefaultConstructorDinamicList() {

        DynamicList<String> din = new DynamicList<>();
        din.add("Hello");
        din.add("Alex");
        String testData = "Hello";
        String result = din.get(0);

        assertThat(result, is(testData));
    }
    /**
     * Test when add Text To Constructor With Param DinamicList.
     */
    @Test
    public void whenTextToConstructorWithParamDinamicList() {
        DynamicList<String> arrCont = new DynamicList<>(2);
        String[] strArr = {"001", "002", "003", "004"};

        for (String str : strArr) {
            arrCont.add(str);
        }

        Iterator it = arrCont.iterator();
        int ind = 0;
        while (it.hasNext()) {
            assertThat(it.next(), is(strArr[ind++]));
        }
    }

}

package ru.pro.iterator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 07.09.2017.
 */
public class TestConvertIt {
    /**
     * Method is whenSetIterator.
     */
    @Test
    public void whenSetIterator() {
        Iterator<Integer> it1 = Arrays.asList(1, 2).iterator();
        Iterator<Integer> it2 = Arrays.asList(3, 4).iterator();
        Iterator<Iterator<Integer>> it = Arrays.asList(it1, it2).iterator();
        Iterator<Integer> convertresult = new ConvertIt().convert(it);
        Iterator<Integer> expect = Arrays.asList(1, 2, 3, 4).iterator();
        if (convertresult.hasNext()) {
            assertThat(convertresult.next(), is(expect.next()));
        }
    }

    /**
     * Method is whenSetIterator2.
     */
    @Test
    public void whenSetIterator2() {
        Iterator<Integer> it1 = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
        Iterator<Integer> it2 = Arrays.asList(0, 9, 8, 7, 5).iterator();
        Iterator<Integer> it3 = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();
        Iterator<Iterator<Integer>> it = Arrays.asList(it1, it2, it3).iterator();
        Iterator<Integer> testData = Arrays.asList(4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();

        ConvertIt iter = new ConvertIt();
        Iterator<Integer> result = iter.convert(it);

        if (result.hasNext()) {
            assertThat(result.next(), is(testData.next()));
        }
    }
}

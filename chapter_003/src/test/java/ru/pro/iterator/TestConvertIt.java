package ru.pro.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 07.09.2017.
 */
public class TestConvertIt {
    /**
     * class object.
     */
    private ConvertIt convertIterator;
    /**
     * Method is whenSetIterator.
     */
    @Test
    public void whenSetIterator() {
        Iterator<Integer> it1 = Arrays.asList(1, 2).iterator();
        Iterator<Integer> it2 = Arrays.asList(3, 4).iterator();
        ArrayList<Iterator<Integer>> iterators = new ArrayList<>();
        iterators.add(it1);
        iterators.add(it2);
        Iterator<Iterator<Integer>> it = iterators.iterator();
        this.convertIterator = new ConvertIt(it);
        convertIterator.next();
        int result = convertIterator.next();
        assertThat(result, is(2));
    }

    /**
     * Method is whenSetIterator2.
     */
    @Test
    public void whenSetIterator2() {
        Iterator<Integer> it1 = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
        Iterator<Integer> it2 = Arrays.asList(0, 9, 8, 7, 5).iterator();
        Iterator<Integer> it3 = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();
        ArrayList<Iterator<Integer>> iterators = new ArrayList<>();
        iterators.add(it1);
        iterators.add(it2);
        iterators.add(it3);
        Iterator<Iterator<Integer>> it = iterators.iterator();
        convertIterator = new ConvertIt(it);
        convertIterator.next();
        convertIterator.next();
        int result = convertIterator.next();
        assertThat(result, is(0));
    }
}

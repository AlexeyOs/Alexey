package ru.pro.iterator;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 06.09.2017.
 */
public class TestEvenIt {

    /**
     * Method whenEventItNext.
     */
    @Test
    public void whenEventItNext() {
        Iterator it = new EvenIt(new int[] {4, 2, 3, 1});
        int result = (Integer) it.next();
        assertThat(result, is(4));
    }

    /**
     * Method whenEventItNext2.
     */
    @Test
    public void whenEventItNext2() {
        Iterator it = new EvenIt(new int[] {4, 2, 5, 3});
        it.next();
        int result = (Integer) it.next();
        assertThat(result, is(2));
    }

    /**
     * Method whenEventItHasNext.
     */
    @Test
    public void whenEventItHasNext() {
        Iterator it = new EvenIt(new int[] {4, 2, 1, 1});
        it.next();
        assertThat(it.hasNext(), is(true));
    }

    /**
     * Method whenEventItHasNext2.
     */
    @Test
    public void whenEventItHasNext2() {
        Iterator it = new EvenIt(new int[] {4, 1, 1, 1});
        assertThat(it.hasNext(), is(true));
    }

    /**
     * Method whenEventItHasNext3.
     */
    @Test
    public void whenEventItHasNext3() {
        Iterator it = new EvenIt(new int[] {4, 2, 1, 1});
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}

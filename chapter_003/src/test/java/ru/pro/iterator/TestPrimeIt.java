package ru.pro.iterator;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 07.09.2017.
 */
public class TestPrimeIt {
    /**
     * Method whenPrimeItNext.
     */
    @Test
    public void whenPrimeItNext() {
        Iterator it = new PrimeIt(new int[] {3, 4, 5, 6, 7});
        it.next();
        int result = (Integer) it.next();
        assertThat(result, is(5));
    }
    /**
     * Method whenPrimeItNext2.
     */
    @Test
    public void whenPrimeItNext2() {
        Iterator it = new PrimeIt(new int[] {3, 4, 5, 6, 7});
        it.next();
        it.next();
        int result = (Integer) it.next();
        assertThat(result, is(7));
    }
    /**
     * Method whenPrimeItHasNext.
     */
    @Test
    public void whenPrimeItHasNext() {
        Iterator it = new PrimeIt(new int[] {3, 4, 5, 6, 7});
        it.next();
        it.next();
        assertThat(it.hasNext(), is(true));
    }
}

package ru.pro.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by koldy on 03.09.2017.
 */
public class TestIteratorArray {
    /**
     * Method  whenIteratorPutMassive.
     */
    @Test
    public void whenIteratorPutMassive() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2}, {3, 4}});
        it.next();
        it.next();
        it.next();
        int result = (Integer) it.next();
        assertThat(result, is(4));
    }

    /**
     * Method whenIteratorNotPutTheMassive.
     */
    @Test
    public void whenIteratorNotPutTheMassive() {
        IteratorArray it = new IteratorArray(new int[][] {{1}});
        it.next();
        it.hasNext();
        assertThat(it.hasNext(), is(false));
    }
}

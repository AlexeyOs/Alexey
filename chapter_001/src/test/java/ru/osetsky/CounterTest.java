package ru.osetsky;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 12.03.2017.
 */
public class CounterTest {
    /**
     * sum of number 1-4.
     */
    @Test
    public void whenEvenOneToFourThenSix() {
        Counter counter = new Counter();
        assertThat(counter.add(1, 4), is(6));
    }

    /**
     * sum of number 1-10.
     */
    @Test
    public void whenEvenOneToTenThenThirty() {
        Counter counter = new Counter();
        assertThat(counter.add(1, 10), is(30));

    }
}
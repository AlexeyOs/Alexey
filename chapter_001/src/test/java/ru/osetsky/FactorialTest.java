package ru.osetsky;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 12.03.2017.
 */
public class FactorialTest {
    /**
     * factorial 4!=24.
     */
    @Test
    public void whenFactorialIsFourThenTwentyFour() {
        Factorial f = new Factorial();
        assertThat(f.factorial(4), is(24));
    }
    /**
     * factorial 3!=6.
     */
    @Test
    public void whenFactorialIsThreeThenNine() {
        Factorial f = new Factorial();
        assertThat(f.factorial(3), is(6));
    }

}
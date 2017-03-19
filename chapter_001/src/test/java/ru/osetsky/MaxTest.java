package ru.osetsky;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 12.03.2017.
 */
public class MaxTest {
    /**
     * Max.
     */
    @Test
    public void threeAndSevenThenSeven() {
        Max m = new Max();
        assertThat(m.max(3, 7), is(7));
    }

}
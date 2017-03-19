package ru.osetsky;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 12.03.2017.
 */
public class PointTest {
    /**
     * Distance between (1,1) and (5,1).
     */
    @Test
    public void whenOneOneFiveOneThenFour() {
        final Point pointA = new Point(1, 1);
        final Point pointB = new Point(5, 1);

        final double result = pointA.distanceTo(pointB);
        assertThat(result, closeTo(4.0, 0.5));
    }
}
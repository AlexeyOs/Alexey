package ru.osetsky;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 12.03.2017.
 */
public class TriangleTest {
	/**
	 * method verify area trinagle.
	 */
    @Test
    public void whenCALong() {

        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 2));
        double result = triangle.area();
        final double area = 0;

        assertThat(result, is(area));
    }

}
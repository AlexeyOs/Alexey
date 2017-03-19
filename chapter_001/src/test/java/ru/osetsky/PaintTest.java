package ru.osetsky;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koldy on 12.03.2017.
 */
public class PaintTest {
	/**
	 * TestPaint.
	 */
    @Test
    public void whenBuidPyramidHeightZeroThenPyramid() {
        Paint p = new Paint();
        assertEquals(p.piramid(0), "");
    }
    /**
     * Build pyramid with height = 1.
     */
    @Test
    public void whenBuidPyramidHeightOneThenPyramid() {
        Paint p = new Paint();
        assertEquals(p.piramid(1), "^");
    }
}
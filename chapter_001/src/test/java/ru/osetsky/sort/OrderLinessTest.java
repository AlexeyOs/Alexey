package ru.osetsky.sort;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by koldy on 18.03.2017.
 */
public class OrderLinessTest {
	/**
	 *method verify sort on ascending.
	 */
    @Test
    public void sortAscending() {
        OrderLiness arr = new OrderLiness();
        int[] a1 = {1, 3, 4, 5};
        boolean b = arr.orderS(a1);
        assertTrue(b);
    }
}
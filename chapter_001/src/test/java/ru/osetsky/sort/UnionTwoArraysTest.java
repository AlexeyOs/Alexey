package ru.osetsky.sort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 14.03.2017.
 */
public class UnionTwoArraysTest {
	/**
	 * method verifyUnion.
	 */
    @Test
    public void verifyUnion() {
    UnionTwoArrays arr = new UnionTwoArrays();
    int[] a1 = {1, 2, 5};
    int[] a2 = {3, 4};
    int[] a = {1, 2, 3, 4, 5};
    assertThat(arr.unionTwo(a1, a2), is(a));
    }

}
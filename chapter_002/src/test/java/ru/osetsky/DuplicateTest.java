package ru.osetsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Alexey Osetsky (alexeyosetsky@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
 public class DuplicateTest {
	 /**
	  * method copyArray.
	  */
	@Test
	public void copyArray() {
		String[] actual = {"hello", "world", "world", "hello", "dud", "sister"};
		String[] expected = {"hello", "world", "dud", "sister"};
		Duplicate duplicate = new Duplicate();
		assertThat(duplicate.copyArray(actual), is(expected));
	}
 }
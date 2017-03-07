package ru.osetsky;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
	@Test
	public void copyArray() {
		String[] actual = {"hello","world","world","hello","dud","sister"};
		String[] expected = {"hello","world","dud","sister"};
		Duplicate duplicate = new Duplicate();
		assertThat(duplicate.copyArray(actual), is(expected));
		
	}
 }
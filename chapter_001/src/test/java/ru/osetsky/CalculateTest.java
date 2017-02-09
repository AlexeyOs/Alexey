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
 public class CalculateTest {
	/**
	* Test add.
	*/
	@Test
	public void whenExexuteMainThenPrintToConsole() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(out.toString(), is("Hello World\r\n"));
	}
 }
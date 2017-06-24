package ru.osetsky.shape;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 21.06.2017.
 */
public class PaintTest {
	/**
	 * Method is howPaintTriangle.
	 */
    @Test
    public void howPaintTriangle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream(); //
        System.setOut(new PrintStream(out));
        Triangle triangle = new Triangle();
        Paint paint = new Paint();
        paint.draw(triangle);
        assertThat(out.toString(), is(" ^ \r\n^ ^\r\n^^^\r\n"));
    }
	/**
	 * Method is howPaintSquare.
	 */
    @Test
    public void howPaintSquare() {
        ByteArrayOutputStream out = new ByteArrayOutputStream(); //
        System.setOut(new PrintStream(out));
        Square square = new Square();
        Paint paint = new Paint();
        paint.draw(square);
        assertThat(out.toString(), is("---\r\n| |\r\n---\r\n"));
    }
}

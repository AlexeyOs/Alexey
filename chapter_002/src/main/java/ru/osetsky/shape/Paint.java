package ru.osetsky.shape;

/**
 * Created by koldy on 20.04.2017.
 */
public class Paint {
	/**
	 * Method is draw.
	 * @param shape It is shape.
	 */
    public void draw(Shape shape) {
		Triangle triangle = new Triangle();
		Square square = new Square();
    	if (shape==triangle) {
			System.out.print(triangle.pic());
		}
		if (shape==square) {
			System.out.print(triangle.pic());
		}
    }
}

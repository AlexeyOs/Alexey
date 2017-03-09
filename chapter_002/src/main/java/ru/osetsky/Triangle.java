package ru.osetsky;

/**
 *Class Triangle решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Triangle {
	/**
	 * field a.
	 */
	private Point a;
	/**
	 * field b.
	 */
	private Point b;
	/**
	 * field c.
	 */
	private Point c;
	/**
	 * field perimetr.
	 */
	private double perimetr;
	 /**
	 * method Triangle.
	 * @param a first param
	 * @param b second param
	 * @param c third param
	 */
	public Triangle(Point a, Point b, Point c) {
	this.a = a;
	this.b = b;
	this.c = c;
	}
	/**
	 * method area.
	 * @return triangle.
	 */
	public double area() {
	//calculate the triangle area
	this.perimetr = distanceTo(a, b) + distanceTo(b, c) + distanceTo(c, a);
	return Math.sqrt(perimetr * (perimetr - distanceTo(a, b)) * (primetr - distanceTo(b, c)) * (perimetr - distanceTo(c, a)));
	}
}
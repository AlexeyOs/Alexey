package ru.osetsky;

/**
 *Class Point решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Point {
	/**
	 * field x.
	 */
	private double x;
	/**
	 * field y.
	 */
	private double y;
	/**
	 * field bool.
	 */
	private boolean bool = true;
	 /**
	 * method Point.
	 * @param x first param
	 * @param y second param
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * method distanceTo.
	 * @param point first param
	 * @return sqrt.
	 */
	public double distanceTo(Point point) {
	if (bool == Triangle.exists())	{
		double dx = this.x - x;
		double dy = this.y - y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	}
}

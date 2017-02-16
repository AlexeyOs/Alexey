package ru.osetsky;

public class Point {
	public double x;
	public double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Point point) {
	//calculate distance between two points 
	double dx = this.x-x;
	double dy = this.y-y;
	return Math.sqrt(dx*dx+dy*dy);
	}
}

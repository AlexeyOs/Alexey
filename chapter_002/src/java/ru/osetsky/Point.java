package ru.osetsky;

import java.io.File;

public class Point {
	public double x;
	public double y;
	public boolean bool=true; 
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Point point) {
	//calculate distance between two points 
	if (bool == Triangle.exists())	{
		double dx = this.x-x;
		double dy = this.y-y;
		return Math.sqrt(dx*dx+dy*dy);
	}
	}
}

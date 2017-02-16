package ru.osetsky;

public class Triangle {
	public Point a;
	public Point b;
	public Point c;	
	public double perimetr;	
	public Triangle(Point a, Point b, Point c) {
	this.a = a;
	this.b = b;
	this.c = c;
	}

	public double area() {
	//calculate the triangle area
	this.perimetr = distanceTo(a,b) + distanceTo(b,c) + distanceTo(c,a);
	return Math.sqrt(perimetr*(perimetr-distanceTo(a,b))*(primetr-distanceTo(b,c))*(perimetr-distanceTo(c,a)));
	}
}
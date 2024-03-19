package it.corso.inizio;

public class Triangle implements Shape {

	double base;
	double height;
	Point vertex;
	
	public Triangle(double base, double height, Point vertex) {
		super();
		this.base = base;
		this.height = height;
		this.vertex = vertex;
	}

	public double getBase() {
		return base;
	}

	public double getHeight() {
		return height;
	}

	public Point getVertex() {
		return vertex;
	}
	
	public double calculateArea() {
		return base*height/2;
	}
	
}

package it.corso.inizio;

public class Rectangle implements Shape {

	double base;
	double height;
	Point vertex;
	
	@Override
	public double calculateArea() {
		return base*height;
	}

	public Rectangle(double base, double height, Point vertex) {
		super();
		this.base = base;
		this.height = height;
		this.vertex = (vertex == null ? new Point() : vertex) ;
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
		
}

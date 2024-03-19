package it.corso.inizio;

public class Square implements Shape {
	
	private double side;
	private Point corner;
	
	public Square(double side, Point corner) {
		super();
		this.side = side;
		this.corner = (corner == null ? new Point() : corner);
	}

	public double getSide() {
		return side;
	}

	public Point getCorner() {
		return corner;
	}

	public double calculateArea() {
		return Math.pow(side, 2);
	}
	
}

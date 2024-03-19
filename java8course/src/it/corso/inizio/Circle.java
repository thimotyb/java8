package it.corso.inizio;

/**
 * Classe che descrive un cerchio
 * 
 * @author azureuser
 */
public class Circle implements Shape {
	
	private Point center;
	private double radius;
	
	/**
	 * Costruttore unico, non possibile costruire oggetti vuoti
	 * @param x la coordinata di ascissa
	 * @param y la coordinata di ordinata
	 * @param radius il raggio 
	 */
	public Circle(Point center, double radius) {
		super();
		this.center = (center == null ? new Point() : center);
		this.radius = radius;
	}
	
	public double getX() {
		return center.getX();
	}
//	public void setX(double x) {
//		this.x = x;
//	}
	public double getY() {
		return center.getY();
	}
//	public void setY(double y) {
//		this.y = y;
//	}
	public double getRadius() {
		return radius;
	}
//	public void setRadius(double radius) {
//		this.radius = radius;
//	}
	
	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2.0d);
	}
	
}

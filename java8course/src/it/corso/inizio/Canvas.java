package it.corso.inizio;

import java.util.ArrayList;
import java.util.List;

/**
 * Costruire un Triangolo (base, height, vertex) e un Quadrato (side, corner)
 * Istanziarla all'interno di canvas
 * 
 * 1) Creare altre due liste, una per Triangoli e una per Quadrati
 * 2) Inserirvi qualche triangolo e qualche quadrato
 * 3) Prelevare l'area di un triangolo all'interno della lista
 * 
 * 
 * 4) Aggiungere un Rectangle (base, height, vertex) e verificare che Canvas con SHape e' OCP
 * 
 */
public class Canvas {

	public static void main(String[] args) {

		System.out.println("Hello World");
		System.out.println("Canvas.main()");
		
		Point pFake = null;
		Point p = new Point(2,2);
		
		Circle c = new Circle(pFake, 2.0d);		
		Circle c2 = new Circle(p, 4.0d);
		Circle c3 = new Circle(p, 8.0d);
		
		Square sq = new Square(5.0d, new Point(9.0d, 9.0d));
		Triangle tri = new Triangle(5, 15, new Point(3, 7));
		
		System.out.println(c.getX());
		
//		c.setX(12.5d);
//		c.setY(10.0d);
		
		System.out.println("Prima: "+c2.getX());
		
		p.setX(5);
		
		System.out.println("Dopo: "+c2.getX());
		
		System.out.println(c2.calculateArea());
		
		ArrayList<Circle> circles = new ArrayList<Circle>();
		circles.add(c);
		circles.add(c2);
		circles.add(c3);
		//circles.add(tri);
		//circles.add(square);
		
		System.out.println(circles.size());
		//System.out.println( ((Circle)circles.get(1)).getX() );
		
		//System.out.println( ((Circle)circles.get(3)).getX() );
		System.out.println(circles.get(1).calculateArea());
		
		ArrayList<Triangle> triangles = new ArrayList<Triangle>();
		triangles.add(new Triangle(3, 4, p));
		triangles.add(new Triangle(5, 4, p));
		System.out.println(triangles.get(1).calculateArea());
		
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(new Square(4,p));
		squares.add(new Square(8,p));
		
		
		// Troviamo la somma totale di tutte le forme inserite nelle collezioni
		// DRY Dont Repeat Yourself!
		double totalArea = 0.0d;
		for (int i = 0; i < circles.size(); i++) {
			totalArea = totalArea + circles.get(i).calculateArea();
		}
		for (Square square : squares) {
			totalArea += square.calculateArea();
		}
		for (Triangle triangle : triangles) {
			totalArea += triangle.calculateArea();
		}
		
		System.out.println(totalArea);
		
		///////////////////////////// OCP : Open Closed Principle ////////////////////////////
		
		List<Shape> shapes = new ArrayList<>();
		
		shapes.add(c);
		shapes.add(c2);
		shapes.add(c3);
		shapes.add(new Square(4,p));
		shapes.add(new Square(8,p));
		shapes.add(new Triangle(3, 4, p));
		shapes.add(new Triangle(5, 4, p));		
		shapes.add(new Rectangle(5,5,p));
		
		//shapes.get(3).calculateArea(); // Dynamic Binding
		totalArea = 0.0d;
		for(Shape shape : shapes) {
			totalArea += shape.calculateArea();
		}
		System.out.println(totalArea);
		
		ArrayList<Shape> circles2 = new ArrayList<>();

	}
}

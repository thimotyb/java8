package it.corso.annotations;

public class RuntimeAnnotationDemo {
    public static void main(String[] args) {
    	Point p = new Point(10, 10);
        Rectangle rect = new Rectangle(p, 20, 30);
        System.out.println(ToStrings.toString(rect));
        System.out.println("Using point: "+ToStrings.toString(p));
    }
}

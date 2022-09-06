package it.corso.annotations;

/*
Run these commands: (from src folder)

javac it/corso/annotations/ToStringAnnotationProcessor.java
javac -processor it.corso.annotations.ToStringAnnotationProcessor it/corso/annotations/*.java
java it.corso.annotations.SourceLevelAnnotationDemo
    
*/

public class SourceLevelAnnotationDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(new Point(10, 10), 20, 30);
        System.out.println(ToStrings.toString(rect));
    }
}

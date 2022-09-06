package it.corso.annotations;

@ToString
public class Rectangle {
    @ToString(includeName=false) private Point topLeft;
    @ToString private int width;
    @ToString private int height;
    public Rectangle(Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }    
    public Point topLeft() { return topLeft; }
    public int width() { return width; }
    public int height() { return height; }
}
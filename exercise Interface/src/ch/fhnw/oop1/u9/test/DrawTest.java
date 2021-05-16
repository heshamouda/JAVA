package ch.fhnw.oop1.u9.test;

import ch.fhnw.oop1.u9.Figure;
import ch.fhnw.oop1.u9.Line;
import ch.fhnw.oop1.u9.Point;
import ch.fhnw.oop1.u9.figures.Circle;
import ch.fhnw.oop1.u9.figures.ClosedPolygon;
import ch.fhnw.oop1.u9.figures.Rectangle;
import ch.fhnw.oop1.u9.figures.RoundedRectangle;
import ch.fhnw.oop1.u9.figures.Square;
import ch.fhnw.oop1.u9.figures.Triangle;
import ch.fhnw.oop1.u9.figures.Turtles;

public class DrawTest {
    public static void main(String[] args) {
        Turtles.show();
        
        Figure[] figures = {
             new Line(100, 200, 300, 10),
             new Square(30, 60, 80),
             new Rectangle(70, 90, 20, 80),
             new RoundedRectangle(270, 50, 90, 180, 20),
             new Triangle(new Point(100, 100), new Point(150,200), new Point(300,370)),
             new Circle(300, 300, 60),
             new ClosedPolygon(new int[]{400, 250, 170, 220, 190}, new int[]{10, 100, 90, 160, 100})
        };
        
        for(Figure f: figures) {
            f.draw();
        }
    }
}   

package ch.fhnw.oop1.u9.figures;

import ch.fhnw.oop1.u9.Point;

/**
 * Diese Klasse modelliert ein Dreieck.
 */
public class Triangle extends ClosedPolygon {

    /**
     * Konstruiert ein Dreieck.
     * @param p0 der erste Punkt
     * @param p1 der zweite Punkt
     * @param p2 der dritte Punkt
     */
    public Triangle(Point p0, Point p1, Point p2) {
        super(new int[]{p0.x, p1.x, p2.x}, new int[]{p0.y, p1.y, p2.y});
    }
    
    @Override
    public boolean equals(Object that) {
        return that instanceof Triangle    
            && super.equals(that);
    }
}

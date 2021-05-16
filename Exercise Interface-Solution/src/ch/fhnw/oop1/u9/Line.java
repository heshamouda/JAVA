package ch.fhnw.oop1.u9;

import ch.fhnw.oop1.u9.figures.Turtles;

/**
 * Diese Klasse modelliert eine Linie.
 */
public class Line extends Figure {
    private int x1;
    private int y1;

    /**
     * Konstruiert eine Linie.
     * 
     * @param x0 x-Koordinate des Startpunktes
     * @param y0 y-Koordinate des Startpunktes
     * @param x1 x-Koordinate des Endpunktes
     * @param y1 y-Koordinate des Endpunktes
     */
    public Line(int x0, int y0, int x1, int y1) {
        super(x0, y0);
        this.x1 = x1;
        this.y1 = y1;
    }

    /**
     * Gibt den Startpunkt zurück.
     * @return den Startpunkt
     */
    public Point getStart() {
        return new Point(getX(), getY());
    }

    /**
     * Gibt den Endpunkt zurück.
     * @return den Endpunkt
     */
    public Point getEnd() {
        return new Point(x1, y1);
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        x1 += dx;
        y1 += dy;
    }

    @Override
    public boolean equals(Object that) {
        return that instanceof Line 
                && getStart().equals(((Line) that).getStart())
                && getEnd().equals(((Line) that).getEnd());
    }

    @Override
    public void draw() {
        Turtles.moveTo(getX(), getY());
        Turtles.down();
        Turtles.moveTo(x1, y1);
        Turtles.up();
    }
}

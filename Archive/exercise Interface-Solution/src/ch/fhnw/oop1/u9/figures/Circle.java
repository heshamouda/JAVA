package ch.fhnw.oop1.u9.figures;

import ch.fhnw.oop1.u9.ClosedFigure;
import ch.fhnw.oop1.u9.Figure;

/** 
 * Diese Klasse modelliert einen Kreis.
 */
public class Circle extends Figure implements ClosedFigure {

    private int r;

    /**
     * Konstruiert einen Kreis.
     * @param x die x-Koordinate
     * @param y die y-Korrdinate
     * @param r der Radius
     */
    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    @Override
    public void draw() {
        int x = getX();
        int y = getY();

        // Wir wollen auf dem Kreis beginnen.
        // Es gilt: Math.cos(0) == 1, Math.sin(0) == 0 (siehe unten).
        Turtles.moveTo(x + r, y);
        Turtles.down();
        for (int i = 1; i <= 360; i++) {
            Turtles.moveTo((int) (x + r * Math.cos(i / 180.0 * Math.PI)),
                    (int) (y + r * Math.sin(i / 180.0 * Math.PI)));
        }
        Turtles.up();
    }

    /**
     * Gibt den Radius zurück.
     * @return den Radius
     */
    public int getRadius() {
        return r;
    }

    @Override
    public double getArea() {
        return r * r * Math.PI;
    }

    @Override
    public double getCircumference() {
        return 2 * r * Math.PI;
    }

    @Override
    public boolean isConvex() {
        return true;
    }
}

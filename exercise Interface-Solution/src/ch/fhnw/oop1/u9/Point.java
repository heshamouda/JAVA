package ch.fhnw.oop1.u9;

/**
 * Diese Klasse modelliert einen Punkt in der Ebene.
 */
public class Point {
    public final int x, y;

    /**
     * Konstruiert einen Punkt.
     * @param x die x-Koordinate
     * @param y die y-Koordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gibt die x-Koordinate zurück.
     * @return die x-Koordinate
     */
    public int getX() {
        return x;
    }
    
    /**
     * Gibt die y-Koordinate zurück.
     * @return die y-Koordinate
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object p) {
        return p instanceof Point 
            && x == ((Point) p).x
            && y == ((Point) p).y;
    }
}

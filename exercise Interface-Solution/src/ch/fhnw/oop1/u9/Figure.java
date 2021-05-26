package ch.fhnw.oop1.u9;

/**
 * Diese Klassen implementiert eine geometrische Figur.
 */
public abstract class Figure {

    private int x, y;

    /**
     * Konstruiert eine Figur. Die Koordinaten sind der Bezugspunkt der Figur.
     * 
     * @param x Die x-Koordinate
     * @param y Die y-Koordinate
     */
    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Verschiebt die Figur.
     * 
     * @param dx die Differenz in der x-Achse
     * @param dy die DIfferenz in der y-Achse
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    
    /**
     * Gibt die x-Koordinate zurück.
     * 
     * @return Die x-Koordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Gibt die y-Koordinate zurück.
     * 
     * @return Die y-Koordinate
     */
    public int getY() {
        return y;
    }
    
    /**
     * Zeichnet die Figur.
     */
    public abstract void draw();
    
    @Override
    public boolean equals(Object that) {
        return that instanceof Figure 
             && x == ((Figure) that).x 
             && y == ((Figure) that).y;
    }

    

}

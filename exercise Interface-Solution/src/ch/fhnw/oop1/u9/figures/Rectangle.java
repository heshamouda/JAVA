package ch.fhnw.oop1.u9.figures;

/**
 * Diese Klasse modelliert ein Rechteck.
 */
public class Rectangle extends ClosedPolygon {

    private int w;
    private int h;

    /**
     * Konstruiert ein Rechteck.
     * @param x die x-Koordinate
     * @param y die y-Koordinate
     * @param w die Breite
     * @param h die Höhe
     */
    public Rectangle(int x, int y, int w, int h) {
        super(new int[] { x, x + w, x + w, x }, new int[] { y, y, y + h, y + h });
        this.w = w;
        this.h = h;
    }

    /**
     * Gibt die Breite zurück.
     * @return die Breite
     */
    public int getWidth() {
        return w;
    }

    /**
     * Gibt die Höhe zurück.
     * @return die Höhe
     */
    public int getHeight() {
        return h;
    }

    @Override
    public boolean equals(Object that) {
        return that instanceof Rectangle
            && super.equals(that);
    }
}

package ch.fhnw.oop1.u9.figures;

/**
 * Diese Klasse modelliert ein Quadrat.
 */
public class Square extends ClosedPolygon {

    private int w;
    
    /**
     * Konstruiert ein Quadrat.
     * @param x die x-Koordinate
     * @param y die y-Koordinate
     * @param w die Seitenlänge
     */
    public Square(int x, int y, int w)  {
        super(new int[] {x, x+w, x+w, x}, new int[] {y, y, y+w, y+w});
        this.w = w;
    }
    
    /**
     * Gibt die Seitenlänge zurück.
     */
    public int getWidth() {
        return w;
    }
    
    @Override
    public boolean equals(Object that) {
        return that instanceof Square    
            && super.equals(that);
    }
}

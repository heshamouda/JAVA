package ch.fhnw.oop1.u9.figures;

import ch.fhnw.oop1.u9.ClosedFigure;
import ch.fhnw.oop1.u9.Figure;

/**
 * Diese Klasse modelliert ein Rechteck mit abgerundeten Ecken.
 */
public class RoundedRectangle extends Figure implements ClosedFigure {

    private int width;
    private int height;
    private int cornerRadius;

    /**
     * Konstruiert ein Rechteck.
     * @param x die x-Koordinate
     * @param y die y-Koordinate
     * @param width die Breite
     * @param height die Höhe
     * @param cornerRadius den Eckradius
     */
    public RoundedRectangle(int x, int y, int width, int height, int cornerRadius) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.cornerRadius = cornerRadius;
    }
    
    /**
     * Gibt die Breite zurück.
     * @return die Breite
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gibt die Höhe zurück.
     * @return die Höhe
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gibt den Eckradius zurück.
     * @return den Eckradius
     */
    public int getCornerRadius() {
        return cornerRadius;
    }
    
    @Override
    public boolean equals(Object that) {
        return that instanceof RoundedRectangle
            && super.equals(that)
            && width == ((RoundedRectangle)that).width
            && height == ((RoundedRectangle)that).height
            && cornerRadius == ((RoundedRectangle)that).cornerRadius;
    }

    @Override
    public double getArea() {
        return width * height 
             - 4 * cornerRadius * cornerRadius 
             + cornerRadius * cornerRadius * Math.PI;
    }

    @Override
    public double getCircumference() {
        return 2 * width + 2 * height - 8 * cornerRadius + 2 * cornerRadius * Math.PI;
    }

    @Override
    public boolean isConvex() {
        return true;
    }
    
    public void draw() {
        int x = getX(), y = getY();
        int width = getWidth(), height = getHeight();
        Turtles.moveTo(x + cornerRadius, y);
        Turtles.down();
        Turtles.moveTo(x + width - cornerRadius, y);
        Turtles.up();
        
        Turtles.moveTo(x + width, y + cornerRadius);
        Turtles.down();
        Turtles.moveTo(x + width, y + height - cornerRadius);
        Turtles.up();
        
        Turtles.moveTo(x + width - cornerRadius, y + height);
        Turtles.down();
        Turtles.moveTo(x + cornerRadius, y + height);
        Turtles.up();
        
        Turtles.moveTo(x, y + height - cornerRadius);
        Turtles.down();
        Turtles.moveTo(x, y + cornerRadius);
        Turtles.up();
        
        drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360);
        drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 180, 270);

        drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180);
        drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 0, 90);
    }

    
    private void drawArc(int x, int y, int r, int from, int to) {
        Turtles.up();
        for (int i = from; i <= to; i++) {
            Turtles.moveTo((int) (x + r * Math.cos(i / 180.0 * Math.PI)),
                           (int) (y + r * Math.sin(i / 180.0 * Math.PI)));
            if(i == from) Turtles.down();
        }
        Turtles.up();
    }
}

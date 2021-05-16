package ch.fhnw.oop1.u9.figures;

import ch.fhnw.oop1.u9.ClosedFigure;
import ch.fhnw.oop1.u9.Figure;
import ch.fhnw.oop1.u9.Line;
import ch.fhnw.oop1.u9.Polygon;

public class ClosedPolygon extends Figure implements Polygon, ClosedFigure {

    private int[] xCoords;
    private int[] yCoords;

    public ClosedPolygon(int[] xCoords, int[] yCoords) {
        super(xCoords[0], yCoords[0]);
        this.xCoords = xCoords;
        this.yCoords = yCoords;
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        for (int i = 0; i < xCoords.length; i++) {
            xCoords[i] += dx;
            yCoords[i] += dy;
        }
    }

    @Override
    public double getArea() {
        final int n = xCoords.length;
        double a = 0;
        for (int i = 0; i < n; i++) {
            a += xCoords[i] * yCoords[(i + 1) % n] - xCoords[(i + 1) % n] * yCoords[i];
        }
        return Math.abs(a / 2);
    }

    @Override
    public double getCircumference() {
        final int n = xCoords.length;
        double c = 0;
        for (int i = 0; i < n; i++) {
            double dx = xCoords[i] - xCoords[(i + 1) % n];
            double dy = yCoords[i] - yCoords[(i + 1) % n];
            c += Math.sqrt(dx * dx + dy * dy);
        }
        return c;
    }

    @Override
    public boolean isConvex() {
        final int n = xCoords.length;

        double signum = 0;
        for (int i = 0; i < n; i++) {
            double dx1 = xCoords[(i + 1) % n] - xCoords[i];
            double dy1 = yCoords[(i + 1) % n] - yCoords[i];
            double dx2 = xCoords[(i + 2) % n] - xCoords[(i + 1) % n];
            double dy2 = yCoords[(i + 2) % n] - yCoords[(i + 1) % n];
            double z = dx1 * dy2 - dy1 * dx2;

            if (signum == 0) {
                if (z > 0) {
                    signum = 1;
                } else if (z < 0) {
                    signum = -1;
                }
            } else {
                if (signum * z < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int getNumberOfEdges() {
        return xCoords.length;
    }

    @Override
    public Line[] getEdges() {
        Line[] edges = new Line[xCoords.length];

        final int n = xCoords.length;
        for (int i = 0; i < n; i++) {
            edges[i] = new Line(xCoords[i], yCoords[i], xCoords[(i + 1) % n], yCoords[(i + 1) % n]);
        }
        return edges;
    }
    
    @Override
    public void draw() {
        if (this.xCoords.length > 0) {
            int n = this.xCoords.length;
            Turtles.moveTo(xCoords[0], yCoords[0]);
            Turtles.down();
            for (int i = 1; i <= n; i++) {
                Turtles.moveTo(xCoords[i%n], yCoords[i%n]);
            }
            Turtles.up();
        }
    }
    
    @Override
    public boolean equals(Object that) {
        if(!(that instanceof ClosedPolygon)) {
            return false;
        }
        ClosedPolygon thatPoly = (ClosedPolygon) that;
        Line[] thisEdges = getEdges();
        Line[] thatEdges = thatPoly.getEdges();
        
        if(thisEdges.length != thatEdges.length) {
            return false;
        }
        
        for(int i = 0; i < thisEdges.length; i++) {
            if(thisEdges[i] != thatEdges[i]) {
                return false;
            }
        }
        return true;
    }
}

package ch.fhnw.oop.figures.abs;

import java.util.Scanner;

import ch.fhnw.oop.figures.abs.figures.Circle;
import ch.fhnw.oop.figures.abs.figures.Rectangle;

/**
 * Programm zur Berechnung von geometrischen Grössen von Figuren.
 */
public class Geometry {

    /**
     * Main.
     * 
     * @param args Die Programmargumente als String
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Was möchten Sie erstellen?");
            String str = s.nextLine();
            Figure f = null;
            switch (str) {
                case "Rechteck":
                    System.out.println("Breite?:");
                    double w = nextDouble(s);
                    System.out.println("Höhe?:");
                    double h = nextDouble(s);
                    f = new Rectangle(w, h);
                    break;
                case "Kreis":
                    System.out.println("Radius?:");
                    double r = nextDouble(s);
                    f = new Circle(r);
                    break;
                case "Quit":
                    System.out.println("Bye bye");
                    running = false;
                    break;
                default:
                    System.out.println("Nicht verstanden... ");
                    f = null;
                }

            if (f != null) {
                System.out.println("Fläche: " + f.getArea());
                System.out.println("Umfang: " + f.getCircumference());
            }
        }
    }
    
    /** Returns the next double and consumes the remaining newline. */
    private static double nextDouble(Scanner s) {
        double result = s.nextDouble();
        s.nextLine();
        return result;
    }
}

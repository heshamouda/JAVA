package ch.fhnw.oop.figures.abs;

/**
 * Definiert eine geometrische Figur.
 *
 */
public abstract class Figure {
	
	/**
	 * Berechnet die Fläche.
	 * 
	 * @return Die Fläche der Figur
	 */
	public abstract double getArea();
	
	/**
	 * Berechnet den Umfang.
	 * 
	 * @return  Den Umfang der Figur
	 */
	public abstract double getCircumference();
}

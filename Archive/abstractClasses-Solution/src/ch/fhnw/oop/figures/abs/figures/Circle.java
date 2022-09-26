package ch.fhnw.oop.figures.abs.figures;

import ch.fhnw.oop.figures.abs.Figure;

/**
 * Implementiert einen Kreis.
 */
public class Circle extends Figure {
	private double radius;

	/**
	 * Erzeugt einen Kreis.
	 * 
	 * @param radius Der Radius
	 */
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getCircumference() {
		return 2 * Math.PI * radius;
	}

}

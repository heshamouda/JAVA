package ch.fhnw.oop.figures.abs.figures;

import ch.fhnw.oop.figures.abs.Figure;

/**
 * Implementiert ein Rechteck.
 */
public class Rectangle extends Figure {
	private double width;
	private double heigth;
	
	/**
	 * Konstruiert ein Rechteck.
	 * 
	 * @param w  Die Länge
	 * @param h  Die Höhe
	 */
	public Rectangle(double width, double heigth) {
		super();
		this.width = width;
		this.heigth = heigth;
	}

	@Override
	public double getArea() {
		return width * heigth;
	}

	@Override
	public double getCircumference() {
		return 2 * (width + heigth);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}
}

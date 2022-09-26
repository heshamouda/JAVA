package ch.fhnw.oop1.u9;

/**
 * Modelliert eine geschlossene Figur.
 */
public interface ClosedFigure {
	/**
	 * Gibt die Fläche der Figur zurück.
	 * @return die Fläche
	 */
    double getArea();
	
	/**
	 * Gibt den Umfang der Figur zurück.
	 * @return den Umfang
	 */
	double getCircumference();
	
	/**
	 * Prüft ob die Figur konvex ist.
	 * @return true, wenn die Figur konvex ist, sonst false.
	 */
	boolean isConvex();
}

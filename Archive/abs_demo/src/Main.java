import java.awt.Rectangle;

import abs.figure.Figure;
import abs.figures.Square;

public class Main {

	public static void main(String[] args) {
		Figure[] figures;
		figures[0] = new Square(0, 0, 10);
		figures[1] = new Rectangle(10, 10, 20, 10);
		
		for(Figure f : figures) {
		f.draw( );
		}

	}

}

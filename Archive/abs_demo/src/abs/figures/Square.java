package abs.figures;

import abs.figure.Figure;

public class Square extends Figure {

	private int size;

	public Square(int x, int y, int w) {
		super(x, y);
		size = w;
	}

	public int getSize() {
		return size;
	}

	@Override
	public void draw() {
		drawRectangle(getX(), getY(), w, w);
	}

}

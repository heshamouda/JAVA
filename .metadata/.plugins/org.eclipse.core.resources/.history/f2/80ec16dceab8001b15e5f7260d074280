package ch.fhnw.oop1.u9.figures;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Class Turtles implements a turtles graphics. The turtle is a point which has
 * a x/y-position, a direction and a pen up/down state. Methods such as move,
 * left, right are used to move the turtle and, depending on the pen state, to
 * draw.
 * 
 * Turtle Graphics are known from the Logo programming language.
 * 
 * The Graphics Turtle is a cursor that has a position (X and Y coordinates), a
 * heading and a pen up/down state. Procedures such as forward, left, etc are
 * used as drawing idioms.
 * 
 * @author Dominik Gruntz
 * 
 */
@SuppressWarnings("serial")
public class Turtles {
	private static boolean down = false;
	private static int x, y, direction;
	private static Color color = Color.BLACK;
	private static List<Line> lines = new CopyOnWriteArrayList<>();

	private static JFrame frame = new JFrame();

	static {
		frame.add(new JComponent() {
			@Override
			public void paint(Graphics g) {
				for (Line line : lines) {
					g.setColor(line.color);
					g.drawLine(line.x1, line.y1, line.x2, line.y2);
				}
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400, 400));
	}

	private static class Line {
		private int x1, y1, x2, y2;
		private Color color;

		public Line(int x1, int y1, int x2, int y2, Color color) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.color = color;
		}
	}

	public static void setColor(Color c) {
		color = c;
	}

	/**
	 * Shows the graphics window.
	 */
	public static void show() {
		frame.setVisible(true);
	}

	/**
	 * Hides the graphics window.
	 */
	public static void hide() {
		frame.setVisible(false);
	}

	/**
	 * Clears the graphics window.
	 */
	public static void clear() {
		lines.clear();
		frame.repaint();
	}

	/**
	 * Sets the pen state in down position. Moving the turtle will draw and
	 * change its position.
	 */
	public static void down() {
		down = true;
	}

	/**
	 * Sets the pen state in up position. Moving the turtle will not draw, just
	 * change its position.
	 */
	public static void up() {
		down = false;
	}

	/**
	 * Changes the direction of the turtle to the left (counterclockwise).
	 * 
	 * @param angle
	 *            the angle in degree the turtle turns.
	 * 
	 */
	public static void left(int angle) {
		direction -= angle;
	}

	/**
	 * Changes the direction of the turtle to the right (clockwise).
	 * 
	 * @param angle
	 *            the angle in degree the turtle turns.
	 * 
	 */
	public static void right(int angle) {
		direction += angle;
	}

	/**
	 * Moves the turtle in the current direction. The pen state determines
	 * whether the turtle draws or not.
	 * 
	 * @param distance
	 *            the distance the turtle moves, may be negative.
	 * @see down
	 * @see up
	 */
	public static void move(int distance) {
		int x1 = x
				+ (int) Math.round(Math.cos(direction * Math.PI / 180)
						* distance);
		int y1 = y
				+ (int) Math.round(Math.sin(direction * Math.PI / 180)
						* distance);
		if (down) {
			lines.add(new Line(x, y, x1, y1, color));
		}
		x = x1;
		y = y1;
		frame.repaint();
	}

	/**
	 * Moves the turtle to the specified point. The pen state determines whether
	 * the turtle draws or not. This method does not change the direction of the
	 * turtle.
	 * 
	 * @param x
	 *            x-coordinate of the new position
	 * @param y
	 *            y-coordinate of the new position
	 */
	public static void moveTo(int x, int y) {
		if (down) {
			lines.add(new Line(Turtles.x, Turtles.y, x, y, color));
		}
		Turtles.x = x;
		Turtles.y = y;
		frame.repaint();
	}

	/**
	 * Sets the direction. The angle is specified in degrees (0..360). A
	 * direction of zero means moving to the right.
	 * 
	 * @param angle
	 * 
	 */
	public static void setDirection(int angle) {
		direction = -angle;
	}

}

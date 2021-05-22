package ch.fhnw.oop1.u9.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ch.fhnw.oop1.u9.ClosedFigure;
import ch.fhnw.oop1.u9.Line;
import ch.fhnw.oop1.u9.Point;
import ch.fhnw.oop1.u9.Polygon;
import ch.fhnw.oop1.u9.figures.Circle;
import ch.fhnw.oop1.u9.figures.ClosedPolygon;
import ch.fhnw.oop1.u9.figures.Rectangle;
import ch.fhnw.oop1.u9.figures.RoundedRectangle;
import ch.fhnw.oop1.u9.figures.Square;
import ch.fhnw.oop1.u9.figures.Triangle;

public class FigureTests {
	
	static class Tuple {
		Point p1, p2;
		Tuple(Point p1, Point p2) {
			if(p1.x < p2.x || p1.x == p2.x && p1.y < p2.y) {
				this.p1 = p1; this.p2 = p2;
			} else {
				this.p1 = p2; this.p2 = p1;
			}
		}
		@Override
		public int hashCode() {
			return ((p1.x*13+p2.x)*13+p1.y)*13+p2.y;
		}
		@Override
		public boolean equals(Object t) {
			return t instanceof Tuple && ((Tuple)t).p1.equals(p1) && ((Tuple)t).p2.equals(p2);
		}
	}
	
	@Test
	public void polygonTest() {
		int[] x = new int[]{1,3,2};
		int[] y = new int[]{0,0,2};
		ClosedPolygon cp = new ClosedPolygon(x.clone(), y.clone());
		assertTrue("ClosedPolygon must implement interface ClosedFigure", cp instanceof ClosedFigure);
		assertTrue("ClosedPolygon must implement interface Polygon", cp instanceof Polygon);
		assertTrue(((ClosedFigure)cp).isConvex());
		
		Polygon p = (Polygon)cp;
		assertEquals(3, p.getNumberOfEdges());
		Line[] lines = p.getEdges();
		assertEquals(3, lines.length);
		Set<Tuple> s1 = new HashSet<Tuple>();
		Set<Tuple> s2 = new HashSet<Tuple>();
		for(int i = 0; i < lines.length; i++) {
			s1.add(new Tuple(lines[i].getStart(), lines[i].getEnd()));
			s2.add(new Tuple(new Point(x[i], y[i]), new Point(x[(i+1) % lines.length], y[(i+1) % lines.length])));
		}
		assertTrue(s1.equals(s2));
		
		int dx = 1;
		int dy = -1;
		cp.move(dx, dy);
		p = (Polygon)cp;
		assertEquals(3, p.getNumberOfEdges());
		lines = p.getEdges();
		assertEquals(3, lines.length);
		s1 = new HashSet<Tuple>();
		s2 = new HashSet<Tuple>();
		for(int i = 0; i < lines.length; i++) {
			s1.add(new Tuple(lines[i].getStart(), lines[i].getEnd()));
			s2.add(new Tuple(new Point(x[i]+dx, y[i]+dy), new Point(x[(i+1) % lines.length]+dx, y[(i+1) % lines.length]+dy)));
		}
		assertTrue(s1.equals(s2));

		cp = new ClosedPolygon(new int[]{1,2,1,0}, new int[]{0,0,1,-2});
		assertFalse(((ClosedFigure)cp).isConvex());
		
		cp = new ClosedPolygon(new int[]{-1,1,1,-1}, new int[]{0,0,1,-1});
		assertFalse(((ClosedFigure)cp).isConvex());
		
		cp = new ClosedPolygon(new int[]{0,2,2,0}, new int[]{0, 0, 2, 2});
		assertTrue(((ClosedFigure)cp).isConvex());
		assertEquals(4, cp.getArea(), 1e-12);
		assertEquals(8, cp.getCircumference(), 1e-12);

		cp = new ClosedPolygon(new int[]{0,2,2,0}, new int[]{0, 0, 1, -1});
		assertFalse(((ClosedFigure)cp).isConvex());
		assertEquals(0, cp.getArea(), 1e-12);
		assertEquals(4+2*Math.sqrt(2), cp.getCircumference(), 1e-12);

		cp = new ClosedPolygon(new int[]{1,3,3,1,1,-1,-1,-3,-3,-1,-1,1}, new int[]{1,1,-1,-1,-3,-3,-1,-1,1,1,3,3});
		assertFalse(((ClosedFigure)cp).isConvex());
		assertEquals(20, cp.getArea(), 1e-12);
		assertEquals(24, cp.getCircumference(), 1e-12);
	}

	@Test
	public void polygon2Test() {
		int[] x = new int[]{0,1,3,2};
		int[] y = new int[]{0,0,0,2};
		ClosedPolygon cp = new ClosedPolygon(x, y);
		assertTrue("ClosedPolygon must implement interface Polygon", cp instanceof Polygon);
		assertTrue(((ClosedFigure)cp).isConvex());

		x = new int[]{0,1,3,2};
		y = new int[]{0,0,0,-2};
		cp = new ClosedPolygon(x, y);
		assertTrue("ClosedPolygon must implement interface Polygon", cp instanceof Polygon);
		assertTrue(((ClosedFigure)cp).isConvex());

		x = new int[]{2,0,1,3};
		y = new int[]{2,0,0,0};
		cp = new ClosedPolygon(x, y);
		assertTrue("ClosedPolygon must implement interface Polygon", cp instanceof Polygon);
		assertTrue(((ClosedFigure)cp).isConvex());

		x = new int[]{ 2,0,1,3};
		y = new int[]{-2,0,0,0};
		cp = new ClosedPolygon(x, y);
		assertTrue("ClosedPolygon must implement interface Polygon", cp instanceof Polygon);
		assertTrue(((ClosedFigure)cp).isConvex());
	}

	@Test
	public void rectangleTest() {
		Rectangle r = new Rectangle(0, 0, 2, 1);
		assertEquals(2, r.getWidth());
		assertEquals(1, r.getHeight());
		assertEquals(0, r.getX());
		assertEquals(0, r.getY());
		assertEquals(2.0, r.getArea(), 1e-15);
		assertEquals(6.0, r.getCircumference(), 1e-15);
		r.move(2, -3);
		assertEquals(2, r.getWidth());
		assertEquals(1, r.getHeight());
		assertEquals(2, r.getX());
		assertEquals(-3, r.getY());
		assertEquals(2.0, r.getArea(), 1e-15);
		assertEquals(6.0, r.getCircumference(), 1e-15);

		assertTrue("Rectangle must implement interface ClosedFigure", r instanceof ClosedFigure);
		ClosedFigure cf = (ClosedFigure) r;
		assertTrue("Rectangle is convex", cf.isConvex());
		
		int[] x = new int[]{2,4,4,2};
		int[] y = new int[]{-3,-3,-2,-2};
		assertTrue("Rectangle must implement interface Polygon", r instanceof Polygon);
		Polygon p = (Polygon) r;
		assertEquals(4, p.getNumberOfEdges());
		Line[] lines = p.getEdges();
		assertEquals(4, lines.length);
		Set<Tuple> s1 = new HashSet<Tuple>();
		Set<Tuple> s2 = new HashSet<Tuple>();
		for(int i = 0; i < lines.length; i++) {
			s1.add(new Tuple(lines[i].getStart(), lines[i].getEnd()));
			s2.add(new Tuple(new Point(x[i], y[i]), new Point(x[(i+1) % lines.length], y[(i+1) % lines.length])));
		}
		assertTrue(s1.equals(s2));

	}
	
	@Test
	public void circleTest() {
		Circle c = new Circle(2,5,10);
		assertEquals(Math.PI*100, c.getArea(), 1e-10);
		assertEquals(Math.PI*20, c.getCircumference(), 1e-10);
		assertEquals(2, c.getX());
		assertEquals(5, c.getY());
		assertEquals(10, c.getRadius());
		assertTrue("Circle must implement interface ClosedFigure", c instanceof ClosedFigure);
		ClosedFigure p = (ClosedFigure) c;
		assertTrue("Every circle is convex", p.isConvex());
		assertFalse("Circle must not be a polygon", c instanceof Polygon);
	}
	
	@Test
	public void squareTest() {
		Square s = new Square(2,5,10);
		assertEquals(100, s.getArea(), 1e-12);
		assertEquals(40, s.getCircumference(), 1e-12);
		assertEquals(2, s.getX());
		assertEquals(5, s.getY());
		assertEquals(10, s.getWidth());
		s.move(-2, -5);
		assertEquals(100, s.getArea(), 1e-12);
		assertEquals(40, s.getCircumference(), 1e-12);
		assertEquals(0, s.getX());
		assertEquals(0, s.getY());
		assertEquals(10, s.getWidth());
		assertTrue("Square must implement interface ClosedFigure", s instanceof ClosedFigure);
		ClosedFigure cf = (ClosedFigure) s;
		assertTrue("Square is convex", cf.isConvex());
		
		assertTrue("Square must implement interface Polygon", s instanceof Polygon);
		int[] x = new int[]{0,10,10,0};
		int[] y = new int[]{0,0,10,10};
		Polygon p = (Polygon) s;
		assertEquals(4, p.getNumberOfEdges());
		Line[] lines = p.getEdges();
		assertEquals(4, lines.length);
		Set<Tuple> s1 = new HashSet<Tuple>();
		Set<Tuple> s2 = new HashSet<Tuple>();
		for(int i = 0; i < lines.length; i++) {
			s1.add(new Tuple(lines[i].getStart(), lines[i].getEnd()));
			s2.add(new Tuple(new Point(x[i], y[i]), new Point(x[(i+1) % lines.length], y[(i+1) % lines.length])));
		}
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void lineTest(){
		Line l = new Line(0, 2, 1, 1);
		assertEquals(new Point(0, 2), l.getStart());
		assertEquals(new Point(1,1), l.getEnd());
		l.move(-1, -2);
		assertEquals(new Point(-1, 0), l.getStart());
		assertEquals(new Point(0,-1), l.getEnd());
		assertFalse("Line must not implement interface ClosedFigure", l instanceof ClosedFigure);
		assertFalse("Line must not implement interface Polygon", l instanceof Polygon);
	}
	
	@Test
	public void roundRectTest(){
		RoundedRectangle rr = new RoundedRectangle(1, -1, 6, 4, 2);
		assertEquals(6, rr.getWidth());
		assertEquals(4, rr.getHeight());
		assertEquals(2, rr.getCornerRadius());
		assertEquals(1, rr.getX());
		assertEquals(-1, rr.getY());
		assertEquals(4*(2+Math.PI), rr.getArea(), 1e-15);
		assertEquals(4*(1+Math.PI), rr.getCircumference(), 1e-15);
		assertTrue("RoundedRectangle must implement interface ClosedFigure", rr instanceof ClosedFigure);
		ClosedFigure p = (ClosedFigure) rr;
		assertTrue("every RoundedRectangle is convex", p.isConvex());
		assertFalse("RoundedRectangle must not implement interface Polygon", rr instanceof Polygon);
		rr.move(5, 3);
		assertEquals(6, rr.getWidth());
		assertEquals(4, rr.getHeight());
		assertEquals(2, rr.getCornerRadius());
		assertEquals(6, rr.getX());
		assertEquals(2, rr.getY());
		assertEquals(4*(2+Math.PI), rr.getArea(), 1e-15);
		assertEquals(4*(1+Math.PI), rr.getCircumference(), 1e-15);
	}
	
	@Test
	public void triangleTest(){
		Triangle t = new Triangle(new Point(0, 0), new Point(4, 0), new Point(2,2));
		assertEquals(4, t.getArea(), 1e-15);
		assertEquals(4*(1+Math.sqrt(2)), t.getCircumference(), 1e-15);
		
		assertTrue("Triangle must implement interface ClosedFigure", t instanceof ClosedFigure);
		ClosedFigure cf = (ClosedFigure) t;
		assertTrue("every triangle is convex", cf.isConvex());
		t.move(2, 3);
		assertEquals(4, t.getArea(), 1e-15);
		assertEquals(4*(1+Math.sqrt(2)), t.getCircumference(), 1e-15);

	
		int[] x = new int[]{2,6,4};
		int[] y = new int[]{3,3,5};
		assertTrue("Triangle must implement interface Polygon", t instanceof Polygon);
		Polygon p = (Polygon) t;
		assertEquals(3, p.getNumberOfEdges());
		Line[] lines = p.getEdges();
		assertEquals(3, lines.length);
		Set<Tuple> s1 = new HashSet<Tuple>();
		Set<Tuple> s2 = new HashSet<Tuple>();
		for(int i = 0; i < lines.length; i++) {
			s1.add(new Tuple(lines[i].getStart(), lines[i].getEnd()));
			s2.add(new Tuple(new Point(x[i], y[i]), new Point(x[(i+1) % lines.length], y[(i+1) % lines.length])));
		}
		assertTrue(s1.equals(s2));
	}

}

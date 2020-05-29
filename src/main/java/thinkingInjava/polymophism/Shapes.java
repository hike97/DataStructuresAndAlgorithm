package thinkingInjava.polymophism;

import java.util.Random;

/**
 * @author hike97 2month
 * @create 2020-04-18 11:37
 * @desc
 **/
class Shape {
	void draw(){}
	void erase(){
		System.out.println ("Shape.erase()");
	}
	void newMethod(){
		System.out.println ("newMethod");
	}
}
class  Circle extends Shape{
	@Override
	void draw(){
		System.out.println ("Circle.draw()");
	}
	@Override
	void erase(){
		System.out.println ("Circle.erase()");
	}

	void newMethod(){
		System.out.println ("Circle.newMethod");
	}
}
class  Triangle extends Shape{
	@Override
	void draw(){
		System.out.println ("Triangle.draw()");
	}
	@Override
	void erase(){
		System.out.println ("Triangle.erase()");
	}
}
class  Square extends Shape{
	@Override
	void draw(){
		System.out.println ("Square.draw()");
	}
	@Override
	void erase(){
		System.out.println ("Square.erase()");
	}
}
class RandomShapeGenerator{
	private Random rand = new Random(47);
	public Shape next(){
		switch (rand.nextInt (3)){
			default:
			case 0: return new Circle ();
			case 1: return new Square ();
			case 2: return new Triangle ();
		}
	}
}

public  class Shapes {
	private static  RandomShapeGenerator gen = new RandomShapeGenerator ();

	public static void main (String[] args) {
		Shape[] s = new Shape[9];
		for (int i = 0; i < s.length; i++) {
			s[i] = gen.next ();
		}
		for (Shape shape : s) {
			shape.draw ();
			shape.erase ();
			shape.newMethod ();
		}
	}

}
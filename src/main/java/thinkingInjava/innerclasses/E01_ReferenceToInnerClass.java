package thinkingInjava.innerclasses;

/**
 * @author hike97 2month
 * @create 2020-04-20 22:15
 * @desc
 **/
class Outer {
	class Inner {
		{ System.out.println("Inner created"); }
	}
	Inner getInner() { return new Inner(); }
}
public class E01_ReferenceToInnerClass {
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.getInner();
	}
}

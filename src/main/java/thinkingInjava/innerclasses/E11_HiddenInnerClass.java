package thinkingInjava.innerclasses;

import thinkingInjava.innerclasses.exercise6.SimpleInterface;

/**
 * @author hike97 2month
 * @create 2020-04-26 23:13
 * @desc
 **/
class Outer5 {
	private class Inner implements SimpleInterface {
		public void f() {
			System.out.println("Outer5.Inner.f");
		}
	}
	public SimpleInterface get() { return new Inner(); }
	public Inner get2() { return new Inner(); }
}
public class E11_HiddenInnerClass {
	public static void main(String args[]) {
		Outer5 out = new Outer5();
		SimpleInterface si = out.get();
		si = out.get2();
		//匿名类不对外暴露
		// Won't compile -- 'Inner' not visible:
		//! Inner i1 = out.get2();
		//! Inner i2 = (Inner)si;
	}
}

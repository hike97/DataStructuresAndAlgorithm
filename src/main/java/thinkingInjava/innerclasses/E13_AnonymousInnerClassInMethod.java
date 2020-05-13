package thinkingInjava.innerclasses;

import thinkingInjava.innerclasses.exercise6.SimpleInterface;

/**
 * @author hike97 2month
 * @create 2020-04-26 23:51
 * @desc
 **/
public class E13_AnonymousInnerClassInMethod {
	public SimpleInterface get() {
		class SI implements SimpleInterface{
			public void f() { System.out.println("SI.f"); }
		}
		return new SI();
	}
	public static void main(String args[]) {
		SimpleInterface si =
				new E09_InnerClassInMethod().get();
		si.f();
	}
}

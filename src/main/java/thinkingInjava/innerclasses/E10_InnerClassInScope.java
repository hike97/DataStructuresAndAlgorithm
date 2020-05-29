package thinkingInjava.innerclasses;

import thinkingInjava.innerclasses.exercise6.SimpleInterface;

/**
 * @author hike97 2month
 * @create 2020-04-25 23:11
 * @desc
 **/
public class E10_InnerClassInScope {
	public SimpleInterface get() {
		{
			class SI implements SimpleInterface{
				public void f() {
					System.out.println("SI.f");
				}
			}
			return new SI();
		}
	}
	public static void main(String args[]) {
		SimpleInterface si =
				new E10_InnerClassInScope().get();
		si.f();
	}
}

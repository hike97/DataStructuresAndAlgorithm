package thinkingInjava.reusing;

import thinkingInjava.reusing.protect.Derived;
import thinkingInjava.reusing.protect.E15_Protected;

/**
 * @author hike97 2month
 * @create 2020-04-13 18:14
 * @desc
 **/
public class E15_ProtectedTest {
	public static void main(String args[]) {
//		new E15_Protected ().f(); // Cannot access
		new Derived ().g();
	}
}

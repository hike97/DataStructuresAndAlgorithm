package thinkingInjava.access;

import thinkingInjava.access.local.E05_AccessControl;

/**
 * @author hike97 2month
 * @create 2020-04-08 22:38
 * @desc 不在同一个包只能访问public
 **/
public class E05_Other {
	public E05_Other() {
		E05_AccessControl test = new E05_AccessControl();
		test.a = 1;
		//! test.b = 2; // Can't access: private
		//! test.c = 3; // Can't access: protected
		//! test.d = 4; // Can't access: package
		test.f1();
		//! test.f2(); // Can't access: private
		//! test.f3(); // Can't access: protected
		//! test.f4(); // Can't access: package
	}
}

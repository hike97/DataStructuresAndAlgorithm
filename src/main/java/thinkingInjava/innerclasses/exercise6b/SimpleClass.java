package thinkingInjava.innerclasses.exercise6b;

import thinkingInjava.innerclasses.exercise6.SimpleInterface;

/**
 * @author hike97 2month
 * @create 2020-04-22 0:41
 * @desc
 **/
public class SimpleClass {
	protected class Inner implements SimpleInterface {
		// Force constructor to be public:
		public Inner() {}
		public void f() {}
	}
}

package thinkingInjava.innerclasses;

import thinkingInjava.innerclasses.exercise6.SimpleInterface;
import thinkingInjava.innerclasses.exercise6b.SimpleClass;

/**
 * @author hike97 2month
 * @create 2020-04-22 0:42
 * @desc 导出类可以访问基类中的protected 内部类的权限
 **/
public class E06_ProtectedInnerClass extends SimpleClass {
	public SimpleInterface get () {
		return new Inner ();
	}

	public static void main (String args[]) {
		new E06_ProtectedInnerClass ().get ().f ();
	}
}

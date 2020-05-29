package thinkingInjava.interfaces;

/**
 * @author hike97 2month
 * @create 2020-04-18 20:21
 * @desc
 **/
abstract class NoMethods {}
class Extended1 extends NoMethods {
	public void f() {
		System.out.println("Extended1.f");
	}
}
abstract class WithMethods {
	abstract public void f();
}

class Extended2 extends WithMethods {
	public void f() {
		System.out.println("Extended2.f");
	}
}
public class E04_AbstractBase {
	public static void test1(NoMethods nm) {
		// Must downcast to access f():
		((Extended1)nm).f();
	}
	public static void test2(WithMethods wm) {
		// No downcast necessary: 基类方法中存在方法声明 不需要向下转型
		wm.f();
	}
	public static void main(String args[]) {
		NoMethods nm = new Extended1();
		test1(nm);
		WithMethods wm = new Extended2();
		test2(wm);
	}
}
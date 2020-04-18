package thinkingInjava.reusing;

import static net.mindview.util.Print.print;

/**
 * @author hike97 2month
 * @create 2020-04-15 18:18
 * @desc
 **/
class WithFinals {
	private final void f() {
		print("WithFinals.f()");
	}
	private void g() {
		print("WithFinals.g()");
	}
}
class OverridingPrivateE20 extends WithFinals {
	private final void f() {
		print("OverridingPrivateE20.f()");
	}
	 private void g() {
		print("OverridingPrivateE20.g()");
	}
}
class OverridingPrivate2E20 extends OverridingPrivateE20 {
	public final void f() {
		print("OverridingPrivate2E20.f()");
	}
	 public void g() {
		print("OverridingPrivate2E20.g()");
	}
}
//事实上 并没没有方法重写 private 和 private final 是隐藏的
public class E20_OverrideAnnotation {
	public static void main(String[] args) {
		OverridingPrivate2E20 op2 = new OverridingPrivate2E20();
		op2.f();
		op2.g();
	}
} ///:~
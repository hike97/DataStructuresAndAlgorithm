package thinkingInjava.interfaces;

import static net.mindview.util.Print.print;

/**
 * @author hike97 2month
 * @create 2020-04-18 21:34
 * @desc
 **/
interface AnInterface {
	void f();
	void g();
	void h();
}
class ImplementInterface implements AnInterface {
	public void f() { print("ImplementInterface.f"); }
	public void g() { print("ImplementInterface.g"); }
	public void h() { print("ImplementInterface.h"); }
}
public class E05_ImplementInterface {
	public static void main(String args[]) {
		ImplementInterface imp = new ImplementInterface();
		imp.f();
		imp.g();
		imp.h();
	}
}
//证明接口中的方法都是public的
class E06_InterfacePublicMethods
		implements AnInterface {
	// Each of these produces a compile-time error message,
	// stating that you cannot reduce the access of the
	// base class public method in a derived class.
//	 void f() {}
//	 void g() {}
//	 void h() {}
	// Compiles OK:
	public void f() {}
	public void g() {}
	public void h() {}
	public static void main(String args[]) {}
}
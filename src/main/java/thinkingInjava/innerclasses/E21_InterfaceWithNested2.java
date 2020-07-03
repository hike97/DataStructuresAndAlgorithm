package thinkingInjava.innerclasses;

/**
 * @author hike97 2month
 * @create 2020-05-25 22:23
 * @desc
 **/
interface I {
	void f();
	void g();
	class Nested {
		static void call(I impl) {
			System.out.println("Calling I.f()");
			impl.f();
			System.out.println("Calling I.g()");
			impl.g();
		}
	}
}
public class E21_InterfaceWithNested2 {
	public static void main(String[] args) {
		I impl = new I() {
			public void f() {}
			public void g() {}
		};
		I.Nested.call(impl);
	}
}

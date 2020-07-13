package thinkingInjava.innerclasses;

/**
 * @author hike97 2month
 * @create 2020-05-25 22:19
 * @desc
 **/
interface WithNested {
	class Nested {
		int i;
		public Nested(int i) { this.i = i; }
		void f() { System.out.println("Nested.f"); }
	}
}
class B2 implements WithNested {}
public class E20_InterfaceWithNested {
	public static void main(String args[]) {
		B2 b = new B2();
		WithNested.Nested ne = new WithNested.Nested(5);
		ne.f();
	}
}
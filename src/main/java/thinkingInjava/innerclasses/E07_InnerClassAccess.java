package thinkingInjava.innerclasses;

/**
 * @author hike97 2month
 * @create 2020-04-22 0:44
 * @desc This exercise shows that inner classes have transparent access to their outer-
 * class objects, even private fields and methods.
 **/
public class E07_InnerClassAccess {
	private int i = 10;
	private void f() {
		System.out.println("E07_InnerClassAccess.f");
	}
	class Inner {
		void g() {
			i++;//内部类修改外部类的域
			f();//内部类调用外部类的方法
		}
	}
	public void h() {
		Inner in = new Inner();
		in.g();
		System.out.println("i = " + i);
	}
	public static void main(String args[]) {
		E07_InnerClassAccess ica = new E07_InnerClassAccess();
		ica.h();
	}
}

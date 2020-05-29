package thinkingInjava.innerclasses;

/**
 * @author hike97 2month
 * @create 2020-04-26 23:46
 * @desc
 **/
public class E12_AnonymousInnerClassAccess {
	private int i = 10;
	private void f() {
		System.out.println("E07_InnerClassAccess.f");
	}
	public void h() {
		new Object (){
			void g(){
				i++;//内部类修改外部类的域
				f();//内部类调用外部类的方法
			}
		}.g ();
		System.out.println("i = " + i);
	}
	public static void main(String args[]) {
		E07_InnerClassAccess ica = new E07_InnerClassAccess();
		ica.h();
	}
}

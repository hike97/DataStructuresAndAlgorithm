package thinkingInjava.reusing;

/**
 * @author hike97 2month
 * @create 2020-04-16 23:55
 * @desc
 **/
class WithFinalMethod {
	final void f() {}
}
public class E21_FinalMethod extends WithFinalMethod {
//	void f() {} 无法重写
	public static void main(String args[]) {}
}
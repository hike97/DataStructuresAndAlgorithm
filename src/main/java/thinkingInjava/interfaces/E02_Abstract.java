package thinkingInjava.interfaces;

/**
 * @author hike97 2month
 * @create 2020-04-18 20:12
 * @desc 没有任何抽象方法的抽象类无法实例化
 **/
abstract class NoAbstractMethods {
	void f() { System.out.println("f()"); }
}
public class E02_Abstract {
	public static void main(String args[]) {
//		new NoAbstractMethods();
	}
}

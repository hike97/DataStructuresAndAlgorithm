package thinkingInjava.interfaces;

/**
 * @author hike97 2month
 * @create 2020-04-18 20:16
 * @desc
 **/
abstract class BaseWithPrint {
	public BaseWithPrint() { print(); }
	public abstract void print();
}
class DerivedWithPrint extends BaseWithPrint {
	int i = 47;
	public void print() {
		System.out.println("i = " + i);
	}
}
public class E03_Initialization {
	public static void main(String args[]) {
		DerivedWithPrint dp = new DerivedWithPrint();
		dp.print();
	}
}

package thinkingInjava.initializationAndCleanup;

/**
 * @author hike97 2month
 * @create 2020-04-06 21:01
 * @desc 可变参数
 **/
class A {}
public class VarArgs {
	static void printArray(Object[] args) {
		for (Object obj : args) {
			System.out.println (obj);
		}
		System.out.println ();
	}
	static void printArraySE5(Object... args) {
		for (Object obj : args) {
			System.out.println (obj);
		}
		System.out.println ();
	}

	public static void main (String[] args) {
		printArray (new Object[]{new Integer (47),new Float (3.14),new Double (11.11)});
		printArray (new Object[]{"one","two","three"});
		printArray (new Object[]{new A(),new A(),new A()});
		printArraySE5("one","two","three");
		printArraySE5 ();
	}
}

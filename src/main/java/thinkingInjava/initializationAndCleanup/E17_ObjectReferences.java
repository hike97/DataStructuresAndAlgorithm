package thinkingInjava.initializationAndCleanup;


/**
 * @author hike97 2month
 * @create 2020-04-06 20:53
 * @desc
 **/
public class E17_ObjectReferences {
	// You can define the array as a field in the class:
	Test_[] array1 = new Test_[5];
	public static void main(String args[]) {
		// Or as a temporary inside main:
		Test_[] array2 = new Test_[5];
		for(int i = 0; i < array2.length; i++)
			array2[i] = new Test_(Integer.toString(i));
	}
}
class Test_ {
	Test_(String s) {
		System.out.println("String constructor; s = " + s);
	}
}

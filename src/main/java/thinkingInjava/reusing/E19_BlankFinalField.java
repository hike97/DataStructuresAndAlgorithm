package thinkingInjava.reusing;

/**
 * @author hike97 2month
 * @create 2020-04-15 17:52
 * @desc 空白final
 **/
class WithBlankFinalField {
	//final变量只能在使用前被初始化 在构造器中 并且一单初始化就无法改变
	public final Integer i;
	// Without this constructor, you'll get a compiler error:
	// "variable i might not have been initialized"
	public WithBlankFinalField(int ii) {
		i = ii;
	}
	public Integer geti() {
		// This won't compile. The error is:
		// "cannot assign a value to final variable i"
		// if(i == null)
		// i = new Integer(47);
		return i;
	}
}
public class E19_BlankFinalField {
	public static void main(String args[]) {
		WithBlankFinalField wbff = new WithBlankFinalField(10);
//		wbff.i=50;
		System.out.println(wbff.geti());
	}
} /* Output:
10
*///:~

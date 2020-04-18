package thinkingInjava.reusing;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hike97 2month
 * @create 2020-04-15 14:49
 * @desc final shujubijiao
 **/
class Value {
	int i;

	public Value (int i) {
		this.i = i;
	}
}
public class FinalData {
	private static Random r = new Random (47);
	private String id;

	public FinalData (String id) {
		this.id = id;
	}

	private final int ValueOne = 9;
	private static final int VALUE_TWO = 9;
	public static final int VALUE_THREE = 39;

	private final  int i4 =  r.nextInt (20); //final 运行时初始化
	static final int INT_5 = r.nextInt (20); //static final 装载时初始化

	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value (33);

	private final int[] a = {1,2,3,4,5};

	@Override
	public String toString () {
		return "FinalData{" +
				"id='" + id + '\'' +
				", i4=" + i4 +
				", INT_5=" + INT_5 +
				'}';
	}

	public static void main (String[] args) {
		FinalData fd1 = new FinalData ("fd1");
//		fd1.ValueOne++;
//		fd1.ValueOne=10; 编译失败
		fd1.v2.i++;
		fd1.v1 = new Value (9);
		for (int i = 0; i < fd1.a.length; i++) {
			fd1.a[i]++;
		}
//		fd1.v2 = new Value (0);
//		fd1.VAL_3 = new Value (1); change reference
//		fd1.a = new int[3];
		System.out.println (fd1);
		System.out.println ("Creating new FinalData");
		FinalData fd2 = new FinalData ("fd2");
		System.out.println (fd1);
		System.out.println (fd2);
	}
}

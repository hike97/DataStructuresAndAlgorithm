package thinkingInjava.polymophism;

/**
 * @author hike97 2month
 * @create 2020-04-18 19:56
 * @desc 运行时类型识别
 **/
public class E17_RTTI {
	public static void main(String[] args) {
		Cycle[] cycles = new Cycle[]{ new Unicycle(),
				new Bicycle(), new Tricycle() };
		// Compile time: method not found in Cycle:
		// cycles[0].balance();
		// cycles[1].balance();
		// cycles[2].balance();
		((Unicycle)cycles[0]).balance(); // Downcast/RTTI
		((Bicycle)cycles[1]).balance(); // Downcast/RTTI
		((Unicycle)cycles[2]).balance(); // Exception thrown
	}
}

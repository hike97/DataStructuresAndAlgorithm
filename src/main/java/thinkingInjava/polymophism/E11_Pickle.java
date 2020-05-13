package thinkingInjava.polymophism;

import static net.mindview.util.Print.print;

/**
 * @author hike97 2month
 * @create 2020-04-18 17:38
 * @desc 构造器调用顺序
 * 1.基类
 * 2.按顺序
 * 3.最后自己
 **/
class Pickle {
	Pickle() { print("Pickle()"); }
}
class Bread {
	Bread() { print("Bread()"); }
}
class Cheese {
	Cheese() { print("Cheese()"); }
}
class Lettuce {
	Lettuce() { print("Lettuce()"); }
}
class PortableLunch extends Lunch{
	PortableLunch() { print("PortableLunch()"); }
}
class  Lunch extends Meal{
	Lunch() { print("Lunch()"); }
}
class Meal {
	Meal() { print("Meal()"); }
}
class Sandwich2 extends PortableLunch {
	Bread b = new Bread();
	Cheese c = new Cheese();
	Lettuce l = new Lettuce();
	Pickle p = new Pickle();
	Sandwich2() { print("Sandwich()"); }
}
public class E11_Pickle {
	public static void main(String args[]) {
		new Sandwich2();
	}
}
/*output:
Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Pickle()
Sandwich()
 *///:~

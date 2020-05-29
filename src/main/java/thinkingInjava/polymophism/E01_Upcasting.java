package thinkingInjava.polymophism;

/**
 * @author hike97 2month
 * @create 2020-04-18 11:23
 * @desc 多态向上转型
 **/
public class E01_Upcasting {
	public static void ride(Cycle c) {}
	public static void main(String[] args) {
		ride(new Cycle()); // No upcasting
		ride(new Unicycle()); // Upcast
		ride(new Bicycle()); // Upcast
		ride(new Tricycle()); // Upcast
	}
} ///:~
//: polymorphism/cycle/Cycle.java
class Cycle {
} ///:~
//: polymorphism/cycle/Unicycle.java
class Unicycle extends Cycle {
	void balance(){}
} ///:~
//: polymorphism/cycle/Bicycle.java
class Bicycle extends Cycle {
	void balance(){}
} ///:~
//: polymorphism/cycle/Tricycle.java
class Tricycle extends Cycle {
} ///:~

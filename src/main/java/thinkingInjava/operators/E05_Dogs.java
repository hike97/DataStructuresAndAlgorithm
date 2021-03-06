package thinkingInjava.operators;

import static net.mindview.util.Print.print;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-03-09 23:36
 * @desc
 **/
public class E05_Dogs {

	static void compare(Dog dog1, Dog dog2) {
		print("== on top references: " + (dog1 == dog2));
		print(
				"equals() on top references: " + dog1.equals(dog2)
		);
		print("== on names: " + (dog1.name == dog2.name));
		print(
				"equals() on names: " + dog1.name.equals(dog2.name)
		);
		print("== on says: " + (dog1.says == dog2.says));
		print(
				"equals() on says: " + dog1.says.equals(dog2.says)
		);
	}
	public static void main (String[] args) {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Dog dog3 = dog1;
		dog1.name = "spot"; dog1.says = "ruff!";
		dog2.name = "scruffy"; dog2.says = "wurf!";
		System.out.println(dog1.name + " says " + dog1.says);
		System.out.println(dog2.name + " says " + dog2.says);
		compare (dog1,dog3);
		System.out.println (dog1 == dog3);
	}
}
class Dog {
	String name;
	String says;
}

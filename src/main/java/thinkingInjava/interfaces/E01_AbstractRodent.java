package thinkingInjava.interfaces;

import static net.mindview.util.Print.print;

/**
 * @author hike97 2month
 * @create 2020-04-18 14:41
 * @desc
 **/
abstract class Rodent {
	abstract void hop ();
	abstract void scurry();
	abstract void reproduce();
	public abstract String toString ();
}

class Mouse extends Rodent {
	public void hop() { print("Mouse hopping"); }
	public void scurry() { print("Mouse scurrying"); }
	public void reproduce() { print("Making more Mice"); }
	public String toString() { return "Mouse"; }
}

class Gerbil extends Rodent {
	public void hop() { print("Gerbil hopping"); }
	public void scurry() { print("Gerbil scurrying"); }
	public void reproduce() { print("Making more Gerbils"); }
	public String toString() { return "Gerbil"; }
}

class Hamster extends Rodent {
	public void hop() { print("Hamster hopping"); }
	public void scurry() { print("Hamster scurrying"); }
	public void reproduce() { print("Making more Hamsters"); }
	public String toString() { return "Hamster"; }
}

public class E01_AbstractRodent {
	public static void main(String args[]) {
		Rodent[] rodents = {
				new Mouse (),
				new Gerbil (),
				new Hamster (),
		};
		for(Rodent r : rodents) {
			r.hop();
			r.scurry();
			r.reproduce();
			print(r);
		}
	}
}

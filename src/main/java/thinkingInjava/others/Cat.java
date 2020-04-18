package thinkingInjava.others;

/**
 * @author hike97 2month
 * @create 2020-04-17 0:25
 * @desc
 **/
class Animal {
	int printInit(String s){
		System.out.println (s);
		return 11;
	}
}
public class Cat extends  Animal{
	private int k = printInit("hehehe");

	public Cat () {
		System.out.println ("constructor");
	}

	public static void main (String[] args) {
		Cat cat = new Cat ();
	}
}

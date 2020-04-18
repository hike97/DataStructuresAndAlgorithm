package thinkingInjava.reusing;

import static net.mindview.util.Print.print;

/**
 * @author hike97 2month
 * @create 2020-04-17 0:29
 * @desc
 **/
class Insect{
	private int i = 9;
	int j;

	public Insect () {
		System.out.println ("i= " + i + "j= " + j);
		j = 39;
	}
	private static int x1 = printInit ("x1 run");

	static int printInit(String s){
		System.out.println (s);
		return 47;
	}
}
public class Beetle extends Insect {
	private int k = printInit ("k run");

	public Beetle () {
		System.out.println ("k= " + k + "j= " + j);
	}
	private static int x2 = printInit ("x2 run");

	public static void main (String[] args) {
		System.out.println ("BETLE");
		new Beetle ();
	}
}

class JapaneseBeetle extends Beetle {
	int m = printInit("JapaneseBeetle.m initialized");
	JapaneseBeetle() {
		print("m = " + m);
		print("j = " + j);
	}
	static int x3 =
			printInit("static JapaneseBeetle.x3 initialized");

	public static void main (String[] args) {
		new JapaneseBeetle ();
	}
}
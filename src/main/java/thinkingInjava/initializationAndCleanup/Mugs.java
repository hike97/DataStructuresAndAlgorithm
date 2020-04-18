package thinkingInjava.initializationAndCleanup;


import static net.mindview.util.Print.print;

/**
 * @author hike97 2month
 * @create 2020-04-06 17:11
 * @desc 非静态实例初始化
 **/
public class Mugs {
	Mug mug1;
	Mug mug2;
	{
		mug1 = new Mug (1);
		mug2 = new Mug (2);
		System.out.println ("mug1 & mug2 initialized");
	}

	public Mugs () {
		System.out.println ("Mugs ()");
	}
	public Mugs (int i) {
		System.out.println ("Mugs (int)");
	}

	public static void main (String[] args) {
		System.out.println ("inside main()");
		new Mugs ();
		print("new Mugs() completed");
		new Mugs (1);
		print("new Mugs(1) completed");

	}

}
class Mug {
	public Mug (int maker) {
		System.out.println ("Mug(" + maker + ")");
	}
	void f(int maker){
		System.out.println ("f(" + maker + ")");
	}
}

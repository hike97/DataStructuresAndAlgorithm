package thinkingInjava.initializationAndCleanup;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-04-06 17:05
 * @desc
 **/
public class E14_StaticStringInitialization {
	static String s1 = "Initialized at definition";
	static String s2;
	static { s2 = "Initialized in static block"; }
	public static void main(String args[]) {
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
	}
}

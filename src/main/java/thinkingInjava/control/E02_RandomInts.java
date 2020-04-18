package thinkingInjava.control;


import java.util.Random;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-03-10 15:16
 * @desc
 **/
public class E02_RandomInts {

	static Random r = new Random (47);

	public static  void compareRand(){
		int a = r.nextInt();
		int b = r.nextInt();
		System.out.println("a = " + a + ", b = " + b);
		if(a < b)
			System.out.println("a < b");
		else if(a > b)
			System.out.println("a > b");
		else
			System.out.println("a = b");
	}
	public static void main (String[] args) {
//		for (int i = 0; i < 25; i++) {
//			compareRand ();
//		}
		//use while
		while (true) compareRand ();
	}
}

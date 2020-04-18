package thinkingInjava.initializationAndCleanup;


import static net.mindview.util.Print.print;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-03-22 21:33
 * @desc
 **/
public class Flower {
	int petalCount = 0;
	String s = "initial Value";

	Flower (int pentals) {
		this.petalCount = pentals; //pentals 花瓣
		print("Constructot /w int arg only , petalCount = "+ pentals);
	}

	Flower (String ss) {
		this.s = ss;
		print("Constructot /w string arg only , s = "+ ss);
	}

	public Flower ( String s,int petalCount) {
		this(petalCount);
		this.s = s;
		print("String & int args");
	}

	public Flower () {
		this("hi",47);
		print ("default constructor (no args)");
	}

	void printPentalCount() {
		print ("petalCount = "+ petalCount + "s = "+s);
	}

	public static void main (String[] args) {
		Flower x = new Flower ();
		x.printPentalCount ();
	}
}

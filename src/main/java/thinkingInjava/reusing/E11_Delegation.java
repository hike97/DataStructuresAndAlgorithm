package thinkingInjava.reusing;

import static net.mindview.util.Print.print;

/**
 * @author hike97 2month
 * @create 2020-04-13 0:57
 * @desc 代理
 **/
class DetergentDelegation {
	private Cleanser cleanser = new Cleanser();
	// Delegated methods:
	public void append(String a) { cleanser.append(a); }
	public void dilute() { cleanser.dilute(); }
	public void apply() { cleanser.apply(); }
	public String toString() { return cleanser.toString(); }
	public void scrub() {
		append(" DetergentDelegation.scrub()");
		cleanser.scrub();
	}
	public void foam() { append(" foam()"); }
	public static void main(String[] args) {
		DetergentDelegation x = new DetergentDelegation();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		print(x);
		print("Testing base class:");
		Cleanser.main(args);
	}


}
public class E11_Delegation {
	public static void main (String[] args) {
		DetergentDelegation.main (args);
	}
}
class Cleanser {
	String s = "Cleanser ";
	void append(String a){s += a;}
	void dilute(){append (" dilute()");}
	void apply(){append (" apply()");}
	void scrub(){append (" scrub()");}

	@Override
	public String toString () {
		return s;
	}

	public static void main (String[] args) {
		Cleanser x = new Cleanser ();
		x.dilute ();x.apply ();x.scrub ();
		print (x);
	}
}

package thinkingInjava.initializationAndCleanup;

/**
 * @author hike97 2month
 * @create 2020-04-07 18:45
 * @desc
 **/
class Tank {
	static int counter;
	int id = counter++;
	boolean full;
	public Tank() {
		System.out.println ("Tank" + id + "created");
		full = true;
	}
	public void empty(){
		full = false;
	}

	@Override
	protected void finalize () throws Throwable {
		if (full)
			System.out.println ("Error: tank " + id + "must be empty at cleanup");
		else
			System.out.println ("Tank" + id + "cleaned up OK");
	}

	public  String toString(){
		return "Tank" +id;
	}
}
public class E12_TankWithTerminationCondition {
	public static void main (String[] args) {
		new Tank ().empty ();
		new Tank ();
		System.gc ();
		System.runFinalization ();
	}
}

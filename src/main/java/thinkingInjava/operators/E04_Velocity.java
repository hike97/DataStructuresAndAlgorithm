package thinkingInjava.operators;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-03-09 23:22
 * @desc
 **/
public class E04_Velocity {
	public static void main(String[] args) {
		if(args.length < 2) {
			System.err.println(
					"Usage: java E04_Velocity distance time");
			System.exit(1);
		}
		float distance = Float.parseFloat(args[0]);
		float time = Float.parseFloat(args[1]);
		System.out.print("Velocity = ");
		System.out.print(distance / time);
		// Change the next line if you want to use a different
		// unit for 'distance'
		System.out.println(" m/s");
	}
}

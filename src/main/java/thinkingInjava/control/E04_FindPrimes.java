package thinkingInjava.control;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-03-10 15:43
 * @desc
 **/
public class E04_FindPrimes {
	public static void main (String[] args) {
		int max = 100;
		// Get the max value from the command line,
		// if the argument has been provided:
		//如果传参运行 就会从这个参数开始 如果不传参 就会从1 开始
		if(args.length != 0)
			max = Integer.parseInt(args[0]);
		for(int i = 1; i < max; i++) {
			boolean prime = true;
			for(int j = 2; j < i; j++)
				if(i % j == 0)
					prime = false;
			if(prime)
				System.out.print(i + " ");
		}
	}
}

package thinkingInjava.control;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static net.mindview.util.Print.printnb;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-03-10 23:01
 * @desc
 **/
public class E04_FindPrimes2 {
	public static void main(String[] args) {
		int max = 100;
		// Get the max value from the command line,
		// if the argument has been provided:
		if(args.length != 0)
			max = Integer.parseInt(args[0]);
		boolean[] sieve = new boolean[max + 1];
		int limit = (int)floor(sqrt(max));
		printnb(1 + " ");
		if(max > 1)
			printnb(2 + " ");
		// Detect prime numbers
		for(int i = 3; i <= limit; i += 2)
			if(!sieve[i])
				for(int j = 2 * i; j <= max; j += i)
					sieve[j] = true;
		// Print prime numbers
		for(int i = 3; i <= max; i += 2)
			if(!sieve[i])
				printnb(i + " ");
	}
}
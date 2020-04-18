package thinkingInjava.initializationAndCleanup;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author hike97 2month
 * @create 2020-04-06 21:28
 * @desc 枚举类的常用方法
 **/
enum PaperCurrencyTypes {
	ONE, TWO, FIVE, TEN, TWENTY, FIFTY
}
public class E21_PaperCurrencyTypesEnum {
	static void describe(PaperCurrencyTypes pct) {
		printnb(pct + " has a portrait of ");
		switch(pct) {
			case ONE: print("George Washington");
				break;
			case TWO: print("Thomas Jefferson");
				break;
			case FIVE: print("Abraham Lincoln");
				break;
			case TEN: print("Alexander Hamilton");
				break;
			case TWENTY: print("Andrew Jackson");
				break;
			case FIFTY: print("U.S. Grant");
				break;
		}
	}
	public static void main(String args[]) {
		for(PaperCurrencyTypes s : PaperCurrencyTypes.values()){
			System.out.println(s + ", ordinal " + s.ordinal());
			describe (s);
		}
	}
}

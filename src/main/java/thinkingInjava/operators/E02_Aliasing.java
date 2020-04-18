package thinkingInjava.operators;

import static net.mindview.util.Print.print;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-03-09 23:12
 * @desc 类别名机制
 **/
public class E02_Aliasing {
	public static void main (String[] args) {
		Integral n1 = new Integral();
		Integral n2 = new Integral();
		n1.f = 9f;
		n2.f = 47f;
		print("1: n1.f: " + n1.f + ", n2.f: " + n2.f);
		n1 = n2;
		print("2: n1.f: " + n1.f + ", n2.f: " + n2.f);
		n1.f = 27f;
		print("3: n1.f: " + n1.f + ", n2.f: " + n2.f);
	}
}
class Integral {
	float f;
}

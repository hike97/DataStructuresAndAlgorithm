package thinkingInjava.operators;

import thinkingInjava.operators.Integral;

import static net.mindview.util.Print.print;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-03-09 23:16
 * @desc 方法别名机制
 **/
public class E02_Aliasing2 {
	static void  f(Integral y){
		y.f = 1.0f;
	}

	public static void main (String[] args) {
		Integral x = new Integral ();
		x.f = 2.0f;
		print("1: x.f: " + x.f);
		f(x);
		print("2: x.f: " + x.f);
	}
}

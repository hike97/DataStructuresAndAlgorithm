package thinkingInjava.initializationAndCleanup;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-04-06 16:31
 * @desc 显式的静态初始化
 **/
public class ExpliciStatic {
	public static void main (String[] args) {
		System.out.println ("Inside main");
//		Cups.cup1.f (99);//首次访问属于那个类的静态数据成员
	}
	static Cups cups1 = new Cups ();
	static Cups cups2 = new Cups ();//静态代码块只初始化一次
}
class Cup {
	public Cup (int maker) {
		System.out.println ("Cup(" + maker + ")");
	}
	void f(int maker){
		System.out.println ("f(" + maker + ")");
	}
}
class Cups{
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup (1);
		cup2 = new Cup (2);
	}
	Cups(){
		System.out.println ("Cpus()");
	}
}

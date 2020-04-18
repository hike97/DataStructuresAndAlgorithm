package thinkingInjava.others;

/**
 * @author hike97 2month
 * @create 2020-04-08 22:19
 * @desc private控制创建对象
 **/
public class IncCream {
	public static void main (String[] args) {
//		Sundae sundae = new Sundae ();
		Sundae sundae = Sundae.makeASundae ();
	}
}
class Sundae {
	private Sundae(){}
	static Sundae makeASundae(){
		return new Sundae ();
	}
}
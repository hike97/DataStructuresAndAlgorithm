package thinkingInjava.access;

/**
 * @author hike97 2month
 * @create 2020-04-12 19:59
 * @desc
 **/
public class E08_ConnectionManager {
	public static void main(String args[]) {
		Connection c = ConnectionManager.getConnection();
		while(c != null) {
			System.out.println(c);
			c.doSomething();
			c = ConnectionManager.getConnection();
		}
	}

}

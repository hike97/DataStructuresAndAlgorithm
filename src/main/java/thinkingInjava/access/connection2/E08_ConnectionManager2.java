package thinkingInjava.access.connection2;



/**
 * @author hike97 2month
 * @create 2020-04-12 20:23
 * @desc
 **/
public class E08_ConnectionManager2 {
	public static void main(String args[]) {
		Connection[] ca = new Connection[10];
		// Use up all the connections 默认生产10个
		for(int i = 0; i < 10; i++)
			ca[i] = ConnectionManager.getConnection();
		// Should produce "null" since there are no
		// more connections: 第十一次使用 会返回null
		System.out.println(ConnectionManager.getConnection());
		// Return connections, then get them out:
		for(int i = 0; i < 5; i++) {
			//获取回来
			ca[i].checkIn();
			Connection c = ConnectionManager.getConnection();
			System.out.println(c);
			c.doSomething();
			c.checkIn();
		}
	}
}

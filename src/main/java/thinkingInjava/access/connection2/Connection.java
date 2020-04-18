package thinkingInjava.access.connection2;


/**
 * @author hike97 2month
 * @create 2020-04-12 20:24
 * @desc
 **/
public class Connection {
	private static int counter = 0;
	private int id = counter++;
	Connection() {}
	public String toString() {
		return "Connection " + id;
	}
	public void doSomething() {}
	public void checkIn() {
		ConnectionManager.checkIn(this);
	}
}

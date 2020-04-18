package thinkingInjava.initializationAndCleanup;

/**
 * @author hike97 2month
 * @create 2020-04-06 21:58
 * @desc finalize的用法
 **/
class Book {
	boolean checkedOut;

	public Book (boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	void  checkIn() {
		checkedOut = false;
	}

	@Override
	protected void finalize () throws Throwable {
		if (checkedOut)
			System.out.println ("Error:checked out");
	}
}
public class TerminationCondition {
	public static void main (String[] args) {
		Book novel = new Book (true);
		//Proper cleanup
		novel.checkIn ();
		//Drop the reference forget to clean up
		new Book (true);
		//强制 garbage collection & finalization;
		System.gc ();
	}
}

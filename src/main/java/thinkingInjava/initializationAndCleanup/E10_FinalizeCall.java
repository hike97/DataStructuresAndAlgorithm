package thinkingInjava.initializationAndCleanup;

/**
 * @author hike97 2month
 * @create 2020-04-06 22:27
 * @desc finalize的行为
 **/
public class E10_FinalizeCall {
	protected void finalize() {
		System.out.println("finalize() called");
	}
	//You probably won’t see the finalizer called because the program doesn’t usually
	//generate enough garbage for the collector to run.
	public static void main(String args[]) {
		new E10_FinalizeCall();
		//finalize方法 总被调用
		System.gc();
		System.runFinalization();
	}
}

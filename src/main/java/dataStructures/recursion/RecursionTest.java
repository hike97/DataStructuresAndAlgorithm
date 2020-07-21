package dataStructures.recursion;

/**
 * @Author hike97
 * @Description 递归测试
 * @create 2020-07-16 16:39
 * @Modified By:
 **/
public class RecursionTest {
	public static void main (String[] args) {
		test (4);

	}
	//打印问题
	public static void test(int n){
		if (n>2){
			test (n-1);
		}else{
			System.out.println ("n="+n);
		}
 	}
 	//阶乘问题
	public static int factorial(int n) {
		if (n==1){
			return 1;
		}else {
			return factorial (n-1)*n;
		}
	}
}

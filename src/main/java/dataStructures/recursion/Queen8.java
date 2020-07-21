package dataStructures.recursion;

/**
 * @Author hike97
 * @Description
 * @create 2020-07-20 14:29
 * @Modified By:
 **/
public class Queen8 {
	//定义一个max表示共有多少个皇后
	int max = 8;
	//定义数组array
	int [] array = new int[max];
	static int count;
	static int judgeCount;
	public static void main (String[] args) {
		Queen8 queen8 = new Queen8 ();
		queen8.check (0);
		System.out.printf ("一共有：%d解法,判断：%d次", count,judgeCount);
	}
	//编写一个方法，放置第n个皇后
	private void check(int n){
		if (n==max){
			print();
			return;
		}
		//依次放入皇后，并判断是否冲突
		for (int i = 0; i < max; i++) {
			//先把当前这个皇后n,放到该行的第1列
			array[n] = i;
			//判断当前放置第n个皇后到i列时，是否冲突
			if (judge (n)){
				//不冲突继续放
				check (n+1);
			}
			//如果冲突，i++ 放置本行 的 后移的一个位置。
		}
	}

	/**
	 *
	 * @param n 表示第n个皇后
	 * @return
	 */
	private boolean judge(int n){
		judgeCount++;
		for (int i = 0; i < n; i++) {
			//判断列和斜线的是否在同一条直线 不用判断行 因为 下标即表示数组下标 又表示第几行
			//Math.abs (n-i) == Math.abs (array[n] -array[i]) 行相减等于坐标相减
			if (array[i] == array[n]||Math.abs (n-i) == Math.abs (array[n] -array[i])){
				return false;
			}
		}
		return true;
	}

	/**
	 * 输出数组
	 */
	private void print(){
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print (array[i]+" ");
		}
		System.out.println ();
	}

}

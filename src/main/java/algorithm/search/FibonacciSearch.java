package algorithm.search;

import java.util.Arrays;

/**
 * @Author hike97
 * @Description 斐波那契查找
 * @create 2020-07-30 17:25
 * @Modified By:
 **/
public class FibonacciSearch {
	public static int maxSize = 20;
    //	由斐波那契数列可知，
	//	F(k)=F(k-1)+F(k-2),
	//	那F(k)-1=(F(k-1)-1)+(F(k-2)-1)+1,
	//	所以数组长度只要满足 F(k)-1，
	//	就可以将数组分为F(k-1)-1和F(k-2)-1左右两部分，
	//	其中mid=low+F(k-1)-1
	public static void main (String[] args) {
		int[] arr = {1,8,10,70,89,1000};
		int[] fibArr = fib ();
		//System.out.println (Arrays.toString (fibArr));
		int index = fibSearch (arr, 10);
		System.out.println (index);
	}

	public static int[] fib(){
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f;
	}

	public static int fibSearch(int[] a ,int key){
		/**
		 * 初始化参数
		 */
		int low = 0;
		int high = a.length - 1;//5 f4-1
		int k = 0;//斐波那契下标
		int mid = 0;
		int[] f = fib ();
		//[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597]
		//将数组长度与f[k]-1 持平
		while (high>f[k]-1){
			k++;
		}
//		//补全数组元素个数为 f[k]-1 arrays.copy 第二个参数为数组长度
//		int[] temp = Arrays.copyOf (a, f[k]);
//		//将数组最后的数填充到新数组
//		for (int i = high+1; i < temp.length; i++) {
//			temp[i] = a[high];
//		}
//		System.out.println ("补充后的数组:");
		int[] temp = a;
		System.out.println (Arrays.toString (temp));
		while (low<high){
			mid = low + f[k-1]-1;//初始位置+斐波那契分割点
			if (key<temp[mid]){
				high = mid -1;
				//下一次循环 f[k-1-1]-1
				k--;
			}else if (key > temp[mid]){
				low = mid+1;
				//下一次循环 f[k-1-2]-1
				k-=2;
			}else {
				//返回小的
				if (mid<=high){
					return mid;
				}else {
					return high;
				}
			}
		}
		return  -1;
	}

}

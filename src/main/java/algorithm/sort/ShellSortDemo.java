package algorithm.sort;

import java.util.Arrays;

import static algorithm.sort.BubbleSortDemo.swap;

/**
 * @Author hike97
 * @Description
 * @create 2020-08-18 15:47
 * @Modified By:
 **/
public class ShellSortDemo {
	public static void main (String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		//希尔排序演变
		System.out.println ("SHELL START");
		//round 1 将len个数据分成 len/2组
		int len = arr.length;
		for (int i = len/2; i < len; i++) {
			for (int j = i-len/2; j >=0; j-=5) {
				if (arr[j]>arr[j+5]){
					swap(arr,j,j+5);
				}
			}
		}
		System.out.println("希尔排序1轮后=" + Arrays.toString(arr));

		for (int i = len/2/2; i < len; i++) {
			for (int j = i-len/2/2; j >=0; j-=2) {
				if (arr[j]>arr[j+2]){
					swap(arr,j,j+2);
				}
			}
		}
		System.out.println("希尔排序2轮后=" + Arrays.toString(arr));

		for (int i = len/2/2/2; i < len; i++) {
			for (int j = i-len/2/2/2; j >=0; j-=1) {
				if (arr[j]>arr[j+1]){
					swap(arr,j,j+1);
				}
			}
		}
		System.out.println("希尔排序3轮后=" + Arrays.toString(arr));
		System.out.println ("SHELL END");
	}

	public static  void ShellSort(int []arr){
		//计算间隔
		for (int gap = arr.length/2; gap >0 ; gap/=2) {

		}
	}
}

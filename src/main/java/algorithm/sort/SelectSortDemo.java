package algorithm.sort;

import java.util.Arrays;

/**
 * @Author hike97
 * @Description 选择排序
 * @create 2020-08-17 15:34
 * @Modified By:
 **/
public class SelectSortDemo {
	public static void main (String[] args) {
		System.out.println ("选择排序演变~~~~~~~~~~~START");
		int [] arr = {101, 34, 119, 1};
//		//第1轮
//		int minIndex = 0;
//		int min = arr[0];
//		for(int j = 0 + 1; j < arr.length; j++) {
//			if (min > arr[j]) { //说明假定的最小值，并不是最小
//				min = arr[j]; //重置min
//				minIndex = j; //重置minIndex
//			}
//		}
//
//
//		//将最小值，放在arr[0], 即交换
//		if(minIndex != 0) {
//			arr[minIndex] = arr[0];
//			arr[0] = min;
//		}
//
//		System.out.println("第1轮后~~");
//		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
//
//
//		//第2轮
//		minIndex = 1;
//		min = arr[1];
//		for (int j = 1 + 1; j < arr.length; j++) {
//			if (min > arr[j]) { // 说明假定的最小值，并不是最小
//				min = arr[j]; // 重置min
//				minIndex = j; // 重置minIndex
//			}
//		}
//
//		// 将最小值，放在arr[0], 即交换
//		if(minIndex != 1) {
//			arr[minIndex] = arr[1];
//			arr[1] = min;
//		}
//
//		System.out.println("第2轮后~~");
//		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
//
//		//第3轮
//		minIndex = 2;
//		min = arr[2];
//		for (int j = 2 + 1; j < arr.length; j++) {
//			if (min > arr[j]) { // 说明假定的最小值，并不是最小
//				min = arr[j]; // 重置min
//				minIndex = j; // 重置minIndex
//			}
//		}
//
//		// 将最小值，放在arr[0], 即交换
//		if (minIndex != 2) {
//			arr[minIndex] = arr[2];
//			arr[2] = min;
//		}
//
//		System.out.println("第3轮后~~");
//		System.out.println(Arrays.toString(arr));// 1, 34, 101, 119
//		System.out.println ("选择排序演变~~~~~~~~~~~END");
		selectSort (arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 选择排序
	 * @param arr
	 */
	public static void selectSort(int [] arr){
		//外层循环控制次数一共循环arr.lengh-1次
		for (int i = 0; i < arr.length-1; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if (min>arr[j]){
					min = arr[j];
					minIndex = j;
				}
			}
			//找出最小的值 和原来的值进行交换
			if (minIndex!=i){
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}

	}
}

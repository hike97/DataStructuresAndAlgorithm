package algorithm.sort;

import java.util.Arrays;

/**
 * @Author hike97
 * @Description 冒泡排序
 * @create 2020-08-17 14:42
 * @Modified By:
 **/
public class BubbleSortDemo {
	public static void main (String[] args) {

		int arr[] = {1,5,3,-2,10};
		int temp ;
		System.out.println ("冒泡排序演变~~~~~~~~~~~~START");
		for (int j = 0; j < arr.length - 1 - 0 ; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		System.out.println("第一趟排序后的数组");
		System.out.println(Arrays.toString(arr));
		// 第二趟排序，就是将第二大的数排在倒数第二位

		for (int j = 0; j < arr.length - 1 - 1 ; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("第二趟排序后的数组");
		System.out.println(Arrays.toString(arr));


		// 第三趟排序，就是将第三大的数排在倒数第三位

		for (int j = 0; j < arr.length - 1 - 2; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("第三趟排序后的数组");
		System.out.println(Arrays.toString(arr));

		// 第四趟排序，就是将第4大的数排在倒数第4位

		for (int j = 0; j < arr.length - 1 - 3; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("第四趟排序后的数组");
		System.out.println(Arrays.toString(arr));
		System.out.println ("冒泡排序演变~~~~~~~~~~~~END");
//		int arr[] = {1, 3, 5, 7, 9};
//		bubbleSort (arr);
		//		System.out.println (Arrays.toString (arr));
	}

	public static void bubbleSort (int arr[]) {
		boolean flag = true;
		for (int i = 0; i < arr.length - 1 && flag; i++) {
			//是否进行下一次冒泡的标记 如果循环一圈没发现前一个大于后一个的情况 flag 为false 说明数组是有序的无需进行下几次冒泡。
			flag = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					swap (arr, j, j + 1);
				}
			}
			System.out.println ("第" + (i + 1) + "次循环");
			System.out.println (Arrays.toString (arr));
		}

	}

	//替换操作
	public static void swap (int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

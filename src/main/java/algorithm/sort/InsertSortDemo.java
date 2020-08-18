package algorithm.sort;

import java.util.Arrays;

/**
 * @Author hike97
 * @Description 插入排序
 * @create 2020-08-17 18:47
 * @Modified By:
 **/
public class InsertSortDemo {
	public static void main (String[] args) {
		int[] arr = {101, 34, 119, 1, -1, 89};
		int insertVal = arr[1];
		int insertIndex = 1-1;
		//待插入数的下标 插入数的前一个数开始比较 如果小于就让数据后移
		while (insertIndex>=0&&insertVal<arr[insertIndex]){
			arr[insertIndex+1] = arr[insertIndex];
			insertIndex--;
		}
		arr[insertIndex+1] = insertVal;
		System.out.println("第1轮插入");
		System.out.println(Arrays.toString(arr));

	    insertVal = arr[2];
	    insertIndex = 2-1;
		//待插入数的下标 插入数的前一个数开始比较 如果小于就让数据后移
		while (insertIndex>=0&&insertVal<arr[insertIndex]){
			arr[insertIndex+1] = arr[insertIndex];
			insertIndex--;
		}
		arr[insertIndex+1] = insertVal;
		System.out.println("第2轮插入");
		System.out.println(Arrays.toString(arr));

		insertVal = arr[3];
		insertIndex = 3-1;
		//待插入数的下标 插入数的前一个数开始比较 如果小于就让数据后移
		while (insertIndex>=0&&insertVal<arr[insertIndex]){
//			[34, 101, 119, 1, -1, 89]
//			[34, 101, 119, 119, -1, 89]
//			[34, 101, 101, 119, -1, 89]
//			[34, 34, 101, 119, -1, 89]
			arr[insertIndex+1] = arr[insertIndex];
			insertIndex--;
		}
		arr[insertIndex+1] = insertVal;
//		[1, 34, 101, 119, -1, 89]
		System.out.println("第3轮插入");
		System.out.println(Arrays.toString(arr));

		insertSort (arr);
		System.out.println("final");
		System.out.println(Arrays.toString(arr));
	}

	public static void insertSort(int[] arr){
		int insertVal  = 0;
		int insertIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i-1;
			while (insertIndex>=0&&insertVal<arr[insertIndex]){
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			if (insertIndex+1 != i){
				arr[insertIndex+1] = insertVal;
			}
		}
	}
}

package algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hike97
 * @Description 二分查找实现
 * @create 2020-07-28 9:49
 * @Modified By:
 **/
public class BinarySearch {
	public static void main (String[] args) {
		int arr[] = {2,4,6,8,10};
//		int i = binarySearch (arr, 0, arr.length - 1, 1);
//		System.out.printf ("查到的index为: {%d}", i);
//		System.out.println ();
//		List<Integer> list = binarySearch2 (arr, 0, arr.length - 1, 1);
//		System.out.println ("binarySearch2 result:"+list);
//		int insertIndex = insertValueSearch (arr, 0, arr.length - 1, 1);
//		System.out.printf ("插值查找index为：<%d>", insertIndex);
		int index = binarySearchNoRecurtion (arr, 8);
		System.out.printf ("非递归查找:%d", index);
	}
	//二分查找算法

	/**
	 *
	 * @param arr
	 * @param left
	 * @param right
	 * @param findVal
	 * @return
	 */
	public static int binarySearch(int[] arr,int left,int right,int findVal){
		int mid = (left+right)/2;
		int midValue = arr[mid];
		if (left>right)return -1;
		if (findVal>midValue){
			//向右递归
			return binarySearch (arr,mid+1,right,findVal);
		}else if (findVal<midValue){
			//向左递归
			return binarySearch (arr,left,mid-1,findVal);
		}else {
			return mid;
		}
	}

	/**
	 * 二分查找 支持 数组中有重复元素
	 * @param arr
	 * @param left
	 * @param right
	 * @param findVal
	 * @return
	 */
	public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
		int mid = (left+right)/2;
		int midValue = arr[mid];
		if (left>right)return new ArrayList<> ();
		if (findVal>midValue){
			//向右递归
			return binarySearch2 (arr,mid+1,right,findVal);
		}else if (findVal<midValue){
			//向左递归
			return binarySearch2 (arr,left,mid-1,findVal);
		}else {
			//找到对应的地址 向左扫描
			List<Integer> resIndexList = new ArrayList<> ();
			int temp = mid - 1;
			while (true){
				System.out.println (temp);
				if (temp < 0 || arr[temp] != findVal){
					break;
				}
				resIndexList.add (temp);
				temp -= 1;
			}
			resIndexList.add (mid);
			//向右扫描
			temp = mid + 1;
			while (true) {
				if (temp > arr.length-1||arr[temp] !=findVal)break;
				resIndexList.add (temp);
				temp += 1;
			}
			return resIndexList;
		}
	}
	//插值查找
	public static int insertValueSearch(int[] arr,int left,int right,int findVal){
		System.out.println ("插值查找~");
		if (left>right||findVal<arr[0]||findVal>arr[arr.length-1])return -1;
//		int mid = left+1/2*(right-left);
		int mid = left + (right-left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midValue = arr[mid];

		if (findVal>midValue){
			//向右递归
			return insertValueSearch (arr,mid+1,right,findVal);
		}else if (findVal<midValue){
			//向左递归
			return insertValueSearch (arr,left,mid-1,findVal);
		}else {
			return mid;
		}
	}

	/**
	 * 非递归二分查找
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int binarySearchNoRecurtion(int arr[],int target){
		int left = 0;
		int right = arr.length-1;
		while (left<right){
			int mid = (left+right)/2;
			if (arr[mid]==target){
				return mid;
			}else if (arr[mid]>target){
				right = mid -1;//向左查找
			}else {
				left = mid+1;
			}
		}
		return -1;

	}
}

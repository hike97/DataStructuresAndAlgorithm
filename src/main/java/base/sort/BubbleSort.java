package base.sort;

import static utils.CommonUtil.printArray;
import static utils.CommonUtil.swap;

/**
 * @author: hike97
 * @createTime: 2023/05/19 23:11
 * @description: 冒泡排序
 * 每次都找到最高为的最大值
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,3,1,5,8,7,6,9};
        sort(arr);
        printArray(arr);
    }
    public static void sort(int arr[]){
        for (int i = arr.length - 1; i >= 0 ; i--) {
            findMax(arr,i);
        }
    }

    public static void  findMax(int nums[],int bit){
        for (int i = 0; i < bit; i++) {
            if (nums[i] > nums[i+1]){
                swap(nums,i,i+1);
            }
        }
    }
}

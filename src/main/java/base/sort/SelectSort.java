package base.sort;

import static utils.CommonUtil.printArray;
import static utils.CommonUtil.swap;

/**
 * @author: hike97
 * @createTime: 2023/05/20 11:17
 * @description: 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {2,3,1,5,8,7,6,9};
        sort(arr);
        printArray(arr);
    }

    public static void sort(int[] arr){
        if (arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }
}

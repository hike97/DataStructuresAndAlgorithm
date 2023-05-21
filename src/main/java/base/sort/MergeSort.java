package base.sort;

import static utils.CommonUtil.printArray;

/**
 * @author: hike97
 * @createTime: 2023/05/16 17:51
 * @description: 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 3, 6, 9};
//        merge(arr);
        merge(arr,1,4,5);

    }
    /**
     * 实现归并排序
     */
    public static void mergeSort(int[] arr, int left, int right){
        if (left == right) {
            return;
        }
        //1.分成两半：防止数组越界
        int mid = left + (right-left)/2;
        //2.左右排序
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right);
        //3.归并所有结果
        merge(arr,left,mid+1,right);
    }
    /**
     * 任意位置实现归并
     */
    public static void merge(int[] arr, int left, int rightPos, int right){
        int mid = rightPos - 1;
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = rightPos;
        int k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            arr[left+l] = temp[l];
        }
    }

    /**
     * 先实现一个简单的
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        int mid = arr.length >> 1;
        int i = 0;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j < arr.length) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j < arr.length) {
            temp[k++] = arr[j++];
        }
        printArray(temp);
    }


}

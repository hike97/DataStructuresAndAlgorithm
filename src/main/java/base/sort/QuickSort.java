package base.sort;

import static utils.CommonUtil.printArray;
import static utils.CommonUtil.swap;

/**
 * @author: hike97
 * @createTime: 2023/05/20 16:28
 * @description: 快速排序
 * O(nLogn) O(logn)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 10, 7};
//        int mid = partition(arr, 0, arr.length - 1);
//        System.out.println(mid);
        sort(arr,0,arr.length-1);
        printArray(arr);
    }

    public static void sort(int[] arr,int leftBound,int rightBound){
        if (leftBound >= rightBound) return;
        int mid = partition(arr, leftBound, rightBound);
        sort(arr,0,mid-1);
        sort(arr,mid+1,rightBound);

    }

    public static int partition(int[] arr,int left,int rightBound){
        //声明一个轴
        int pivot = arr[rightBound];
        //右边界
        int right = rightBound - 1;
        while (left <= right){
            //找到比轴大的数，如果left小于轴，下标一直右移
            while (left <= right && pivot >= arr[left]) {
                left++;
            }
            while (right >= left && pivot <arr[right]){
                right--;
            }
            //两两交换直到两个指针碰撞到一起
            if (left < right){
                swap(arr,left,right);
            }
        }
        //最后把轴和左边界交换
        swap(arr,left,rightBound);
        return left;
    }
}

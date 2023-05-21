package base.sort;

import static utils.CommonUtil.printArray;
import static utils.CommonUtil.swap;

/**
 * @author: hike97
 * @createTime: 2023/05/20 12:35
 * @description: 插入排序 和 希尔排序（shell）
 */
public class InsertAndShellSort {
    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
//        insertSort(arr,1);
        shellSort(arr);
        printArray(arr);
    }
    // 在对每个子序列进行插入排序时，我们需要比较相隔 gap 的元素，也就是 arr[j] 和 arr[j - gap]。
    // 为了保证 arr[j - gap] 不越界，我们需要让 j - gap >= 0，也就是 j >= gap。
    // 所以循环条件是 j > gap - 1。
    public static void insertSort(int[] arr,int gap) {
        for (int i = gap; i < arr.length; i++) {
            for (int j = i; j >= gap; j-=gap) {
                //后边的数比前边的小
                if (arr[j] < arr[j - gap]) {
                    swap(arr, j, j - gap);
                }
            }
        }
    }

    /**
     * 希尔排序 效率高  不稳定
     * O（n^1.3）
     */
    public static void shellSort(int[] arr) {
        for (int gap = arr.length >> 1; gap > 0 ; gap = gap >> 1) {
            insertSort(arr,gap);
        }
    }
}

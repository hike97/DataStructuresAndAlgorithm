package base.sort;

import static utils.CommonUtil.printArray;
import static utils.CommonUtil.swap;

/**
 * @author: hike97
 * @createTime: 2023/05/21 22:20
 * @description: 堆排序
 * 关键步骤：
 * 1.调整最大节点
 * 2.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 3, 6, 9};
        sort(arr);
        printArray(arr);
    }

    /**
     * 1.堆排序
     */
    public static void sort(int[] arr) {
        //1.构建最大堆
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            //2.始终交换堆顶和堆末元素
            swap(arr, 0, i);
            //3.交换之后重新堆化
            maxHeapify(arr, 0, i);
        }
    }

    /**
     * 2.构建大顶堆
     *   从倒数第一个父节点依次向上构建
     *   lastNonLeaf节点的下标 = (arr.length - 1) / 2;
     * @param arr
     */
    public static void buildMaxHeap(int[] arr) {
        //1.找到最后一个非叶子节点
        int lastNonLeaf = (arr.length - 1) / 2;
        //2.遍历最后一个非叶子节点的前一个节点
        for (int i = lastNonLeaf; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    /**
     * 3.最基本的操作：堆化
     * @param arr  数组
     * @param i    最大节点（tobe）
     * @param size 数组大小
     */
    public static void maxHeapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, i, size);
        }
    }
}

package algorithm.primary.s_001_helloworld;

import algorithm.utils.CommonUtil;

/**
 * @author: hike97
 * @createTime: 2023/04/08 13:36
 * @description: 选择排序 插入排序 冒泡排序
 */
public class C03_Sort {
    /**
     * 插入排序简化版
     */
    public static void insertSortSimple(int[] arr){
        //1.边界条件
        if (arr == null || arr.length < 2 ) return;
        for (int end = 1; end < arr.length; end++) {
            //pre 当前数的前一位 end-1 end
            for (int pre = end-1; pre >=0 && arr[pre]>arr[pre+1] ; pre--) {
                CommonUtil.swap(arr,pre,pre+1);
            } 
        }
    }
    /**
     * 插入排序
     */
    public static void insertSort(int[] arr){
        //1.边界条件
        if (arr == null || arr.length < 2 ) return;
        int n = arr.length;
        //保证第n位以内有序
        for (int i = 1; i < n; i++) {
            //2.标记一个起始位
            int newNumIndex = i;
            //3.两个条件  不越界&&后一个数小于前一个数并且下标不断前移
            while (newNumIndex-1 >= 0 && arr[newNumIndex] < arr[newNumIndex-1]){
                CommonUtil.swap(arr,newNumIndex,newNumIndex-1);
                newNumIndex --;
            }
        }
    }
    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr){
        //1.边界条件
        if (arr == null || arr.length < 2 ) return;
        //0 ~ n-1
        //0 ~ n-2
        //0 ~ end
        int n = arr.length;
        //先控制范围 每次都少遍历最高位
        for (int end = n-1; end >=0 ; end--) {
            //在end的边界下两个数进行互相比较,将大的数放在最右边
            for (int i = 0; i < end; i++) {
                //System.out.println(i +" : " + (i+1));
                if (arr[i]>arr[i+1]){
                    CommonUtil.swap(arr,i,i+1);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        //1.边界条件
        if (arr == null || arr.length < 2 ) return;
        int n = arr.length;
        //0 ~ n-1 0
        //1 ~ n-1 1
        //2 ~ n-1 2
        for (int i = 0; i < n; i++) {
            //i~ n-1 定义范围
            int minIndex = i;//i
            //i之后所有的东西看一遍，找到最小值的位置
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //与数组最左位置交换
            //第1位 最小
            //第2位 最小
            //........
            //第n位 最小
            CommonUtil.swap(arr,i,minIndex);
        }

    }
    public static void main(String[] args) {
        int arr[] = {1,3,4,8,3,4,9,8,5,3,2,1};
        CommonUtil.printArray(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        //insertSort(arr);
        insertSortSimple(arr);
        CommonUtil.printArray(arr);
    }
}

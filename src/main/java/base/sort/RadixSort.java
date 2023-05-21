package base.sort;

import utils.NumberComparator;

import static utils.CommonUtil.printArray;

/**
 * @author: hike97
 * @createTime: 2023/05/21 12:33
 * @description: 基数排序 基于计数排序 计数数组 累加数组 临时数组
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = NumberComparator.lenRandomValueRandom(10, 100);
        printArray(arr);
        sort(arr);
        printArray(arr);
    }

    public static void sort(int[] arr){
        //1.计算出数组中最大值 求出最高位次
        int max = getMax(arr);
        //2.获取位数
        int digits = getDigits(max);
        //3.根据位数循环进行累加计算
        int place = 1;
        for (int i = 0; i < digits; i++) {
            //4.计数排序
            countSort(arr,place);
            printArray(arr);
            place *= 10;
        }
    }

    /**
     * 计数排序
     * @param arr
     * @param place
     */
    private static void countSort(int[] arr, int place) {
        //1.基数排序的数组规模只有 0~9
        int[] tmp = new int[arr.length];
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit] ++;
        }
        //2.累加数组
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }
        //3.反向循环数组添加元素到tmp
        for (int i = arr.length - 1; i >=0 ; i--) {
            int digit = (arr[i] / place) % 10;
            int pos =  count[digit] - 1;
            tmp[pos] = arr[i];
            count[digit] -- ;
        }
        //4.输出到原数组
        System.arraycopy(tmp,0,arr,0,tmp.length);
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    private static int getDigits(int max) {
        int digits = 1;
        for (int i = 0; i <= max; i++) {
            max /= 10;
            digits++;
        }
        return digits;
    }
}

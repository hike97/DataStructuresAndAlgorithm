package base.sort;

import utils.NumberComparator;

import static utils.CommonUtil.printArray;


/**
 * @author: hike97
 * @createTime: 2023/05/20 19:54
 * @description:
 * 计数排序算法的基本思想是:
 * 找出数组中的最大值和最小值
 * 根据最大值和最小值的范围创建一个计数数组，用来存储每个元素出现的次数
 * 对计数数组进行累加，得到每个元素在排序后数组中的位置
 * 倒序遍历原数组，根据计数数组中的位置将元素放入一个临时数组中
 * 将临时数组复制到原数组中
 *
 * 计数排序的时间复杂度和空间复杂度都是**O (n+k)**，其中n是数组的长度，k是数组中元素的范围¹²³。
 *
 * 时间复杂度是O (n+k)的原因是：
 *
 * - 计数排序需要遍历一次数组，统计每个元素出现的次数，这需要O (n)的时间
 * - 计数排序需要创建一个长度为k的计数数组，用来存储每个元素出现的次数，这需要O (k)的时间
 * - 计数排序需要对计数数组进行累加，得到每个元素在排序后数组中的位置，这需要O (k)的时间
 * - 计数排序需要倒序遍历一次数组，根据计数数组中的位置将元素放入一个临时数组中，这需要O (n)的时间
 * - 计数排序需要将临时数组复制到原数组中，这需要O (n)的时间
 *
 * 所以总共需要O (n+k)的时间。
 *
 * 空间复杂度是O (n+k)的原因是：
 *
 * - 计数排序需要创建一个长度为k的计数数组，用来存储每个元素出现的次数，这需要O (k)的空间
 * - 计数排序需要创建一个长度为n的临时数组，用来存储排序后的元素，这需要O (n)的空间
 *
 * 所以总共需要O (n+k)的空间。
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = NumberComparator.lenRandomValueRandom(10, 100);
        printArray(arr);
        sort(arr);
        printArray(arr);
    }

    public static void sort(int[] arr){
        if (arr.length <= 1){
            return;
        }
        //算出最大最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        //根据最大最小值创建计数数组
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) { // 修改了这里
            //每个数出现一次就 +1
            int index = arr[i] - min;
            counts[index] ++;
        }
        //保证稳定性创建一个累加数组
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i-1];
        }
        //倒序数组，根据累加数组将元素存入临时数组中
        int[] tmp = new int[arr.length]; // 修改了这里
        for (int i = arr.length - 1; i >= 0 ; i--) {
            int index = arr[i] - min;
            int pos = counts[index] - 1;
            tmp[pos] = arr[i];
            counts[index] -- ;
        }
        System.arraycopy(tmp,0,arr,0,tmp.length);
    }
}

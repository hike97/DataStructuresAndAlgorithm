package base.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: hike97
 * @createTime: 2023/05/21 19:43
 * @description: 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {

    }

    public static void bucketSort(double[] arr) {
        //创建一个数组，用来存放若干个桶
        ArrayList<ArrayList<Double>> buckets = new ArrayList<>();
        //根据数组长度确定桶的数量，这里假设每个桶最多存放10个元素
        int bucketCount = arr.length / 10 + 1;
        //初始化每个桶
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        //将数组中的元素分配到各个桶中，这里假设数组中的元素都在0到1之间
        for (double num : arr) {
            //计算元素应该放入哪个桶，这里使用简单的乘法和取整运算
            int index = (int) (num * bucketCount);
            //将元素放入对应的桶中
            buckets.get(index).add(num);
        }
        //对每个桶内的元素进行排序，这里使用Collections.sort方法
        for (ArrayList<Double> bucket : buckets) {
            Collections.sort(bucket);
        }
        //将所有桶内的元素依次放回原数组中
        int index = 0;
        for (ArrayList<Double> bucket : buckets) {
            for (double num : bucket) {
                arr[index++] = num;
            }
        }
    }

}

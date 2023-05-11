package utils;

import zuoshen.primary.s_002_node.entity.DoubleNode;
import zuoshen.primary.s_002_node.entity.Printable;

import java.util.function.Supplier;

/**
 * @author: hike97
 * @createTime: 2023/04/08 13:39
 * @description: 打印工具
 */
public class CommonUtil {

    public static <T extends Printable> void printNode(T n1) {
        while (n1 != null) {
            System.out.print(n1.getValue() + " ");
            n1 = (T) n1.getNext();
        }
    }

    public static void printDoubleNode(DoubleNode n1) {
        Integer lastVal;
        Integer nextVal;
        while (n1 != null) {
            lastVal = n1.last == null ? null : n1.last.value;
            nextVal = n1.next == null ? null : n1.next.value;
            System.out.println(lastVal + " <~ " + n1.value + " -> " + nextVal + " ");
            n1 = n1.next;
        }
    }

    public static void newLine() {
        System.out.println("============华丽的分隔符==============");
    }

    /**
     * 某个值出现的概率
     */
    public static void printNumP(int testTimes, Supplier<Integer> supplier, int expectNum) {
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (supplier.get() == expectNum) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
    }

    /**
     * 概率测试
     */
    public static void printP(int testTimes, int scale, Supplier<Integer> s) {
        int[] buckets = new int[scale];
        for (int i = 0; i < testTimes; i++) {
            int num = s.get();
            buckets[num]++;
        }
        for (int i = 0; i < scale; i++) {
            System.out.println(i + "这个数，出现了 " + buckets[i] + "次");
        }
    }

    /**
     * 数组的i和j交换
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 数组打印
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

package algorithm;

import static algorithm.utils.CommonUtil.printArray;

/**
 * @author: hike97
 * @createTime: 2023/04/10 10:40
 * @description: 草稿纸
 */
public class Test {
    public static void main(String[] args) {
        int[] array = generateRandomArray(10, 10);
        printArray(array);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}

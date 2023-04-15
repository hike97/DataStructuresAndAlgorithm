package algorithm.primary.s_001_helloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static algorithm.Test.generateRandomArray;
import static algorithm.utils.CommonUtil.printArray;

/**
 * @author: hike97
 * @createTime: 2023/04/10 9:43
 * @description: 二分法经典问题
 */
public class C06_BinarySearch {
    /**
     * 题目3：arr有序 求<=num 最右的数的下标
     */
    public static int findRingtIndexLessthanNum(int[] arr,int num){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int L = 0;
        int R = arr.length-1;
        int ans = -1;
        while (L <= R){
            int mid = (L + R)/2;
            if (arr[mid] <= num){
                ans = mid;
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return ans;

    }
    /**
     * 题目3：arr有序 求>=num 最左的数的下标
     */
    public static int findLeftIndexGreaterthanNum(int[] arr,int num){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int L = 0;
        int R = arr.length-1;
        int ans = -1;
        while (L <= R){
            int mid = (L + R)/2;
            //如果发现大于num 将结果坐标更新
            if (arr[mid] >= num){
                ans = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return ans;

    }
    /**
     * 题目2：二分查找 arr有序
     */
    public static boolean findNum(int[] arr,int num){
        if (arr == null || arr.length == 0){
            return false;
        }
        int L = 0;
        int R = arr.length-1;
        while (L <= R){
            int mid = (L + R)/2;
            if (arr[mid] == num){
                return true;
            }
            if (arr[mid] < num){
                L = mid + 1;
            }
            if (arr[mid] > num){
                R = mid - 1;
            }
        }
        return false;
    }
    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testFindNum() {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != findNum(arr, value)) {
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
    /**
     * 题目1：整体无序数组 保证相邻两个数之间不等 求一个局部最小值的index
     * 局部最小值含义：大于左边 小与右边
     * 结论：二分不一定有序
     */
    public static int findLocalMinimumIndex(int[] arr){
        try {
            //1.考虑边界问题
            if (arr == null || arr.length == 0) return -1;
            if (arr.length == 1 || arr[0] < arr[1]) return 0;
            int n = arr.length - 1;
            if (arr[n] < arr[n-1]){
                return n;
            }
            int l = 0;
            int r = n;
            //l<=r 会出现边界问题 如果只剩下两个数 l=0 r=1 mid=0 这样 mid-1 会越界
            //solution : 把条件改成 l < r-1 保证 l r 之间存在 3个数之上才进行循环操作
            //while (l <= r){
            while (l < r - 1){
                int mid = (l + r)/2;
                if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]){
                    return mid;
                }
                if (arr[mid] > arr[mid - 1]){
                    //抛弃高位 高位在右
                    r = mid - 1;
                    continue;
                }
                if (arr[mid] > arr[mid + 1]){
                    //抛弃高位 高位在左
                    l = mid + 1;
                }
            }
            //2个值的时候 谁最小就返回谁
            return arr[r] < arr[l] ? r : l;
        } catch (Exception e) {
            printArray(arr);
            throw new RuntimeException(e);
        }
    }

    // 生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    // 也用于测试
    public static boolean check(int[] arr, int minIndex) {
        try {
            if (arr.length == 0) {
                return minIndex == -1;
            }
            int left = minIndex - 1;
            int right = minIndex + 1;
            //如果越界 不破坏规则
            boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
            boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
            return leftBigger && rightBigger;
        } catch (Exception e) {
            printArray(arr);
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFindLocalMinimumIndex() {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            //int[] arr = {198,28,81,15,47 };
            int ans = findLocalMinimumIndex(arr);
            Assertions.assertTrue(check(arr, ans));
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");
    }
}

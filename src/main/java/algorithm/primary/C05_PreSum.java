package algorithm.primary;

import algorithm.utils.CommonUtil;
import algorithm.utils.NumberComparator;

/**
 * @author: hike97
 * @createTime: 2023/04/09 23:18
 * @description: 前缀数组之和
 */
public class C05_PreSum {

    public static class RangeSum2 {
        //前n项和数组
        private int[] preSum;

        public RangeSum2(int[] array){
            int N = array.length;
            preSum = new int[N];
            preSum[0] = array[0];
            for (int i = 1; i <N ; i++) {
                //这个数组的前n项和 等于前缀数组和加上当前数组的值
                preSum[i] = preSum[i-1] + array[i];
            }
        }

        /**
         * 求区间(L,R)范围内数组之和
         * @param L
         * @param R
         * @return
         */
        public int rangeSum(int L,int R){
            return L == 0 ? preSum[R] : preSum[R] - preSum[L-1];
        }
    }

    public static void main(String[] args) {
        int[] arr = NumberComparator.lenRandomValueRandom(10, 100);
        CommonUtil.printArray(arr);
        RangeSum2 rangeSum = new RangeSum2(arr);
        System.out.println(rangeSum.rangeSum(0, 5));
        System.out.println(rangeSum.rangeSum(1, 5));
    }
}

package algorithm.primary.s_001_helloworld;

/**
 * @author: hike97
 * @createTime: 2023/04/08 12:57
 * @description: 阶乘的实现
 */
public class C02_SumOfFactorial {
    public static long factorial(int n){
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
            //System.out.println("i: "+i+" result: "+result);
        }
        return result;
    }
    //第一种，每次阶乘都算一遍 然后求和
    public static long f1(long n){
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans  = ans + factorial(i);
        }
        return ans;
    }
    //第二种：把每次的结果放到一个变量中 然后求和
    public static long f2(long n){
        long result = 0;
        long cur = 1;
        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            result = result + cur;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(f1(10));
        System.out.println(f2(10));
    }
}

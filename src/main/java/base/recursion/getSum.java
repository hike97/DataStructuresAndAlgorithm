package base.recursion;

/**
 * @author: hike97
 * @createTime: 2023/05/11 15:47
 * @description: 递归实现n以内数字的相加的和
 */
public class getSum {

    public static int sum(int n) {
        if (n >= 1) {
            return sum(n - 1) + n;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sum(100));
    }
}

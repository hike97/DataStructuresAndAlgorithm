package work;

/**
 * @author: hike97
 * @createTime: 2023/05/11 9:53
 * @description: 用两个变量实现交换
 */
public class ChangeTwoNums {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a + ":" + b);
    }
}

package algorithm.primary.s_001_helloworld;

/**
 * @author: hike97
 * @createTime: 2023/04/08 11:18
 * @description: 打印一个整数的32位信息
 */
public class C01_PrintBinary {
    public static void main(String[] args) {
        int num  = 2147483647;
        printBinary(num);

        int test = 1122321312;

        printBinary(test);
        printBinary(test<<1);

        //负数的表示 去掉符号位 取反+1
        //11111111111111111111111111111111
        System.out.println("-1取反+1 就是相反数");
        printBinary(-1);
        printBinary(~-1);
        System.out.println(~-1+1);

        //带符号右移
        int c = 18989;
        System.out.println(c>>1);
        System.out.println(c>>>1);
        //最小负数 取 相反数
        int minValue = Integer.MIN_VALUE;
        System.out.println("int最小数："+minValue);
        System.out.println("最小数取反："+-minValue);
        System.out.println("最小数取反+1结果："+(~minValue+1));

        int zero = 0;
        //0 的相反数 因为位溢出 所以 还是 0
        System.out.println(~zero + 1);
    }

    /**
     * 将一个int 以32位二进制打出来
     * 无符号整数 是 2的32次方-1 为什么-1 因为把0 分配给了非负区域
     * 有符号是 -2^31 ~ 2^31-1
     * @param num
     */
    public static void printBinary(int num){
        for (int i = 31; i >=0 ; i--) {
            if ((i&7) == 0){
                System.out.print((num & (1<<i)) == 0 ? "0 " : "1 ");
            }else {
                System.out.print((num & (1<<i)) == 0 ? "0" : "1");
            }

        }
        System.out.println();
    }
}

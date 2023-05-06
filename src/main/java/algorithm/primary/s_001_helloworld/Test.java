package algorithm.primary.s_001_helloworld;

import static algorithm.primary.s_001_helloworld.C01_PrintBinary.printBinary;

/**
 * @author: hike97
 * @createTime: 2023/04/21 11:56
 * @description: TODO
 */
public class Test {
    public static void main(String[] args) {
        int i = 1 << 29;
        printBinary(i);
        int capacity = (1 << 29) - 1;
        printBinary(capacity);
    }
}

package zuoshen.primary.s_001_helloworld;

/**
 * @author: hike97
 * @createTime: 2023/04/21 11:56
 * @description: TODO
 */
public class Test {
    public static void main(String[] args) {
        int i = 1 << 29;
        C01_PrintBinary.printBinary(i);
        int capacity = (1 << 29) - 1;
        C01_PrintBinary.printBinary(capacity);
    }
}

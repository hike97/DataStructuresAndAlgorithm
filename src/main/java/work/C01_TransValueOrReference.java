package work;

/**
 * @author: hike97
 * @createTime: 2023/04/15 8:52
 * @description: java 值传递或引用传递问题 =>java是值传递
 */
public class C01_TransValueOrReference {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        System.out.println("Before calling foo, a is " + a);
        foo(a);
        System.out.println("After calling foo, a is " + a);
    }

    public static void foo(ListNode b) {
        System.out.println("Inside foo, b is " + b);
        b = new ListNode(2);
        System.out.println("Inside foo, b is " + b);
    }

    private static class ListNode{
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

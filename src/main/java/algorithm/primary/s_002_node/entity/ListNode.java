package algorithm.primary.s_002_node.entity;

/**
 * @author: hike97
 * @createTime: 2023/04/15 19:04
 * @description: TODO
 */
public class ListNode implements Printable {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public int getValue() {
        return val;
    }

    @Override
    public Printable getNext() {
        return next;
    }
}

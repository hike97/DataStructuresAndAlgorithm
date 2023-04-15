package algorithm.primary.s_002_node.entity;

/**
 * @author: hike97
 * @createTime: 2023/04/14 17:20
 * @description: 单向链表
 */
public class Node implements Printable {
    public int value;
    public Node next;

    public Node(int data) {
        value = data;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Printable getNext() {
        return next;
    }
}

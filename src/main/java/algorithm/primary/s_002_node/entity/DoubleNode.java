package algorithm.primary.s_002_node.entity;

import lombok.ToString;

/**
 * @author: hike97
 * @createTime: 2023/04/14 19:02
 * @description: 双向链表
 */
@ToString
public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data){
        value = data;
    }
}

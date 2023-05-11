package zuoshen.primary.s_002_node;

import zuoshen.primary.s_002_node.entity.Node;
import org.junit.jupiter.api.Test;

import static utils.CommonUtil.printNode;

/**
 * @author: hike97
 * @createTime: 2023/04/14 19:05
 * @description: 单链表算法
 */
public class C01_SingleNode {

    @Test
    public void testReverseNode() {
        //1.初始化链表
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        System.out.println("原链表输出");
        printNode(n1);
        System.out.println();
        Node reverseNode = reverseNode(n1);
        System.out.println("反转链表输出");
        printNode(reverseNode);
    }

    //1.反转链表
    public static Node reverseNode(Node head) {
        //初始化一个空节点
        Node pre = null;
        //标记节点
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

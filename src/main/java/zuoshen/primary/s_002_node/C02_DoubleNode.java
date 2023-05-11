package zuoshen.primary.s_002_node;

import zuoshen.primary.s_002_node.entity.DoubleNode;
import utils.CommonUtil;
import org.junit.jupiter.api.Test;

/**
 * @author: hike97
 * @createTime: 2023/04/14 19:05
 * @description: 双向链表算法
 */
public class C02_DoubleNode {

    @Test
    public void testReverseDoubleNode() {
        //1.初始化双向链表
        DoubleNode node = new DoubleNode(1);
        node.next =  new DoubleNode(2);
        node.next.last = node;
        node.next.next = new DoubleNode(3);
        node.next.next.last = node.next;
        CommonUtil.printDoubleNode(node);
        DoubleNode reverseDoubleNode = reverseDoubleNode(node);
        System.out.println("反转之后的双向链表");
        CommonUtil.printDoubleNode(reverseDoubleNode);
    }

    public static DoubleNode reverseDoubleNode(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}

package algorithm.primary.s_002_node;


import algorithm.primary.s_002_node.entity.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static algorithm.utils.CommonUtil.printNode;

/**
 * @author: hike97
 * @createTime: 2023/04/14 21:22
 * @description: k组反转链表
 */
public class C05_ReverseNodesInKGroup {

    public ListNode listNode;

    @BeforeEach
    public void beforeTest() {
        listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
    }

    /**
     * 第一步求出k之后的临界点
     */
    @Test
    public void testGetKGroup() {
        ListNode endNode = getEndNodeByK(listNode, 7);
        System.out.println(endNode);
        System.out.println(listNode);
    }

    @Test
    public void testAll() {
        ListNode node = reverseKGroup(listNode, 2);
        printNode(node);
    }
    /**
     * 1.获取一个步长为k的Node的值
     * 1,2,3,4,5 k=3
     * 那么需要遍历k-1 次得到end为3
     *
     * @param start
     * @param k
     * @return
     */
    public static ListNode getEndNodeByK(ListNode start, int k) {
        //start != null 边界问题
        for (int i = 0; i < k - 1 && start != null; i++) {
            start = start.next;
        }
        return start;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        //这里不能直接遍历head，需要返回结果 所以复制head引用
        ListNode start = head;
        //1.求出end
        ListNode end = getEndNodeByK(start, k);
        if (end == null) {
            return head;
        }
        //2.第一组凑齐,head 指向新头部
        head = end;
        //3.反转链表操作
        reverse(start, end);
        //4.上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            //新一组的节点
            start = lastEnd.next;
            end = getEndNodeByK(start, k);
            if (end == null) {
                return head;
            }
            System.out.println("方法外部 before invoke reverse ,lastEnd: "+lastEnd+"\nend: "+end);
            reverse(start, end);
            System.out.println("方法外部 after invoke reverse ,lastEnd: "+lastEnd+"\nend: "+end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    private static void reverse(ListNode start, ListNode end) {
        System.out.println("方法内部：before invoke reverse() end: " + end);
        //1.先找到e 的下一个位置
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next;
        //2.反转链表
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
        System.out.println("方法内部：after invoke reverse() end: " + end);
    }
}

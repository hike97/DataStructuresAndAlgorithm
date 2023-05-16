package newcoder;

import utils.Generator;
import zuoshen.primary.s_002_node.entity.ListNode;

import static utils.CommonUtil.printNode;

/**
 * @author: hike97
 * @createTime: 2023/05/15 19:41
 * @description: 求两个链表相交的节点
 */
public class getIntersectionNode {
    public static ListNode listNode1 = new ListNode(1);
    public static ListNode listNode2 = new ListNode(2);
    public static ListNode listNode3 = new ListNode(3);
    public static void main(String[] args) {
        ListNode pHead1 = Generator.generateRandomList(5);
        ListNode pre1 = pHead1;
        for (int i = 1; i < 5; i++) {
            pre1 = pre1.next;
        }
        pre1.next = listNode1;
        pre1.next.next = listNode2;
        pre1.next.next.next = listNode3;
        ListNode pHead2 = Generator.generateRandomList(3);
        ListNode pre2 = pHead2;
        for (int i = 1; i < 3; i++) {
            pre2 = pre2.next;
        }
        pre2.next = listNode1;
        pre2.next.next = listNode2;
        pre2.next.next.next = listNode3;
        printNode(pHead1);
        printNode(pHead2);
        ListNode found = FindFirstCommonNode(pHead1, pHead2);
        printNode(found);
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //先计算出两个链表的长度 和 差值
        long l1 = 0;
        long l2 = 0;
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        while (head1 != null) {
            head1 = head1.next;
            l1++;
        }

        while (head2 != null) {
            head2 = head2.next;
            l2++;
        }

        long diff = l1 > l2 ? (l1 - l2) : (l2 - l1);
        head1 = l1 > l2 ? pHead1 : pHead2;
        head2 = (head1 == pHead1) ? pHead2 : pHead1;

        for (int i = 0; i < diff; i++) {
            head1 = head1.next;
        }
        while (head1 != null && head2 != null) {
            if (head1 ==  head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
}

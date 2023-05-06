package algorithm.primary.s_002_node;

import algorithm.primary.s_002_node.entity.ListNode;

/**
 * @author: hike97
 * @createTime: 2023/04/15 18:36
 * @description: 反转链表两数相加
 */
public class C06_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        //获取链表长度 根据长度找到长链表和短链表
        int head1Len = getNodeLength(head1);
        int head2Len = getNodeLength(head2);
        ListNode longNode = head1Len > head2Len ? head1 : head2;
        ListNode shortNode = longNode == head1 ? head2 : head1;
        //进位 和当前位变量
        int carry = 0;
        int curNum;
        ListNode curL = longNode;
        ListNode curS = shortNode;
        //记录长链表即将遍历为空的位置
        ListNode lastNode = null;
        //分三种情况
        //1.短的遍历完毕
        while (curS != null) {
            curNum = longNode.val + shortNode.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            lastNode = curL;
            curS = curS.next;
            curL = curL.next;
        }
        //2.长的遍历完毕
        while (curL != null) {
            curNum = longNode.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            lastNode = curL;
            curL = curL.next;
        }
        //3.长短都遍历完看看是否剩余进位
        while (carry != 0) {
            lastNode.next = new ListNode(1);
        }
        //将最终结果全部合到 最长链表
        return longNode;
    }

    public static int getNodeLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}

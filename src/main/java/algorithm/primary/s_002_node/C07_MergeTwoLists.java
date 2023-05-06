package algorithm.primary.s_002_node;

import algorithm.primary.s_002_node.entity.ListNode;

/**
 * @author: hike97
 * @createTime: 2023/04/15 20:52
 * @description: 合并两个链表为有序链表
 * 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
 */
public class C07_MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        //1.谁小谁是头
        ListNode head = list1.val <= list2.val ? list1 : list2;
        //2.cur1 小头下一个 cur2 大头第一个
        ListNode cur1 = head.next;
        ListNode cur2 = list1 == head ? list2 : list1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        //跳出循环  谁不空 指向谁 后边的链表无需排序
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }
}

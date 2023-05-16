package newcoder;

import utils.Generator;
import zuoshen.primary.s_002_node.entity.ListNode;

import static utils.CommonUtil.printNode;


/**
 * @author: hike97
 * @createTime: 2023/05/11 19:47
 * @description: 反转链表
 */
public class ReverseListSolution {
    public static void main(String[] args) {
        ListNode head = Generator.generateRandomList(10);
        printNode(head);
        ListNode result = reverseListRecursion(head);
        printNode(result);

    }
    /**
     * 递归方法反转链表
     * @param head
     * @return
     */
    public static ListNode reverseListRecursion(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        //ListNode cur =  reverseListRecursion(head.next);
        ListNode cur =  reverseListNormal(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    /**
     * 普通方法反转链表
     * @param head
     * @return
     */
    public static ListNode reverseListNormal(ListNode head){
        if (head == null || head.next == null){
            return  head;
        }
        ListNode pre  = null;
        ListNode next;
        while (head != null){
            //记录head没有断链之前的节点
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

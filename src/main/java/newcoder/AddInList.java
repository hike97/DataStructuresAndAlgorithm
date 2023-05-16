package newcoder;

import zuoshen.primary.s_002_node.entity.ListNode;

/**
 * @author: hike97
 * @createTime: 2023/05/15 22:23
 * @description: 两链表相加 注意题目链表顺序 如果是相反的需要反转链表
 */
public class AddInList {
    public static void main(String[] args) {

    }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode dommy =  new ListNode(-1);
        ListNode cur = dommy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int x, y;
            if (head1 == null) {
                x = 0;
            } else {
                x = head1.val;
            }

            if (head2 == null) {
                y = 0;
            } else {
                y = head2.val;
            }

            int sum = x + y + carry;
            carry = sum / 10;
            int digital = sum % 10;
            cur.next = new ListNode(digital);
            cur = cur.next;

            //继续步进两个节点
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        //如果两个节点都遍历完了还有进位
        if (carry != 0) {
            cur.next = new ListNode(1);
        }
        return dommy.next;
    }
}

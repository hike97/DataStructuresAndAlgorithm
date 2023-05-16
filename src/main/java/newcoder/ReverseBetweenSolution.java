package newcoder;

import utils.Generator;
import zuoshen.primary.s_002_node.entity.ListNode;

import static utils.CommonUtil.printNode;

/**
 * @author: hike97
 * @createTime: 2023/05/11 18:52
 * @description: 链表内指定区间反转
 * https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=295&tqId=654&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 */
public class ReverseBetweenSolution {
    public static void main(String[] args) {
        ListNode head = Generator.generateRandomList(1, false);
        printNode(head);
        ListNode node = ReverseBetween(head, 1, 1);
        System.out.println();
        printNode(node);
    }

    public static ListNode ReverseBetween(ListNode head, int m, int n){
        // write code here
        // 1.设置虚拟节点
        ListNode dummy = new ListNode(-1);
        // 2.连接head
        dummy.next = head;
        // 3.添加pre指针 和 cur 指针 pre指针指向要变化的节点的前一个节点 cur指向要反转的节点
        ListNode pre = dummy;
        ListNode cur = pre.next;
        // 4.定位pre
        for(int i = 0; i < m - 1; i++){
            pre = pre.next;
            cur = cur.next;
        }
        // 5.进行链表反转操作 首先找到cur的下一个节点
        //例如 1->2->3->4 找到2
        //然后 2 指向 4
        //3 指向 2
        for(int i = 0; i < n - m; i++){
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}

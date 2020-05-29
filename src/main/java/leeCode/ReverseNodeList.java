package leeCode;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-25 11:26
 * @Modified By:
 **/
public class ReverseNodeList {
	public static void main (String[] args) {
		ListNode head = new ListNode (1, new ListNode (2, new ListNode (3,new ListNode (4,new ListNode (5,null)))));
		ListNode node = reverseList (head);
		System.out.println (node);
	}
	public static ListNode reverseList(ListNode head) {
		//获取当前节点
		ListNode cur = head;
		//获取当前节点的下一节点指针
		ListNode next = null;
		//创建反转头结点
		ListNode reversHead = new ListNode(0);
		while(cur!=null){
			next = cur.next;
			cur.next = reversHead.next;
			reversHead.next = cur;
			cur = next;
		}
		head = reversHead.next;

		return head;
	}
}

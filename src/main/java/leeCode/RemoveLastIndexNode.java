package leeCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author hike97
 * @Description 删除倒数第n个结点
 * @create 2020-05-21 11:15
 * @Modified By:
 **/
public class RemoveLastIndexNode {
	public static void main (String[] args) {
		ListNode head = new ListNode (1, new ListNode (2, null));
		ListNode node = removeNthFromEnd (head, 2);
		System.out.println (node);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		//空列表
		if(head.next==null)return null;
		//获取列表size
		int size = 0;
		ListNode current = head;
		while(current != null){
			size++;
			current = current.next;
		}
		if (n>size) return  null;
		//获取倒数第n个结点的前一节点
		current = head;
		if (n>size)return null;
		int scope = size-n;
		if (scope>1){
			for(int i = 0;i<scope-1;i++){
				current = current.next;
			}
		}else {
			if (n==1) {
				head.next=null;
				return head;
			}
			if (n==size) return head.next;
		}


		current.next=current.next.next;

		return head;
	}
}
 //Definition for singly-linked list.
@Data
@NoArgsConstructor
@AllArgsConstructor
class ListNode {
     int val;
     ListNode next;
	 ListNode(int x) { val = x; }
 }


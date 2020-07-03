package leeCode;



/**
 * @Author hike97
 * @Description
 * @create 2020-05-28 14:07
 * @Modified By:
 **/
public class MergeTwoNodes {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null&&l2==null)return  null;
		if (l1==null)return l2;
		if (l2==null)return l1;
		ListNode result ;
		if (l2.val>l1.val){
			result = l1;
			result.next = mergeTwoLists (l1.next,l2);
		}else {
			result = l2;
			result.next = mergeTwoLists (l2.next,l1);
		}
		return  result;

	}

	public static void main (String[] args) {
		ListNode listNode1 = new ListNode (1, new ListNode (2, new ListNode (4,null)));
		ListNode listNode2 = new ListNode (1, new ListNode (3, new ListNode (4,null)));
		ListNode listNode = mergeTwoLists (listNode1, listNode2);
		System.out.println (listNode);

	}
}

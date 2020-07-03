package dataStructures.linkedlist;

import lombok.Data;

import java.util.Stack;

import static dataStructures.linkedlist.SingleLinkedList.getlength;

/**
 * @Author hike97
 * @Description 单链表
 * @create 2020-05-11 14:50
 * @Modified By:
 **/
public class SingleLinkedListDemo{
	public static void main (String[] args) {
		HeroNode hero1 = new HeroNode (1, "宋江", "及时雨");
	    HeroNode hero2 = new HeroNode (2,"卢俊义","玉麒麟");
	    HeroNode hero3 = new HeroNode (3,"公孙胜","入云龙");
	    HeroNode hero4 = new HeroNode (4,"宁立恒","血手人屠");
	    SingleLinkedList list = new SingleLinkedList ();
//		list.add (hero1);
//		list.add (hero4);
//		list.add (hero2);
//		list.add (hero3);
//按编号排序
		list.addByOrder (hero1);
		list.addByOrder (hero4);
		list.addByOrder (hero3);
		list.addByOrder (hero2);
//		list.addByOrder (hero2);
//		HeroNode hero5 = new HeroNode (4,"吴用","智多星");
//		list.update (hero5);
//		list.delete (1);
		list.list ();
//		list.reverseList (list.getHead ());
		System.out.println ("#####逆序打印链表#####");
		list.reversePrint (list.getHead ());
		System.out.println ("#####逆序打印链表END#####");
//		list.list ();
		//		System.out.println (getlength (list.getHead ()));
	}

}
@Data
class SingleLinkedList {
	//初始化头结点
	private HeroNode head = new HeroNode(0,"","");
	//添加节点
	public void add(HeroNode heroNode){
		//1.找到最后结点 最后结点的next -> 新结点
		//2.头节点不能动，需要
		HeroNode temp = head;
		while (true){
			//找到链表最后
			if (temp.getNext ()==null)break;
			temp = temp.getNext ();
		}
		temp.setNext (heroNode);
	}
	//根据顺序添加结点
	public  void addByOrder(HeroNode heroNode){
		HeroNode temp = this.head;
		boolean flag = false;//判断编号是否存在
		while (true){
			if (temp.getNext ()==null)break;//说明temp已经在链表的最后
			if (temp.getNext ().getNo ()>heroNode.getNo ()){
				break;
			}else if (temp.getNext ().getNo ()==heroNode.getNo ()){
				flag=true;
				break;
			}
			temp = temp.getNext ();
		}
		//判断flag的值
		if (flag){
			System.out.printf ("编号%d已存在,不能加入\n",heroNode.getNo ());
		}else {
			//heroNode->C(temp.next)
			//temp ->heroNode
			heroNode.setNext (temp.getNext ());
			temp.setNext (heroNode);
		}
	}

	//修改 根据no修改
	public void update(HeroNode newHeroNode){
		//判断是否为空
		if (head.getNext ()==null){
			System.out.println ("链表为空");
			return;
		}
		//
		HeroNode temp = this.head.getNext ();
		boolean flag = false;//是否找到结点
		while (true){
			if (temp==null)break;
			if (temp.getNo ()==newHeroNode.getNo ()){
				flag=true;
				break;
			}
			temp = temp.getNext ();
		}
		if (flag){
			temp.setName (newHeroNode.getName ());
			temp.setNickname (newHeroNode.getNickname ());
		}else {
			System.out.printf ("没有找到编号%d的结点,不能修改\n",newHeroNode.getNo ());
		}
	}

	//删除
	public void delete(int no){
		HeroNode temp = head;
		boolean flag = false;//标志是否找到待删除节点
		while (true){
			if (temp.getNext ()==null){
				break;
			}
			if (temp.getNext ().getNo () == no){
                //找到待删除节点的前一个结点temp
				flag = true;
				break;
			}
			temp = temp.getNext ();
		}
		if (flag){
            temp.setNext (temp.getNext ().getNext ());
		}else {
			System.out.printf ("没有找到编号%d的结点,不能删除\n",no);
		}
	}

	/**
	 * 题1：获取单链表的节点的个数（如果是头结点的链表，需求不统计头结点）
	 */
	public static int getlength(HeroNode head){
		if (head.getNext ()==null)return 0;//空链表
		int length = 0;
		HeroNode current = head.getNext ();
		while (current!=null){
			length++;
			current=current.getNext ();
		}
		return length;
	}

	/**
	 * 题2：获取单链表倒数第k个结点
	 * 1.获取有效结点
	 * 2.遍历size-index 次 取得结果
	 */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
    	if (head.getNext ()==null)return null;
		int size = getlength (head);//获取有效结点个数
		if (index<0||index>size)return null;//越界
		HeroNode temp = head.getNext ();
		for (int i = 0; i < size - index; i++) {
			temp = temp.getNext ();
		}
		return temp;
	}

	/**
	 * 题3：单链表的反转
	 */
	public static  void reverseList(HeroNode head){
		//无结点 结点为1
		if (head==null||head.getNext ()==null) return ;
 		//定一个辅助指针
		HeroNode cur = head.getNext ();
		//定义当前节点的下一个节点
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode (0,"","");
		while (cur!=null){
			next = cur.getNext ();
			//将cur的下一个节点指向新的链表的最前端
			cur.setNext (reverseHead.getNext ());
			reverseHead.setNext (cur);
			cur = next;
		}
		head.setNext (reverseHead.getNext ());
	}

	/**
	 * 题4：反向打印单链表
	 */
    public static  void reversePrint(HeroNode head) {
    	if (head.getNext () == null)return;
		Stack<HeroNode> stack = new Stack<> ();
		HeroNode cur = head.getNext ();
		//压栈
		while (cur !=null){
			stack.push (cur);
			cur = cur.getNext ();
		}
		//出栈
		while (stack.size ()>0) System.out.println (stack.pop ());
	}
	public void list() {
		//判断链表事发后为空
		if (head.getNext () == null)return;
		//辅助变量遍历
		HeroNode temp = head.getNext ();
		while (true){
			//判断是否到最后
			if (temp==null) break;
			System.out.println (temp);
			temp = temp.getNext ();

		}
	}
}
@Data
class HeroNode {
	private int no;
	private String name;
	private String nickname;
	private HeroNode next;

	public HeroNode (int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString () {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickname='" + nickname + '\'' +
				'}';
	}
}
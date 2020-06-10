package dataStructures.linkedlist;

import lombok.Data;

/**
 * @Author hike97
 * @Description 约瑟夫问题
 * @create 2020-06-04 13:59
 * @Modified By:
 **/
public class Josephus {
	public static void main (String[] args) {
         //测试
		CircleSingleLinkedList list = new CircleSingleLinkedList ();
		list.add (5);
		list.showBoy ();
		//出圈操作
		list.countBoy (1,2,5);
	}
}
//创建一个环形的单向链表
class CircleSingleLinkedList{
	private Boy first ;
	//添加节点 构成环形链表
	public void add(int nums){
		if (nums<1) {
			System.out.println ("nums值不正确");
			return;
		}
		//创建环形链表
		Boy curBoy = null;//辅助指针
		for (int i = 1; i <=nums; i++) {
			Boy boy = new Boy (i);
			//第一个节点
			if (i == 1){
				first = boy;
				first.setNext (first);
				curBoy = first;//指向第一个
			} else {
				curBoy.setNext (boy);
				boy.setNext (first);
				curBoy = curBoy.getNext ();
			}
		}
	}

	//遍历当前环形链表
	public void showBoy(){
		//判断链表是否为空
		if (first == null){
			System.out.println ("null");
			return;
		}
		Boy curBoy =  first;
		while (true){
			System.out.printf ("小孩的编号: %d \n",curBoy.getNo ());
			if (curBoy.getNext () == first) break;
			curBoy = curBoy.getNext ();
		}
	}

	//根据用户的输入，计算小孩出圈的顺序
	void countBoy(int startNo,int countNum,int nums){
		//先对数据进行校验
		if (first == null || startNo <1 || startNo > nums) System.out.println ("输入参数有误，请重新输入");
		//创建辅助指针，帮助完成小孩出圈
		Boy helper = first;
		while (true){
			if (helper.getNext () == first) break;
			helper = helper.getNext ();
		}
		//小孩报数前先确定first和helper的定位
		for (int i = 0; i < startNo-1; i++) {
			first = first.getNext ();
			helper = helper.getNext ();
		}
		//出圈操作
		while (true) {
			if (helper == first) break;
			//让first 和 helper 指针同时移动 countNum - 1
			for (int i = 0; i < countNum - 1; i++) {
				first = first.getNext ();
				helper = helper.getNext ();
			}
			//这是first指向的节点，就是要出圈的小孩节点
			System.out.printf ("小孩%d出圈\n",first.getNo ());
			//进行出圈操作
			first = first.getNext ();//first 后移
			helper.setNext (first);//尾部合并
		}
		System.out.printf ("最后留在圈中的小孩编号%d \n", helper.getNo ());
	}
}
//创建一个Boy类，表示一个节点
@Data
class Boy {
	private int no;//编号
	private Boy next;

	public Boy (int no) {
		this.no = no;
	}
}

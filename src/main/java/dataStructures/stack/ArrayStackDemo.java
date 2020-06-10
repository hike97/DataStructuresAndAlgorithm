package dataStructures.stack;

import java.util.Scanner;

/**
 * @Author hike97
 * @Description 数组和单链表实现栈
 * @create 2020-06-10 11:00
 * @Modified By:
 **/
public class ArrayStackDemo {
	public static void main (String[] args) {
//		ArrayStack stack = new ArrayStack (4);
		NodeStack stack = new NodeStack ();
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner (System.in);
		while (loop){
			System.out.println ("show: 展示栈");
			System.out.println ("exit 退出程序");
			System.out.println ("push 入栈");
			System.out.println ("pop 出栈");
			System.out.println ("please choose your choice");
			key=scanner.next ();
			switch (key){
				case "show":
					stack.list ();
					break;
				case "push":
					System.out.println ("type your nums ~~");
					int value = scanner.nextInt ();
					stack.push (value);
					break;
				case "pop":
					try {
						int res = stack.pop ();
						System.out.printf ("出栈的数据是:%d\n",res);
					} catch (Exception e) {
						e.printStackTrace ();
					}
					break;
				case "exit":
					scanner.close ();
					loop = false;
					break;
				default:
					break;
			}
		}
		System.out.println ("程序退出");
	}
}
class NodeStack{

	class Node {// 定义节点
		private Node next;
		public int value;

		public Node () {
		}

		public Node (int value) {
			this.value = value;
		}
	}
    //top为头结点用于辅助入栈出栈
	Node top ;

	public NodeStack () {
		this.top = new Node ();
		top.next = null;
		top.value = 0;
	}
	//判断是否为空
	public boolean isEmpty(){
		return top.next == null;
	}
	//入栈 头插法入栈
	public void push(int value){
		Node element = new Node (value);
		if (top.next == null){
			top.next = element;
		}else {
			element.next = top.next;
			top.next = element;
		}
	}
	//出栈
	public int pop(){
		int ele;
		try {
			ele = top.next.value;
			//断链操作
			top.next = top.next.next;
		} catch (Exception e) {
			throw new RuntimeException ("栈为空，无法出栈");
		}

		return ele;
	}
	//返回栈的大小
	public int size(){
		Node temp = this.top;
		int i = 0;
		while (temp.next != null) {
			i++;
			temp = temp.next;
		}
		return i;
	}

	//输出栈
	public void list(){
		if (isEmpty ()) return;
		Node temp = this.top;
		while (temp.next!=null){
			System.out.printf ("stack=%d\n",temp.next.value);
			temp = temp.next;
		}
	}
}
//定义一个ArrayStack 表示栈
class ArrayStack {
	private int maxSize;
	private int[] stack;
	private  int top = -1;
    //defination
	public ArrayStack (int maxSize) {
		this.maxSize = maxSize;
		this.stack = new int[this.maxSize];
	}
	//栈满
	public boolean isFull(){
		return top == maxSize-1;
	}
	//栈空
	public boolean isEmpty(){
		return top ==-1;
	}
	//入栈
	public void  push(int value){
		if (isFull ()){
			System.out.println ("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}
	//出栈
	public int pop(){
		if (isEmpty ()){
			System.out.println ("栈空");
		}
		int value = stack[top];
		top-=1;
		return value;
	}
	public void list(){
		if (isEmpty ()){
			System.out.println ("栈空，没有数据");
			return;
		}
		for (int i = top; i >=0 ; i--) {
			System.out.printf ("stack[%d]=%d\n", i,stack[i]);
		}
	}
}

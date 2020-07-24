package dataStructures.hashTab;

import java.util.Scanner;

/**
 * @Author hike97
 * @Description hash散列演示
 * @create 2020-07-22 9:32
 * @Modified By:
 **/
public class HashTabDemo {
	public static void main (String[] args) {
		//创建哈希表
		HashTab hashTab = new HashTab(7);
		//写一个简单的菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("add:  添加雇员");
			System.out.println("list: 显示雇员");
			System.out.println("find: 查找雇员");
			System.out.println("del: 删除雇员");
			System.out.println("exit: 退出系统");

			key = scanner.next();
			switch (key) {
				case "add":
					System.out.println("输入id");
					int id = scanner.nextInt();
					System.out.println("输入名字");
					String name = scanner.next();
					//创建 雇员
					Emp emp = new Emp(id, name);
					hashTab.add(emp);
					break;
				case "list":
					hashTab.list();
					break;
				case "find":
					System.out.println("请输入要查找的id");
					id = scanner.nextInt();
					hashTab.findEmpById(id);
					break;
				case "del":
					System.out.println("请输入要删除的id");
					id = scanner.nextInt();
					hashTab.delEmpbyId (id);
					break;
				case "exit":
					scanner.close();
					System.exit(0);
				default:
					break;
			}
		}

	}
}
//创建实体
class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp (int id, String name) {
		this.id = id;
		this.name = name;
	}
}
//创建HashTab 管理多条链表
class HashTab {
	private EmpLinkedList[] empLinkedListArray;
	private int size ;

	public HashTab (int size) {
		this.size = size;
		empLinkedListArray = new EmpLinkedList[size];
		//不要忘记初始化链表
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkedList ();
		}
	}
	//添加雇员
	public void add(Emp emp){
		int empLinkedNO = hashFun (emp.id);
		//将emp 添加到对应的链表中
		empLinkedListArray[empLinkedNO].add (emp);
		//
	}
	//遍历hash表
	public void list(){
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i].list (i+1);
		}
	}
	//根据输入的Id,查找雇员
	public void findEmpById(int id) {
		int empLinkedListNo = hashFun (id);
		Emp emp = empLinkedListArray[empLinkedListNo].findEmpById (id);
		if (emp!=null){
			System.out.printf ("在第%d条链表中找到雇员 id = %d\n", empLinkedListNo + 1,id);
		}else{
			System.out.println ("在哈希表中，没有找到该雇员");
		}
	}
	//根据输入的Id,删除雇员
	public void delEmpbyId(int id) {
		int empLinkedListNo = hashFun (id);
		boolean emp = empLinkedListArray[empLinkedListNo].delEmpbyId (id);
		if (emp){
			System.out.printf (" 在第%d条链表中删除雇员 id = %d\n", empLinkedListNo + 1,id);
		}else{
			System.out.println ("在哈希表中，没有找到该雇员");
		}
	}
	//hash算法
	public int hashFun(int id){
		return id % size;
	}
}
//EmpLinkedList
class EmpLinkedList {
	private Emp head;//头指针 指向第一个Emp
	//添加
	public void add(Emp emp){
		if (head == null){
			head =  emp;
			return;
		}
		//不是第一个 辅助指针 定位到最后
		Emp curEmp = this.head;
		while (true) {
			if (curEmp.next == null) break;
			curEmp = curEmp.next;
		}
		//退出时将emp加在最后
		curEmp.next = emp;
	}
	//遍历链表的雇员信息
	public void list(int no){
		if (head == null){
			System.out.println ("第"+no+"链表为空");
			return;
		}
		System.out.print ("第"+no+"链表链表的信息为");
		Emp curEmp = head;//辅助指针
		while (true){
			System.out.printf ("=> id=%d name=%s\t", curEmp.id,curEmp.name);
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		System.out.println ();

	}

	public Emp findEmpById(int id){
		//判断链表是否为空
		if (head == null){
			System.out.println ("链表为空~");
			return null;
		}
		//辅助指针
		Emp curEmp = this.head;
		while (true){
			//找到
			if (curEmp.id == id) break;
			//没找到
			if (curEmp.next == null){
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;
		}
		return curEmp;

	}

	public boolean delEmpbyId(int id){
		boolean flag = false;
		if(head == null){
			return false;
		}else if (head.id == id){
			head = null;
			return true;
		}
		Emp preEmp = this.head;
		if (preEmp.next==null)return false;
		Emp curEmp = this.head.next;
		while (true) {
			if (curEmp.id == id){
				flag = true;
				break;
			}
			if (curEmp.next == null) {
				curEmp=null;
				break;
			}
			preEmp = curEmp;
			curEmp = curEmp.next;
		}
		if (flag){
			preEmp.next = curEmp.next;
		}
		return true;
	}

}

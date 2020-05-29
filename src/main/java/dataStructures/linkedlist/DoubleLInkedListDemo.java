package dataStructures.linkedlist;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-29 13:50
 * @Modified By:
 **/
public class DoubleLInkedListDemo {
}
class DoubleLinkedList {

	//先初始化一个头结点，头结点不要动，不存放具体的数据
	private HeroNode2 head = new HeroNode2 (0,"","");

	//返回头结点
	public HeroNode2 getHead(){
		return head;
	}

	//遍历双向链表
	public void list() {
		//判断链表事发后为空
		if (head.next == null)return;
		//辅助变量遍历
		HeroNode2 temp = head.next;
		while (true){
			//判断是否到最后
			if (temp==null) break;
			System.out.println (temp);
			temp = temp.next;

		}
	}
	//添加链表（默认添加到最后）
	public void add(HeroNode2 heroNode){
		//1.找到最后结点 最后结点的next -> 新结点
		//2.头节点不能动，需要
		HeroNode2 temp = head;
		while (true){
			//找到链表最后
			if (temp.next==null)break;
			temp = temp.next;
		}
		//形成一个双向链表
		temp.next= heroNode;
		heroNode.pre=temp;
	}
	//修改链表 双向链表节点内容修改和单向链表一样
	//只是改成heroNode2
	public void update(HeroNode2 newHeroNode){
		//判断是否为空
		if (head.next==null){
			System.out.println ("链表为空");
			return;
		}
		//
		HeroNode2 temp = this.head.next;
		boolean flag = false;//是否找到结点
		while (true){
			if (temp==null)break;
			if (temp.no==newHeroNode.no){
				flag=true;
				break;
			}
			temp = temp.next;
		}
		if (flag){
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		}else {
			System.out.printf ("没有找到编号%d的结点,不能修改\n",newHeroNode.no);
		}
	}
	
	//删除结点
	//删除
	public void delete(int no){
		if (head.next == null) return;
		HeroNode2 temp = head.next;
		boolean flag =  false;
		while (true){
			if (temp == null) break;
			if (temp.no==no){
				flag =true;
				break;
			}
			temp = temp.next;
		}
		if (flag){

		}

	}


}
class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;//指向下一个节点，默认为null
	public  HeroNode2 pre;//前一个节点，默认为null

	public HeroNode2(int no, String name, String nickname) {
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

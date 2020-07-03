package dataStructures.linkedlist;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-29 13:50
 * @Modified By:
 **/
public class DoubleLInkedListDemo {
	public static void main (String[] args) {
		System.out.println ("双向链表的测试");
		//先创建节点
		HeroNode2 hero1 = new HeroNode2 (1, "宋江", "及时雨");
		HeroNode2 hero2 = new HeroNode2 (2,"卢俊义","玉麒麟");
		HeroNode2 hero3 = new HeroNode2 (3,"公孙胜","入云龙");
		HeroNode2 hero4 = new HeroNode2 (5,"宁立恒","血手人屠");
		//创建一个双向链表
		DoubleLinkedList heroDoublelist = new DoubleLinkedList ();
		//添加
		heroDoublelist.add (hero1);
		heroDoublelist.add (hero2);
		heroDoublelist.add (hero3);
		heroDoublelist.add (hero4);
		//遍历
//		heroDoublelist.list ();
		HeroNode2 updateHero = new HeroNode2 (4, "铁剑河山", "陆红提");
//		//修改
//		System.out.println ("do update operation");
//		heroDoublelist.update (updateHero);
//		heroDoublelist.list ();
//		//删除
//		heroDoublelist.delete (4);
//		System.out.println ("do delete operation");
//		heroDoublelist.list ();

		//有序添加
		heroDoublelist.addByOrder (updateHero);
		System.out.println ("有序添加操作后~~");
		heroDoublelist.list ();
	}
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

	//根据顺序添加结点
	public  void addByOrder(HeroNode2 heroNode){
		HeroNode2 temp = this.head;
		boolean flag = false;//判断编号是否存在
		while (true){
			if (temp.next==null)break;//说明temp已经在链表的最后
			if (temp.no>heroNode.no){
				break;
			}else if (temp.no==heroNode.no){
				flag=true;
				break;
			}
			temp = temp.next;
		}
		//判断flag的值
		if (flag){
			System.out.printf ("编号%d已存在,不能加入\n",heroNode.no);
		}else {
            temp.pre.next=heroNode;
            heroNode.pre=temp.pre;
            heroNode.next=temp;
            temp.pre=heroNode;
		}
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

	/**
	 * 说明：
	 * 1.对于双向链表，我们可以直接找到要删除的这个节点
	 * 2.找到后，自我删除即可
	 */
	public void delete(int no){
		//判断当前链表是否为空
		if (head.next==null){
			System.out.println ("链表为空，无法删除");
			return;
		}
		HeroNode2 temp = head.next;//辅助变量（指针）
		boolean flag =  false;//标志时候找到 待删除节点
		while (true){
			if (temp == null) break;//已经找到链表最后节点的next;
			if (temp.no==no){
				flag =true;
				break;
			}
			temp = temp.next;
		}
		if (flag){
            temp.pre.next=temp.next;
            //这里我们的代码有问题
			/**
			 * 最后一个节点 temp.next 为空
			 */
			if (temp.next!=null)  temp.next.pre=temp.pre;
		}else{
			System.out.printf ("要删除的%d 节点不存在\n",no);
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

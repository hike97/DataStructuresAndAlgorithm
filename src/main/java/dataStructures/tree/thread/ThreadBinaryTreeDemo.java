package dataStructures.tree.thread;

import lombok.Data;

/**
 * @Author hike97
 * @Description
 * @create 2020-07-14 14:51
 * @Modified By:
 **/
public class ThreadBinaryTreeDemo {
	public static void main (String[] args) {
		HeroNode root  = new HeroNode (1,"tom");
		HeroNode node2  = new HeroNode (3,"jerry");
		HeroNode node3  = new HeroNode (6,"betty");
		HeroNode node4  = new HeroNode (8,"monika");
		HeroNode node5  = new HeroNode (10,"steve");
		HeroNode node6  = new HeroNode (14,"anna");

		//二叉树 后边我们要递归创建
		ThreadBinaryTree binaryTree = new ThreadBinaryTree ();
		root.setLeft (node2);
		root.setRight (node3);
		node2.setLeft (node4);
		node2.setRight (node5);
		node3.setLeft (node6);
		binaryTree.setRoot (root);
		binaryTree.threadedNodes (root);
		//测试：以10号结点 测试
		HeroNode left = node5.getLeft ();
		System.out.println ("前驱结点："+left);
		HeroNode right = node5.getRight ();
		System.out.println ("后继结点："+right);
		System.out.println ("使用线索化的方式遍历线索化二叉数");
		binaryTree.threadedList ();

	}
	
}
//实现了线索化功能的二叉树
class ThreadBinaryTree {
	HeroNode root;
	//为了实现线索化需要创建一个指向当前结点的前驱结点的指针
	HeroNode pre = null;
	public void setRoot (HeroNode root) {
		this.root = root;
	}
	public void threadNodes(){
		this.threadedNodes (root);
	}
	/**
	 * 遍历线索化二叉树
	 */
	public void threadedList(){
		//定一个变量，存储当前遍历的结点，从root开始
		HeroNode node = root;
		while (node!=null){
			//循环的找到leftType==1的结点，找到leftType==1时的结点
			while (node.getLeftType ()==0){
				node = node.getLeft ();
			}
			//打印当前这个结点
			System.out.println (node);
			//当前结点的右指针指向的是后继结点，就一直输出
			while (node.getRightType () == 1){
				//获取到当前结点的后继结点
				node = node.getRight ();
				System.out.println (node);
			}
			//替换遍历这个结点
			node =  node.getRight ();
		}

	}
	/**
	 * 中序二叉树线索化
	 */
	public void threadedNodes(HeroNode node	){
		if (node==null)return;
		//1.先线索化左子树
		threadedNodes (node.getLeft ());
		//2.线索化当前结点
			/**处理当前结点的前驱结点*/
		if (node.getLeft () == null){
			//让当前结点的左指针指向前驱结点
			node.setLeft (pre);
			node.setLeftType (1);//前驱结点
		}
			/**处理当前结点的后继结点*/
		if (pre !=null&&pre.getRight () == null){
			//让前驱结点的右指针指向当前结点
			pre.setRight (node);
			//修改前驱结点的右指针类型
			pre.setRightType (1);
		}
		/**
		 * 每处理一个结点后 让当前结点变成下一个节点的前驱结点。
		 */
		pre = node;
		//3.线索化右子树
		threadedNodes (node.getRight ());

	}
	public void order(String type){
		switch (type){
			case "front":
				root.preOrder ();
				break;
			case "mid":
				root.midOrder ();
				break;
			case "back":
				root.backOrder ();
				break;
		}
	}

	public HeroNode orderSearch(String type, int no){
		HeroNode resNode;
		switch (type){
			case "front":
				resNode = root.preOrderSearch (no);
				break;
			case "mid":
				resNode = root.infixOrderSearch (no);
				break;
			case "back":
				resNode = root.postOrderSearch (no);
				break;
			default:
				return null;
		}
		return resNode;
	}

	public void delNode(int no) {
		if (root != null){
			//如果是根结点 清空树
			if (root.getNo () == no){
				root=null;
			}else {
				root.delNode (no);
			}
		}else {
			System.out.println ("空树不能删除");
		}
	}

}
@Data
class HeroNode {
	private int no;
	private String name;
	private HeroNode left; //默认null
	private HeroNode right;//默认null
	private int leftType; //0表示左子树，1表示前驱
	private int rightType; //0表示右子树，1表示前驱
	public HeroNode (int no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString () {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				'}';
	}

	//编写前序遍历方法
	public void preOrder(){
		System.out.println (this);//先输出父结点
		//递归左子树前序遍历
		if (this.left!=null){
			this.left.preOrder ();
		}
		if (this.right!=null){
			this.right.preOrder ();
		}
	}
	//编写中序遍历方法
	public void midOrder(){
		if (this.left!=null){
			this.left.midOrder();
		}
		System.out.println (this);//先输出父结点
		//递归左子树前序遍历
		if (this.right!=null){
			this.right.midOrder();
		}
	}
	//编写后序遍历方法
	public void backOrder(){
		if (this.left!=null){
			this.left.backOrder();
		}
		//递归左子树前序遍历
		if (this.right!=null){
			this.right.backOrder();
		}
		System.out.println (this);//先输出父结点
	}

	//二叉树查询

	/**
	 * 前序遍历查找
	 * @param no
	 * @return
	 */
	public HeroNode preOrderSearch(int no){
		//比较当前结点是是不是
		System.out.println ("前序查找");
		if (this.no==no){
			return this;
		}
		//1.递归左子结点
		HeroNode resNode = null;
		if (this.left != null){
			resNode = this.left.preOrderSearch (no);
		}
		if (resNode!=null)return resNode;
		//2.递归右子结点
		if (this.right != null){
			resNode = this.right.preOrderSearch (no);
		}
		return resNode;
	}

	/**
	 * 中序遍历查找
	 * @param no
	 * @return
	 */
	public HeroNode infixOrderSearch(int no){
		HeroNode resNode = null;
		//1.递归左子结点
		if (this.left != null){
			resNode = this.left.infixOrderSearch (no);
		}
		if (resNode!=null)return resNode;
		//比较当前结点是是不是
		System.out.println ("中序查找");
		if (this.no==no){
			return this;
		}
		//2.递归右子结点
		if (this.right != null){
			resNode = this.right.infixOrderSearch (no);
		}
		return resNode;
	}

	public HeroNode postOrderSearch(int no){
		HeroNode resNode = null;
		//1.递归左子结点
		if (this.left != null){
			resNode = this.left.postOrderSearch (no);
		}
		if (resNode!=null)return resNode;
		//2.递归右子结点
		if (this.right != null){
			resNode = this.right.postOrderSearch (no);
		}
		if (resNode!=null)return resNode;
		//比较当前结点是是不是
		System.out.println ("后序查找");
		if (this.no==no){
			return this;
		}

		return resNode;
	}

	public void delNode(int no){
		if (this.left != null && this.left.no == no){
			this.left=null;
			return;
		}
		if (this.right != null && this.right.no == no){
			this.right=null;
			return;
		}
		if (this.left !=null) this.left.delNode (no);
		if (this.right !=null) this.right.delNode (no);
	}


}


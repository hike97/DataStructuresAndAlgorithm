package dataStructures.tree;

import lombok.Data;

/**
 * @Author hike97
 * @Description 二叉树
 * @create 2020-07-13 16:52
 * @Modified By:
 **/
public class BinaryTreeDemo {
	public static void main (String[] args) {
		//生成一个二叉树
		HeroNode root = new HeroNode  (1, "宋江");
		HeroNode node1 = new HeroNode (2, "卢俊义");
		HeroNode node2 = new HeroNode (3, "公孙胜");
		HeroNode node3 = new HeroNode (4, "吴用");
		HeroNode node4 = new HeroNode (5, "关胜");
		BinaryTree tree = new BinaryTree ();
		tree.setRoot (root);
		root.setLeft (node1);
		root.setRight (node2);
		node2.setLeft (node3);
		node2.setRight (node4);
//		System.out.println ("前序");
//		tree.order ("front");
//		System.out.println ("中序");
//		tree.order ("mid");
//		System.out.println ("后序");
//		tree.order ("back");
//		System.out.println ("查找 binaryTreeSearch");
//		System.out.println ("前序查询~~~~~~~~~~~~~~");
//		tree.orderSearch ("front",5);
//		System.out.println ("中序查询~~~~~~~~~~~~~~");
//		tree.orderSearch ("mid",5);
//		System.out.println ("后序查询~~~~~~~~~~~~~~");
//		tree.orderSearch ("back",5);
		//删除
		tree.order ("front");
		tree.delNode (4);
		tree.order ("front");

	}
}

class BinaryTree {
	HeroNode root;
	public void setRoot (HeroNode root) {
		this.root = root;
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

	public HeroNode orderSearch(String type,int no){
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

package dataStructures.tree.avl;

/**
 * @Author hike97
 * @Description
 * @create 2020-08-05 20:11
 * @Modified By:
 **/
public class AVLTreeDemo {
	public static void main (String[] args) {
//		int arr[]  = {4,3,6,5,7,8};
//		int arr[]  = {10,12,8,9,7,6};
		int arr[]  = {10,11,7,6,8,9};
		AVLTree avlTree = new AVLTree ();
		for (int i = 0; i < arr.length; i++) {
			avlTree.add (new Node (arr[i]));
		}
		avlTree.infixOrder ();
		System.out.println (avlTree.getRoot ().height ());
		System.out.println (avlTree.getRoot ().leftHeight ());
		System.out.println (avlTree.getRoot ().rightHeight ());
		System.out.println (avlTree.getRoot ());
	}
}
class AVLTree{

	private Node root;

	public Node getRoot () {
		return root;
	}

	//删除结点
	public void delNode (int value) {
		if (root == null) {
			return;
		} else {
			//1.seek 要删除的结点targetNode
			Node targetNode = search (value);
			if (targetNode == null) return;
			//如果发现二叉树只有一个结点
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			//查找targetNode的父结点
			Node parent = searchParent (value);
			//如果要删除的结点是叶子结点
			if (targetNode.left == null && targetNode.right == null) {
				if (parent.left != null && parent.left.value == value) {
					parent.left = null;
				} else if (parent.right != null && parent.right.value == value) {
					parent.right = null;
				}
				/*父结点有两颗子树*/
			} else if (targetNode.left != null && targetNode.right != null) {
				int minValue = delRightTreeMin (targetNode.right);
				targetNode.value = minValue;
			} else {
				/*只有一棵子树的结点*/
				if (targetNode.left != null) {
					//如果删除的结点只有左子节点 删除的结点是parent 的左节点
					if (parent != null) {
						if (parent.left.value == value) {
							parent.left = targetNode.left;
						} else {
							//左 右
							parent.right = targetNode.left;
						}
					} else {
						root = targetNode.left;
					}
				} else {
					if (parent != null) {
						//删除结点只有右节点 是parent的左节点
						if (parent.left.value == value) {
							parent.left = targetNode.right;
						} else {
							parent.right = targetNode.right;
						}
					} else {
						root = targetNode.right;
					}


				}

			}
		}

	}

	//删除右子树最小结点

	/**
	 * @param node
	 * @return
	 */
	public int delRightTreeMin (Node node) {
		Node target = node;
		//循环查左子结点，就会找到最小值
		while (target.left != null) {
			target = target.left;
		}
		//这时target指向最小结点
		delNode (target.value);
		return target.value;

	}

	//查找父节点
	public Node searchParent (int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent (value);
		}
	}

	//查找删除结点
	public Node search (int value) {
		if (root == null) {
			return null;
		} else {
			return root.search (value);
		}
	}

	//添加方法
	public void add (Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add (node);
		}
	}

	//中序遍历
	public void infixOrder () {
		if (root != null) {
			root.infixOrder ();
		} else {
			System.out.println ("二叉排序树为空，不能遍历");
		}
	}
}
class Node {
	int value;
	Node left;
	Node right;

	public Node (int value) {
		this.value = value;
	}
	//返回左子树的高度
	public int leftHeight(){
		if (left == null) return 0;
		return left.height ();
	}
	//返回右子树的高度
	public int rightHeight(){
		if (right == null) return 0;
		return right.height ();
	}
	//返回当前结点的高度，以该结点为根结点的树的高度
	public int height(){
		return Math.max (left == null?0:left.height (),right==null?0:right.height ())+1;
	}

	//左旋转方法
	private void leftRotate(){
		Node newNode = new Node (value);
		newNode.left = left;
		newNode.right = right.left;
		value = right.value;
		right = right.right;
		left  = newNode;

	}
	//右旋转
	public void rightRotate(){
		Node newNode = new Node (value);
		newNode.right = right;
		newNode.left = left.right;
		value = left.value;
		left = left.left;
		right = newNode;
	}

	//查找要删除的结点
	public Node search (int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value) {
			//如果左子结点为空
			if (this.left == null) return null;
			return this.left.search (value);
		} else {
			if (this.right == null) return null;
			return this.right.search (value);
		}
	}

	//查找要删除结点的父结点
	public Node searchParent (int value) {
		//如果当前结点就是删除结点的父结点，就返回
		if ((this.left != null && this.left.value == value) ||
				(this.right != null && this.right.value == value)) {
			return this;
		} else {
			//小于 向左递归查找
			if (value < this.value && this.left != null) {
				return this.left.searchParent (value);
			} else if (value >= this.value && this.right != null) {
				return this.right.searchParent (value);
			} else {
				return null;
			}
		}

	}

	@Override
	public String toString () {
		return "Node{" +
				"value=" + value +
				'}';
	}

	//添加结点方法
	public void add (Node node) {
		if (node == null) return;
		//判断传入的节点的值和当前
		if (node.value < this.value) {
			//左节点为空
			if (this.left == null) {
				this.left = node;
			} else {
				//递归插入左子树
				this.left.add (node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				//递归插入右子树
				this.right.add (node);
			}
		}
		//当添加完一个结点后，如果（右树高度-右树高度）
		if (rightHeight ()-leftHeight () > 1){
			if (right!=null&&right.leftHeight ()>right.rightHeight ()){
				right.rightRotate ();
				leftRotate ();
			}else {
				leftRotate ();
			}
			return;//必须要返回 否则会无限循环
		}
		if (leftHeight ()-rightHeight ()>1){
			//如果左子树的右子树大于左子树的左子树
			if (left!=null&&left.rightHeight ()>left.leftHeight ()){
				//先对当前结点的左结点进行左旋转
				left.leftRotate ();
				//在对对当前结点进行右旋转
				rightRotate ();
			}else {
				rightRotate ();
			}
		}
	}

	//中序遍历
	public void infixOrder () {
		if (this.left != null) this.left.infixOrder ();
		System.out.println (this);
		if (this.right != null) this.right.infixOrder ();
	}
}

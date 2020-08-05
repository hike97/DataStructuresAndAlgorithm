package dataStructures.tree.binary;


/**
 * @Author hike97
 * @Description 二叉排序树
 * @create 2020-08-04 18:35
 * @Modified By:
 **/
public class BinarySortTreeDemo {
	public static void main (String[] args) {
		int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
		BinarySortTree binarySortTree = new BinarySortTree ();
		//循环的添加结点到二叉排序树
		for (int i = 0; i < arr.length; i++) {
			binarySortTree.add (new Node (arr[i]));
		}

		//中序遍历二叉排序树
		System.out.println ("中序遍历二叉排序树~");
		binarySortTree.infixOrder (); // 1, 3, 5, 7, 9, 10, 12

		//测试删除叶子结点 2 5 9
		System.out.println ("删除后遍历二叉排序树~");
		binarySortTree.delNode (2);
		binarySortTree.delNode (7);
		binarySortTree.delNode (3);
		binarySortTree.delNode (5);
		binarySortTree.delNode (9);
		binarySortTree.delNode (12);
		binarySortTree.delNode (10);
		binarySortTree.delNode (1);
		binarySortTree.infixOrder ();
	}
}

//二叉排序树
class BinarySortTree {
	private Node root;

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
	}

	//中序遍历
	public void infixOrder () {
		if (this.left != null) this.left.infixOrder ();
		System.out.println (this);
		if (this.right != null) this.right.infixOrder ();
	}
}

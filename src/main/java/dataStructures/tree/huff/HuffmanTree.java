package dataStructures.tree.huff;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author hike97
 * @Description
 * 				赫夫曼树的创建
 * 			    wpl 带权路径长度
 * 				wpl最小的数叫做最优二叉树（赫夫曼树）
 * @create 2020-08-13 15:51
 * @Modified By:
 **/
public class HuffmanTree {
	public static void main (String[] args) {
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		Node root = createHuffmanTree(arr);

		//测试一把
		preOrder(root); //

	}
	//编写一个前序遍历的方法
	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else{
			System.out.println("是空树，不能遍历~~");
		}
	}
	//创建赫夫曼树的方法
	public static Node createHuffmanTree(int arr[]){
		List<Node> nodes = new ArrayList<> ();
		for (int value : arr) {
			nodes.add (new Node (value));
		}
		while (nodes.size () > 1) {
			//从小到大排序
			Collections.sort (nodes);
			System.out.println ("nodes = " + nodes);
			//取出前两个数
			Node left = nodes.get (0);
			Node right = nodes.get (1);
			Node parent = new Node (left.value + right.value);
			parent.left = left;
			parent.right = right;
			nodes.remove (left);
			nodes.remove (right);
			nodes.add (parent);
		}
		return nodes.get (0);

	}
}
// 创建结点类
// 为了让Node 对象持续排序Collections集合排序
// 让Node 实现Comparable接口
class Node implements Comparable<Node> {
	int value; // 结点权值
	char c; //字符
	Node left; // 指向左子结点
	Node right; // 指向右子结点

	//写一个前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}

	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// 表示从小到大排序
		return this.value - o.value;
	}

}

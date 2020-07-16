package dataStructures.tree;

/**
 * @Author hike97
 * @Description 顺序存储二叉树
 * @create 2020-07-14 11:02
 * @Modified By:
 **/
public class ArrBinaryTreeDemo {
	public static void main (String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		ArrBinaryTree tree = new ArrBinaryTree (arr);
		tree.order ("front");
		System.out.println ();
		tree.order ("mid");
		System.out.println ();
		tree.order ("back");
	}
}
//编写一个ArrBinaryTree 实现顺序存储
class ArrBinaryTree {
	private int [] arr;//存储数据节点的数组

	public ArrBinaryTree (int[] arr) {
		this.arr = arr;
	}
	//前序遍历顺序遍历二叉树
	public void order(String type){
		switch (type){
			case "front":
				this.preOrder (0);
				break;
			case "mid":
				this.midOrder (0);
				break;
			case "back":
				this.backOrder (0);
				break;
		}
	}

	/**
	 * 前序
	 * @param index
	 */
	public void preOrder(int index) {
		//如果数组为空，或者arr.length = 0
		if (arr == null || arr.length == 0){
			System.out.println ("数组为空，不能按照二叉树前序遍历");
		}
		//输出当前这个元素
		System.out.print (arr[index]+" ");
		//向左递归遍历
		if (index*2+1<arr.length){
			preOrder (2*index+1);
		}
		//向右递归遍历
		if (index*2+2<arr.length){
			preOrder (2*index+2);
		}
	}

	/**
	 * 中序
	 * @param index
	 */
	public void midOrder(int index) {
		//如果数组为空，或者arr.length = 0
		if (arr == null || arr.length == 0){
			System.out.println ("数组为空，不能按照二叉树前序遍历");
		}
		//向左递归遍历
		if (index*2+1<arr.length){
			midOrder (2*index+1);
		}
		//输出当前这个元素
		System.out.print (arr[index]+" ");
		//向右递归遍历
		if (index*2+2<arr.length){
			midOrder (2*index+2);
		}
	}

	/**
	 * 后序
	 * @param index
	 */
	public void backOrder(int index) {
		//如果数组为空，或者arr.length = 0
		if (arr == null || arr.length == 0){
			System.out.println ("数组为空，不能按照二叉树前序遍历");
		}
		//向左递归遍历
		if (index*2+1<arr.length){
			backOrder (2*index+1);
		}
		//向右递归遍历
		if (index*2+2<arr.length){
			backOrder (2*index+2);
		}
		//输出当前这个元素
		System.out.print (arr[index]+" ");
	}
}

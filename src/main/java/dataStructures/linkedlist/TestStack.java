package dataStructures.linkedlist;

import java.util.Stack;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-27 15:23
 * @Modified By: 演示栈的基本引用
 **/
public class TestStack {
	public static void main (String[] args) {
		Stack<String> stack = new Stack<> ();
		stack.add ("jack");
		stack.add ("tom");
		stack.add ("smith");

		while (stack.size ()>0){
			System.out.println (stack.pop ());
		}
	}
}

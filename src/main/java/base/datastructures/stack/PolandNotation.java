package base.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author hike97
 * @Description
 * @create 2020-07-08 16:33
 * @Modified By:
 **/
public class PolandNotation {
	public static void main (String[] args) {
		//将一个中缀表达式转成后缀表达式
		//说明
		//1.1+（（2+3）X4）-5 转成 123+4X+5-
		//2.直接对str进行操作，不方便，因此先将表达式变成一个数组
		String expression = "1+((2+3)*4)-5";
		List<String> list = tofixExpressionList (expression);
		System.out.println ("中缀表达式：" + list);
		//3.将一个中缀表达式转换成后缀表达式list
		List<String> suffix = parseSuffixExpressionList (list);
		System.out.println ("后缀表达式：" + suffix);
		//out :[1, 2, 3, +, 4, *, +, 5, -]

		//逆波兰计算
		int result = calculate (suffix);
		System.out.println ("结果是："+result);

	}

	/**
	 * method:中缀转后缀
	 */
	public static List<String> parseSuffixExpressionList (List<String> ls) {
		//定义两个栈
		Stack<String> s1 = new Stack<> ();//符号栈
		//		Stack<String> s2 = new Stack<> ();//存储中间结果栈（可用arrayList替换）
		List<String> s2 = new ArrayList<> ();
		for (String item : ls) {
			//如果是一个数 入栈s2
			if (item.matches ("\\d+")) {
				s2.add (item);
			} else if (item.equals ("(")) {
				s1.push (item);
			} else if (item.equals (")")) {
				//如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
				while (!s1.peek ().equals ("(")) {
					//s1的结果只要不等于左括号就出栈
					s2.add (s1.pop ());
				}
				s1.pop ();//将左括号弹出
			} else {
				//当item 的优先级小于等于栈顶的优先级
				//再次转到(4.1)与s1中新的栈顶运算符相比较
				while (s1.size () != 0 && Operation.getValue (s1.peek ()) >= Operation.getValue (item)) {
					s2.add (s1.pop ());
				}
				//还需要将item 压入栈中
				s1.push (item);
			}
		}
		//将s1 剩余的运算符一次弹出并加入s2
		while (s1.size () != 0) s2.add (s1.pop ());
		return s2;
	}

	/**
	 * method:将中缀表达式转成对应的list
	 */
	public static List<String> tofixExpressionList (String s) {
		List<String> ls = new ArrayList<> ();
		int i = 0;
		String str; //对多位数的拼接
		char c;
		String cs;
		do {
			//如果cs 是一个非数字 就需要加入到ls
			if ((cs = ("" + s.charAt (i))).matches ("\\D")) {
				ls.add (cs);
				i++;
			} else {
				//如果是一个数需要考虑多位数
				str = "";
				while (i < s.length () && (cs = ("" + s.charAt (i))).matches ("\\d")) {
					str += cs;//拼接
					i++;
				}
				ls.add (str);
			}

		} while (i < s.length ());
		return ls;
	}
	//逆波兰表达式
	public static int calculate (List<String> ls) {
		//创建个栈 只需要一个栈即可
		Stack<String> stack = new Stack<> ();
		//遍历ls
		for (String item : ls) {
			if (item.matches ("\\d+")) {
				//匹配的是数 入栈
				stack.push (item);
			} else {
				//否则pop出两个数，运算，再入栈
				int num2 = Integer.parseInt (stack.pop ());
				int num1 = Integer.parseInt (stack.pop ());
				int res = 0;
				if (item.equals ("+")) {
					res = num2 + num1;
				} else if (item.equals ("-")) {
					res = num1 - num2;
				} else if (item.equals ("*")) {
					res = num1 * num2;
				} else if (item.equals ("/")) {
					res = num1 / num2;
				} else {
					throw new RuntimeException ("运算符有误~");
				}
				//把res入栈
				stack.push ("" + res);
			}
		}
		return Integer.parseInt (stack.pop ());

	}
}

/**
 * 编写一个类Operation 可以返回一运算符对应的优先级
 */
class Operation {
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	//写一个方法 返回对应的优先级数字
	public static int getValue (String operation) {
		int result = 0;
		switch (operation) {
			case "+":
				result = ADD;
				break;
			case "-":
				result = SUB;
				break;
			case "*":
				result = MUL;
				break;
			case "/":
				result = DIV;
				break;
			default:
				System.out.println ("不存在的运算符~");
				break;
		}
		return result;
	}
}

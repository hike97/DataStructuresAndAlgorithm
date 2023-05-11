package base.datastructures.stack;

/**
 * @Author hike97
 * @Description
 * @create 2020-06-28 16:36
 * @Modified By:
 **/
public class Calculator {
	public static void main (String[] args) {
		String expression = "30+2*6-2";
		ArrayStack2 numStack = new ArrayStack2 (10);
		ArrayStack2 operStack = new ArrayStack2 (10);
		//定义需求的相关变量
		int index = 0;//用于扫描
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';//将每次扫描得到char保存到ch
		String keepNum = "";
		while (true) {
			//依次得到expression 的每一个字符
			ch = expression.substring (index, index + 1).charAt (0);
			//判断ch类型，然后做相应的处理
			//如果是运算符
			if (operStack.isOperation (ch)) {
				//判断当前的符号栈是否为空
				if (!operStack.isEmpty ()) {
					//如果符号栈有操作符，就进行比较
					//如果当前的操作符的优先级小于或者等于占中的操作符，就需要从栈中pop两个数，
					//再从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，将打那个钱的操作符入符号栈
					if (operStack.priority (ch) <= operStack.priority (operStack.peek ())) {
						num1 = numStack.pop ();
						num2 = numStack.pop ();
						oper = operStack.pop ();
						res = numStack.cal (num1, num2, oper);
						//然后把运算的结果入树栈
						numStack.push (res);
						//将当前的操作符入符号栈
						operStack.push (ch);
					} else {
						//如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈。
						operStack.push (ch);
					}
				} else {
					//如果为空直接入栈。。
					operStack.push (ch);
				}

			} else {
				//如果是数，则直接入树栈
				//由于数字和asc码表的数据相差48 字符串1 的char为49 所以应该减48
				//				numStack.push (ch - 48);
				//分析思路
				//1.当处理多位数时，不能发现是一个数就入栈
				//2.处理数，需要向expression表达式的index后一位，直到是运算符位置
				//3.因此需要定义一个变量 字符串，用于拼接
				/**累加*/
				keepNum += ch;
				/**如果ch已经是expression的最后一位，就直接入栈*/
				if (index == expression.length () - 1) {
					numStack.push (Integer.parseInt (keepNum));
				} else {
					//判断下一个字符是不是数字，是数字继续扫描，运算符，入栈
					//是后一位，不是index++,不改变index
					if (operStack.isOperation (expression.substring (index + 1, index + 2).charAt (0))) {
						numStack.push (Integer.parseInt (keepNum));
						//keepNum 清空
						keepNum = "";
					}
				}
			}
			//index+1 判断是否扫描到expression的最后
			index++;
			if (index >= expression.length ()) {
				break;
			}

		}
		//当表达式扫描完毕，将顺序的从数栈和符号中pop出相应的数和符号，并运行
		while (true) {
			//如果符号栈为空，则计算到最后的结果，数栈中只有一个数字
			if (operStack.isEmpty ()) {
				break;
			}
			num1 = numStack.pop ();
			num2 = numStack.pop ();
			oper = operStack.pop ();
			res = numStack.cal (num1, num2, oper);
			numStack.push (res);
		}
		System.out.printf ("表达式%s = %d", expression, numStack.pop ());

	}

}

//增加一些功能
class ArrayStack2 {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	// 增加一个方法，返回当前栈顶的值，但是不是真正的pop
	public int peek () {
		return stack[top];
	}

	//defination
	public ArrayStack2 (int maxSize) {
		this.maxSize = maxSize;
		this.stack = new int[this.maxSize];
	}

	//栈满
	public boolean isFull () {
		return top == maxSize - 1;
	}

	//栈空
	public boolean isEmpty () {
		return top == -1;
	}

	//入栈
	public void push (int value) {
		if (isFull ()) {
			System.out.println ("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}

	//出栈
	public int pop () {
		if (isEmpty ()) {
			System.out.println ("栈空");
		}
		int value = stack[top];
		top -= 1;
		return value;
	}

	public void list () {
		if (isEmpty ()) {
			System.out.println ("栈空，没有数据");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf ("stack[%d]=%d\n", i, stack[i]);
		}
	}

	//返回运算符的优先级，优先级由程序员确定
	public int priority (int operation) {
		if (operation == '*' || operation == '/') {
			return 1;

		} else if (operation == '+' || operation == '-') {
			return 0;
		}
		return -1;
	}

	//判断是不是一个运算符
	public boolean isOperation (char val) {
		return
				val == '+' ||
						val == '-' ||
						val == '*' ||
						val == '/';
	}

	//计算方法
	public int cal (int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num2 / num1;
				break;
			default:
				break;
		}
		return res;
	}
}

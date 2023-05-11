package base.datastructures.queue;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-09 16:57
 * @Modified By:
 **/
public class CircleArrayQueue {
	private int maxSize;//表示数组最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;//该数据用于存放数据，模拟队列
	//创建队列的构造器
	public CircleArrayQueue(int arrMaxSize){
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}

	//判断队列是否满
	public boolean isFull() {
		return (rear+1)%maxSize == front;
	}

	//判断队列是否为空
	public boolean isEmpty() {
		return  rear == front;
	}
	//添加数据到队列
	public void  addQueue(int n){
		//判断队列是否满
		if (isFull ()){
			System.out.println ("队列满，不能加入数据");
			return;
		}
		//rear
		arr[rear] = n;
		//将rear后移，这里将取模
		rear =  (rear+1)%maxSize;
	}
	//获取队列数据
	public int getQueue(){
		//判断队列是否空
		if (isEmpty ()){
			throw new RuntimeException ("队列空，不能取数据");//throw 本身导致代码return
		}
		//front 指向队列的第一个元素
		int value = arr[front];
		front=(front+1)%maxSize;
		return value;
	}
	//求出当前队列有效的个数
	public int size(){
		return (rear+maxSize-front)%maxSize;
	}
	//显示队列的所有数据
	public  void  showQueue(){
		//遍历
		if (isEmpty ()){
			System.out.println ("队列为空，没有数据····");
			return;
		}
		//从 front 开始遍历 遍历多少个元素
		for (int i = front; i < front+size (); i++) {
			System.out.printf ("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
		}
	}
	//显示队列的头数据是多少，不是取出数据
	public  int headQueue(){
		//判断是否为空
		if (isEmpty ()){
			throw new RuntimeException ("队列为空，没有数据~~");
		}
		return arr[front];
	}
}

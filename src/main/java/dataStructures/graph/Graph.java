package dataStructures.graph;

import thinkingInjava.innerclasses.exercise6b.SimpleClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author hike97
 * @Description
 * @create 2020-07-23 17:20
 * @Modified By:
 **/
public class Graph {
	private List<String> vertexList;//存储顶点集合
	private int [][] edges;//存储图对应的邻接矩阵
	private int numOfEdges;//边的个数
	private boolean[] isVisited;

	public static void main (String[] args) {
		//测试一把图是否创建
//		String Vertexs[] = {"A", "B", "C", "D", "E"};
		String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
		Graph graph = new Graph (8);
		for (String vertex : Vertexs) {
			graph.insertVertex (vertex);
		}
		//添加边
		//A-B A-C B-C B-D B-E
//		graph.insertEdge(0, 1, 1); // A-B
//		graph.insertEdge(0, 2, 1); //
//		graph.insertEdge(1, 2, 1); //
//		graph.insertEdge(1, 3, 1); //
//		graph.insertEdge(1, 4, 1); //

		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(2, 5, 1);
		graph.insertEdge(2, 6, 1);
		graph.insertEdge(5, 6, 1);

		graph.showGraph ();
		System.out.println ("dfs 深度遍历");
		graph.dfs ();
		System.out.println ();
		System.out.println ("bfs 广度遍历");
		graph.bfs ();

	}
	//构造器
	public Graph (int n) {
		this.vertexList = new ArrayList<> ();
		this.edges = new int[n][n];
		this.numOfEdges = 0;
	}
	//添加边
	public void insertEdge(int v1,int v2,int weight){
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	//图中常用的方法
	//返回结点的个数
	public int getNumOfVertex() {
		return vertexList.size();
	}
	//显示图对应的矩阵
	public void showGraph() {
		for(int[] link : edges) {
			System.err.println(Arrays.toString(link));
		}
	}
	//得到边的数目
	public int getNumOfEdges() {
		return numOfEdges;
	}
	//返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	//返回v1和v2的权值
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}
	//插入结点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}

	/**
	 * 查找第一个邻接点的下标，否则返回-1
	 * @param index
	 * @return
	 */
	public int getFirstNeighbor(int index) {
		for(int j = 0; j < vertexList.size(); j++) {
			if(edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	/**
	 * 根据前一个邻接节点的下标来获取下一个邻接节点
	 * @param v1
	 * @param v2
	 * @return
	 */
	public int getNextNeighbor(int v1,int v2){
		for (int j = v2+1; j < vertexList.size (); j++) {
			if (edges[v1][j]>0){
				return j;
			}
		}
		return -1;
	}

	//深度优先遍历算法一个顶点
	private void dfs(boolean[] isVisited,int i){
		//访问当前节点并输出
		System.out.print (getValueByIndex (i) + "->");
		isVisited[i] = true;
		//查找第一个邻接节点w
		int w = getFirstNeighbor (i);
		while (w != -1){
			if (!isVisited[w]){
				dfs (isVisited,w);
			}
			w = getNextNeighbor (i,w);
		}
	}
	//深度-所有顶点遍历
	public void dfs(){
		isVisited = new boolean[vertexList.size ()];
		for (int i = 0; i < getNumOfVertex (); i++) {
			if (!isVisited[i])dfs (isVisited,i);
		}
	}

	//广度遍历 一个顶点
	private void bfs(boolean[] isVisited,int i){
		int u ; // 表示队列的头结点对应下标
		int w ; // 邻接结点w
		//队列，记录结点访问的顺序
		LinkedList queue = new LinkedList();
		//访问结点，输出结点信息
		System.out.print(getValueByIndex(i) + "=>");
		//标记为已访问
		isVisited[i] = true;
		//将结点加入队列
		queue.addLast(i);
		while (!queue.isEmpty ()){
			u = (int) queue.removeFirst ();
			//找到第一个邻接点的下标w
			w = getFirstNeighbor (u);
			while (w !=-1){
				if (!isVisited[w]){
					System.out.print(getValueByIndex(w) + "=>");
					//标记为已访问
					isVisited[w] = true;
					//将结点加入队列
					queue.addLast(w);
				}
				//如果w已经被访问，查找当前顶点邻接点的下一个邻接点
				w = getNextNeighbor (u, w);
			}
		}
	}

	//遍历所有的结点，都进行广度优先搜索
	public void bfs(){
		isVisited = new boolean[vertexList.size ()];
		for (int i = 0; i < getNumOfVertex (); i++) {
			if (!isVisited[i])bfs (isVisited,i);
		}
	}
}

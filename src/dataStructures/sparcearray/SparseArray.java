package dataStructures.sparcearray;

import java.io.*;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2019-07-27 18:27
 * @desc 稀疏数组
 **/
public class SparseArray {
	/**
	 * 记录数组一共有几行几列 有多少不同的值
	 * 把不同值的元素行列记录在一个小规模数组里 缩小程序规模
	 */
	public static void main (String[] args) {
		//创建一个原始的二维数组11*11
		//0:表示没有棋子 1，表示黑子 2表示篮子
		int chessArr1 [][] = new int [11][11];
		//(2,3) (3,4)有两个棋子 黑 蓝
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;
		System.out.println ("原始数组：》》》》》》");
		for (int[] row : chessArr1) {
			for (int data : row) {
				System.out.printf ("%d\t",data);
			}
			System.out.println ();
		}

		/**
		 * 将二维数组得到非0数据的个数
		 */
		//1.先遍历二维数组，得到非0数据的个数
		int sum = 0;
		for (int i = 0; i <11 ; i++) {
			for (int j = 0; j <11 ; j++) {
				if (chessArr1[i][j] !=0) {
					sum++;
				}
			}
		}
		System.out.println (sum);
		//2.创建稀疏数组
		int[][] sparseArr = new int[sum + 1][3];
		//给稀疏数组赋值
		/*给第一行赋值*/
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		//遍历二维数组 赋值
		int count = 0 ;//count用于记录是第几个非0数据 就是稀疏数组的行坐标
		for (int i = 0; i <11 ; i++) {
			for (int j = 0; j <11 ; j++) {
				if (chessArr1[i][j] !=0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}
		System.out.println ();
		System.out.println ("得到的稀疏数组为~~~~");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf ("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		System.out.println ();
		//3.稀疏数组转为二维数组
		//先读取第一行创建二维数组
		int [][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

		//稀疏数组还原二维数组
		for (int i = 1; i <sparseArr.length ; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		//输出恢复后的二维数组
		System.out.println ("恢复后的二维数组");
		for (int[] row : chessArr2) {
			for (int data : row) {
				System.out.printf ("%d\t",data);
			}
			System.out.println ();
		}
		saveParseArray (sparseArr);
		getParseArray();

	}

	public static void saveParseArray(int sparseArr[][]){
		try {
			String filePath = "D:/io/map.data";
			File dir = new File ("D:/io");
			if (!dir.exists ()){
				dir.mkdir ();
				File file = new File (filePath);
				file.createNewFile ();
				ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (file));
				oos.writeObject (sparseArr);
				oos.close ();
			}
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}

	public static void getParseArray(){
		try {
			FileInputStream fis = new FileInputStream (new File ("D:/io/map.data"));
			ObjectInputStream ois = new ObjectInputStream (fis);
			Object o = ois.readObject ();
			System.out.println (o);
			int sparseArr[][] = (int[][]) o;
			for (int i = 0; i < sparseArr.length; i++) {
				System.out.printf ("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
			}
		} catch (IOException e) {
			e.printStackTrace ();
		} catch (ClassNotFoundException e) {
			e.printStackTrace ();
		}
	}
}

package leetcode;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-12 9:47
 * @Modified By: 旋转nxn2维数组
 **/
public class Rotate2 {
	public static void main (String[] args) {
		int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		int [][] matrix_=new int[matrix.length][matrix.length];
//		for (int i = 0; i < matrix.length; i++) {
//			System.arraycopy (matrix[i],0,matrix_[i],0,matrix_.length);
//		}
//		for (int i = 0; i < matrix_.length; i++) {
//			int scope = matrix_.length-1;
//			for (int j = 0; j < matrix_.length; j++) {
//				matrix[i][j]=matrix_[scope--][i];
//				System.out.printf ("%d\t",matrix[i][j]);
//			}
//			System.out.println ();
//		}
		//先上下翻转 翻转次数为length/2
		int len = matrix.length;
		for (int i = 0; i < len/2; i++) {
			int [] temp =  matrix[i];
			matrix[i] = matrix[len-1-i];
			matrix[len-1-i]=temp;
		}
		printArr (matrix);
        //根据对角线交换两个变量
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i+1; j < len; j++) {
				int temp = matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		printArr (matrix);

	}
	static void printArr(int arr[][]){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <arr.length ; j++) {
				System.out.printf ("%d\t",arr[i][j]);
			}
			System.out.println ();
		}
	}
}

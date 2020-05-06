package dataStructures.work;

/**
 * @Author hike97
 * @Description
 * @create 2020-04-30 15:07
 * @Modified By:
 **/
public class Fbi {
	static int generateFbi(int i){
		if (i<2) return i==0?0:1;
		return generateFbi (i-1)+generateFbi(i-2);
	}
	public static void main (String[] args) {
		for (int i = 0; i < 40; i++) {
			System.out.printf ("%d ",generateFbi (i));
		}
	}
}

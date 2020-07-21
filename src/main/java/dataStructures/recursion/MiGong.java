package dataStructures.recursion;

/**
 * @Author hike97
 * @Description
 * @create 2020-07-16 19:23
 * @Modified By:
 **/
public class MiGong {
	public static void main (String[] args) {
		//先创建一个二维数组 模拟迷宫
		//地图
		int[][] map = new int[8][7];
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print (map[i][j] + " ");
			}
			System.out.println ();
		}
		//递归回溯
		setWay (map,1,1);
		//输出新的地图
		System.out.println ("小球走过并并标识过的地图");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print (map[i][j] + " ");
			}
			System.out.println ();
		}

	}

	/**
	 * 到[6][5] 位置，说明通路找到。
	 * map为 0 没走过 1 墙 2 表示路径 3 表示该点已经走过但是走不通
	 * 在走迷宫时需要确定一个策略 先走下-右-上-左
	 *
	 * @param map 表示地图
	 * @param i   从哪个位置开始找
	 * @param j
	 * @return 找到返回true 否则false
	 */
	public static boolean setWay (int[][] map, int i, int j) {
		if (map[6][5] == 2) {//通路已经找到ok
			return true;
		} else {
			if (map[i][j] == 0) {
				//按照策略 下右上左 走
				//假设改点可以走通
				map[i][j] = 2;
				if (setWay (map, i + 1, j)) {//向下走
					return true;
				} else if (setWay (map, i, j + 1)) {//向右走
					return true;
				} else if (setWay (map, i - 1, j)) {//向上
					return true;
				} else if (setWay (map, i, j - 1)) {//向左走
					return true;
				} else {
					//说明该带点走不通，是死路
					map[i][j] = 3;
					return false;
				}
			} else {
				//可能是123
				return false;

			}
		}
	}
}

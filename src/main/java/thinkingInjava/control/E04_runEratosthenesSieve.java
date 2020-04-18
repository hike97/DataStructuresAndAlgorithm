package thinkingInjava.control;

/**
 * @author hike97 許せ　サスケ　これで最後だ
 * @create 2020-03-10 22:18
 * @desc 根据e04 衍生的埃拉托色尼筛选算法
 * 详情请见https://blog.csdn.net/xiaoquantouer/article/details/51817803?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 **/
public class E04_runEratosthenesSieve {

	public static void runEratosthenesSieve (int upperBound) {
		int upperBoundSquareRoot = (int) Math.sqrt (upperBound);
		boolean[] isComposite = new boolean[upperBound + 1];

		for (int m = 2; m <= upperBoundSquareRoot; m++) {
			if (!isComposite[m]) {
				System.out.print (m + " ");
				for (int k = m * m; k <= upperBound; k += m)
					isComposite[k] = true;
			}
		}

		for (int m = upperBoundSquareRoot; m <= upperBound; m++)
			if (!isComposite[m])
				System.out.print (m + " ");
	}

	public static void main (String[] args) {
		runEratosthenesSieve (100);
	}
}

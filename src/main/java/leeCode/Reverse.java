package leeCode;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-08 15:11
 * @Modified By: 反转
 **/
public class Reverse {
	public static int power(int a , int b) {
		int power = 1;
		for (int c = 0; c < b; c++)
			power *= a;
		return power;
	}
	public static int reverse(int x) {
		if (x>Integer.MAX_VALUE||x<Integer.MIN_VALUE) return 0;
		//2.在判断这个数有多少位
		//1位数和0返回本身
		int xtemp = x ;
		int digits;
		int count = 0;
		if (xtemp<0)xtemp=-xtemp;
		while (xtemp>=1){
			xtemp=xtemp/10;
			count++;
		}
		digits=count;
		if(digits==0){
			return 0;
		}else{
			//反转操作
			double result = 0;
			int j = digits-1;
			for(int i=1;i<=digits;i++){
				int bit = (int) (x % (Math.pow (10, i))/Math.pow(10,i-1));
				int pow = (int) Math.pow (10, j--);
				double resultTemp = Double.valueOf (bit) * Double.valueOf (pow);
				result +=resultTemp;
				if (result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) return 0;
			}
			return (int) result;
		}


	}
	public static int reverseDemo(int x) {
		long rs = 0;
		while(x != 0){
			rs = rs*10+x%10;
			x /= 10;
		}
		return (rs<Integer.MIN_VALUE || rs>Integer.MAX_VALUE) ? 0:(int)rs;
	}

	public static void main (String[] args) {
//		int i = 2147483651;
//		System.out.println (-2147483412 % Math.pow (10, 10));
//		System.out.println (123 % 100 / 10);
//		System.out.println (123 % 1000 / 100);
//		System.out.println (-2147483412 % (Math.pow (10, 10)) / Math.pow (10, 9));
//		System.out.println (reverse (1563847412));
		System.out.println (reverseDemo (1563847412));

	}
}

package leetcode;

/**
 * @Author hike97
 * @Description
 * @create 2020-06-09 16:33
 * @Modified By:
 **/
public class KMPAlgorithm {
	public static void main (String[] args) {
		 String str1= "BBC ABCDAB ABCDABCDABDE";
		 String str2="ABCDABD";
		int i = violentMatch (str1, str2);
		System.out.println (i);
	}
	//1.暴力匹配法
	static int violentMatch(String str1,String str2){
		char[] s = str1.toCharArray ();
		char[] p = str2.toCharArray ();
		int i = 0;
		int j = 0;
		while (i <s.length&& j<p.length){
			if (s[i]==p[j]){
				i++;
				j++;
			}else {
				i=i-j+1;
				j=0;
			}
		}
		if (j == p.length) {
			return i-j;
		}else {
			return -1;
		}
	}
	//获取一个字符串的部分匹配值表
	static int[] kmpNext(String dest){
		int[] next = new int[dest.length ()];
		next[0]=0;//长度为1，部分匹配值就是0
		for (int i = 0; i < dest.length (); i++) {
			
		}
		return next;
	}
}

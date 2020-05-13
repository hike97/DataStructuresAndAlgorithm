package leeCode;

import java.util.Arrays;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-06 16:23
 * @Modified By:
 **/
public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums){
		if (nums==null||nums.length==0)return 0;
		int j = 0;//起始位置
		for (int i = 1; i < nums.length; i++) {//起始位置+1
            if (nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
			}
		}
		System.out.println (Arrays.toString (nums));
		return j+1;
	}
	public static void main (String[] args) {
//            int[] nums = {0,0,1,1,2};
		    int [] nums = {0,0,1,1,1,2,2,3,3,4};
		    int end = removeDuplicates (nums);
		    System.out.println (end);
	}
}

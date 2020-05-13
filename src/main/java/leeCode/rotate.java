package leeCode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-09 14:02
 * @Modified By: 旋转数组
 **/
public class rotate {
	public static void main (String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
//		//先旋转一次
//		for (int j = 0; j <3 ; j++) {
//			int temp;
//			temp=nums[nums.length-1];
//			for (int i=nums.length-1;i>0;i--){
//				nums[i]=nums[i-1];
//			}
//			nums[0]=temp;
//		}

//		Deque<Integer> queue = new ArrayDeque<> ();
//		for (int num : nums) {
//			queue.add (num);
//		}
//		for (int i = 0; i < 3; i++) {
//			Integer last = queue.removeLast ();
//			queue.addFirst (last);
//		}
//		for (int i = 0; i < queue.size (); i++) {
//			nums[i]=((LinkedList<Integer>) queue).get (i);
//		}
		int result[] = new int[nums.length];
		int k = 3;
		for (int i = 0; i < nums.length; i++) {
			result[(i+k)%nums.length]=nums[i];
		}
		System.arraycopy (result,0,nums,0,nums.length);

		System.out.println (Arrays.toString (nums));
	}
}

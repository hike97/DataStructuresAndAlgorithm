package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-07 16:34
 * @Modified By:
 **/
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for(int i = 0;i<nums.length;i++){
			for(int j = i+1;j<nums.length;j++){
				if(nums[i]==target-nums[j]){
					result[0]=i;
					result[1]=j;
					return result;
				}
			}
		}
		return null;
	}

	public static void main (String[] args) {
		int [] nums =  {2,5,5,11};
		int target = 10;
		int[] result = twoSumMap(nums, target);
		System.out.println(Arrays.toString(result));
	}

	public static int[] twoSumMap(int[] numbers,int target){
		Map<Integer, Integer> map =  new HashMap<>(numbers.length);
		int [] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int expectVal = target - numbers[i];
			if (map.containsKey(expectVal)) {
				result[0] = map.get(expectVal);
				result[1] = i + 1;
				return result;
			}
			if (!map.containsKey(numbers[i])) {
				map.put(numbers[i], i + 1);
			}
		}
		return result;
	}
}

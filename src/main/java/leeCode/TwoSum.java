package leeCode;

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
//		int target = 10;
//		int[] result = twoSum (nums, 10);
//		System.out.println (Arrays.toString (result));
//		HashMap<Object, Object> map = new HashMap<> ();
//		Arrays.stream (nums).skip (2).forEach (System.out::print);
		int i = -123;
		i=-i;
		System.out.println (i);

	}
}

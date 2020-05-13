package leeCode;

import java.util.HashMap;

/**
 * @Author hike97
 * @Description 判断元素重复
 * @create 2020-05-07 15:42
 * @Modified By:
 **/
public class ContainsDuplicate {
		public boolean containsDuplicate(int[] nums) {
			HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
			for(int i=0;i<nums.length;i++){
				if(map.containsKey(nums[i])){//这个数已经出现过一次
					return true;
				}
				else{
					map.put(nums[i],i);
				}
			}
			return false;
		}


}

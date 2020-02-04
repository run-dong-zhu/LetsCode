package searching_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 560, Level: Medium
 * 
 * Given an array of integers and an integer k, 
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */
public class LeetCode560_SubarraySumEqualsK {
	
	public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // When map contains a (sum -k) means there is a sum = k, subarray
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

	public static void main(String[] args) {
		LeetCode560_SubarraySumEqualsK obj = new LeetCode560_SubarraySumEqualsK();
		
		int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
		int k = 7;
		
		System.out.println(obj.subarraySum(nums, k));
	}

}

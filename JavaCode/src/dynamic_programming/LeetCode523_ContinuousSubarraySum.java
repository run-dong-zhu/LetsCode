package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 523, Level: Medium
 * 
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray 
 * of size at least 2 that sums up to a multiple of k, that is, 
 * sums up to n*k where n is also an integer.
 * 
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 */
public class LeetCode523_ContinuousSubarraySum {
    
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // init map for case e.g. [1, 5], k = 6
        map.put(0, -1);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if(k != 0) {
                sum = sum % k;;
            }
            
            /* a % k = x
               b % k = x
               (a - b) % k = x -x = 0
               here a - b = the sum between i and j.
            */
            if(map.containsKey(sum)) {
                if(i - map.get(sum) > 1) {
                    return true;
                }
            }
            else {
                map.put(sum, i);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        LeetCode523_ContinuousSubarraySum obj = new LeetCode523_ContinuousSubarraySum();
        int[] nums = {2, 5, 33, 6, 7, 25, 15};
        
        System.out.println(obj.checkSubarraySum(nums, 13));
    }

}

package array_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 128, Level: Hard
 * 
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LeetCode128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();    
        int max = 0;
        for(int num : nums) {
            if(map.containsKey(num)) {
                continue;
            }
            
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            max = Math.max(max, sum);
            
            // control the window for consecutive sequence
            if(left > 0) {
                map.put(num - left, sum);
            }
            
            if(right > 0) {
                map.put(num + right, sum);
            }
            map.put(num, sum);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        LeetCode128_LongestConsecutiveSequence obj = new LeetCode128_LongestConsecutiveSequence();

        int[] nums = {100, 4, 101, 2, 3, 1};
        
        System.out.println(obj.longestConsecutive(nums));
    }
}

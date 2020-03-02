package greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 659, Level: Medium
 *
 * Given an array nums sorted in ascending order, return true if and only if you can split it into 
 * 1 or more subsequences such that each subsequence consists of consecutive integers and has length at least 3.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,3,4,5]
 * Output: True
 * 
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3
 * 3, 4, 5
 */
public class LeetCode659_SplitArrayIntoConsecutiveSubsequences {
	
//	public boolean isPossible(int[] nums) {
//        if(nums.length < 3)
//            return false;
//        
//        int pre = Integer.MIN_VALUE;
//    	int p1 = 0;
//    	int p2 = 0;
//    	int p3 = 0;
//    	
//        int cur = 0;
//    	int cnt = 0;
//    	int c1 = 0;
//    	int c2 = 0;
//    	int c3 = 0;
//            
//        for (int i = 0; i < nums.length; pre = cur, p1 = c1, p2 = c2, p3 = c3) {
//            for (cur = nums[i], cnt = 0; i < nums.length && cur == nums[i]; i++) {
//    			cnt++;
//    		}
//            
//            if (cur != pre + 1) {
//                if (p1 != 0 || p2 != 0) {
//    				return false;
//    			}
//    			
//                c1 = cnt;
//    			c2 = 0;
//    			c3 = 0;
//                
//            } else {
//                if (cnt < p1 + p2) {
//    				return false;
//    			}
//    			
//                c1 = Math.max(0, cnt - (p1 + p2 + p3));
//                c2 = p1;
//                c3 = p2 + Math.min(p3, cnt - (p1 + p2));
//            }
//        }
//        
//        return (p1 == 0 && p2 == 0); 
//    }
	
	public boolean isPossible(int[] nums) {
        if(nums.length < 3)
            return false;
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> appendMap = new HashMap<>(); // handle len 3+
        
        for(int num : nums) {
        	frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        for(int num : nums) {
        	if(frequencyMap.get(num) == 0) {
        		continue;
        	}
        	else if(appendMap.getOrDefault(num, 0) > 0) {
        		appendMap.put(num, appendMap.get(num) - 1);
        		appendMap.put(num + 1, appendMap.getOrDefault(num + 1, 0) + 1);
        	}
        	else if(frequencyMap.getOrDefault(num + 1, 0) > 0 
        			&& frequencyMap.getOrDefault(num + 2, 0) > 0) {
        		frequencyMap.put(num + 1, frequencyMap.get(num + 1) - 1);
        		frequencyMap.put(num + 2, frequencyMap.get(num + 2) - 1);
        		appendMap.put(num + 3, appendMap.getOrDefault(num + 3, 0) + 1);
        	}
        	else {
        		return false;
        	}
        	frequencyMap.put(num, frequencyMap.get(num) - 1);
        }
        
        return true; 
    }

	public static void main(String[] args) {
		LeetCode659_SplitArrayIntoConsecutiveSubsequences obj = new LeetCode659_SplitArrayIntoConsecutiveSubsequences();

//		int[] nums = {1, 2, 2, 3, 3, 4};
//		int[] nums = {1, 2, 3, 4, 4, 5, 5, 6, 7, 8, 100, 101, 102};
		int[] nums = {1, 2, 3, 4, 4, 5};
		
		System.out.println(obj.isPossible(nums));
	}

}

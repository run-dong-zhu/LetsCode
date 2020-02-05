package searching_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 15, Level: Medium
 * 
 * Given an array of integers, are there elements a, b, c in array 
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * The solution set must not contain duplicate triplets.
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 */
public class LeetCode15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new LinkedList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        // avoid same number
                        while (lo < hi && nums[lo] == nums[lo+1]) {
                            lo++;
                        }
                        // avoid same number
                        while (lo < hi && nums[hi] == nums[hi-1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    }
                    else {
                        hi--;
                    }
               }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode15_3Sum obj = new LeetCode15_3Sum();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2, 0, 0, 2, 2, 2};
        System.out.println(obj.threeSum(nums));
    }

}

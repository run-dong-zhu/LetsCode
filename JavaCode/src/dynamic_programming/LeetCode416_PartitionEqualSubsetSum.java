package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 416, Level: Medium
 * 
 * Given a non-empty array containing only positive integers, 
 * find if the array can be partitioned into two subsets such 
 * that the sum of elements in both subsets is equal.
 * 
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 */
public class LeetCode416_PartitionEqualSubsetSum {
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
    
        // odd or even
        if ((sum & 1) == 1) {
            return false;
        }
        
        sum /= 2;

        int n = nums.length;
        
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
    
        dp[0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
   
        return dp[n][sum];
    }

    public static void main(String[] args) {
        //
        LeetCode416_PartitionEqualSubsetSum obj = new LeetCode416_PartitionEqualSubsetSum();
        
        int[] nums = {1, 5, 11, 5};
        
        System.out.println(obj.canPartition(nums));
    }

}

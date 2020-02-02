package dynamic_programming;

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
        
        boolean[] dp = new boolean[sum + 1];
    
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]]; //dp[j] means select this num, dp[j - nums[i - 1]] means select this num
            }
        }
   
        return dp[sum];
    }

    public static void main(String[] args) {
        LeetCode416_PartitionEqualSubsetSum obj = new LeetCode416_PartitionEqualSubsetSum();
        
        int[] nums = {1, 5, 13, 5};
        
        System.out.println(obj.canPartition(nums));
    }

}

package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 494, Level: Medium
 *
 * https://leetcode.com/problems/target-sum/
 */
public class LeetCode494_TargetSum {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }   

    public int subsetSum(int[] nums, int s) {
//        int[][] dp = new int[nums.length][s + 1];
//        
//        for(int i = 0; i < nums.length; i++) {
//            dp[i][0] = 1;
//        }
//        
//        for(int i = 1; i < nums.length; i++) {
//            for(int j = s; j >= nums[i]; j--) {
//                dp[i][j] = dp[i-1][j] + dp[i][j - nums[i]]; 
//            }
//        }
//        
//        return dp[nums.length - 1][s];
        
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
            for(int x : dp) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        return dp[s];
    }
    
    public static void main(String[] args) {
        LeetCode494_TargetSum obj = new LeetCode494_TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        
        System.out.println(obj.findTargetSumWays(nums, S));
    }

}

package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 213, Level: Medium
 */
public class LeetCode213_HouseRobber2 {
	
	private int helper(int[] nums, int start, int end) {
		if(end - start < 0)
            return 0;
        
        if(end - start == 0)
            return nums[start];
        
        if(end - start == 1)
            return Math.max(nums[start], nums[end]);
        
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        
        for(int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[end];
	}
	
	public int rob(int[] nums) {   
        if(nums.length == 1)
            return nums[0];
        
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

	public static void main(String[] args) {
		LeetCode213_HouseRobber2 obj = new LeetCode213_HouseRobber2();
		int[] nums = {8, 2, 8, 9, 2};
		System.out.println(obj.rob(nums));
	}

}

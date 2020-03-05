package divide_conquer;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 53, Level: Easy
 *
 */
public class LeetCode53_MaximumSubarray {
    
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }
    
    private int maxSubArray(int[] nums, int l, int r) {
        if (l > r) {
            return Integer.MIN_VALUE;
        }
        
        // divide
        int mid = l + (r - l) / 2, ml = 0, mr = 0;
        int lmax = maxSubArray(nums, l, mid - 1);
        int rmax = maxSubArray(nums, mid + 1, r);
        
        for (int i = mid - 1, sum = 0; i >= l; i--) {
            sum += nums[i];
            ml = Math.max(sum, ml);
        }
        
        for (int i = mid + 1, sum = 0; i <= r; i++) {
            sum += nums[i];
            mr = Math.max(sum, mr);
        }
        return Math.max(Math.max(lmax, rmax), ml + mr + nums[mid]);
    }
    
    // follow up find start and end index of maxSubarray
    public int[] maxSub(int[] nums) {
    	if(nums.length == 0) {
    		return new int[0];
    	}
    	
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	
    	int max = nums[0];
    	int end = 0;
    	
    	for(int i = 1; i < dp.length; i++) {
    		if(dp[i - 1] > 0) {
    			dp[i] = dp[i - 1] + nums[i];
    		}
    		else {
    			dp[i] = nums[i];
    		}
    		
    		if(dp[i] > max) {
    			max = dp[i];
    			end = i;
    		}
    	}
    	
    	int start = end;
    	while(max > 0) {
    		max -= nums[start--];
    	}
    	
    	return new int[] {start + 1, end};
    }
    
    // follow up find at least len(2) maxSubarray
    public int[] maxSub2(int[] nums) {
    	if(nums.length == 0) {
    		return new int[0];
    	}
    	
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	
    	int max = nums[0];
    	int end = 0;
    	
    	for(int i = 1; i < dp.length; i++) {
    		if(dp[i - 1] > 0) {
    			dp[i] = dp[i - 1] + nums[i];
    		}
    		else {
    			dp[i] = nums[i];
    		}
    		
    		if(dp[i] > max) {
    			max = dp[i];
    			end = i;
    		}
    	}
    	
    	int start = end;
    	while(max > 0) {
    		max -= nums[start--];
    	}
    	
    	return new int[] {start + 1, end};
    }
    
    
    public static void main(String[] args) {
        LeetCode53_MaximumSubarray obj = new LeetCode53_MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(nums));
        
        int[] res = obj.maxSub(nums);
        System.out.println(res[0] + " " + res[1]);
    }

}

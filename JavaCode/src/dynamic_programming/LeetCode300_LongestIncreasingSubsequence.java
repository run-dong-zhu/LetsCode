package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 300, Level: Medium
 * 
 * 
 */
public class LeetCode300_LongestIncreasingSubsequence {
//    public int lengthOfLIS(int[] nums) {
//        if(nums.length < 2) {
//            return nums.length;
//        }
//        
//        int[] lis = new int[nums.length];
//        
//        lis[0] = 1;
//        
//        int max = 1;
//        
//        for(int i = 1; i < nums.length; i++) {
//            lis[i] = 1;
//            for(int j = 0; j < i; j++) {
//                if(nums[i] > nums[j] && lis[i] < lis[j] + 1) {
//                    lis[i] = lis[j] + 1;
//                }
//            }
//            if(max < lis[i]) {
//                max = lis[i];
//            }
//        }
//        
//        return max;
//    }
    
    /*
     * Now try to minimize from j to i part by Binary Search
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        int size = 0;
        
        for(int num : nums) {
            int l = 0;
            int r = size;
            while(l != r) {
                int mid = (l + r) / 2;
                
                if(dp[mid] < num) {
                    l = mid + 1;
                }
                else {
                    r = mid;
                }
            }
            
            dp[l] = num;
            if(l == size)
                size++;
        }
        
        return size;
    }
    
    public static void main(String[] args) {
        LeetCode300_LongestIncreasingSubsequence obj = new LeetCode300_LongestIncreasingSubsequence();
        
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        
        System.out.println(obj.lengthOfLIS(nums));
    }
}

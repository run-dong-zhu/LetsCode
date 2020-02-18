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

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LeetCode53_MaximumSubarray obj = new LeetCode53_MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(nums));
    }

}

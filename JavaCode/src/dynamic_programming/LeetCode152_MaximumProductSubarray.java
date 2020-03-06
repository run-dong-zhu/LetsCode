package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 153, Level: Medium
 * 
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */
public class LeetCode152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int product = nums[0];
        
        for(int i = 1, imax = product, imin = product; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            
            product = Math.max(product, imax);
        }
        
        return product;
    }
    
    // follow up maxProduct under certain value
    public int maxProd(int[] nums, int left, int right, int K) {        
        int product = nums[left];
        
        for(int i = left + 1, imax = product, imin = product; i < right; i++) {
            if(nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            
            imax = Math.max(imax * nums[i], nums[i]);
//            System.out.print("imax: " +  imax);
            imin = Math.min(imin * nums[i], nums[i]);
//            System.out.print(" imin: " +  imin);
//            System.out.println();
            
            while(imax > K) {
                imax = maxProd(nums, left + 1, right, K);
            }
            
            product = Math.max(product, imax);
        }
        
        return product;
    }
    
    public int maxProduct(int[] nums, int K) {
        if(nums.length == 0)
            return 0;
        
        int product = nums[0];
        
        for(int i = 1, imax = product, imin = product; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            
            product = Math.max(product, imax);
        }
        
        return product;
    }
    
    public static void main(String[] args) {
        LeetCode152_MaximumProductSubarray obj = new LeetCode152_MaximumProductSubarray();
        
        int[] nums = {1, -2, 3, 4};

        System.out.println(obj.maxProduct(nums));
        
        int[] test = {5, 2, 2, 2, 2, 2, 5};
        int K = 35;
        
        System.out.println(obj.maxProd(test, 0, test.length, K));
        
        int[] test2 = {3, 2, -2, 4, -2};
        int K2 = 40;
        System.out.println(obj.maxProd(test2, 0, test2.length, K2));
    }

}

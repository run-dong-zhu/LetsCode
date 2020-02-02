package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 238, level: Medium
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to 
 * the product of all the elements of nums except nums[i].
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up: Could you solve it with constant space complexity?
 */
public class LeetCode238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        int[] result = new int[len];
        
        result[0] = 1;
        
        // get every num from 1 to n - 1
        for(int i = 1; i < len; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        
        int product = 1;
        
        for(int i = len - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product *= nums[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        LeetCode238_ProductOfArrayExceptSelf obj = new LeetCode238_ProductOfArrayExceptSelf();
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {6, 2, 7, 3};
        int[] res = obj.productExceptSelf(nums);
        for(int p : res) {
            System.out.print(p + " ");
        }
    }

}

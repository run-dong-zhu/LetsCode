package binary_search;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 33, Level: Medium
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class LeetCode33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }
            
            if((nums[mid] < nums[0]) == (target < nums[0])) {
                // from mid to right is ascending order, or
                // from left to mid is ascending order, and
                // target inside ascending order
            } else {
                if(target < nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
                else {
                    nums[mid] = Integer.MAX_VALUE;
                }
            }
            
            if(nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        LeetCode33_SearchInRotatedSortedArray obj = new LeetCode33_SearchInRotatedSortedArray();

//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {4, 5, 6, 0, 1, 2, 3};
        
        System.out.println(obj.search(nums, 3));
    }

}

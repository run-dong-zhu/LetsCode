package searching_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 34, Level: Medium
 * 
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class LeetCode34_FindFirstAndLastPositionOfElementInSortedArray {

    public int findLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] != target) {
                    return mid;
                }
                else {
                    r = mid - 1;
                }
            }
            else if(nums[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        
        return -1;
    }
    
    public int findRight(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                }
                else {
                    l = mid + 1;
                }
            }
            else if(nums[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        return new int[] {findLeft(nums, target), findRight(nums, target)};
    }
    public static void main(String[] args) {
        LeetCode34_FindFirstAndLastPositionOfElementInSortedArray obj = new LeetCode34_FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(obj.searchRange(nums, target)[0] + ", " + obj.searchRange(nums, target)[1]);
    }

}

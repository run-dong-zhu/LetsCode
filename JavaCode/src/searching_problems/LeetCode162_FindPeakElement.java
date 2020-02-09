package searching_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 162, Level: Medium
 * 
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 */
public class LeetCode162_FindPeakElement {
    
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] > nums[mid + 1]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        
        return l;
    }

    public static void main(String[] args) {
        LeetCode162_FindPeakElement obj = new LeetCode162_FindPeakElement();
        int[] nums = {1, 5, 6, 7, 11, 9};
        System.out.println(obj.findPeakElement(nums));
    }

}

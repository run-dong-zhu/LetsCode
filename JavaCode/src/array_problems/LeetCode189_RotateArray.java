package array_problems;

import java.util.Arrays;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 189, Level: Easy
 * 
 * https://leetcode.com/problems/rotate-array/
 */
public class LeetCode189_RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums.length <= 1 || k == 0) {
            return;
        }
        
        int n = nums.length;
        k = k % n;
        
        int[] temp = Arrays.copyOfRange(nums, n - k, n);
//        int[] temp = new int[k];
//        for(int i = 0, j = n - k; i < k; i++, j++) {
//            temp[i] = nums[j];
//        }

        int l = n - k - 1;
        int r = n - 1;
        
        while(l >= 0) {
            nums[r] = nums[l];
            r--;
            l--;
        }
        
        for(int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
    
    
    private void reverseArray(int[] array, int l, int r) {
        while(l < r) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            
            l++;
            r--;
        }
    }
    
    public void rotate2(int[] nums, int k) {
        if(nums.length <= 1 || k == 0) {
            return;
        }
        
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }
    
    public static void main(String[] args) {
        LeetCode189_RotateArray obj = new LeetCode189_RotateArray();

        int[] nums = {1, 3, 4, 9, 7};
        int k = 2;
        
        obj.rotate(nums, k);
        
        for(int num : nums) {
            System.out.print(num + " ");
        }
        
        System.out.println();
        
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        int k2 = 3;
        
        obj.rotate2(nums2, k2);
        
        for(int num : nums2) {
            System.out.print(num + " ");
        }
    }

}

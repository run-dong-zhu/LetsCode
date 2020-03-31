package string_problems;

import java.util.Arrays;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 566, Level: Medium
 * 
 * https://leetcode.com/problems/next-greater-element-iii/
 */
public class LeetCode556_NextGreaterElement3 {

    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        
        int i = 0;
        int j = 0;
        
        for(i = nums.length - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                break;
            }
        }
        
        if(i == 0) {
            return -1;
        }
        
        int x = nums[i - 1]; // swap 1
        int smallest = i; // swap 2
        for(j = i + 1; j < nums.length; j++) {
            if(nums[j] > x && nums[j] <= nums[smallest]) {
                smallest = j;
            }
        }
        
        nums[i - 1] = nums[smallest];
        nums[smallest] = (char)(x);
        
        Arrays.sort(nums, i, nums.length);
        
        long res = Long.parseLong(new String(nums));
        return res <= Integer.MAX_VALUE ? (int)res : -1;
    }
    
    public static void main(String[] args) {
        LeetCode556_NextGreaterElement3 obj = new LeetCode556_NextGreaterElement3();

        System.out.println(obj.nextGreaterElement(Integer.MAX_VALUE));
        System.out.println(obj.nextGreaterElement(534962));
    }

}

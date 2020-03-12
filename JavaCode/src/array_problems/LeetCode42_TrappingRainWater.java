package array_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 42, Level: Hard
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class LeetCode42_TrappingRainWater {
    // brute force
//    public int trap(int[] height) {
//        int ans = 0;
//        
//        for(int i = 1; i < height.length - 1; i++) {
//            int left = 0;
//            int right = 0;
//            for(int j = i; j >=0; j--) {
//                left = Math.max(left, height[j]);
//            }
//            for(int k = i; k < height.length; k++) {
//                right = Math.max(right, height[k]);
//            }
//            
//            ans += Math.min(left, right) - height[i];
//        }
//        
//        return ans;
//    }
    
    public int trap(int[] height) {
        int res = 0;

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while(left < right) {
            if(height[left] < height[right]) {
                maxLeft = Math.max(height[left], maxLeft);
                res += maxLeft - height[left];
                left++;
            }
            else {
                maxRight = Math.max(height[right], maxRight);
                res += maxRight - height[right];
                right--;
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
        LeetCode42_TrappingRainWater obj = new LeetCode42_TrappingRainWater();

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        System.out.println(obj.trap(height));
    }

}

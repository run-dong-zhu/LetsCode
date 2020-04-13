package array_problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 84, Level: Hard
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LeetCode84_LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        
        while(stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (n - stack.peek() - 1));
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        LeetCode84_LargestRectangleInHistogram obj = new LeetCode84_LargestRectangleInHistogram();

        int[] heights = {2, 1, 5, 6, 2, 3};
        
        System.out.println(obj.largestRectangleArea(heights));
    }

}

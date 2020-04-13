package array_problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 85, Level: Hard
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * 
 * Example:
 * Input:
 * [
 *  ["1","0","1","0","0"],
 *  ["1","0","1","1","1"],
 *  ["1","1","1","1","1"],
 *  ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class LeetCode85_MaximalRectangle {

    private void buildHistogram(char[][] matrix, int[][] grid) {
        for(int c = 0; c < matrix[0].length; c++) {
            grid[0][c] = matrix[0][c] == '1' ? 1 : 0;
        }
        
        for(int r = 1; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                if(matrix[r][c] == '1') {
                    grid[r][c] = grid[r - 1][c] + 1;
                }
                else {
                    grid[r][c] = 0;
                }
            }
        }
    }
    
    private int maxRec(int[][] grid, int bottom) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        
        for(int i = 0; i < grid[0].length; i++) {
            while(stack.peek() != -1 && grid[bottom][stack.peek()] >= grid[bottom][i]) {
                max = Math.max(max, grid[bottom][stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        
        while(stack.peek() != -1) {
            max = Math.max(max, grid[bottom][stack.pop()] * (grid[0].length - stack.peek() - 1));
        }
        
        return max;
    }
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] grid = new int[rows][cols];
        buildHistogram(matrix, grid);
        
        int max = 0;
        
        for(int r = 0; r < rows; r++) {
            max = Math.max(max, maxRec(grid, r));
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        LeetCode85_MaximalRectangle obj = new LeetCode85_MaximalRectangle();

        char[][] matrix = {{'1', '0', '1', '0', '0'},
                           {'1', '0', '1', '1', '1'},
                           {'1', '1', '1', '1', '1'},
                           {'1', '0', '0', '1', '0'}};
        
        System.out.println(obj.maximalRectangle(matrix));
    }

}

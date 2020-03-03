package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 221, Level: Medium
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * 
 * Example:
 * Input: 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 */
public class LeetCode221_MaximalSquare {
	
	private int getMin(int[][] dp, int r, int c) {
        return Math.min(dp[r - 1][c - 1], Math.min(dp[r][c - 1], dp[r - 1][c]));
    }
    
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int r = 0; r < matrix.length; r++) {
            if(matrix[r][0] == '1') {
                dp[r][0] = 1;
            }
        }
        
        for(int c = 0; c < matrix[0].length; c++) {
            if(matrix[0][c] == '1') {
                dp[0][c] = 1;
            }
        }
        
        int maxSqrt = 0;
        
        for(int r = 1; r < dp.length; r++) {
            for(int c = 1; c < dp[0].length; c++) {
                if(matrix[r][c] == '1') {
                    dp[r][c] = getMin(dp, r, c) + 1;
                    maxSqrt = Math.max(maxSqrt, dp[r][c]);
                }
            }
        }
        
        return maxSqrt * maxSqrt;
    }

	public static void main(String[] args) {
		LeetCode221_MaximalSquare obj = new LeetCode221_MaximalSquare();

		char[][] matrix = {{'0', '1', '1', '1', '0'},
						  {'1', '1', '1', '1', '1'},
						  {'0', '1', '1', '1', '1'},
						  {'0', '1', '1', '1', '1'},
						  {'0', '0', '1', '1', '1'}};
		
		System.out.println(obj.maximalSquare(matrix));
	}

}

package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 363, 
 */
public class LeetCode363_MaxSumOfRectangleNoLargerThanK {
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
         if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        
        for(int r = 1; r < row; r++) {
            dp[r][0] = Math.max(matrix[r][0], dp[r - 1][0] + matrix[r][0]);
        }
        
        for(int c = 1; c < col; c++) {
            dp[0][c] = Math.max(matrix[0][c], dp[0][c - 1] + matrix[0][c]);
        }
        
        for(int r = 1; r < row; r++) {
            for(int c = 1; c < col; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
        LeetCode363_MaxSumOfRectangleNoLargerThanK obj = new LeetCode363_MaxSumOfRectangleNoLargerThanK();

        int[][] matrix = {{1, 0, 1},
                          {0, -2, 3}};
        
        System.out.println(obj.maxSumSubmatrix(matrix, 2));
    }

}

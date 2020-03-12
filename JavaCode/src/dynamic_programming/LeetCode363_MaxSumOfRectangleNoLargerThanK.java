package dynamic_programming;

import java.util.TreeSet;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 363, 
 */
public class LeetCode363_MaxSumOfRectangleNoLargerThanK {
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        //boundary check
        if(matrix.length == 0) {
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int maxSum = Integer.MIN_VALUE;
        
        for(int left = 0; left < col; left++) {
            int[] dp = new int[row];
            for(int right = left; right < col; right++) {
                for(int i = 0; i < row; i++) {
                    dp[i] += matrix[i][right];
                }
                
                //we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int currSum = 0;
                
                for(int sum : dp) {
                    currSum += sum;
                    Integer num = set.ceiling(currSum - k);
                    if(num != null) {
                        maxSum = Math.max(maxSum, currSum - num);
                    }
                    set.add(currSum);
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LeetCode363_MaxSumOfRectangleNoLargerThanK obj = new LeetCode363_MaxSumOfRectangleNoLargerThanK();
//        int[][] matrix = {{1, 0, 1},
//                          {0, -2, 3}};
        
        int[][] matrix = {{2, 1, -3, -4, 5},
                          {0, 6, 3, 4, 1},
                          {2, -2, -1, 4, 5},
                          {-3, 3, 1, 0, 3}};
        
        int k = 100;
        
        System.out.println(obj.maxSumSubmatrix(matrix, k));
    }

}

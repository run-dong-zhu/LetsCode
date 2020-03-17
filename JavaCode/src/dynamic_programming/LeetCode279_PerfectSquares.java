package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 279, Level: Medium
 */
public class LeetCode279_PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, n);
        
        dp[0] = 0;
        dp[1] = 1;
        
        // dp[12] = dp[12 - 4] + dp[4]
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        LeetCode279_PerfectSquares obj = new LeetCode279_PerfectSquares();

        System.out.println(obj.numSquares(15));
    }

}

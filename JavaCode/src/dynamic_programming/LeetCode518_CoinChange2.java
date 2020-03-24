package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 518, Level: Medium
 *
 * https://leetcode.com/problems/coin-change-2/
 */
public class LeetCode518_CoinChange2 {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        dp[0][0] = 1;
        
        // dp[i][j] = the number of combinations of amount j with first i types of coins
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + (coins[i - 1] <= j ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        
        return dp[coins.length][amount];
    }
    
    public static void main(String[] args) {
        LeetCode518_CoinChange2 obj = new LeetCode518_CoinChange2();
        int[] coins = {1, 2, 5};
        int amount = 5;
        
        System.out.println(obj.change(amount, coins));
    }

}

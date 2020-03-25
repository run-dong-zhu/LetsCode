package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 72
 *
 * https://leetcode.com/problems/edit-distance/
 */
public class LeetCode72_EditDistance {

    public int minDistance(String word1, String word2) {
        int row = word1.length();
        int col = word2.length();
        
        int[][] dp = new int[row + 1][col + 1];
                
        for(int r = 0; r <= row; r++) {
            Arrays.fill(dp[r], row + col + 1);
            dp[r][0] = r;
        }
        
        for(int c = 0; c <= col; c++) {
            dp[0][c] = c;
        }
        
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                char ch1 = word1.charAt(r);
                char ch2 = word2.charAt(c);
                
                if(ch1 == ch2) {
                    dp[r + 1][c + 1] = dp[r][c];
                }
                else {
                    dp[r + 1][c + 1] = Math.min(dp[r + 1][c], Math.min(dp[r][c + 1], dp[r][c])) + 1;
                }
            }
        }
        
        return dp[row][col];
    }
    
    public static void main(String[] args) {
        LeetCode72_EditDistance obj = new LeetCode72_EditDistance();
        
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(obj.minDistance(word1, word2));
    }

}

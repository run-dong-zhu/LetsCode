package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 10, Level: Hard
 * 
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class LeetCode10_RegularExpressionMatching {

//    // DFS
//    public boolean isMatch(String s, String p) {
//        if(p.length() == 0) {
//            return s.length() == 0; 
//        }
//        
//        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
//        
//        if(p.length() >= 2 && p.charAt(1) == '*') {
//            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
//        }
//        else {
//            return firstMatch && isMatch(s.substring(1), p.substring(1));    
//        }
//    }
    
    // DP
    public boolean isMatch(String s, String p) {
        int row = s.length();
        int col = p.length();

        boolean[][] dp = new boolean[row + 1][col + 1];
        // initial
        dp[0][0] = true;

        for(int i = 2; i <= col; i++) {
            if(p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for(int r = 1; r <= row; r++) {
            for(int c = 1; c <= col; c++) {
                char sc = s.charAt(r - 1);
                char pc = p.charAt(c - 1);

                if(sc == pc || pc == '.') {
                    dp[r][c] = dp[r - 1][c - 1];
                }
                else if(pc == '*') {
                    // use 0 times
                    if(dp[r][c - 2]) {
                        dp[r][c] = true;
                    }
                    else {
                        if(sc == p.charAt(c - 2) || p.charAt(c - 2) == '.') {
                            dp[r][c] = dp[r - 1][c];
                        }
                    }
                }
            }
        }

        return dp[row][col];
    }

    public static void main(String[] args) {
        LeetCode10_RegularExpressionMatching obj = new LeetCode10_RegularExpressionMatching();

        String s = "aaabcca";
        String p = "a*.c.a";
        
        System.out.println(obj.isMatch(s, p));
    }

}

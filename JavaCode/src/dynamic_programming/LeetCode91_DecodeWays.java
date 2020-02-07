package dynamic_programming;

/**
 * 
 * @author rund-dong-zhu
 * @description LeetCode 91, Level: Medium
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * 
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 */
public class LeetCode91_DecodeWays {

	public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') {
        	return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';
            
            // can't make progress, return 0
            if (prev == 0 && curr == 0 || (curr == 0 && (prev * 10 + curr > 26)))
            {
                return 0;
            }
            // can't use the previous value, so can only get to this state from the previous
            else if (prev == 0 || (prev * 10 + curr) > 26)
            {
                dp[i + 1] = dp[i];
            }
            // can't use current state, can only get to this state from i - 1 state
            else if (curr == 0)
            {
                dp[i + 1] = dp[i - 1];
            }
            // can get to this state from the previous two states
            else
            {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        
        return dp[dp.length - 1];
    }

	public static void main(String[] args) {
		LeetCode91_DecodeWays obj = new LeetCode91_DecodeWays();
		String s = "100";
		System.out.println(obj.numDecodings(s));
	}

}

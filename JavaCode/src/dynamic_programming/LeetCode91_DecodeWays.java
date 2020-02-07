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
        
        for(int i = 1; i < dp.length; i++) {
        	int curr = s.charAt(i) - '0';
        	int prev = s.charAt(i - 1) - '0';
        	
        	if(prev == 0 && curr == 0 || (curr == 0 && (prev * 10 + curr > 26))) {
        		return 0;
        	}
        	else if(prev == 0 || prev * 10 + curr > 26) {
        		dp[i] = dp[i - 1] + 1;
        		if(s.charAt(i) - '0' <= 6) {
        			dp[i] = dp[i - 1] + 1;
        		}
        		else {
        			dp[i] = dp[i - 1];
        		}
        	}
        	else {
        		dp[i] = dp[i - 1];
        	}
        }
        
        return 0;
    }

	public static void main(String[] args) {
		LeetCode91_DecodeWays obj = new LeetCode91_DecodeWays();
		String s = "109";
		System.out.println(obj.numDecodings(s));
	}

}

package string_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 5, Level: Medium
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LeetCode5_LongestPalindromicSubstring {

    int left = 0;
    int max = 0;
    
    public void helper(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        
        if(max < r - l - 1) {
            left = l + 1;
            max = r - l - 1;
        }
    }
    
    public String longestPalindrome(String s) {
        if(s.length() < 2) {
            return s;
        }
        
        for(int i = 0; i < s.length(); i++) {
            helper(s, i, i); // i is the center of palindrome
            helper(s, i, i + 1); // i and i + 1 are the center of palindrome
        }
        
        return s.substring(left, left + max);
    }
    
    public static void main(String[] args) {
        LeetCode5_LongestPalindromicSubstring obj = new LeetCode5_LongestPalindromicSubstring();

        String s = "eabcb";
        
        System.out.println(obj.longestPalindrome(s));
    }

}

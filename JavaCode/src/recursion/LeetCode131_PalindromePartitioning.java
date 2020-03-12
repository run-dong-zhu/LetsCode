package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 131, Level: Medium
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * Input: "aab"
 * Output:
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 *  ]
 */
public class LeetCode131_PalindromePartitioning {
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length();
        
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    private void helper(int i, String curr, String s, List<String> list, List<List<String>> res) {
        if(i == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        curr += s.charAt(i);
        
        if(isPalindrome(curr)) {
            list.add(curr);
        }
        
        helper(i + 1, curr, s, list, res);
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        
        helper(0, "", s, list, res);
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

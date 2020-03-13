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
        int right = s.length() - 1;
        
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    private void helper(int index, String s, List<String> list, List<List<String>> res) {
        if(list.size() > 0 && index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = index + 1; i <= s.length(); i++) {
            if(isPalindrome(s.substring(index, i))) {
                list.add(s.substring(index, i));
                helper(i, s, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        
        helper(0, s, list, res);
        
        return res;
    }

    public static void main(String[] args) {
        LeetCode131_PalindromePartitioning obj = new LeetCode131_PalindromePartitioning();
        String s = "aab";
        System.out.println(obj.partition(s));
    }

}

package string_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 680, Level: Easy
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 */
public class LeetCode680_ValidPalindrome2 {
    
    public boolean isPalindrome(String s, int l, int r) {
        while(l <= r) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while(l < r) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        LeetCode680_ValidPalindrome2 obj = new LeetCode680_ValidPalindrome2();
        System.out.println(obj.validPalindrome("abca"));
        System.out.println(obj.validPalindrome("abcda"));
    }

}

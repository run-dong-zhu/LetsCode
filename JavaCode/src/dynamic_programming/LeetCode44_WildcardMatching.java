package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 44, Level: Hard
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * 
 * Output: false
 * 
 * Explanation: "a" does not match the entire string "aa".
 */
public class LeetCode44_WildcardMatching {

    /*
     * if s[i] == p[j] || p[j] == '?', ++i and ++j.
     * ii, jj, record the positon of '*' in s and p, ++j and go on.
     * if not match, go back to star, i = ++ii;
     */
    public boolean isMatch(String s, String p) {
        int i = 0; // String pointer
        int j = 0; // Pattern pointer
        
        int ii = -1;
        int jj = -1;
        
        while(i < s.length()) {
            if(j < p.length() && p.charAt(j) == '*') {
                while(j < p.length() && p.charAt(j) == '*') {
                    j++;
                }
                if(j == p.length()) {
                    return true;
                }
                ii = i;
                jj = j;
            }
            if(j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } 
            else {
                if (ii == -1) {
                    return false;
                }
                ii++;
                i = ii;
                j = jj;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return i == s.length() && j == p.length();
    }
    
    public static void main(String[] args) {
        LeetCode44_WildcardMatching obj = new LeetCode44_WildcardMatching();

        String s = "acbbbb";
        String p = "a*b";
        
        System.out.println(obj.isMatch(s, p));
    }

}

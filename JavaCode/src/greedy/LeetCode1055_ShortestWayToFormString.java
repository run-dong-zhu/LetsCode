package greedy;

import java.util.Arrays;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 1055, Level: Medium
 * 
 * From any string, we can form a subsequence of that string by deleting some number of 
 * characters (possibly no deletions).
 * 
 * Given two strings source and target, return the minimum number of subsequences of source 
 * such that their concatenation equals target. If the task is impossible, return -1.
 * 
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
 */
public class LeetCode1055_ShortestWayToFormString {
    
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        
        int[][] idx = new int[cs.length][26];
        idx[cs.length - 1][cs[cs.length - 1] - 'a'] = cs.length; 
        for (int i = cs.length - 2; i >= 0; i--) {
            idx[i] = Arrays.copyOf(idx[i + 1],26);
            idx[i][cs[i] - 'a'] = i + 1; 
        }
        
        int res = 1;
        int j = 0;
        
        for (int i = 0; i < ts.length; i++) {
            if (j == cs.length) {
                j = 0;
                res++;
            }
            j = idx[j][ts[i] - 'a'];
            if (idx[0][ts[i] - 'a'] == 0) return -1;
            if (j == 0) {
                res++;
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1055_ShortestWayToFormString obj = new LeetCode1055_ShortestWayToFormString();

        String source = "xyz";
        String target = "xzyxz";
        
        System.out.println(obj.shortestWay(source, target));
    }

}

package array_problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 340, Level: Hard
 * 
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * 
 * Example 1:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * 
 * Example 2:
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 */
public class LeetCode340_LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int max = 0;
        
        int[] map = new int[256];
        
        for(int i = 0; i < s.length(); i++) {            
            if(map[s.charAt(i)]++ == 0) {
                k--;
            }
            while(k < 0 && start < s.length()) {
                map[s.charAt(start) - 'a']--;
                if(map[s.charAt(start) - 'a'] == 0) {
                    k++;
                }
                start++;
            }
            
            max = Math.max(max, i - start + 1);
        }
        
        return max;
    }
    
//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        if(s.length() == 0 || k == 0) {
//            return 0;
//        }
//        
//        int max = 1;
//        int start = 0;
//        
//        Map<Character, Integer> map = new HashMap<>();
//        
//        for(int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), i);
//            
//            if(map.size() == k + 1) {
//                int del = Collections.min(map.values());
//                map.remove(s.charAt(del));
//                start = del + 1;
//            }
//            
//            max = Math.max(max, i - start + 1);
//        }
//        
//        return max;
//    }
//    
    public static void main(String[] args) {
        LeetCode340_LongestSubstringWithAtMostKDistinctCharacters obj = 
                new LeetCode340_LongestSubstringWithAtMostKDistinctCharacters();
        
        String s = "eceba";
        int k = 2;
        
        System.out.println(obj.lengthOfLongestSubstringKDistinct(s, k));
    }
}

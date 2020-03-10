package dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 140, Level: Hard
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1:
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 */
public class LeetCode140_WordBreak2 {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<Character> set = new HashSet<>();
        
        for(String word : wordDict) {
            for(char ch : word.toCharArray()) {
                set.add(ch);
            }
        }
        
        for(char ch : s.toCharArray()) {
            if(!set.contains(ch)) {
                return new ArrayList<>();
            }
        }
        
        Set<String> words = new HashSet<>(wordDict);
        
        List<List<String>> dp = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        
        temp.add("");
        dp.add(temp);
        
        for(int i = 1; i <= s.length(); i++) {
            temp = new ArrayList<>();
            for(int j = 0; j < i; j++) {
                if(words.contains(s.substring(j, i))) {
                    for(int k = 0; k < dp.size(); k++) {
                        String str = dp.get(i).get(k);
                        if(str.equals("")) {
                            temp.add(s.substring(j, i));
                        }
                        else {
                            temp.add(str + " " + s.substring(j, i));
                        }
                    }
                }
            }
            dp.add(temp);
        }
        return dp.get(s.length());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

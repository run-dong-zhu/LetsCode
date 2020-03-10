package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    private void helper(String s, Set<String> words, String path, int start, List<String> res) {
        if(start == s.length()) {
            res.add(path);
            return;
        }
        if(path.length() != 0) {
            path = path + " ";
        }
        for(int i = start; i < s.length(); ++i) {
            String word = s.substring(start, i + 1);
            if(words.contains(word) == false) {
                continue;
            }
            helper(s, words, path + word, i + 1, res);
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        
        int n = s.length();
        boolean[] canBreak = new boolean[n + 1];
        canBreak[n] = true;
        
        Set<String> words = new HashSet<>(wordDict);
        
        for(int i = n - 1; i >= 0; --i) {
            for(int j = i; j < n; ++j) {
                if(words.contains(s.substring(i, j + 1)) && canBreak[j + 1]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        if(canBreak[0] == false) {
            return res;
        }
        helper(s, words, "", 0, res);
        
        return res;
    }

    public static void main(String[] args) {
        LeetCode140_WordBreak2 obj = new LeetCode140_WordBreak2();

        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        
        System.out.println(obj.wordBreak(s, wordDict));
    }

}

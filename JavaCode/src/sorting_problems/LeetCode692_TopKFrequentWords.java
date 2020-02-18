package sorting_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 692, Level: Medium
 * 
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. 
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
public class LeetCode692_TopKFrequentWords {
    // Sorting
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        List<String> candidates = new ArrayList<>(map.keySet());
        
        Collections.sort(candidates, (a, b) -> map.get(a).equals(map.get(b)) ?
                a.compareTo(b) : map.get(b) - map.get(a));

        return candidates.subList(0, k);
    }
    
    

    public static void main(String[] args) {
        LeetCode692_TopKFrequentWords obj = new LeetCode692_TopKFrequentWords();

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        
        System.out.println(obj.topKFrequent(words, 3));
    }

}

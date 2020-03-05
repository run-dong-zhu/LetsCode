package searching_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 127, Level: Medium
 * 
 * https://leetcode.com/problems/word-ladder/
 */
public class LeetCode127_WordLadder {	
	public int helper(String beginWord, String endWord, Set<String> set) {
		Set<String> visited = new HashSet<>();
		
		visited.add(beginWord);
//		set.add(endWord);
		
		int distance = 1;
		
		while(!visited.contains(endWord)) {
			Set<String> toAdd = new HashSet<>();
			for(String str : visited) {
				for(int i = 0; i < str.length(); i++) {
					char[] chr = str.toCharArray();
					for(char ch = 'a'; ch <= 'z'; ch++) {
						chr[i] = ch;
						String word = new String(chr);
						if(set.contains(word)) {
							toAdd.add(word);
							set.remove(word);
						}
					}
				}
			}
			
			if(toAdd.size() == 0) {
				return 0;
			}
			
			distance++;
			visited = toAdd;
		}
		return distance;
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>();
		
		for(String word : wordList) {
			set.add(word);
		}

		return helper(beginWord, endWord, set);
    }

	public static void main(String[] args) {
		LeetCode127_WordLadder obj = new LeetCode127_WordLadder();

		String beginWord = "hit";
		String endWord = "cog";
		
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		
		System.out.println(obj.ladderLength(beginWord, endWord, wordList));
	}

}

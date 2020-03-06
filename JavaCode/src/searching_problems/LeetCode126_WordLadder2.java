package searching_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 126, Level: Hard
 * 
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class LeetCode126_WordLadder2 {
	// Using bfs build graph
	private void bfs(Set<String> startSet, String endWord, Map<String, List<String>> map,
			Set<String> dict) {
		if(startSet.isEmpty()) {
			return;
		}
		
		Set<String> toAdd = new HashSet<>();
		boolean isEnd = false;
		dict.removeAll(startSet);
		
		for(String s : startSet) {
			char chs[] = s.toCharArray();
			for(int i = 0; i < s.length(); i++) {
//				char chs[] = s.toCharArray();
				char old = chs[i];
				for(char ch = 'a'; ch <= 'z'; ch++) {
					if (chs[i] == ch) {
						continue;
					}

					chs[i] = ch;
					String word = new String(chs);
					if(dict.contains(word)) {
						if(word.equals(endWord)) {
							isEnd = true;
						} else {
							toAdd.add(word);
						}
						
						if(map.get(s) == null) {
							map.put(s, new ArrayList<>());
						}
						
						map.get(s).add(word);
					}
				}
				chs[i] = old;
			}
		}
		
		if(!isEnd) {
			bfs(toAdd, endWord, map, dict);
		}
	}
	
	private void dfs(String word, String endWord, List<String> list, List<List<String>> res,
			Map<String, List<String>> map) {		
		if(word.equals(endWord)) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		if(map.get(word) == null) {
			return;
		}
		
		for(String next : map.get(word)) {
			list.add(next);
			dfs(next, endWord, list, res, map);
			list.remove(list.size() - 1);
		}
	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
				
		Set<String> dict = new HashSet<>(wordList);
		if(!dict.contains(endWord)) {
			return res;
		}
		
		Set<String> startSet = new HashSet<>();
		startSet.add(beginWord);
		
		Map<String, List<String>> map = new HashMap<>();
		
		bfs(startSet, endWord, map, dict);
		
		List<String> list = new ArrayList<>();
		list.add(beginWord);
		
		dfs(beginWord, endWord, list, res, map);
		
		return res;
	}

	public static void main(String[] args) {
		LeetCode126_WordLadder2 obj = new LeetCode126_WordLadder2();

		String beginWord = "hit";
		String endWord = "cog";
		
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		
//		String beginWord = "hot";
//		String endWord = "dog";
//		
//		List<String> wordList = Arrays.asList("hot", "dog");

		System.out.println(obj.findLadders(beginWord, endWord, wordList));
	}

}

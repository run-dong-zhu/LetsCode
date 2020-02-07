package design_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 211, Level: Medium
 * 
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class LeetCode211_AddandSearchWord {
    final int MAX_LEN = 26;
    
    class TrieNode {
        TrieNode[] children = new TrieNode[MAX_LEN];
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();
    
    /** Initialize your data structure here. */
    public LeetCode211_AddandSearchWord() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            if(node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        
        node.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] word, int level, TrieNode node) {
        if(level == word.length) {
            return node.isEnd;
        }
        if(word[level] != '.') {
            return node.children[word[level] - 'a'] != null && match(word, level + 1, node.children[word[level] - 'a']);
        }
        else {
            for(int i = 0; i < MAX_LEN; i++) {
                if(node.children[i] != null) {
                    if(match(word, level + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        LeetCode211_AddandSearchWord obj = new LeetCode211_AddandSearchWord();
        obj.addWord("abc");
        obj.addWord("abd");
        obj.addWord("aed");
        
        System.out.println(obj.search("ab"));
        System.out.println(obj.search("abc"));
        System.out.println(obj.search("a.c"));
        System.out.println(obj.search(".ed"));
        System.out.println(obj.search(".ec"));
    }

}

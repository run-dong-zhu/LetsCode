package string_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 76, Level: Hard
 * 
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class LeetCode76_MinimumWindowSubstring {
	
	public String minWindow(String s, String t) {
		int start = 0;
		int end = 0; // scanner
		int minStart = 0;
		int minLen = s.length() + 1;
		int counter = t.length(); // record all char in t
		
		int[] map = new int[128];
        
        for(int i = 0; i < t.length(); i++) {
        	map[t.charAt(i)]++;
        }
        
        while(end < s.length()) {
        	char ch = s.charAt(end);
        	
        	if (map[ch] > 0) {
        		counter--;
        	}
        	
  	      	map[ch]--; // substring include ch
  	      	end++;
  	      	
	  	    while (counter == 0) {
	  	        if(minLen > end - start) {
	  	    	    minLen = end - start;
	  	    	    minStart = start;
	  	        }
		  	    char startChar = s.charAt(start);
		  	    map[startChar]++;
		  	    if(map[startChar] > 0) {
		  	    	counter++;
		  	    }
		  	    start++;
	        }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

	public static void main(String[] args) {
		LeetCode76_MinimumWindowSubstring obj = new LeetCode76_MinimumWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		
//		String s = "AA";
//		String t = "A";
		
		System.out.println(obj.minWindow(s, t));
	}

}

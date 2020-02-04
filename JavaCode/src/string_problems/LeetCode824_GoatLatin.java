package string_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 824, Level: Easy
 *
 * https://leetcode.com/problems/goat-latin/
 */
public class LeetCode824_GoatLatin {

	public String toGoatLatin(String S) {
        Set<Character> vowelSet = new HashSet<>(
        		Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        String[] strs = S.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        StringBuilder suffix = new StringBuilder("a");
        
        for(String str : strs) {
        	if (sb.length() != 0) {
                sb.append(" ");
            }
        	
            if(vowelSet.contains(str.charAt(0))) {
                sb.append(str);
            }
            else {
                sb.append(str.substring(1));
                sb.append(str.charAt(0));
            }
            
            sb.append("ma").append(suffix);
            suffix.append("a");
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		LeetCode824_GoatLatin obj = new LeetCode824_GoatLatin();
		System.out.println(obj.toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}

}

package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 68, Level: Hard
 * 
 * https://leetcode.com/problems/text-justification/
 */
public class LeetCode68_TextJustification {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
        
        if(words.length == 0) {
            return res;
        }
        
        int n = words.length;
        int index = 0;
        
        while(index < n) {
            int totalChars = words[index].length();
            int next = index + 1;
            
            // while totalChars < maxWidth
            while(next < n) {
                if(totalChars + words[next].length() + 1 > maxWidth) {
                    break;
                }
                totalChars += 1 + words[next].length();
                next++;
            }
            
            int gaps = next - index - 1;
            StringBuilder sb = new StringBuilder();

            // last line or single word
            if(next == n || gaps == 0) {
                for(int i = index; i < next; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                
                sb.deleteCharAt(sb.length() - 1);
                
                while(sb.length() < maxWidth) {
                    sb.append(' ');
                }
            }
            // lines from 0 to second last
            else {
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;
                
                for(int i = index; i < next - 1; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                    
                    for(int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++) {
                        sb.append(' ');
                    }
                }
                
                sb.append(words[next - 1]);
            }
            
            res.add(sb.toString());
            index = next;
        }
        
        return res;
    }

	public static void main(String[] args) {
		LeetCode68_TextJustification obj = new LeetCode68_TextJustification();

		String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", 
				"to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
		
		for(String line : obj.fullJustify(words, 20)) {
			System.out.println(line);
		}
	}

}

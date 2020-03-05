package string_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 38, Level: Easy
 * 
 * https://leetcode.com/problems/count-and-say/
 */
public class LeetCode38_CountAndSay {
	
	public String countAndSay(int n) {
        if(n == 0) {
            return "";
        }
        
        String str = "1";
        
        while(n > 1) {
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            char ch = str.charAt(0);
            int count = 0;
            while(idx < str.length()) {
                if(str.charAt(idx) == ch) {
                    count++;
                }
                else {
                    sb.append(count);
                    sb.append(ch);
                    // reset
                    count = 0;
                    ch = str.charAt(idx);
                    idx--;
                }
                idx++;
            }
            
            sb.append(count);
            sb.append(ch);
            
            str = sb.toString();
            n--;
        }
        
        return str;
    }

	public static void main(String[] args) {
		LeetCode38_CountAndSay obj = new LeetCode38_CountAndSay();

		System.out.println(obj.countAndSay(5));
	}

}

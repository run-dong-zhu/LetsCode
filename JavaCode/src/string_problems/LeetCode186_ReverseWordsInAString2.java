package string_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 186, Level: Medium
 * 
 * Given an input string , reverse the string word by word. 
 * 
 * Example:
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 
 * Note: 
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * 
 * Follow up: Could you do it in-place without allocating extra space?
 */
public class LeetCode186_ReverseWordsInAString2 {
	
	public void reverse(char[] s, int left, int right) {
		while(left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;

			left++;
			right--;
		}
	}
	
	public void reverseWords(char[] s) {
		int left = 0;
        int right = s.length - 1;

        reverse(s, left, right);
        
        left = 0;
        for(int i = 0; i < s.length; i++) {
        	if(s[i] == ' ') {
        		reverse(s, left, i - 1);
        		left = i + 1;
        	}
        	if(i == s.length - 1) {
        		reverse(s, left, i);
        	}
        }
    }

	public static void main(String[] args) {
		LeetCode186_ReverseWordsInAString2 obj = new LeetCode186_ReverseWordsInAString2();
		
		char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};

		obj.reverseWords(s);
		
		String str = new String(s);
		
		System.out.println(str);
	}

}

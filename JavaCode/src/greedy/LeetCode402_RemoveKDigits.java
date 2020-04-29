package greedy;

import java.util.Stack;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode: 402, level: Medium
 *
 * https://leetcode.com/problems/remove-k-digits/
 */
public class LeetCode402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder();
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < num.length(); i++) {
            char number = num.charAt(i);
            while(!stack.isEmpty() && number < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            if(number != '0' || !stack.isEmpty()) {
                stack.push(number);
            }
        }
        
        while(!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        if(result.length() == 0) {
            return "0";
        }
        
        return result.reverse().toString();
    }
    
    public static void main(String[] args) {
        LeetCode402_RemoveKDigits obj = new LeetCode402_RemoveKDigits();

        String num = "85297";
        int k = 3;
        System.out.println(obj.removeKdigits(num, k));
    }

}

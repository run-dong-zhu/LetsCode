package string_problems;

import java.util.Stack;

/**
 * @author run-dong-zhu
 * @description LeetCode 20, level: Easy
 * 
 * https://leetcode.com/problems/valid-parentheses/
 */

public class LeetCode20_ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        } 
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(')');
            }         
            else if(s.charAt(i) == '{') {
                stack.push('}');
            }
            else if(s.charAt(i) == '[') {
                stack.push(']');
            }
            else {
                if(stack.isEmpty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String s = "(){[]}";
        
        LeetCode20_ValidParentheses obj = new LeetCode20_ValidParentheses();
        
        System.out.println(obj.isValid(s));
    }
}

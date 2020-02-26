package string_problems;

import java.util.Stack;

public class LeetCode227_BasicCalculator2 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        int num = 0;
        int idx = 0;
        
        char sign = '+';

        
        while(idx < s.length()) {
            if(Character.isDigit(s.charAt(idx))){
                num = num * 10 + s.charAt(idx) - '0';
            }
            
            if((!Character.isDigit(s.charAt(idx)) && s.charAt(idx) != ' ') || idx == s.length() - 1) {
                if(sign == '-'){
                    stack.push(-num);
                }
                if(sign == '+'){
                    stack.push(num);
                }
                if(sign == '*'){
                    stack.push(stack.pop() * num);
                }
                if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                
                sign = s.charAt(idx);
                num = 0;
            }
            
            idx++;
        }
        
        int result = 0;
        for(int i : stack){
            result += i;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        LeetCode227_BasicCalculator2 obj = new LeetCode227_BasicCalculator2();

        String s = "3 + 2 * 2";
        
        System.out.println(obj.calculate(s));
    }

}

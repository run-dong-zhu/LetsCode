package design_problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 224, Level: Hard
 * 
 * https://leetcode.com/problems/basic-calculator/
 */
public class LeetCode224_BasicCalculator {
    
    private int helper(Queue<Character> q) {
        int num = 0;
        int prev = 0;
        int sum = 0;
        char prevOp = '+';
        
        while(!q.isEmpty()) {
            char c = q.poll();
            
            if(c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            else if(c == '(') {
                num = helper(q);
            }
            else {
                switch(prevOp) {
                    case '+':
                        sum += prev;
                        prev = num;
                        break;
                            
                    case '-':
                        sum += prev;
                        prev = -num;
                        break;
                    case '*':
                        prev *= num;
                        break;
                    case '/':
                        prev /= num;
                        break;
                }
                
                if(c == ')') {
                    break;
                }
                
                num = 0;
                prevOp = c;
            }
        }
        
        return sum + prev;
    }
    
    public int calculate(String s) {
        Queue<Character> q = new ArrayDeque<>();
        
        for(char ch : s.toCharArray()) {
            if(ch != ' ') {
                q.offer(ch);
            }
        }
        
        q.offer(' ');
        
        return helper(q);
    }
    public static void main(String[] args) {
        LeetCode224_BasicCalculator obj = new LeetCode224_BasicCalculator();

        String s = "23 * (1 + 127) - 25 + ((8 - 4) / 4)";
        
        System.out.println(obj.calculate(s));
    }

}

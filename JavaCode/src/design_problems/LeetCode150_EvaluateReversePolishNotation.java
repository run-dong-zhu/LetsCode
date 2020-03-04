package design_problems;

import java.util.Stack;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 150, Level: Medium
 * 
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class LeetCode150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) throws Exception {
        Stack<Integer> stack = new Stack<>();
        
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")) {
                a = stack.pop();
                b = stack.pop();
                
                stack.add(a + b);
            }
            else if(tokens[i].equals("-")) {
                a = stack.pop();
                b = stack.pop();
                
               stack.add(b - a);
            }
            else if(tokens[i].equals("*")) {
                a = stack.pop();
                b = stack.pop();
                
                stack.add(a * b);
            }
            else if(tokens[i].equals("/")) {
                a = stack.pop();
                b = stack.pop();
                
//                if(a == 0) {
//                	throw new ArithmeticException();
//                }
                
                stack.add(b / a);
            }
            else {
            	try {
	                int operator = Integer.parseInt(tokens[i]);
	                stack.push(operator);
            	} catch(Exception e){
            		System.out.println("Invalid token");
            		return -1;
            	}
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        LeetCode150_EvaluateReversePolishNotation obj = new LeetCode150_EvaluateReversePolishNotation();

        String[] tokens = {"4", "13", "0", "/", "+"};
//        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        try {
        	System.out.println(obj.evalRPN(tokens));
        } catch(Exception e) {
        	System.out.println(e.getMessage());
//        	System.out.println(e.toString());
//        	e.printStackTrace();
        }
    }

}

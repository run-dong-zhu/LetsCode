package design_problems;

import java.util.Stack;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 716, Level: Easy
 * 
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. 
 *             If you find more than one maximum elements, only remove the top-most one.
 */
public class LeetCode716_MaxStack {
    Stack<Integer> maxStack;
    Stack<Integer> stack;
    
    /** initialize your data structure here. */
    public LeetCode716_MaxStack() {
        maxStack = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        int max = stack.isEmpty() ? x : maxStack.peek();
        stack.add(x);
        maxStack.add(Math.max(max, x));
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        
        while(top() != max) {
            temp.add(pop());
        }
        pop();
        while(!temp.isEmpty()) {
            maxStack.add(temp.pop());
        }
        
        return max;
    }

    public static void main(String[] args) {
        LeetCode716_MaxStack obj = new LeetCode716_MaxStack();
        
        obj.push(1);
        obj.push(3);
        obj.push(5);
        obj.push(3);
        
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
    }

}

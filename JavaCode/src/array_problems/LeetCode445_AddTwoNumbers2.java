package array_problems;

import java.util.Stack;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 445, Level: Medium
 * 
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class LeetCode445_AddTwoNumbers2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }

        int x = 0;        
        ListNode node = new ListNode(0);
        
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if(!s1.isEmpty())
                x += s1.pop();
            if(!s2.isEmpty())
                x += s2.pop();
            
            node.val = x % 10;
            ListNode head = new ListNode(x / 10);
            head.next = node;
            node = head;
            x /= 10;
        }
        
        return node.val == 0 ? node.next : node;
    }
    
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int num1 = 0;
//        int num2 = 0;
//        
//        while(l1 != null) {
//            num1 = num1 * 10 + l1.val;
//            l1 = l1.next;
//        }
//        
//        while(l2 != null) {
//            num2 = num2 * 10 + l2.val;
//            l2 = l2.next;
//        }
//        
//        int sum = num1 + num2;
//        
//        ListNode head = null;
//        while(sum != 0) {
//            int num = sum % 10;
//            ListNode node = new ListNode(num);
////            ListNode next = head.next;
//            node.next = head;
//            head = node;
//            sum /= 10;
//        }
//        
//        return head;
//    }
    
    public static void main(String[] args) {
        LeetCode445_AddTwoNumbers2 obj = new LeetCode445_AddTwoNumbers2();
        
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        
        a.next = b;
        b.next = c;
        c.next = d;
        
        ListNode e = new ListNode(9);
        ListNode f = new ListNode(9);
        ListNode g = new ListNode(9);
        
        e.next = f;
        f.next = g;

        ListNode node = obj.addTwoNumbers(a, e);
        
        while(node != null) {
            if(node.next == null) {
                System.out.print(node.val);
            }
            else {
                System.out.print(node.val + " -> ");
            }
            
            node = node.next;
        }
    }

}

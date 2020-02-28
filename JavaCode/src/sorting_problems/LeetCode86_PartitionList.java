package sorting_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 86, Level: Medium
 * 
 * https://leetcode.com/problems/partition-list/
 */
public class LeetCode86_PartitionList {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode partition(ListNode head, int x) {
        ListNode greaterHead = new ListNode(0);
        ListNode greater = greaterHead;
        ListNode lessHead = new ListNode(0);
        ListNode less = lessHead;
        
        while(head != null) {
            if(head.val < x) {
                less.next = head;
                less = head;
            }
            else {
                greater.next = head;
                greater = head;
            }
            head = head.next;
        }
        
        less.next = greaterHead.next;
        greater.next = null;
        return lessHead.next;
    }

    public static void main(String[] args) {
        LeetCode86_PartitionList obj = new LeetCode86_PartitionList();
        
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        
        ListNode node = obj.partition(a, 3);
        
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

package array_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 24
 * 
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class LeetCode24_SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }    
    
    private ListNode swap(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }
        
        ListNode next = node.next;
        
        node.next = swap(next.next);
        next.next = node;
        return next;
    }
    
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }
    
    public static void main(String[] args) {
        LeetCode24_SwapNodesInPairs obj = new LeetCode24_SwapNodesInPairs();
        
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        
        a.next = b;
        b.next = c;
        c.next = d;
        
        ListNode head = obj.swapPairs(a);
        
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

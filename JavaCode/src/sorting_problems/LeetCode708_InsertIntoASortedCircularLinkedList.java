package sorting_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 708, Level: Medium
 * 
 * Given a node from a Circular Linked List which is sorted in ascending order, 
 * write a function to insert a value insertVal into the list such that it remains a sorted circular list. 
 * The given node can be a reference to any single node in the list, 
 * and may not be necessarily the smallest value in the circular list.
 * 
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. 
 * After the insertion, the circular list should remain sorted.
 * 
 * If the list is empty (i.e., given node is null), you should create a new single circular list 
 * and return the reference to that single node. Otherwise, you should return the original given node.
 * 
 * Input: head = [3,4,1], insertVal = 2
 * Output: [3,4,1,2]
 * 
 * Explanation: In the figure above, there is a sorted circular list of three elements. 
 * You are given a reference to the node with value 3, and we need to insert 2 into the list. 
 * The new node should be inserted between node 1 and node 3. After the insertion, the list should 
 * look like this, and we should still return node 3.
 */
public class LeetCode708_InsertIntoASortedCircularLinkedList {

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
    
    public Node insert(Node head, int insertVal) {
        // if start is null, create a node pointing to itself and return
        if(head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        // is start is NOT null, try to insert it into correct position
        Node cur = head;
        
        boolean loop = true;
        
        while(loop) {
            // case 1A: has a tipping point, still climbing
            if (cur.val < cur.next.val) { 
                if (cur.val <= insertVal && insertVal <= cur.next.val) { // insertVal in between cur and next
                    insertAfter(cur, insertVal);
                    loop = false;
                }
            // case 1B: has a tipping point, about to return back to min node
            } else if (cur.val > cur.next.val) { 
                if (cur.val <= insertVal || insertVal <= cur.next.val) { // cur is the tipping point, insertVal is max or min val
                    insertAfter(cur, insertVal);
                    loop = false;
                }
                // case 2: NO tipping point, all flat
            } else {
                if (cur.next == head) {  // insertVal before we traverse all nodes back to start
                    insertAfter(cur, insertVal);
                    break;
                }
            }
            // None of the above three cases met, go to next node
            cur = cur.next;
        }
        
        return head;
    }
    
    private void insertAfter(Node curr, int insertVal) {
        curr.next = new Node(insertVal, curr.next);
    }
        
    public static void main(String[] args) {
        LeetCode708_InsertIntoASortedCircularLinkedList obj = new LeetCode708_InsertIntoASortedCircularLinkedList();

        Node a = new Node(1);
        Node b = new Node(1);
        
        a.next = b;
        b.next = a;
        
        Node node = obj.insert(a, 2);
        
        System.out.print(node.val);
    }

}

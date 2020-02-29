package sorting_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 23, Level: Hard
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * Input:
 * [
 *  1->4->5,
 *  1->3->4,
 *  2->6
 *  ]
 *  
 *  Output: 1->1->2->3->4->4->5->6
 */
public class LeetCode23_MergeKSortedLists {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	 public ListNode merge(ListNode l1, ListNode l2) {
	      ListNode head = new ListNode(0);
	      ListNode result = head;
	     
	      while(l1 != null && l2 != null) {
	          if(l1.val <= l2.val) {
	              head.next = l1;
	              l1 = l1.next;
	          }
	          else {
	              head.next = l2;
	              l2 = l2.next;
	          }
	          head = head.next;
	      }
	     
	      if(l1 != null) {
	          head.next = l1;
	      }
	      if(l2 != null) {
	          head.next = l2;
	      }
	     
	      return result.next;
	  }
	
	 public ListNode mergeKLists(ListNode[] lists) {

	     if(lists.length == 0) {
	         return null;
	     }

	     if(lists.length == 1) {
	         return lists[0];
	     }

	     if(lists.length == 2) {
	         return merge(lists[0], lists[1]);
	     }

	     int mid = lists.length / 2;

	     ListNode[] firstHalf = new ListNode[mid];
	     for(int i = 0; i < mid; i++) {
	         firstHalf[i] = lists[i];
	     }

	     ListNode[] secondHalf = new ListNode[lists.length - mid];
	     for(int i = mid; i < lists.length; i++) {
	         secondHalf[i - mid] = lists[i];
	     }

	     ListNode first = mergeKLists(firstHalf);
	     ListNode second = mergeKLists(secondHalf);

	     return merge(first, second);
	 }

     public static void main(String[] args) {
	     // TODO Auto-generated method stub

	 }

}

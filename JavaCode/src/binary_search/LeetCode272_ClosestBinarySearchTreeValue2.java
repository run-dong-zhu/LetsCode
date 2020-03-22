package binary_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 272, Level: Hard
 * 
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * 
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * 
 * Example:
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 *      4
 *     / \
 *    2   5
 *   / \
 *  1   3
 * Output: [4,3]
 * 
 * 
 */
public class LeetCode272_ClosestBinarySearchTreeValue2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public void inorder(TreeNode node, double target, boolean reverse, Stack<Integer> stack) {
        if(node == null) {
            return;
        }
        
        inorder(reverse ? node.right : node.left, target, reverse, stack);
        // early terminate, no need to traverse the whole tree
        if ((reverse && node.val <= target) || (!reverse && node.val > target)) {
            return;
        }
        // track the value of current node
        stack.push(node.val);
        inorder(reverse ? node.left : node.right, target, reverse, stack);
    }
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        
        Stack<Integer> s1 = new Stack<>(); // all node.val <= target
        Stack<Integer> s2 = new Stack<>(); // all node.val > target
        
        inorder(root, target, false, s1);
        inorder(root, target, true, s2);
        
        while(k > 0) {
            if(s1.isEmpty()) {
                res.add(s2.pop());
            }
            else if(s2.isEmpty()) {
                res.add(s1.pop());
            }
            else if(Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) {
                res.add(s1.pop());
            }
            else {
                res.add(s2.pop());
            }
            k--;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        
        a.left = b;
        a.right = c;
        
        b.left = d;
        b.right = e;

        LeetCode272_ClosestBinarySearchTreeValue2 obj = new LeetCode272_ClosestBinarySearchTreeValue2();
        double target = 3.7;
        
        System.out.println(obj.closestKValues(a, target, 2));
    }

}

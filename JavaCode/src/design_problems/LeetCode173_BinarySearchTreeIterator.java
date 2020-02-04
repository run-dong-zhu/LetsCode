package design_problems;

import java.util.Stack;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 173, Level: Medium
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class LeetCode173_BinarySearchTreeIterator {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Stack<TreeNode> stack = new Stack<>();
    
    private void pushAll(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
//        for (; node != null; stack.push(node), node = node.left);
    }
    
    public LeetCode173_BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(20);
        
        a.left = b;
        a.right = c;
        
        c.left = d;
        c.right = e;
        
        LeetCode173_BinarySearchTreeIterator obj = new LeetCode173_BinarySearchTreeIterator(a);
        
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }

}

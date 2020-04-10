package searching_problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 99, Level: Hard
 * 
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class LeetCode99_RecoverBinarySearchTree {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
    
    // iterative
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            
            root = stack.removeLast();
            
            if(pred != null && root.val < pred.val) {
                y = root;
                if(x == null)
                    x = pred;
                else break;
            }
            pred = root;
            root = root.right;
        }

        swap(x, y);
    }
    
    TreeNode x = null, y = null, pred = null;

    public void findTwoSwapped(TreeNode root) {
        if(root == null) {
            return;
        }

        findTwoSwapped(root.left);
        
        if(pred != null && root.val < pred.val) {
            y = root;
            if(x == null) {
                x = pred;
            }
            else return;
        }
        pred = root;
        findTwoSwapped(root.right);
    }

    public void recoverTree2(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }
    
    public static void main(String[] args) {
        LeetCode99_RecoverBinarySearchTree obj = new LeetCode99_RecoverBinarySearchTree();
        
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);

        a.left = b;
        a.right = c;
        
        c.left = d;
        
//        obj.recoverTree(a);
        obj.recoverTree2(a);
    }

}

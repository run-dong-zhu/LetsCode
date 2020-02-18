package searching_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 103, Level: Medium
 * 
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class LeetCode103_BinaryTreeZigzagLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level = 0;
        
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
                
                list.add(node.val);
            }
            
            if(level % 2 != 0) {
                Collections.reverse(list);
            }
            
            res.add(list);
            level++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        LeetCode103_BinaryTreeZigzagLevelOrderTraversal obj = new LeetCode103_BinaryTreeZigzagLevelOrderTraversal();

        TreeNode a = new TreeNode(1);
        
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        
        a.left = b;
        a.right = c;
        
        b.left = d;
        b.right = e;
        
        c.left = f;
        c.right = g;
        
        System.out.println(obj.zigzagLevelOrder(a));
    }

}

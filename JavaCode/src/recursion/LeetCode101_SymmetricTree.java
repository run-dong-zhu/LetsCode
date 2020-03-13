package recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 101, Level: Easy
 */
public class LeetCode101_SymmetricTree {
	
	public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
	// Non-recursive method
	public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            
            if(t1 == null && t2 == null) {
                continue;
            }
            
            if(t1 == null || t2 == null) {
                return false;
            }
            
            if(t1.val != t2.val) {
                return false;
            }
            
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        
        return true;
    }

	public static void main(String[] args) {
		LeetCode101_SymmetricTree obj = new LeetCode101_SymmetricTree();

		TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        
        a.left = b;
        a.right = c;
        
        System.out.println(obj.isSymmetric(a));
	}

}

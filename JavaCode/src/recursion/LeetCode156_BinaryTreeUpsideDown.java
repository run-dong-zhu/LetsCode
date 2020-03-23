package recursion;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 156, Level: Medium
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, flip it upside down and 
 * turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 * 
 * Example:
 * Input: [1,2,3,4,5]
 * 
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * 
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 * 
 *     4
 *    / \
 *   5   2
 *       / \
 *      3   1  
 */
public class LeetCode156_BinaryTreeUpsideDown {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }
    
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;   // node 2 left children
        root.left.right = root;         // node 2 right children
        root.left = null;
        root.right = null;
        return newRoot;
    }
    
    public static void main(String[] args) {
        LeetCode156_BinaryTreeUpsideDown obj = new LeetCode156_BinaryTreeUpsideDown();
        
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        
        a.left = b;
        a.right = c;
        
        b.left = d;
        b.right = e;

        obj.upsideDownBinaryTree(a);
    }

}

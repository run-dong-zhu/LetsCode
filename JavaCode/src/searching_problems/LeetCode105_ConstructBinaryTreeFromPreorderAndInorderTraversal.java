package searching_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 105, Level: Medium
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class LeetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inIndex = 0; 

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
    
    private void preOrder(TreeNode node) {
        if(node == null)
            return;
        
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public static void main(String[] args) {
        LeetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal obj = 
                new LeetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
        
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        obj.preOrder(obj.buildTree(preorder, inorder));
    }

}

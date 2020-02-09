package searching_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 285, Level: Medium
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val.
 */
public class LeetCode285_InorderSuccessorInBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while (root != null && root.val <= p.val)
            root = root.right;
        if (root == null)
            return null;
        TreeNode left = inorderSuccessor(root.left, p);
        return (left != null && left.val > p.val) ? left : root;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(5);
        
        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;
        
        c.left = f;
        
        LeetCode285_InorderSuccessorInBST obj = new LeetCode285_InorderSuccessorInBST();
        
        System.out.println(obj.inorderSuccessor(a, d).val);
    }

}

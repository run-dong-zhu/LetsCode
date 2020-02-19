package recursion;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 129, Level: Medium
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class LeetCode129_SumRootToLeafNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
        
    private int helper(TreeNode node, int sum) {        
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return sum * 10 + node.val;
        }
        
        return helper(node.left, sum * 10 + node.val) + helper(node.right, sum * 10 + node.val);
    }
    
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        
        a.left = b;
        a.right = c;
        
        LeetCode129_SumRootToLeafNumbers obj = new LeetCode129_SumRootToLeafNumbers();
        
        System.out.println(obj.sumNumbers(a));
    }

}

package binary_search;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 270, Level: Easy
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 * 1) Given target value is a floating point.
 * 2) You are guaranteed to have only one unique value in the BST that is closest to the target.
 * 
 * Example:
 * Input: root = [4,2,5,1,3], target = 3.714286
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 * 
 * Output: 4
 */
public class LeetCode270_ClosestBinarySearchTreeValue {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        int val = root.val;
        
        while(root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root =  target < root.val ? root.left : root.right;
        }
        
        return closest;
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
        
        LeetCode270_ClosestBinarySearchTreeValue obj = new LeetCode270_ClosestBinarySearchTreeValue();
        double target = 3.7;
        System.out.println(obj.closestValue(a, target));
    }

}

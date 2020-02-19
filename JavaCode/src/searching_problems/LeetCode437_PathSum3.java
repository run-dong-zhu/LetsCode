package searching_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 437, Level: Easy
 * 
 * https://leetcode.com/problems/path-sum-iii/
 */
public class LeetCode437_PathSum3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    int count = 0;
    
    public void traverse(TreeNode node, int currSum, int target, Map<Integer, Integer> map) {
        if(node == null) {
            return;
        }
        
        currSum += node.val;
        
        // if map contains currSum - target => subtree contains target
        if(map.containsKey(currSum - target)) {
            count += map.get(currSum - target);
        }
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        traverse(node.left, currSum, target, map);
        traverse(node.right, currSum, target, map);
        
        map.put(currSum, map.get(currSum) - 1);
    }
    
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        traverse(root, 0, sum, map);
        
        return count;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(11);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(-2);
        TreeNode i = new TreeNode(1);
        
        a.left = b;
        a.right = c;
        
        b.left = d;
        b.right = e;
        
        c.right = f;
        
        d.left = g;
        d.right = h;
        
        e.right = i;
        
        LeetCode437_PathSum3 obj = new LeetCode437_PathSum3();
        
        System.out.println(obj.pathSum(a, 8));
    }

}

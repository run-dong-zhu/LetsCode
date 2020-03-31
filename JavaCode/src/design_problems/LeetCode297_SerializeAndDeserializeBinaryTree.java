package design_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 297, Level: Hard
 * 
 * Note: Do not use class member/global/static variables to store states. 
 * Your serialize and deserialize algorithms should be stateless.
 */
public class LeetCode297_SerializeAndDeserializeBinaryTree {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serHelper(root, sb);
        
        return sb.toString();
    }
    
    private void serHelper(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append('#');
            return;
        }
        
        sb.append((char)(node.val + '0'));
        
        serHelper(node.left, sb);
        serHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return desHelper(data, new int[1]);
    }
    
    public TreeNode desHelper(String data, int[] ptr) {
        if(data.charAt(ptr[0]) == '#') {
            return null;
        }
        
        TreeNode root = new TreeNode(data.charAt(ptr[0]) - '0');
        
        ptr[0]++;
        TreeNode left = desHelper(data, ptr);
        ptr[0]++;
        TreeNode right = desHelper(data, ptr);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    public static void main(String[] args) {
        LeetCode297_SerializeAndDeserializeBinaryTree obj = new LeetCode297_SerializeAndDeserializeBinaryTree();

        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(20);
        
        a.left = b;
        a.right = c;
        
        c.left = d;
        c.right = e;
        
        String data = obj.serialize(a);
        TreeNode root = obj.deserialize(data);
        
        System.out.println(root.val);
    }

}

package searching_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author run-dong-zhu
 *
 */
public class LeetCode133_CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    
    // Breadth First Search
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        
        while(!q.isEmpty()) {
            Node originNode = q.poll();
            
            for(Node neighbor : originNode.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    q.add(neighbor);
                }
                
                map.get(originNode).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
    
    // Depth First Search
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraphDFS(Node node) {
        if (node == null) {
            return node;
        }

        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraphDFS(neighbor));
        }
        
        return cloneNode;
    }
    
    public static void main(String[] args) {
       Node a = new Node(1);
       Node b = new Node(2);
       Node c = new Node(3);
       Node d = new Node(4);
       
       a.neighbors = Arrays.asList(b, d);
       b.neighbors = Arrays.asList(a, c);
       c.neighbors = Arrays.asList(b, d);
       d.neighbors = Arrays.asList(a, c);
       
       LeetCode133_CloneGraph obj = new LeetCode133_CloneGraph();
       
       System.out.println(obj.cloneGraph(a).val);
       System.out.println(obj.cloneGraphDFS(a).val);
    }

}

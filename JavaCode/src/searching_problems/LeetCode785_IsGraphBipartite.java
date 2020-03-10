package searching_problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 785, Level: Medium
 * 
 */
public class LeetCode785_IsGraphBipartite {
    
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++) {
            if(visited[i] != 0) {
                continue;
            }
            
            Queue<Integer> q = new LinkedList<>();
            
            // init first graph
            visited[i] = 1;
            q.offer(visited[0]);
            
            while(!q.isEmpty()) {
                int node = q.poll();
                int color = visited[node];
                
                int neighborColor = color == 1 ? 2 : 1;
                
                for(int neighbor : graph[node]) {
                    if(visited[neighbor] == 0) {
                        visited[neighbor] = neighborColor;
                        q.add(neighbor);
                    }
                    else if(visited[neighbor] != neighborColor) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) { 
        LeetCode785_IsGraphBipartite obj = new LeetCode785_IsGraphBipartite();
        
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        
        System.out.println(obj.isBipartite(graph));
    }

}

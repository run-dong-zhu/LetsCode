package searching_problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 286, Level: Medium
 * 
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume 
 * that the distance to a gate is less than 2147483647.
 * 
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * 
 * Example: 
 * Given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * 
 * After running your function, the 2D grid should be:
 * 
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 */
public class LeetCode286_WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();

        // add all gates in queue
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0];
            int col = top[1];

            if(row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[] {row - 1, col});
            }
            if(row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[] {row + 1, col});
            }
            if(col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[] {row, col - 1});
            }
            if(col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[] {row, col + 1});
            }
        }
    }
    
    public static void main(String[] args) {
        LeetCode286_WallsAndGates obj = new LeetCode286_WallsAndGates();

        int INF = Integer.MAX_VALUE;
        
        int[][] rooms = {{INF, -1, 0, INF},
                         {INF, INF, INF, -1},
                         {INF, -1, INF, -1},
                         {0, -1, INF, INF}};
        
        obj.wallsAndGates(rooms);
        
        for(int[] room : rooms) {
            for(int r : room) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}

package searching_problems;

import java.util.PriorityQueue;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 407, Level: Hard
 * 
 * https://leetcode.com/problems/trapping-rain-water-ii/
 */
public class LeetCode407_TrappingRainWater2 {
    
    class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;
        
        Cell(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }
        
        public int compareTo(Cell otherCell) {
            if(this.height == otherCell.height) {
                return 0;
            }
            if(this.height > otherCell.height) {
                return 1;
            }
            return -1;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length < 1) {
            return 0;
        }
        
        int row = heightMap.length;
        int col = heightMap[0].length;
        
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        boolean[][] visited = new boolean[row][col];
        
        for(int r = 0; r < row; r++) {
            visited[r][0] = true;
            heap.offer(new Cell(r, 0, heightMap[r][0]));
            
            visited[r][col - 1] = true;
            heap.offer(new Cell(r, col - 1, heightMap[r][col - 1]));
        }
        
        for(int c = 0; c < col; c++) {
            visited[0][c] = true;
            heap.offer(new Cell(0, c, heightMap[0][c]));
            
            visited[row - 1][c] = true;
            heap.offer(new Cell(row - 1, c, heightMap[row - 1][c]));
        }
        
        int res = 0;
        
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        while(!heap.isEmpty()) {
            Cell curr = heap.poll();
            
            int r = curr.row;
            int c = curr.col;
            int h = curr.height;
            
            for(int[] dir : dirs) {
                int rr = r + dir[0];
                int cc = c + dir[1];
                if(rr > 0 && rr < row - 1 && cc > 0 && cc < col - 1 && !visited[rr][cc]) {
                    visited[rr][cc] = true;
                    res += Math.max(0, h - heightMap[rr][cc]);
                    heap.offer(new Cell(rr, cc, Math.max(h, heightMap[rr][cc])));
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        LeetCode407_TrappingRainWater2 obj = new LeetCode407_TrappingRainWater2();

        int[][] heightMap = {{1, 4, 3, 1, 3, 2},
                             {3, 2, 1 ,3, 2, 4},
                             {2, 3, 3, 2, 3, 1}};
        
        System.out.println(obj.trapRainWater(heightMap));
    }

}

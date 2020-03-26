package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 361, Level: Medium
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall 
 * since the wall is too strong to be destroyed.
 * 
 * Note: You can only put the bomb at an empty cell.
 * 
 * Example:
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3 
 * 
 * Explanation: For the given grid,
 * 0 E 0 0 
 * E 0 W E 
 * 0 E 0 0
 * Placing a bomb at (1,1) kills 3 enemies.
 */
public class LeetCode361_BombEnemy {
    
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int max = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[] cols = new int[n]; // record bombs in each col
        
        for(int i = 0; i < m; i++) {
            int rows = 0; // record bombs in this row
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0') {
                    int total = rows + cols[j];
                    // vertical check
                    for(int k = j + 1; k < n && grid[i][k] != 'W'; k++) {
                        if(grid[i][k] == 'E') {
                            total++;
                        }
                    }
                    
                    // horizontal check
                    for(int k = i + 1; k < m && grid[k][j] != 'W'; k++) {
                        if(grid[k][j] == 'E') {
                            total++;
                        }
                    }
                    
                    max = Math.max(max, total);
                } else if(grid[i][j] == 'W') {
                    rows = 0;
                    cols[j] = 0;
                } else {
                    rows++;
                    cols[j]++;
                }
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        LeetCode361_BombEnemy obj = new LeetCode361_BombEnemy();
        
        char[][] grid = {{'0', 'E', '0', '0'}, 
                         {'E', '0', 'W', 'E'}, 
                         {'0', 'E', '0', '0'}};
        
        
        System.out.println(obj.maxKilledEnemies(grid));
    }
}

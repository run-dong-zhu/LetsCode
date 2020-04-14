package searching_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 79, Level: Medium
 * 
 * https://leetcode.com/problems/word-search/
 */
public class LeetCode79_WordSearch {

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private boolean dfs(char[][] board, String word, int i, int row, int col) {
        if(i == word.length()) {
            return true;
        }
        
        if(row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(i)) {
            return false;
        }
        
        board[row][col] = '#';
        
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            
            if(dfs(board, word, i + 1, r, c)) {
                return true;
            }
        }
        
        board[row][col] = word.charAt(i);
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] == word.charAt(0)) {
                    if(dfs(board, word, 0, r, c)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        LeetCode79_WordSearch obj = new LeetCode79_WordSearch();
        
        char[][] board = {{'A', 'B', 'C', 'E'},
                          {'S', 'F', 'E', 'S'},
                          {'A', 'D', 'E', 'E'}};
        
        String word = "ABCESEEEFS";
        
        System.out.println(obj.exist(board, word));
    }

}

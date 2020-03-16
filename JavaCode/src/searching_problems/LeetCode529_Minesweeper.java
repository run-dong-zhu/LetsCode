package searching_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 529, Level: Medium
 * 
 * https://leetcode.com/problems/minesweeper/
 */
public class LeetCode529_Minesweeper {
    int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];

        int row = board.length;
        int col = board[0].length;

        if(board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        char mine = '0';

        for(int[]dir : dirs) {
            int rr = r + dir[0];
            int cc = c + dir[1];

            if(rr >= 0 && rr < row && cc >= 0 && cc < col && board[rr][cc] == 'M') {
                mine++;
            }
        }

        if(mine != '0') {
            board[r][c] = mine;
            return board;
        }

        board[r][c] = 'B';

        for(int[]dir : dirs) {
            int rr = r + dir[0];
            int cc = c + dir[1];

            if(rr >= 0 && rr < row && cc >= 0 && cc < col && board[rr][cc] == 'E') {
                updateBoard(board, new int[] {rr, cc});
            }
        }

        return board;
    }

    public static void main(String[] args) {
        LeetCode529_Minesweeper obj = new LeetCode529_Minesweeper();

        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                          {'E', 'E', 'M', 'E', 'E'},
                          {'E', 'E', 'E', 'E', 'E'},
                          {'E', 'E', 'E', 'E', 'E'}};
        
        int[] click = {3, 0};
        
        char[][] res = obj.updateBoard(board, click);
        
        for(char[] re : res) {
            for(char r : re) {
                System.out.print(r);
            }
            System.out.println();
        }
    }

}

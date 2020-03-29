package design_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 348, Level: Medium
 * 
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * 
 * You may assume the following rules:
 * 1) A move is guaranteed to be valid and is placed on an empty block.
 * 2) Once a winning condition is reached, no more moves is allowed.
 * 3) A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * 
 * Follow up:
 * Could you do better than O(n^2) per move() operation?
 */
public class LeetCode348_TicTacToe {
    
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int n;
    
    /** Initialize your data structure here. */
    public LeetCode348_TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. 
    */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        
        rows[row] += toAdd;
        cols[col] += toAdd;
        
        if(row == col) {
            diagonal += toAdd;
        }
        
        if(row + col == n - 1) {
            antiDiagonal += toAdd;
        }
        
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        LeetCode348_TicTacToe toe = new LeetCode348_TicTacToe(3);

        System.out.print(toe.move(0, 0, 1));
        System.out.print(toe.move(0, 2, 2));
        System.out.print(toe.move(2, 2, 1));
        System.out.print(toe.move(1, 1, 2));
        System.out.print(toe.move(2, 0, 1));
        System.out.print(toe.move(1, 0, 2));
        System.out.print(toe.move(2, 1, 1));
    }

}

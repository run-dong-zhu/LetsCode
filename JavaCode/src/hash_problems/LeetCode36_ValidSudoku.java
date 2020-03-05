package hash_problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 36, Level: Medium
 * 
 * https://leetcode.com/problems/valid-sudoku/
 */
public class LeetCode36_ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for(int r = 0; r < 9; r++) {
			Set<Character> row = new HashSet<>();
			Set<Character> col = new HashSet<>();
			Set<Character> cube = new HashSet<>();
			
			for(int c = 0; c < 9; c++) {
				if(board[r][c] != '.' && !row.add(board[r][c])) {
					return false;
				}
				if(board[c][r]!='.' && !col.add(board[c][r]))
	                return false;
	            int RowIndex = 3 * (r / 3);
	            int ColIndex = 3 * (r % 3);
	            if(board[RowIndex + c / 3][ColIndex + c % 3] != '.' 
	            		&& !cube.add(board[RowIndex + c / 3][ColIndex + c % 3]))
	                return false;
	            }
		}
		return true;
    }

	public static void main(String[] args) {
		LeetCode36_ValidSudoku obj = new LeetCode36_ValidSudoku();

		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
				  		  {'6','.','.','1','9','5','.','.','.'},
				  		  {'.','9','8','.','.','.','.','6','.'},
				  		  {'8','.','.','.','6','.','.','.','3'},
				  		  {'4','.','.','8','.','3','.','.','1'},
				  		  {'7','.','.','.','2','.','.','.','6'},
				  		  {'.','6','.','.','.','.','2','8','.'},
				  		  {'.','.','.','4','1','9','.','.','5'},
				  		  {'.','.','.','.','8','.','.','7','9'}};
		
		System.out.println(obj.isValidSudoku(board));
	}

}

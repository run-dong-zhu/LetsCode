package array_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 73, Level: Medium
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * 
 * Example 1:
 * 
 * Input: 
 * [
 *  [1,1,1],
 *  [1,0,1],
 *  [1,1,1]
 * ]
 * 
 * Output: 
 * [
 *  [1,0,1],
 *  [0,0,0],
 *  [1,0,1]
 * ]
 * 
 * Follow up:
 * 1) A straight forward solution using O(mn) space is probably a bad idea.
 * 2) A simple improvement uses O(m + n) space, but still not the best solution.
 * 3) Could you devise a constant space solution?
 */
public class LeetCode73_SetMatrixZeroes {
    
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {
            if(matrix[i][0] == 0) {
                isCol = true;
            }

            for(int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        LeetCode73_SetMatrixZeroes obj = new LeetCode73_SetMatrixZeroes();

        int[][] matrix = {{0, 1, 2, 0},
                        {3, 4, 5, 2},
                        {1, 3, 1, 5}};
        
        obj.setZeroes(matrix);
    }

}

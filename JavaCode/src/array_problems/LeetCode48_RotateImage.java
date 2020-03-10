package array_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 48, Level: Medium
 * 
 * https://leetcode.com/problems/rotate-image/
 */
public class LeetCode48_RotateImage {
	
	public void rotate(int[][] matrix) {
		int s = 0;
		int n = matrix.length - 1;
		
		// reverse matrix top down
	    while(s < n){
	        int[] temp = matrix[s];
	        matrix[s] = matrix[n];
	        matrix[n] = temp;
	        s++;
	        n--;
	    }

	    // swap 
	    for(int r = 0; r < matrix.length; r++){
	        for(int c = r + 1; c < matrix[r].length; c++){
	            int temp = matrix[r][c];
	            matrix[r][c] = matrix[c][r];
	            matrix[c][r] = temp;
	        }
	    }
    }

	public static void main(String[] args) {
		LeetCode48_RotateImage obj = new LeetCode48_RotateImage();
		
		int[][] matrix = {{5, 1, 9, 11},
				  		  {2, 4, 8, 10},
				  		  {13, 3, 6, 7},
				  		  {15, 14, 12, 16}};

		
		obj.rotate(matrix);
		
		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}
}

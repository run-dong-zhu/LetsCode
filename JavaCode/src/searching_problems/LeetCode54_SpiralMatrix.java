package searching_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 54, Level: Medium
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class LeetCode54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        if(matrix.length == 0) {
            return res;
        }
        
        int rBegin = 0, cBegin = 0;
        int rEnd= matrix.length - 1;
        int cEnd = matrix[0].length - 1;
        
        while(rBegin <= rEnd && cBegin <= cEnd) {
            // left2right
            for(int i = cBegin; i <= cEnd; i++) {
                res.add(matrix[rBegin][i]);
            }
            rBegin++;
            
            // up2down
            for(int i = rBegin; i <= rEnd; i++) {
                res.add(matrix[i][cEnd]);
            }
            cEnd--;
            
            if(rBegin <= rEnd) {
                // right2left
                for(int i = cEnd; i >= cBegin; i--) {
                    res.add(matrix[rEnd][i]);
                }
            }
            rEnd--;
            
            if(cBegin <= cEnd) {
                // down2up
                for(int i = rEnd; i >= rBegin; i--) {
                    res.add(matrix[i][cBegin]);
                }
            }
            cBegin++;
        }
        
        return res;
    }

    public static void main(String[] args) {
        LeetCode54_SpiralMatrix obj = new LeetCode54_SpiralMatrix();

//        int[][] matrix = {{1, 2, 3},
//                          {4, 5, 6},
//                          {7, 8, 9}};
        
        int[][] matrix = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12}};
        
        System.out.println(obj.spiralOrder(matrix));
    }

}

package greedy;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 1007, Level: Medium
 * 
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class LeetCode1007_MinimumDominoRotationForEqualRow {
    
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); ++i) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); ++i) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode1007_MinimumDominoRotationForEqualRow obj = new LeetCode1007_MinimumDominoRotationForEqualRow();

        int[] A = {2, 5, 2, 2, 2};
        int[] B = {1, 2, 3, 4, 5};
        
        System.out.println(obj.minDominoRotations(A, B));
    }

}

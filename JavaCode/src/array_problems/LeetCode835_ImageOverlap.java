package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 835, Level: Medium
 * 
 * https://leetcode.com/problems/image-overlap/
 */
public class LeetCode835_ImageOverlap {

	public int largestOverlap(int[][] A, int[][] B) {
		int N = A.length;
		
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i = 0; i < N * N; ++i) {
            if (A[i / N][i % N] == 1) {
                LA.add(i / N * 100 + i % N);
            }
        }
        for(int i = 0; i < N * N; ++i) {
            if (B[i / N][i % N] == 1) {
                LB.add(i / N * 100 + i % N);
            }
        }
        for(int i : LA) { 
        	for(int j : LB) {
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        	}
        }
        
        int res = 0;
        for(int i : count.values()) {
            res = Math.max(res, i);
        }
        return res;
    }
	
	public static void main(String[] args) {
		LeetCode835_ImageOverlap obj = new LeetCode835_ImageOverlap();

		int[][] A = {{1, 1, 0},
	            	 {0, 1, 0},
	            	 {0, 1, 0}};
		
		int[][] B = {{0, 0, 0},
					 {0, 1, 1},
					 {0, 0, 1}};
		
		
		System.out.println(obj.largestOverlap(A, B));
	}

}

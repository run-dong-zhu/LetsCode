package dynamic_programming;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 801, Level: Medium
 * 
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 */
public class LeetCode801_MinimumSwapsToMakeSequencesIncreasing {
	
	public int minSwap(int[] A, int[] B) {
	    // swapRecord means for the ith element in A and B, the minimum swaps if we swap A[i] and B[i]
	    // fixRecord means for the ith element in A and B, the minimum swaps if we DONOT swap A[i] and B[i]
        int swapRecord = 1, fixRecord = 0;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
            	// In this case, the ith manipulation should be same as the i-1th manipulation
                // fixRecord = fixRecord;
                swapRecord++;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
            	// In this case, the ith manipulation should be the opposite of the i-1th manipulation
                int temp = swapRecord;
                swapRecord = fixRecord + 1;
                fixRecord = temp;
            } else {
                // Either swap or fix is OK. Let's keep the minimum one
                int min = Math.min(swapRecord, fixRecord);
                swapRecord = min + 1;
                fixRecord = min;
            }
        }
        return Math.min(swapRecord, fixRecord);
    }

	public static void main(String[] args) {
		LeetCode801_MinimumSwapsToMakeSequencesIncreasing obj = new LeetCode801_MinimumSwapsToMakeSequencesIncreasing();

//		int[] A = {0, 3, 5, 8, 9};
//		int[] B = {2, 1, 4, 6, 9};
		
		int[] A = {0, 4, 4, 5, 9};
        int[] B = {0, 1, 6, 8, 10};
		
		System.out.println(obj.minSwap(A, B));
	}

}

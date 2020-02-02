package sorting_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 56, Level: medium
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class LeetCode56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
    
        for (int[] interval : intervals) {
            if (interval[0] <= end) { // Overlapping intervals, move the end if needed
                end = Math.max(end, interval[1]);
            }
            else {                  // Disjoint intervals, add the previous one and reset bounds
                result.add(new int[] {start, end});
                start = interval[0];
                end = interval[1];
            }
        }
    
        // Add the last interval
        result.add(new int[] {start, end});
        
        int[][] res = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }

    public static void main(String[] args) {
        LeetCode56_MergeIntervals obj = new LeetCode56_MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        
        int[][] res = obj.merge(intervals);
        for(int[] re : res) {
            System.out.println("[" + re[0] + ", " + re[1] + "]");
        }
    }

}

package sorting_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 57, Level: Hard
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class LeetCode57_InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {        
        List<int[]> list = new ArrayList<>();
        
        int start = newInterval[0];
        int end = newInterval[1];
        
        int idx = 0;
        
        // greedy get all small intervals
        while(idx < intervals.length && intervals[idx][1] < start) {
            list.add(intervals[idx++]);
        }
        
        while(idx < intervals.length && intervals[idx][0] <= end) {
            int s = intervals[idx][0];
            int e = intervals[idx][1];
            
            if(s < start) {
                start = s;
            }
            
            if(end < e) {
                end = e;
            }
            
            idx++;
        }
        
        list.add(new int[] {start, end});
        
        while(idx < intervals.length) {
            list.add(intervals[idx++]);
        }
        
//        int[][] res = new int[list.size()][2];
//        
//        for(int i = 0; i < res.length; i++) {
//            res[i] = list.get(i);
//        }
//        
//        return res;
        
        return list.toArray(new int[list.size()][2]);
    }
    
    public static void main(String[] args) {
        LeetCode57_InsertInterval obj = new LeetCode57_InsertInterval();
        
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] res = obj.insert(intervals, newInterval);
        
        for(int[] r : res) {
            System.out.print(r[0] + "-" + r[1] + " ");
        }
    }

}

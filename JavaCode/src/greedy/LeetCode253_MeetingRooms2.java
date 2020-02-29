package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 253, Level: Medium
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * 
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class LeetCode253_MeetingRooms2 {
    
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals.length;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.offer(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        
        return pq.size();
    }

    public static void main(String[] args) {
        LeetCode253_MeetingRooms2 obj = new LeetCode253_MeetingRooms2();
        
//        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals = {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
        System.out.println(obj.minMeetingRooms(intervals));
    }

}

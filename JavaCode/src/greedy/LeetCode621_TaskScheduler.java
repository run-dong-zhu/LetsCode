package greedy;

import java.util.Arrays;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 621, Level: Medium
 * 
 * Given a char array representing tasks CPU need to do. It contains capital letters 
 * A to Z where different letters represent different tasks. Tasks could be done without 
 * original order. Each task could be done in one interval. For each interval, CPU 
 * could finish one task or just be idle. However, there is a non-negative cooling interval 
 * n that means between two same tasks, there must be at least n intervals that CPU are doing 
 * different tasks or just be idle. You need to return the least number of intervals the CPU 
 * will take to finish all the given tasks.
 */
public class LeetCode621_TaskScheduler {
    
    public int leastInterval(char[] tasks, int n) {
        int[] charSet = new int[26];
        
        for(char task : tasks) {
            charSet[task - 'A']++;
        }
        
        Arrays.sort(charSet);
        
        int i = 25;
        
        // calculating the tail
        while(i >= 0 && charSet[i] == charSet[25]) {
            i--;
        }
        
        // charSet[25] - 1 -> Most frequent task, n + 1 -> intervals, 
        return Math.max(tasks.length, (charSet[25] - 1) * (n + 1) + 25 - i);
    }

    public static void main(String[] args) {
        LeetCode621_TaskScheduler obj = new LeetCode621_TaskScheduler();

//        char[] tasks = {'A', 'B', 'C', 'A', 'B', 'C', 'A', 'B', 'C'};
        
//        String s = "AACCCBEEE";
        String s = "CCCBEEE";
        char[] tasks = s.toCharArray();
        
        System.out.println(obj.leastInterval(tasks, 1));
    }

}

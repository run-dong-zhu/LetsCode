package hash_problems;

import java.util.Stack;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 739, Level: Medium
 *
 * Given a list of daily temperatures T, return a list such that, for each day in the input, 
 * tells you how many days you would have to wait until a warmer temperature. 
 * If there is no future day for which this is possible, put 0 instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class LeetCode739_DailyTemperatures {
    
    public int[] dailyTemperatures(int[] T) {
//        // brute force
//        int[] res = new int[T.length];
//
//        if(T.length == 0)
//            return res;
//
//        res[res.length - 1] = 0;
//
//        for(int i = 0; i < res.length - 1; i++) {
//            if(T[i + 1] > T[i]) {
//                res[i] = 1;
//            }
//            else {
//                int j = i + 2;
//                
//                while(j < res.length && T[j] <= T[i]) {
//                    j++;
//                }
//                
//                if(j >= res.length) {
//                    res[i] = 0;
//                }
//                
//                else{
//                    res[i] = j - i;
//                }
//            }
//        }
//
//        return res;
     
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode739_DailyTemperatures obj = new LeetCode739_DailyTemperatures();

        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        
        for(int day : obj.dailyTemperatures(T)) {
            System.out.print(day + " ");
        }
    }

}

package sorting_problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 239, Level: Hard
 */
public class LeetCode239_SlidingWindowMaximum {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        if(n == 0) {
            return nums;
        }
        
		int[] res = new int[n - k + 1]; // n - k + 1 is the num of windows
        
		// store index
		Deque<Integer> dq = new ArrayDeque<>();
        
		for (int i = 0; i < n; i++) {
			// remove numbers out of range k
			while (!dq.isEmpty() && dq.peek() < i - k + 1) {
				// i - k + 1 is the window
				dq.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}
			// q contains index... r contains content
			dq.offer(i);
			if (i - k + 1 >= 0) {
				res[i - k + 1] = nums[dq.peek()];
			}
		}
		
		return res;
    }

	public static void main(String[] args) {
		LeetCode239_SlidingWindowMaximum obj = new LeetCode239_SlidingWindowMaximum();
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		
		int[] result = obj.maxSlidingWindow(nums, 3);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}

}

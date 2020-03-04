package greedy;

import java.util.Arrays;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 1231, Level: Hard
 * 
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
 * You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces 
 * using K cuts, each piece consists of some consecutive chunks.
 * 
 * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
 * 
 * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
 * 
 * Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * Output: 6
 * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
 * 
 * Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
 * Output: 5
 * Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 */
public class LeetCode1231_DivideChocolate {
	
	public int maximizeSweetness(int[] sweetness, int K) {
        int left = 0, right = Arrays.stream(sweetness).sum() / (K + 1);
        
        while(left < right) {
        	int mid = (left + right + 1) / 2;
        	int cuts = 0;
        	
        	for (int i = 0, cur = 0; i < sweetness.length; ++i) {
        		cur += sweetness[i];
                if (cur >= mid) {
                    cur = 0;
                    cuts++;
//                    if (++cuts > K) break;
                }
            }
            if (cuts > K)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

	public static void main(String[] args) {
		LeetCode1231_DivideChocolate obj = new LeetCode1231_DivideChocolate();

		int[] sweetness = {1, 2, 2, 1, 2, 2, 1, 2, 2};
		
		System.out.println(obj.maximizeSweetness(sweetness, 2));
	}

}

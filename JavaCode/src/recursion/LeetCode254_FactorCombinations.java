package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 254
 * 
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.  
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * 
 * Note:
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * 
 * Example 1:
 * Input: 1
 * Output: []
 * 
 * Example 2:
 * Input: 37
 * Output:[]
 * 
 * Example 3:
 * Input: 12
 * Output:
 * [
 *  [2, 6],
 *  [2, 2, 3],
 *  [3, 4]
 * ]
 */
public class LeetCode254_FactorCombinations {

    private void helper(int n, int d, List<Integer> list, List<List<Integer>> res) {
        if(n <= 1) {
            if(list.size() > 1)
                res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = d; i <= n; i++) {
            if(n % i == 0) {
                list.add(i);
                
                helper(n / i, i, list, res);
                
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        helper(n, 2, list, res);
        
        return res;
    }
    
    public static void main(String[] args) {
        LeetCode254_FactorCombinations obj = new LeetCode254_FactorCombinations();

        System.out.println(obj.getFactors(12));
    }

}

package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 46, Level: Medium
 * 
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 */
public class LeetCode46_Permutations {

    public void helper(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                if(list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                helper(nums, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        helper(nums, list, res);
        return res;
    }
    
    public static void main(String[] args) {
        LeetCode46_Permutations obj = new LeetCode46_Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(obj.permute(nums));
    }

}

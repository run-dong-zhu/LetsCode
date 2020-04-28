package greedy;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 45, Level: Hard
 * 
 * https://leetcode.com/problems/jump-game-ii/
 */
public class LeetCode45_JumpGame2 {
    
    public int jump(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        
        int jump = 1;
        // max step based on current position
        int currentMax = nums[0];
        // max step within currentMax
        int maxStep = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int step = i + nums[i];
            if(i > currentMax) {
                jump++;
                currentMax = maxStep;
            }
            if(maxStep < step) {
                maxStep = step;
            }
        }
        
        return jump;
    }

    public static void main(String[] args) {
        LeetCode45_JumpGame2 obj = new LeetCode45_JumpGame2();

        int[] nums = {2, 3, 1, 1, 4};
        
        System.out.println(obj.jump(nums));
    }

}

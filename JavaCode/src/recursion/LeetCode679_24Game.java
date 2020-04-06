package recursion;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 679, Level: Hard
 * 
 * https://leetcode.com/problems/24-game/
 */
public class LeetCode679_24Game {

    public boolean judgePoint24(int[] nums) {
        double[] array = new double[] {nums[0], nums[1], nums[2], nums[3]};
        
        return helper(array);
    }
    
    private boolean helper(double[] array) {
        if(array.length == 1) {
            return Math.abs(array[0] - 24) < 0.01;
        }
        
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                double[] b = new double[array.length - 1];
                
                for(int k = 0, index = 0; k < array.length; k++) {
                    if(k != i && k != j) {
                        b[index++] = array[k];
                    }
                }
                
                for(double d : compute(array[i], array[j])) {
                    b[b.length - 1] = d;
                    
                    if(helper(b)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private double[] compute(double x,  double y) {
        return new double[] {x + y, x - y, x * y, x / y, y - x, y / x};
    }
    
    public static void main(String[] args) {
        LeetCode679_24Game obj = new LeetCode679_24Game();

        int[] nums = {4, 1, 8, 7};
        
        System.out.println(obj.judgePoint24(nums));
    }

}

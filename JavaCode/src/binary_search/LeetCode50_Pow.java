package binary_search;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 50, Level: Medium
 *
 * https://leetcode.com/problems/powx-n/
 */
public class LeetCode50_Pow {

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        
        double half = fastPow(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    
    public double myPow(double x, int n) {
        long N = n; // long type avoid stack overflow
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
    
    public static void main(String[] args) {
        LeetCode50_Pow obj = new LeetCode50_Pow();

        System.out.println(obj.myPow(1.0, -2147483648));
    }

}

package string_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 190, Level: Easy
 * 
 * https://leetcode.com/problems/reverse-bits/
 */
public class LeetCode190_ReverseBits {
    
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if(i < 31) // CATCH: for last digit, don't shift! Because in the first step we shift result once more.
                result <<= 1;
        }
        return result;
    }
    
    public static void main(String[] args) {
//        System.out.println(Integer.SIZE + ", " + Integer.BYTES);
        
        LeetCode190_ReverseBits obj = new LeetCode190_ReverseBits();

        int n = Integer.MIN_VALUE;
        
        System.out.println(obj.reverseBits(n));
    }
}

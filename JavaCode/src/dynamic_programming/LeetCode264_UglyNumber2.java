package dynamic_programming;

/**
 * 
 * @description LeetCode 264, level: Medium
 * 
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * 
 * Example:
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 */
public class LeetCode264_UglyNumber2 {

    public int nthUglyNumber(int n) {
        if(n <= 1) {
            return n;
        }
        
        int[] uglyArr = new int[n];
        uglyArr[0] = 1;
            
        int mul2 = 2;
        int mul3 = 3;
        int mul5 = 5;
        
        int i2  = 0;
        int i3  = 0;
        int i5  = 0;
        
        for(int i = 1; i < n; i++) {
            uglyArr[i] = Math.min(mul2, Math.min(mul3, mul5));
            
            if(uglyArr[i] == mul2) {
                i2++;
                mul2 = uglyArr[i2] * 2;
            }
            if(uglyArr[i] == mul3) {
                i3++;
                mul3 = uglyArr[i3] * 3;
            }
            if(uglyArr[i] == mul5) {
                i5++;
                mul5 = uglyArr[i5] * 5;
            }
        }
        
        return uglyArr[n - 1];
    }
    
    public static void main(String[] args) {
        LeetCode264_UglyNumber2 obj = new LeetCode264_UglyNumber2();
        System.out.println(obj.nthUglyNumber(10));
    }

}

package greedy;

import java.util.Arrays;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 135, Level: Hard
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * 1) Each child must have at least one candy.
 * 2) Children with a higher rating get more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 */
public class LeetCode135_Candy {
    
    public int candy(int[] ratings) {
        int[] left2Right = new int[ratings.length];
        int[] right2Left = new int[ratings.length];
        // goal 1
        Arrays.fill(left2Right, 1);
        Arrays.fill(right2Left, 1);
        
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                left2Right[i] = left2Right[i - 1] + 1;
            }
        }
        
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right2Left[i] = right2Left[i + 1] + 1;
            }
        }
        
        int sum = 0;
        
        for(int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2Right[i], right2Left[i]);
        }
        
        return sum;
    }

    public static void main(String[] args) {
        LeetCode135_Candy obj = new LeetCode135_Candy();

        int[] ratings = {1, 0, 2};
        
        System.out.print(obj.candy(ratings));
    }

}

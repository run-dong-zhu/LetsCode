package hash_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 149, Level: Hard
 * 
 * 
 */
public class LeetCode149_MaxPointsOnALine {

    public double getSlope(int[] a, int[] b) {
        return (b[1] - a[1]) / (b[0] - a[0]);
    }
    
    public int maxPoints(int[][] points) {
        if(points.length < 2) {
            return points.length;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

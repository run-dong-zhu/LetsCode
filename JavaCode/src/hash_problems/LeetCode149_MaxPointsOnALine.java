package hash_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 149, Level: Hard
 * 
 * 
 */
public class LeetCode149_MaxPointsOnALine {
    
    private boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    public double getSlope(int[] a, int[] b) {
        if(a[0] == b[0])
            return Double.MAX_VALUE;
        if(a[1] == b[1])
            return 0;
        
        return ((double)b[1] - a[1]) / (double)(b[0] - a[0]);
    }
    
    public int maxPoints(int[][] points) {
        int n = points.length;
        
        if(n < 2) {
            return n;
        }
        
        int max = 1;
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            int[] point = points[i];
            
            if(set.contains(point[0] + "-" + point[1])) {
                continue;
            }
            
            int same = 0;
            int localMax = 1;
            Map<Double, Integer> map = new HashMap<>();
            
            for(int j = i + 1; j < n; j++) {
                if(isSame(point, points[j])) {
                    same++;
                    continue;
                }
                
                double slope = getSlope(point, points[j]);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            
            set.add(point[0] + "-" + point[1]);
            max = Math.max(max, localMax + same);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        LeetCode149_MaxPointsOnALine obj = new LeetCode149_MaxPointsOnALine();

        int[][] points = {{84, 250}, {0, 0}, {1, 0}, {0, -70}, {0, -70}, {1, -1}, {21, 10}, {42, 90}, {-42, -230}};
        
        System.out.println(obj.maxPoints(points));
    }

}

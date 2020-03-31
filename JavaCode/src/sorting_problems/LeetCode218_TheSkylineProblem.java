package sorting_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 
 * @author zhurundong
 * @description LeetCode 218, Level: Hard
 * 
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class LeetCode218_TheSkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        
        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        
        for(int[] building : buildings) {
            treeMap.putIfAbsent(building[0], new ArrayList<>());
            treeMap.get(building[0]).add(building);
            treeMap.putIfAbsent(building[1], new ArrayList<>());
            treeMap.get(building[1]).add(building);
        }
        
        for(int left : treeMap.keySet()) {
            List<int[]> bs = treeMap.get(left);
            
            for(int[] b : bs) {
                if(b[0] == left) {
                    maxHeap.offer(b);
                }
                else {
                    maxHeap.remove(b);
                }
            }
            
            if(maxHeap.size() == 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(0);
                res.add(temp);
            }
            else {
                int maxHeight = maxHeap.peek()[2];
                
                if(res.size() == 0 || res.get(res.size() - 1).get(1) != maxHeight) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(left);
                    temp.add(maxHeight);
                    res.add(temp);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        LeetCode218_TheSkylineProblem obj = new LeetCode218_TheSkylineProblem();
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        
        for(List<Integer> list : obj.getSkyline(buildings)) {
            System.out.println(list);
        }
    }

}

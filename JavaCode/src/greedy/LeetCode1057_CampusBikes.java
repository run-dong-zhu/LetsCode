package greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 1057, Level: Medium
 *
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. 
 * Each worker and bike is a 2D coordinate on this grid.
 * 
 * Our goal is to assign a bike to each worker. Among the available bikes and workers, 
 * we choose the (worker, bike) pair with the shortest Manhattan distance between each other, 
 * and assign the bike to that worker. (If there are multiple (worker, bike) pairs with the same 
 * shortest Manhattan distance, we choose the pair with the smallest worker index; 
 * if there are multiple ways to do that, we choose the pair with the smallest bike index). 
 * We repeat this process until there are no available workers.
 * 
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 * 
 * Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.
 * 
 * Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * Output: [1,0]
 * 
 * Explanation: 
 * Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
 */
public class LeetCode1057_CampusBikes {
	
	public int[] assignBikes(int[][] workers, int[][] bikes) {
		int n = workers.length;
		
		// order by Distance ASC, WorkerIndex ASC, BikeIndex ASC
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			int comp = Integer.compare(a[0], b[0]);
			if(comp == 0) {
				if(a[1] == b[1]) {
					return Integer.compare(a[2], b[2]);
				}
				
				return Integer.compare(a[1], b[1]);
			}
			
			return comp;
		});
		
		// loop through every possible pairs of bikes and people,
        // calculate their distance, and then throw it to the pq.
        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                int dist = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
                pq.add(new int[]{dist, i, j}); 
            }
        }
        
        // init the result array with state of 'unvisited'.
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        // assign the bikes.
        Set<Integer> bikeAssigned = new HashSet<>();
        while (bikeAssigned.size() < n) {
            int[] workerAndBikePair = pq.poll();
            if (res[workerAndBikePair[1]] == -1 && !bikeAssigned.contains(workerAndBikePair[2])) {   
                res[workerAndBikePair[1]] = workerAndBikePair[2];
                bikeAssigned.add(workerAndBikePair[2]);
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		LeetCode1057_CampusBikes obj = new LeetCode1057_CampusBikes();

		int[][] workers = {{0, 0}, {2, 1}};
		int[][] bikes = {{1, 2}, {3, 3}};
		
		int[] res = obj.assignBikes(workers, bikes);
		
		for(int i : res) {
			System.out.println(i);
		}
	}

}

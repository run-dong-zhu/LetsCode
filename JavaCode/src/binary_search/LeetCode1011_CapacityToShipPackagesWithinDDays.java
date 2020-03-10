package binary_search;

public class LeetCode1011_CapacityToShipPackagesWithinDDays {
	
	public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        
        for(int w : weights) {
        	left = Math.max(left, w);
        	right += w;
        }
        
        while(left < right) {
        	int mid = (left + right) / 2;
        	int need = 1;
        	int cur = 0;

            for(int w: weights) {
                if(cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            
            if (need > D) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        return left;
    }

	public static void main(String[] args) {
		LeetCode1011_CapacityToShipPackagesWithinDDays obj = new LeetCode1011_CapacityToShipPackagesWithinDDays();
		
		int[] weights = {3, 2, 2, 4, 1, 4};
		int D = 3;
		
		System.out.println(obj.shipWithinDays(weights, D));
	}

}

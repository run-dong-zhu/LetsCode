package sorting_problems;

/**
 * 
 * @author run-dong-zhu
 * @description Heap Sort
 *
 * The i th round select the i th biggest element
 * 
 * Time Complexity:
 * BEST: O(nlogn)
 * AVG: O(nlogn)
 * WORST: O(nlogn)
 */
public class HeapSort {
    
    public void heapify(int[] nums, int len, int i) {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // if left child is larger than root
        if(left < len && nums[left] > nums[root]) {
            root = left;
        }
        
        // if right child is larger than root
        if(right < len && nums[right] > nums[root]) {
            root = right;
        }
        
        // if largest is not root
        if(root != i) {
            int temp = nums[i];
            nums[i] = nums[root];
            nums[root] = temp;
            
            heapify(nums, len, root);
        }
    }
    
    public void heapSort(int[] nums) {
        for(int i = (nums.length / 2) - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
        
        for(int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            
            heapify(nums, i, 0);
        }
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();

        int[] nums = {3, 5, 8, 7, 2};
        
        obj.heapSort(nums);
        
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }

}

package sorting_problems;
/**
 * 
 * @author run-dong-zhu
 * @description Quick Sort
 *
 * Time Complexity:
 * BEST: O(nlogn) -- pivot middle element 
 * AVG: O(nlogn)
 * WORST: O(n2) -- pivot biggest or smallest element
 */
public class QuickSort {
    
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        
        for(int j = low; j < high; j++) {
            if(nums[j] < pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        
        int temp = nums[i + 1];
        nums[i + 1] = pivot;
        nums[high] = temp;
        
        return i + 1;
    }
    
    public void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int pivot = partition(nums, low, high);
            // divide and conquer
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] nums = {3, 1, 5, 2, 7, 4};
        
        obj.quickSort(nums, 0, nums.length - 1);
        
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }

}

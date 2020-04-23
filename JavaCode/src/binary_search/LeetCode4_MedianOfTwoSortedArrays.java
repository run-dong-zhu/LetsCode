package binary_search;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 4, Level: Hard
 * 
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class LeetCode4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if(len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        if(len1 == 0) {
            return ((double)nums2[(len2 - 1) / 2] + (double)nums2[len2 / 2]) / 2;
        }
        
        int len = len1 + len2;
        int s1 = 0;
        int e1 = len1;
        int cut1 = 0;
        int cut2 = 0;
        
        while(s1 <= e1) {
            cut1 = (s1 + e1) / 2;
            cut2 = (len + 1) / 2 - cut1;
            double l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r1 = cut1 == len1 ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = cut2 == len2 ? Integer.MAX_VALUE : nums2[cut2];
            
            if(l1 > r2) {
                e1 = cut1 - 1;
            }
            else if(l2 > r1) {
                s1 = cut1 + 1;
            }
            else {
                if(len % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
                else {
                    return Math.max(l1, l2);
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        LeetCode4_MedianOfTwoSortedArrays obj = new LeetCode4_MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3, 5, 7, 12};
        int[] nums2 = {2, 4, 4, 6};
        
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }

}

package searching_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 1239, Level: Medium
 * 
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class LeetCode1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

//    public int maxLength(List<String> arr) {
//        List<Integer> dp = new ArrayList<>();
//        dp.add(0);
//        
//        int res = 0;
//        
//        for (String s : arr) {
//            int a = 0, dup = 0;
//            
//            for (char ch : s.toCharArray()) {
//                dup |= a & (1 << (ch - 'a'));
//                a |= 1 << (ch - 'a');
//            }
//            
//            if (dup > 0) continue;
//            
//            for (int i = dp.size() - 1; i >= 0; --i) {
//                if ((dp.get(i) & a) > 0) continue;
//                dp.add(dp.get(i) | a);
//                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
//            }
//        }
//        return res;
//    }
    
    private int max = 0;
    
    public int maxLength(List<String> arr) {
        dfs(arr, 0, "");
        return max;
    }

    public void dfs(List<String> arr, int index, String concatenatStr) {
        if(isUnique(concatenatStr)) {
            max = Math.max(max, concatenatStr.length());
        }
        
        if(index == arr.size() || !isUnique(concatenatStr)) {
            return;
        }
        
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, i + 1, concatenatStr + arr.get(i));
        }
    }
    
    public boolean isUnique(String s) {
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) alpha[s.charAt(i) - 'a']++;
        for (int i = 0; i < alpha.length; i++) if (alpha[i] > 1) return false;
        return true;
    }
    
    public static void main(String[] args) {
        LeetCode1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters obj = 
                new LeetCode1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
        
        List<String> arr = Arrays.asList("un","iq","ue");

        System.out.println(obj.maxLength(arr));
    }

}

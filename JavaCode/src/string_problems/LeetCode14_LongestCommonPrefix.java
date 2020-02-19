package string_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 14, Level: Easy
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 */
public class LeetCode14_LongestCommonPrefix {
    // Horizontal Scanning
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }

    // Vertical Scanning
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        
//        for (int i = 0; i < strs[0].length() ; i++){
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j ++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != c)
//                    return strs[0].substring(0, i);             
//            }
//        }
//        return strs[0];
//    }
    
    public static void main(String[] args) {
        LeetCode14_LongestCommonPrefix obj = new LeetCode14_LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(obj.longestCommonPrefix(strs));
    }
}

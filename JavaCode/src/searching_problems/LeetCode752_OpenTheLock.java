package searching_problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 752, Level: Medium
 * 
 * https://leetcode.com/problems/open-the-lock/
 */
public class LeetCode752_OpenTheLock {

    public int openLock(String[] deadends, String target) {
        int steps = 0;

        Set<String> dead = new HashSet<>();
        
        for(String deadend : deadends) {
            dead.add(deadend);
        }
        
        Set<String> begin = new HashSet<>();
        begin.add("0000");
        
        Set<String> end = new HashSet<>();
        end.add(target);

        Set<String> temp = new HashSet<>();
        
        while(!begin.isEmpty() && !end.isEmpty()) {
            if(begin.size() > end.size()) {
                temp = begin;
                begin = end;
                end = temp;
            }
            
            temp = new HashSet<>();
            
            for(String s : begin) {
                if(end.contains(s)) {
                    return steps;
                }
                if(dead.contains(s)) {
                    continue;
                }
                dead.add(s);
                
                StringBuilder sb = new StringBuilder(s);
                
                for(int i = 0; i < 4; i++) {
                    char ch = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + sb.substring(i + 1);
                    
                    if(!dead.contains(s1)) {
                        temp.add(s1);
                    }
                    
                    if(!dead.contains(s2)) {
                        temp.add(s2);
                    }
                }
            }
            
            steps++;
            begin = temp;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        LeetCode752_OpenTheLock obj = new LeetCode752_OpenTheLock();
        
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        
        System.out.println(obj.openLock(deadends, target));
    }
}

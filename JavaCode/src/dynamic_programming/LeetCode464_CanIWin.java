package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 464, Level: Medium
 * 
 * 
 */
public class LeetCode464_CanIWin {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger <= 0) {
            return true;
        }
        
        if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        
        int[] state = new int[maxChoosableInteger];
        Map<String, Boolean> map = new HashMap<>();
        
        return canIWin(desiredTotal, state, map);
    }
    
    private boolean canIWin(int total, int[] state, Map<String, Boolean> map) {
        String curr = Arrays.toString(state);
        
        if(map.containsKey(curr)) {
            return map.get(curr);
        }
        
        for(int i = 0; i < state.length; i++) {
            if(state[i] == 0) {
                state[i] = 1;
                if(total <= i + 1 || !canIWin(total - (i + 1), state, map)) {
                    map.put(curr, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        
        map.put(curr, false);
        
        return false;
    }
    
    public static void main(String[] args) {
        LeetCode464_CanIWin obj = new LeetCode464_CanIWin();

        int maxChoosableInteger = 5;
        int desiredTotal = 11;
        
        System.out.println(obj.canIWin(maxChoosableInteger, desiredTotal));
    }

}

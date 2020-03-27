package searching_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 721, Level: Medium
 * 
 * https://leetcode.com/problems/accounts-merge/
 */
public class LeetCode721_AccountsMerge {
    
    private void dfs(Set<String> visited, Map<String, Set<String>> e2e, List<String> list, String email) {
        if(!e2e.containsKey(email) || e2e.get(email).size() == 0) {
            return;
        }
        
        for(String neighbor : e2e.get(email)) {
            if(visited.add(neighbor)) {
                list.add(neighbor);
                dfs(visited, e2e, list, neighbor);
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        
        Map<String, String> e2n = new HashMap<>();
        Map<String, Set<String>> e2e = new HashMap<>();
        
        // build graph
        for(List<String> account : accounts) {
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                e2n.put(email, name);
                e2e.putIfAbsent(email, new HashSet<>());
                
                if(i == 1) 
                    continue;
                
                String prev = account.get(i - 1);
                e2e.get(prev).add(email);
                e2e.get(email).add(prev);
            }
        }
        
        Set<String> visited = new HashSet<>();
        
        for(String email : e2n.keySet()) {
            if(visited.add(email)) {
                List<String> list = new ArrayList<>();
                list.add(email);
                dfs(visited, e2e, list, email);
                Collections.sort(list);
                list.add(0, e2n.get(email));
                res.add(list);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        LeetCode721_AccountsMerge obj = new LeetCode721_AccountsMerge();
        
        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        
        for(List<String> account : obj.accountsMerge(accounts)) {
            System.out.println(account);
        }
    }

}

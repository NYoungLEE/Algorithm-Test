import java.util.*;

class Solution {
    
    public static List<List<String>> candidates;
    public static Set<String> visited;
    public static Set<Set<String>> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        candidates = new ArrayList<>();
        for (String banned : banned_id) {
            List<String> list = new ArrayList<>();
            
            for (String user : user_id) {
                if (match(user, banned)) list.add(user);
            }
            candidates.add(list);
        }
        
        visited = new HashSet<>();
        result = new HashSet<>();
        dfs(0, banned_id.length);
        
        return result.size();
    }
    
    private void dfs(int depth, int target) {
        
        if (depth == target) {
            result.add(new HashSet<>(visited));
            return;
        }
        
        for (String user : candidates.get(depth)) {
            if (visited.contains(user)) continue;
            visited.add(user);
            dfs(depth + 1, target);
            visited.remove(user);
        }
    }
    
    private boolean match(String user, String banned) {
        if (user.length() != banned.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        
        return true;
    }
}
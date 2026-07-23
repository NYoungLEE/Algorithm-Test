import java.util.*;

class Solution {
    
    public List<Integer> pick;
    public int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        
        pick = new ArrayList<>();
        
        dfs(n, q, ans, 1, 0);
            
        return answer;
        
    }
    
    private void dfs(int n, int[][] q, int[] ans, int start, int depth) {
        
        if (depth == 5) {
            if (check(q, ans)) answer++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            pick.add(i);
            dfs(n, q, ans, i + 1, depth + 1);
            pick.remove(pick.size() - 1);
        }
    }
    
    private boolean check (int[][] q, int[] ans) {
        
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            
            for (int x : pick) {
                for (int y : q[i]) {
                    if (x == y) cnt++;
                }
            }
            
            if (cnt != ans[i]) return false;
        }
        
        return true;
    }
}
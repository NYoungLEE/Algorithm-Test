import java.util.*;

class Solution {
    
    public List<Integer>[] tree;
    public int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        
        tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        dfs(0, 0, 0, candidates, info);
        
        return answer;
    }
    
    private void dfs(int cur, int sheep, int wolf, List<Integer> candidates, int[] info) {

        if (info[cur] == 0) sheep++;
        else wolf++;
        
        if (wolf >= sheep) return;
        
        answer = Math.max(answer, sheep);
 
        List<Integer> next = new ArrayList<>(candidates);
        next.remove(Integer.valueOf(cur));
        next.addAll(tree[cur]);
        
        for (int n : next) {
            dfs(n, sheep, wolf, next, info);
        }
        
    }
}
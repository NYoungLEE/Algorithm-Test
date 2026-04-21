import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            boolean[] visited = new boolean[n + 1];
            
            int count = dfs(a, a, b, visited);
            int diff = n - count;
            
            answer = Math.min(answer, Math.abs(count - diff));
        }
        
        return answer;
    }
    
    private static int dfs(int cur, int a, int b, boolean[] visited) {
        visited[cur] = true;
        int count = 1;
        
        for (int next : graph[cur]) {
            if ((cur == a && next == b) || (cur == b && next == a)) continue;
            
            if (!visited[next]) {
                count += dfs(next, a, b, visited);
            }
        }
        
        return count;
    }
}
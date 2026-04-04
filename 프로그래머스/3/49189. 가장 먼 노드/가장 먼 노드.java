import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static int[] dist;
    
    public int solution(int n, int[][] edge) {

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        bfs(1);
        
        int max = 0;
        for (int d : dist) max = Math.max(max, d);
        
        int answer = 0;
        for (int d : dist) {
            if (d == max) answer++;
        }
        return answer;
    }
    
    private void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        dist[num] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
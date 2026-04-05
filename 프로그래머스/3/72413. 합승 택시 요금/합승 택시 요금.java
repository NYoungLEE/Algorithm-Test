import java.util.*;

class Solution {
    
    static List<Node>[] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < fares.length; i++) {
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int cost = fares[i][2];
            
            graph[v1].add(new Node(v2, cost));
            graph[v2].add(new Node(v1, cost));
        }
        
        int[] dist1 = dijkstra(s, n);
        int[] dist2 = dijkstra(a, n);
        int[] dist3 = dijkstra(b, n);
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dist1[i] + dist2[i] + dist3[i]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dist[now.v] < now.cost) continue;
            
            for (Node next : graph[now.v]) {
                int newCost = now.cost + next.cost;
                
                if (dist[next.v] > newCost) {
                    dist[next.v] = newCost;
                    pq.offer(new Node(next.v, newCost));
                }
            }
        }
        
        return dist;
    }
    
    public static class Node implements Comparable<Node> {
        int v;
        int cost;
        
        public Node (int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
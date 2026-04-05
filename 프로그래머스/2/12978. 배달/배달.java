import java.util.*;

class Solution {
    
    static List<Node>[] graph;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < road.length; i++) {
            int e1 = road[i][0];
            int e2 = road[i][1];
            int cost = road[i][2];
            
            graph[e1].add(new Node(e2, cost));
            graph[e2].add(new Node(e1, cost));
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dijkstra(1);
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
    
    private void dijkstra(int num) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(num, 0));
        dist[num] = 0;
        
        while(!pq.isEmpty()) {
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
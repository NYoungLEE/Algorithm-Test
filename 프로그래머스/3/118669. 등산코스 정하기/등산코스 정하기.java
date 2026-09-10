import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 정점 그래프
        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        // 무방향 간선 추가
        for (int[] p : paths) {
            graph[p[0]].add(new Edge(p[1], p[2]));
            graph[p[1]].add(new Edge(p[0], p[2]));
        }

        // 산봉우리 집합 (O(1) 체크용)
        Set<Integer> summitSet = new HashSet<>();
        for (int s : summits) summitSet.add(s);

        // intensity 배열: 각 정점까지의 현재 최소 intensity
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        // PQ: 현재 intensity 기준 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 출입구들 시작점으로 설정
        for (int g : gates) {
            intensity[g] = 0;
            pq.add(new Node(g, 0));
        }

        // 다익스트라 변형
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 현재 값이 저장된 intensity보다 크면 skip
            if (curr.intensity > intensity[curr.node]) continue;

            // 산봉우리까지의 경로만 탐색 → 봉우리에서 넘어가지 않음
            if (summitSet.contains(curr.node)) continue;

            // 인접 노드 탐색
            for (Edge e : graph[curr.node]) {
                int next = e.to;
                int cost = e.time;

                // 다음 intensity = 현재 intensity 와 edge weight 중 큰 값
                int newIntensity = Math.max(curr.intensity, cost);

                if (newIntensity < intensity[next]) {
                    intensity[next] = newIntensity;
                    pq.add(new Node(next, newIntensity));
                }
            }
        }

        // 결과: intensity 가장 작은 산봉우리 + 값
        Arrays.sort(summits);
        int bestSummit = 0;
        int bestValue = Integer.MAX_VALUE;

        for (int s : summits) {
            if (intensity[s] < bestValue) {
                bestValue = intensity[s];
                bestSummit = s;
            }
        }

        return new int[]{bestSummit, bestValue};
    }

    static class Edge {
        int to, time;
        Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static class Node implements Comparable<Node> {
        int node, intensity;
        Node(int node, int intensity) {
            this.node = node;
            this.intensity = intensity;
        }
        @Override
        public int compareTo(Node o) {
            return this.intensity - o.intensity;
        }
    }
}
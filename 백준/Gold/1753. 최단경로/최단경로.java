import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int[] distance;
  static boolean[] visited;
  static ArrayList<Edge>[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken()); // 노드 개수
    int E = Integer.parseInt(st.nextToken()); // 에지 개수
    int K = Integer.parseInt(br.readLine());  // 출발 노드
    distance = new int[V + 1];
    visited = new boolean[V + 1];
    list = new ArrayList[V + 1];
    for (int i = 0; i <= V; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    for (int i = 1; i <= V; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      list[u].add(new Edge(v, w));
    }
    dijkstra(K);
    for (int i = 1; i <= V; i++) {
      if (visited[i]) {
        System.out.println(distance[i]);
      } else {
        System.out.println("INF");
      }
    }
  }

  private static void dijkstra(int start) {
    PriorityQueue<Edge> queue = new PriorityQueue<>();
    queue.add(new Edge(start, 0));
    distance[start] = 0;
    while (!queue.isEmpty()) {
      Edge now = queue.poll();
      int vertex = now.vertex;
      if (visited[vertex]) continue;
      visited[vertex] = true;
      for (int i = 0; i < list[vertex].size(); i++) {
        Edge tmp = list[vertex].get(i);
        int next = tmp.vertex;
        int value = tmp.value;
        if (distance[vertex] + value < distance[next]) {
          distance[next] = distance[vertex] + value;
          queue.add(new Edge(next, distance[next]));
        }
      }
    }
  }
}

class Edge implements Comparable<Edge> {
  int vertex;
  int value;

  public Edge(int vertex, int value) {
    this.vertex = vertex;
    this.value = value;
  }

  public int compareTo(Edge e) {
    return this.value - e.value;
  }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int[] distance;
  static boolean[] visited;
  static ArrayList<Node>[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 도시 개수
    int M = Integer.parseInt(br.readLine());  // 버스 개수
    distance = new int[N + 1];
    visited = new boolean[N + 1];
    list = new ArrayList[N + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);
    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      list[u].add(new Node(v, w));
    }
    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());
    dijkstra(start);
    System.out.println(distance[end]);
  }

  private static void dijkstra(int start) {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.add(new Node(start, 0));
    distance[start] = 0;
    while (!queue.isEmpty()) {
      Node now = queue.poll();
      int vertex = now.end;
      if (visited[vertex]) continue;
      visited[vertex] = true;
      for (int i = 0; i < list[vertex].size(); i++) {
        Node tmp = list[vertex].get(i);
        int next = tmp.end;
        int value = tmp.value;
        if (distance[vertex] + value < distance[next]) {
          distance[next] = distance[vertex] + value;
          queue.add(new Node(next, distance[next]));
        }
      }
    }
  }
}

class Node implements Comparable<Node> {
  int end;
  int value;

  public Node(int end, int value) {
    this.end = end;
    this.value = value;
  }

  @Override
  public int compareTo(Node n) {
    return this.value - n.value;
  }

}

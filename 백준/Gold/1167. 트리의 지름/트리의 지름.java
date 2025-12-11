import java.io.*;
import java.util.*;

public class Main {

  static ArrayList<Edge>[] A;
  static boolean[] visited;
  static int[] distance;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 노드 개수

    A = new ArrayList[N + 1];
    for (int i = 1; i < N + 1; i++) {
      A[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      while (true) {
        int E = Integer.parseInt(st.nextToken());
        if (E == -1) break;
        int V = Integer.parseInt(st.nextToken());
        A[S].add(new Edge(E, V));
      }
    }

    visited = new boolean[N + 1];
    distance = new int[N + 1];
    BFS(1);

    int max = 1;
    for (int i = 2; i <= N; i++) {
      if (distance[max] < distance[i]) max = i;
    }

    visited = new boolean[N + 1];
    distance = new int[N + 1];
    BFS(max);

    Arrays.sort(distance);
    System.out.println(distance[N]);
  }

  private static void BFS(int node) {
    Queue<Integer> queue = new LinkedList<>();
    visited[node] = true;
    queue.add(node);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (Edge i : A[now]) {
        int e = i.e;
        int v = i.value;

        if (!visited[e]) {
          visited[e] = true;
          queue.add(e);
          distance[e] = distance[now] + v;
        }
      }
    }
  }
}

class Edge {
  int e;
  int value;

  public Edge(int e, int value) {
    this.e = e;
    this.value = value;
  }
}

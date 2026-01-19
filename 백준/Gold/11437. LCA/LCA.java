import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Integer>[] tree;
  static boolean[] visited;
  static int[] depth;
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 노드 개수
    tree = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      tree[s].add(e);
      tree[e].add(s);
    }
    visited = new boolean[N + 1];
    depth = new int[N + 1];
    parent = new int[N + 1];
    BFS(1);
    int M = Integer.parseInt(br.readLine());  // 질의 개수
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int LCA = findLCA(a, b);
      System.out.println(LCA);
    }
  }

  private static void BFS(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    visited[node] = true;
    int level = 1;
    int now_size = 1;
    int count = 0;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int next : tree[now]) {
        if (!visited[next]) {
          queue.add(next);
          visited[next] = true;
          parent[next] = now;
          depth[next] = level;
        }
      }
      count++;
      if (count == now_size) {
        count = 0;
        now_size = queue.size();
        level++;
      }
    }
  }

  private static int findLCA(int a, int b) {
    if (depth[a] < depth[b]) {
      int temp = a;
      a = b;
      b = temp;
    }
    while (depth[a] != depth[b]) {
      a = parent[a];
    }
    while (a != b) {
      a = parent[a];
      b = parent[b];
    }
    return a;
  }
}

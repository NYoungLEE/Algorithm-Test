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
  static int[][] parent;
  static int kmax;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 수의 개수
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
    int temp = 1;
    kmax = 0;
    while (temp <= N) {
      temp <<= 1;
      kmax++;
    }
    parent = new int[kmax + 1][N + 1];
    BFS(1);
    for (int k = 1; k <= kmax; k++) {
      for (int n = 1; n <= N; n++) {
        parent[k][n] = parent[k - 1][parent[k - 1][n]];
      }
    }
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
          parent[0][next] = now;
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
    if (depth[a] > depth[b]) {
      int temp = a;
      a = b;
      b = temp;
    }
    for (int k = kmax; k >= 0; k--) {
      if (depth[b] - depth[a] >= Math.pow(2, k)) {
        if (depth[a] <= depth[parent[k][b]]) {
          b = parent[k][b];
        }
      }
    }
    for (int k = kmax; k >= 0; k--) {
      if (parent[k][a] != parent[k][b]) {
        a = parent[k][a];
        b = parent[k][b];
      }
    }
    int LCA = a;
    if (a != b) {
      LCA = parent[0][LCA];
    }
    return LCA;
  }
}

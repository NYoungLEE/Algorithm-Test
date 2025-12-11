import java.util.*;

public class Main {

  static int[] dist;
  static boolean[] visited;
  static int N, K;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    N = sc.nextInt(); // 수빈의 위치
    K = sc.nextInt(); // 동생의 위치

    dist = new int[100001];
    visited = new boolean[100001];
    BFS(N);

    System.out.println(dist[K]);
  }

  private static void BFS(int node) {
    Queue<Integer> queue = new LinkedList<>();
    visited[node] = true;
    queue.add(node);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      if (now == K) return;

      int[] next = {now - 1, now + 1, now * 2};
      for (int nx : next) {
        if (nx >= 0 && nx <= 100000 && !visited[nx]) {
          visited[nx] = true;
          dist[nx] = dist[now] + 1;
          queue.add(nx);
        }
      }
    }
  }
}
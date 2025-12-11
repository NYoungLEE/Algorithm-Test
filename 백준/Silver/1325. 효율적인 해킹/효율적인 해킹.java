import java.io.*;
import java.util.*;

public class Main {

  static ArrayList<Integer>[] A;
  static boolean[] visited;
  static int[] distance;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
    int M = Integer.parseInt(st.nextToken()); // 관계 개수

    distance = new int[N + 1];
    A = new ArrayList[N + 1];
    for (int i = 1; i < N + 1; i++) {
      A[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int S =  Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      A[E].add(S);
    }

    for (int i = 1; i < N + 1; i++) {
      visited = new boolean[N + 1];
      BFS(i);
    }

    int maxCount = 1;
    for (int i = 1; i < N + 1; i++) {
      if (maxCount < distance[i]) maxCount = distance[i];
    }

    for (int i = 1; i < N + 1; i++) {
      if (distance[i] == maxCount) System.out.print(i + " ");
    }
  }

  private static void BFS(int node) {
    Queue<Integer> queue = new LinkedList<>();
    visited[node] = true;
    queue.add(node);

    int count = 0;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int i : A[now]) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
          count++;
        }
      }
    }

    distance[node] = count;
  }
}
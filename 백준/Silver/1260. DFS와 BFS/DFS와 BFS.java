import java.io.*;
import java.util.*;

public class Main {

  static ArrayList<Integer>[] A;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 노드 개수
    int M = Integer.parseInt(st.nextToken()); // 에지 개수
    int V = Integer.parseInt(st.nextToken()); // 시작점

    A = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      A[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      A[S].add(E);
      A[E].add(S);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(A[i]);
    }
    visited = new boolean[N + 1];
    DFS(V);
    System.out.println();
    visited = new boolean[N + 1];
    BFS(V);
  }

  public static void DFS(int node) {
    System.out.print(node + " ");
    visited[node] = true;

    for (int i : A[node]) {
      if (!visited[i]) {
        DFS(i);
      }
    }
  }

  public static void BFS(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    visited[node] = true;

    while (!queue.isEmpty()) {
      int newNode = queue.poll();
      System.out.print(newNode + " ");

      for (int i : A[newNode]) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static ArrayList<Integer>[] tree;
  static boolean[] visited;
  static int[] answer;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 노드 개수
    tree = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    answer = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 1; i < N; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      tree[a].add(b);
      tree[b].add(a);
    }
    DFS(1);
    for (int i = 2; i <= N; i++) {
      System.out.println(answer[i]);
    }
  }

  private static void DFS(int node) {
    visited[node] = true;
    for (int next : tree[node]) {
      if (!visited[next]) {
        answer[next] = node;
        DFS(next);
      }
    }
  }
}
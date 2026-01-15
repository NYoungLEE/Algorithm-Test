import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static ArrayList<Integer>[] tree;
  static boolean[] visited;
  static int answer, deleteNode;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 노드 개수
    tree = new ArrayList[N];
    visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      tree[i] = new ArrayList<>();
    }
    int root = 0;
    for (int i = 0; i < N; i++) {
      int num = sc.nextInt();
      if (num != -1) {
        tree[i].add(num);
        tree[num].add(i);
      } else {
        root = i;
      }
    }
    deleteNode = sc.nextInt(); // 삭제 노드
    if (deleteNode == root)
      System.out.println(0);
    else {
      DFS(root);
      System.out.println(answer);
    }
  }

  private static void DFS(int node) {
    visited[node] = true;
    int cNode = 0;
    for (int next : tree[node]) {
      if (!visited[next] && next != deleteNode) {
        cNode++;
        DFS(next);
      }
    }
    if (cNode == 0) {
      answer++;
    }
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static ArrayList<Integer>[] A;
  static boolean[] visited;
  static int[] check;
  static boolean IsEven;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());  // 테스트 개수
    for (int t = 0; t < T; t++) {
      String[] s = br.readLine().split(" ");
      int V = Integer.parseInt(s[0]); // 노드 개수
      int E = Integer.parseInt(s[1]); // 에지 개수
      A = new ArrayList[V + 1];
      visited = new boolean[V + 1];
      check = new int[V + 1];
      IsEven = true;
      for (int i = 1; i <= V; i++) {
        A[i] = new ArrayList<>();
      }
      for (int i = 0; i < E; i++) {
        s = br.readLine().split(" ");
        int u = Integer.parseInt(s[0]);
        int v = Integer.parseInt(s[1]);
        A[u].add(v);
        A[v].add(u);
      }
      for (int i = 1; i <= V; i++) {
        if (IsEven) {
          DFS(i);
        } else {
          break;
        }
      }

      if (IsEven) System.out.println("YES");
      else System.out.println("NO");
    }
  }

  private static void DFS(int node) {
    visited[node] = true;
    for (int i : A[node]) {
      if (!visited[i]) {
        check[i] = (check[node] + 1) % 2;
        DFS(i);
      } else if (check[i] == check[node]) {
        IsEven = false;
      }
    }
  }
}

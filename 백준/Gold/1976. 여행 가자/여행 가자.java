import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine()); // 도시 개수
    int M = Integer.parseInt(br.readLine()); // 여행 경로 데이터
    int[][] dosi = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        dosi[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[] route = new int[M + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= M; i++) {
      route[i] = Integer.parseInt(st.nextToken());
    }
    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (dosi[i][j] == 1) {
          union(i, j);
        }
      }
    }

    int index = find(route[1]);
    for (int i = 1; i <= M; i++) {
      if (find(route[i]) != index) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  private static int find(int a) {
    if (a == parent[a]) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 도시 개수
    int M = Integer.parseInt(br.readLine());  // 노선 개수
    int[][] distance = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (i == j) distance[i][j] = 0;
        else distance[i][j] = Integer.MAX_VALUE;
      }
    }
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());
      if (distance[S][E] > W) distance[S][E] = W;
    }
    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) continue;
          distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
        }
      }
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (distance[i][j] == Integer.MAX_VALUE) System.out.print("0 ");
        else System.out.print(distance[i][j] + " ");
      }
      System.out.println();
    }
  }
}

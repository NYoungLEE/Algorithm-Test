import java.util.*;
import java.io.*;

public class Main {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static int[][] map;
  static boolean[][] visited;
  static int M, N, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(st.nextToken()); // 테스트케이스 개수
    int count = 0;
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken()); // 가로 길이
      N = Integer.parseInt(st.nextToken()); // 세로 길이
      K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

      map = new int[N][M];
      visited = new boolean[N][M];

      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        map[X][Y] = 1;
      }

      count = 0;
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
          if (map[j][k] == 1 && !visited[j][k]) {
            count++;
            DFS(j, k);
          }
        }
      }
      sb.append(count).append("\n");
    }

    System.out.print(sb);
  }

  public static void DFS(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1) {
        if (!visited[nx][ny]) {
          DFS(nx, ny);
        }
      }
    }
  }

}
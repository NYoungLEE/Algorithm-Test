import java.io.*;
import java.util.*;

public class Main {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static int[][] map;
  static boolean[][] visited;
  static int N, count, height;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 행/열의 개수

    map = new int[N][N];
    int maxHeight = 1;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        maxHeight = Math.max(maxHeight, map[i][j]);
      }
    }

    int answer = 0;
    for (height = 0; height <= maxHeight; height++) {
      visited = new boolean[N][N];
      count = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j] && height < map[i][j]) {
            DFS(i, j);
            count++;
          }
        }
      }
      answer = Math.max(answer, count);
    }

    System.out.println(answer);
  }

  public static void DFS(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < N && ny >= 0 && ny < N){
        if (!visited[nx][ny] && height < map[nx][ny]) {
          DFS(nx, ny);
        }
      }
    }
  }
}
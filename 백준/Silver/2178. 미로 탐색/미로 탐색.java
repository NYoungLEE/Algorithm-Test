import java.io.*;
import java.util.*;

public class Main {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static int[][] map;
  static boolean[][] visited;
  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 행
    M = Integer.parseInt(st.nextToken()); // 열

    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    BFS(0, 0);
    System.out.println(map[N - 1][M - 1]);
  }

  public static void BFS(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if (!visited[nx][ny] && map[nx][ny] != 0) {
            visited[nx][ny] = true;
            map[nx][ny] = map[now[0]][now[1]] + 1;
            queue.add(new int[] {nx, ny});
          }
        }
      }
    }
  }
}
import java.io.*;
import java.util.*;

public class Main {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static char[][] map;
  static boolean[] used;
  static int R, C, depth;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken()); // 행의 개수
    C = Integer.parseInt(st.nextToken()); // 열의 개수

    map = new char[R][C];
    used = new boolean[26];

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    depth = 1;
    DFS(0, 0, depth);

    System.out.println(depth);
  }

  public static void DFS(int x, int y, int dep) {
    used[map[x][y] - 'A'] = true;

    depth = Math.max(depth, dep);

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
        int next = map[nx][ny] - 'A';
        if (!used[next]) {
          used[next] = true;
          DFS(nx, ny, dep + 1);
          used[next] = false;
        }
      }
    }
  }
}